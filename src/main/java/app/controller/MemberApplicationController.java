package app.controller;

import domain.services.MemberApplicationHandler;

import java.net.http.HttpRequest;

public class MemberApplicationController {

    private MemberApplicationHandler handler;

    MemberApplicationController(MemberApplicationHandler handler){
        this.handler = handler;
    }

    int applicationAction(HttpRequest request){

        return 404;
    }
}
