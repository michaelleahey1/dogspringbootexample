package com.ust.dogspringbootex.model;

import java.util.UUID;

public class Dog {
    private final UUID id;
    private final String name;

    public Dog(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
    public UUID getId()
    {return id;}
    public String getName()
    {return name;}
}
