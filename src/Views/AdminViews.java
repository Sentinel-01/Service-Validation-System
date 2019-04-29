package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBConnection;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;

public class AdminViews extends JFrame {

	private JPanel contentPane;
	private JTextField TaskNumber;
	private JTextField EvidenceType;
	private JTextField TaskName;
	private JTextField ExecutorName;
	private JTextField ExecutorEmail;

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
		setBounds(100, 100, 450, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TaskNumber = new JTextField();
		TaskNumber.setBounds(120, 66, 272, 26);
		contentPane.add(TaskNumber);
		TaskNumber.setColumns(10);
		
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
		
		EvidenceType = new JTextField();
		EvidenceType.setColumns(10);
		EvidenceType.setBounds(123, 246, 272, 26);
		contentPane.add(EvidenceType);
		
		TaskName = new JTextField();
		TaskName.setColumns(10);
		TaskName.setBounds(120, 104, 272, 26);
		contentPane.add(TaskName);
		
		JLabel lblTaskDescription = new JLabel("Task Description");
		lblTaskDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblTaskDescription.setBounds(25, 136, 108, 16);
		contentPane.add(lblTaskDescription);
		
		JTextArea TaskDescription = new JTextArea();
		TaskDescription.setBounds(125, 135, 256, 32);
		contentPane.add(TaskDescription);
		
		JLabel lblProcessOwner = new JLabel("Executor");
		lblProcessOwner.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblProcessOwner.setBounds(29, 190, 97, 16);
		contentPane.add(lblProcessOwner);
		
		ExecutorName = new JTextField();
		ExecutorName.setColumns(10);
		ExecutorName.setBounds(120, 183, 272, 26);
		contentPane.add(ExecutorName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblEmail.setBounds(25, 224, 97, 16);
		contentPane.add(lblEmail);
		
		ExecutorEmail = new JTextField();
		ExecutorEmail.setColumns(10);
		ExecutorEmail.setBounds(120, 216, 272, 26);
		contentPane.add(ExecutorEmail);
		
		/**
		 *  On "Submit", send all inputs to a special ArrayList.
		 */
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(120, 332, 89, 23);
		contentPane.add(btnSubmit);
		DBConnection DB = new DBConnection();
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String taskNumber,taskName,taskDescription,executor,email,evidencetype;
				taskNumber= TaskNumber.getText().toString();
				taskName=TaskName.getText().toString();
				taskDescription=TaskDescription.getText().toString();
				
				executor=ExecutorName.getText().toString();
				email=ExecutorEmail.getText().toString();
				evidencetype=EvidenceType.getText().toString();
				ArrayList<AdminViews> tasks=new ArrayList<AdminViews>();
				//String[] tasknames = 
				try {
					ResultSet s=DB.getAdminstratorConnection(taskNumber,taskName,taskDescription);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
