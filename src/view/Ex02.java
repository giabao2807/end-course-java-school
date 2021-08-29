package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Ex02 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex02 frame = new Ex02();
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
	public Ex02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Courses Management");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(132, 24, 192, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add a new Course");
		btnNewButton.setBounds(85, 65, 273, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Ex02_2().setVisible(true);
			}
		});
		
		JButton btnDisplayAllCourse = new JButton("Display all Courses");
		btnDisplayAllCourse.setBounds(85, 118, 273, 21);
		contentPane.add(btnDisplayAllCourse);
		btnDisplayAllCourse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){	
				new Ex02_3().setVisible(true);
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Search Course by Course Code");
		btnNewButton_1_1.setBounds(85, 168, 273, 21);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Exit Application");
		btnNewButton_1_1_1.setBounds(85, 218, 273, 21);
		contentPane.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(3);
				
			}
		});
	}
	
}
