package com.ccsia.demo.model;

public class ResultBuilder {

    public static Result success() {
        return new Result(true);
    }

    public static Result success(Object date) {
        return new Result(date, true);
    }

    public static Result error() {
        return new Result(false);
    }

}
