//import arrays utility
import java.util.Arrays;

public class Pizza {

    //array to hold the toppings
    private String[] toppings;

    //number of toppings
    private int numToppings;

    //price field, protected so subclass can access it
    protected double price;

    //constructor
    public Pizza(String[] toppings, int numToppings) {

        //sets fields
        this.toppings = toppings;
        this.numToppings = numToppings;

        //builds toppings description string
        String desc = "";
        for (int i = 0; i < numToppings; i++) {
            desc += toppings[i];
            if (i < numToppings - 1) {
                desc += ", ";
            }
        }

        //calculates price based on toppings
        price = 14 + 2 * numToppings;
    }

    //overrides toString
    public String toString() {
        return "pizza with " + numToppings + " toppings: " +
                //uses arrays util to print array
                Arrays.toString(toppings) +
                "\nprice: $" + price;
    }

}
