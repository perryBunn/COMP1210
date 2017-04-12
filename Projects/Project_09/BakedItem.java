import java.text.DecimalFormat;
/**
 *
 */
public abstract class BakedItem {

   protected String name;
   protected String flavor;
   protected int quantity;
   protected String[] ingredients;
   protected static int count = 0;
   /**
    * @param nameIn creates the name of the object
    * @param flavorIn creates the flavor of the object
    * @param quantityIn creates the qunatity of the object
    * @param ingredientsIn creates the ingredients of the object
    */
   public BakedItem(String nameIn, String flavorIn, int quantityIn, 
                                             String ... ingredientsIn) {
      name = nameIn;
      flavor = flavorIn;
      quantity = quantityIn;
      ingredients = ingredientsIn;
      count++;
   }
   /**
    * @return returns the name of the object
    */
   public String getName() {
      return name;
   }
   /**
    * @param nameIn sets the name of the object
    */
   public void setName(String nameIn) {
      this.name = nameIn;
   }
   /**
    * @return returns the flavor of object
    */
   public String getFlavor() {
      return flavor;
   }
   /**
    * @param flavorIn sets the flavor of the object
    */
   public void setFlavor(String flavorIn) {
      this.flavor = flavorIn;
   }
   /**
    * @return returns the quantity of the object
    */
   public int getQuantity() {
      return quantity;
   }
   /**
    * @param quantityIn the number of items stored by the objects
    */
   public void setQuantity(int quantityIn) {
      this.quantity = quantityIn;
   }
   /**
    * @return returns the ingredients for teh object
    */
   public String[] getIngredients() {
      return ingredients;
   }
   /**
    * @param ingredientsIn input of the ingredients for the object
    */
   public void setIngredients(String ... ingredientsIn) {
      this.ingredients = ingredientsIn;
   }
   /**
    * @return returns the count of objects
    */
   public static int getCount() {
      return count;
   }
   /**
    *
    */
   public static void resetCount() {
      BakedItem.count = 0;
   }
   /**
    * @return returns the toString of the object
    */
   public final String toString() {
      String ingredientsR = "";
      int j = 0;
      for (int i = 0; i < ingredients.length; i++) {
         if (j != 5 && j == ingredients.length - 1) {
            ingredientsR += ingredients[i];
         } else if (j < 5 && (i != ingredients.length - 1)) {
            ingredientsR += ingredients[i] + ", ";
            j++;
         } else if (j == 5 && (i != ingredients.length - 1)) {
            ingredientsR += "\n" + ingredients[i] + ", ";
            j = 1;
         } else if (j == 5 && (i == ingredients.length - 1)) {
            ingredientsR += "\n" + ingredients[i];
            j++;
         } else {
            ingredientsR += ingredients[i];
            j++;
         }
      }
      DecimalFormat fmt = new DecimalFormat("$#,##0.00");
      String result = this.getClass().toString().substring(6) 
         + ": " + name + " - " + flavor + "\tQuantity: " + quantity 
         + "\tPrice: " + fmt.format(price()) + "\n" + "(Ingredients: " 
         + ingredientsR + ")";
      return result;
   }
   /**
    * @return returns the price of the object
    */
   public abstract double price();
}