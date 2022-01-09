package infrastructure.forms;

import domain.services.subscriptionRequest.SubscriptionRequestAction;
import infrastructure.Action;

import java.lang.reflect.Array;

public class SubscriptionRequestForm implements Form {
    private boolean valid;
    private boolean submitted;

    @Override
    public void submit(Action action) {
        this.submitted = true;
    }

    @Override
    public SubscriptionRequestAction getData() {
        return null;
    }

    @Override
    public Array getErrors() {
        return null;
    }

    public boolean isValid(){
        return this.valid;
    }

    public boolean isSubmitted(){
        return this.submitted;
    }
}
