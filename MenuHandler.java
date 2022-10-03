import java.util.Scanner;

class MenuHandler
{
private static final String EXIT_PROGRAM = "9";

GroceryList myList;
Scanner keyboard;

// -----------------------------
public MenuHandler(GroceryList myList)
{
this.myList = myList;
keyboard = new Scanner(System.in);
} // End constructor


// -----------------------------
public void showMenu()
{
System.out.println();
System.out.println("*** Menu ***");
System.out.println("0 - Show the menu");
System.out.println("1 - Display the grocery list");
System.out.println("2 - Add to the grocery item");
System.out.println("3 - Clear the grocery list");
System.out.println("4 - Load the grocery list");
System.out.println("5 - Save the grocery list");
System.out.println("9 - Exit the program");
} // End method


// -----------------------------
public void processCommand(String command)
{
FileHandler myFile;
String productName;
String quantity;
GroceryItem myItem;
int length;
String buffer;
Scanner bufferReader;

switch (command)
   {
   case "0": showMenu();
             break;
   case "1": System.out.println("**** GROCERY LIST ***");
             myList.displayContents();
             System.out.println("*** END OF LIST ***");
             break;
   case "2": System.out.println("**** Add to the Grocery List ***");
             System.out.print("Enter the product name: ");
             productName = keyboard.nextLine();
             System.out.print("Enter the quantity needed: ");
             quantity = keyboard.nextLine();
             myItem = new GroceryItem(productName, quantity);
             myList.addItem(myItem);
             break;
   case "3": System.out.println("**** Clear the Grocery List ***");
             myList.clearContents();
             break;
   case "4": System.out.println("*** Load the grocery list from the data file ***");
             myFile = new FileHandler(); 
             myList.clearContents();
             myFile.loadListFromFile(myList);
             break;
   case "5": System.out.println("*** Save the grocery list to the data file ***");
             myFile = new FileHandler();
             myFile.saveListToFile(myList);
             break;
   case "9": // Exit the program
             break;
   default:  System.out.println("Not a valid menu option");
   } // End switch
} // End method


} // End class
