package main.java.com.marketsoftcommunity.model;

import main.java.com.marketsoftcommunity.util.Util;

/**
 * @Author Aidan Stewart
 * @Year 2019
 * Copyright (c)
 * All rights reserved.
 */
public class Model {
    private int id;
    private String name;

    public Model (String name){
        this.id = Util.NEW_ID();
        this.name = name;
    }

   public Model(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
