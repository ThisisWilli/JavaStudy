package com.study.designpattern.proxypattern.staticproxy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-20 16:40
 **/

public class FundManager implements Transcation {

    private Fund fund;

    public FundManager(Fund fund) {
        this.fund = fund;
    }

    @Override
    public void buy() {
        searchBuy();
        fund.buy();
    }

    @Override
    public void sell() {
        searchSell();
        fund.sell();
    }

    public void searchBuy(){
        System.out.println("寻找潜力高的股票");
    }

    public void searchSell(){
        System.out.println("预估哪些股票会跌");
    }
}
