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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ApproverView extends JFrame {

	private JPanel contentPane;
	private JTextField task_name;
	private JTextField Executor;
	private JTextField Evidence_type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApproverView frame = new ApproverView();
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
	public ApproverView() {
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
		btnSubmit.setBounds(304, 204, 94, 29);
		contentPane.add(btnSubmit);
		
		JCheckBox approve = new JCheckBox("Approve");
		approve.setBounds(123, 207, 93, 23);
		contentPane.add(approve);
		
		JCheckBox reject = new JCheckBox("Reject");
		reject.setBounds(218, 207, 93, 23);
		contentPane.add(reject);
		
		JLabel label_1 = new JLabel("Task Name");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		label_1.setBounds(38, 91, 61, 16);
		contentPane.add(label_1);
		
		task_name = new JTextField();
		task_name.setColumns(10);
		task_name.setBounds(133, 92, 272, 26);
		contentPane.add(task_name);
		
		JLabel label_3 = new JLabel("Executor");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		label_3.setBounds(38, 134, 97, 16);
		contentPane.add(label_3);
		
		Executor = new JTextField();
		Executor.setColumns(10);
		Executor.setBounds(133, 129, 272, 26);
		contentPane.add(Executor);
		
		JLabel label_4 = new JLabel("Evidence type");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		label_4.setBounds(38, 168, 97, 16);
		contentPane.add(label_4);
		
		Evidence_type = new JTextField();
		Evidence_type.setColumns(10);
		Evidence_type.setBounds(133, 163, 272, 26);
		contentPane.add(Evidence_type);
		
		JComboBox task_list = new JComboBox();
		task_list.setBounds(123, 61, 275, 20);
		contentPane.add(task_list);
		Preprocess getdata =new Preprocess();
		 ArrayList<Preprocess> result=getdata.getTask();
		 for(Preprocess p: result)
		 {
			 task_list.addItem(p.getTaskType());
			 //+"   "+p.getTaskExecutor()+"  "+p.getEvidence()
		 }
		
		task_list.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String task_type=task_list.getSelectedItem().toString();
				for(Preprocess p: result)
				 {
					if(p.getTaskType().equals(task_type))
					{
						Executor.setText(p.getTaskExecutor());
						Evidence_type.setText(p.getEvidence());
						task_name.setText(task_type);
					}
				 }
			}
		});
	}
}
