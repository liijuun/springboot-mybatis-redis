package com.example.ucms.common.entity;

import java.io.Serializable;

/**
 * Created by j23li on 2018/12/20.
 */
public class Response<T> implements Serializable {
    private static final String R_MEG_EMPTY = "";
    public static final String R_CODE_OK = "OK";
    public static final String R_CODE_NOTOK = "Not OK";

    private final String responseCode;
    private final String message;
    private T data;

    public Response(){
        this(R_CODE_OK, R_MEG_EMPTY);
    }

    public Response(final String code, final String message){
        this.responseCode = code == null? Response.R_CODE_OK : code;
        this.message = message == null? Response.R_MEG_EMPTY : message;
        this.data = null;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
