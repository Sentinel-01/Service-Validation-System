package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class AdminViews extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViews frame = new AdminViews();
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
	public AdminViews() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(120, 66, 272, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnServiceValidationSystem = new JTextPane();
		txtpnServiceValidationSystem.setText("SERVICE VALIDATION SYSTEM");
		txtpnServiceValidationSystem.setBounds(120, 21, 192, 16);
		contentPane.add(txtpnServiceValidationSystem);
		
		JTextPane txtpnAdministratorView = new JTextPane();
		txtpnAdministratorView.setText("ADMINISTRATOR VIEW");
		txtpnAdministratorView.setBounds(146, 38, 147, 16);
		contentPane.add(txtpnAdministratorView);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 58, 370, 6);
		contentPane.add(separator);
		
		JLabel lblNameOfObj = new JLabel("Task Number");
		lblNameOfObj.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNameOfObj.setBounds(25, 72, 86, 16);
		contentPane.add(lblNameOfObj);
		
		JLabel lblDescription = new JLabel("Task Name");
		lblDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblDescription.setBounds(25, 103, 61, 16);
		contentPane.add(lblDescription);
		
		JLabel lblEvidenceType = new JLabel("Evidence type");
		lblEvidenceType.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblEvidenceType.setBounds(25, 252, 97, 16);
		contentPane.add(lblEvidenceType);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 246, 272, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 104, 272, 26);
		contentPane.add(textField_2);
		
		JLabel lblTaskDescription = new JLabel("Task Description");
		lblTaskDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblTaskDescription.setBounds(25, 136, 108, 16);
		contentPane.add(lblTaskDescription);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(125, 135, 256, 32);
		contentPane.add(textArea);
		
		JLabel lblProcessOwner = new JLabel("Executor");
		lblProcessOwner.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblProcessOwner.setBounds(29, 190, 97, 16);
		contentPane.add(lblProcessOwner);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(120, 183, 272, 26);
		contentPane.add(textField_4);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblEmail.setBounds(25, 224, 97, 16);
		contentPane.add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(120, 216, 272, 26);
		contentPane.add(textField_5);
	}
}
