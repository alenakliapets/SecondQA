package TestsLesson15;

import BaseEntities.BaseTest;
import org.testng.annotations.Test;

public class LoggerTest extends BaseTest {

    @Test
    public void logginLevelsTest(){
        logger.fatal("Уровень - fatal");
        logger.error("Уровень - error");
        logger.warn("Уровень - warn");
        logger.info("Уровень - info");
        logger.debug("Уровень - debug");
        logger.trace("Уровень - trace");
    }

}
