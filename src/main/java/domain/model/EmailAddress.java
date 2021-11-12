package domain.model;

import domain.exception.InvalidArgumentException;

public final class EmailAddress {

    private String emailAddress;

    public EmailAddress(String emailAddress) throws InvalidArgumentException
    {
        if(!isValid(emailAddress)){
            throw new InvalidArgumentException("Invalid argument exception");
        }
        this.emailAddress = emailAddress;
    }

    private boolean isValid(String emailAddress){
        //TODO
        return false;
    }

    public String getEmailAddress(){
        return this.emailAddress;
    }
}
