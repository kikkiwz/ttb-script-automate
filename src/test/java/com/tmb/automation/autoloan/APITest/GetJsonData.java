package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.util.ReadJson;
import org.json.simple.JSONObject;

public class GetJsonData {

    public static JSONObject getReDirectSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/postloan_success.json");
    }

    public static JSONObject getAccDetailSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/get_accountdetail_success.json");
    }

    public static JSONObject getCusDetail() {
        return ReadJson.readJson("/src/main/resources/autoloan/cusdetail_success.json");
    }

    public static JSONObject getApplicationList() {
        return ReadJson.readJson("/src/main/resources/autoloan/applicationslist_success.json");
    }

    public static JSONObject getCarTransferFromSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/cartransferfrom_success.json");
    }

    public static JSONObject getCarTransferFromFailed() {
        return ReadJson.readJson("/src/main/resources/autoloan/cartransferfrom_failed.json");
    }

    public static JSONObject getCopyOfContractSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/copyofcontract_success.json");
    }

    public static JSONObject getCopyOfContract_failed() {
        return ReadJson.readJson("/src/main/resources/autoloan/copyofcontract_failed.json");
    }

    public static JSONObject getSrTrackingList_Success() {
        return ReadJson.readJson("/src/main/resources/autoloan/copyofcontract_success.json");
    }

    public static JSONObject getSrTrackingList_Failed() {
        return ReadJson.readJson("/src/main/resources/autoloan/copyofcontract_success.json");
    }

    public static JSONObject getBranchSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/getbranch_success.json");
    }

    public static JSONObject getBranchTHSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/getbranchthai_success");
    }

    public static JSONObject getBranchBadReq() {
        return ReadJson.readJson("/src/main/resources/autoloan/getbranchthai_badreq.json");
    }

    public static JSONObject getAddressProvide_Success() {
        return ReadJson.readJson("/src/main/resources/autoloan/address_provide_success.json");
    }

    public static JSONObject getAddressProvide_BadReq() {
        return ReadJson.readJson("/src/main/resources/autoloan/address_provide_badrequest.json");
    }

    public static JSONObject getAddressSubDistrict_Success() {
        return ReadJson.readJson("/src/main/resources/autoloan/address_subdistrict_success.json");
    }

    public static JSONObject getAddressSubDistrict_BadReq() {
        return ReadJson.readJson("/src/main/resources/autoloan/address_subdistrict_badrq.json");
    }

    public static JSONObject getAddressPostCode_Success() {
        return ReadJson.readJson("/src/main/resources/autoloan/address_postcode_success.json");
    }

    public static JSONObject getAddressPostCode_BadReq() {
        return ReadJson.readJson("/src/main/resources/autoloan/address_postcode_badreq.json");
    }

    public static JSONObject getApplicationsList() {
        return ReadJson.readJson("/src/main/resources/autoloan/getloanstatus_applicationslist_en_existing.json");
    }

    public static JSONObject getLoanStatusDetail() {
        return ReadJson.readJson("/src/main/resources/autoloan/getloanstatusdetail_en_existing.json");
    }

    public static JSONObject getEnitiSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/enoti_success.json");
    }

    public static JSONObject getViewRegisSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/view_car_registrtion_success");
    }

    public static JSONObject getAccountDetailSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/account_detail_success.json");
    }

    public static JSONObject getAccountDetailBadRq() {
        return ReadJson.readJson("/src/main/resources/autoloan/account_detail_BadRQ.json");
    }

    public static JSONObject getViewCarRegistrationBookSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/view_car_registration_book_success.json");
    }

    public static JSONObject getViewSaleSheetSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/view_sale_sheet_success.json");
    }

    public static JSONObject getViewSaleSheetFailed() {
        return ReadJson.readJson("/src/main/resources/autoloan/view_sale_sheet_failed.json");
    }

    public static JSONObject getPaymentListSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/payment_list_success.json");
    }

    public static JSONObject getPaymentListBadRQ() {
        return ReadJson.readJson("/src/main/resources/autoloan/payment_list_badrq.json");
    }

    public static JSONObject getPaymentDetailSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/payment_detail_success.json");
    }

    public static JSONObject getPaymentDetailBadRQ() {
        return ReadJson.readJson("/src/main/resources/autoloan/payment_detail_badrq.json");
    }

    public static JSONObject getCarTaxSignOnlinePaymentSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/car_tax_sign_online_payment_success.json");
    }

    public static JSONObject getCarTaxSignOnlinePaymentBadRQ() {
        return ReadJson.readJson("/src/main/resources/autoloan/car_tax_sign_online_payment_badrq.json");
    }

    public static JSONObject getCloseAccountOnlinePaymentSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/close_account_online_payment_success.json");
    }

    public static JSONObject getCloseAccountOnlinePaymentBadRQ() {
        return ReadJson.readJson("/src/main/resources/autoloan/close_account_online_payment_badrq.json");
    }

    public static JSONObject getApplicationDetailSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/application_detail_success.json");
    }

    public static JSONObject getApplicationDetailBadRequest() {
        return ReadJson.readJson("/src/main/resources/autoloan/application_detail_bad_request.json");
    }

    public static JSONObject getApplicationDetailInternalServerError() {
        return ReadJson.readJson("/src/main/resources/autoloan/application_detail_internal_server_error.json");
    }

    public static JSONObject getCloseAccountCalculateDebtAmountBadRequest() {
        return ReadJson.readJson("/src/main/resources/autoloan/close_account_calculate_debt_mount_bad_request.json");
    }

    public static JSONObject getLeadInfoWithMongoIdSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/get_lead_info_with_mongo_id_success.json");
    }

    public static JSONObject getPostLoan() {
        return ReadJson.readJson("/src/main/resources/autoloan/post_loan_body.json");
    }

    public static JSONObject encryptDataCYC() {
        return ReadJson.readJson("/src/main/resources/autoloan/data-gen_token_cyc.json");
    }

    public static JSONObject cycCreateLeadSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/cyc_create_lead.json");
    }

    public static JSONObject calculateDebtAmountSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/calculate_debt_amount.json");
    }

    public static JSONObject calculateDebtAmountFail() {
        return ReadJson.readJson("/src/main/resources/autoloan/calculate_debt_amount_fail.json");
    }

    public static JSONObject closeAccountServiceDetail() {
        return ReadJson.readJson("/src/main/resources/autoloan/close_account_service_detail.json");
    }

    public static JSONObject commonBranchProvinceThai() {
        return ReadJson.readJson("/src/main/resources/autoloan/common_branch_province_th.json");
    }
    public static JSONObject commonBranchProvinceEnglish() {
        return ReadJson.readJson("/src/main/resources/autoloan/common_branch_province_en.json");
    }
    public static JSONObject fetchDataMongoCycSuccessCyc() {
        return ReadJson.readJson("/src/main/resources/autoloan/autoloan_fetch_data_from_mongodb_cyc.json");
    }
    public static JSONObject fetchDataMongoCycSuccessAccountDetail() {
        return ReadJson.readJson("/src/main/resources/autoloan/autoloan_fetch_data_from_mongodb_account_detail.json");
    }
    public static JSONObject fetchDataMongoCycSuccessApplicationDetail() {
        return ReadJson.readJson("/src/main/resources/autoloan/autoloan_fetch_data_from_mongodb_application_detail.json");
    }

    public static JSONObject saveDataMongoCycSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/autoloan_save_data_to_monodb_cyc.json");
    }

    public static JSONObject saveDataMongoAccountDetailSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/autoloan_save_data_to_monodb_account_detail.json");
    }

    public static JSONObject saveDataMongoApplicationDetailSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/autoloan_fetch_data_from_mongodb_application_detail.json");
    }

    public static JSONObject getAccountListSuccess() {
        return ReadJson.readJson("/src/main/resources/autoloan/account_list_success.json");
    }

    public static JSONObject getAccountListBadRequest() {
        return ReadJson.readJson("/src/main/resources/autoloan/account_list_bad_request.json");
    }

    public static JSONObject getK2AddServiceRequest() {
        return ReadJson.readJson("/src/main/resources/autoloan/k2_add_service_request.json");
    }

    public static JSONObject getK2updatePaymentFlag() {
        return ReadJson.readJson("/src/main/resources/autoloan/k2_update_payment_flag.json");
    }
}