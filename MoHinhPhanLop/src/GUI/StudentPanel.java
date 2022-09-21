package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class StudentPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel panel ;
	public StudentPanel() {
		panel = new JPanel();
		panel.setSize(955, 663);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("New sagdasgdgagdsaglabel");
		lblNewLabel.setBounds(489, 162, 45, 13);
		panel.add(lblNewLabel);
	}
}
