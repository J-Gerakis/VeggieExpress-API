package org.qj.veggieexpress.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Payload information missing or inconsistent")
public class VeggieErrorException extends Exception{
    public VeggieErrorException(String message) { super(message); }

    public VeggieErrorException(String message, Throwable cause) { super(message, cause); }
}
