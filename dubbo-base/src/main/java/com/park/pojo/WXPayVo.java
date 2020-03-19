package com.park.pojo;

public class WXPayVo {
    private String notifyUrl;
    private String appId;// 小程序ID
    private String mchId;// 商户号
    private String nonceStr;// 随机字符串
    private String signType;//签名类型
    private String sign;// 签名
    private String body;// 商品描述
    private String outTradeNo;// 商户订单号
    private int TotalFee;// 标价金额 ,单位为分
    private String spbill_create_ip;// 终端IP
    private String notify_url;// 通知地址
    private String trade_type;// 交易类型
    private String openId;//用户标识

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

}
