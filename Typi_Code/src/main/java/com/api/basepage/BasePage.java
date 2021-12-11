package com.api.basepage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BasePage {
	public static Logger logger;
	
	public BasePage() {
	logger = Logger.getLogger("API Logs");
	PropertyConfigurator.configure("Log4j.properties");

	}
}
