package com.tmb.automation.model.platform2;

import com.tmb.automation.api.investment.model.BaseApiModel;

public class SearchProfileSuccessApiModel extends BaseApiModel{
    public Data data;
    public class Data {
        public String customer_id;
        public String id_card_or_passport_no;
        public String customer_name_en;
        public String customer_name_th;
        public String customer_status;
    }

}
