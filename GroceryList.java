import java.util.ArrayList;

class GroceryList
{

private ArrayList<GroceryItem> theList;

// ------------------------------------------
public GroceryList()
{
theList = new ArrayList<GroceryItem>();
} // End constructor


// ------------------------------------------
public int getLength()
{
return theList.size();
} // End method


// ------------------------------------------
public void addItem(GroceryItem item)
{
theList.add(item);
} // End method


// ------------------------------------------
public GroceryItem getItem(int index)
{
return theList.get(index);
} // End method


// ------------------------------------------
public void displayContents()
{
for (int i = 0; i < theList.size(); i++)
   {
   System.out.println(theList.get(i));   
   } // End for
} // End method


// ------------------------------------------
public void clearContents()
{
theList.clear();
} // End method

} // End class
