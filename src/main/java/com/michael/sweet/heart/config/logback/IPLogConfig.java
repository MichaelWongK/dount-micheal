package com.michael.sweet.heart.config.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * 在logback日志中显示服务器IP信息,实现多服务集群负载时的问题定位
 *
 * @author Arnold.zhao <a href="mailto:13949123615@163.com"/>
 * @create 2019-04-13
 */
public class IPLogConfig extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "0.0.0.0";
        }
    }
}
