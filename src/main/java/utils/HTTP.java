package utils;

import domain.model.MemberStatus;

public enum HTTP {
    OK(200),
    CREATED(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    private final int code;

    HTTP(int code){ this.code = code;}

    public int value() {
        return code;
    }
}
