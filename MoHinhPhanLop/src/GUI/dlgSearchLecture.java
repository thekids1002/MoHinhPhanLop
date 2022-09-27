
package GUI;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.Person;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class dlgSearchLecture extends JDialog {

	private JPanel contentPane;
	private JTextField txtKeyWord;
	private JCheckBox cbxFindByID;
	private JCheckBox cbxFindByDay;
	private JButton btnSearchStudents;
	private JCheckBox cbxFindByName;
	private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public dlgSearchLecture() {

		CheckboxGroup cbg = new CheckboxGroup();
		setTitle("Tìm Kiếm Giáo Viên");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 583, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtKeyWord = new JTextField();
		txtKeyWord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtKeyWord.setBounds(194, 51, 348, 54);
		contentPane.add(txtKeyWord);
		txtKeyWord.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nhập Từ Khoá Cần Tìm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 50, 175, 54);
		contentPane.add(lblNewLabel);
		buttonGroup = new ButtonGroup();
		cbxFindByName = new JCheckBox("Tìm Theo Tên");
		cbxFindByName.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbxFindByName.setBounds(137, 159, 146, 21);
		contentPane.add(cbxFindByName);

		cbxFindByID = new JCheckBox("Tìm Theo Mã");
		cbxFindByID.setSelected(true);
		cbxFindByID.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbxFindByID.setBounds(309, 159, 146, 21);
		contentPane.add(cbxFindByID);

		cbxFindByDay = new JCheckBox("Tìm theo ngày đăng kí");
		cbxFindByDay.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbxFindByDay.setBounds(353, 159, 205, 21);
		// contentPane.add(cbxFindByDay);

		btnSearchStudents = new JButton("Tìm");
		btnSearchStudents.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchStudents.setBounds(205, 230, 157, 44);
		contentPane.add(btnSearchStudents);
		buttonGroup.add(cbxFindByDay);
		buttonGroup.add(cbxFindByID);
		buttonGroup.add(cbxFindByName);
		addEvent();
	}

	private void addEvent() {
		btnSearchStudents.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbxFindByName.isSelected()) {
					SearchByName();
				} else if (cbxFindByID.isSelected()) {
					SearchByID();
				} else if (cbxFindByDay.isSelected()) {
					SearchByDay();
				} else {
					JOptionPane.showMessageDialog(null, "Chưa chọn cách tìm kiếm");
				}

			}

		});

	}

	private void SearchByID() {
		String ID = txtKeyWord.getText().trim();
		if (isNumber(ID)) {
			System.out.println("Ok");
			ArrayList<Person> list = new BLL.LectureBLL().searchByID(Integer.parseInt(ID));
			System.out.println(list);
			if (list != null && list.size() > 0) {
				MainFrame.dtmLecture.setRowCount(0);
				repaintPage();
				for (Person person : list) {
					Vector<Object> vec = new Vector<Object>();
					vec.add(person.getID());
					vec.add(person.getFirstname());
					vec.add(person.getLastname());
					vec.add(person.getHireDate());
					MainFrame.dtmLecture.addRow(vec);
					this.setVisible(false);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "ID phải là số");
		}
	}

	private void repaintPage() {
		MainFrame.pnPageLecture.removeAll();
		MainFrame.pnPageLecture.revalidate();
		MainFrame.pnPageLecture.repaint();
	}

	protected void SearchByDay() {

	}

	protected void SearchByName() {
		String Name = txtKeyWord.getText().trim();
		if (!isNumber(Name)) {

			ArrayList<Person> list = new BLL.LectureBLL().searchByName(Name);
			if (list != null && list.size() > 0) {
				MainFrame.dtmLecture.setRowCount(0);
				repaintPage();
				for (Person person : list) {
					Vector<Object> vec = new Vector<Object>();
					vec.add(person.getID());
					vec.add(person.getFirstname());
					vec.add(person.getLastname());
					vec.add(person.getHireDate());
					MainFrame.dtmLecture.addRow(vec);
					this.setVisible(false);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Không tìm thấy");
			}
		}

	}

	public boolean isNumber(String s) {
		try {
			int a = Integer.parseInt(s);
			return true;
		} catch (Exception e) {

			return false;
		}
	}
}
