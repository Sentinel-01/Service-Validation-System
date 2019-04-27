package Views;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Executor extends JPanel {

	/**
	 * Create the panel.
	 */
	public Executor() {
		setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("SERVICE VALIDATION SYSTEM");
		textPane.setBounds(144, 11, 192, 16);
		add(textPane);
		
		JTextPane txtpnExecutor = new JTextPane();
		txtpnExecutor.setText("EXECUTOR");
		txtpnExecutor.setBounds(185, 30, 72, 16);
		add(txtpnExecutor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 57, 417, 2);
		add(separator);
		
		JSlider slider = new JSlider();
		slider.setBounds(33, 146, 387, 26);
		add(slider);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(23, 171, 46, 14);
		add(lblStart);
		
		JLabel lblComplete = new JLabel("Complete");
		lblComplete.setBounds(374, 183, 46, 14);
		add(lblComplete);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(23, 135, 46, 14);
		add(lblStatus);
		
		JLabel lblTask = new JLabel("Task");
		lblTask.setBounds(23, 75, 46, 14);
		add(lblTask);
		
		JButton btnUploadEvidence = new JButton("Upload Evidence");
		btnUploadEvidence.setBounds(24, 224, 135, 23);
		add(btnUploadEvidence);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(59, 72, 177, 20);
		add(comboBox);
		
		JButton btnComplete = new JButton("Complete");
		btnComplete.setBounds(291, 224, 89, 23);
		add(btnComplete);

	}
}
