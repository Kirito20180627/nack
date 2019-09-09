package com.ldy.common.exception;

public class UtilException extends Exception {

    private static final long serialVersionUID = -1291133336471657473L;

    public UtilException(String message, Throwable cause){super(message, cause);}

    public UtilException(String message){super(message,null);}

    public UtilException(Throwable cause){super(cause);}
}
