package org.example;

import java.util.ArrayList;

public class Animal extends Entity{
    public String species;
    private ArrayList<String> acceptableCropTypes = new ArrayList<>();

    public Animal(String name, String species, ArrayList<String> acceptableCropTypes){
        super(name);
        this.species = species;
        this.acceptableCropTypes = acceptableCropTypes;
    }

    @Override
    public void GetDescription(){
        System.out.println("This animal has the id " + getId() + ", it is named," + getName() + "\nis of " + getSpecies() + " species and accepts only " + getAcceptableCropTypes() + " crops.\n");
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
