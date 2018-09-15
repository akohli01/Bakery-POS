package OrderItems;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import OrderProcessor.OrderCalculator;

public class Cake extends JFrame{
	
	private JPanel titlePanel, optionsPanel, addOrder;
	private JLabel title;
	private JLabel chocolate, carrot, redVelvet, butter, coconut, pound; 
	private JSpinner spinner, spinner1, spinner2, spinner3, spinner4, spinner5;
	private JButton add, cancel;
	private final double CHOCOLATE_PRICE = 7.00, CARROT_PRICE = 7.50, RED_VELVET_PRICE= 8.00,
			             BUTTER_PRICE = 7.00, COCONUT_PRICE = 7.50, POUND_PRICE = 7.00;
	
	public Cake() {
		
		//Set basic properties for JFrame
		setTitle("Cake");
		setLayout(new GridBagLayout());
		setBounds(100,100,1500,700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(Color.getHSBColor(0.15f, .20f, .97f));

		//Build the 3 JFrame panels 
		titlePanelBuilder();
		optionsPanelBuilder();
		addOrderPanelBuilder();		
	}
	
	private void titlePanelBuilder() {
		
		        //Initialize JLabel
				title = new JLabel("Cake Options");
				
				//Set text formatting for JLabel
				title.setFont(new Font("Serif", Font.BOLD, 35));
				
				//Initialize title panel
				titlePanel = new JPanel();
				
				// Make panel transparent
				titlePanel.setOpaque(false);
				
				//Set layout for title panel
				titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
				
				//Add label to title panel
				titlePanel.add(title);
				
				//Set GridBagConstraint for this panel
				GridBagConstraints global = new GridBagConstraints();
				
				global.gridx= 0;
				global.gridy=0;
				global.weighty = 0.5;
				
				//Add title panel to JFrame
				add(titlePanel, global);
		
	}
	
	private void optionsPanelBuilder() {
		
		//Initialize bagel options - JLabels
		chocolate = new JLabel("Chocolate Cake " + "($" + String.format("%.2f",CHOCOLATE_PRICE)  + " each" +  ")");
		carrot = new JLabel("Carrot Cake" + "($" + String.format("%.2f",CARROT_PRICE) +" each" +  ")");
		redVelvet = new JLabel("Red Velvet Cake " + "($" + String.format("%.2f",RED_VELVET_PRICE) + " each" +  ")");
		coconut= new JLabel("Coconut Cake " + "($" + String.format("%.2f",COCONUT_PRICE) + " each" +  ")");
		butter = new JLabel("Butter Cake " + "($" + String.format("%.2f",BUTTER_PRICE) + " each" +  ")");
		pound = new JLabel("Pound Cake " + "($" + String.format("%.2f",POUND_PRICE) + " each" +  ")");
		
		//Set text formatting for JLabels
		chocolate.setFont(new Font("Serif", Font.PLAIN, 22));
		carrot.setFont(new Font("Serif", Font.PLAIN, 22));
		redVelvet.setFont(new Font("Serif", Font.PLAIN, 22));
		coconut.setFont(new Font("Serif", Font.PLAIN, 22));
		butter.setFont(new Font("Serif", Font.PLAIN, 22));
		pound.setFont(new Font("Serif", Font.PLAIN, 22));
		
		
		//Initialize optionsPanel
		optionsPanel = new JPanel(new GridBagLayout());

        //Set Background color to white
        optionsPanel.setBackground(Color.WHITE);
					
		//Define GridBagConstraints
				GridBagConstraints c = new GridBagConstraints();
				GridBagConstraints d = new GridBagConstraints();
				GridBagConstraints e = new GridBagConstraints();
				GridBagConstraints f = new GridBagConstraints();
				GridBagConstraints g = new GridBagConstraints();
				GridBagConstraints h = new GridBagConstraints();
				GridBagConstraints i = new GridBagConstraints();
				GridBagConstraints j = new GridBagConstraints();
				GridBagConstraints k = new GridBagConstraints();
				GridBagConstraints l = new GridBagConstraints();
				GridBagConstraints m = new GridBagConstraints();
				GridBagConstraints n = new GridBagConstraints();
				
				c.gridx = 0;
				c.gridy = 0;
				c.insets = new Insets(0,0,20,20);
				
				
				d.gridx = 1;
				d.gridy = 0;
				d.insets = new Insets(0,0,20,20);
				
				e.gridx = 2;
				e.gridy = 0;
				e.insets = new Insets(0,0,20,20);
				
				f.gridx = 3;
				f.gridy = 0;
				f.insets = new Insets(0,0,20,20);
				
				g.gridx = 4;
				g.gridy = 0;
				g.insets = new Insets(0,0,20,20);
				
				h.gridx = 5;
				h.gridy = 0;
				h.insets = new Insets(0,0,20,20);
			
				i.gridx = 0;
				i.gridy = 1;
				i.weightx = 0.5;
				i.insets = new Insets(0,0,0,20);
				
				j.gridx = 1;
				j.gridy = 1;
				j.weightx = 0.5;
				j.insets = new Insets(0,0,0,20);

				k.gridx = 2;
				k.gridy = 1;
				k.weightx = 0.5;
				k.insets = new Insets(0,0,0,20);
				
				l.gridx = 3;
				l.gridy = 1;
				l.weightx = 0.5;
				l.insets = new Insets(0,0,0,20);

				m.gridx = 4;
				m.gridy = 1;
				m.weightx = 0.5;
				m.insets = new Insets(0,0,0,20);
				
				n.gridx = 5;
				n.gridy = 1;
				n.weightx = 0.5;
				n.insets = new Insets(0,0,0,20);
		
				//Create a SpinnerModel that will be used for the JSpinner objects
				 SpinnerModel value =  new SpinnerNumberModel(0, 0, 100 ,1);
				 SpinnerModel value1 =  new SpinnerNumberModel(0, 0, 100 ,1);
				 SpinnerModel value2 =  new SpinnerNumberModel(0, 0, 100 ,1); 
				 SpinnerModel value3 =  new SpinnerNumberModel(0, 0, 100 ,1); 
				 SpinnerModel value4 =  new SpinnerNumberModel(0, 0, 100 ,1); 
				 SpinnerModel value5 =  new SpinnerNumberModel(0, 0, 100 ,1); 
				 
					//Create JSpinner objects
					spinner = new JSpinner(value); 
					spinner1 = new JSpinner(value1); 
					spinner2 = new JSpinner(value2); 
					spinner3 = new JSpinner(value3); 
					spinner4 = new JSpinner(value4); 
					spinner5 = new JSpinner(value5); 
		
		//Set Spinner font sizes
		spinner.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner1.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner2.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner3.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner4.setFont(new Font("Serif", Font.PLAIN, 22));
		spinner5.setFont(new Font("Serif", Font.PLAIN, 22));
		
		//Set sizes for spinner box
		 Dimension dim = spinner.getPreferredSize();
	        dim.height = 30;
	        dim.width = 50;
	        
	        spinner.setPreferredSize(dim);
	        spinner1.setPreferredSize(dim);
	        spinner2.setPreferredSize(dim);
	        spinner3.setPreferredSize(dim);
	        spinner4.setPreferredSize(dim);
	        spinner5.setPreferredSize(dim);
		
		//Add bagel options to JPanel optionsPanel
		optionsPanel.add(chocolate, c );
		optionsPanel.add(spinner, d);
		optionsPanel.add(carrot, e);
		optionsPanel.add(spinner1, f);
		optionsPanel.add(redVelvet, g);
		optionsPanel.add(spinner2, h);
		optionsPanel.add(coconut, i);
		optionsPanel.add(spinner3, j);
		optionsPanel.add(butter, k);
		optionsPanel.add(spinner4, l);
		optionsPanel.add(pound, m);
		optionsPanel.add(spinner5, n);
		
		//Set GridBagConstraint for this panel
		GridBagConstraints global = new GridBagConstraints();
		
		global.gridx= 0;
		global.gridy=1;
		global.weighty = 0.5;

		//Add optionsPanel to JFrame
		add(optionsPanel, global);
		
	}
	
	private void addOrderPanelBuilder() {
				//Initialize JButtons
				add = new JButton("Add to order");
				cancel = new JButton("Cancel selection");
				
				//Set Text formatting for JButtons
				add.setFont(new Font("Serif", Font.PLAIN, 22));
				cancel.setFont(new Font("Serif", Font.PLAIN, 22));
				
				//Add in actionListener method
				cancel.addActionListener(new ExitListener());
				add.addActionListener(new AddListener());
				
				//Initialize addOrder panel
				addOrder = new JPanel();
				
				// Make panel transparent
				addOrder.setOpaque(false);
				
				//Set Layout for addOrder panel
				addOrder.setLayout(new FlowLayout(FlowLayout.CENTER,50,70));
				
				//Add JButtons to addOrder panel
				addOrder.add(add);
				addOrder.add(cancel);
				
				//Set GridBagConstraint for this panel
				GridBagConstraints global = new GridBagConstraints();
				
				global.gridx= 0;
				global.gridy=2;
				global.weighty = 0.5;

				
				//Add addOrder panel to JFrame
				add(addOrder, global);
				
				//Set border for panel
				optionsPanel.setBorder(BorderFactory.createCompoundBorder(new LineBorder(new Color(0,0,0), 3),
						new EmptyBorder(50, 70, 50, 70)));
	}
	
	private class AddListener implements ActionListener{
		
       public void actionPerformed(ActionEvent e) {
			
    	   int quantity = (Integer) spinner.getValue();
   	   	int quantity1 = (Integer) spinner1.getValue();
   	   	int quantity2 = (Integer) spinner2.getValue();
   	   	int quantity3 = (Integer) spinner3.getValue();
   	   	int quantity4 = (Integer) spinner4.getValue();
   	   	int quantity5 = (Integer) spinner5.getValue();
    	   		
		    if(quantity != 0) 
		    	OrderCalculator.displayOrderInfo(quantity, chocolate.getText(), CHOCOLATE_PRICE, "cake" );
		    if(quantity1 != 0) 
		    	OrderCalculator.displayOrderInfo(quantity1, carrot.getText(), CARROT_PRICE, "cake");
		    if(quantity2 != 0) 
		    	OrderCalculator.displayOrderInfo(quantity2, redVelvet.getText(), RED_VELVET_PRICE, "cake");
		    if(quantity3 != 0) 
		    	OrderCalculator.displayOrderInfo(quantity3, coconut.getText(), COCONUT_PRICE, "cake" );
		    if(quantity4 != 0) 
		    	OrderCalculator.displayOrderInfo(quantity4, butter.getText(), BUTTER_PRICE, "cake" );
		    if(quantity5 != 0) 
		    	OrderCalculator.displayOrderInfo(quantity5, pound.getText(), POUND_PRICE, "cake" );

		    	dispose();
		}
	}
	
	private class ExitListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			dispose();
		}
	}

}

