package org.example;

public class Entity {

    public int id;
    protected String name;

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void GetDescription(){
        System.out.println("This entity has id " +  getId() + " and is named " + getName() + ".");
    }

    public String getCSV(){
        return id + "," + name;
    }

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
