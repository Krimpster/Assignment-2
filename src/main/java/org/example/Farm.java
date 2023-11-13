package org.example;

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
                    cManager.GetCrops();
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
    private void Save(){

    }
    private void Load(){
        
    }
}
