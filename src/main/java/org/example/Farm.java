package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Farm {
    Scanner scan = new Scanner(System.in);
    AnimalManager aManager = new AnimalManager();
    CropManager cManager = new CropManager();
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
                    //cManager.GetCrops();
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
                    looping = false;
                    break;
                    /*System.out.println("Quitting without saving first will remove all your progress, are you sure you want that? y/n");
                    String check2 = scan.nextLine();
                    switch (check2){
                        case "y":
                            looping = false;
                            break;
                        case "n":
                            MainMenu();
                            break;
                        default:
                            System.out.println("Input was invalid.");
                            break;
                    }*/
                default:
                    System.out.println("Input was invalid.");
                    break;
            }
        }
    }

    File folder = new File("folder");
    File animals =  new File("folder/animals.txt");
    File crops = new File("folder/crops.txt");
    private void Save(){
        try {
            FileWriter fw = new FileWriter(animals);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Animal a : aManager.animalList){
                bw.write(a.getCSV());
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){

        }
        try {
            FileWriter fw = new FileWriter(crops);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Crop c : cManager.cropList){
                bw.write(c.getCSV());
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){

        }
    }
    public void Load() {
        try {
            FileReader fr = new FileReader(crops);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            try {
                String[] string = line.split(",");
                String name = string[1];
                String cropType = string[2];
                int quantity = Integer.parseInt(string[3]);
                cManager.ToList(name, cropType, quantity);
            } catch (Exception e) {

            }
            line = br.readLine();
        } catch (IOException e) {

        }
        try {
            FileReader fr = new FileReader(animals);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            try {
                String[] string = line.split(",");
                String name = string[1];
                String species = string[2];
                String[] string2 = line.split("@");
                ArrayList<String> accList = new ArrayList<>();
                for (int i = 0; i < string2.length; i++) {
                    accList.add(string2[i]);
                }
                aManager.ToList(name, species, accList);
            } catch (Exception e) {

            }
            line = br.readLine();
        } catch (IOException e) {

        }
    }
}
