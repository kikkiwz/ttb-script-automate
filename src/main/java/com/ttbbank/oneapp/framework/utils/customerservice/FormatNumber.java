package com.ttbbank.oneapp.framework.utils.customerservice;

import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FormatNumber {
    /**
     * @param number The number in plain format
     * @param mask   The  mask pattern.
     *               Use # to include the digit from the position.
     *               Use x to mask the digit at that position.
     *               Any other char will be inserted.
     * @return The masked card number
     */
    public static String formatAccount(String number, String mask) {
        int index = 0;
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                masked.append(number.charAt(index));
                index++;
            } else if (c == 'X') {
                masked.append(c);
                index++;
            } else {
                masked.append(c);
            }
        }
        return masked.toString();
    }

    public static String formatPortFolio(String number) {
        String a = "";
        if (number.length() != 20) {
            for (int i = 0; i < 20 - number.length(); i++) {
                a += "0";
            }
        }
        System.err.println(a);
        String portCode = number.substring(0, 2) + a + number.substring(2, 9);
        return portCode;
    }

    public static String formatBalance(double number) {
        String pattern = "###,###.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formatBalance = decimalFormat.format(number);
        if (formatBalance.equals(".00")) {
            formatBalance = "0" + formatBalance;
        }
        return formatBalance;
    }

    public static JSONObject formatJsonMutual(List portNumber) {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < portNumber.size(); i++) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("account_number", portNumber.get(i));
            jsonArray.put(jsonObj);
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("mutual_fund_accounts", jsonArray);
        return jsonObj;
    }

    public static String ConvertDate(String Date_Expiry, Boolean Format, String timezone) throws IOException {
        DateTimeFormatter newFormatter = null;
        if (Format) {
            if (timezone.equals("TH")) {
                int year = Integer.parseInt(Date_Expiry.substring(0, 4)) + 543;
                Date_Expiry = year + Date_Expiry.substring(4, 16);
                newFormatter = DateTimeFormatter.ofPattern("dd MMM yy, HH:mm น.", new Locale("th", "TH"));
                System.err.println("Date of th" + newFormatter);
            } else {
                newFormatter = DateTimeFormatter.ofPattern("dd MMM yy, HH:mm a", Locale.ENGLISH);
            }
        } else {
            if (timezone.equals("TH")) {
                int year = Integer.parseInt(Date_Expiry.substring(0, 4)) + 543;
                Date_Expiry = year + Date_Expiry.substring(4, 10) + "T00:00";
                newFormatter = DateTimeFormatter.ofPattern("dd MMM yy", new Locale("th", "TH"));
                System.err.println("Date of th" + newFormatter);
            } else {
                newFormatter = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
            }
        }
        System.err.println("Date_Expiry : " + Date_Expiry);
        LocalDateTime dateTime = LocalDateTime.parse(Date_Expiry);
        String contactDate = dateTime.format(newFormatter);
        return contactDate;
    }

    public static String convertTimes(String time) throws ParseException {
        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
        SimpleDateFormat _12HourSDF = new SimpleDateFormat("h:mm a");
        Date _24HourDt = _24HourSDF.parse(time);
        return _12HourSDF.format(_24HourDt);
    }

    public static String checkStatusNdid(String status) throws Exception {
        String result = "";
        if(status.equals("confirmed")){
            result = "Authentication successful";
        }else if(status.equals("cancelled")){
            result = "Authentication canceled";
        }else {
            result = "Authentication expired";
        }
        return result;
    }
}
