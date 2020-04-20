package com.study.designpattern.proxypattern.staticproxy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-20 16:38
 **/

public class Fund implements Transcation{
    @Override
    public void buy() {
        System.out.println("买基金");
    }

    @Override
    public void sell() {
        System.out.println("卖基金");
    }
}
