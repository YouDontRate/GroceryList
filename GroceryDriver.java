import java.util.Scanner;

class GroceryDriver
{
private static final String EXIT_PROGRAM = "9";

// ------------------------------------------
public static void main(String[] args)
{
Scanner keyboard = new Scanner(System.in);
GroceryList mainList = new GroceryList();
MenuHandler menu = new MenuHandler(mainList);

String userInput;
boolean exitProgram = false;

menu.showMenu();

while (!exitProgram)
   {
   System.out.print("Enter a menu command(0 for menu): ");
   userInput = keyboard.nextLine();
   menu.processCommand(userInput);
   if (userInput.equals(EXIT_PROGRAM))
      exitProgram = true;
   }  // End while
System.out.println("*** EXIT THE PROGRAM ***");   

} // End main

} // End class
