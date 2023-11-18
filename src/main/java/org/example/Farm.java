package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Farm {
    static Scanner scan = new Scanner(System.in);
    static AnimalManager aManager;
    static CropManager cManager;

    public Farm(){
        if(aManager == null && cManager == null){
            aManager = new AnimalManager();
            cManager = new CropManager();
        }
    }

    // This is the main menu that the program opens into, here you can choose to either interact with the animals or crops
    // or you can save and load the two files containing the animal and crop objects.
    public static void MainMenu(){
        boolean looping = true;
        while(looping) {
            System.out.println("What would you like to do?");
            System.out.println("1. Manage animals.");
            System.out.println("2. Manage crops.");
            System.out.println("3. Save progress.");
            System.out.println("4. Load file, only recommended when you want to return to a prior state of progress.");
            System.out.println("5. Quit");
            String check = scan.nextLine();
            switch(check) {
                case "1":
                    aManager.AnimalMenu();
                    looping = false;
                    break;
                case "2":
                    cManager.CropMenu();
                    looping = false;
                    break;
                case "3":
                    Save();
                    break;
                case "4":
                    Load();
                    break;
                case "5":
                    System.out.println("Quitting without saving first will remove all your progress, are you sure you want that? y/n");
                    String check2 = scan.nextLine();
                    switch (check2){
                        case "y":
                            looping = false;
                            return;
                        case "n":
                            MainMenu();
                            break;
                        default:
                            System.out.println("Input was invalid.");
                            break;
                    }
                    return;
                default:
                    System.out.println("Input was invalid.");
                    break;
            }
        }
    }
    // Creates the folder and files that the save and load systems use.
    static File folder = new File("folder");
    static File animals =  new File("folder/animals.txt");
    static File crops = new File("folder/crops.txt");

    //This is the save method for the program.
    private static void Save(){
        try {
            FileWriter fw = new FileWriter(animals);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Animal a : aManager.GetAnimals()){
                bw.write(a.GetCSV(a.getAcceptableCropTypes()));
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){

        }
        try {
            FileWriter fw = new FileWriter(crops);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Crop c : cManager.GetCrops()){
                bw.write(c.GetCSV());
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){

        }
    }

    // this is the load method for the program.
    public static void Load() {
        folder.mkdir();
        try {
            FileReader fr = new FileReader(crops);
            BufferedReader br = new BufferedReader(fr);
            String nextLine = br.readLine();
            while(nextLine != null) {
                try {
                    String[] string = nextLine.split(",");
                    String name = string[0];
                    String cropType = string[1];
                    int quantity = Integer.parseInt(string[2]);
                    cManager.ToList(name, cropType, quantity);
                } catch (Exception e) {

                }
                nextLine = br.readLine();
            }
        } catch (IOException e) {

        }
        try {
            FileReader fr = new FileReader(animals);
            BufferedReader br = new BufferedReader(fr);
            String nextLine = br.readLine();
            while(nextLine != null) {
                try {
                    String[] string = nextLine.split(",");
                    String name = string[0];
                    String species = string[1];
                    ArrayList<String> accList = new ArrayList<>();
                    for (int i = 2; i < string.length; i++) {
                        accList.add(string[i]);
                    }
                    aManager.ToList(name, species, accList);
                } catch (Exception e) {

                }
                nextLine = br.readLine();
            }
        } catch (IOException e) {

        }
    }
}
