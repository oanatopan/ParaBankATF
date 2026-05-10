package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtility {

    public static final Logger logger = LogManager.getLogger(LogUtility.class);

    public static void startTest(String testName) {
        logger.info("***** EXECUTION STARTED: " + testName + " *****");
    }

    public static void infoLog(String message) {
        logger.info(message);
    }

    public static void warnLog(String message) {
        logger.warn(message);
    }

    public static void errorLog(String message) {
        logger.error(message);
    }

    public static void finishTest(String testName) {
        logger.info("***** EXECUTION FINISHED: " + testName + " *****");
    }
}