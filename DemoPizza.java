//import scanner for user input
import java.util.Scanner;

public class DemoPizza {

    //main method
    public static void main(String[] args) {

        //creates scanner object
        Scanner scan = new Scanner(System.in);

        //prompt for toppings
        System.out.println("enter pizza toppings (quit to finish):");

        //array which holds the toppings
        String[] toppings = new String[10];
        //counter for the amount of toppings
        int numToppings = 0;

        //loop to get toppings
        while (numToppings < 10) {
            //get topping input
            String topping = scan.nextLine();
            //checks for 'quit'
            if (topping.equalsIgnoreCase("quit")) {
                break;
            }
            //adds topping to array
            toppings[numToppings++] = topping;
        }

        //prompt for delivery
        System.out.print("delivery pizza? (y/n): ");
        //get yes/no input
        boolean delivery = scan.nextLine().equalsIgnoreCase("y");

        Pizza pizza;
        //if delivery
        if (delivery) {
            //get address
            System.out.print("enter delivery address: ");
            String address = scan.nextLine();
            //create delivery pizza
            pizza = new DeliveryPizza(toppings, address, numToppings);
        } else {
            //create regular pizza
            pizza = new Pizza(toppings, numToppings);
        }

        //print blank line
        System.out.println();
        //print pizza details
        System.out.println(pizza);

    }

}
