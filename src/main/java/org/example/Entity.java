package org.example;

public class Entity {

    public int id;
    protected String name;

    // The main constructor for the Entity super class.
    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // The base GetDescription method that gets overriden by the subclasses.
    public void GetDescription(){
        System.out.println("This entity has id " +  getId() + " and is named " + getName() + ".");
    }

    // The base GetCSV method that gets overriden by the subclasses.
    public String GetCSV(){
        return id + "," + name;
    }

    // Getters and setters for the Entity super class.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
