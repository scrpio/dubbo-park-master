package com.park.common.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

public class ToolUtil {

    public static void main(String[] args) {
        System.out.println(getRandomId());
    }

    /**
     * Util工具类方法
     * 获取真实的ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();

    }

    public static String getRandomId() {
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        return str;
    }

    /**
     * 获取随机位数的字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 短信验证码
     *
     * @return
     */
    public static String getRandomNumber() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 时间戳转日期格式
     *
     * @param timeStmp
     * @return
     */
    public static String getDateFormat(long timeStmp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date(timeStmp));
    }

    public static <T> List<T> newLinkedList(T... values) {
        return (LinkedList) list(true, values);
    }

    public static <T> List<T> list(boolean isLinked, T... values) {
        if (isEmpty(values)) {
            return list(isLinked);
        } else {
            List<T> arrayList = isLinked ? new LinkedList() : new ArrayList(values.length);
            Object[] arr$ = values;
            int len$ = values.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                T t = (T) arr$[i$];
                (arrayList).add(t);
            }

            return arrayList;
        }
    }

    public static <T> boolean isEmpty(T... array) {
        return array == null || array.length == 0;
    }
}
