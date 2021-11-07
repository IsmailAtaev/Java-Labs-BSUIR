package com.ataew.model;

public class World {

    private String text;
    private String symbol;

    public World(String text, String symbol) {
        this.text = text;
        this.symbol = symbol;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
