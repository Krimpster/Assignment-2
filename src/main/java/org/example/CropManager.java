package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class CropManager {
    public static ArrayList<Crop> cropList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    // This is the crop menu, here you can interact with crops in different ways.
    public void CropMenu() {
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
                    for (Crop crop : cropList){
                        crop.GetDescription();
                    }
                    break;
                case "2":
                    AddCrop();
                    break;
                case "3":
                    RemoveCrop();
                    break;
                case "4":
                    Farm.MainMenu();
                    return;
                default:
                    System.out.println("Input was invalid!");
                    break;
            }
        }
    }

    // When called it lists out all values for the crop objects in the crop list.
    public void ViewCrops() {
        for(Crop crop : cropList){
            System.out.println("Crop ID: " + crop.getId() + ", Crop name: " +  crop.getName()
                    + ", Crop type: " + crop.getCropType() + ", quantity: " + crop.getQuantity());;
        }
    }

    // Allows for the user to add stock to existing crops or to add new crop objects to the crop list.
    private void AddCrop() {
        ViewCrops();
        System.out.println("What crop do you want to add to (ID): ");
        int idCheck = Integer.parseInt(scan.nextLine());
        for(Crop crop : cropList){
            if(crop.id == idCheck){
                System.out.println("How many?");
                int number = Integer.parseInt(scan.nextLine());
                crop.AddCrop(number);
                return;
            }
        }
        System.out.println("Crop ID not found, let's add it to the list instead.\nWhat should the crops name be? ");
        String name = scan.nextLine();
        System.out.println("What type of crop is it? ");
        String type = scan.nextLine();;
        System.out.println("How many of these crops do you have? ");
        int quantity = Integer.parseInt(scan.nextLine());
        Crop c = new Crop(name, type, quantity);
        cropList.add(c);
        System.out.println("Crop added successfully!");
    }

    // Allows the user to remove a specific index from the crop list.
    private void RemoveCrop() {
        ViewCrops();
        boolean removed = false;
        System.out.println("Which crop do you want to exterminate from the farm (ID)? ");
        int check = Integer.parseInt(scan.nextLine());
        for(int i = 0; cropList.size() > i; i++){
            if(cropList.get(i).getId() == check){
                cropList.remove(i);
                System.out.println("Crop with ID " + check + " successfully removed");
                removed = true;
            }
        }
        if(!removed){
            System.out.println("Crop with that ID could not be found, try again.");
            RemoveCrop();
        }
    }

    // Used by the Load method to add crop objects into the crop list from a text file.
    public void ToList(String name, String cropType, int quantity){
        cropList.add(new Crop(name, cropType, quantity));
    }

    // Used by the program as a whole to retrieve the crop list.
    public ArrayList<Crop> GetCrops(){
        return cropList;
    }
}
