package com.tmb.automation.api.investment.config;

public class Globals {
    private static Globals globalsInstance = new Globals();

    public static Globals getInstance() {

        return globalsInstance;

    }

    private int pinNo = 0;
    private String orderID = "";

    private Globals() {

    }

    public int getPinNo() {

        return pinNo;

    }

    public void setPinNo(int pinNo) {

        this.pinNo = pinNo;

    }

    public String getOderID(){

        return orderID;
    }

    public void setOderID(String  orderID){

        this.orderID= orderID;
    }

}
