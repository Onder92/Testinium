
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;


public class Log {
	
	static Logger logger= Logger.getLogger(Log.class);
	
	public Log() {
		DOMConfigurator.configure("log4j.xml");
	}

	public void info(String message) {
		Logger.info(message);
	}
	
	public void warn(String message) {
		Logger.warn(message);
		
	}
	
	public void error(String message) {
		Logger.errror(message);
		
	}
}
