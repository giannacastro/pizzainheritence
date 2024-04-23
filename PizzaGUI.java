//imports swing gui components
import javax.swing.*;
//imports java awt and awt event classes
import java.awt.*;
import java.awt.event.*;
//imports java util array list class
import java.util.ArrayList;
//pizza gui class extends jframe
public class PizzaGUI extends JFrame {

    //gui components as prvate fields
  private JTextField toppingsField;
  private JTextField addressField;
  private JList toppingsList;
  private JTextArea outputArea;
  private JRadioButton pickupButton;
  private JRadioButton deliveryButton;
  private ArrayList<String> toppings = new ArrayList<>();
  private boolean isDoneAdding = false;

  //panel to hold the gui components

  private JPanel panel;

  //for maximum number of toppings (ten toppings max)
  private final int MAX_TOPPINGS = 10;

  //constructor which initializes the gui components
  public PizzaGUI() {

      //label for entering the toppings
    JLabel toppingsLabel = new JLabel("Enter toppings (type 'quit' to finish):");

    //text for entering the toppings
    toppingsField = new JTextField(20);
    //adds listener to the field
    toppingsField.addActionListener(new AddToppingListener());

    //list to display the entered toppings
    toppingsList = new JList();
    //set width and number of rows
    toppingsList.setFixedCellWidth(100);
    toppingsList.setVisibleRowCount(5);
    //initializes empty list
    toppingsList.setListData(new String[0]);

    //label for address
    JLabel addressLabel = new JLabel("Delivery address:");
    //text field for the address
    addressField = new JTextField(20);

    //buttons for picking up or delivery option
    pickupButton = new JRadioButton("Pickup");
    deliveryButton = new JRadioButton("Delivery");
    //group buttons
    ButtonGroup group = new ButtonGroup();
    group.add(pickupButton);
    group.add(deliveryButton);

    //button to place order
    JButton orderButton = new JButton("Place Order");
    //adds order listener
    orderButton.addActionListener(new PlaceOrderListener());

    //text area to display order summary
    outputArea = new JTextArea(10, 20);
    outputArea.setEditable(false);

    //create panel
    panel = new JPanel();
    //add components to panel
    panel.add(toppingsLabel);
    panel.add(toppingsField);
    panel.add(new JScrollPane(toppingsList));
    panel.add(addressLabel);
    panel.add(addressField);
    panel.add(pickupButton);
    panel.add(deliveryButton);
    panel.add(orderButton);


//adds panel and output area to frame
    add(panel, BorderLayout.NORTH);
    add(new JScrollPane(outputArea), BorderLayout.CENTER);


    //sets frame properties
    setSize(400, 300);
    setVisible(true);
  }

  //inner class for adding toppings
  class AddToppingListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        //checks if max toppings are not reached
      if (!isDoneAdding && toppings.size() < MAX_TOPPINGS) {

          //get text, add to list
        String newTopping = toppingsField.getText();
        if(!newTopping.equalsIgnoreCase("quit")) {
          toppings.add(newTopping);
          toppingsList.setListData(toppings.toArray());
        } else {
          isDoneAdding = true;
        }
        toppingsField.setText("");
      } else if (toppings.size() >= MAX_TOPPINGS) {
        JOptionPane.showMessageDialog(PizzaGUI.this,
          "Max 10 toppings allowed");
      }
    }
  }

  //inner class for placing orders
  class PlaceOrderListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        //get address if delivery selected
        //creates order summary string
        //sets output area text

      String address = "";
      if (deliveryButton.isSelected()) {
        address = addressField.getText();
      }

      //creativity (thank you message)
      String orderSummary = "Thank you for your order!\n";
      orderSummary += "Toppings: " + toppings + "\n";
      orderSummary += "Address: " + address + "\n";
      orderSummary += deliveryButton.isSelected() ? "Delivery" : "Pickup";

      outputArea.setText(orderSummary);
    }
  }

  //main method to launch gui
  public static void main(String[] args) {
    new PizzaGUI();
  }

}
