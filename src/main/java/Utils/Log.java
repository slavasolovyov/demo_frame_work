package Utils;

import org.apache.log4j.Logger;

public class Log {

    private static Logger logger = Logger.getLogger(Log.class);
    public static void info(String text) {logger.info(text);}
    public static void debug(String text) {logger.debug(text);}
}
