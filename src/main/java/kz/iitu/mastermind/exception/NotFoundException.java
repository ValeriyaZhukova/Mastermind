package kz.iitu.mastermind.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    public NotFoundException()
    {
        super("No such record found in database");
    }

    public NotFoundException(String s)
    {
        super(s);
    }

}
