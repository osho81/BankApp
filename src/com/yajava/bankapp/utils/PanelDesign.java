package com.yajava.bankapp.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class with static method returning panel (design) for JOption
 */

public class PanelDesign {
	
	public static JPanel panel(String string) {
		
		// Inner panel design & associated text label
		JPanel panel = new JPanel();
		panel.setBackground(Color.black); // Or (new Color(70, 100, 100));
		panel.setSize(new Dimension(100, 100));
		panel.setLayout(null);
		
		JLabel label1 = new JLabel(string);
		label1.setVerticalAlignment(SwingConstants.CENTER);
		label1.setBounds(-5, 20, 200, 10);
		label1.setFont(new Font("Arial", Font.BOLD, 12));
		label1.setForeground(Color.green);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label1); // Connect label to above panel
		
		return panel;
		
	}
	

}
