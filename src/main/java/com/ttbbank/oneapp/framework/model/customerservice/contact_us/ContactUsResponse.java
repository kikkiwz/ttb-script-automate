package com.ttbbank.oneapp.framework.model.customerservice.contact_us;

import java.util.List;

public class ContactUsResponse {
    public List<SocialMediaDeeplinkList> social_media_deeplink_list;
    public String tmb_display_number;
    public String tmb_dial_number;
    public boolean wealth_flag;
    public boolean has_advisor;
    public boolean within_working_hours;
    public String advisor_full_name_th;
    public String advisor_full_name_en;
    public String advisor_image;
    public String advisor_email;
    public String advisor_mobile_number;
    public String advisor_supervisor_email;
    public List<AdvisorLicense> advisor_license;
}
