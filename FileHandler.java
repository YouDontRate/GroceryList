import java.nio.file.*;
import java.io.*;
import java.io.IOException;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;

class FileHandler
{

private Path filePath; 
private InputStream input;
private OutputStream output;
private BufferedReader reader;

// ----------------------------------
public FileHandler()
{
filePath = Paths.get("Groceryfile.txt");
} // End constructor


// ------------------------------------
private void openFileToRead()
{
try
   {
   input = Files.newInputStream(filePath, READ);
   reader = new BufferedReader(new InputStreamReader(input));   
   } // End try
catch (Exception e)
   {
   System.out.println("(openFileToRead) Error: " + e);
   } // End catch
} // End method


// -------------------------------------
private String readLine()
{
String buffer = null;
try
   {
   buffer = reader.readLine();
   } // End try
catch (Exception e)
   {
   System.out.println("(readLine) Error: " + e);
   } // End catch

return buffer;
} // End method


// ------------------------------------
private void openFileToWrite()
{
try
   {
   output = new BufferedOutputStream(Files.newOutputStream(filePath, CREATE));
   } // End try
catch (Exception e)
   {
   System.out.println("(openFileToWrite) Error: " + e);
   } // End catch
} // End method


// -------------------------------------
private void writeLine(String buffer)
{
final char END_OF_LINE = '\n';
String tempBuffer;
byte[] data;

tempBuffer = buffer + END_OF_LINE;
data = tempBuffer.getBytes();

try
   {
   output.write(data);
   } // End try
catch (Exception e)
   {
   System.out.println("(writeLine) Error: " + e);
   } // End catch
} // End method


// ------------------------------------
private void closeReadFile()
{
try
   {
   input.close();
   } // End try
catch (Exception e)
   {
   System.out.println("(closeReadFile) Error: " + e);
   } // End catch
} // End method


// ------------------------------------
private void closeWriteFile()
{
try
   {
   output.close();
   } // End try
catch (Exception e)
   {
   System.out.println("(closeWriteFile) Error: " + e);
   } // End catch
} // End method


// ------------------------------------------
public void loadListFromFile(GroceryList myList)
{
String buffer;
int length;
Scanner bufferReader;
GroceryItem item;
String productName;
String quantity;

openFileToRead();
myList.clearContents();

buffer = readLine();

// Read the line count from the file
length = Integer.parseInt(buffer);

// Read the lines of the grocery list from the file
for (int i = 0; i < length; i++)
   {
   buffer = readLine();
   bufferReader = new Scanner(buffer);
   productName = bufferReader.next();
   quantity = bufferReader.nextLine();
   item = new GroceryItem(productName, quantity);
   myList.addItem(item);
   } // End for

closeReadFile();
} // End method


// ------------------------------------------
public void saveListToFile(GroceryList myList)
{
int length;

openFileToWrite();

length = myList.getLength();

// Write the line count as the first line in the file
writeLine(Integer.toString(length));

// Write the lines of the grocery list to the file
for (int i = 0; i < length; i++)
   {
   writeLine(myList.getItem(i).toString());
   } // End for

closeWriteFile();
} // End method

   
} // End class

