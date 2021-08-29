package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Course;
import dao.CourseDao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex02_2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private CourseDao dao = new CourseDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex02_2 frame = new Ex02_2();
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
		public Ex02_2() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Code");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel.setBounds(51, 38, 45, 16);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(106, 35, 70, 19);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(106, 83, 265, 19);
			contentPane.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(106, 137, 88, 19);
			contentPane.add(textField_2);
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setBounds(51, 185, 69, 27);
			contentPane.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Course c = new Course(textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()));
					dao.saveCourse(c);
					setDefaultCloseOperation(3);
				}
			});
			
			JLabel lblName = new JLabel("Name");
			lblName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblName.setBounds(51, 83, 45, 16);
			contentPane.add(lblName);
			
			JLabel lblNewLabel_1_2 = new JLabel("Credit");
			lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_1_2.setBounds(51, 137, 45, 16);
			contentPane.add(lblNewLabel_1_2);
			
			JButton btnClear = new JButton("Clear");
			btnClear.setBounds(145, 185, 69, 27);
			contentPane.add(btnClear);
		}
		
}
