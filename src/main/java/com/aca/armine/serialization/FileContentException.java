package com.aca.armine.serialization;

import java.util.logging.Logger;

public class FileContentException extends RuntimeException {
    public FileContentException(){
        Logger logger = Logger.getGlobal();
        logger.severe("Empty file");

    }
}
