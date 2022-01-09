package infrastructure.forms;

import infrastructure.Action;

import java.lang.reflect.Array;

public interface Form {

    void submit(Action action);
    Action getData();
    Array getErrors();
    boolean isValid();
    boolean isSubmitted();
}
