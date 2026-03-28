/* Gurnit Chopra
   Friday, June 7, 2024
   This game is a business tycoon game, The user will start off with a decent amount of resources to run their business for a fair amount of time. As the game progresses, the user can make financial decisions to futher increase the success of their business, gain levels, make more buildings, upgrade those buildings, and more. The user will be able to choose from mutiple different actions in which they think will be they best for their business. 
*/
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in); // definning scanner, to access input from the user

    Business business = new Business(); // creating a new business object

//----------------------Declaring variables and arrays--------------------//
    
    //with the arrays that have building at the beginning of the name, it is to show the user the exact stat of the building, so that the user can see the exact amount of such that each building has.
    String userChoice = "1";
    String userName = "";
    String lostGame = "";
    String exitProgram = "n"; // this variable is used to exit the program
    int userChoiceNum = 0; // this will be used throughout the code to take the users input
    int counter = 0;
    int holder = 0; // a holder variable, which is used very temporarily within some parts of the code
    int holder3 = 0; // a holder variable, which is used very temporarily within some parts of the code
    int currentCash = (int) (Math.random() * (60000 - 40000 + 1) + 40000);
    int userLevel = 1; // to store the users level
    int buildingLevelCost = 50000; // This is the cost to upgrade a building
    int numOfBuildings = 1; // the number of buildings that the user has
    int totalExpenses = 0; // the total expenses of the user, which is calculated at the end of the month
    int day = 1; // represents the day
    int buildingCost = 0; // represents the amount that the user has to spend to purchase a new building
    int viewBuilding = 0; // the user can only monitor 1 building at a time, viewBuilding is used to monitor the building
    int addDemand = 0; // demand is esstienally the number of products that the user sells per day
    int newProducts = 0; // this is the number of products that the user buys
    int profitBoosterActive = 0; // these booster active variables are used to show whether or not the booster is active or not
    int expenseReliefActive = 0;
    int buildingIncentiveActive = 0;
    int purchaseReliefActive = 0;
    int profitBoosterUsable = 1; // these booster usable variables are used to show whether the booster is usable or not
    int expenseReliefUsable = 1;
    int buildingIncentiveUsable = 1;
    int purchaseReliefUsable = 1;
    int productBuyPrice = (int) (Math.random() * (160 - 130 + 1) + 130); // the price of the product that the user is buying is a random number between 130 and 160
    int productSellPrice = (int) (Math.random() * (225 - 175 + 1) + 175); // the price of the product that the user is selling is a random number between 175 and 225
    int newBuildingSqFt = (int) (Math.random() * (1500 - 1000 + 1) + 1000); // when a new building is purcahsed, the square footage of the new building is a random number between 1000 and 1500
    int newBuildingInventory = (int) ((Math.random() * (7500 - 5000 + 1) + 5000) / productBuyPrice); // the starting inventory that the user recieves is a random number dollar value between 7500 and 5000, which is then dividing by the product buy price, which then gives us the number of products that is in inventory
    int [] holder2 = new int [10]; // this array is used to store the return values of varies methods
    int [] buildingLevel = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}; // holds the value of the buildings' level
    int [] buildingDemand = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}; // holds the value of each of the buildings demand
    int [] buildingExpenses = {1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000}; // holds the value of each of the buildings expenses
    int [] buildingRevenue = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // hold the values of each of the buildings revenue
    int [] buildingInventory = {newBuildingInventory,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // hold the values of each of the buildings inventory
    int [] buildingShelfInventory = {30,30,30,30,30,30,30,30,30,30,30,30,30,30,30}; // hold the values of each of the buildings shelf inventory
    int [] buildingMaxShelfInventory = {30,30,30,30,30,30,30,30,30,30,30,30,30,30,30}; // holds the values of each of the buildings max shelf inventory
    int [] buildingSqFt = {newBuildingSqFt,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // the first building has a random square footage between 1000 and 1500
    int [] buildingEmployees = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // holds the value of each of the buildings employees
    int [] buildingWorth = {100000,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // holds the value of each of the buildings worth, with the first one being 100,000
    int [] previousResults = new int[200]; // this array is used to store the previous results of the user

//----------------------Introduction to the game----------------------------//

    previousResults = business.read(); // reads the saveGame.txt file
    
    System.out.println("Welcome to Rise and Prosper!");
    System.out.println("\nMay I have your name?");
    userName = input.nextLine();
    System.out.println("\nHello, " + userName + "! You are a business owner and you have just started a business! \nYou have $" + currentCash + " dollars, " + numOfBuildings + " building and a dream!\nYour job is to make sure that your business is running smoothly! \nYour main goal is to make your business big, profitable, and successful! \nYou will have to make smart, financial decisions, and make sure that you are \nable to keep your business a float, Good luck!");
    System.out.println("\nPress 1 to view the tutortial, or press 2 to start the game:");
    userChoice = input.nextLine(); // asking the user to press 1 to start the game

    if (userChoice.equals("1")){ // if the user wants to view the tutorial
      System.out.println("\n<----------------------< Tutorial >-------------------------->\n");
      System.out.println("Welcome to the tutorial! \nIn this game, you will be able to make financial decisions to further increase the success of your business! \nYou will also be able to make decisions to upgrade your buildings, and make sure that your business is running smoothly! \nLets go through some of the possible misconceptions of the game, first lets address demand. Demand increases over time, and what demand represents is the amount of products that you sell every day, the higher demand, the more products you sell, the more products you sell, the more money you make. Next, whenever you buy a building, you are going to instantly 'view' that building, at the end of the day when you want to close your business, you can choose if you want to view that new building. To add, paying off a loan can only be done at the end of the month.\nNow Lets go through the different actions that you can perform. \n#1 is simple, if your business inventory is low on inventory, you can purchase more inventory! \n#2 is also simple, as the days go by, the shelves in your building slowly become empty as you sell your products! So you may want to restock your inventory. \n#3 is a bit more complicated, as you expand and grow your business, your expenses will increase! At the start of the game, you will start off will $1000 in expenses that you should pay off within the first month. \n#4 is also a bit more complicated, if you want to expand your buildings, or purchase a new one, you can enter this option to do so! \n#5 If you want to hire employees, then you can do so here, but keep in mind that it costs $2500 upfront and $3000 monthly, but you recieve more money in return over time. \n#6 You have 4 different boosters that can help you with different things, but remember, the boosters wear off by the end of the day! \n#7 If you want to see the current stats of the building that you are currently viewing, you can do so here! \n#8 its simple, if you want to get a loan, you can get a loan, but keep in mind that at the end of the month, you should pay it off, as all expenses increase if you do not pay it off within the first month! To pay off a loan, you need to pay off the 'total expenses' tab. \n#9 If you want to recieve more money from your business revenue, you may want to close the business for the day, but as explained before there are downsides to doing this. \n#10 If you want to exit the program. \n#11 If you want to save and exit the program.");
      System.out.println("\n<----------------------< End of Tutorial >---------------------->\n");
      System.out.println("Press 2 to start the game: ");
      userChoice = input.nextLine(); // asks if the user wants to continue and play the game
    } if (userChoice.equals("2")){ // if the user presses 1, the game will start

      business.buildingDetails(currentCash, numOfBuildings, viewBuilding, buildingRevenue[viewBuilding], buildingLevel[viewBuilding], buildingSqFt[viewBuilding], buildingDemand[viewBuilding], buildingExpenses[viewBuilding], buildingMaxShelfInventory[viewBuilding], buildingEmployees[viewBuilding], buildingShelfInventory[viewBuilding], buildingWorth[viewBuilding], buildingInventory[viewBuilding]); // this method is used to display the details of the user's business, and the user's current cash, number of buildings, and the view building number
      System.out.println("You are able to use either any of the 4 boosters: Profit booster, Expense relief, Building incentive, and Purchase relief");
      System.out.println("\n<--------------------------------------------------------------->\n");

      if (previousResults[0] > 0){ // checking if the day in the previous saved game is greater than 1
        System.out.println("\nWould you like to load a previous saved run? (y/n)");
        userChoice = input.nextLine(); // asking the user if they would like to load a previous run
        if (userChoice.equalsIgnoreCase("y")){ // if the user's answer was y
          day = previousResults[0]; // the day is set to what was in the previous run
          currentCash = previousResults[1]; // the cash is set to what was in the previous run
          viewBuilding = previousResults[2]; // the view building is set to what was in the previous run
          numOfBuildings = previousResults[3]; // the number of buildings is set to what was in the previous run
          userLevel = previousResults[4]; // the users level is set to what was in the previous run
          for (counter = 0; counter < numOfBuildings; counter++){ // this runs for the amount of buildings that the user had
            buildingExpenses[counter] = previousResults[(10 * counter) + 5]; // the expenses of each of the buildings is set to what was in the previous run
            buildingShelfInventory[counter] = previousResults[(10 * counter) + 6]; // the buildings shelf inventory is set to what was in the previous run
            buildingInventory[counter] = previousResults[(10 * counter)  + 7]; // the buildings inventory is set to what was in the previous run
            buildingLevel[counter] = previousResults[(10 * counter)  + 8]; // the buildings level is set to what was in the previous run
            buildingDemand[counter] = previousResults[(10 * counter)  + 9]; // the buildings demand is set to what was in the previous run
            buildingWorth[counter] = previousResults[(10 * counter) + 10]; // the buildings worth is set to what was in the previous run
            buildingSqFt[counter] = previousResults[(10 * counter)  + 11]; // the buildings square footage is set to what was in the previous run
            buildingRevenue[counter] = previousResults[(10 * counter) + 12]; // the buildings revenue is set to what was in the previous run
            buildingEmployees[counter] = previousResults[(10 * counter) +13]; // the buildings employees is set to what was in the previous run
            buildingMaxShelfInventory[counter] = previousResults[(10 * counter) + 14]; // the buildings max shelf inventory is set to what was in the previous run
          } // for num of buildings
        } // if user choice
      }  //  if previous result
      
      System.out.println("Do you want to start with day " + day + "? (y/n)");
      userChoice = input.nextLine(); // asking the user if they want to start with day 1
      if (userChoice.equalsIgnoreCase("y")){ // if the user enters y (yes) to starting day 1, then the game will start (the if statement will run)
        while (exitProgram.equalsIgnoreCase("n")){ // this while loop will run until the user enters y (yes) for exiting the program

//-----------------------------------------User leveling up-------------------------------------------//

          holder2[0] = 0;
          
          holder2 = business.levelUp(userLevel, currentCash, numOfBuildings, buildingLevel[viewBuilding], buildingDemand[viewBuilding]); // this method is used to check if the user can level up, if yes, then proceeds with the level up process
          // this is the return value of the levelUp method, which will return the userLevel, currentCash, numOfBuildings, buildingLevel, and buildingDemand
          if (holder2[0] == 1){ // if the user leveled up, then the value of the first index would be 1, as it would be set to successful
            // if the first value of the holder2 array is 1 (which means that the level up was successful)
            // then the userLevel, currentCash, numOfBuildings, buildingLevel, and buildingDemand will be updated
            userLevel = holder2[1]; // the user level is set to the second index of the array
            currentCash = holder2[2]; // the users current cash is set to the third index of the array
            addDemand = holder2[3]; // the users add demand is set to the fourth index of the array
            System.out.println("As you have leveled up, you have regained access to all of the boosters that you have used in the previous level!");
            for (counter = 0; counter < numOfBuildings; counter++){ // for loop runs for the number of buildings that the user has
              buildingDemand[counter] = buildingDemand[counter] + addDemand; // sets the demand for each one of the buildings to the demand that has been set from the method
            }
            // setting all of the boosters active back to 1, as the user has leveled up
            profitBoosterUsable = 1;
            expenseReliefUsable = 1;
            buildingIncentiveUsable = 1;
            purchaseReliefUsable = 1;
          } // if the user leveled up
          
          if (userChoiceNum == 9){ // Checks if the user ended the day, then proceeds with the revenue process
            productSellPrice = (int) (Math.random() * (225 - 175 + 1) + 175); // the price of the product that the user is selling is a random number between 175 and 225
            productBuyPrice = (int) (Math.random() * (160 - 130 + 1) + 130); // the price of the product that the user is buying is a random number between 130 and 160
            for (counter = 0; counter < numOfBuildings; counter++){ // runs through all of the buildings
              holder = buildingShelfInventory[counter] - buildingDemand[counter]; // this calculates the amount that should be on the shelf
              if (holder < 0){ // if the amount of shelf subtract the demand is less than 0, then this run
                holder3 = buildingDemand[counter] + holder; // this ensures that the amount on the shelf is 0, not negative
                buildingRevenue[counter] = (int) (holder3 * productSellPrice); // takes the amount that was actually on the shelf, and multiplies it by the product sell price, to get the buildings revenue
                buildingShelfInventory[counter] = 0; // as the demand was higher than the amount that was on the shelf, the shelf inventory is set to 0
              } else { // if the amount on the shelf is greater than the demand
                buildingShelfInventory[counter] = buildingShelfInventory[counter] - buildingDemand[counter]; // calculates the amount that was taken off the shelf
                buildingRevenue[counter] = (int) (buildingDemand[counter] * productSellPrice); // takes that amount, and multiplies it by the product price to get the buildings revenue
              }
              currentCash = currentCash + buildingRevenue[counter]; // adds the amount of revenue to the users cash
              if (profitBoosterActive == 1){ // if the user currently has a profit booster active, then this will run
                for (counter = 0; counter < numOfBuildings; counter++){ // runs through all of the buildings
                  holder3 = (int) (buildingRevenue[counter] * 0.25); // takes a quarter of what the building made that day
                  currentCash = currentCash + holder3; // adds it to cash
                  System.out.println("Since you have a profit booster active, for building #" + (counter + 1) + " you have gained $" + holder3 + "!");
                } // for loop
              } // if profit booster active
            }
          }
          if (currentCash < 0){ // checks if the user's cash is less than 0
            System.out.println("As you do not have enough money to perform any actions within the game, you have until the end of the month to have your cash above $0! If not, then you have lost the game!");
          }
//-----------------------------Monthly Report & Expenses--------------------------------------//

          if (day == 30){ // checks if it is the end of the month
            System.out.println("\n<----------------------< Monthly Report >-------------------------->\n");

            day = 1; // resets the day back to 1
            System.out.println("You have reached the end of the month! The day has been reset back to 1.");
            System.out.println("You have $" + currentCash + " dollars!");
            // buildings worth
            for (counter = 0; counter < numOfBuildings; counter++){ // runs through all of the buildings
              buildingWorth[counter] = (int) ((buildingLevel[counter] - 1) * 50000); // adds the amount of levels that the building has to the buildings worth (not including the first one)
              buildingWorth[counter] = 100000; // adds 100000 for every building that the user owns
              buildingWorth[counter] = (int) (buildingWorth[counter] * 1.1); // adds 10% to all of the buildings worth (realistic)
              System.out.println("The worth of your #" + (counter + 1) + " building now is: " + buildingWorth[counter]);
              System.out.println("In building #" + (counter + 1) + " you have " + buildingShelfInventory[counter] + " products on the shelf, and " + buildingInventory[counter] + " off the shelf.");
            }
                                      //--EXPENSES--//
            
            for (counter = 0; counter < numOfBuildings; counter++){ // runs through all of the buildings
              buildingExpenses[counter] = buildingExpenses[counter] + (int) (buildingEmployees[counter] * 3000); // wages monthly cost
              buildingExpenses[counter] = (buildingExpenses[counter] + 1000); // building monthly cost
              currentCash = currentCash + (buildingEmployees[counter] * 4000); // takes the amount of employees per building and multiplies it by 4000, then adds it to the current cash
              if (buildingEmployees[counter] > 0){ // if the user does have 1 or more employees in the building at counter
                System.out.println("\nWith you having " + buildingEmployees[counter] + " employees, you have made $" + (buildingEmployees[counter] * 4000) + " from your employees' work!");
              }
              for (int counter2 = 0; counter2 < buildingLevel[counter]; counter2++) { // this for loop runs through all of the levels for each building
                buildingExpenses[counter] = (buildingExpenses[counter] + 600); // building level expense cost
              }
              System.out.println("The expenses of building #" + (counter + 1) + " is: " + buildingExpenses[counter]);
            }

            System.out.println("Would you like to pay off all of your expenses from all of your buildings? (y/n)");
            userChoice = input.nextLine(); // asking the user if they would like to pay off all of their expenses
            if (userChoice.equalsIgnoreCase("y")){ // if the user entered y (yes)
              for (counter = 0; counter < numOfBuildings; counter++){ // runs through all buildings
                totalExpenses = totalExpenses + buildingExpenses[counter]; // adds all of the buildings expenses to this variable
              }
              if (totalExpenses > currentCash){ // if the users current cash is less than the amount in expenses that the user wants to pay
                System.out.println("With the total amount of expenses being " + totalExpenses + ", and with you having $" + currentCash + "you are unable to pay off all of your expenses.");
                for (counter = 0; counter < numOfBuildings; counter++){ // runs through all of the buildings
                  buildingExpenses[counter] = (int) (buildingExpenses[counter] * 1.2); // adds 20% to all of the expenses (realistic), as the user was not able to pay
                  System.out.println("Since you were not able to pay your expenses within the month, your expenses for building " + (counter + 1) + " has risen to " + buildingExpenses[counter]);
                }
              } else { // if the users current cash is greater than the amount in expenses that the user wants to pay
                currentCash = currentCash - totalExpenses; // subtracts the users cash from all of their expenses
                System.out.println("You have paid off all of your expenses! You now have $" + currentCash + " dollars!");
                for (counter = 0; counter < numOfBuildings; counter++){ // runs through all of the buildings
                  buildingExpenses[counter] = 0; // sets their expenses to 0
                }
              }
            } else if (userChoice.equalsIgnoreCase("n")){ // if the user entered n (no)
              totalExpenses = 0; // sets the amount in total expenses to 0
              System.out.println("As you do not want to pay off all of your expenses, the expenses of all of your buildings have been increased by 20%! Below is the new expenses for each of your buildings.");
              for (counter = 0; counter < numOfBuildings; counter++){ // runs through all of their buildings
                buildingExpenses[counter] = (int) (buildingExpenses[counter] * 1.2); // increases each of the buildings expenses by 20%
                System.out.println("Building #" + (counter + 1) + ": $" + buildingExpenses[counter]);
                totalExpenses = totalExpenses  + buildingExpenses[counter]; // adds the expense amount to the total expenses variable
              }
              System.out.println("The expenses from all of your building(s) has come to: " + totalExpenses + "!");
              System.out.println("\n<--------------------------------------------------------------->\n");
            } if (currentCash < 0 || totalExpenses > buildingWorth[viewBuilding]){ // checks if the users cash is less than 0, or if the total expenses is greater than a buildings worth, just as a thing to refer to justify if the user is in a lot of debt
              lostGame = "y"; // set the lost game variable to y (yes)
              System.out.println("As your unable to pay anything with your financial position, you have lost the game!");
            }
          }
          if (profitBoosterActive == 1 && userChoiceNum == 9 || expenseReliefActive == 1 && userChoiceNum == 9 || buildingIncentiveActive == 1 && userChoiceNum == 9 || purchaseReliefActive == 1 && userChoiceNum == 9){ // if any of the boosters were active, and the user chose to enter into a new day, then this will run
          System.out.println("As this is the start of a new day, your boosters that you used in the previous day, have been set to inactive.");
          profitBoosterActive = 0; // sets all of the boosters to inactive, as it is a new day
          expenseReliefActive = 0;
          buildingIncentiveActive = 0;
          purchaseReliefActive = 0;
        }

          for (counter = 0; counter < numOfBuildings; counter++){ // runs through all of the buildings
            buildingWorth[counter] = (int) ((buildingLevel[counter] - 1) * 50000); // adds the amount of levels that the building has to the buildings worth (not including the first one)
            buildingWorth[counter] = 100000; // adds 100000 for every building that the user owns
          }
          
//------------------------------------daily menu------------------------------//

          System.out.println("\n<----------------------< New Ticket >-------------------------->\n");
          
          if (day == 1){ // informs the user if it is their first day that they will not be making any money
            System.out.println("\nAs this is your first day, your business will not be making any money.");
          }
          System.out.println("\nDay #" + day + "!\n");
          System.out.println("\nYour building(s):");
          // prints a text based version of their buildings
          business.buildingLevel(buildingLevel, numOfBuildings); // calls the building level method which prints back to the user a text based version of how their building looks

          System.out.println("\nYou have $" + currentCash + " dollars");
          System.out.println("\nThis building has made $" + buildingRevenue[viewBuilding] + " dollars today!\n");
          System.out.println("The market: \n");
          System.out.println("Buying products today is: $" + productBuyPrice + " dollars per product");
          System.out.println("Selling products today is: $" + productSellPrice + " dollars per product\n");
          System.out.println("\nFor this new day as you are viewing your #" + (viewBuilding + 1) + " building. Choose an option between 1-11:\n");
          System.out.println("1) Want to purchase more inventory?");
          System.out.println("2) Want to restock your shelves with your inventory?");
          System.out.println("3) Want to pay off the expenses for this building?");
          System.out.println("4) Want to expand your buildings?");
          System.out.println("5) Want to hire employees?");
          System.out.println("6) Want to use an Efficiency Booster?");
          System.out.println("7) Want to see the details of your building?");
          System.out.println("8) Want to get a loan?");
          System.out.println("9) Close the business for the day?");
          System.out.println("10) Would you like to exit the program?");
          System.out.println("11) Would you like to exit the program & save progress?");
          System.out.println("\nEnter the number of the option that you want to choose: ");
          if (lostGame.equals("n")){
            userChoiceNum = 10; // sets the user choice number to 10, which is to exit the program
          } else {
            userChoiceNum = input.nextInt(); // asks the user to enter the number of the option that they would like to pursue
            input.nextLine(); // clears the input
          }

//----------------------------------------------Option 1------------------------------------------//

          if (userChoiceNum < 1 || userChoiceNum > 11){ // checks if the user inputted an invalid number
            System.out.println("\nInvalid number, please try again");
          } else if (userChoiceNum == 1){ // if the user enters 1, then the user will be able to purchase more inventory
            System.out.println("\nHow much inventory would you like to purchase? (0 to cancel)\n");
            System.out.println("1) $500?");
            System.out.println("2) $1000?");
            System.out.println("3) $2000?");
            System.out.println("4) $5000?");
            System.out.println("5) $10000?");
            System.out.println("6) $50000?");
            System.out.println("7) $250000?");
            userChoiceNum = input.nextInt(); // asks the user to enter the number of the option that they would like to pursue
            if (userChoiceNum < 1 || userChoiceNum > 7){ // checks if the user inputted an invalid number
              System.out.println("\nInvalid number, please try again");
            } else if (userChoiceNum == 1){ // if the user enters 1, then the user wants to purchase $500 worth of inventory
              holder2 = business.purchasingProcess(currentCash, 500, newProducts, productBuyPrice, buildingInventory[viewBuilding], expenseReliefActive); // this calls the purchasing process method, which will return the values that associate with purchasing products
            } else if (userChoiceNum == 2){ // if the user enters 2, then the user wants to purchase $1000 worth of inventory
              holder2 = business.purchasingProcess(currentCash, 1000, newProducts, productBuyPrice, buildingInventory[viewBuilding], expenseReliefActive); // this calls the purchasing process method, which will return the values that associate with purchasing products
            } else if (userChoiceNum == 3){ // if the user enters 3, then the user wants to purchase $2000 worth of inventory
              holder2 = business.purchasingProcess(currentCash, 2000, newProducts, productBuyPrice, buildingInventory[viewBuilding], expenseReliefActive); // this calls the purchasing process method, which will return the values that associate with purchasing products
            } else if (userChoiceNum == 4){ // if the user enters 4, then the user wants to purchase $5000 worth of inventory
              holder2 = business.purchasingProcess(currentCash, 5000, newProducts, productBuyPrice, buildingInventory[viewBuilding], expenseReliefActive); // this calls the purchasing process method, which will return the values that associate with purchasing products
            } else if (userChoiceNum == 5){ // if the user enters 5, then the user wants to purchase $10000 worth of inventory
              holder2 = business.purchasingProcess(currentCash, 10000, newProducts, productBuyPrice, buildingInventory[viewBuilding], expenseReliefActive); // this calls the purchasing process method, which will return the values that associate with purchasing products
            } else if (userChoiceNum == 6){ // if the user enters 6, then the user wants to purchase $50000 worth of inventory
              holder2 = business.purchasingProcess(currentCash, 50000, newProducts, productBuyPrice, buildingInventory[viewBuilding], expenseReliefActive); // this calls the purchasing process method, which will return the values that associate with purchasing products
            } else if (userChoiceNum == 7){
              holder2 = business.purchasingProcess(currentCash, 250000, newProducts, productBuyPrice, buildingInventory[viewBuilding], expenseReliefActive); // this calls the purchasing process method, which will return the values that associate with purchasing products
            } if (holder2[0] == 1){ // if the first index of the holder2 array is 1, then the user has successfully purchased the inventory, which then updates cash and inventory
              currentCash = holder2[1];
              buildingInventory[viewBuilding] = holder2[2];
            }
//-------------------------------------------Option 2------------------------------------------//

          } else if (userChoiceNum == 2){ // if the user enters 2, then the user will be able to restock their shelves with their inventory
            System.out.println("\nChoose the option that you would like to restock your shelves with: (0 to cancel)\n");
            System.out.println("1) Would you like to restock a portion of your shelves?");
            System.out.println("2) Would you like to restock your shelves entirely?");
            userChoiceNum = input.nextInt(); // asking the user if they want to restock a portion of their shelves or their entire shelves
            if (userChoiceNum < 1 || userChoiceNum > 2){ // checks if the user inputted an invalid number
              System.out.println("\nInvalid number, please try again");
            } else if (userChoiceNum == 1){ // if the user enters 1, then the user will be able to restock a portion of their shelves
              System.out.println("<-----------------< Inventory Stats >----------------->\n");
              System.out.println("The amount of inventory that you have at this building is: " + buildingInventory[viewBuilding] + " products!");
              System.out.println("The amount that you shelves can hold is " + buildingMaxShelfInventory[viewBuilding] + " products!");
              System.out.println("And currently the amount that is on your shelf is " + buildingShelfInventory[viewBuilding] + " products!");
              System.out.println("<----------------------------------------------------->");
              System.out.println("\nAre you sure you would like to restock? If yes, then by how much? (0 to cancel)");
              userChoiceNum = input.nextInt(); // asking the user how much they want to restock
              if (userChoiceNum > (buildingMaxShelfInventory[viewBuilding] - buildingShelfInventory[viewBuilding]) || userChoiceNum <= 0){ // checks if the user inputted an invalid number
                System.out.println("\nExiting... please try again");
              } else { // if the user inputted a valid number, then the user will be able to restock their shelves
                buildingShelfInventory[viewBuilding] = buildingShelfInventory[viewBuilding] + userChoiceNum; // adds the user's input to the amount of inventory that is on their shelf
                buildingInventory[viewBuilding] = buildingInventory[viewBuilding] - userChoiceNum; // subtracts the user's input from the amount of inventory that is at the building
                System.out.println("You have successfully restocked your shelves, your shelves now have " + buildingShelfInventory[viewBuilding] + " inventory on them");          
                userChoiceNum = 0; // in case the user enters a number like 9 where it runs portions of the code that the user didnt want to run
              }
            } else if (userChoiceNum == 2){ // if the user enters 2, then the user will be able to restock their shelves entirely
              if (buildingInventory[viewBuilding] < (buildingMaxShelfInventory[viewBuilding] - buildingShelfInventory[viewBuilding])){ // checks if the user has enough inventory off the shelf to restock their shelves, or if the shevles are full
                System.out.println("The amount of inventory that you have is not enough to restock your shelves, please try again");
              } else { // if the user is able to restock their shelves
                System.out.println("Are you sure you would like to restock your shelves entirely? (0 to cancel, 1 to go ahead)");
                userChoiceNum = input.nextInt(); // asking the user if they want to restock their shelves entirely
                if (userChoiceNum == 1){ // checks if the user wants to go ahead
                  holder3 = buildingShelfInventory[viewBuilding]; // sets the holder variable to what is on the shelf
                  buildingShelfInventory[viewBuilding] = buildingMaxShelfInventory[viewBuilding]; // sets the shelf to the maximum amount that the shelf can hold
                  buildingInventory[viewBuilding] = buildingInventory[viewBuilding] - (buildingMaxShelfInventory[viewBuilding] - holder3); // updates the building inventory to reflect the change
                  System.out.println("You have successfully restocked you shelves!");
                  System.out.println("Your shelves now have " + buildingShelfInventory[viewBuilding] + " inventory on them!");
                  System.out.println("You now have " + buildingInventory[viewBuilding] + " products at your building");
                } else { // if the user does not want to go ahead
                  System.out.println("Exiting... please try again");
                }
              }
            }
//------------------------------------------------Option 3-----------------------------------------------//

          } else if (userChoiceNum == 3){ // if the user enters 3, then the user will be able pay off a portion of their expenses, or pay it off entirely
            System.out.println("\nYou currently have $" + buildingExpenses[viewBuilding] + " in expenses. Enter which option you would like to choose: (0 to cancel)\n");
            System.out.println("1) Would you like to pay off a portion of your expenses from this building?");
            System.out.println("2) Would you like to pay off your entire expenses from this building?");
            userChoiceNum = input.nextInt(); // asking the user if they want to pay off a portion of their expenses or their entire expenses
            if (userChoiceNum < 1 || userChoiceNum > 2){ // checks if the user inputted an invalid number
              System.out.println("\nInvalid number, please try again");
            } else if (userChoiceNum == 1){ // if the user enters 1, then the user will be able to pay off a portion of their expenses
              System.out.println("\nThe amount of expenses that you have at this building is: $" + buildingExpenses[viewBuilding]);
              System.out.println("Are you sure you would like to pay off your expenses, if yes, then enter the amount that you would like to pay? (0 to cancel)");
              userChoiceNum = input.nextInt(); // asking the user how much they want to pay off
              if (userChoiceNum > buildingExpenses[viewBuilding] || userChoiceNum > currentCash || userChoiceNum <= 0){ // checks if the user inputted an invalid number
                System.out.println("\nExiting... Please try again");
              } else { // if the user inputted a valid number, then the user will be able to pay off their expenses
                buildingExpenses[viewBuilding] = buildingExpenses[viewBuilding] - userChoiceNum; // subtracts the user's input from the amount of expenses that is at the building
                currentCash = currentCash - userChoiceNum; // subtracts the user's input from the amount of cash that the user has
                if (expenseReliefActive == 1){ // checks if the expense relief booster is active, if yes, then the user will recieve a portion of the cash back from paying their expenses
                  holder = (int) (userChoiceNum * 0.25); // takes 1/4 of the expense amount
                  currentCash = currentCash + holder; // and adds it back to the users cash
                  System.out.println("With you having an expense relief booster active, you were able to save " + holder + " dollars!");
                }
                System.out.println("You have successfully paid off a portion of your expenses! Your expenses are now $" + buildingExpenses[viewBuilding]);
              }
              userChoiceNum = 0; // in case the user enters a number like 9 where it runs portions of the code that the user didnt want to run
            } else if (userChoiceNum == 2){ // if the user enters 2, then the user will be able to pay off their entire expenses
              if (buildingExpenses[viewBuilding] > currentCash){ // checks if the user has enough money to pay off their expenses
                System.out.println("You do not have enough money to pay off your expenses, please try again");
              } else { // if the user is able to pay off their expenses
                System.out.println("Are you sure you would like to pay off your building expenses ($" + buildingExpenses[viewBuilding] + ") entirely? (0 to cancel, 1 to go ahead)");
                userChoiceNum = input.nextInt(); // asks the user if they are sure in paying off their building expenses
                if (userChoiceNum == 1){ // checks if the user wants to go ahead
                  if (buildingExpenses[viewBuilding] == 0){
                    System.out.println("You have already paid off your expenses!");
                  } else {
                    if (expenseReliefActive == 1){ // checks if the expense relief booster is active, if yes, then the user will recieve a portion of the cash back from paying their expenses
                      holder = (int) (buildingExpenses[viewBuilding] * 0.25); // takes 1/4 of the expense amount
                      currentCash = currentCash + holder; // and adds it back to the users cash
                      System.out.println("With you having an expense relief booster active, you were able to save " + holder + " dollars!");
                    }
                    currentCash = currentCash - buildingExpenses[viewBuilding]; // subtracts the amount of expenses that is at the building from the amount of cash that the user has
                    buildingExpenses[viewBuilding] = 0; // sets the amount of expenses that the user is viewing to 0
                    System.out.println("You have successfully paid off your expenses!");
                  }
                } else { // if the user typed in something other than 1
                  System.out.println("Exiting... please try again");
                }
              }
            }

//--------------------------------------------------Option 4--------------------------------------//

          } else if (userChoiceNum == 4){ // if the user enters 4, then the user will be able to expand their buildings, and even purchase even more buildings
            holder = 0;  // ensures that there is no value within the holder variable
            buildingCost = ((numOfBuildings - 1) * 50000) + 100000; // calculates the cost of the new building with this formula (first building is 100,000 and increases by 50,000 every building)
            System.out.println("\nEnter which option you would like to choose: (0 to cancel)\n");
            System.out.println("1) Would you like to level up your building? ($50,000)");
            System.out.println("2) Would you like to purchase another building? ($" + buildingCost + ")");
            userChoiceNum = input.nextInt(); // takes the users input on whether they would want to level up their building or purchase another
            if (userChoiceNum < 1 || userChoiceNum > 2){ // checks if the user inputted an invalid number
              System.out.println("\nInvalid number, please try again");
            } else if (userChoiceNum == 1){ // if the user enters 1, then the user wants to level up their building
              if (currentCash <= buildingLevelCost){ // checks if the user is financially able to perform this action
                System.out.println("\nYou do not have enough money to level up your building, please try again");
              } else { // the user is able to level up their building
                buildingLevel[viewBuilding] = buildingLevel[viewBuilding] + 1; // increases the level of the building by 1
                currentCash = currentCash - buildingLevelCost; // subtracts the users cash by the level up cost
                buildingSqFt[viewBuilding] = buildingSqFt[viewBuilding] + (int) (Math.random() * (750 - 500 + 1) + 500); // the square foot of the building increases by a random amount between 500 and 750
                buildingDemand[viewBuilding] = buildingDemand[viewBuilding] + 10; // the demand of that building increases by 10
                buildingExpenses[viewBuilding] = (int) ((buildingExpenses[viewBuilding] + 500) * 1.2); // the expenses of the building increases by 500, and then increases the whole amount by 20%
                buildingMaxShelfInventory[viewBuilding] =(buildingMaxShelfInventory[viewBuilding] + 40); // increases the max amount that the shelf can hold by 30%
                System.out.println("\n<-------------------< Building Level Up >------------------>\n");
                System.out.println("You have successfully leveled up your building! Your building is now level " + buildingLevel[viewBuilding]);
                System.out.println("Your building now has " + buildingSqFt[viewBuilding] + " square feet!");
                System.out.println("Your building demand has increased to " + buildingDemand[viewBuilding] + "!");
                System.out.println("Your building expenses have increased to $" + buildingExpenses[viewBuilding] + "!");
                System.out.println("The maximum that your shelves can hold has increased to " + buildingMaxShelfInventory[viewBuilding] + "!");
                System.out.println("\nYour building now looks like this: ");
                business.buildingLevel(buildingLevel, numOfBuildings); // prints the users building back to them, including the new level expansion
              }
            } else if (userChoiceNum == 2){ // if the user enters 2, then the user wants to purchase another building
              if (currentCash <= buildingCost){ // checks if the user is financially able to perform this action
                System.out.println("\nYou do not have enough money to purchase another building, please try again later");
              } else { // if the user is financially able to performt this action
                numOfBuildings++; // increases the number of buildings by 1
                currentCash = currentCash - buildingCost; // decreases the users cash by the cost of the new building
                if (buildingIncentiveActive == 1){ // checks if the building incentive booster is active, if yes, then the user will recieve a portion of the cash back from the purchase
                  holder = (int) (buildingCost * 0.25); // takes a quarter of the cost
                  currentCash = currentCash + holder; // and adds it to the users cash
                  System.out.println("With you having a building incentive booster active, you were able to save " + holder + " dollars!");
                }
                buildingSqFt[numOfBuildings] = (buildingSqFt[numOfBuildings] + newBuildingSqFt); // the square feet of the new building is a random amount between 1000 and 1500
                buildingInventory[numOfBuildings] = (buildingInventory[numOfBuildings] + newBuildingInventory); // the amount of inventory of the new building is a random amount between 1000 and 1500
                buildingExpenses[numOfBuildings] = buildingExpenses[numOfBuildings] + 1000; // the expenses of the new building is increased 1000
                System.out.println("You have successfully purchased another building! You now own " + numOfBuildings + " buildings!");
                System.out.println("Your new building has " + buildingSqFt[numOfBuildings] + " square feet!");
                System.out.println("Your new building expenses have increased to $" + buildingExpenses[numOfBuildings] + "!");
                System.out.println("The maximum that your new buildings shelves can hold is " + buildingMaxShelfInventory[numOfBuildings]);
              }
            }

//----------------------------------------------------Option 5--------------------------------------------------//

          } else if (userChoiceNum == 5){ // if the user enters 5, then the user will be able to hire employees to their building
            System.out.println("\nHow many employees would you like to hire? (Each employee is $2500 as a downpayment, and $3000 a month, enter a number between 1-8, 0 to cancel):\n");
            System.out.println("1) 1?");
            System.out.println("2) 2?");
            System.out.println("3) 3?");
            System.out.println("4) 4?");
            System.out.println("5) 5?");
            userChoiceNum = input.nextInt(); // asks the user the amount of employees that they would like to hire
            if (userChoiceNum < 1 || userChoiceNum > 5){ // checks if the user inputted an invalid number
              System.out.println("\nInvalid number, please try again");
            } else if (currentCash < 2500){ // if the user can not afford to hire a singular employee
              System.out.println("You do not have enough money to hire an employee, please try again later");
            } else if (userChoiceNum == 1){ // if the user chose to hire 1 employee
              holder2 = business.employees(currentCash, 2500, buildingEmployees[viewBuilding], 1); // calls the employees method, and sets the amount of employees that the user hired to the amount that the method returns
            } else if (userChoiceNum == 2){ // if the user chose to hire 2 employees
              holder2 = business.employees(currentCash, 5000, buildingEmployees[viewBuilding], 2); // calls the employees method, and sets the amount of employees that the user hired to the amount that the method returns
            } else if (userChoiceNum == 3){ // if the user chose to hire 3 employees
              holder2 = business.employees(currentCash, 7500, buildingEmployees[viewBuilding], 3); // calls the employees method, and sets the amount of employees that the user hired to the amount that the method returns
            } else if (userChoiceNum == 4){ // if the user chose to hire 4 employees
              holder2 = business.employees(currentCash, 10000, buildingEmployees[viewBuilding], 4); // calls the employees method, and sets the amount of employees that the user hired to the amount that the method returns
            } else if (userChoiceNum == 5){ // if the user chose to hire 5 employees
              holder2 = business.employees(currentCash, 12500, buildingEmployees[viewBuilding], 5); // calls the employees method, and sets the amount of employees that the user hired to the amount that the method returns
            } if (holder2[0] == 1){ // the first index of the array hold the "successful" variable, if 1, then the user was successful in hiring the employees
              currentCash = holder2[1]; // sets the users cash to the amount that came out of the method
              buildingEmployees[viewBuilding] = holder2[2]; // sets the amount of employees to the amount that came out of the method
            }

//-----------------------------------------------Option 6---------------------------------------------------//

          } else if (userChoiceNum == 6){ // if the user enters 6, then the user will be able to use one of their boosters
            System.out.println("\nWhich Booster would you like use? (enter a number between 1-8, 0 to cancel): \n");
            System.out.println("1) Profit Booster?");
            System.out.println("2) Expense Relief?");
            System.out.println("3) Building Incentive?");
            System.out.println("4) Purchase Relief?");
            userChoiceNum = input.nextInt(); // asks the user which booster that they would to use
            if (userChoiceNum < 1 || userChoiceNum > 4){ // if the user entered an invalid number
              System.out.println("\nInvalid number, please try again");
            } if (userChoiceNum == 1 && profitBoosterActive == 1 || userChoiceNum == 2 && expenseReliefActive == 1 || userChoiceNum == 3 && buildingIncentiveActive == 1 || userChoiceNum == 4 && purchaseReliefActive == 1){ // if the user asked to use a booster but already has it in use
              System.out.println("You have already activated this booster, please try again later");
            } if (userChoiceNum == 1 && profitBoosterUsable == 0 || userChoiceNum == 2 && expenseReliefUsable == 0 || userChoiceNum == 3 && buildingIncentiveUsable == 0 || userChoiceNum == 4 && purchaseReliefUsable == 0){ // if the user asked to use a booster, but have already used it within their level
              System.out.println("You have already used this booster within this level, you have to level up first, and then you will be able to use it again.");
            
            } if (userChoiceNum == 1){ // if the user chose option 1 (profit booster)
              profitBoosterActive = 1; // sets the boosters active variable to 1 (true)
              profitBoosterUsable = 0; // sets the boosters usable varuable to 0 (false)
              System.out.println("You now have successfully have a profit booster in effect until the end of the day! (takes a quarter of you profits and adds it to your cash)");
            } else if (userChoiceNum == 2){ // if the user chose option 2 (expense relief booster)
              expenseReliefActive = 1; // sets the boosters active varaible to 1 (true)
              expenseReliefUsable = 0; // sets the boosters usable varuable to 0 (false)
              System.out.println("You now have successfully have a expense relief booster in effect until the end of the day! (takes off a 1/4 of the price off of expenses)");
            } else if (userChoiceNum == 3){ // if the user chose option 3 (building incentive booster)
              buildingIncentiveActive = 1; // sets the boosters active varaible to 1 (true)
              buildingIncentiveUsable = 0; // sets the boosters usable varuable to 0 (false)
              System.out.println("You now have successfully have a building incentive booster in effect until the end of the day! (takes off a 1/4 of the price off of expenses)");
            } else if (userChoiceNum == 4){ // if the user chose option 4 (purchase relief booster)
              purchaseReliefActive = 1; // sets the boosters active varaible to 1 (true)
              purchaseReliefUsable = 0; // sets the boosters usable varuable to 0 (false)
              System.out.println("You now have successfully have a purchase relief booster in effect until the end of the day! (takes off a 1/4 of the price off of expenses)");
            }

//------------------------------------------------Option 7---------------------------------------------------//

          } else if (userChoiceNum == 7){ // if the user enters 7, then the user will be able to see the details of their building
            business.buildingDetails(currentCash, numOfBuildings, viewBuilding, buildingRevenue[viewBuilding], buildingLevel[viewBuilding], buildingSqFt[viewBuilding], buildingDemand[viewBuilding], buildingExpenses[viewBuilding], buildingMaxShelfInventory[viewBuilding], buildingEmployees[viewBuilding], buildingShelfInventory[viewBuilding], buildingWorth[viewBuilding], buildingInventory[viewBuilding]); // this method is used to display the details of the user's business, and the user's current cash, number of buildings, and the view building number, and more by calling the building details method

//----------------------------------------------Option 8---------------------------------------------------//

          } else if (userChoiceNum == 8){ // if the user enters 8, then the user will be able to get a loan
            System.out.println("\nRemember that when it comes to paying off this loan, there is added interest to the amount!");
            System.out.println("Select the amount that you would like to take out as a loan (enter a number between 1-8, 0 to cancel): \n");
            System.out.println("1) $1,000? (7% interest)");
            System.out.println("2) $2,500? (6% interest)");
            System.out.println("3) $5,000? (6% interest)");
            System.out.println("4) $10,000? (5% interest)");
            System.out.println("5) $25,000? (5% interest)");
            System.out.println("6) $50,000? (4% interest)");
            System.out.println("7) $150,000? (3% interest)");
            System.out.println("8) $300,000? (2% interest)");
            userChoiceNum = input.nextInt(); // asks the user for the loan amount that they would like to take out
            if (userChoiceNum < 1 || userChoiceNum > 8){ // if the user inputted an invalid number
              System.out.println("\nInvalid number, please try again");
            } else if (userChoiceNum == 1){ // if the user wants to take out a loan of $1,000
              holder2 = business.loanProcess(currentCash, totalExpenses, 1000, 1.07); // cals the loan process method to take out the loan, and sets the values to the holder2 array
            } else if (userChoiceNum == 2){ // if the user wants to take out a loan of $2,500
              holder2 = business.loanProcess(currentCash, totalExpenses, 2500, 1.06); // cals the loan process method to take out the loan, and sets the values to the holder2 array
            } else if (userChoiceNum == 3){ // if the user wants to take out a loan of $5,000
              holder2 = business.loanProcess(currentCash, totalExpenses, 5000, 1.06); // cals the loan process method to take out the loan, and sets the values to the holder2 array
            } else if (userChoiceNum == 4){ // if the user wants to take out a loan of $10,000
              holder2 = business.loanProcess(currentCash, totalExpenses, 10000, 1.05); // cals the loan process method to take out the loan, and sets the values to the holder2 array
            } else if (userChoiceNum == 5){ // if the user wants to take out a loan of $25,000
              holder2 = business.loanProcess(currentCash, totalExpenses, 25000, 1.05); // cals the loan process method to take out the loan, and sets the values to the holder2 array
            } else if (userChoiceNum == 6){ // if the user wants to take out a loan of $50,000
              holder2 = business.loanProcess(currentCash, totalExpenses, 50000, 1.04); // cals the loan process method to take out the loan, and sets the values to the holder2 array
            } else if (userChoiceNum == 7){ // if the user wants to take out a loan of $150,000
              holder2 = business.loanProcess(currentCash, totalExpenses, 150000, 1.03); // cals the loan process method to take out the loan, and sets the values to the holder2 array
            } else if (userChoiceNum == 8){ // if the user wants to take out a loan of $300,000
              holder2 = business.loanProcess(currentCash, totalExpenses, 300000, 1.02); // cals the loan process method to take out the loan, and sets the values to the holder2 array
            } if (holder2[2] == 1){
              currentCash = holder2[0]; // updates the current cash with the amount that came out of the method
              totalExpenses = holder2[1]; // updates the total expenses with the amount that came out of the method
            }

//----------------------------------------------Option 9------------------------------------------------//

          } else if (userChoiceNum == 9){ // if the user enters 9, then the user will be able to head into the next day
            System.out.println("\nAre you sure you want to close the business for the day? (1 for yes, 2 for no)");
            userChoiceNum = input.nextInt(); // asks the user if they are sure if they want to close the business for the day
            if (userChoiceNum == 1){ // if the user is sure that they want to close the business for the day
              userChoiceNum = 9; // so that the if statements that run if user ends the day is ran
              day++; // increments the day by 1
              System.out.println("\n<-----------------< Daily Report >----------------->\n");
              System.out.println("You have successfully ended the day!");
              System.out.println("You have $" + currentCash + " in cash!");
              System.out.println("You have $" + buildingExpenses[viewBuilding] + " in expenses!");
              System.out.println("You have " + buildingShelfInventory[viewBuilding] + " products ON the shelf");
              System.out.println("You have " + buildingInventory[viewBuilding] + " products OFF the shelf");
              System.out.println("Your inventory has decreased by " + buildingDemand[viewBuilding] + " products today!\n");
              if (profitBoosterUsable == 1 && profitBoosterActive == 0){ // if the user is able to use a profit booster, as the usable variable is set to 1 (true) and the active variable is set to 0 (false)
                System.out.println("You have a profit booster that can be used!");
              } if (expenseReliefUsable == 1 && expenseReliefActive == 0) { // if the user is able to use a expense relief booster, as the usable variable is set to 1 (true) and the active variable is set to 0 (false)
                System.out.println("You have a expense relief booster that can be used!");
              } if (buildingIncentiveUsable == 1 && buildingIncentiveActive == 0){ // if the user is able to use a building incentive booster, as the usable variable is set to 1 (true) and the active variable is set to 0 (false)
                System.out.println("You have a building incentive booster that can be used!");
              } if (purchaseReliefUsable == 1 && purchaseReliefActive == 0){ // if the user is able to use a purchase relief booster, as the usable variable is set to 1 (true) and the active variable is set to 0 (false)
                System.out.println("You have a purchase relief booster that can be used!");
              }
              if (numOfBuildings > 1){
                System.out.println("\n<------------------------------------------------->\n");
                System.out.println("Would you like to monitor a different building? (1 for yes, 2 for n)");
                userChoiceNum = input.nextInt(); // asks the user if they would like to monitor another building
                if (userChoiceNum == 1){ // if the user entered y, or yes
                  System.out.println("Which building would you like to monitor? (1-" + numOfBuildings + "): ");
                  holder = input.nextInt(); // asks the user which building that they would like to monitor
                  if (holder < 0 || holder > numOfBuildings){ // if the user inputted an invalid number
                    System.out.println("\nInvalid number, please try again");
                  } else { // if the user inputted a valid number
                    viewBuilding = holder - 1; // as this variable is used in array indexes, subtracting 1 is necessary as the array starts at index 0
                  } // else statement
                } // if the user entered yes to monitoring another building
              }
            } else { // if the user is not sure that they want to close the business for the day
              System.out.println("Exiting... please try again later");
            }
            

//------------------------------------------------Option 10------------------------------------------//

          } else if (userChoiceNum == 10){ // if the user enters 10, then they will exit the program without saving their progress
            System.out.println("\nAre you sure you want to exit the program? (1 for yes, 2 for no)");
            userChoiceNum = input.nextInt(); // asks if the user is sure that they want to exit the program
            if (userChoiceNum == 1){ // if the user is sure that they want to exit the program
              System.out.println("Exiting the program...");
              exitProgram = "y"; // sets the exit program variable to y, which will cause the program to exit the while loop
            } else { // if the user is not sure that they want to exit the program
              System.out.println("\nPlease try again later...");
            }
              
//------------------------------------------------Option 11------------------------------------------//

          } else if (userChoiceNum == 11){ // if the user enters 11, then they will exit the program with saving their progress
            System.out.println("\nAre you sure you want to exit the program? (1 for yes, 2 for no)");
            userChoiceNum = input.nextInt(); // asks the user if they are sure that they want to exit the program
            if (userChoiceNum == 1){ // if the user is sure that they want to exit the program
              System.out.println("Exiting the program...");
              System.out.print("Saving your progress...");
              business.saveGame(day, currentCash, buildingExpenses, buildingShelfInventory, buildingInventory, buildingLevel, buildingDemand, buildingWorth, buildingSqFt, buildingRevenue, buildingEmployees, buildingMaxShelfInventory, viewBuilding, numOfBuildings, userLevel); // calls the save game method to save the progress of the user, taking all of the arrays to do with the buildings status and worth and expenses, and variables such as viewbuilding, user level and current cash and day
              exitProgram = "y"; // sets the exit program variable to y, which will cause the program to exit the while loop
            } else { // if the user is not sure that they want to exit the program
              System.out.println("\nPlease try again later...");
            }
          } // option 11
        } // while user has not typed no
      } // start of day 1 if statement
    } // start of game if statement
    input.close();
  }
}
