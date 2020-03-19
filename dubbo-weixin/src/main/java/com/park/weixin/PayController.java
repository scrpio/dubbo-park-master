package com.park.weixin;

import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.common.util.ToolUtil;
import com.park.common.wxpay.sdk.MyConfig;
import com.park.common.wxpay.sdk.WXPay;
import com.park.common.wxpay.sdk.WXPayUtil;
import com.park.pojo.OrderInfo;
import com.park.common.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PayController {
    private Logger logger = LoggerFactory.getLogger(PayController.class);

    @SystemLog(value = "支付操作")
    @PostMapping("/api/wxPay")
    public Result<Object> wxPay(@RequestBody OrderInfo orderInfo) throws Exception {
        MyConfig config = new MyConfig();

        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<>();
        data.put("appid", config.getAppID());
        data.put("mch_id", config.getMchID());
        data.put("body", orderInfo.getBody());
        data.put("out_trade_no", orderInfo.getOut_trade_no() == "" ? ToolUtil.getRandomNumber() : orderInfo.getOut_trade_no());
        data.put("total_fee", orderInfo.getTotal_fee());
        data.put("spbill_create_ip", "127.0.0.1");
        data.put("notify_url", "http://localhost:7777/api/wxPay/payResult");
        data.put("trade_type", "JSAPI");
        data.put("openid", orderInfo.getOpenid());

        String sign = WXPayUtil.generateSignature(data, config.getKey());
        data.put("sign", sign);

        Map<String, String> resp = wxpay.unifiedOrder(data);
        logger.info("-------下单:" + resp.toString());
        if ("SUCCESS".equals(resp.get("return_code"))) {
            //再次签名
            Map<String, String> reData = new HashMap<>();
            reData.put("appId", config.getAppID());
            reData.put("nonceStr", resp.get("nonce_str"));
            String newPackage = "prepay_id=" + resp.get("prepay_id");
            reData.put("package", newPackage);
            reData.put("signType", "MD5");
            reData.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));

            String newSign = WXPayUtil.generateSignature(reData, config.getKey());
            resp.put("paySign", newSign);
            resp.put("timeStamp", reData.get("timeStamp"));
            logger.info("-------签名:" + resp.toString());
            return new ResultUtil<Object>().setData(resp);
        } else {
            return new ResultUtil<Object>().setErrorMsg(resp.get("return_msg"));
        }
    }

    @GetMapping(value = "/api/wxPay/payResult")
    public void payResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqParams = read(request.getInputStream());
        logger.info("-------支付结果:" + reqParams);
        StringBuffer sb = new StringBuffer("<xml><return_code>SUCCESS</return_code><return_msg>OK</return_msg></xml>");
        response.getWriter().append(sb.toString());
    }

    private String read(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[512];
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            return new String(baos.toByteArray(), 0, baos.size(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
