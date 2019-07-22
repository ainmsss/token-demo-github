package com.ccsia.demo.model;

public class ResultBuilder {

    public static Result success() {
        return new Result(true);
    }

    public static Result success(Object date) {
        return new Result(date, true);
    }

    public static Result error(String errorCode, String errorMsg) {
        return new Result(false, errorCode, errorMsg);
    }

}
