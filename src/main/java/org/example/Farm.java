package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Farm {
    Scanner scan = new Scanner(System.in);
    AnimalManager aManager;
    CropManager cManager;

    public Farm(){
        if(aManager == null && cManager == null){
            aManager = new AnimalManager();
            cManager = new CropManager();
        }
    }

    public void MainMenu(){
        boolean looping = true;
        while(looping) {
            System.out.println("What would you like to do?");
            System.out.println("1. Manage animals.");
            System.out.println("2. Manage crops.");
            System.out.println("3. Save progress.");
            System.out.println("4. Load file.");
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

    File folder = new File("folder");
    File animals =  new File("folder/animals.txt");
    File crops = new File("folder/crops.txt");
    File animal = new File("folder/animal.txt");

    private void Save(){
        try {
            FileWriter fw = new FileWriter(animal);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Animal a : aManager.GetAnimals()){
                bw.write(a.GetCSV(a.getAcceptableCropTypes()));
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){

        }
        /*try {
            FileWriter fw = new FileWriter(crops);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Crop c : cManager.GetCrops()){
                bw.write(c.GetCSV());
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){

        }*/
    }
    public void Load() {
        folder.mkdir();
        /*try {
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

        }*/
        try {
            FileReader fr = new FileReader(animal);
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
