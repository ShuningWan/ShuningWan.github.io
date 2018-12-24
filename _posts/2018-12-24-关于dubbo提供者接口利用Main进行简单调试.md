---
layout:     post
title:      关于dubbo提供者接口利用Main进行简单调试
date:       2018-12-24
author:     Shuning Wan
header-img: img/post-bg-coffee.jpeg
catalog: true
tags:
    - Java
    - Dubbo
---
```java
/**
 * @author Shuning Wan
 * @version 1.0
 * @date 2018/12/24
 */
public class NganluongPayout {

    static ApplicationConfig ac = null;
    static RegistryConfig rc = null;

    static{
        try{
            ac = new ApplicationConfig();
            ac.setName("global-common-upstream-service");//应用名字
            rc  = new RegistryConfig();
            rc.setAddress("zookeeper://192.168.1.19:2181");//zookeeper注册中心地址
            rc.setProtocol("zookeeper");//协议
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static <T> T getProvider(Class<T> c,String group){
        ReferenceConfig<T> rcc = new ReferenceConfig<T>();
        rcc.setTimeout(50000);
        rcc.setRegistry(rc);
        rcc.setApplication(ac);
        rcc.setCheck(false);
        rcc.setInterface(c);
        rcc.setGroup(group);
        return  rcc.get();
    }


    public static void test(){
        EnquiryTransactionStatusInput param = new EnquiryTransactionStatusInput();
        param.setTransNo("2222222");
        param.setTradeNo("0000000000");
        UpstreamPayoutService esop = getProvider(UpstreamPayoutService.class, "");
        esop.enquiryTransactionStatus(param);
        System.out.println("invoke success");
    }


    public static void main(String[] args) {
        test();//执行测试
    }
}
```



