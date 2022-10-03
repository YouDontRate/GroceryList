class GroceryItem
{

private String productName;
private String quantity;


// ------------------------------------
public GroceryItem(String productName, String quantity)
{
this.productName = productName;
this.quantity = quantity;
} // End constructor


// ------------------------------------
public String toString()
{
final String SPACE = " ";
return productName + SPACE + quantity;
} // End method


} // End class
