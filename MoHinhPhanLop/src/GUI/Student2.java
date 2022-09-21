package GUI;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

public class Student2 extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel panel ;
	public Student2() {
		panel = new JPanel();
		panel.setSize(955, 663);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(489, 162, 45, 13);
		panel.add(lblNewLabel);
		panel.setBackground(Color.black);
	}

}
