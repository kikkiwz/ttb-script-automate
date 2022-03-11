package com.ttbbank.oneapp.framework.utils.customerservice;
import com.aventstack.extentreports.ExtentTest;

public class CheckResult {
    public static String CheckResults(String element, String elementEquals, String status) {
        String result = null;
        if(!status.equals("Fail")) {
            if (element.equals(elementEquals)) {
                result = "Pass";
            } else {
                System.err.println(element + " != " + elementEquals);
                result = "Fail";
            }
        }else {
            if (!element.equals(elementEquals)) {
                System.err.println(element + " != " + elementEquals);
            }
            result = "Fail";
        }
        return result;
    }

    public static String CheckDisable(String element, Boolean disabled, String status) {
        String result = null;
        if(!status.equals("Fail")) {
            if(disabled){
                if (element == null) {
                    result = "Fail";
                } else {
                    result = "Pass";
                }
            }else {
                if (element  == null) {
                    result = "Pass";
                } else {
                    result = "Fail";
                }
            }
        }else {
            result = "Fail";
        }
        return result;
    }

    public static void CheckResultsReport(ExtentTest status, String result) {
        if(result.equals("Pass")){
            status.pass(result);
        }else {
            status.fail(result);
        }
    }

    public static String CheckResultsAccountType(String element, String elementEquals, String status) {
        String result = null;
        if(!status.equals("Fail")) {
            if (!element.equals(elementEquals)) {
                result = "Pass";
            } else {
                System.err.println(element + " != " + elementEquals);
                result = "Fail";
            }
        }else {
            if (!element.equals(elementEquals)) {
                System.err.println(element + " != " + elementEquals);
            }
            result = "Fail";
        }
        return result;
    }
}
