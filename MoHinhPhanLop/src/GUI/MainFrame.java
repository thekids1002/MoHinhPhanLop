package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTD;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import BLL.LectureBLL;
import BLL.StudentBLL;
import DTO.Department;
import DTO.Person;
import DTO.StudentGrade;
import BLL.StudentGradeBLL;
import BLL.CourseInstructorBLL;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	CardLayout cardLayout;
	private JPanel CourseCard;
	private JLabel lblCourseCard;
	private JPanel CourseIntructorCard;
	private JLabel lblCourseIntructor;
	private JPanel GradeCard;
	private JLabel lblStudentGrade;
	private JPanel panel;
	private JButton btnStudent;
	private JButton btnLecture;
	private JButton btnCourse;
	private JButton btnCourseIntructor;
	private JButton btnGrade;
	private JPanel pnCards;
	private JPanel StudentCard;
	private JLabel lblStudents;
	private JPanel LectureCard;
	private JLabel lblLecture;
	private JTextField txtStudentsFirstName;
	private JTextField txtStudentLastName;
	private JTable tblStudents;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtLectureFirstName;
	private JTextField txtLectureLastName;
	private JTable tblLectures;
	private DefaultTableModel dtmLecture;
	private JButton btnLectureEdit;
	private JButton btnLectureAdd;
	private JDateChooser dateLectures;
	private JButton btnLectureDelete;
	private JButton btnLectureReload;
	private JButton btnAddStudent;
	private JButton btnEditStudent;
	private DefaultTableModel dtmStudent;
	private JDateChooser dateEnrollment;
	private JButton btnDeleteStudent;
	private JButton btnReloadStudents;
	private JButton btnAddCourse;
	private JButton btnEditCourse;
	private Container btnDeleteCourse;
	private JButton btnReloadCourse;
	private JDateChooser dateCourse;
	private JComboBox cmbDepartment;
	private DefaultTableModel dtmStudentGrade;
	private JButton btnAddStudentGrade;
	private JButton btnEditStudentGrade;
	private JButton btnDeleteStudentGrade;
	private JButton btnReloadStudentGrade;
	private DefaultTableModel dtmCourseInstructor;
	private JButton btnAddCourseInstructor;
	private JButton btnEditCourseInstructor;
	private JButton btnDeleteCourseInstructor;
	private JButton btnReloadCourseInstructor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
								.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (ClassNotFoundException ex) {

					} catch (InstantiationException ex) {

					} catch (IllegalAccessException ex) {

					} catch (javax.swing.UnsupportedLookAndFeelException ex) {

					}
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		addControl();

		addEvent();
		initData();

	}

	private void addControl() {
		panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(0, 0, 291, 683);
		contentPane.add(panel);
		panel.setLayout(null);

		btnStudent = new JButton("Quản Lý Sinh Viên");

		btnStudent.setBounds(35, 59, 237, 49);
		panel.add(btnStudent);

		btnLecture = new JButton("Quản Lý Giáo Viên");

		btnLecture.setBounds(35, 134, 237, 49);
		panel.add(btnLecture);

		btnCourse = new JButton("Quản Lý Khoá Học");

		btnCourse.setBounds(35, 214, 237, 49);
		panel.add(btnCourse);

		btnCourseIntructor = new JButton("Quản Lý Phân Công");

		btnCourseIntructor.setBounds(35, 290, 237, 49);
		panel.add(btnCourseIntructor);

		btnGrade = new JButton("Quản Lý Kết Quả");

		btnGrade.setBounds(35, 366, 237, 49);
		panel.add(btnGrade);

		pnCards = new JPanel();
		pnCards.setBounds(301, 10, 955, 663);
		contentPane.add(pnCards);
		pnCards.setLayout(new CardLayout(0, 0));
		/* STUDENT CARD */
		StudentCard = new JPanel();
		pnCards.add(StudentCard, "StudentCard");
		StudentCard.setLayout(null);

		lblStudents = new JLabel("Quản lý sinh viên");
		lblStudents.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudents.setForeground(Color.RED);
		lblStudents.setBounds(401, 10, 196, 38);
		StudentCard.add(lblStudents);

		dateEnrollment = new JDateChooser();
		dateEnrollment.setBounds(484, 195, 205, 38);
		StudentCard.add(dateEnrollment);

		JLabel lblNewLabel = new JLabel("Tên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(294, 131, 60, 38);
		StudentCard.add(lblNewLabel);

		JLabel lblHVTn = new JLabel("Họ Và Tên Lót");
		lblHVTn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHVTn.setBounds(294, 75, 121, 38);
		StudentCard.add(lblHVTn);

		JLabel lblNgyngK = new JLabel("Ngày Đăng Kí");
		lblNgyngK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgyngK.setBounds(294, 195, 121, 38);
		StudentCard.add(lblNgyngK);

		txtStudentsFirstName = new JTextField();
		txtStudentsFirstName.setBounds(484, 78, 202, 38);
		StudentCard.add(txtStudentsFirstName);
		txtStudentsFirstName.setColumns(10);

		txtStudentLastName = new JTextField();
		txtStudentLastName.setColumns(10);
		txtStudentLastName.setBounds(484, 134, 202, 38);
		StudentCard.add(txtStudentLastName);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(88, 358, 769, 305);
		StudentCard.add(scrollPane_1);

		dtmStudent = new DefaultTableModel();
		dtmStudent.addColumn("Mã Sinh Viên");
		dtmStudent.addColumn("Họ và tên lót");
		dtmStudent.addColumn("Tên");
		dtmStudent.addColumn("Ngày Đăng Kí");

		tblStudents = new MyTable(dtmStudent);
		scrollPane_1.setViewportView(tblStudents);

		btnAddStudent = new JButton("Thêm");
		btnAddStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddStudent.setBounds(88, 267, 111, 38);
		StudentCard.add(btnAddStudent);

		btnEditStudent = new JButton("Sửa");
		btnEditStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEditStudent.setBounds(249, 267, 111, 38);
		StudentCard.add(btnEditStudent);

		btnDeleteStudent = new JButton("Xoá");
		btnDeleteStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteStudent.setBounds(414, 267, 111, 38);
		StudentCard.add(btnDeleteStudent);

		btnReloadStudents = new JButton("Tải Lại");
		btnReloadStudents.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReloadStudents.setBounds(587, 267, 111, 38);
		StudentCard.add(btnReloadStudents);
		
		btnSreachStudent = new JButton("Tìm Kiếm");
		btnSreachStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chức năng đang được cập nhật");
			}
		});
		btnSreachStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSreachStudent.setBounds(745, 267, 111, 38);
		StudentCard.add(btnSreachStudent);

		LectureCard = new JPanel();
		pnCards.add(LectureCard, "LectureCard");
		LectureCard.setLayout(null);

		lblLecture = new JLabel("Quản lý giáo viên");
		lblLecture.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLecture.setForeground(Color.RED);
		lblLecture.setBounds(401, 10, 196, 38);
		LectureCard.add(lblLecture);

		lblNewLabel_1 = new JLabel("Tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(294, 131, 60, 38);
		LectureCard.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Họ Và Tên Lót");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(294, 75, 121, 38);
		LectureCard.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Ngày Thuê");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(294, 195, 121, 38);
		LectureCard.add(lblNewLabel_3);

		txtLectureFirstName = new JTextField();
		txtLectureFirstName.setBounds(484, 78, 202, 38);
		LectureCard.add(txtLectureFirstName);
		txtLectureFirstName.setColumns(10);

		txtLectureLastName = new JTextField();
		txtLectureLastName.setColumns(10);
		txtLectureLastName.setBounds(484, 134, 202, 38);
		LectureCard.add(txtLectureLastName);

		dateLectures = new JDateChooser();
		dateLectures.setBounds(484, 195, 205, 38);
		LectureCard.add(dateLectures);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(94, 334, 769, 305);
		LectureCard.add(scrollPane_2);
		dtmLecture = new DefaultTableModel();
		dtmLecture.addColumn("Mã Giáo Viên");
		dtmLecture.addColumn("Họ và Chữ Lót");
		dtmLecture.addColumn("Tên");
		dtmLecture.addColumn("Ngày Thuê");
		tblLectures = new MyTable(dtmLecture);
		scrollPane_2.setViewportView(tblLectures);

		btnLectureAdd = new JButton("Thêm");

		btnLectureAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLectureAdd.setBounds(94, 268, 111, 38);
		LectureCard.add(btnLectureAdd);

		btnLectureEdit = new JButton("Sửa");
		btnLectureEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLectureEdit.setBounds(258, 268, 111, 38);
		LectureCard.add(btnLectureEdit);

		btnLectureDelete = new JButton("Xoá");

		btnLectureDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLectureDelete.setBounds(421, 268, 111, 38);
		LectureCard.add(btnLectureDelete);
		btnLectureReload = new JButton("Tải Lại");

		btnLectureReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLectureReload.setBounds(590, 268, 111, 38);
		LectureCard.add(btnLectureReload);
		
		btnLectureSreach = new JButton("Tìm Kiếm");
		btnLectureSreach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chức năng đang được cập nhật");
			}
		});
		btnLectureSreach.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLectureSreach.setBounds(752, 268, 111, 38);
		LectureCard.add(btnLectureSreach);

		/* END LECTURE CARD */

		/* C CARD */
		cardLayout = (CardLayout) pnCards.getLayout();

		CourseCard = new JPanel();
		pnCards.add(CourseCard, "CourseCard");
		CourseCard.setLayout(null);

		lblCourseCard = new JLabel("Quản Lý Khoá Học");
		lblCourseCard.setForeground(Color.RED);
		lblCourseCard.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCourseCard.setBounds(377, 0, 326, 36);
		CourseCard.add(lblCourseCard);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(153, 255, 255), 2));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(25, 46, 920, 290);
		CourseCard.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Tên KH");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(45, 25, 72, 36);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Khoa");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(45, 83, 72, 36);
		panel_1.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("URL");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2.setBounds(45, 138, 72, 36);
		panel_1.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_2_1 = new JLabel("Địa Điểm");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2_1.setBounds(484, 25, 72, 36);
		panel_1.add(lblNewLabel_4_2_1);

		JLabel lblNewLabel_4_2_2 = new JLabel("Ngày");
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2_2.setBounds(484, 83, 72, 36);
		panel_1.add(lblNewLabel_4_2_2);

		JLabel lblNewLabel_4_2_3 = new JLabel("Giờ");
		lblNewLabel_4_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2_3.setBounds(484, 138, 72, 36);
		panel_1.add(lblNewLabel_4_2_3);

		txtCourseName = new JTextField();
		txtCourseName.setBounds(145, 28, 249, 36);
		panel_1.add(txtCourseName);
		txtCourseName.setColumns(10);

		txtUrl = new JTextField();
		txtUrl.setColumns(10);
		txtUrl.setBounds(145, 141, 249, 36);
		panel_1.add(txtUrl);

		cmbDepartment = new JComboBox();
		cmbDepartment.setBounds(145, 86, 249, 35);
		panel_1.add(cmbDepartment);

		dateCourse = new JDateChooser();
		dateCourse.setBounds(601, 86, 249, 33);
		panel_1.add(dateCourse);

		cmbTimeCourse = new JComboBox();
		cmbTimeCourse.setBounds(601, 140, 248, 36);
		panel_1.add(cmbTimeCourse);

		btnAddCourse = new JButton("Thêm");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddCourse.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnAddCourse.setBounds(86, 217, 117, 42);
		panel_1.add(btnAddCourse);

		btnEditCourse = new JButton("Sửa");
		btnEditCourse.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnEditCourse.setBounds(273, 217, 117, 42);
		panel_1.add(btnEditCourse);

		btnDeleteCourse = new JButton("Xoá");
		btnDeleteCourse.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDeleteCourse.setBounds(478, 217, 117, 42);
		panel_1.add(btnDeleteCourse);

		btnReloadCourse = new JButton("Tải Lại");
		btnReloadCourse.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnReloadCourse.setBounds(680, 217, 117, 42);
		panel_1.add(btnReloadCourse);
		
		txtLocation = new JTextField();
		txtLocation.setColumns(10);
		txtLocation.setBounds(601, 25, 249, 36);
		panel_1.add(txtLocation);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(25, 356, 920, 307);
		CourseCard.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(6, 6, 908, 295);
		panel_2.add(scrollPane_3);

		tblCourse = new JTable();
		scrollPane_3.setViewportView(tblCourse);

		// Course Instructor Card start
		CourseIntructorCard = new JPanel();
		pnCards.add(CourseIntructorCard, "CourseIntructorCard");
		CourseIntructorCard.setLayout(null);

		lblCourseIntructor = new JLabel("Quản lý Phân công");
		lblCourseIntructor.setForeground(Color.RED);
		lblCourseIntructor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCourseIntructor.setBounds(377, 0, 326, 36);
		CourseIntructorCard.add(lblCourseIntructor);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(25, 46, 920, 290);
		CourseIntructorCard.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Mã giảng viên");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(294, 131, 140, 38);
		panel_3.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("Mã khóa học");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(294, 75, 131, 38);
		panel_3.add(lblNewLabel_5);
		
		JComboBox cmbCourse = new JComboBox();
		cmbCourse.setBounds(444, 75, 131, 35);
		panel_3.add(cmbCourse);
		
		JComboBox cmbInstructor = new JComboBox();
		cmbInstructor.setBounds(444, 135, 131, 35);
		panel_3.add(cmbInstructor);
		
		btnAddCourseInstructor = new JButton("Thêm");
		btnAddCourseInstructor.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnAddCourseInstructor.setBounds(86, 217, 117, 42);
		panel_3.add(btnAddCourseInstructor);
		
		btnEditCourseInstructor = new JButton("Sửa");
		btnEditCourseInstructor.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnEditCourseInstructor.setBounds(273, 217, 117, 42);
		panel_3.add(btnEditCourseInstructor);
		
		btnDeleteCourseInstructor = new JButton("Xoá");
		btnDeleteCourseInstructor.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDeleteCourseInstructor.setBounds(478, 217, 117, 42);
		panel_3.add(btnDeleteCourseInstructor);
		
		btnReloadCourseInstructor = new JButton("Tải Lại");
		btnReloadCourseInstructor.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnReloadCourseInstructor.setBounds(680, 217, 117, 42);
		panel_3.add(btnReloadCourseInstructor);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(25, 356, 920, 307);
		CourseIntructorCard.add(panel_4);
		
		JScrollPane scrollPane_3_1 = new JScrollPane();
		scrollPane_3_1.setBounds(6, 6, 908, 295);
		panel_4.add(scrollPane_3_1);

		dtmCourseInstructor = new DefaultTableModel();
		dtmCourseInstructor.addColumn("Mã khóa học");
		dtmCourseInstructor.addColumn("Mã người hướng dẫn");
		
		tblCourseInstructor = new MyTable(dtmCourseInstructor);
		scrollPane_3_1.setViewportView(tblCourseInstructor);

		GradeCard = new JPanel();
		pnCards.add(GradeCard, "GradeCard");
		GradeCard.setLayout(null);

		lblStudentGrade = new JLabel("Quản lý kết quả");
		lblStudentGrade.setForeground(Color.RED);
		lblStudentGrade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentGrade.setBounds(377, 0, 326, 36);
		GradeCard.add(lblStudentGrade);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(25, 46, 920, 290);
		GradeCard.add(panel_5);
		panel_5.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Mã học viên");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(294, 97, 140, 38);
		panel_5.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Mã khóa học");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(294, 35, 131, 38);
		panel_5.add(lblNewLabel_8);
		
		cmbCourseGrade = new JComboBox();
		cmbCourseGrade.setBounds(453, 39, 131, 35);
		panel_5.add(cmbCourseGrade);
		
		cmbStudent = new JComboBox();
		cmbStudent.setBounds(454, 101, 131, 35);
		panel_5.add(cmbStudent);
		
		JLabel lblNewLabel_5_1 = new JLabel("Điểm");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(294, 154, 110, 38);
		panel_5.add(lblNewLabel_5_1);
		
		txtGrade = new JTextField();
		txtGrade.setBounds(453, 155, 131, 35);
		panel_5.add(txtGrade);
		txtGrade.setColumns(10);
		
		btnAddStudentGrade = new JButton("Thêm");
		btnAddStudentGrade.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnAddStudentGrade.setBounds(86, 217, 117, 42);
		panel_5.add(btnAddStudentGrade);
		
		btnEditStudentGrade = new JButton("Sửa");
		btnEditStudentGrade.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnEditStudentGrade.setBounds(273, 217, 117, 42);
		panel_5.add(btnEditStudentGrade);
		
		btnDeleteStudentGrade = new JButton("Xoá");
		btnDeleteStudentGrade.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDeleteStudentGrade.setBounds(478, 217, 117, 42);
		panel_5.add(btnDeleteStudentGrade);
		
		btnReloadStudentGrade = new JButton("Tải Lại");
		btnReloadStudentGrade.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnReloadStudentGrade.setBounds(680, 217, 117, 42);
		panel_5.add(btnReloadStudentGrade);
		
		panel_6 = new JPanel();
		panel_6.setBounds(25, 356, 920, 357);
		GradeCard.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 2, 2);
		panel_6.add(scrollPane_4);
		
		dtmStudentGrade = new DefaultTableModel();
		tblStudentGrade = new MyTable();
		scrollPane_4.setViewportView(tblStudentGrade);

	}

	private void addEvent() {

		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pnCards, "StudentCard");
			}
		});

		btnLecture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pnCards, "LectureCard");
			}
		});

		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pnCards, "CourseCard");
			}
		});

		btnCourseIntructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pnCards, "CourseIntructorCard");
			}
		});

		btnGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pnCards, "GradeCard");
			}
		});

		// ADD EDIT REMOVE RELOAD LECTURES
		// #TABLE LECTURE CLICK EVENT
		tblLectures.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblLectures.getSelectedRow();
				if (i >= 0) {
					try {
						String firstName = dtmLecture.getValueAt(i, 1).toString();
						String lastName = dtmLecture.getValueAt(i, 2).toString();
						String stringdateLecture = dtmLecture.getValueAt(i, 3).toString();
						Date dateLecture = new SimpleDateFormat("yyyy-MM-dd").parse(stringdateLecture);
						txtLectureFirstName.setText(firstName);
						txtLectureLastName.setText(lastName);
						dateLectures.setDate(dateLecture);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		// add Lecture
		btnLectureAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastName = txtLectureLastName.getText();
				String firstName = txtLectureFirstName.getText();
				Date dateLecture = dateLectures.getDate();
				Person person = new Person(0, lastName, firstName, dateLecture, null);
				if (LectureBLL.gI().addLecture(person)) {
					LoadListLecture();
					JOptionPane.showMessageDialog(null, "Đã thêm thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra khi thêm giáo viên");
				}

			}
		});
		// edit Lecture
		btnLectureEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastName = txtLectureLastName.getText();
				String firstName = txtLectureFirstName.getText();
				Date dateLecture = dateLectures.getDate();
				int i = tblLectures.getSelectedRow();
				try {
					if (i >= 0) {
						int ID = Integer.parseInt(dtmLecture.getValueAt(i, 0).toString());
						Person person = new Person(ID, lastName, firstName, dateLecture, null);
						if (LectureBLL.gI().editLecture(person)) {
							LoadListLecture();
							JOptionPane.showMessageDialog(null, "Đã sửa thành công");
						} else {
							JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn giáo viên cần sửa");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		// delete Lecture
		btnLectureDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tblLectures.getSelectedRow();
				try {
					if (i >= 0) {
						int ID = Integer.parseInt(dtmLecture.getValueAt(i, 0).toString());
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá không?", "Warning",
								dialogButton);
						if (dialogResult == JOptionPane.YES_OPTION) {
							if (LectureBLL.gI().deleteLecture(ID)) {
								LoadListLecture();
								JOptionPane.showMessageDialog(null, "Đã xoá thành công");
							} else {
								JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra");
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn giáo viên cần xoá");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		// reload Lecture
		btnLectureReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoadListLecture();
					JOptionPane.showMessageDialog(null, "Đã tải lại danh sách thành công");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Có lỗi khi tải danh sách giáo viên");
				}

			}
		});
		// END EVENT LECTURE

		// START EVENT STUDENTS
		// click table students
		tblStudents.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblStudents.getSelectedRow();
				if (i >= 0) {
					try {
						String firstName = dtmStudent.getValueAt(i, 1).toString();
						String lastName = dtmStudent.getValueAt(i, 2).toString();
						String stringdateLecture = dtmStudent.getValueAt(i, 3).toString();
						Date dateenrollment = new SimpleDateFormat("yyyy-MM-dd").parse(stringdateLecture);
						txtStudentsFirstName.setText(firstName);
						txtStudentLastName.setText(lastName);
						dateEnrollment.setDate(dateenrollment);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		// add Students
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastName = txtStudentLastName.getText();
				String firstName = txtStudentsFirstName.getText();
				Date dateenrollment = dateEnrollment.getDate();
				Person person = new Person(0, lastName, firstName, null, dateenrollment);
				if (StudentBLL.gI().addStudents(person)) {
					LoadListStudents();
					JOptionPane.showMessageDialog(null, "Đã thêm thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra khi thêm giáo viên");
				}

			}
		});
		// edit Students
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastName = txtStudentLastName.getText();
				String firstName = txtStudentsFirstName.getText();
				Date dateenrollment = dateEnrollment.getDate();

				int i = tblStudents.getSelectedRow();
				try {
					if (i >= 0) {
						int ID = Integer.parseInt(dtmStudent.getValueAt(i, 0).toString());
						Person person = new Person(ID, lastName, firstName, null, dateenrollment);
						if (StudentBLL.gI().editStudents(person)) {
							LoadListStudents();
							JOptionPane.showMessageDialog(null, "Đã sửa thành công");
						} else {
							JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn học sinh cần sửa");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		// delete Students
		// delete Lecture
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tblStudents.getSelectedRow();
				try {
					if (i >= 0) {
						int ID = Integer.parseInt(dtmStudent.getValueAt(i, 0).toString());
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá không?", "Warning",
								dialogButton);
						if (dialogResult == JOptionPane.YES_OPTION) {
							if (StudentBLL.gI().deleteLecture(ID)) {
								LoadListStudents();
								JOptionPane.showMessageDialog(null, "Đã xoá thành công");
							} else {
								JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra khi xoá sinh viên");
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn sinh viên cần xoá");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		// reload Lecture
		btnReloadStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoadListStudents();
					JOptionPane.showMessageDialog(null, "Đã tải lại danh sách thành công");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Có lỗi khi tải danh sách giáo viên");
				}

			}
		});
		// END EVENT STUDENTS
		
		// START EVENT STUDENT GRADE
				// click table student grade
				tblStudentGrade.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						int i = tblStudentGrade.getSelectedRow();
						if (i >= 0) {
							try {
								String idCourse = dtmStudentGrade.getValueAt(i, 1).toString();
								String idStudent = dtmStudent.getValueAt(i, 2).toString();
								String grade = dtmStudent.getValueAt(i, 3).toString();
								cmbCourseGrade.setSelectedIndex(i);
								cmbStudent.setSelectedIndex(i);
								txtGrade.setText(grade);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				});
				// add Students
				btnAddStudent.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						float grade = Float.parseFloat(txtGrade.getText()); 
						int idCourse = cmbCourseGrade.getSelectedIndex();
						int idStudent = cmbStudent.getSelectedIndex();
						StudentGrade studentGrade = new StudentGrade(0, idCourse, idStudent, grade);
						if (StudentGradeBLL.gI().addGrade(studentGrade)) {
							LoadListStudents();
							JOptionPane.showMessageDialog(null, "Đã thêm thành công");
						} else {
							JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra khi thêm điểm khóa học");
						}

					}
				});
				// edit Students
				btnEditStudent.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						float grade = Float.parseFloat(txtGrade.getText());
						int i = tblStudentGrade.getSelectedRow();
						try {
							if (i >= 0) {
								int idEnrollment = Integer.parseInt(dtmStudentGrade.getValueAt(i, 0).toString());
								int idCourse = Integer.parseInt(dtmStudentGrade.getValueAt(i, 1).toString());
								int idPerson = Integer.parseInt(dtmStudentGrade.getValueAt(i, 2).toString());
								StudentGrade studentGrade = new StudentGrade(idEnrollment, idCourse, idPerson, grade);
								if (StudentGradeBLL.gI().editGrade(studentGrade)) {
									LoadListStudents();
									JOptionPane.showMessageDialog(null, "Đã sửa thành công");
								} else {
									JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Bạn chưa chọn điểm cần sửa");
							}
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}
				});
				// delete Students
				// delete Lecture
				btnDeleteStudent.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int i = tblStudents.getSelectedRow();
						try {
							if (i >= 0) {
								int ID = Integer.parseInt(dtmStudent.getValueAt(i, 0).toString());
								int dialogButton = JOptionPane.YES_NO_OPTION;
								int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá không?", "Warning",
										dialogButton);
								if (dialogResult == JOptionPane.YES_OPTION) {
									if (StudentBLL.gI().deleteLecture(ID)) {
										LoadListStudents();
										JOptionPane.showMessageDialog(null, "Đã xoá thành công");
									} else {
										JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra khi xoá sinh viên");
									}
								}

							} else {
								JOptionPane.showMessageDialog(null, "Bạn chưa chọn sinh viên cần xoá");
							}
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}
				});
				// reload Lecture
				btnReloadStudents.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							LoadListStudents();
							JOptionPane.showMessageDialog(null, "Đã tải lại danh sách thành công");
						} catch (Exception e2) {
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null, "Có lỗi khi tải danh sách giáo viên");
						}

					}
				});
				// END EVENT STUDENTS		
	}

	public static ArrayList<DTO.Person> lecturesList;
	public static ArrayList<DTO.Person> studentsList;
	public static ArrayList<DTO.Department> departmentsList;
	public void LoadListLecture() {
		lecturesList = null;
		lecturesList = BLL.LectureBLL.gI().readLectures();
		dtmLecture.setRowCount(0);
		for (Person person : lecturesList) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(person.getID());
			vec.add(person.getFirstname());
			vec.add(person.getLastname());
			vec.add(person.getHireDate());
			dtmLecture.addRow(vec);
		}
	}
	public void LoadListStudents() {
		studentsList = null;
		studentsList = BLL.StudentBLL.gI().readStudens();
		dtmStudent.setRowCount(0);
		for (Person person : studentsList) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(person.getID());
			vec.add(person.getFirstname());
			vec.add(person.getLastname());
			vec.add(person.getEnrollmentDate());
			dtmStudent.addRow(vec);
		}
	}
	public void LoadListDepartments() {
		departmentsList = null;
		departmentsList = BLL.DepartementBLL.gI().listDepartments();
		cmbDepartment.removeAllItems();
		for (Department department : departmentsList) {
			cmbDepartment.addItem(department);
		}
	}
    public void LoadComboTime() {
    	cmbTimeCourse.removeAllItems();
    	String hours = "00";
    	String miniutes = "00";
    	String seconds = "00";
    	int inthours = Integer.parseInt(hours);
    	for(int i = 0 ; i < 24 ; i++) {
    		if(i < 10) {
    			hours = "0" + i;
    		}
    		else {
    			hours = i+"";
    		}
    		miniutes = "00";
    		String time = hours + ":" + miniutes + ":" +seconds;
    		cmbTimeCourse.addItem(time);
    		int intminiutes = 15;
    		while(intminiutes <= 50 && intminiutes > 0) {
    			miniutes = String.valueOf(intminiutes);
    			if(intminiutes != 60) {
    				time = hours + ":" + miniutes + ":" +seconds;
    			}
    			intminiutes+=15;
    			cmbTimeCourse.addItem(time);
    		}
    		
    	
    	}
    }
	
	private JPanel panel_1;
	private JTextField txtCourseName;
	private JTextField txtUrl;
	private JComboBox cmbTimeCourse;
	private JTable tblCourse;
	private JButton btnSreachStudent;
	private JButton btnLectureSreach;
	private JTextField txtLocation;
	private JLabel lblNewLabel_5;
	private JTable tblCourseInstructor;
	private JPanel panel_5;
	private JPanel panel_6;
	private JTable tblStudentGrade;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JComboBox cmbCourseGrade;
	private JComboBox cmbStudent;
	private JTextField txtGrade;

	

	private void initData() {
		LoadListLecture();
		LoadListStudents();
		LoadListDepartments();
		LoadComboTime();
	}
}
