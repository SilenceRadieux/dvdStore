package org.dvdstore.backpostgre.exceptions;

public class IdNotFoundException extends Exception{

    public IdNotFoundException(String message) {
        super("Id Not Found");
    }
}
