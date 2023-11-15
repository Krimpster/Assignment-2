package org.example;

import java.util.ArrayList;
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
    public Crop(String name, String cropType, int quantity){
        super(nextId, name);
        nextId++;
        this.cropType = cropType;
        this.quantity = quantity;
    }

    @Override
    public void GetDescription(){
        System.out.println("This crop has the id " + getId() + ", it is named " + getName() + ",\nis of " + getCropType()
                + " type and there are " + getQuantity() + " left of it in stock.\n");
    }

    public String getCSV(){
        return id + "," + name + "," + cropType + "," + quantity;
    }

    public void AddCrop(int quantity){
        this.quantity += quantity;
    }

    public boolean TakeCrop(int id) {
        boolean fed = false;
        for (Crop crop : CropManager.GetCrops()) {
            if (crop.getQuantity() >= 1) {
                fed = true;
                this.quantity--;
            }
        }
        return fed;
    }

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
