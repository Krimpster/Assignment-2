package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalManager {
    ArrayList<Animal> animalList = new ArrayList<>();
    ArrayList<String> accList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    CropManager cManager = new CropManager();

    // This is the animal submenu, here you can interact with the animals in different ways.
    public void AnimalMenu(){
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
                    ViewAnimals();
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
                    Farm.MainMenu();
                    return;
                default:
                    System.out.println("Input was invalid!");
                    break;
            }
        }
    }

    // This method goes through the list of animal objects and lists them on the terminal.
    private void ViewAnimals(){
        ArrayList<String> cList = new ArrayList<>();
        for (Animal animal : animalList){
            System.out.println("Id: " + animal.getId() + ", Name: " + animal.getName()
                    + ", Species: " + animal.getSpecies() + ", Eats: " + GetFoodList(animal) + ".\n");
        }
    }

    // This method takes the ArrayList that contains the crop types an animal can and transforms it into
    // a string to be fed back to the ViewAnimals method.
    private String GetFoodList(Animal animal){
        ArrayList<String> cList = new ArrayList<>();
            for (Crop crop : cManager.GetCrops()) {
                for (String s : animal.getAcceptableCropTypes()) {
                    if (crop.getId() == Integer.parseInt(s)) {
                        cList.add(crop.getName());
                    }
                }
            }
        return cList.toString().replace("[", "").replace("]", "");
    }

    // This method is used to add new animal objects into the animal list.
    private void AddAnimal(){
        ViewAnimals();
        System.out.println("What is the name of the animal you want to add? ");
        String name = scan.nextLine();
        System.out.println("What species is the animal? ");
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

    // This method is used to remove a specific index from the animal list.
    private void RemoveAnimal(){
        ViewAnimals();
        boolean removed = false;
        System.out.println("Which animal do you want to put to pasture (ID)? ");
        int check = Integer.parseInt(scan.nextLine());
        for(int i = 0; animalList.size() > i; i++){
            if(animalList.get(i).getId() == check){
                animalList.remove(i);
                System.out.println("Animal with ID " + check + " successfully removed.");
                removed = true;
            }
        }
        if(!removed){
            System.out.println("Animal with that ID could not be found, try again.");
            RemoveAnimal();
        }
    }

    // This method is used for "feeding" the animals contained in the animal list.
    // The method will open up to a yes or no question, asking if you want to feed the animals.
    // If yes then the method will go through the list of animals and display them on the terminal and you will be prompted with a question of which
    // ID you want to feed. It will then look for a match of ID between the user input and the animals in animal list. If a match
    // is found the method will go through the list of Crops and compare the animals acceptableCropType IDs with the IDs of the crops in the crop list
    // If a match is found the method will call on a different method named Feed that has the parameter of the crop we just found in the list.
    private void FeedAnimals(){
        boolean looping = true;
        System.out.println("Would you like to feed some of the animals? (y/n)");
        String input = scan.nextLine();
        while(looping) {
            switch (input) {
                case "y":
                    for (Animal animal : animalList){
                        System.out.println("ID: " + animal.getId() + ", Name: " + animal.getName());
                    }
                    System.out.println("Which animal would you like to feed? (ID)");
                    boolean found = false;
                    int idToFind = Integer.parseInt(scan.nextLine());
                    for (Animal animal : animalList) {
                        if (animal.getId() == idToFind) {
                            found = true;
                            for(Crop crop : cManager.GetCrops()) {
                                for (String string : animal.getAcceptableCropTypes()) {
                                    if (Integer.parseInt(string) == crop.id) {
                                        System.out.println("ID: " + crop.getId() + ", Name: " + crop.getName() + ", Storage quantity: " + crop.getQuantity());
                                    }
                                }
                            }
                            System.out.println("Which crop do you want to feed the animal? (ID)");
                            int idToFind2 = Integer.parseInt(scan.nextLine());
                            for (Crop c : cManager.GetCrops()) {
                                if(c.getId() == idToFind2) {
                                    for (String s : animal.getAcceptableCropTypes()) {
                                        if (c.id == Integer.parseInt(s)) {
                                            animal.Feed(c);
                                            looping = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(!found){
                        System.out.println("That ID could not be found, try again.");
                        looping = true;
                    }

                    break;
                case "n":
                    looping = false;
                    AnimalMenu();
                    break;
                case "Default":
                    System.out.println("Input was invalid.");
                    break;
                }
            }
    }

    // Is used by the Load method to input animal objects into the animal list from a text file.
    public void ToList(String name, String species, ArrayList<String> accList){
        animalList.add(new Animal(name, species, accList));
    }

    // Is used by the program at large to retrieve the animal list.
    public ArrayList<Animal> GetAnimals(){
        return animalList;
    }
}
