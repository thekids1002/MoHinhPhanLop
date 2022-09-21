package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	CardLayout cardLayout;
	private JPanel CourseCard;
	private JLabel lblCourseCard;
	private JPanel CourseIntructorCard;
	private JLabel lblCourseIntructor;
	private JPanel GradeCard;
	private JLabel label;
	private JPanel panel;
	private JButton btnStudent;
	private JButton btnLecture;
	private JButton btnCourse;
	private JButton btnCourseIntructor;
	private JButton btnGrade;
	private JPanel pnCards;
	private StudentPanel StudentCard;
	private JLabel lblStudents;
	private Student2 LectureCard;
	private JLabel lblLecture;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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

	}

	private void addControl() {
		panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(-9, 10, 300, 663);
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

		StudentCard = new StudentPanel();
		pnCards.add(StudentCard, "StudentCard");
		StudentCard.setLayout(null);

		lblStudents = new JLabel("Quản lý sinh viên");
		lblStudents.setBounds(351, 269, 45, 13);
		StudentCard.add(lblStudents);

		LectureCard = new Student2();
		pnCards.add(LectureCard, "LectureCard");
		LectureCard.setLayout(null);

		lblLecture = new JLabel("Quản lý giáo viên");
		lblLecture.setBounds(328, 349, 45, 13);
		LectureCard.add(lblLecture);

		cardLayout = (CardLayout) pnCards.getLayout();

		CourseCard = new JPanel();
		pnCards.add(CourseCard, "CourseCard");

		lblCourseCard = new JLabel("Course");
		CourseCard.add(lblCourseCard);

		CourseIntructorCard = new JPanel();
		pnCards.add(CourseIntructorCard, "CourseIntructorCard");
		CourseIntructorCard.setLayout(null);

		lblCourseIntructor = new JLabel("lblCourseIntructor");
		lblCourseIntructor.setBounds(440, 5, 82, 13);
		CourseIntructorCard.add(lblCourseIntructor);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 254, 670, 358);
		CourseIntructorCard.add(scrollPane);
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("tets");
		dtm.addColumn("adhhsahdah");
		table = new MyTable(dtm);
		scrollPane.setViewportView(table);

		GradeCard = new JPanel();
		pnCards.add(GradeCard, "GradeCard");

		label = new JLabel("GradeCard");
		GradeCard.add(label);
		
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
				cardLayout.show(pnCards, "StudentCard");
			}
		});

		btnCourseIntructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pnCards, "CourseCard");
			}
		});

		btnGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pnCards, "CourseIntructorCard");
			}
		});
		
	}
}
