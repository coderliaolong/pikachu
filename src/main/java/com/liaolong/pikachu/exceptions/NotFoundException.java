package com.liaolong.pikachu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author LiaoLong
 * @date 2021-12-05 13:58
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

    public NotFoundException() {

    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
