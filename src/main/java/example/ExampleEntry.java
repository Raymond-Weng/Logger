package example;

import logger.Logger;

import java.util.logging.Level;

public class ExampleEntry {
    public static void main(String[] args) {
        //setup
        Logger.init();

        //get Logger
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

        //log
        logger.log(Level.INFO,"My first log.");
    }
}
