package com.tmb.automation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString

public class LoginLogsModel {
    public String[] ActualResult;
    public String correlation_id;
    public String activity_type_id;
    public String activity_type;
    public String agent_id;
    public String emp_id;
    public String activity_status;
    public String fail_reason;
    public ActivityDate activity_date;
    public ActivityDescription[] activitydescription;
    @Data
    @Setter
    @Getter
    @ToString
    public class ActivityDescription {
        public String flex;
        public String value;
        public String description;
    }
    @Data
    @Setter
    @Getter
    @ToString
    public class ActivityDate {
        public String $numberLong;
        public String $date;
    }

}
/*
[
    {
        "_id": {
            "$oid": "604768bdb1af631aa4bc9bb6"
        },
        "correlation_id": "X-Correlation-ID",
        "activity_type_id": "9002001",
        "activity_type": "Search Customer",
        "activity_date": {
            "$numberLong": "1615292605842"
        },
        "agent_id": "occ_040",
        "activity_status": "Success",
        "fail_reason": "",
        "activitydescription": [
            {
                "flex": "module_name",
                "value": "CUSTOMER SEARCH"
            },
            {
                "flex": "search_by",
                "value": "passport-no"
            },
            {
                "flex": "from_date_time"
            },
            {
                "flex": "to_date_time"
            }
        ]
    }
]
 
}
*/