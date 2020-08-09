package com.aca.files.model;

import java.util.logging.Logger;

public class FileIsEmptyException extends RuntimeException {
    public FileIsEmptyException(String message){
        Logger logger = Logger.getGlobal();
        logger.severe("Empty file");

    }
}
