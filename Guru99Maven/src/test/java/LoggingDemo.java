import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingDemo extends Base {

    private static final Logger logger = LogManager.getLogger(LoggingDemo.class);

    public static void main(String[] args) {

        logger.trace("Entering app");
        logger.error("error message");
        logger.debug("clicked on a button");
        logger.fatal("kaboom");
    }
}
