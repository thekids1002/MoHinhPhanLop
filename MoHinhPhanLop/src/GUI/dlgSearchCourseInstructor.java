
package GUI;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.CourseInstructorBLL;
import DTO.CourseInstructor;
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

public class dlgSearchCourseInstructor extends JDialog {
	private CourseInstructorBLL courseInstructorBLL;
	private JPanel contentPane;
	private JTextField txtKeyWord;
	private JCheckBox cbxFindByLectureID;
	private JCheckBox cbxFindByDay;
	private JButton btnSearch;
	private JCheckBox cbxFindByCourseID;
	private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public dlgSearchCourseInstructor() {

		CheckboxGroup cbg = new CheckboxGroup();
		setTitle("Tìm Kiếm Phân Công");
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

		JLabel lblNewLabel = new JLabel("Nhập Từ Khoá Cần Tìm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 50, 175, 54);
		contentPane.add(lblNewLabel);
		buttonGroup = new ButtonGroup();
		cbxFindByCourseID = new JCheckBox("Tìm Theo Mã Khoá Học");
		cbxFindByCourseID.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbxFindByCourseID.setBounds(82, 159, 201, 21);
		contentPane.add(cbxFindByCourseID);

		cbxFindByLectureID = new JCheckBox("Tìm Theo Mã Giáo Viên");
		cbxFindByLectureID.setSelected(true);
		cbxFindByLectureID.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbxFindByLectureID.setBounds(309, 159, 215, 21);
		contentPane.add(cbxFindByLectureID);

		cbxFindByDay = new JCheckBox("Tìm theo ngày đăng kí");
		cbxFindByDay.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbxFindByDay.setBounds(353, 159, 205, 21);
		// contentPane.add(cbxFindByDay);

		btnSearch = new JButton("Tìm");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(205, 230, 157, 44);
		contentPane.add(btnSearch);
		buttonGroup.add(cbxFindByDay);
		buttonGroup.add(cbxFindByLectureID);
		buttonGroup.add(cbxFindByCourseID);
		courseInstructorBLL = new CourseInstructorBLL();
		addEvent();
	}

	private void addEvent() {
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtKeyWord.getText();
				if (!isNumber(id)) {
					JOptionPane.showMessageDialog(null, "ID phải là số");
					return;
				}
				if (cbxFindByCourseID.isSelected()) {
					int ID = Integer.parseInt(id);
					SearchByCourseID(ID);
				} else if (cbxFindByLectureID.isSelected()) {
					int ID = Integer.parseInt(id);
					SearchByLectureID(ID);
				} else {
					JOptionPane.showMessageDialog(null, "Chưa chọn cách tìm kiếm");
				}

			}

		});

	}

	protected void SearchByLectureID(int ID) {
		ArrayList<DTO.CourseInstructor> arrayList = courseInstructorBLL.searchByLectureID(ID);
		MainFrame.dtmCourseInstructor.setRowCount(0);
		int i = 0;
		for (CourseInstructor courseInstructor : arrayList) {
			i++;
			Vector<Object> vec = new Vector<Object>();
			vec.add(String.valueOf(i));
			for (DTO.Course course : MainFrame.coursesList) {
				if (course.getCourseID() == courseInstructor.getCourseID()) {
					vec.add(course.getTitle());
					break;
				}
			}
			for (DTO.Person per : MainFrame.lecturesList) {
				if (per.getID() == courseInstructor.getPersonID()) {
					vec.add(per.getFirstname() + " " + per.getLastname());
					break;
				}
			}

			MainFrame.dtmCourseInstructor.addRow(vec);
		}

	}

	protected void SearchByCourseID(int ID) {

		ArrayList<DTO.CourseInstructor> arrayList = courseInstructorBLL.searchByCourseID(ID);
		MainFrame.dtmCourseInstructor.setRowCount(0);
		int i = 0;
		for (CourseInstructor courseInstructor : arrayList) {
			i++;
			Vector<Object> vec = new Vector<Object>();
			vec.add(String.valueOf(i));
			for (DTO.Course course : MainFrame.coursesList) {
				if (course.getCourseID() == courseInstructor.getCourseID()) {
					vec.add(course.getTitle());
					break;
				}
			}
			for (DTO.Person per : MainFrame.lecturesList) {
				if (per.getID() == courseInstructor.getPersonID()) {
					vec.add(per.getFirstname() + " " + per.getLastname());
					break;
				}
			}

			MainFrame.dtmCourseInstructor.addRow(vec);
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
