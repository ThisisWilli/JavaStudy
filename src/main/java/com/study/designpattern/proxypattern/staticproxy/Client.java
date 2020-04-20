package com.study.designpattern.proxypattern.staticproxy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-20 13:23
 **/

public class Client {
    public static void main(String[] args) {
//        Host host = new Host();
//        Proxy proxy = new Proxy(host);
//        proxy.rent();
        Fund fund = new Fund();

        FundManager manager = new FundManager(fund);
        manager.buy();
        manager.sell();
    }
}
