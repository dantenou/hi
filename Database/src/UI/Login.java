package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		try {
			try {
				UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName()	
				);
			} catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 569);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\美图\\图标\\ti.jpg"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(186, 60, 191, 24);
		contentPane.add(textArea);
		
		JLabel label_1 = new JLabel("名称：");
		label_1.setBounds(75, 62, 72, 18);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8BF4\u660E", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label.setBounds(14, 27, 439, 76);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("主机：");
		label_2.setBounds(75, 139, 72, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("端口：");
		label_3.setBounds(75, 170, 72, 18);
		contentPane.add(label_3);
		
		JLabel lblNewLabel = new JLabel("连接类型：");
		lblNewLabel.setBounds(75, 201, 83, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label_4 = new JLabel("用户：");
		label_4.setBounds(75, 282, 72, 18);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("密码：");
		label_5.setBounds(75, 313, 72, 18);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("数据库：");
		label_6.setBounds(75, 354, 72, 18);
		contentPane.add(label_6);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(186, 280, 191, 20);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(186, 311, 191, 20);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(186, 199, 191, 20);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(186, 168, 191, 20);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(186, 135, 191, 20);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(186, 352, 191, 20);
		contentPane.add(textArea_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBorder(new TitledBorder(null, "\u8FDE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		label_7.setBounds(14, 116, 439, 120);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBorder(new TitledBorder(null, "\u767B\u5F55\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		label_8.setBounds(14, 251, 439, 156);
		contentPane.add(label_8);
		
		JButton button = new JButton("帮助");
		button.setBounds(36, 474, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("确定");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new SqlUI().setVisible(true);;
				dispose();
			}
		});
		button_1.setBounds(180, 474, 113, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("取消");
		button_2.setBounds(317, 474, 113, 27);
		contentPane.add(button_2);
	}

}
