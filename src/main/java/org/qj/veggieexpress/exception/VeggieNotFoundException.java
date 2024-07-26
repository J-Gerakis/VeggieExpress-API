package org.qj.veggieexpress.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Object not found with current parameters")
public class VeggieNotFoundException extends Exception{
    public  VeggieNotFoundException(){}
    public VeggieNotFoundException(String message) { super(message); }
}
