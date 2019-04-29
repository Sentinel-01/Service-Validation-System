package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBConnection;

import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ProcessOwnView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcessOwnView frame = new ProcessOwnView();
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
	public ProcessOwnView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("SERVICE VALIDATION SYSTEM");
		textPane.setBounds(118, 19, 192, 16);
		contentPane.add(textPane);
		
		JTextPane txtpnProcessOwnerView = new JTextPane();
		txtpnProcessOwnerView.setText("PROCESS OWNER VIEW");
		txtpnProcessOwnerView.setBounds(144, 36, 147, 16);
		contentPane.add(txtpnProcessOwnerView);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 56, 370, 6);
		contentPane.add(separator);
		
		JLabel lblObjectType = new JLabel("Task Type");
		lblObjectType.setBounds(33, 74, 93, 16);
		contentPane.add(lblObjectType);
		
		JLabel lblObjectApprover = new JLabel("Task Executor");
		lblObjectApprover.setBounds(245, 74, 126, 16);
		contentPane.add(lblObjectApprover);
		
		JComboBox<String> task_type = new JComboBox<String>();
		task_type.setBounds(24, 91, 180, 27);
		contentPane.add(task_type);
		
		JLabel lblEvidence = new JLabel("Evidence");
		lblEvidence.setBounds(32, 130, 93, 16);
		contentPane.add(lblEvidence);
		
		JComboBox<String> evidence = new JComboBox<String>();
		evidence.setBounds(23, 147, 180, 27);
		contentPane.add(evidence);
		
		JComboBox<String> task_executor = new JComboBox<String>();
		task_executor.setBounds(239, 91, 180, 27);
		contentPane.add(task_executor);
		
		/**
 		*  Create another task process if the user desires.
 		*/
		JButton btnAddAnother = new JButton("Add Another");
		btnAddAnother.setBounds(23, 199, 117, 29);
		contentPane.add(btnAddAnother);
		DBConnection DB = new DBConnection();
		DBConnection DB1 = new DBConnection();
		DBConnection DB2 = new DBConnection();
		try {
			ResultSet s=DB.getProcessOwnerConnection();
			while(s.next())
			{
				task_type.addItem(s.getString("task_name"));
			}
			ResultSet taskExecResult=DB1.getExecutorConnection();
			while(taskExecResult.next())
			{
				task_executor.addItem(taskExecResult.getString("Executor_Name"));
			}
			ResultSet evidenceResult=DB2.getEvidenceConnection();
			while(evidenceResult.next())
			{
				evidence.addItem(evidenceResult.getString("evidence_type"));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Preprocess p =new Preprocess();
		btnAddAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			p.setTask(task_type.getSelectedItem().toString(),task_executor.getSelectedItem().toString(),evidence.getSelectedItem().toString());
			}
		});
		
		/**
 		*  Tells application that user has finished adding/selecting processes.
 		*/
		JButton btnComplete = new JButton("Complete");
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.awt.EventQueue.invokeLater(new Runnable() {

			        public void run() {
			        	new MultiLogin().setVisible(true);
			        }
			    });
			}
		});
		btnComplete.setBounds(300, 199, 117, 29);
		contentPane.add(btnComplete);
	}
}
