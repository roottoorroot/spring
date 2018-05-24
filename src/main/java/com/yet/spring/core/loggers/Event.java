package com.yet.spring.core.loggers;

import java.text.DateFormat;
import java.util.Random;
import java.util.Date;
import java.util.*;

public class Event {


    Random rnd = new Random();
    private int id = rnd.nextInt(10000);
    private String message;
    private Date date;
    private DateFormat df;


    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public String toString() {
        return new String(this.id + " | " + this.message + " | " + this.df.format(date));
    }
}
