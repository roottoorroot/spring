package com.yet.spring.core.loggers;

import java.text.DateFormat;
import java.util.Random;
import java.util.Date;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {


    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private int id;
    private String message;
    private Date date;
    private DateFormat df;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event(Date date, DateFormat df) {
        this.id = AUTO_ID.getAndIncrement();
        this.date = date;
        this.df = df;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    @Override
    public String toString() {
        return "event [id= " + id + ", message = " + message + ", date= " + df.format(date) + " ] ";
    }
}
