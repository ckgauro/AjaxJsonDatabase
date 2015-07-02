package com.ckg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.log4j.Logger;
public class FetchData {
	private static Connection connection = null;
	
	static Logger log=Logger.getLogger(FetchData.class.getName());

	public static Connection getConnection() {
		System.out.println("Call Connection============>");
		log.info("Call Connection============> ");
		if (connection != null)
			return connection;
		else {
			try {
				System.out.println("Call Properties============>");
				Properties prop = new Properties();
				InputStream inputStream = FetchData.class.getClassLoader()
						.getResourceAsStream("db.properties");
				System.out.println("Call inputStream============>");
				//System.out.println("location is "+inputStream.);
				prop.load(inputStream);
				System.out.println("Call Driver============>");
				String driver = prop.getProperty("driver");
				String serverName = prop.getProperty("server");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				String sid =prop.getProperty("sid");
				String portNumber=prop.getProperty("portNumber");
				String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
				System.out.println("url="+url);
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}

	public static ArrayList<Countries> getAllCountries() {
		log.info("ArrayList Call Connection============> ");
		connection = FetchData.getConnection();
		ArrayList<Countries> countryList = new ArrayList<Countries>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from country ");
System.out.println("Fetching result");
			while (rs.next()) {
				Countries country = new Countries();
				country.setCode(rs.getString("Code"));
				country.setName(rs.getString("Name"));
				country.setContinent(rs.getString("Continent"));
				country.setArea(rs.getInt("area"));
				country.setPopulation(rs.getInt("Population"));
				country.setCapital(rs.getString("Capital"));
				countryList.add(country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return countryList;
	}

}
