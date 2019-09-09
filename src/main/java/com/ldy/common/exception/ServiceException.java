package com.ldy.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceException extends Exception {
    private static final Logger logger = LoggerFactory.getLogger(ServiceException.class);
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        logger.error(message, cause);
    }
    public ServiceException(Throwable cause) {
        super(cause);
        logger.error("", cause);
    }
    public ServiceException(String message) {
        super(message, null);
        logger.error(message);
    }

}
