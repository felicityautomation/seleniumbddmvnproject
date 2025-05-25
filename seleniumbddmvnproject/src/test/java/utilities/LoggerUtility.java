package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggerUtility {
	
	public static Logger getLogger(String classNameAndMethodName) {
				//Step1 - Create Logger object
				Logger logger=LogManager.getLogger(classNameAndMethodName);
				
				//Step2 - Configure Logger Object to print in the console and to store log message in the file
				Configurator.initialize("MyConfig", "log4j2.properties");
				
				return logger;
	}

}
