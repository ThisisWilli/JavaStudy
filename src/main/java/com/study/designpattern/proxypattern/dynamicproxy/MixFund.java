package com.study.designpattern.proxypattern.dynamicproxy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-20 19:31
 **/

public class MixFund implements MixTranscation {
    @Override
    public void sell() {
        System.out.println("抛售混合型基金");
    }

    @Override
    public void buy() {
        System.out.println("购买混合型基金");
    }
}
