package tests.Log4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class day15_LogTests {
    private  static Logger logger= LogManager.getLogger(day15_LogTests.class.getName());
    @Test
    public void test1(){
        logger.fatal("Fatal logger!!!");
        logger.error("Error logger!!!");
        logger.warn("Warn logger!!!");
        logger.debug("Debug logger!!!");
        logger.info("Info logger!!!");

    }
}
