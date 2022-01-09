package infrastructure.forms;

import infrastructure.Action;

import java.lang.reflect.Array;

public class SubscriptionPaymentForm implements Form{
    private boolean valid;
    private boolean submitted;

    @Override
    public void submit(Action action) {
        this.submitted = true;
    }

    @Override
    public Action getData() {
        return null;
    }

    @Override
    public Array getErrors() {
        return null;
    }

    @Override
    public boolean isValid() {
        return this.valid;
    }

    @Override
    public boolean isSubmitted() {
        return this.submitted;
    }
}
