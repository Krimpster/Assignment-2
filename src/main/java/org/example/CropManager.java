package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class CropManager {
    public static ArrayList<Crop> cropList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public CropManager(){
        cropList.add(new Crop("Wheat", "Cereal", 45));
        cropList.add(new Crop("Corn", "Cereal", 30));
        cropList.add(new Crop("Grubs", "Insect", 67));
    }
    public void CropMenu() {
        Farm farm = new Farm();
        System.out.println("This is the crop menu, what would you like to do?");
        boolean looping = true;
        while (looping) {
            System.out.println("This is the crop menu, what would you like to do?");
            System.out.println("1. View crops");
            System.out.println("2. Add crops");
            System.out.println("3. Remove crops");
            System.out.println("4. Go back to Main Menu");
            String check = scan.nextLine();
            switch (check) {
                case "1":
                    ViewCrops();
                    break;
                case "2":
                    AddCrop();
                    break;
                case "3":
                    RemoveCrop();
                    break;
                case "4":
                    farm.MainMenu();
                    break;
                default:
                    System.out.println("Input was invalid!");
                    break;
            }
        }
    }
    public void ViewCrops () {
        for(Crop crop : cropList){
            crop.GetDescription();
        }
    }
    private void AddCrop () {
        ViewCrops();
        System.out.println("What crop do you want to add to (ID): ");
        String check = scan.nextLine();
        int number = Integer.parseInt(check);
        for(Crop crop : cropList){
            if(crop.id == number){
                crop.AddCrop(number);
            }
            else{
                System.out.println("Crop ID not found, let's add it to the list instead.\nWhat should the crops name be: ");
                String name = scan.nextLine();
                System.out.println("What type of crop is it:");
                String type = scan.nextLine();;
                System.out.println("How many of these crops do you have: ");
                int quantity = Integer.parseInt(scan.nextLine());
                cropList.add(new Crop(name, type, quantity));
                System.out.println("Crop added successfully!");
            }
        }
    }
    private void RemoveCrop () {
        boolean removed = false;
        ViewCrops();
        System.out.println("Which crop do you want to exterminate from the farm (ID): ");
        int check = Integer.parseInt(scan.nextLine());
        for(int i = 0; cropList.size() > i; i++){
            if(cropList.get(i).getId() == check){
                cropList.remove(check);
                System.out.println("Crop with ID " + check + " successfully removed");
                removed = true;
            }
        }
        if(!removed){
            System.out.println("Animal with that ID could not be found, try again.");
            RemoveCrop();
        }
    }
    public static ArrayList<Crop> GetCrops(){
        return cropList;
    }
}
