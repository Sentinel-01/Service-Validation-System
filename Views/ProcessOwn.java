package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProcessOwn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcessOwn frame = new ProcessOwn();
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
	public ProcessOwn() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(24, 91, 180, 27);
		contentPane.add(comboBox);
		
		JLabel lblEvidence = new JLabel("Evidence");
		lblEvidence.setBounds(32, 130, 93, 16);
		contentPane.add(lblEvidence);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(23, 147, 180, 27);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(239, 91, 180, 27);
		contentPane.add(comboBox_2);
		
		JButton btnAddAnother = new JButton("Add Another");
		btnAddAnother.setBounds(23, 199, 117, 29);
		contentPane.add(btnAddAnother);
		
		JButton btnComplete = new JButton("Complete");
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComplete.setBounds(300, 199, 117, 29);
		contentPane.add(btnComplete);
	}
}
