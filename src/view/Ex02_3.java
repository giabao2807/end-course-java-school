package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Course;
import dao.CourseDao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class Ex02_3 extends JFrame {

	private CourseDao dao = new CourseDao();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex02_3 frame = new Ex02_3();
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
	public Ex02_3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("List of all courses (order by Credit)");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(70, 0, 300, 38);
		contentPane.add(lblNewLabel);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 46, 416, 207);
		contentPane.add(textArea);
		for(Course course : dao.getAllCourse()) {
			textArea.append(course.toString() + "\n");
		}
	}
}
