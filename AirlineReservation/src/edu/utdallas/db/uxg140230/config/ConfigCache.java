package edu.utdallas.db.uxg140230.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigCache {
	private static ConfigCache instance;
	
	private Properties configPoperties;
	
	private ConfigCache() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(Constants.CONFIG_PROPERTIES_FILE);
		configPoperties = new Properties();
		try {
			configPoperties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConfigCache getInstance() {
		if (instance == null)
			instance = new ConfigCache();
		return instance;
	}
	
	public String getJDBCDriver() {
		String value = configPoperties.getProperty(Constants.JDBC_DRIVER_KEY);
		if (value == null)
			value = Constants.JDBC_DRIVER_DEFAULT;
		return value;
	}
	
	public String getDatabaseURL() {
		String value = configPoperties.getProperty(Constants.DATABASE_URL_KEY);
		if (value == null)
			value = Constants.DATABASE_URL_DEFAULT;
		return value;
	}
	
	public String getDatabaseUsername() {
		String value = configPoperties.getProperty(Constants.DATABASE_USERNAME_KEY);
		if (value == null)
			value = Constants.DATABASE_USERNAME_DEFAULT;
		return value;
	}
	
	public String getDatabasePassword() {
		String value = configPoperties.getProperty(Constants.DATABASE_PASSWORD_KEY);
		if (value == null)
			value = Constants.DATABASE_PASSWORD_DEFAULT;
		return value;
	}
}
