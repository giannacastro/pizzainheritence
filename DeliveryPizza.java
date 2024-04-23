public class DeliveryPizza extends Pizza {

    //delivery fee field
    private double deliveryFee;

    //delivery address field
    private String deliveryAddress;

    //constructor
    public DeliveryPizza(String[] toppings, String deliveryAddress, int numToppings) {

        //calls super constructor
        super(toppings, numToppings);

        //sets address
        this.deliveryAddress = deliveryAddress;

        //calculates delivery fee based on price
        if (price > 18) {
            deliveryFee = 3;
        } else {
            deliveryFee = 5;
        }
    }

    //overrides toString
    public String toString() {

        //calls super toString
        return super.toString() +

                //adds delivery details
                "\ndelivery fee: $" + deliveryFee +
                "\ndelivery address: " + deliveryAddress;
    }

}
