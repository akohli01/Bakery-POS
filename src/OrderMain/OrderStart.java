package OrderMain;
import OrderItems.Cake;
import OrderItems.Drink;
import OrderItems.Muffin;
import OrderItems.Bagel;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

import OrderProcessor.OrderCalculator;

//Main GUI for program
public class OrderStart extends JFrame {
	
	private JPanel panelTop, panelMiddle, panelBottom, panelBottomCenter, panelBottomRight;
	private JButton bagels, drinks, muffins, cakes;
	private JButton checkout, exit, clearAll;
	public static JTextArea orderInfo;
	private JLabel subTotal, salesTax, total;
	public static JTextField subTotalField, salesTaxField, totalField;

	private OrderStart() {
		//Set basic properties for JFrame
		setLayout(new GridLayout(3,1,10, 30));
		setTitle("Manhattan's Finest Bakery");
		setBounds(100,100,1200,700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.getHSBColor(0.15f, .20f, .97f));

		//Builds the three panels for layout
		panelTopBuilder();
		panelMiddleBuilder();
		panelBottomBuilder();
		
		setVisible(true);
	}

	//Builds the top panel which contains the bagel, drinks, muffins, and cakes options
	private void panelTopBuilder() {
		//Initialize the JButtons for panelTop
		   bagels = new JButton("Bagels");
			drinks= new JButton("Drinks");
			muffins = new JButton("Muffins");
			cakes = new JButton("Cakes"); 
			
		//Assign image icons to JButtons
			bagels.setIcon(new ImageIcon(OrderStart.class.getResource("/resources/Bagel.png")));
			cakes.setIcon(new ImageIcon(OrderStart.class.getResource("/resources/Cake.png")));
			drinks.setIcon(new ImageIcon(OrderStart.class.getResource("/resources/Drinks.png")));
			muffins.setIcon(new ImageIcon(OrderStart.class.getResource("/resources/Muffin.png")));
		
		//Remove "dotted border" from JButtons
			bagels.setFocusPainted(false);
			cakes.setFocusPainted(false);
			drinks.setFocusPainted(false);
			muffins.setFocusPainted(false);
		
		//Add Action Listeners to JButtons
			bagels.addActionListener(new OptionsListener());
			drinks.addActionListener(new OptionsListener());
			muffins.addActionListener(new OptionsListener());
			cakes.addActionListener(new OptionsListener());
		
		//Set formatting for JButtons for panelTop
			bagels.setFont(new Font("Serif", Font.PLAIN, 22));
			drinks.setFont(new Font("Serif", Font.PLAIN, 22));
			muffins.setFont(new Font("Serif", Font.PLAIN, 22));
			cakes.setFont(new Font("Serif", Font.PLAIN, 22));
			
		//Initialize JPanel panelTop
			panelTop = new JPanel();
			
		// Make panel transparent
			panelTop.setOpaque(false);
		
		//Customize panelTop layout and spacing
			panelTop.setLayout(new FlowLayout(FlowLayout.CENTER,50,70));
			
		//Add JButtons to JPanel panelTop
			panelTop.add(bagels);
			panelTop.add(drinks);
			panelTop.add(muffins);
			panelTop.add(cakes);
		
		//Add panelTop to the top of the JFrame
			getContentPane().add(panelTop);
	}

	//Builds the middle panel which contains the order details
	private void panelMiddleBuilder() {
		//Initialize JTextArea orderInfo
				orderInfo = new JTextArea("Order details: \n\n",7,60);
				
				
			//Set formatting for text inside JTextArea orderInfo
				orderInfo.setFont(new Font("Serif", Font.PLAIN, 22));
			
			//Disable modification of JTextArea orderInfo
				orderInfo.setEditable(false);
			
		//Create a JScrollPane object for orderInfo
				JScrollPane sp = new JScrollPane(orderInfo);
			
				
			//Initialize JPanel panelMiddle
				panelMiddle = new JPanel();
				
			// Make panel transparent
				panelMiddle.setOpaque(false);
				
			//Add orderInfo to panelMiddle
				panelMiddle.add(sp);
			
			//Add panelMiddle to JFrame
				add(panelMiddle);
	}

	//Builds the bottom panel which allows you to clear, exit, or checkout an order
	private void panelBottomBuilder() {
		//Initialize JButtons for JPanel panelBottom
				checkout = new JButton("Checkout");
				exit = new JButton("Exit");
				clearAll = new JButton("Clear Order");
				
			//Set Formatting for JButtons for panelBottom
				checkout.setFont(new Font("Serif", Font.PLAIN, 22));
				exit.setFont(new Font("Serif", Font.PLAIN, 22));
				clearAll.setFont(new Font("Serif", Font.PLAIN, 22));
			
			//Add in actionListener method
				exit.addActionListener(new ExitListener());
				clearAll.addActionListener(new ClearListener());
				checkout.addActionListener(new CheckoutListener());
				
			//Initialize panelBottom
				panelBottom = new JPanel();
				
		    // Make panel transparent
				panelBottom.setOpaque(false);
				
			//set Layout for panelBottom
				panelBottom.setLayout(new GridLayout(1,2));
			
			//Initialize panelBottomCenter
				panelBottomCenter = new JPanel();
				
			// Make panel transparent
				panelBottomCenter.setOpaque(false);
			
			//Set layout for panelBottomCenter
				panelBottomCenter.setLayout(new FlowLayout(FlowLayout.RIGHT,50,70));
			
			//Add JButtons to panelBottomCenter
				panelBottomCenter.add(clearAll);
				panelBottomCenter.add(checkout);
				panelBottomCenter.add(exit);
			
			//Add panelBottomCenter to panelBottom
				panelBottom.add(panelBottomCenter);
				
			//Initialize JLabels that will be placed in panelBottomRight
				subTotal = new JLabel("Subtotal");
				salesTax = new JLabel("Sales Tax (6%)");
				total = new JLabel("Total");
			
			//Set alignment for text in JLabels
				subTotal.setHorizontalAlignment(JLabel.RIGHT);
				salesTax.setHorizontalAlignment(JLabel.RIGHT);
				total.setHorizontalAlignment(JLabel.RIGHT);
			
			//Set text formatting for JLabels
				subTotal.setFont(new Font("Serif", Font.PLAIN, 22));
				salesTax.setFont(new Font("Serif", Font.PLAIN, 22));
				total.setFont(new Font("Serif", Font.PLAIN, 22));
					
			//Initialize JTextFields that will be placed in panelBottomRight
				subTotalField = new JTextField(10);
				salesTaxField = new JTextField(10);
				totalField = new JTextField(10);
			
			//Set background color for JTextFields
				subTotalField.setBackground(Color.WHITE);
				salesTaxField.setBackground(Color.WHITE);
				totalField.setBackground(Color.WHITE);
				
			//Disable modification of the Cost text fields
				subTotalField.setEditable(false);
				salesTaxField.setEditable(false);
				totalField.setEditable(false);
			
		//Set text formatting for the JTextFields
				subTotalField.setFont(new Font("Serif", Font.PLAIN, 22));
				salesTaxField.setFont(new Font("Serif", Font.PLAIN, 22));
				totalField.setFont(new Font("Serif", Font.PLAIN, 22));
				
			//Initialize panelBottomRight
				panelBottomRight = new JPanel();
				
			// Make panel transparent
				panelBottomRight.setOpaque(false);
				
			//Set Layout for panelBottomRight
				panelBottomRight.setLayout(new GridBagLayout());
				
				//Initialize GridBagConstraints 
				GridBagConstraints c = new GridBagConstraints();
				GridBagConstraints d = new GridBagConstraints();
				GridBagConstraints e = new GridBagConstraints();
				GridBagConstraints f = new GridBagConstraints();
				GridBagConstraints g = new GridBagConstraints();
				GridBagConstraints h = new GridBagConstraints();
				
				
				c.gridx = 0;
				c.gridy = 0;
				c.insets = new Insets(0,0,20,20);
				
				
				d.gridx = 1;
				d.gridy = 0;
				d.insets = new Insets(0,0,20,20);
				
				e.gridx = 0;
				e.gridy = 1;
				e.insets = new Insets(0,0,20,20);
				
				f.gridx = 1;
				f.gridy = 1;
				f.insets = new Insets(0,0,20,20);
				
				g.gridx = 0;
				g.gridy = 2;
				g.insets = new Insets(0,0,20,20);
				
				h.gridx = 1;
				h.gridy = 2;
				h.insets = new Insets(0,0,20,20);
				
			//Add JLabels and JTextFields to panelBottomRight
				panelBottomRight.add(subTotal,c);
				panelBottomRight.add(subTotalField,d);
				panelBottomRight.add(salesTax,e);
				panelBottomRight.add(salesTaxField,f);
				panelBottomRight.add(total,g);
				panelBottomRight.add(totalField,h);
				
			//Add panelBottomRight to panelBottom
				panelBottom.add(panelBottomRight);
				
			//Add panelBottom to JFrame
				add(panelBottom);
	}

	//Opens the appropriate options (bagels, drinks, muffins, etc) tab based upon the user's selection
	private class OptionsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			setEnabled(false);
			
			if(e.getSource() == bagels) {
			new Bagel().addWindowListener(new winChecker());
			}
			
			else if(e.getSource() == drinks) {
				new Drink().addWindowListener(new winChecker());
			}
			
			else if(e.getSource() == muffins) {
				new Muffin().addWindowListener(new winChecker());
			}
			
			else if(e.getSource() == cakes) {
				new Cake().addWindowListener(new winChecker());
			}
			
		}
	}
	
	//Clears the user's order
	private class ClearListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			OrderCalculator.clearOrderAndPriceInfo();
			
		}
	}

	//Performs a "checkout" function
	private class CheckoutListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			OrderCalculator.checkoutRunner();

		}
	}

	//Handles the exit event
	private class ExitListener implements ActionListener{
			
		public void actionPerformed(ActionEvent e) {
			
			System.exit(0);
		}
	}

	//Unlocks the OrderMain.OrderStart panel
	private class winChecker extends WindowAdapter{
		
		public void windowClosed(WindowEvent e) {
			
			setEnabled(true);
			setVisible(true);
			setExtendedState(Frame.NORMAL);
			
		}
	}

	//Main point of execution
	public static void main(String[] args) {
		new OrderStart();
	}

}
