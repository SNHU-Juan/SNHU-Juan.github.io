/*
Juan Topete
PetBags Project 1
*/

import java.util.Scanner;

// Declare Pet class
public class Pet {
  
   // List of varibles for specific attributes.
   private String petType;
   private String petName;
   private int dogSpaces;
	private int catSpaces;
	private int dogWeight;
	private int daysStay;
	private double amountDue;
   private int grooming;
   

   // Main program loop
   public static void main(String[] args)
    {
      getPetType();
      setPetType();
      getPetName();
      setPetName();
      getDogSpaces();
      setDogSpaces();
      getDogWeight();
      setDogWeight();
      getGrooming();
      setGrooming();
      getAmountDue();
      SetAmountDue();
      return;
    }
    
   // Constructor to initialize values for variables
	public Pet() {
		petType = "";  // Either dog or cat
		petName = "";  // Name of the pet
      dayStay = 0;   // Num. of days stayed
      dogSpaces = 30;   // Number of dog spaces available
      catSpaces = 12;   // Number of cat spaces available
      grooming = 0; // Grooming for dog owners 0: no or 1: yes
      amountDue = 0.0;  // The amount due from owner
	}

    // Take user input
   static Scanner scnr = new Scanner(System.in);
 
   // Mutator methods
	public static setPetType(String petDogCat) {
		petType = petDogCat;
	}
			
	public void setPetName(String name) {
		petName = name;
	}
			
	public void setDogSpaces(int dogSpaceNum) {
		dogSpaces = dogSpaceNum;
	}
	
	public void setGrooming(int groomDog)
	   grooming = groomDog;
   }
	public void setDaysStay(int numDaysStay) {
		daysStay = numDaysStay;
	}
	
	public void setAmountDue(double totalAmountDue) {
		amountDue = totalAmountDue;
	}
	
	// Accessors methods
	public String getPetType() {
		System.out.println("Is the pet a dog or cat");
		petType = scan.nextLine();
		return petType;
	}
	
	public String getPetName() {
	   System.out.println("Enter pet's name");
		petName = scan.nextLine();
		return petName;
	}
	
	
	public int getDogSpaces() {
	   if petType == "dog" {
	      if dogSpaces > 0 {
	         dogSpaces = dogspaces - 1;
	      }
	   }
	   return dogSpaces;
	}
	
	public double getDogWeight() {
	   System.out.println( "Enter dog's weight (0 for cat)");
	   dogWeight = scan.nextDouble();
	   return dogWeight;
	}
	
	public int getCatSpaces() {
	   if petType == "cat" {
	      if catSpaces > 0 {
	         catSpaces = catspaces - 1;
	      }
	   }
	    return catSpaces;
	}
	
	public int getGrooming() {
	   if petType == "dog" {
	      System.out.println( "Select grooming for dog 0: no, 1: yes");
		   grooming = scan.nextInteger();     
	   }
	   return grooming;
	}
	
	public int getDaysStay() {
	   return daysStay;
	}
	
	public double getAmountDue() {
	   if (petType == "dog") && (dogWeight < 20) {
	      amountDue = 24 + (grooming * 19.95);
	   }
	   if (petType == "dog") && ((dogWeight >= 20) && (dogWeight < 30)) {
	      amountDue = 29 + (grooming * 24.95);
	   }
	   if (petType == "dog") && (dogWeight >= 30) {
	      amountDue = 34 + (grooming * 29.95);
	   }
	   if (petType == "cat") {
	      amountDue = 18;
	   } 
	   return amountDue;
	}

}