package com.study.designpattern.proxypattern.dynamicproxy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-20 19:32
 **/

public class StackFund implements StackTranscation {
    @Override
    public void sell() {
        System.out.println("抛售股票型基金");
    }

    @Override
    public void buy() {
        System.out.println("购买股票型基金");
    }
}
