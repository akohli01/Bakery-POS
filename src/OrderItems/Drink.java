package OrderItems;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import OrderProcessor.OrderCalculator;

public class Drink extends JFrame {

	private JPanel titlePanel, optionsPanel, addOrder, teaPanel, coffeePanel, juicePanel;
	private JLabel title;
	private JLabel greenTea, blackTea, whiteTea;
	private JLabel regularCoffee, decafCoffee, cappuccino;
	private JLabel orangeJuice, appleJuice, grapeJuice;
	private JSpinner spinner, spinner1, spinner2, spinner3, spinner4, spinner5,
			spinner6, spinner7, spinner8;
	private JButton add, cancel;
	private final double GREEN_TEA_PRICE = 1.00, WHITE_TEA_PRICE = 1.25, BLACK_TEA_PRICE = 1.25;
	private final double REGULAR_PRICE = 1.20, DECAF_PRICE = 1.25, CAPPUCCINO_PRICE = 2.00;
	private final double APPLE_JUICE_PRICE = 1.15, ORANGE_JUICE_PRICE = 1.15, 
			             GRAPE_JUICE_PRICE = 1.15;
	

	public Drink() {

		// Set basic properties for JFrame
		setTitle("Drinks");
		setLayout(new GridBagLayout());
		setBounds(100,100,1500,700);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(Color.getHSBColor(0.15f, .20f, .97f));

		// Build the 3 JFrame panels
		titlePanelBuilder();
		optionsPanelBuilder();
		addOrderPanelBuilder();
	}

	private void titlePanelBuilder() {
		// Initialize JLabel
		title = new JLabel("Drink Options");

		// Set text formatting for JLabel
		title.setFont(new Font("Serif", Font.BOLD, 35));

		// Initialize title panel
		titlePanel = new JPanel();
		
		// Make panel transparent
			titlePanel.setOpaque(false);

		// Set layout for title panel
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

		// Add label to title panel
		titlePanel.add(title);
		
		//Set GridBagConstraint for this panel
		GridBagConstraints global = new GridBagConstraints();
		
		global.gridx= 0;
		global.gridy=0;
		global.weighty = 0.5;

		// Add title panel to JFrame
		add(titlePanel, global);

	}

	private void optionsPanelBuilder() {

		// Initialize optionsPanel
		optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

		optionsPanel.setOpaque(false);

		teaPanelBuilder();
		coffeePanelBuilder();
		juicePanelBuilder();
		
		//Set GridBagConstraint for this panel
		GridBagConstraints global = new GridBagConstraints();
		
		global.gridx= 0;
		global.gridy=1;
		global.weighty = 0.5; 
		
		// Add optionsPanel to JFrame
		add(optionsPanel, global);

	}

	private void teaPanelBuilder() {
		// Initialize OrderItems.Drink options - JLabels
        greenTea = new JLabel("Green Tea " + "($" + String.format("%.2f", GREEN_TEA_PRICE)  + " each"  + ")" );
		blackTea = new JLabel("Black Tea " + "($" + String.format("%.2f", BLACK_TEA_PRICE)  + " each"  + ")" );
		whiteTea = new JLabel("White Tea " + "($" + String.format("%.2f", WHITE_TEA_PRICE)  + " each"  + ")" );

		// Set text formatting for JLabels
		greenTea.setFont(new Font("Serif", Font.PLAIN, 22));
		whiteTea.setFont(new Font("Serif", Font.PLAIN, 22));
		blackTea.setFont(new Font("Serif", Font.PLAIN, 22));

		// Create JSpinner objects
		spinner = new JSpinner();
		spinner1 = new JSpinner();
		spinner2 = new JSpinner();

		// Set Spinner font sizes
		spinner.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner1.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner2.setFont(new Font("Serif", Font.PLAIN, 22));

		// Set sizes for spinner box
		Dimension dim = spinner.getPreferredSize();
		dim.height = 30;
		dim.width = 50;

		spinner.setPreferredSize(dim);
		spinner1.setPreferredSize(dim);
		spinner2.setPreferredSize(dim); 

		// Initialize teaPanel
		teaPanel = new JPanel(new GridBagLayout());

        //Set Background color to white
        teaPanel.setBackground(Color.WHITE);
		
		//Define GridBagConstraints
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints d = new GridBagConstraints();
		GridBagConstraints e = new GridBagConstraints();
		GridBagConstraints f = new GridBagConstraints();
		GridBagConstraints g = new GridBagConstraints();
		GridBagConstraints h = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,15,10);
		
		
		d.gridx = 1;
		d.gridy = 0;
		d.insets = new Insets(0,0,15,10);
		
		e.gridx = 0;
		e.gridy = 1;
		e.insets = new Insets(0,0,15,10);
		
		f.gridx = 1;
		f.gridy = 1;
		f.insets = new Insets(0,0,15,10);
		
		g.gridx = 0;
		g.gridy = 2;
		g.insets = new Insets(0,0,15,10);
		
		h.gridx = 1;
		h.gridy = 2;
		h.insets = new Insets(0,0,15,10);

		teaPanel.add(greenTea, c);
		teaPanel.add(spinner, d);
		teaPanel.add(blackTea, e);
		teaPanel.add(spinner1,f);
		teaPanel.add(whiteTea,g);
		teaPanel.add(spinner2,h); 

		//Set titled border for panel
				Border line = BorderFactory.createLineBorder(new Color(0,0,0), 3);
		        
		teaPanel.setBorder(BorderFactory.createCompoundBorder(
			          new TitledBorder(line, "Tea", TitledBorder.CENTER, 
			        		           TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 22) ),
					  new EmptyBorder(50, 60, 50, 60)));
	
		 //Add teaPanel to optionsPanel
		optionsPanel.add(teaPanel);

	}

	private void coffeePanelBuilder() {
		// Initialize OrderItems.Drink options - JLabels
		regularCoffee = new JLabel("Regular " + "($" + String.format("%.2f", REGULAR_PRICE)  + " each"  + ")" );
		decafCoffee = new JLabel("Decaffeinated Coffee "+ "($" + String.format("%.2f", DECAF_PRICE)  + " each"  + ")" );
		cappuccino = new JLabel("Cappuccino " + "($" + String.format("%.2f", CAPPUCCINO_PRICE)  + " each"  + ")" );
		
		// Set text formatting for JLabels
		regularCoffee.setFont(new Font("Serif", Font.PLAIN, 22));
		decafCoffee.setFont(new Font("Serif", Font.PLAIN, 22));
		cappuccino.setFont(new Font("Serif", Font.PLAIN, 22));

		// Create JSpinner objects
		spinner3 = new JSpinner();
		spinner4 = new JSpinner();
		spinner5 = new JSpinner();

		// Set Spinner font sizes
		spinner3.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner4.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner5.setFont(new Font("Serif", Font.PLAIN, 22));

		// Set sizes for spinner box
		Dimension dim = spinner3.getPreferredSize();
		dim.height = 30;
		dim.width = 50;

		spinner3.setPreferredSize(dim);
		spinner4.setPreferredSize(dim);
		spinner5.setPreferredSize(dim);

		// Initialize coffeePanel
         coffeePanel = new JPanel(new GridBagLayout());

        //Set Background color to white
        coffeePanel.setBackground(Color.WHITE);

         //Define GridBagConstraints
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints d = new GridBagConstraints();
        GridBagConstraints e = new GridBagConstraints();
        GridBagConstraints f = new GridBagConstraints();
        GridBagConstraints g = new GridBagConstraints();
        GridBagConstraints h = new GridBagConstraints();
				
				c.gridx = 0;
				c.gridy = 0;
				c.insets = new Insets(0,0,15,10);
				
				
				d.gridx = 1;
				d.gridy = 0;
				d.insets = new Insets(0,0,15,10);
				
				e.gridx = 0;
				e.gridy = 1;
				e.insets = new Insets(0,0,15,10);
				
				f.gridx = 1;
				f.gridy = 1;
				f.insets = new Insets(0,0,15,10);
				
				g.gridx = 0;
				g.gridy = 2;
				g.insets = new Insets(0,0,15,10);
				
				h.gridx = 1;
				h.gridy = 2;
				h.insets = new Insets(0,0,15,10);

			

		coffeePanel.add(regularCoffee,c);
		coffeePanel.add(spinner3,d);
		coffeePanel.add(decafCoffee,e);
		coffeePanel.add(spinner4,f);
		coffeePanel.add(cappuccino,g);
		coffeePanel.add(spinner5, h);

		//Set titled border for panel
				Border line = BorderFactory.createLineBorder(new Color(0,0,0), 3);
		        
		coffeePanel.setBorder(BorderFactory.createCompoundBorder(
			          new TitledBorder(line, "Coffee", TitledBorder.CENTER, 
			        		           TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 22) ),
					  new EmptyBorder(50, 60, 50, 60)));
        
        //Add coffeePanel to optionsPanel
		optionsPanel.add(coffeePanel);

	}

	private void juicePanelBuilder() {
		// Initialize OrderItems.Drink options - JLabels
		orangeJuice = new JLabel("Orange Juice " + "($" + String.format("%.2f", ORANGE_JUICE_PRICE)  + " each"  + ")" );
		appleJuice = new JLabel("Apple Juice "  + "($" + String.format("%.2f", APPLE_JUICE_PRICE)  + " each"  + ")" );
		grapeJuice = new JLabel("Grape Juice " + "($" + String.format("%.2f", GRAPE_JUICE_PRICE)  + " each"  + ")" );

		// Set text formatting for JLabels
		orangeJuice.setFont(new Font("Serif", Font.PLAIN, 22));
		appleJuice.setFont(new Font("Serif", Font.PLAIN, 22));
		grapeJuice.setFont(new Font("Serif", Font.PLAIN, 22));

		// Create JSpinner objects
		spinner6 = new JSpinner();
		spinner7 = new JSpinner();
		spinner8 = new JSpinner();

		// Set Spinner font sizes
		spinner6.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner7.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner8.setFont(new Font("Serif", Font.PLAIN, 22));

		// Set sizes for spinner box
		Dimension dim = spinner6.getPreferredSize();
		dim.height = 30;
		dim.width = 50;

		spinner6.setPreferredSize(dim);
		spinner7.setPreferredSize(dim);
		spinner8.setPreferredSize(dim);

		// Initialize juicePanel
		juicePanel = new JPanel(new GridBagLayout());

        //Set Background color to white
        juicePanel.setBackground(Color.WHITE);
		
		//Define GridBagConstraints
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints d = new GridBagConstraints();
		GridBagConstraints e = new GridBagConstraints();
		GridBagConstraints f = new GridBagConstraints();
		GridBagConstraints g = new GridBagConstraints();
		GridBagConstraints h = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,15,10);
		
		
		d.gridx = 1;
		d.gridy = 0;
		d.insets = new Insets(0,0,15,10);
		
		e.gridx = 0;
		e.gridy = 1;
		e.insets = new Insets(0,0,15,10);
		
		f.gridx = 1;
		f.gridy = 1;
		f.insets = new Insets(0,0,15,10);
		
		g.gridx = 0;
		g.gridy = 2;
		g.insets = new Insets(0,0,15,10);
		
		h.gridx = 1;
		h.gridy = 2;
		h.insets = new Insets(0,0,15,10);
		
		juicePanel.add(orangeJuice,c);
		juicePanel.add(spinner6,d);
		juicePanel.add(appleJuice,e);
		juicePanel.add(spinner7,f);
		juicePanel.add(grapeJuice,g);
		juicePanel.add(spinner8,h);

		//Set titled border for panel
		Border line = BorderFactory.createLineBorder(new Color(0,0,0), 3);
        
juicePanel.setBorder(BorderFactory.createCompoundBorder(
	          new TitledBorder(line, "Juice", TitledBorder.CENTER, 
	        		           TitledBorder.CENTER, new Font("Serif", Font.PLAIN, 22) ),
			  new EmptyBorder(50, 60, 50, 60)));
		        
		//Add juicePanel to optionsPanel
		optionsPanel.add(juicePanel);
	}

	private void addOrderPanelBuilder() {
		// Initialize JButtons
		add = new JButton("Add to order");
		cancel = new JButton("Cancel selection");

		// Set Text formatting for JButtons
		add.setFont(new Font("Serif", Font.PLAIN, 22));
		cancel.setFont(new Font("Serif", Font.PLAIN, 22));

		// Add in actionListener method
		cancel.addActionListener(new ExitListener());
		add.addActionListener(new AddListener());

		// Initialize addOrder panel
		addOrder = new JPanel();
		
		// Make panel transparent
					addOrder.setOpaque(false);

		// Set Layout for addOrder panel
		addOrder.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 70));

		// Add JButtons to addOrder panel
		addOrder.add(add);
		addOrder.add(cancel);

		//Set GridBagConstraint for this panel
		GridBagConstraints global = new GridBagConstraints();
		
		global.gridx= 0;
		global.gridy=2;
		global.weighty = 0.5;
		
		// Add addOrder panel to JFrame
		add(addOrder, global);
	}

	private class AddListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int quantity = (Integer) spinner.getValue();
    	   	int quantity1 = (Integer) spinner1.getValue();
    	   	int quantity2 = (Integer) spinner2.getValue();
    	   	int quantity3 = (Integer) spinner3.getValue();
    	   	int quantity4 = (Integer) spinner4.getValue();
    	   	int quantity5 = (Integer) spinner5.getValue();
    	 	int quantity6 = (Integer) spinner6.getValue();
    	 	int quantity7 = (Integer) spinner7.getValue();
    	 	int quantity8 = (Integer) spinner8.getValue();

			if (quantity != 0)
				OrderCalculator.displayOrderInfo(quantity, greenTea.getText(),
						GREEN_TEA_PRICE, "drink");
			if (quantity1 != 0)
				OrderCalculator.displayOrderInfo(quantity1, blackTea.getText(),
						BLACK_TEA_PRICE, "drink");
			if (quantity2 != 0)
				OrderCalculator.displayOrderInfo(quantity2, whiteTea.getText(),
						WHITE_TEA_PRICE, "drink");
			if (quantity3 != 0)
				OrderCalculator.displayOrderInfo(quantity3, regularCoffee.getText(),
						REGULAR_PRICE, "drink");
			if (quantity4 != 0)
				OrderCalculator.displayOrderInfo(quantity4, decafCoffee.getText(),
						DECAF_PRICE, "drink");
			if (quantity5 != 0)
				OrderCalculator.displayOrderInfo(quantity5, cappuccino.getText(),
			     CAPPUCCINO_PRICE, "drink");
			if (quantity6 != 0)
				OrderCalculator.displayOrderInfo(quantity6, orangeJuice.getText(),
						ORANGE_JUICE_PRICE, "drink");
			if (quantity7 != 0)
				OrderCalculator.displayOrderInfo(quantity7, appleJuice.getText(),
						APPLE_JUICE_PRICE, "drink");
			if (quantity8 != 0)
				OrderCalculator.displayOrderInfo(quantity8, grapeJuice.getText(),
						GRAPE_JUICE_PRICE, "drink");

			dispose();
		}
	}

	private class ExitListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			dispose();
		}
	}

}
