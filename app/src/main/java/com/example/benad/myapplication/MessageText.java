package com.example.benad.myapplication;

/**
 * Created by benad on 11/10/2016.
 */
public class MessageText {

    String login;
    String message;

    public MessageText(String login, String message) {
        this.login = login;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
