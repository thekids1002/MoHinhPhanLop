
package GUI;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.Course;
import DTO.CourseInstructor;
import DTO.Department;
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

public class dlgSearchCourse extends JDialog {

	private JPanel contentPane;
	private JTextField txtKeyWord;
	private JCheckBox cbxFindOnline;
	private JCheckBox cbxFindByDay;
	private JButton btnSearch;
	private JCheckBox cbxFindOnsite;
	private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public dlgSearchCourse() {

		CheckboxGroup cbg = new CheckboxGroup();
		setTitle("Tìm Kiếm Khoá Học");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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

		JLabel lblNewLabel = new JLabel("Nhập Mã Khoá Học");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 50, 175, 54);
		contentPane.add(lblNewLabel);
		buttonGroup = new ButtonGroup();
		cbxFindOnsite = new JCheckBox("Tìm Khoa Hoc Onsite");
		cbxFindOnsite.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbxFindOnsite.setBounds(82, 159, 201, 21);
		contentPane.add(cbxFindOnsite);

		cbxFindOnline = new JCheckBox("Tìm Khoa Hoc Online");
		cbxFindOnline.setSelected(true);
		cbxFindOnline.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbxFindOnline.setBounds(309, 159, 215, 21);
		contentPane.add(cbxFindOnline);

		cbxFindByDay = new JCheckBox("Tìm theo ngày đăng kí");
		cbxFindByDay.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbxFindByDay.setBounds(353, 159, 205, 21);
		// contentPane.add(cbxFindByDay);

		btnSearch = new JButton("Tìm");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(205, 230, 157, 44);
		contentPane.add(btnSearch);
		buttonGroup.add(cbxFindByDay);
		buttonGroup.add(cbxFindOnline);
		buttonGroup.add(cbxFindOnsite);
		addEvent();
	}

	private void addEvent() {
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtKeyWord.getText();
				if(!isNumber(id)) {
					JOptionPane.showMessageDialog(null, "ID phải là số");
					return;
				}
				if (cbxFindOnsite.isSelected()) {
					int ID = Integer.parseInt(id);
					SearchOnsite(ID);
				} else if (cbxFindOnline.isSelected()) {
					int ID = Integer.parseInt(id);
					SearchOnline(ID);
				} else {
					JOptionPane.showMessageDialog(null, "Chưa chọn cách tìm kiếm");
				}

			}

		});

	}

	protected void SearchOnline(int iD) {
		ArrayList<Course> arrayList = BLL.CourseBLL.searchOnline(iD);
		if(arrayList != null && arrayList.size() > 0) {
			int i = 0;
			MainFrame.dtmcourseOnline.setRowCount(0);
			for (Course course : arrayList) {
				i++;
				Vector<Object> vec = new Vector<Object>();
				vec.add(String.valueOf(i));
				vec.add(course.getCourseID());
				vec.add(course.getTitle());
				for (Department department : MainFrame.departmentsList) {
					if (department.getDepartmentID() == course.getDepartmentID()) {
						vec.add(department.getName());
						break;
					}
				}
				vec.add(course.getOnlineCourse().getUrl());
				MainFrame.dtmcourseOnline.addRow(vec);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy");
		}
	}

	protected void SearchOnsite(int iD) {
		ArrayList<Course> arrayList = new BLL.CourseBLL().searchOnsite(iD);
		if( arrayList != null && arrayList.size() > 0) {
			MainFrame.dtmcourseSite.setRowCount(0);
			int i = 0;
			for (Course course : arrayList) {
				i++;
				Vector<Object> vec = new Vector<Object>();
				vec.add(String.valueOf(i));
				vec.add(course.getCourseID());
				vec.add(course.getTitle());
				for (Department department : MainFrame.departmentsList) {
					if (department.getDepartmentID() == course.getDepartmentID()) {
						vec.add(department.getName());
						break;
					}
				}
				vec.add(course.getOnsiteCourse().getLocation());
				vec.add(course.getOnsiteCourse().getDays());
				vec.add(course.getOnsiteCourse().getTime());
				MainFrame.dtmcourseSite.addRow(vec);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy");
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
