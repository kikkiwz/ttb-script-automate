package com.tmb.automation.api.IT4IT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.Assert;

import com.tmb.automation.helper.Helper;

public class DBConnection {
	
	public Connection con = null;
	public static String getProperties(String value) {
		InputStream fis;
		Properties prop = null;
		
		try {
			// getResourceAsStream("Global.properties") =
			// "/src/main/resources/Global.properties";
			fis = Helper.class.getClassLoader().getResourceAsStream("application.properties");
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String propertyValue = prop.getProperty(value);
		if (propertyValue == null) {
			Assert.fail("value of " + value + " is not found in Global.properties");
		}
		return propertyValue;
	}

	public ResultSet connection(String queery) throws SQLException, ClassNotFoundException {
		String dbUrl = getProperties("datasource.url");
		String username = getProperties("datasource.username");
		String password = getProperties("datasource.password");
		String classname = getProperties("datasource.driver-class-name");
		
		
			Class.forName(classname);

			con = DriverManager.getConnection(dbUrl, username, password);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(queery);

			return rs;
		

	}

}
