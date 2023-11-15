package org.example;

import java.util.ArrayList;

public class Animal extends Entity{
    public String species;
    private ArrayList<String> acceptableCropTypes = new ArrayList<>();
    static int nextId = 1;

    public Animal(String name, String species, ArrayList<String> acceptableCropTypes) {
        super(nextId,name);
        nextId++;
        this.species = species;
        this.acceptableCropTypes = acceptableCropTypes;
    }

    public Animal(int id, String name, String species, ArrayList<String> acceptableCropTypes){
        super(id,name);
        this.species = species;
        this.acceptableCropTypes = acceptableCropTypes;
    }

    @Override
    public void GetDescription(){
        System.out.println("This animal has the id " + getId() + ", it is named," + getName()
                + "\nis of " + getSpecies() + " species and accepts only " + getAcceptableCropTypes() + " crops.\n");
    }
    @Override
    public String getCSV(){
        return id + "," + name + "," + species;
    }

    /*public void Feed(){
        if(takeCrop() = true){

        }
    }*/

    public ArrayList<String> getAcceptableCropTypes() {
        return acceptableCropTypes;
    }

    public void setAcceptableCropTypes(ArrayList<String> acceptableCropTypes) {
        this.acceptableCropTypes = acceptableCropTypes;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
