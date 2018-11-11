package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class SqlUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						UIManager.setLookAndFeel(
							UIManager.getSystemLookAndFeelClassName()	
						);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					SqlUI frame = new SqlUI();
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
	public SqlUI() {
		setTitle("oneTeamBench");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\美图\\图标\\ti.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 572);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setOpaque(false);
		tabbedPane.setName("fucck\r\n");
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setBounds(0, 94, 746, 431);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("计算", null, panel, null);
		panel.setLayout(null);
		
		JButton btnOo = new JButton("oo");
		btnOo.setBounds(44, 107, 113, 27);
		panel.add(btnOo);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("花间", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("mm\r\n");
		
		//do definite myself
		btnNewButton.addActionListener(new ACL());		
		btnNewButton.setBounds(33, 71, 113, 27);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("总结", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("变形", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel1_4 = new JPanel();
		ImageIcon img =new ImageIcon("F:\\美图\\图标\\ti.jpg");
		img.setImage(img.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		tabbedPane.addTab("王道", null, panel1_4, "4444");
		panel1_4.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 441, 40);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JSeparator separator = new JSeparator();
		menuBar.add(separator);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JSeparator separator_1 = new JSeparator();
		menuBar.add(separator_1);
		
		JMenu mnNewMenu_2 = new JMenu("New menu");
		menuBar.add(mnNewMenu_2);
		
		JSeparator separator_2 = new JSeparator();
		menuBar.add(separator_2);
		
		JMenu mnNewMenu_3 = new JMenu("New menu");
		menuBar.add(mnNewMenu_3);

	}
}
