package com.nriagudubem.search.exceptions;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InvalidCredentialsException extends UsernameNotFoundException {

    public InvalidCredentialsException(String msg) {
        super(msg);
    }

    public InvalidCredentialsException(String msg, Throwable t) {
        super(msg, t);
    }
}
