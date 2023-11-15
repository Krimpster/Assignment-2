package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalManager {
    ArrayList<Animal> animalList = new ArrayList<>();
    ArrayList<String> accList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    public void AnimalMenu(){
        Farm farm = new Farm();
        boolean looping = true;
        while (looping) {
            System.out.println("This is the animal menu, what would you like to do?");
            System.out.println("1. View animals");
            System.out.println("2. Add animals");
            System.out.println("3. Remove animals");
            System.out.println("4. Feed animals");
            System.out.println("5. Go back to Main Menu");
            String check = scan.nextLine();
            switch (check) {
                case "1":
                    for (Animal animal : animalList){
                        animal.GetDescription();
                    }
                    break;
                case "2":
                    AddAnimal();
                    break;
                case "3":
                    RemoveAnimal();
                    break;
                case "4":
                    FeedAnimals();
                    break;
                case "5":
                    farm.MainMenu();
                    break;
                default:
                    System.out.println("Input was invalid!");
                    break;
            }
        }
    }
    private void ViewAnimals(){
        for (Animal animal : animalList){
            System.out.println("ID: " + animal.getId() + ", name: " + animal.getName() + ", species: "
                    + animal.getSpecies() + ", eats crops with the IDs: " + animal.getAcceptableCropTypes() + ".");
        }
    }
    private void AddAnimal(){
        ViewAnimals();
        System.out.println("What is the name of the animal you want to add: ");
        String name = scan.nextLine();
        System.out.println("What species is the animal: ");
        String spec = scan.nextLine();
        System.out.println("Input the ID of the crops the animal can eat, input '*' to end inputting: ");
        boolean looping = true;
        while(looping){
            String check = scan.nextLine();
            if(check.equals("*")){
                System.out.println("Animal successfully added!");
                looping = false;
            }
            else{
                accList.add(check);
            }
        }
        animalList.add(new Animal(name, spec, accList));
    }
    private void RemoveAnimal(){
        boolean removed = false;
        ViewAnimals();
        System.out.println("Which animal do you want to put to pasture (ID): ");
        int check = Integer.parseInt(scan.nextLine());
        for(int i = 0; animalList.size() > i; i++){
            if(animalList.get(i).getId() == check){
                animalList.remove(i);
                System.out.println("Animal with ID " + check + " successfully removed");
                removed = true;
            }
        }
        if(!removed){
            System.out.println("Animal with that ID could not be found, try again.");
            RemoveAnimal();
        }
    }
    private void FeedAnimals(){

    }
    public void ToList(String name, String species, ArrayList<String> accList){
        animalList.add(new Animal(name, species, accList));
    }
    public ArrayList<Animal> GetAnimals(){
        return animalList;
    }
}
