package tests;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_log4j2 {
   // Create object
    private static Logger logger= LogManager.getLogger(Day15_log4j2.class.getName());
    @Test
    public void log4jTest(){
        //  Use logger object to log/print information
        logger.fatal("Fatal log!!!");//PRINTS DEFAULT
        logger.warn("Warning log!!!");//PRINTS DEFAULT
        logger.debug("Debug Log!!!");
        logger.info("Info Log!!!");

    }
}
