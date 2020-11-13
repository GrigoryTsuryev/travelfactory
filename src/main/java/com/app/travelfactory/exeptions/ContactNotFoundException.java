package com.app.travelfactory.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ContactNotFoundException extends NoSuchElementException {
}
