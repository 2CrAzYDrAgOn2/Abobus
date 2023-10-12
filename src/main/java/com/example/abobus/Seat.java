package com.example.abobus;

public class Seat {
    private boolean empty;
    private String name;

    public Seat(boolean empty, String name){
        this.empty = empty;
        this.name = name;
    }

    public boolean GetEmpty(){
        return empty;
    }

    public void SetEmpty(boolean empty){
        this.empty = empty;
    }

    public String GetName(){
        return name;
    }

    public void SetName(String name){
        this.name = name;
    }
}