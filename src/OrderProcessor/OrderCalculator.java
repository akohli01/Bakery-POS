package OrderProcessor;

import OrderMain.OrderStart;

import javax.swing.JOptionPane;


public class OrderCalculator {

	private static double subTotalVariable = 0;
	private final static double salesTaxVariable = .06;

	    //Updates the orderInfo textbox to reflect the items chosen for purchase
		public static void displayOrderInfo(int quantity, String itemName, double price, String caller) {

			OrderStart.orderInfo.append(quantity  + " " +itemName +" \n");
			
			 subTotalVariable += (quantity * price) ;
			
			showPriceInfo(subTotalVariable);
			
		}

		//Updates the subtotal, salestax, and total text fields
		private static void showPriceInfo(double subTotalVariable) {
			
			OrderStart.subTotalField.setText(String.format("$%.2f",subTotalVariable));
			OrderStart.salesTaxField.setText(String.format("$%.2f", (subTotalVariable * salesTaxVariable)));
			OrderStart.totalField.setText(String.format("$%.2f",subTotalVariable + (subTotalVariable * salesTaxVariable)));
		}

		//Performs the "checkout"
		public static void checkoutRunner() {
			
			if(OrderStart.totalField.getText().equals(""))
			    JOptionPane.showMessageDialog(null, "No items are selected for purchase");
			else {
				JOptionPane.showMessageDialog(null, "The total is " + OrderStart.totalField.getText());
			}
			clearOrderAndPriceInfo();
			subTotalVariable = 0;
			
		}

		//Clears the Order information and Price information
		public static void clearOrderAndPriceInfo() {
             subTotalVariable = 0;
             OrderStart.orderInfo.setText("" + "Order details: \n\n");
             OrderStart.subTotalField.setText("");
             OrderStart.salesTaxField.setText("");
             OrderStart.totalField.setText("");
		}
		
		
}
