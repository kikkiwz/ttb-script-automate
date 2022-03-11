package com.tmb.automation.util.platform2;

public class EnvironmentModel {
    public Server server;
    public MongoDb mongodb;

    public class Server {
        public String dev;
        public String vit;
        public String sit;
        public String uat;
        public String pre;
    }

    public class MongoDbConnect {
        public String client_url;
        public String database_name;
        public String collection_name;
        public String sorts_by_column;
    }

    public class MongoDb {
        public Employee employee;
        public Customer customer;
    }

    public class Employee {
        public MongoDbConnect dev;
        public MongoDbConnect sit;
        public MongoDbConnect vit;
        public MongoDbConnect uat;
    }

    public class Customer {
        public MongoDbConnect dev;
        public MongoDbConnect sit;
        public MongoDbConnect vit;
        public MongoDbConnect uat;
    }

}

