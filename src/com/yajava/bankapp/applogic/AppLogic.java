package com.yajava.bankapp.applogic;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.yajava.bankapp.customeraction.CustomerAction;
import com.yajava.bankapp.utils.PanelDesign;

/**
 * Main application class orchestrating the program
 */

public class AppLogic {

	CustomerAction customerAction = new CustomerAction(); 
	
	public void runApp() {
		// Welcome code....

		
		
		// OUTER menu
		final ImageIcon icon = new ImageIcon("src/moneybag.png"); // Icon from www.icons8.com
		
		// Inne panel size
		UIManager.put("OptionPane.minimumSize", new Dimension(250, 120));
		
		// Returned panel design objects
		JPanel returnedPanel = PanelDesign.panel("Welcome to Bank Of Bravos");
		JPanel returnedPanel2 = PanelDesign.panel("Thank You...");
		
		int choice = -1; 
		while (choice != 2) {
			String[] choices = { "Employee?", "Customer?", "Exit" };
			choice = JOptionPane.showOptionDialog(null, returnedPanel, "Bank Of Bravos",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, choices, choices[0]);
			if (choice == 0) {
				// Employee - send to inner menu for employee
				customerAction.runMenu();
			} else if (choice == 1) {
				// Employee - send to inner menu for employee

			} else {
				JOptionPane.showMessageDialog(null, returnedPanel2);
			}
		}
		
		

	}
	

}
