package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Approver extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Approver frame = new Approver();
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
	public Approver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 54, 370, 6);
		contentPane.add(separator);
		
		JTextPane txtpnApprover = new JTextPane();
		txtpnApprover.setText("APPROVER");
		txtpnApprover.setBounds(187, 32, 72, 16);
		contentPane.add(txtpnApprover);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("SERVICE VALIDATION SYSTEM");
		textPane_1.setBounds(123, 17, 192, 16);
		contentPane.add(textPane_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setBounds(304, 249, 94, 29);
		contentPane.add(btnSubmit);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Approve");
		chckbxNewCheckBox.setBounds(133, 250, 93, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxReject = new JCheckBox("Reject");
		chckbxReject.setBounds(215, 250, 93, 23);
		contentPane.add(chckbxReject);
		
		JLabel label = new JLabel("Task Number");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		label.setBounds(38, 60, 86, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(133, 54, 272, 26);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Task Name");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		label_1.setBounds(38, 91, 61, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 92, 272, 26);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Task Description");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		label_2.setBounds(38, 124, 108, 16);
		contentPane.add(label_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(138, 123, 260, 32);
		contentPane.add(textArea);
		
		JLabel label_3 = new JLabel("Executor");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		label_3.setBounds(38, 168, 97, 16);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 162, 272, 26);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("Evidence type");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		label_4.setBounds(38, 196, 97, 16);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 190, 272, 26);
		contentPane.add(textField_3);
		
		JLabel lblProcessOwner = new JLabel("Process Owner");
		lblProcessOwner.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblProcessOwner.setBounds(38, 230, 97, 16);
		contentPane.add(lblProcessOwner);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(133, 224, 272, 26);
		contentPane.add(textField_4);
	}
}
