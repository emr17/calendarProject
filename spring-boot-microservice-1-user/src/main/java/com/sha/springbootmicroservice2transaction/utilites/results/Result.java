package com.sha.springbootmicroservice2transaction.utilites.results;

public class Result {
    private boolean success;
    private String message;
    //BU RESULTLARI OBJE OLARAK ALIYORUZ FRONT ENDDE

    // sadece success blgisini döndürmek istiyorsak
    public Result(boolean success) {
        this.success= success;

    }

    public Result(boolean success, String message) {
        this(success);
        this.message = message;


    }

    public boolean isSuccess() {
        return success;
    }
    public String getMessage() {
        return message;
    }
}
