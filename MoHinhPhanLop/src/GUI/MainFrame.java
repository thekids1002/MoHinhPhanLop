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
import java.awt.Button;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.function.DoubleToIntFunction;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import BLL.LectureBLL;
import BLL.OnlineCourseBLL;
import BLL.OnsiteCourseBLL;
import BLL.StudentBLL;
import DTO.Course;
import DTO.CourseInstructor;
import DTO.Department;
import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import DTO.Person;
import DTO.StudentGrade;
import BLL.StudentGradeBLL;
import BLL.CourseBLL;
import BLL.CourseInstructorBLL;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {
	public static MainFrame gI = null;

	public static MainFrame gI() {
		if (gI == null) {
			gI = new MainFrame();
		}
		return gI;
	}

	public JPanel contentPane;
	CardLayout cardLayout;
	public JPanel CourseCard;
	public JLabel lblCourseCard;
	public JPanel CourseIntructorCard;
	public JLabel lblCourseIntructor;
	public JPanel GradeCard;
	public JLabel lblStudentGrade;
	public JPanel panel;
	public JButton btnStudent;
	public JButton btnLecture;
	public JButton btnCourse;
	public JButton btnCourseIntructor;
	public JButton btnGrade;
	public JPanel pnCards;
	public JPanel StudentCard;
	public JLabel lblStudents;
	public JPanel LectureCard;
	public JLabel lblLecture;
	public JTextField txtStudentsFirstName;
	public JTextField txtStudentLastName;
	public JTable tblStudents;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JTextField txtLectureFirstName;
	public JTextField txtLectureLastName;
	public JTable tblLectures;
	public static DefaultTableModel dtmLecture;
	public JButton btnLectureEdit;
	public JButton btnLectureAdd;
	public JDateChooser dateLectures;
	public JButton btnLectureDelete;
	public JButton btnLectureReload;
	public JButton btnAddStudent;
	public JButton btnEditStudent;
	public static DefaultTableModel dtmStudent;
	public JDateChooser dateEnrollment;
	public JButton btnDeleteStudent;
	public JButton btnReloadStudents;
	public JButton btnAddCourse;
	public JButton btnEditCourse;
	public JButton btnDeleteCourse;
	public JButton btnReloadCourse;
	public JComboBox cmbDepartment;
	public static DefaultTableModel dtmStudentGrade;
	public JButton btnAddStudentGrade;
	public JButton btnEditStudentGrade;
	public JButton btnDeleteStudentGrade;
	public JButton btnReloadStudentGrade;
	public static DefaultTableModel dtmCourseInstructor;
	public JButton btnAddCourseInstructor;
	public JButton btnEditCourseInstructor;
	public JButton btnDeleteCourseInstructor;
	public JButton btnReloadCourseInstructor;
	public JPanel panel_1;
	public JTextField txtCourseName;
	public JTextField txtUrl;
	public JComboBox cmbTimeCourse;
	public JTable tblCourseOnsite;
	public JButton btnSreachStudent;
	public JButton btnLectureSreach;
	public JTextField txtLocation;
	public JLabel lblNewLabel_5;
	public JTable tblCourseInstructor;
	public JPanel panel_5;
	public JPanel panel_6;
	public JTable tblStudentGrade;
	public JLabel lblNewLabel_7;
	public JLabel lblNewLabel_8;
	public JComboBox cmbCourseGrade;
	public JComboBox cmbStudent;
	public JTextField txtGrade;
	public JComboBox cmbLectureIntructor;
	public JComboBox cmbCourseIntructor;
	protected Person lectureSelected;
	protected Course courseSelected;
	protected Person lectureSelectedinTalbe;
	protected Course courseSelectedinTable;
	protected Person studentSelectedinTable;
	protected Course coursegradeSelectedinTable;
	protected Person studentGradeSelected;
	protected Course courseGradeSelected;
	public static JPanel pnPageStudents;
	public static JPanel pnPageLecture;
	public static DefaultTableModel dtmcourseOnline;
	public static DefaultTableModel dtmcourseSite;
	CourseBLL courseBLL;
	CourseInstructorBLL courseInstructorBLL;
	LectureBLL lectureBLL;
	OnlineCourseBLL onlineCourseBLL;
	OnsiteCourseBLL onsiteCourseBLL;
	StudentBLL studentBLL;
	StudentGradeBLL studentGradeBLL;

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
							if ("Windows".equals(info.getName())) {
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
					frame.setLocationRelativeTo(null);
					frame.setTitle("Ph???n m???m qu???n l?? kho?? h???c");
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
		courseBLL = new CourseBLL();
		courseInstructorBLL = new CourseInstructorBLL();
		lectureBLL = new LectureBLL();
		onlineCourseBLL = new OnlineCourseBLL();
		onsiteCourseBLL = new OnsiteCourseBLL();
		studentBLL = new StudentBLL();
		studentGradeBLL = new StudentGradeBLL();
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

	public void addControl() {
		panel = new JPanel();
		// panel.setBackground(SystemColor.scrollbar);
		panel.setBackground(new Color(219, 218, 213, 255));
		panel.setBounds(0, 0, 291, 683);
		contentPane.add(panel);
		panel.setLayout(null);

		btnStudent = new JButton("Qu???n L?? Sinh Vi??n");
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 15));

		btnStudent.setBounds(35, 59, 237, 49);
		panel.add(btnStudent);

		btnLecture = new JButton("Qu???n L?? Gi??o Vi??n");
		btnLecture.setFont(new Font("Tahoma", Font.BOLD, 15));

		btnLecture.setBounds(35, 134, 237, 49);
		panel.add(btnLecture);

		btnCourse = new JButton("Qu???n L?? Kho?? H???c");
		btnCourse.setFont(new Font("Tahoma", Font.BOLD, 15));

		btnCourse.setBounds(35, 214, 237, 49);
		panel.add(btnCourse);

		btnCourseIntructor = new JButton("Qu???n L?? Ph??n C??ng");
		btnCourseIntructor.setFont(new Font("Tahoma", Font.BOLD, 15));

		btnCourseIntructor.setBounds(35, 290, 237, 49);
		panel.add(btnCourseIntructor);

		btnGrade = new JButton("Qu???n L?? K???t Qu???");
		btnGrade.setFont(new Font("Tahoma", Font.BOLD, 15));

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

		lblStudents = new JLabel("Qu???n l?? sinh vi??n");
		lblStudents.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudents.setForeground(Color.RED);
		lblStudents.setBounds(401, 10, 196, 38);
		StudentCard.add(lblStudents);

		dateEnrollment = new JDateChooser();
		dateEnrollment.setBounds(484, 195, 205, 38);
		StudentCard.add(dateEnrollment);

		JLabel lblNewLabel = new JLabel("T??n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(294, 131, 60, 38);
		StudentCard.add(lblNewLabel);

		JLabel lblHVTn = new JLabel("H??? V?? T??n L??t");
		lblHVTn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHVTn.setBounds(294, 75, 121, 38);
		StudentCard.add(lblHVTn);

		JLabel lblNgyngK = new JLabel("Ng??y ????ng K??");
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
		scrollPane_1.setBounds(88, 345, 769, 269);
		StudentCard.add(scrollPane_1);

		dtmStudent = new DefaultTableModel();
		dtmStudent.addColumn("M?? Sinh Vi??n");
		dtmStudent.addColumn("H??? v?? t??n l??t");
		dtmStudent.addColumn("T??n");
		dtmStudent.addColumn("Ng??y ????ng K??");

		tblStudents = new MyTable(dtmStudent);
		scrollPane_1.setViewportView(tblStudents);

		btnAddStudent = new JButton("Th??m");
		btnAddStudent.setIcon(new ImageIcon("img\\Add.png"));
		btnAddStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddStudent.setBounds(88, 267, 121, 38);
		StudentCard.add(btnAddStudent);

		btnEditStudent = new JButton("S???a");
		btnEditStudent.setIcon(new ImageIcon("img\\Edit.png"));
		btnEditStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEditStudent.setBounds(249, 267, 121, 38);
		StudentCard.add(btnEditStudent);

		btnDeleteStudent = new JButton("Xo??");
		btnDeleteStudent.setIcon(new ImageIcon("img\\Delete.png"));
		btnDeleteStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteStudent.setBounds(414, 267, 121, 38);
		StudentCard.add(btnDeleteStudent);

		btnReloadStudents = new JButton("T???i L???i");
		btnReloadStudents.setIcon(new ImageIcon("img\\update.png"));
		btnReloadStudents.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReloadStudents.setBounds(587, 267, 121, 38);
		StudentCard.add(btnReloadStudents);

		btnSreachStudent = new JButton("T??m Ki???m");
		btnSreachStudent.setIcon(new ImageIcon("img\\Search.png"));
		btnSreachStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgSearchStudent frame = new dlgSearchStudent();

				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnSreachStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSreachStudent.setBounds(745, 267, 121, 38);
		StudentCard.add(btnSreachStudent);

		panel_8 = new JPanel();
		panel_8.setBackground(UIManager.getColor("Button.highlight"));
		panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_8.setBounds(48, 49, 860, 286);
		StudentCard.add(panel_8);

		pnPageStudents = new JPanel();
		pnPageStudents.setBounds(87, 624, 770, 29);
		StudentCard.add(pnPageStudents);

		LectureCard = new JPanel();
		pnCards.add(LectureCard, "LectureCard");
		LectureCard.setLayout(null);

		lblLecture = new JLabel("Qu???n l?? gi??o vi??n");
		lblLecture.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLecture.setForeground(Color.RED);
		lblLecture.setBounds(401, 10, 196, 38);
		LectureCard.add(lblLecture);

		lblNewLabel_1 = new JLabel("T??n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(294, 131, 60, 38);
		LectureCard.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("H??? V?? T??n L??t");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(294, 75, 121, 38);
		LectureCard.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Ng??y Thu??");
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
		scrollPane_2.setBounds(94, 348, 769, 271);
		LectureCard.add(scrollPane_2);
		dtmLecture = new DefaultTableModel();
		dtmLecture.addColumn("M?? Gi??o Vi??n");
		dtmLecture.addColumn("H??? v?? Ch??? L??t");
		dtmLecture.addColumn("T??n");
		dtmLecture.addColumn("Ng??y Thu??");
		tblLectures = new MyTable(dtmLecture);
		scrollPane_2.setViewportView(tblLectures);

		btnLectureAdd = new JButton("Th??m");
		btnLectureAdd.setIcon(new ImageIcon("img\\Add.png"));

		btnLectureAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLectureAdd.setBounds(94, 268, 121, 38);
		LectureCard.add(btnLectureAdd);

		btnLectureEdit = new JButton("S???a");
		btnLectureEdit.setIcon(new ImageIcon("img\\Edit.png"));
		btnLectureEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLectureEdit.setBounds(258, 268, 121, 38);
		LectureCard.add(btnLectureEdit);

		btnLectureDelete = new JButton("Xo??");
		btnLectureDelete.setIcon(new ImageIcon("img\\Delete.png"));

		btnLectureDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLectureDelete.setBounds(421, 268, 121, 38);
		LectureCard.add(btnLectureDelete);
		btnLectureReload = new JButton("T???i L???i");
		btnLectureReload.setIcon(new ImageIcon("img\\update.png"));

		btnLectureReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLectureReload.setBounds(590, 268, 121, 38);
		LectureCard.add(btnLectureReload);

		btnLectureSreach = new JButton("T??m Ki???m");
		btnLectureSreach.setIcon(new ImageIcon("img\\Search.png"));
		btnLectureSreach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new dlgSearchLecture().setVisible(true);
			}
		});
		btnLectureSreach.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLectureSreach.setBounds(752, 268, 121, 38);
		LectureCard.add(btnLectureSreach);

		panel_9 = new JPanel();
		panel_9.setBackground(UIManager.getColor("Button.highlight"));
		panel_9.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_9.setBounds(48, 49, 860, 286);
		LectureCard.add(panel_9);

		pnPageLecture = new JPanel();
		pnPageLecture.setBounds(94, 621, 769, 32);
		LectureCard.add(pnPageLecture);

		/* END LECTURE CARD */

		/* C CARD */
		cardLayout = (CardLayout) pnCards.getLayout();

		CourseCard = new JPanel();
		pnCards.add(CourseCard, "CourseCard");
		CourseCard.setLayout(null);

		lblCourseCard = new JLabel("Qu???n L?? Kho?? H???c");
		lblCourseCard.setForeground(Color.RED);
		lblCourseCard.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCourseCard.setBounds(377, 0, 326, 36);
		CourseCard.add(lblCourseCard);

		panel_1 = new JPanel();

		panel_1.setBackground(UIManager.getColor("Button.highlight"));
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(48, 49, 860, 286);
		CourseCard.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("T??n KH");
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

		JLabel lblNewLabel_4_2_1 = new JLabel("?????a ??i???m");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2_1.setBounds(484, 25, 72, 36);
		panel_1.add(lblNewLabel_4_2_1);

		JLabel lblNewLabel_4_2_2 = new JLabel("Ng??y");
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2_2.setBounds(484, 83, 72, 36);
		panel_1.add(lblNewLabel_4_2_2);

		JLabel lblNewLabel_4_2_3 = new JLabel("Gi???");
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

		cmbTimeCourse = new JComboBox();
		cmbTimeCourse.setBounds(601, 140, 248, 36);
		panel_1.add(cmbTimeCourse);

		btnAddCourse = new JButton("Th??m");
		btnAddCourse.setIcon(new ImageIcon("img\\Add.png"));
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = txtUrl.getText();
				String TenKH;
				int Khoa;
				TenKH = txtCourseName.getText();
				String department = cmbDepartment.getSelectedItem().toString();
				Khoa = Integer.parseInt(department.substring(0, department.indexOf("-")).trim());
				Course course = new Course(0, TenKH, 1, Khoa);
				int id = courseBLL.addCourse(course);
				if (id != -1) {
					JOptionPane.showMessageDialog(null, "???? th??m th??nh c??ng");
					if (url.isBlank() || url.isEmpty()) {
						String location = txtLocation.getText();
						String days = txtdateCourse.getText();
						String timestr = cmbTimeCourse.getSelectedItem().toString();
						Time time = null;
						try {
							time = java.sql.Time.valueOf(timestr);
							OnsiteCourse onsiteCourse = new OnsiteCourse(id, TenKH, 0, Khoa, location, days, time);
							if (onsiteCourse.getDays().isEmpty() || onsiteCourse.getDays().isBlank()) {
								JOptionPane.showMessageDialog(null, "Kh??ng ???????c ????? tr???ng ng??y");
								return;
							}
							if (onsiteCourse.getLocation().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Kh??ng ???????c ????? tr???ng ph??ng h???c");
								return;
							}
							if (onsiteCourse.getTime() == null) {
								JOptionPane.showMessageDialog(null, "Th???i gian sai");
								return;
							}
							if (onsiteCourseBLL.addOnSiteCourse(onsiteCourse)) {
								JOptionPane.showMessageDialog(null, "???? th??m th??nh c??ng kho?? h???c Onsite");
								LoadListOnsiteCourse();
								addPageOnsite();
							}
						} catch (IllegalArgumentException e2) {
							e2.printStackTrace();
						}
					} else {
						OnlineCourse onlineCourse = new OnlineCourse(id, TenKH, 0, Khoa, url);
						if (onlineCourse.getUrl().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Kh??ng ???????c ????? tr???ng URL");
							return;
						}
						if (onlineCourse.getCourseID() < 0) {
							JOptionPane.showMessageDialog(null, "L???i kh??ng c?? ID");
							return;
						}
						if (onlineCourseBLL.addOnlineCourse(onlineCourse)) {
							JOptionPane.showMessageDialog(null, "???? th??m th??nh c??ng kho?? h???c Online");
							LoadListOnlineCourse();
							addPageOnline();
						}
					}
				} else if (id == -1) {
					JOptionPane.showMessageDialog(null, "T??n kho?? h???c kh??ng ???????c ????? tr???ng");
				} else if (id == -2) {
					JOptionPane.showMessageDialog(null, "T??n khoa kh??ng ???????c ????? tr???ng");
				}

			}
		});
		btnAddCourse.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnAddCourse.setBounds(40, 217, 117, 42);
		panel_1.add(btnAddCourse);

		btnEditCourse = new JButton("S???a");
		btnEditCourse.setIcon(new ImageIcon("img\\Edit.png"));
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tblCourseOnsite.getSelectedRow();
				int j = tblCourseOnline.getSelectedRow();
				if (i >= 0) {
					j = -1;
					String url = txtUrl.getText();
					String TenKH;
					int Khoa;
					TenKH = txtCourseName.getText();
					String department = cmbDepartment.getSelectedItem().toString();
					Khoa = Integer.parseInt(department.substring(0, department.indexOf("-")).trim());
					int id = Integer.parseInt(dtmcourseSite.getValueAt(i, 1).toString());
					Course course = new Course(id, TenKH, 1, Khoa);
					if (courseBLL.editCourse(course)) {
						// JOptionPane.showMessageDialog(null, "???? s???a th??nh c??ng");
						if (url.isBlank() || url.isEmpty()) {
							String location = txtLocation.getText();
							String days = txtdateCourse.getText();
							String timestr = cmbTimeCourse.getSelectedItem().toString();
							Time time = java.sql.Time.valueOf(timestr);
							OnsiteCourse onsiteCourse = new OnsiteCourse(id, TenKH, 0, 0, location, days, time);
							if (onsiteCourse.getDays().isEmpty() || onsiteCourse.getDays().isBlank()) {
								JOptionPane.showMessageDialog(null, "Kh??ng ???????c ????? tr???ng ng??y");
								return;
							}
							if (onsiteCourse.getLocation().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Kh??ng ???????c ????? tr???ng ph??ng h???c");
								return;
							}
							if (onsiteCourse.getTime() == null) {
								JOptionPane.showMessageDialog(null, "Th???i gian sai");
								return;
							}
							if (onsiteCourseBLL.editOnSiteCourse(onsiteCourse)) {
								JOptionPane.showMessageDialog(null, "???? s???a th??nh c??ng kho?? h???c Onsite");
								LoadListOnsiteCourse();
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "S???a kho?? h???c onsite kh??ng th??nh c??ng");
					}
				}
				if (j >= 0) {
					i = -1;
					String url = txtUrl.getText();
					String TenKH;
					int Khoa;
					TenKH = txtCourseName.getText();
					String department = cmbDepartment.getSelectedItem().toString();
					Khoa = Integer.parseInt(department.substring(0, department.indexOf("-")).trim());
					int id = Integer.parseInt(dtmcourseOnline.getValueAt(j, 1).toString());
					Course course = new Course(id, TenKH, 1, Khoa);
					if (courseBLL.editCourse(course)) {
						OnlineCourse onlineCourse = new OnlineCourse(id, TenKH, 0, 0, url);
						if (onlineCourse.getUrl().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Kh??ng ???????c ????? tr???ng URL");
							return;
						}
						if (onlineCourse.getCourseID() < 0) {
							JOptionPane.showMessageDialog(null, "L???i kh??ng c?? ID");
							return;
						}
						if (onlineCourseBLL.editOnlineCourse(onlineCourse)) {
							JOptionPane.showMessageDialog(null, "???? s???a th??nh c??ng kho?? h???c Online");
							LoadListOnlineCourse();
						} else {
							JOptionPane.showMessageDialog(null, "???? c?? l???i x???y ra");
						}
						// }
					} else {
						JOptionPane.showMessageDialog(null, "C?? l???i x???y ra");
					}
				}
			}
		});
		btnEditCourse.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnEditCourse.setBounds(206, 217, 117, 42);
		panel_1.add(btnEditCourse);

		btnDeleteCourse = new JButton("Xo??");
		btnDeleteCourse.setIcon(new ImageIcon("img\\Delete.png"));
		btnDeleteCourse.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDeleteCourse.setBounds(371, 217, 117, 42);
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID;
				// .... x??? l?? xo?? kho?? h???c online ///
				int i = tblCourseOnline.getSelectedRow();
				if (i >= 0) {
					ID = Integer.parseInt(dtmcourseOnline.getValueAt(i, 1).toString());
					if (onlineCourseBLL.deleteOnlineCourse(ID)) {
						if (new BLL.CourseBLL().deleteCourse(ID)) {
							JOptionPane.showMessageDialog(null, "???? xo?? kho?? h???c online th??nh c??ng");
							LoadListOnlineCourse();
							addPageOnline();
						} else {
							JOptionPane.showMessageDialog(null, "???? xo?? kho?? h???c online th???t b???i\n" +
									"C???n xo?? c??c ph??n c??ng c???a kho?? h???c tr?????c");
						}
					} else {
						JOptionPane.showMessageDialog(null, "???? xo?? kho?? h???c th???t b???i");
					}
				}
				int j = tblCourseOnsite.getSelectedRow();
				// x??? l?? xo?? kho?? h???c onsite
				if (j >= 0) {
					ID = Integer.parseInt(dtmcourseSite.getValueAt(j, 1).toString());
					if (onsiteCourseBLL.deleteSiteCourse(ID)) {
						if (new BLL.CourseBLL().deleteCourse(ID)) {
							JOptionPane.showMessageDialog(null, "???? xo?? kho?? h???c onsite th??nh c??ng");
							LoadListOnsiteCourse();
							addPageOnsite();
						} else {
							JOptionPane.showMessageDialog(null, "B???n c???n xo?? kho?? ph??n c??ng tr?????c");

						}
					} else {
						JOptionPane.showMessageDialog(null, "???? xo?? kho?? h???c th???t b???i");
					}
				}
			}
		});
		panel_1.add(btnDeleteCourse);

		btnReloadCourse = new JButton("T???i L???i");
		btnReloadCourse.setIcon(new ImageIcon("img\\update.png"));

		btnReloadCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "???? t???i l???i danh s??ch kho?? h???c th??nh c??ng");
				LoadListOnlineCourse();
				LoadListOnsiteCourse();
			}
		});
		btnReloadCourse.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnReloadCourse.setBounds(536, 217, 117, 42);
		panel_1.add(btnReloadCourse);

		txtLocation = new JTextField();
		txtLocation.setColumns(10);
		txtLocation.setBounds(601, 25, 249, 36);
		panel_1.add(txtLocation);

		txtdateCourse = new JTextField();
		txtdateCourse.setColumns(10);
		txtdateCourse.setBounds(600, 83, 249, 36);
		panel_1.add(txtdateCourse);

		JButton btnSearchStudentsGrade_1 = new JButton("T??m");
		btnSearchStudentsGrade_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new dlgSearchCourse().setVisible(true);
			}
		});
		btnSearchStudentsGrade_1.setIcon(new ImageIcon("img\\Search.png"));
		btnSearchStudentsGrade_1.setBounds(697, 217, 117, 42);
		panel_1.add(btnSearchStudentsGrade_1);
		btnSearchStudentsGrade_1.setFont(new Font("SansSerif", Font.BOLD, 15));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Kho\u00E1 H\u1ECDc Onsite", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel_2.setBounds(25, 341, 525, 322);
		CourseCard.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 27, 501, 264);
		panel_2.add(scrollPane_3);

		dtmcourseSite = new DefaultTableModel();
		dtmcourseSite.addColumn("STT");
		dtmcourseSite.addColumn("M?? Kho?? H???c");
		dtmcourseSite.addColumn("T??n Kho?? H???c");
		dtmcourseSite.addColumn("Khoa");
		dtmcourseSite.addColumn("Ph??ng");
		dtmcourseSite.addColumn("Ng??y");
		dtmcourseSite.addColumn("Gi???");
		tblCourseOnsite = new MyTable(dtmcourseSite);
		tblCourseOnsite.setAutoscrolls(false);

		scrollPane_3.setViewportView(tblCourseOnsite);

		pnPageOnsite = new JPanel();
		pnPageOnsite.setBounds(10, 293, 505, 29);
		panel_2.add(pnPageOnsite);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Kho\u00E1 H\u1ECDc Online", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel_7.setBounds(550, 345, 395, 318);
		CourseCard.add(panel_7);
		panel_7.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 375, 258);
		panel_7.add(scrollPane);

		dtmcourseOnline = new DefaultTableModel();
		dtmcourseOnline.addColumn("STT");
		dtmcourseOnline.addColumn("M?? Kho?? H???c");
		dtmcourseOnline.addColumn("T??n Kho?? H???c");
		dtmcourseOnline.addColumn("Khoa");
		dtmcourseOnline.addColumn("Url");
		tblCourseOnline = new MyTable(dtmcourseOnline);
		scrollPane.setViewportView(tblCourseOnline);

		pnPageOnline = new JPanel();
		pnPageOnline.setBounds(20, 289, 365, 29);
		panel_7.add(pnPageOnline);

		// Course Instructor Card start
		CourseIntructorCard = new JPanel();
		pnCards.add(CourseIntructorCard, "CourseIntructorCard");
		CourseIntructorCard.setLayout(null);

		lblCourseIntructor = new JLabel("Qu???n l?? Ph??n c??ng");
		lblCourseIntructor.setForeground(Color.RED);
		lblCourseIntructor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCourseIntructor.setBounds(377, 0, 326, 36);
		CourseIntructorCard.add(lblCourseIntructor);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_3.setBackground(UIManager.getColor("Button.highlight"));
		panel_3.setBounds(48, 49, 860, 286);

		CourseIntructorCard.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("M?? gi???ng vi??n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(273, 116, 140, 38);
		panel_3.add(lblNewLabel_6);

		lblNewLabel_5 = new JLabel("M?? kh??a h???c");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(273, 60, 131, 38);
		panel_3.add(lblNewLabel_5);

		cmbCourseIntructor = new JComboBox();
		cmbCourseIntructor.setBounds(423, 60, 164, 35);
		cmbCourseIntructor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbCourseIntructor.getSelectedItem() == null) {
					return;
				}
				courseSelected = (Course) cmbCourseIntructor.getSelectedItem();

			}
		});
		panel_3.add(cmbCourseIntructor);

		cmbLectureIntructor = new JComboBox();
		cmbLectureIntructor.setBounds(423, 120, 164, 35);
		cmbLectureIntructor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbLectureIntructor.getSelectedItem() == null) {
					return;
				}
				lectureSelected = (Person) cmbLectureIntructor.getSelectedItem();

			}
		});
		panel_3.add(cmbLectureIntructor);

		btnAddCourseInstructor = new JButton("Th??m");
		btnAddCourseInstructor.setIcon(new ImageIcon("img\\Add.png"));
		btnAddCourseInstructor.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnAddCourseInstructor.setBounds(47, 217, 117, 42);
		panel_3.add(btnAddCourseInstructor);

		btnEditCourseInstructor = new JButton("S???a");
		btnEditCourseInstructor.setIcon(new ImageIcon("img\\Edit.png"));
		btnEditCourseInstructor.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnEditCourseInstructor.setBounds(215, 217, 117, 42);
		panel_3.add(btnEditCourseInstructor);

		btnDeleteCourseInstructor = new JButton("Xo??");
		btnDeleteCourseInstructor.setIcon(new ImageIcon("img\\Delete.png"));
		btnDeleteCourseInstructor.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDeleteCourseInstructor.setBounds(380, 217, 117, 42);
		panel_3.add(btnDeleteCourseInstructor);

		btnReloadCourseInstructor = new JButton("T???i L???i");
		btnReloadCourseInstructor.setIcon(new ImageIcon("img\\update.png"));
		btnReloadCourseInstructor.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnReloadCourseInstructor.setBounds(544, 217, 117, 42);
		panel_3.add(btnReloadCourseInstructor);

		JButton btnSearchCourseIntructor = new JButton("T??m");
		btnSearchCourseIntructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgSearchCourseInstructor courseInstructor = new dlgSearchCourseInstructor();
				courseInstructor.setVisible(true);
				courseInstructor.setLocationRelativeTo(null);
			}
		});
		btnSearchCourseIntructor.setIcon(new ImageIcon("img\\Search.png"));
		btnSearchCourseIntructor.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnSearchCourseIntructor.setBounds(704, 217, 117, 42);
		panel_3.add(btnSearchCourseIntructor);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Qu\u1EA3n L\u00FD Ph\u00E2n C\u00F4ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_4.setLayout(null);
		panel_4.setBounds(25, 336, 920, 327);
		CourseIntructorCard.add(panel_4);

		JScrollPane scrollPane_3_1 = new JScrollPane();
		scrollPane_3_1.setBounds(10, 22, 900, 255);
		panel_4.add(scrollPane_3_1);

		dtmCourseInstructor = new DefaultTableModel();
		dtmCourseInstructor.addColumn("S??? th??? t???");
		dtmCourseInstructor.addColumn("T??n Kho?? H???c");
		dtmCourseInstructor.addColumn("T??n Ng?????i H?????ng D???n");

		tblCourseInstructor = new MyTable(dtmCourseInstructor);
		scrollPane_3_1.setViewportView(tblCourseInstructor);

		pnPageCourseIntructor = new JPanel();
		pnPageCourseIntructor.setBounds(69, 285, 769, 32);
		panel_4.add(pnPageCourseIntructor);

		// Sudent Grade Card
		GradeCard = new JPanel();
		pnCards.add(GradeCard, "GradeCard");
		GradeCard.setLayout(null);

		lblStudentGrade = new JLabel("Qu???n l?? k???t qu???");
		lblStudentGrade.setForeground(Color.RED);
		lblStudentGrade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentGrade.setBounds(377, 0, 326, 36);
		GradeCard.add(lblStudentGrade);

		panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("Button.highlight"));
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));

		panel_5.setBounds(48, 49, 860, 286);
		GradeCard.add(panel_5);
		panel_5.setLayout(null);

		lblNewLabel_7 = new JLabel("M?? h???c vi??n");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(267, 98, 140, 38);
		panel_5.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("M?? kh??a h???c");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(267, 36, 131, 38);
		panel_5.add(lblNewLabel_8);

		cmbCourseGrade = new JComboBox();
		cmbCourseGrade.setBounds(426, 40, 169, 35);
		cmbCourseGrade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbCourseGrade.getSelectedItem() == null) {
					return;
				}
				courseGradeSelected = (DTO.Course) cmbCourseGrade.getSelectedItem();

			}
		});
		panel_5.add(cmbCourseGrade);

		cmbStudent = new JComboBox();
		cmbStudent.setBounds(427, 102, 168, 35);
		cmbStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbStudent.getSelectedItem() == null) {
					return;
				}
				studentGradeSelected = (Person) cmbStudent.getSelectedItem();

			}
		});
		panel_5.add(cmbStudent);

		JLabel lblNewLabel_5_1 = new JLabel("??i???m");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(267, 155, 110, 38);
		panel_5.add(lblNewLabel_5_1);

		txtGrade = new JTextField();
		txtGrade.setBounds(426, 156, 169, 35);
		panel_5.add(txtGrade);
		txtGrade.setColumns(10);

		btnAddStudentGrade = new JButton("Th??m");
		btnAddStudentGrade.setIcon(new ImageIcon("img\\Add.png"));
		btnAddStudentGrade.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnAddStudentGrade.setBounds(43, 218, 117, 42);
		panel_5.add(btnAddStudentGrade);

		btnEditStudentGrade = new JButton("S???a");
		btnEditStudentGrade.setIcon(new ImageIcon("img\\Edit.png"));
		btnEditStudentGrade.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnEditStudentGrade.setBounds(206, 218, 117, 42);
		panel_5.add(btnEditStudentGrade);

		btnDeleteStudentGrade = new JButton("Xo??");
		btnDeleteStudentGrade.setIcon(new ImageIcon("img\\Delete.png"));
		btnDeleteStudentGrade.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDeleteStudentGrade.setBounds(372, 218, 117, 42);
		panel_5.add(btnDeleteStudentGrade);

		btnReloadStudentGrade = new JButton("T???i L???i");
		btnReloadStudentGrade.setIcon(new ImageIcon("img\\update.png"));
		btnReloadStudentGrade.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnReloadStudentGrade.setBounds(538, 218, 117, 42);
		panel_5.add(btnReloadStudentGrade);

		JButton btnSearchStudentsGrade = new JButton("T??m");
		btnSearchStudentsGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new dlgSearchGrade().setVisible(true);
			}
		});
		btnSearchStudentsGrade.setIcon(new ImageIcon("img\\Search.png"));
		btnSearchStudentsGrade.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnSearchStudentsGrade.setBounds(704, 218, 117, 42);
		panel_5.add(btnSearchStudentsGrade);

		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Qu\u1EA3n L\u00FD \u0110i\u1EC3m", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_6.setBounds(25, 356, 920, 307);
		GradeCard.add(panel_6);
		panel_6.setLayout(null);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setLocation(10, 21);
		scrollPane_4.setSize(900, 244);
		panel_6.add(scrollPane_4);

		dtmStudentGrade = new DefaultTableModel();
		dtmStudentGrade.addColumn("M?? ??i???m");
		dtmStudentGrade.addColumn("M?? kh??a h???c");
		dtmStudentGrade.addColumn("M?? h???c vi??n");
		dtmStudentGrade.addColumn("??i???m");

		tblStudentGrade = new MyTable(dtmStudentGrade);
		scrollPane_4.setViewportView(tblStudentGrade);

		pnGradeCard = new JPanel();
		pnGradeCard.setBounds(79, 271, 769, 32);
		panel_6.add(pnGradeCard);

	}

	public void addEvent() {

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
				// ID t??? ?????ng t??ng n??n ch??n s??? 0 ho???c null v??o ?????u c???a Constructor
				Person person = new Person(0, lastName, firstName, dateLecture, null);
				if (person.getFirstname().isEmpty() || person.getLastname().isBlank()) {
					JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng t??n");
					return;
				}
				if (person.getLastname().isEmpty() || person.getLastname().isBlank()) {
					JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng h???");
					return;
				}
				if (person.getHireDate() == null) {
					JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng ng??y thu??");
					return;
				}
				if (lectureBLL.addLecture(person)) {
					LoadListLecture();
					addPageLecture();
					JOptionPane.showMessageDialog(null, "???? th??m th??nh c??ng");
				} else {
					JOptionPane.showMessageDialog(null, "???? c?? l???i x???y ra khi th??m gi??o vi??n");
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
						if (person.getFirstname().isEmpty() || person.getLastname().isBlank()) {
							JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng t??n");
							return;
						}
						if (person.getLastname().isEmpty() || person.getLastname().isBlank()) {
							JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng h???");
							return;
						}
						if (person.getHireDate() == null) {
							JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng ng??y thu??");
							return;
						}
						if (lectureBLL.editLecture(person)) {
							LoadListLecture();
							addPageLecture();
							JOptionPane.showMessageDialog(null, "???? s???a th??nh c??ng");
						} else {
							JOptionPane.showMessageDialog(null, "???? c?? l???i x???y ra");
						}
					} else {
						JOptionPane.showMessageDialog(null, "B???n ch??a ch???n gi??o vi??n c???n s???a");
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
						int dialogResult = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo?? kh??ng?", "Warning",
								dialogButton);
						if (dialogResult == JOptionPane.YES_OPTION) {
							if (lectureBLL.deleteLecture(ID)) {
								LoadListLecture();
								addPageLecture();
								JOptionPane.showMessageDialog(null, "???? xo?? th??nh c??ng");
							} else {
								JOptionPane.showMessageDialog(null,
										"Gi??o vi??n n??y ???? ???????c ph??n c??ng gi???ng d???y, b???n ph???i xo?? ph??n c??ng tr?????c");
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "B???n ch??a ch???n gi??o vi??n c???n xo??");
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
					addPageLecture();
					JOptionPane.showMessageDialog(null, "???? t???i l???i danh s??ch th??nh c??ng");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "C?? l???i khi t???i danh s??ch gi??o vi??n");
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
				if (person.getFirstname().isEmpty() || person.getLastname().isBlank()) {
					JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng t??n");
					return;
				}
				if (person.getLastname().isEmpty() || person.getLastname().isBlank()) {
					JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng h???");
					return;
				}
				if (person.getEnrollmentDate() == null) {
					JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng ng??y ????ng k??");
					return;
				}
				if (studentBLL.addStudents(person)) {
					LoadListStudents();
					AddPageStudent();
					JOptionPane.showMessageDialog(null, "???? th??m th??nh c??ng");
				} else {
					JOptionPane.showMessageDialog(null, "???? c?? l???i x???y ra khi th??m gi??o vi??n");
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
						if (person.getFirstname().isEmpty() || person.getLastname().isBlank()) {
							JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng t??n");
							return;
						}
						if (person.getLastname().isEmpty() || person.getLastname().isBlank()) {
							JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng h???");
							return;
						}
						if (person.getEnrollmentDate() == null) {
							JOptionPane.showMessageDialog(null, "B???n kh??ng ???????c ????? tr???ng ng??y ????ng k??");
							return;
						}
						if (studentBLL.editStudents(person)) {
							LoadListStudents();
							AddPageStudent();
							JOptionPane.showMessageDialog(null, "???? s???a th??nh c??ng");
						} else {
							JOptionPane.showMessageDialog(null, "???? c?? l???i x???y ra");
						}
					} else {
						JOptionPane.showMessageDialog(null, "B???n ch??a ch???n h???c sinh c???n s???a");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		// delete Students
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tblStudents.getSelectedRow();
				try {
					if (i >= 0) {
						int ID = Integer.parseInt(dtmStudent.getValueAt(i, 0).toString());
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo?? kh??ng?", "Warning",
								dialogButton);
						if (dialogResult == JOptionPane.YES_OPTION) {
							if (studentBLL.deleteLecture(ID)) {
								LoadListStudents();
								AddPageStudent();
								JOptionPane.showMessageDialog(null, "???? xo?? th??nh c??ng");
							} else {
								JOptionPane.showMessageDialog(null, "???? c?? l???i x???y ra khi xo?? sinh vi??n");
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "B???n ch??a ch???n sinh vi??n c???n xo??");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		// reload
		btnReloadStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoadListStudents();
					AddPageStudent(); // x??? l?? ph??n trang
					JOptionPane.showMessageDialog(null, "???? t???i l???i danh s??ch th??nh c??ng");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "C?? l???i khi t???i danh s??ch gi??o vi??n");
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
						studentSelectedinTable = null;
						coursegradeSelectedinTable = null;
						String nameCourse = dtmStudentGrade.getValueAt(i, 1).toString();
						String nameStutent = dtmStudentGrade.getValueAt(i, 2).toString();
						String grade = dtmStudentGrade.getValueAt(i, 3).toString();
						System.out.println(nameCourse + " - " + nameStutent);
						for (int j = 0; j < coursesList.size(); j++) {
							if (nameCourse.toLowerCase().trim()
									.contains(coursesList.get(j).getTitle().toLowerCase().trim())) {
								cmbCourseGrade.setSelectedItem(coursesList.get(j));
								coursegradeSelectedinTable = coursesList.get(j);
								break;
							}
						}
						for (int j = 0; j < studentsList.size(); j++) {
							if (nameStutent.toLowerCase().trim()
									.contains(studentsList.get(j).getFirstname().toLowerCase().trim() + " "
											+ studentsList.get(j).getLastname().toLowerCase().trim())) {
								cmbStudent.setSelectedIndex(j);
								studentSelectedinTable = studentsList.get(j);
								break;
							}
						}
						txtGrade.setText(grade);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		// add Student Grade
		btnAddStudentGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (courseGradeSelected != null && studentGradeSelected != null) {
					Person student = studentGradeSelected;
					Course course = courseGradeSelected;
					String gradestr = txtGrade.getText();
					float grade = 0;
					try {
						grade = Float.parseFloat(gradestr);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "??i???m ph???i l?? s???");
						return;
					}
					StudentGrade studentGrade = new StudentGrade(0, course.getCourseID(), student.getID(), grade);
					if (studentGrade.getGrade() > 10 || studentGrade.getGrade() < 0) {
						JOptionPane.showMessageDialog(null, "??i???m kh??ng h???p l???");
						return;
					}
					if (studentGrade.getCourseID() < 0) {
						JOptionPane.showMessageDialog(null, "T??n kh??a h???c kh??ng ???????c ????? tr???ng");
						return;
					}
					if (studentGrade.getStudentID() < 0) {
						JOptionPane.showMessageDialog(null, "T??n h???c vi??n kh??ng ???????c ????? tr???ng");
						return;
					}
					if (studentGradeBLL.addGrade(studentGrade)) {
						addPageCourseGrade();
						LoadListGrade();
						LoadListStudents();
						JOptionPane.showMessageDialog(null, "???? th??m th??nh c??ng");
					} else {
						JOptionPane.showMessageDialog(null, "???? c?? l???i x???y ra khi th??m ??i???m kh??a h???c");
					}
				}

			}
		});
		// edit Student Grade
		btnEditStudentGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tblStudentGrade.getSelectedRow();
				try {
					float grade = Float.parseFloat(txtGrade.getText());
					if (i >= 0) {
						if (courseGradeSelected != null && studentGradeSelected != null) {
							Person student = studentGradeSelected;
							Course course = courseGradeSelected;
							String gradestr = txtGrade.getText();
							Float grade1 = Float.parseFloat(gradestr);
							String IDstr = dtmStudentGrade.getValueAt(i, 0).toString();
							int ID = Integer.parseInt(IDstr);
							StudentGrade studentGrade = new StudentGrade(ID, course.getCourseID(), student.getID(),
									grade1);
							if (studentGrade.getGrade() > 10 || studentGrade.getGrade() < 0) {
								JOptionPane.showMessageDialog(null, "??i???m kh??ng h???p l???");
								return;
							}
							if (studentGrade.getCourseID() < 0) {
								JOptionPane.showMessageDialog(null, "T??n kh??a h???c kh??ng ???????c ????? tr???ng");
								return;
							}
							if (studentGrade.getStudentID() < 0) {
								JOptionPane.showMessageDialog(null, "T??n h???c vi??n kh??ng ???????c ????? tr???ng");
								return;
							}
							if (studentGradeBLL.editGrade(studentGrade)) {
								LoadListGrade();
								LoadListStudents();
								JOptionPane.showMessageDialog(null, "???? s???a th??nh c??ng");
							} else {
								JOptionPane.showMessageDialog(null, "???? c?? l???i x???y ra khi s???a ??i???m kh??a h???c");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "B???n ch??a ch???n ??i???m c???n s???a");
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "??i???m kh??ng h???p l???");
					e2.printStackTrace();
				}
			}
		});
		// delete Student Grade
		btnDeleteStudentGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tblStudentGrade.getSelectedRow();
				try {
					if (i >= 0) {
						int idEnrollment = Integer.parseInt(dtmStudentGrade.getValueAt(i, 0).toString());
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo?? kh??ng?", "Warning",
								dialogButton);
						if (dialogResult == JOptionPane.YES_OPTION) {
							if (studentGradeBLL.deleteGrade(idEnrollment)) {
								LoadListGrade();
								JOptionPane.showMessageDialog(null, "???? xo?? th??nh c??ng");
							} else {
								JOptionPane.showMessageDialog(null, "???? c?? l???i x???y ra khi xo?? ??i???m");
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "B???n ch??a ch???n ??i???m c???n xo??");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		// reload student grade
		btnReloadStudentGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoadListGrade();
					addPageCourseGrade();
					JOptionPane.showMessageDialog(null, "???? t???i l???i danh s??ch th??nh c??ng");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "C?? l???i khi t???i danh s??ch ??i???m");
				}

			}
		});
		// END EVENT STUDENT GRADE

		// START EVENT COURSE INSTRUCTOR
		// click table course instructor
		tblCourseInstructor.addMouseListener(new MouseListener() {

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
				int i = tblCourseInstructor.getSelectedRow();
				if (i >= 0) {
					try {
						lectureSelectedinTalbe = null;
						courseSelectedinTable = null;
						String nameCourse = dtmCourseInstructor.getValueAt(i, 1).toString();
						String nameLecture = dtmCourseInstructor.getValueAt(i, 2).toString();
						for (int j = 0; j < coursesList.size(); j++) {
							if (nameCourse.toLowerCase().trim()
									.contains(coursesList.get(j).getTitle().toLowerCase().trim())) {
								cmbCourseIntructor.setSelectedIndex(j);
								courseSelectedinTable = coursesList.get(j);
								break;
							}
						}
						for (int j = 0; j < lecturesList.size(); j++) {
							if (nameLecture.toLowerCase().trim()
									.contains(lecturesList.get(j).getLastname().toLowerCase().trim())) {
								cmbLectureIntructor.setSelectedIndex(j);
								lectureSelectedinTalbe = lecturesList.get(j);
								break;
							}
						}

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		// add Course Instructor
		btnAddCourseInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (courseSelected != null && lectureSelected != null) {
					CourseInstructor courseInstructor = new CourseInstructor(courseSelected.getCourseID(),
							lectureSelected.getID());
					if (courseInstructor.getCourseID() < 0) {
						JOptionPane.showMessageDialog(null, "M?? kh??a h???c kh??ng ???????c ????? tr???ng ");
						return;
					}
					if (courseInstructor.getPersonID() < 0) {
						JOptionPane.showMessageDialog(null, "M?? gi???ng vi??n kh??ng ???????c ????? tr???ng");
						return;
					}
					if (courseInstructorBLL.addCourseInstructor(courseInstructor)) {
						addPageCourseInstructor();
						JOptionPane.showMessageDialog(null, "???? th??m th??nh c??ng");
					} else {
						JOptionPane.showMessageDialog(null, "???? c?? l???i x???y ra khi th??m ph??n c??ng");
					}
				}

			}
		});
		// edit Course Instructor
		btnEditCourseInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = tblCourseInstructor.getSelectedRow();
				try {
					if (i >= 0) {
						if (lectureSelected != null && courseSelected != null && courseSelectedinTable != null
								&& lectureSelectedinTalbe != null) {
							CourseInstructor courseInstructor1 = new CourseInstructor(courseSelected.getCourseID(),
									lectureSelected.getID());
							CourseInstructor courseInstructor2 = new CourseInstructor(
									courseSelectedinTable.getCourseID(), lectureSelectedinTalbe.getID());
							if (courseInstructor2.getCourseID() < 0) {
								JOptionPane.showMessageDialog(null, "M?? kh??a h???c kh??ng ???????c ????? tr???ng ");
								return;
							}
							if (courseInstructor2.getPersonID() < 0) {
								JOptionPane.showMessageDialog(null, "M?? gi???ng vi??n kh??ng ???????c ????? tr???ng");
								return;
							}
							if (courseInstructorBLL.editCourseInstructor(courseInstructor1, courseInstructor2)) {
								LoadListInstructor();
								addPageCourseInstructor();
								JOptionPane.showMessageDialog(null, "???? ch???nh s???a ph??n c??ng th??nh c??ng");
							} else {
								JOptionPane.showMessageDialog(null, "???? ch???nh s???a ph??n c??ng th???t b???i");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "B???n ch??a ch???n ph??n c??ng c???n s???a");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		// delete Course Instructor
		btnDeleteCourseInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tblCourseInstructor.getSelectedRow();
				try {
					if (i >= 0) {
						if (courseSelectedinTable != null && lectureSelectedinTalbe != null) {
							int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo?? kh??ng?", "Warning",
									dialogButton);
							if (dialogResult == JOptionPane.YES_OPTION) {
								if (new BLL.CourseInstructorBLL().deleteCourseInstructor(
										courseSelectedinTable.getCourseID(), lectureSelectedinTalbe.getID())) {
									LoadListInstructor();
									addPageCourseInstructor();
									JOptionPane.showMessageDialog(null, "???? xo?? ph??n c??ng th??nh c??ng");
								} else {
									JOptionPane.showMessageDialog(null, "???? xo?? ph??n c??ng th???t b???i");
								}
							}

						}

					} else {
						JOptionPane.showMessageDialog(null, "B???n ch??a ch???n ph??n c??ng c???n xo??");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		// reload Course Instructor
		btnReloadCourseInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoadListInstructor();
					addPageCourseInstructor();
					JOptionPane.showMessageDialog(null, "???? t???i l???i danh s??ch th??nh c??ng");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "C?? l???i khi t???i danh s??ch ph??n c??ng");
				}

			}
		});
		// END EVENT COURSE INSTRUCTOR

		tblCourseOnsite.addMouseListener(new MouseListener() {

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
				int i = tblCourseOnsite.getSelectedRow();
				if (i >= 0) {
					String courseName = dtmcourseSite.getValueAt(i, 2).toString();
					String Location = dtmcourseSite.getValueAt(i, 4).toString();
					String Date = dtmcourseSite.getValueAt(i, 5).toString();
					String Time = dtmcourseSite.getValueAt(i, 6).toString();
					String Department = dtmcourseSite.getValueAt(i, 3).toString();
					int j = 0;
					for (Department de : departmentsList) {
						j++;
						if (de.getName().contains(Department)) {
							cmbDepartment.setSelectedItem(de);
							break;
						}
					}
					for (String s : new Contrains().vec) {
						if (s.contains(Time)) {
							cmbTimeCourse.setSelectedItem(s);
							break;
						}
					}
					txtCourseName.setText(courseName);
					txtdateCourse.setText(Date);
					txtLocation.setText(Location);
					txtUrl.setText("");
				}

			}
		});
		tblCourseOnline.addMouseListener(new MouseListener() {

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
				int i = tblCourseOnline.getSelectedRow();
				if (i >= 0) {
					String courseName = dtmcourseOnline.getValueAt(i, 2).toString();
					String Department = dtmcourseOnline.getValueAt(i, 3).toString();
					String url = dtmcourseOnline.getValueAt(i, 4).toString();
					int j = 0;
					for (Department de : departmentsList) {
						j++;
						if (de.getName().contains(Department)) {
							cmbDepartment.setSelectedItem(de);
							break;
						}
					}
					txtCourseName.setText(courseName);
					txtdateCourse.setText("");
					txtLocation.setText("");
					txtUrl.setText(url);
					cmbTimeCourse.setSelectedIndex(0);
				}

			}
		});

	}

	public static ArrayList<DTO.Person> lecturesList;
	public static ArrayList<DTO.Person> studentsList;
	public static ArrayList<DTO.Department> departmentsList;
	public static ArrayList<DTO.StudentGrade> studentGradeList;
	public static ArrayList<DTO.CourseInstructor> courseInstructorList;
	public static ArrayList<DTO.Course> coursesList;
	public static ArrayList<OnsiteCourse> coursesOnsiteList;
	public static ArrayList<OnlineCourse> coursesOnLineList;
	public JTable tblCourseOnline;
	public JTextField txtdateCourse;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel pnPageCourseIntructor;
	public static JPanel pnGradeCard;
	private JPanel pnPageOnsite;
	private JPanel pnPageOnline;

	public void LoadListInstructor() {
		courseInstructorList = null;
		courseInstructorList = courseInstructorBLL.readAllCourseInstructor();
		ArrayList<DTO.CourseInstructor> arrayList = courseInstructorBLL.loadCourseInstructorByPage(1);
		dtmCourseInstructor.setRowCount(0);
		int i = 0;
		for (CourseInstructor courseInstructor : arrayList) {
			i++;
			Vector<Object> vec = new Vector<Object>();
			vec.add(String.valueOf(i));
			for (DTO.Course course : coursesList) {
				if (course.getCourseID() == courseInstructor.getCourseID()) {
					vec.add(course.getTitle());
					break;
				}
			}
			for (DTO.Person per : lecturesList) {
				if (per.getID() == courseInstructor.getPersonID()) {
					vec.add(per.getFirstname() + " " + per.getLastname());
					break;
				}
			}

			dtmCourseInstructor.addRow(vec);
		}
	}

	public void LoadListGrade() {
		studentGradeList = null;
		studentGradeList = studentGradeBLL.readAllGrade();
		ArrayList<DTO.StudentGrade> arrayList = studentGradeBLL.LoaddGradeByPage(1);
		dtmStudentGrade.setRowCount(0);
		LoadListStudents();
		LoadListCoursetoComboBox();
		for (StudentGrade studentGrade : arrayList) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(studentGrade.getEnrollmentID());
			for (DTO.Course course : coursesList) {
				if (course.getCourseID() == studentGrade.getCourseID()) {
					vec.add(course.getTitle());
					break;
				}
			}
			for (DTO.Person per : studentsList) {
				if (per.getID() == studentGrade.getStudentID()) {
					vec.add(per.getFirstname() + " " + per.getLastname());
					break;
				}
			}
			vec.add(studentGrade.getGrade());
			dtmStudentGrade.addRow(vec);
		}
	}

	public void LoadListLecture() {
		lecturesList = null;
		lecturesList = lectureBLL.readLectures();
		ArrayList<Person> arrayList = lectureBLL.loadLecturesByPage(1);
		dtmLecture.setRowCount(0);
		for (Person person : arrayList) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(person.getID());
			vec.add(person.getFirstname());
			vec.add(person.getLastname());
			vec.add(person.getHireDate());
			dtmLecture.addRow(vec);
			cmbLectureIntructor.addItem(person);
		}
		for (Person person : lecturesList) {
			cmbLectureIntructor.addItem(person);
		}
	}

	public void LoadListStudents() {
		studentsList = null;
		studentsList = studentBLL.readStudens();
		ArrayList<Person> arrayList = studentBLL.loadStudentsByPage(1);
		dtmStudent.setRowCount(0);
		cmbStudent.removeAllItems();
		for (Person person : arrayList) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(person.getID());
			vec.add(person.getFirstname());
			vec.add(person.getLastname());
			vec.add(person.getEnrollmentDate());
			dtmStudent.addRow(vec);

		}
		// add combobox students
		for (Person person : studentsList) {
			cmbStudent.addItem(person);
		}
	}

	public void LoadListOnlineCourse() {
		coursesOnLineList = null;
		coursesOnLineList = onlineCourseBLL.readAllCourseOnline();
		dtmcourseOnline.setRowCount(0);
		ArrayList<OnlineCourse> arrayList = onlineCourseBLL.loadCourseByPage(1);
		int i = 0;
		for (OnlineCourse course : arrayList) {
			i++;
			Vector<Object> vec = new Vector<Object>();
			vec.add(String.valueOf(i));
			vec.add(course.getCourseID());
			vec.add(course.getTitle());
			for (Department department : departmentsList) {
				if (department.getDepartmentID() == course.getDepartmentID()) {
					vec.add(department.getName());
					break;
				}
			}
			vec.add(course.getUrl());
			dtmcourseOnline.addRow(vec);
		}
	}

	public void LoadListOnsiteCourse() {
		coursesOnsiteList = null;
		coursesOnsiteList = onsiteCourseBLL.readAllOnsiteCourses();
		ArrayList<OnsiteCourse> arrayList = onsiteCourseBLL.loadOnsiteCoursesByPage(1);
		dtmcourseSite.setRowCount(0);
		int i = 0;
		for (OnsiteCourse course : arrayList) {
			i++;
			Vector<Object> vec = new Vector<Object>();
			vec.add(String.valueOf(i));
			vec.add(course.getCourseID());
			vec.add(course.getTitle());
			for (Department department : departmentsList) {
				if (department.getDepartmentID() == course.getDepartmentID()) {
					vec.add(department.getName());
					break;
				}
			}
			vec.add(course.getLocation());
			vec.add(course.getDays());
			vec.add(course.getTime());
			dtmcourseSite.addRow(vec);
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

	public void LoadListCoursetoComboBox() {
		coursesList = null;
		coursesList = new BLL.CourseBLL().readAllCourse();
		cmbCourseIntructor.removeAllItems();
		for (Course course : coursesList) {
			cmbCourseIntructor.addItem(course);
			cmbCourseGrade.addItem(course);
		}
	}

//	public void LoadComboTime() {
//		cmbTimeCourse.removeAllItems();
//		String hours = "00";
//		String miniutes = "00";
//		String seconds = "00";
//		int inthours = Integer.parseInt(hours);
//		for (int i = 0; i < 24; i++) {
//			if (i < 10) {
//				hours = "0" + i;
//			} else {
//				hours = i + "";
//			}
//			miniutes = "00";
//			String time = hours + ":" + miniutes + ":" + seconds;
//			System.out.println("vec.add(\""+time+"\");");
//			cmbTimeCourse.addItem(time);
//			int intminiutes = 15;
//			while (intminiutes <= 50 && intminiutes > 0) {
//				miniutes = String.valueOf(intminiutes);
//				if (intminiutes != 60) {
//					time = hours + ":" + miniutes + ":" + seconds;
//					System.out.println("vec.add(\""+time+"\");");
//				}
//				intminiutes += 15;
//				cmbTimeCourse.addItem(time);
//			}
//
//		}
//	}
	public void LoadComboTime() {
		cmbTimeCourse.removeAllItems();

		for (String s : new Contrains().vec) {
			cmbTimeCourse.addItem(s);
		}
	}

	public void initData() {
		LoadListLecture();
		LoadListStudents();
		LoadListDepartments();
		LoadListGrade();
		LoadListCoursetoComboBox();
		LoadListInstructor();
		LoadComboTime();
		LoadListOnsiteCourse();
		LoadListOnlineCourse();
		AddPageStudent();
		addPageLecture();
		addPageCourseInstructor();
		addPageCourseGrade();
		addPageOnsite();
		addPageOnline();
	}

	private void addPageOnline() {
		pnPageOnline.removeAll();
		pnPageOnline.revalidate();
		pnPageOnline.repaint();
		LoadListOnlineCourse();
//		coursesOnLineList = null;
//		coursesOnLineList = BLL.CourseBLL.readOnlineCourse();
		for (int i = 1; i <= (coursesOnLineList.size() / Contrains.pagesize) + 1; i++) {
			JButton button = new JButton("" + i);
			final int page = i;
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dtmcourseOnline.setRowCount(0);
					int j = 1;
					ArrayList<OnlineCourse> arrayList = onlineCourseBLL.loadCourseByPage(page);
					for (OnlineCourse course : arrayList) {

						Vector<Object> vec = new Vector<Object>();
						vec.add(String.valueOf(j));
						vec.add(course.getCourseID());
						vec.add(course.getTitle());
						for (Department department : departmentsList) {
							if (department.getDepartmentID() == course.getDepartmentID()) {
								vec.add(department.getName());
								break;
							}
						}
						vec.add(course.getUrl());
						dtmcourseOnline.addRow(vec);
						j++;
					}
				}
			});
			pnPageOnline.add(button);

		}

	}

	private void addPageOnsite() {
		pnPageOnsite.removeAll();
		pnPageOnsite.revalidate();
		pnPageOnsite.repaint();
		LoadListOnsiteCourse();
		for (int i = 1; i <= (coursesOnsiteList.size() / Contrains.pagesize) + 1; i++) {
			JButton button = new JButton("" + i);
			final int page = i;
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<OnsiteCourse> arrayList = onsiteCourseBLL.loadOnsiteCoursesByPage(1);
					dtmcourseSite.setRowCount(0);
					int i = 0;
					for (OnsiteCourse course : arrayList) {
						i++;
						Vector<Object> vec = new Vector<Object>();
						vec.add(String.valueOf(i));
						vec.add(course.getCourseID());
						vec.add(course.getTitle());
						for (Department department : departmentsList) {
							if (department.getDepartmentID() == course.getDepartmentID()) {
								vec.add(department.getName());
								break;
							}
						}
						vec.add(course.getLocation());
						vec.add(course.getDays());
						vec.add(course.getTime());
						dtmcourseSite.addRow(vec);
					}
				}
			});
			pnPageOnsite.add(button);

		}

	}

	private void addPageCourseGrade() {
		pnGradeCard.removeAll();
		pnGradeCard.revalidate();
		pnGradeCard.repaint();
		LoadListGrade();
		for (int i = 1; i <= (studentGradeList.size() / Contrains.pagesize) + 1; i++) {
			JButton button = new JButton("" + i);
			final int page = i;
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<StudentGrade> arrayList = new BLL.StudentGradeBLL().LoaddGradeByPage(page);
					dtmStudentGrade.setRowCount(0);
					LoadListStudents();
					LoadListCoursetoComboBox();
					for (StudentGrade studentGrade : arrayList) {
						Vector<Object> vec = new Vector<Object>();
						vec.add(studentGrade.getEnrollmentID());
						for (DTO.Course course : coursesList) {
							if (course.getCourseID() == studentGrade.getCourseID()) {
								vec.add(course.getTitle());
								break;
							}
						}
						for (DTO.Person per : studentsList) {
							if (per.getID() == studentGrade.getStudentID()) {
								vec.add(per.getFirstname() + " " + per.getLastname());
								break;
							}
						}
						vec.add(studentGrade.getGrade());
						dtmStudentGrade.addRow(vec);
					}

				}
			});
			pnGradeCard.add(button);

		}

	}

	private void addPageLecture() {
		pnPageLecture.removeAll();
		pnPageLecture.revalidate();
		pnPageLecture.repaint();
		LoadListLecture();
		for (int i = 1; i <= (lecturesList.size() / Contrains.pagesize) + 1; i++) {
			JButton button = new JButton("" + i);
			final int page = i;
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<Person> arrayList = lectureBLL.loadLecturesByPage(page);
					dtmLecture.setRowCount(0);
					for (Person person : arrayList) {
						Vector<Object> vec = new Vector<Object>();
						vec.add(person.getID());
						vec.add(person.getFirstname());
						vec.add(person.getLastname());
						vec.add(person.getHireDate());
						dtmLecture.addRow(vec);
					}
				}
			});
			pnPageLecture.add(button);

		}

	}

	private void addPageCourseInstructor() {
		pnPageCourseIntructor.removeAll();
		pnPageCourseIntructor.revalidate();
		pnPageCourseIntructor.repaint();
		LoadListInstructor();
		for (int i = 1; i <= (courseInstructorList.size() / Contrains.pagesize) + 1; i++) {
			JButton button = new JButton("" + i);
			final int page = i;
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					courseInstructorList = null;
					courseInstructorList = courseInstructorBLL.loadCourseInstructorByPage(page);
					dtmCourseInstructor.setRowCount(0);
					int i = 0;
					for (CourseInstructor courseInstructor : courseInstructorList) {
						i++;
						Vector<Object> vec = new Vector<Object>();
						vec.add(String.valueOf(i));
						for (DTO.Course course : coursesList) {
							if (course.getCourseID() == courseInstructor.getCourseID()) {
								vec.add(course.getTitle());
								break;
							}
						}
						for (DTO.Person per : lecturesList) {
							if (per.getID() == courseInstructor.getPersonID()) {
								vec.add(per.getFirstname() + " " + per.getLastname());
								break;
							}
						}

						dtmCourseInstructor.addRow(vec);
					}
				}
			});
			pnPageCourseIntructor.add(button);

		}

	}

	private void AddPageStudent() {
		pnPageStudents.removeAll();
		pnPageStudents.revalidate();
		pnPageStudents.repaint();
		LoadListStudents();
		for (int i = 1; i <= (studentsList.size() / Contrains.pagesize) + 1; i++) {
			JButton button = new JButton("" + i);
			final int page = i;
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					studentsList = null;
					studentsList = studentBLL.loadStudentsByPage(page);
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
			});
			pnPageStudents.add(button);

		}

	}
}
