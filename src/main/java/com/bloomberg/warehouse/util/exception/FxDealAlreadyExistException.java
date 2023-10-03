package com.bloomberg.warehouse.util.exception;

public class FxDealAlreadyExistException extends RuntimeException{
    public FxDealAlreadyExistException() {
        super("FxDeal Already Exist!");
    }
}
