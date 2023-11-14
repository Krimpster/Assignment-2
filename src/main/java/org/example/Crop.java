package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Crop extends Entity{
    public String cropType;
    private int quantity;
    Scanner scan = new Scanner(System.in);

    public Crop(String name, String cropType, int quantity){
        super(name);
        this.cropType = cropType;
        this.quantity = quantity;
    }

    @Override
    public void GetDescription(){
        System.out.println("This crop has the id " + getId() + ", it is named " + getName() + ",\nis of " + getCropType()
                + " type and there are " + getQuantity() + " left of it in stock.\n");
    }

    public void AddCrop(int id, ArrayList<Crop> cropList){
        System.out.println("Crop ID found, input how many crops you want to add to the total: ");
        String check = scan.nextLine();
        int number2 = Integer.parseInt(check);
        for(Crop crop : cropList){
            if(id == crop.id) {
                setQuantity(quantity, number2);
            }
        }
    }

    /*public boolean TakeCrop(int id) {
        for (Crop crop : CropManager.GetCrops()) {
            if (crop.getQuantity() >= 1) {
                return true;
                setQuantity2(crop.id);
            } else {
                return false;
            }
        }
    }*/

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity, int addition) {
        this.quantity = quantity + addition;
    }
    public void setQuantity2(int quantity) {
        this.quantity = --quantity;
    }
}
