package org.example;

import java.util.Scanner;

public class Crop extends Entity{
    public String cropType;
    private int quantity;
    Scanner scan = new Scanner(System.in);
    static int nextId = 1;

    public Crop(int id, String name, String cropType, int quantity){
        super(nextId, name);
        if(id >= nextId)
        {
            nextId = id + 1;
        }
        this.cropType = cropType;
        this.quantity = quantity;
    }

    // The main constructor of the Crop class.
    public Crop(String name, String cropType, int quantity){
        super(nextId, name);
        nextId++;
        this.cropType = cropType;
        this.quantity = quantity;
    }

    // When called this will list out all values for given crop object.
    @Override
    public void GetDescription(){
        System.out.println("This crop has the id " + getId() + ", it is named " + getName() + ",\nis of " + getCropType()
                + " type and there are " + getQuantity() + " left of it in stock.\n");
    }

    // Returns a given crop object in CSV form for storage in a text file.
    @Override
    public String GetCSV(){
        return name + "," + cropType + "," + quantity;
    }

    // Called by the AddCrop method in CropManager to increase the amount of stock that a given crop has.
    public void AddCrop(int quantity){
        this.quantity += quantity;
    }

    // Used by the Feed method to compare the quantity that the user input with the available stock for a given crop object.
    // If there is enough stock the quantity will be taken away from it and the method will return true, if there isn't the method simply returns false.
    public boolean TakeCrop(int quantity) {
        boolean fed = false;
            if (this.quantity >= quantity) {
                fed = true;
                this.quantity -= quantity;
            }
        return fed;
    }

    // Getters and setters for the Crop class.
    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
