package domain.model;

import domain.exception.InvalidArgumentException;

public final class EmailAddress {

    private final String emailAddress;

    public EmailAddress(String emailAddress) throws InvalidArgumentException
    {
        if(!isValid(emailAddress)){
            throw new InvalidArgumentException("Invalid argument exception");
        }
        this.emailAddress = emailAddress;
    }

    private boolean isValid(String emailAddress){
        String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; // pourrait être une constante
        return emailAddress.matches(emailRegex);
    }

    public String getEmailAddress(){
        return this.emailAddress;
    }
}
