package com.ccsia.demo.model;


public class Result {

    private Object data;

    private boolean success;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(Object data, boolean success) {
        this.data = data;
        this.success = success;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
