package com.aca.armine.generic;

import java.util.logging.Logger;

public class EmptyCollectionException extends RuntimeException {

    public EmptyCollectionException(){
        Logger logger = Logger.getGlobal();
        logger.severe("Empty Collection");

    }
}
