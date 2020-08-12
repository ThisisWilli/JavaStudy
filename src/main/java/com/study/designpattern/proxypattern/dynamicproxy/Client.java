package com.study.designpattern.proxypattern.dynamicproxy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-20 14:05
 **/

public class Client {
//    public static void main(String[] args) {
//        // 代理角色
//        // 代理角色：现在没有
//        ProxyInvocationHandler pih = new ProxyInvocationHandler();
//        // 通过调用程序处理橘色来处理我们要调用的接口对象
//        // 动态生成代理
//        pih.setTarget(new StackFund());
//        StackTranscation proxy = (StackTranscation)pih.getProxy();
//        proxy.buy();
//        proxy.sell();
//
//        pih.setTarget(new MixFund());
//        MixTranscation mixProxy = (MixTranscation)pih.getProxy();
//        mixProxy.buy();
//        mixProxy.sell();
//    }
    public static void main(String[] args) {
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(new StackTranscation() {
            @Override
            public void sell() {
                System.out.println("买股票");
            }

            @Override
            public void buy() {
                System.out.println("卖股票");
            }
        });

        StackTranscation proxy = (StackTranscation)pih.getProxy();
        proxy.buy();
    }
}
