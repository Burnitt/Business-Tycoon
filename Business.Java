/* Gurnit Chopra
 ICS3UO-C
 Arrays Assignment 
 Friday, April 19, 2024
 Within this java file, I have created a class called Business.java. This class contains all of the methods that are used in the program.  
*/

import java.io.IOException; // import the IOException class to handle errors
import java.io.*; // import the File class


public class Business { // Business class

  int holder3 = 0; // initiating a holder variable 
  int [] holder; // a holder array
  int [] holder2 = new int[4]; // another holder array
  int [] previousResults = new int [200]; // an array that stores the previous results (saved games) that the file has
  int counter = 0; // initiating a counter variable
  int successful = 0; // initiating a successful variable
  public Business () { // constructor method

    holder = new int [10]; // initiating the holder array
  } // constructor method
  int userlevel = 1; // setting the user level to 1

  public void levelSign(){ // procedural method that prints out the level sign
    System.out.println("\n__________________________________________");
    System.out.println("| |     __        __   |       ___     | |");
    System.out.println("| |    | _| \\  / | _|  |  |  | |__|    | |");
    System.out.println("| |___ |__    /  |__   |   __/ |       . |");
    System.out.println("|______________________________|_________|\n");
  } // level sign procedural method

  public int[] purchasingProcess (int currentCash, int subCash, int newProducts, int productBuyPrice, int buildingInventory, int expenseRelief){ // functional method that calculates the purchasing process (when the user wants to purcahse some inventory)
    successful = 0; // sets the successful variable to 0
    if (currentCash < subCash){ // if the users cash is greater than the amount that the user wants to spend
      System.out.println("You do not have enough money to purchase this amount of inventory");
    } else { // if the user does have enough cash to purchase the inventory
      currentCash = currentCash - subCash; // subtracts the amount of inventory that the user wants to purchase from the users current cash
      if (expenseRelief == 1){ // if the user has a expense relief booster active
        holder3 = (int) (subCash * 0.25); // takes a quarter of the amount that the user spent
        currentCash = currentCash + holder3; // Adds it to their cash
        System.out.println("With you having a purchase relief booster active, you have saved " + holder3 + " dollars!");
      } // if the user has a expense relief
      newProducts = (int) (subCash / productBuyPrice); // calculates the amount of products that the user just purchased by taking the amount that the user spent, divided 
      buildingInventory = buildingInventory + newProducts; // adds the new products that the user bought to the building inventory
      System.out.println("You have purchased $" + subCash + " worth of inventory, or " + newProducts + " products!"); 
      successful = 1; // as the purchase was successful, the successful variable is set to 1 (true)
    }
    holder[0] = successful; // sets the first index of the holder array to the successful variable
    holder[1] = currentCash; // sets the second index of the holder array to the current cash variable
    holder[2] = buildingInventory; // sets the third index of the holder array to the building inventory
    return holder; // as this is a functional method, it returns back a int[] array, named holder
  } // purchasing process method


  public int[] levelProcess (int userLevel, int currentCash, int numOfBuildings, int buildingLevel, int demand, int cash, int addDemand){ // functional method that does the calculations for when a user levels up
    currentCash = currentCash + cash; // when the user levels up, the user receives a bonus, which is what cash represents
    userlevel++; // the user level increments by 1
    successful = 1; // as the user was able to level up, the successful variable is set to 1 (true)
    levelSign(); // calls the levelSign method, which displays a large level up sign
    System.out.println("You have reached level " + userlevel + "!");
    System.out.println("You have $" + currentCash + " dollars");
    System.out.println("Your demand for all of your buildings has increased by: " + addDemand);
    holder2[0] = successful; // sets the first index of the holder2 array to the successful variable
    holder2[1] = userLevel; // sets the second index of the holder2 array to the userLevel variable
    holder2[2] = currentCash; // sets the third index of the holder2 array to the currentCash variable
    holder2[3] = addDemand; // sets the fourth index of the holder2 array to the add demand varaible
    return holder2; // as this is a functional method, this returns a int[] array, named holder2
  } // level process method

  public int[] levelUp (int level, int currentCash, int numOfBuildings, int buildingLevel, int demand){ // functional method that is the main house for the user leveling up
    successful = 0; // sets the successful variable to 0
    if (level == 1){ // checks if the user is currently at level 1
      if (currentCash >= 150000 && numOfBuildings == 3 && buildingLevel == 2){ // checks if the user has the requirements for leveling up
        holder2 = levelProcess(level, currentCash, numOfBuildings, buildingLevel, demand, 50000, 50); // calls the level process method, which does the leveling up process, and assigns the value to the holder array
      }
    } else if (level == 2){ // checks if the user is currently at level 2
      if (currentCash >= 400000 && numOfBuildings == 6 && buildingLevel == 4){ // checks if the user has the requirements for leveling up
        holder2 = levelProcess(level, currentCash, numOfBuildings, buildingLevel, demand, 200000, 250); // calls the level process method, which does the leveling up process, and assigns the value to the holder array
      }
    } else if (level == 3){ // checks if the user is currently at level 3
      if (currentCash >= 700000 && numOfBuildings == 10 && buildingLevel == 6){ // checks if the user has the requirements for leveling up
        holder2 = levelProcess(level, currentCash, numOfBuildings, buildingLevel, demand, 500000, 1000); // calls the level process method, which does the leveling up process, and assigns the value to the holder array
      }
    } else if (level == 4){ // checks if the user is currently at level 4
      if (currentCash >=1000000 && numOfBuildings == 15 && buildingLevel == 8){ // checks if the user has the requirements for leveling up
        holder2 = levelProcess(level, currentCash, numOfBuildings, buildingLevel, demand, 800000, 2000); // calls the level process method, which does the leveling up process, and assigns the value to the holder array
      }
    }
    holder2[0] = successful; // sets the first index of the holder array to the successful variable
    holder2[1] = level; // sets the second index of the holder array to the level variable
    holder2[2] = currentCash; // sets the third index of the holder array to the current cash variable
    holder2[3] = demand; // sets the fourth index of the holder array to the demand variable
    return holder2; // as this is a functional method, this returns a int[] array, named holder
  } // level up method

  public void buildingDetails (int currentCash, int numOfBuildings, int viewBuilding, int buildingRevenue, int buildingLevel, int buildingSqFt, int buildingDemand, int buildingExpenses, int buildingMaxShelfInventory, int buildingEmployees, int buildingShelfInventory, int buildingWorth, int buildingInventory) { // a procedural method that takes the details of the building that the user is viewing, and displays it back to the user
    System.out.println("\nYou have $" + currentCash + " dollars");
    System.out.println("You have " + numOfBuildings + " building(s)");
    System.out.println("\n<---------------------< Building Details >-------------------->\n");
    System.out.println("The building that you are currently viewing is #" + (viewBuilding + 1) + "!");
    System.out.println("The amount of revenue that this building has made today is: " + buildingRevenue + "!");
    System.out.println("The current level of this building is: " + buildingLevel + "!");
    System.out.println("The current square feet of this building is: " + buildingSqFt + "sqft!");
    System.out.println("The current demand of this building is: " + buildingDemand + "!");
    System.out.println("The current expenses of this building is: $" + buildingExpenses + "!");
    System.out.println("The current amount that your shelfs can hold is: " + buildingMaxShelfInventory + " products!");
    System.out.println("The amount of inventory that is OFF of the shelf is: " + buildingInventory + " products!");
    System.out.println("The current amount of employees this building has is: " + buildingEmployees + "!");
    System.out.println("The current amount that is on your shelf right now is: " + buildingShelfInventory + " products!");
    System.out.println("This current amount that this building is worth is: $" + buildingWorth + "!");
  } // buildingDetails method
  
  public void buildingLevel (int[] buildingLevel, int numOfBuildings){ // a procedural method that takes the level of the building that the user is viewing, and prints out a text based building based on the amount of levels that the building has
    for (counter = 0; counter < numOfBuildings; counter++){ // runs through all of the buildings
      System.out.println(" ____________");
      System.out.println("/_________//|");
      for (int counter2 = 0; counter2 < buildingLevel[counter]; counter2++){ // runs through all of the buildings' levels
        System.out.println("|  + - +  |/|");
      } // for loop
      System.out.println(" -----------");
    }
  } // building level method
  
  public int[] employees (int currentCash, int downPayment, int buildingEmployees, int addEmployees){ // a functional method that runs through the process of hiring employees
    successful = 0; // sets the successful variable to 0
    if (currentCash <= downPayment){ // if the users cash is less than the down payment of hiring the employee(s)
      System.out.println("You do not have enough money to hire an employee, please try again later");
    } else { // if the user is able to afford the down payment for hiring the employees
    currentCash = currentCash - downPayment; // subtracts the amount that the user has to pay in a down payment from the users cash
    buildingEmployees = buildingEmployees + addEmployees; // the buildings employees increase by the amount of employees that the user hired
    System.out.println("You have successfully hired " + addEmployees + " employee(s)! You now have " + buildingEmployees + " employee(s) at this building!");
      successful = 1; // as this operation was successful, the successful variable is set to 1 (true)
    }
    holder[0] = successful; // sets the first index of the holder array to the successful variable
    holder[1] = currentCash; // sets the second index of the holder array to the current cash variable
    holder[2] = buildingEmployees; // sets the third index of the holder array to the building employees variable
    return holder; // as this is a functional method, it returns a int[] array, named holder
  } // hiring employees method
  
  public int[] loanProcess (int currentCash, int totalExpenses, int loanAmount, double loanInterest){ // a functional method that runs through the process of get a loan
    successful = 1; // sets the successful variable to 1
    currentCash = currentCash + loanAmount; // the users cash increases by the amount that the user wants to take out as a loan
    totalExpenses = totalExpenses +  (int) (loanAmount * loanInterest); // adding the loan amount plus 5% interest to the users total expenses
    System.out.println("You have successfully taken out a loan of $1,000!");
    System.out.println("Your current cash is now: " + currentCash + "!");
    System.out.println("You can pay off this loan at the end of the month when it asks you to pay off all of your expenses!");
    holder[0] = currentCash; // sets the first index of the holder array to the current cash variable
    holder[1] = totalExpenses; // sets the second index of the holder array to the total expenses
    holder[2] = successful; // sets the third index of the holder array to the successful variable
    return holder; // as this is a functional method, this returns a int[] array, name holder
  } // loan process method

  public int[] read() { // a functional method that reads the data from the saveGame.txt file
    try { // try statement
      counter = 0; // counter is set to 0
      String line; // declares a string variable called line
      BufferedReader input; // declares a buffered reader variable called input
      input = new BufferedReader(new FileReader("saveGame.txt")); // initializes the buffered reader variable called input to read from the saveGame.txt file
      while ((line = input.readLine()) != null) { // while the line is not null
        previousResults[counter] = Integer.parseInt(line); // the previous results array is set to the line variable, which is an integer
        counter++; // counter increments by 1
      } // while loop
      input.close(); // closes the buffered reader variable called input
    } catch (FileNotFoundException e) { // catch statement
      System.out.println("Error, file not found!");
    } catch (IOException e) { //catch statement
      System.out.println("Error reading from file " + e.getMessage());
    } catch (Exception e) { // catch statement
      System.out.println("An unexpected error happened " + e.getMessage());
    } // end of last catch statement
    if (counter == 1){ // if the counter is equals to 1, that means that the user has not saved any progress
      for (counter = 0; counter < 200; counter++){ // runs through all of the indexs of the array
        previousResults[counter] = 0; // sets the value to 0
      } // for loop
    } // if statement
    return previousResults; // as this is a functional method, this returns a int[] array, named previousResults
  } // read from file method 

  public void saveGame (int day, int currentCash, int[] buildingExpenses, int[] buildingShelfInventory, int[] buildingInventory, int[] buildingLevel, int[] buildingDemand, int[] buildingWorth, int[] buildingSqFt, int[] buildingRevenue, int[] buildingEmployees, int[] buildingMaxShelfInventory, int viewBuilding, int numOfBuildings, int userLevel){ // a procedural method that saves the progress of the user
    int counter = 0; // sets the counter variable to 0
    try { // try statement
      BufferedWriter output; // declares a buffered writer variable called output
      output = new BufferedWriter(new FileWriter("saveGame.txt")); // initializes the buffered writer variable called output to write to the saveGame.txt file
      // writes all of the non array, integer values to the file
      output.write(day + "\n"); // writes the day variable to the file
      output.write(currentCash + "\n"); // writes the current cash to the file
      output.write(viewBuilding + "\n"); // writes the view building number to the file
      output.write(numOfBuildings + "\n"); // writes the number of buildings to the gile
      output.write(userLevel + "\n"); // writes the user level to the file
      // writes all of the array values to the file
      for (counter = 0; counter < numOfBuildings; counter++) { // runs through the amount of buildings that the user has
        output.write(buildingExpenses[counter] + "\n"); // writes each buildings expenses to the file
        output.write(buildingShelfInventory[counter] + "\n"); // writes each buildings shelf inventory to the file
        output.write(buildingInventory[counter] + "\n"); // writes each buildings inventory to the file
        output.write(buildingLevel[counter] + "\n"); // writes each buildings level to the file
        output.write(buildingDemand[counter] + "\n"); // writes each buildings demand to the file
        output.write(buildingWorth[counter] + "\n"); // writes each buildings worth to the file
        output.write(buildingSqFt[counter] + "\n"); // writes each buildings square feet to the file
        output.write(buildingRevenue[counter] + "\n"); // writes each buildings revenue to the file
        output.write(buildingEmployees[counter] + "\n"); // writes each buildings employees to the file
        output.write(buildingMaxShelfInventory[counter] + "\n"); // writes each buildings max shelf inventory to the file 
      } output.close(); // closes the buffered writer variable called output
    } catch (IOException e) { // catch statement
      System.out.println("Error with writing to the file!");
      e.printStackTrace(); // prints the error
    }
  }
}
