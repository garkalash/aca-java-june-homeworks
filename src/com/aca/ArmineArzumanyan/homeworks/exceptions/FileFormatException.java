package com.aca.arminearzumanyan.homeworks.exceptions;

import java.util.logging.Logger;

public class FileFormatException extends RuntimeException{

    public FileFormatException(){
        Logger logger = Logger.getGlobal();
        logger.severe("Wrong file");
    }
}
