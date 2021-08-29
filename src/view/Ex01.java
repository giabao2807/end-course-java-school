package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Ex01 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex01 frame = new Ex01();
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
	public Ex01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp chu\u1ED7i");
		lblNewLabel.setBounds(81, 10, 111, 44);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblThcHin = new JLabel("Th\u1EF1c hi\u1EC7n");
		lblThcHin.setBounds(81, 77, 111, 44);
		lblThcHin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblThcHin);
		
		JLabel lblNewLabel_2 = new JLabel("Nh\u1EADp chu\u1ED7i");
		lblNewLabel_2.setBounds(81, 157, 111, 44);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(208, 10, 409, 34);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox<String> cbbThucHien = new JComboBox<String>();
		cbbThucHien.setBounds(208, 77, 174, 35);
		cbbThucHien.addItem("Đếm từ");
		cbbThucHien.addItem("Đếm từ trùng lặp");
		cbbThucHien.addItem("Đảo chuỗi");
		contentPane.add(cbbThucHien);
		
		JButton ViewBtn = new JButton("View");
		ViewBtn.setBounds(106, 402, 95, 34);
		ViewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String str = textField.getText().toString().trim();
				if(str.equals("")) {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Please input string",  "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					int selectedIndex = cbbThucHien.getSelectedIndex();
					switch(selectedIndex) {
					case 0:
						demTu(str);
						//JOptionPane.showMessageDialog(null, String.valueOf(cbbThucHien.getSelectedIndex()));
						break;
					case 1:
						demTuTrungLap(str);
						//JOptionPane.showMessageDialog(null, String.valueOf(cbbThucHien.getSelectedIndex()));
						break;
					case 2:
						daoChuoi(str);
						//JOptionPane.showMessageDialog(null, String.valueOf(cbbThucHien.getSelectedIndex()));
						break;
					}
				}
			}

			private void daoChuoi(String str) {
				String[] arr= str.split(" ");
				for(int i = arr.length -1; i>=0; i--) {
					textArea.append(arr[i] + " ");
				}
			}

			private void demTuTrungLap(String str) {
				String[] arrString = str.split(" ");
				int count = 0;
				for(int i = 0; i<arrString.length; i++) {
					if(isNotExist(arrString, i)) {
						for(int j = i; j<arrString.length; j++) {
							if(arrString[i].equals(arrString[j])) {
									count++;
							}
						}
						//textArea.setText();
						textArea.append(arrString[i] + ": " + count   + " lan" + "\n");
					}
					count = 0;
				}
				
			}
			private boolean isNotExist(String[] arr, int index) {
				for(int i = index-1; i >= 0; i--)
					if(arr[i].equals(arr[index])) {
						return false;
					}
				return true;
			}

			private void demTu(String str) {
				String[] arrString = str.split(" ");
				textArea.setText("Tong so cac tu thuc hien co trong chuoi la: " + arrString.length);
			}
		});
		ViewBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(ViewBtn);
		
		JButton ResetBtn = new JButton("Reset");
		ResetBtn.setBounds(274, 402, 95, 34);
		ResetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textArea.setText("");
				cbbThucHien.setSelectedIndex(-1);
			}
		});
		ResetBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(ResetBtn);
		
		JButton ExitBtn = new JButton("Exit");
		ExitBtn.setBounds(477, 402, 95, 34);
		ExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DISPOSE_ON_CLOSE);			
				}
		});
		ExitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(ExitBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 169, 409, 211);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	}
}

