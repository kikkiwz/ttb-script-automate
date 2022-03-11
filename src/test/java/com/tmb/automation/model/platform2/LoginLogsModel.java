package com.tmb.automation.model.platform2;

public class LoginLogsModel {
    public String[] ActualResult;
    public String correlation_id;
    public String activity_type_id;
    public String activity_type;
    public String agent_id;
    public String activity_status;
    public String fail_reason;
    public ActivityDate activity_date;
    public ActivityDescription[] activitydescription;
    public class ActivityDescription {
        public String flex;
        public String value;
    }
    public class ActivityDate {
        public String $numberLong;
    }

}
