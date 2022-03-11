package com.tmb.automation.pages.pb1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class Oracle_DB {

	public ResultSet crmDB(String url, String host, String port, String sid, 
			String username, String password, String query) throws SQLException {

		Connection con = DriverManager.getConnection(url + host + ":" + port + ":" + sid, username, password);
		Statement crmDB = con.createStatement();
		ResultSet resultDB = crmDB.executeQuery(query);
		
		return resultDB;
	}

}
