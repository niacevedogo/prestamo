package com.example.prestamos.services;

public class Response {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    // se acostumbra a colorcar un codigo y un mensaje
    // para explicar al usuario que ocurrió




}
