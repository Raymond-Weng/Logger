package logger;

import java.io.IOException;
import java.util.logging.*;

public class Logger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
    private static Level consoleLevel, fileLevel;


    public static void init() {
        try {
            Logger.consoleLevel = LoggerConsts.CONSOLE_LEVEL;
            Logger.fileLevel = LoggerConsts.FILE_LEVEL;
            setup();
        } catch (Exception e) {
            logger.log(Level.WARNING, "[Logger]Oh no,we just have a exception while setuping!", e);
        }
        logger.log(Level.INFO, "[Logger]Setup complete.");
    }

    private static void setup() throws IOException {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(consoleLevel);
        logger.addHandler(consoleHandler);

        FileHandler fileHandler = new FileHandler(LoggerConsts.FILE_PATH);
        fileHandler.setLevel(fileLevel);
        fileHandler.setFormatter(new XMLFormatter());
        logger.addHandler(fileHandler);
    }

}
