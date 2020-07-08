package com.aca.arminearzumanyan.homeworks.exceptions;

import java.util.logging.Logger;

public class NotEnoughItemException extends RuntimeException {


    public NotEnoughItemException() {
        Logger logger = Logger.getGlobal();
        logger.severe("Not enough items in stock");
    }
}
