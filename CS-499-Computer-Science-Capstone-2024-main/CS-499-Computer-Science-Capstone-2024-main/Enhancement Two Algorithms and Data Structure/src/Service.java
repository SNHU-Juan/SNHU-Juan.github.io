/*
Juan Topete
IT - 145
Pet Check-in/Check-out Service
Orignally done on January 31, 2023 Enhancement done on June 7, 2023
*/

import java.util.ArrayList;  // Import package for ArrayLists
import java.util.Scanner;  // Import package for user input
import java.util.Collections; // Import package to create collection in order to sort


public class EnhancementTwo {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<String> petList;
    static ArrayList<Integer> petWeight;

    // Main Program Loop
    public static void main(final String[] args) {
        
        int options[] = {1,2,3,4,5,6}; // Option numbers for menu Array
        String menuItems[] = {"Create New Pets", "Update Pets", "Delete Pets", "Show Pets", "Pay for Service", "Exit"};  // Options for menu Array

        showMainMenu(options, menuItems);  // Method called to display the main menu using the Array at the start of the program
        scan.close();  // Method called to close the scanner once it has been opened
    }

    // Options for the main menu
    public static void showMainMenu(int opts [], String items[]) {
        while (true)
        {
        int options[] = {1,2,3,4,5,6};  // Option numbers for menu Array
        String menuItems[] = {"Create New Pets", "Update Pets", "Delete Pets", "Show Pets", "Pay for Service", "Exit"};  // Options for menu Array
        System.out.println("--- MAIN MENU ---");
        // Display array length
        for (int i = 0; i < opts.length; i++){
            System.out.printf("%d. %s\n", opts[i], items[i]);
        }
        System.out.println("=================");
        System.out.print("Enter your Choice : ");

        // Allows for user input once the menu has been displayed
        int option = scan.nextInt();

        // The switch block that determines what happens once the user has made a selection
        switch (option) {
            case 1:
                createPets();  // Calls the create pet method
                break;
            case 2:
                updatePets();  // Calls the update pet method
                break;
            case 3:
                deletePets();  // Calls the delete pet method
                break;
            case 4:
                showPets();  // Calls the show pet method
                break;
            case 5:
                payForService();  // Calls the pay for service method
                break;
            case 6:
            System.exit(0);  // Allows the user to exit the menu
            break;
            // If the user enters an invalid selection this will be printed out
            default:
                System.out.println("Invalid option!");
                showMainMenu(options, menuItems);  // Returns to the menu
        }
    }
}

    // Method used to create a new pet
    public static void createPets() {

        Scanner myObj = new Scanner(System.in);  // Allows for user input

        System.out.print("Enter Pet Names For List: ");
        String newPet = myObj.nextLine();

        // Creates a new Array for the pet name to be stored
        String newPetArray[] = newPet.split(" ");
        petList = new ArrayList<>();
        
        // Every time a new pet is created it moves up one node in the list
        for (int i = 0; i < newPetArray.length; i++) {
            petList.add(newPetArray[i]);
        }
  
        System.out.println("Pets in list are " + petList);  // Prints the items that are stored in "petList"
    }

    // Method used to update an exsisting pet
    public static void updatePets() {

        System.out.println("Enter the name of the pet to be updated");
        String name = scan.next();
        System.out.println("Enter the updated name");
        String newName = scan.next();

        // Iterates through the ArrayList until the name is found
        for (int i = 0; i < petList.size(); i++) {
            // Get the name to be updated
            if (petList.get(i).equals(name)) {
                // Set the new name to the existing name
                petList.set(i, newName);
                break;
            }
        }
        System.out.println("Pets in list after updating the pet  " + petList);  // Print items that are stored in "petList"
    }

    // Method used to delete a pet
    public static void deletePets() {

        System.out.println("Enter the name of the pet to be deleted");
        String name = scan.next();
        for (int i = 0; i < petList.size(); i++) {
            // Gets the name the user has entered
            if (petList.get(i).equals(name)) {
                // Removes the name from the list
                petList.remove(i);
        System.out.println("Your pet has been removed.");
                break;
            }
        }
        System.out.println("Pets in list after deleting the specific pet " + petList);  // Print items that are stored in "petList"
    }

    // Method used to show pets in petList
    public static void showPets() {
        Collections.sort(petList);  // Sort the items in the ArrayList in alphabetical order
        System.out.println("These are the pets that you have: " + petList);  // Prints petList in alphabetical order
        }

    // Method used to pay for service
    public static void payForService() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Choose either '1' for cat or '2' for dog");
        int petType = scan.nextInt();  // User chooses either dog or cat
        // Price will depend on type of animal
        if(petType == 1) {
            System.out.println("Grooming will be $" + petList.size() * 50);  // Price will be $50.00 for cats
        }
        else if(petType == 2) {
            System.out.println("Gromming will be $" + petList.size() * 75);  // Price will be $75.00 for dogs
        }
	    else {
	        System.out.println("invalid response");
	    }
    }
}