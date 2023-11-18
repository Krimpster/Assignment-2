package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Animal extends Entity{
    public String species;
    private ArrayList<String> acceptableCropTypes = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static int nextId = 1;

    // The main constructor for the Animal class, used to give any animal object values.
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

    // Isn't actually used by anything currently but would list all values for an animal object of called, even the unmodified acceptableCropType list.
    @Override
    public void GetDescription(){
        System.out.println("This animal has the id " + getId() + ", it is named," + getName()
                + "\nis of " + getSpecies() + " species and accepts only " + getAcceptableCropTypes() + " crops.\n");
    }

    // Used to generate a CSV of an animal object for storage in a text file.
    public String GetCSV(ArrayList<String> acceptableCropTypes){
        ArrayList<String> aList = new ArrayList<>();
        for(String s : acceptableCropTypes) {
            aList.add(s);
        }
        String commaList = aList.toString().replace("[","").replace("]","").replace(" ","");
        return name + "," + species + "," + commaList;
    }

    // Called by the FeedAnimal method when a match between an animals acceptableCropType IDs and an ID in the crop list is found.
    // If this happens the user will be prompted with how many of the stock that matches the ID that they want to feed the animal with.
    // This number will then be used as a parameter when calling the TakeCrop method.
    // If TakeCrop decides that there are enough crops in stock it will return true,
    // which will result in the animal being fed and the program returning to the animal menu.
    public static void Feed(Crop crop){
        System.out.println("How many crops do you want to feed the animal with? ");
        int quantity = Integer.parseInt(scan.nextLine());
        if (crop.TakeCrop(quantity)) {
            System.out.println("Animal has been fed.");
        } else {
            System.out.println("There wasn't enough feed in storage to feed the animal.");
        }
    }

    // Getters and setter for the animal class.
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
