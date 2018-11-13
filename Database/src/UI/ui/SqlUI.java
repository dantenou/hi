package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import javax.swing.JSplitPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTree;
import javax.swing.border.EtchedBorder;

public class SqlUI extends JFrame {

	private JPanel contentPane;
	private static int w;
	private static int h;
	private static int c;
	private static int lyc;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setResizable(false);
		
		
		
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName()	
				);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //设置JFrame
		setTitle("SQL操作界面");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/pic/co.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 562);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(UIManager.getBorder("Menu.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//设置图片
		ImageIcon img =new ImageIcon("src/pic/co.png");
		img.setImage(img.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setBounds(526, 39, 277, 21);
		contentPane.add(toolBar);
		
		//设置按钮图标
		ImageIcon pen =new ImageIcon("src/pic/penc.png");
		pen.setImage(pen.getImage().getScaledInstance(15, 20, Image.SCALE_DEFAULT));
		
		ImageIcon bt =new ImageIcon("src/pic/bt.png");
		bt.setImage(bt.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		
		ImageIcon st =new ImageIcon("src/pic/st.png");
		st.setImage(st.getImage().getScaledInstance(15, 20, Image.SCALE_DEFAULT));
		
		
		
		JButton button = new JButton("对象浏览");
		button.setIcon(bt);
		toolBar.add(button);
		toolBar.addSeparator();
		
		JButton button_1 = new JButton("数据浏览");
		button_1.setIcon(st);
		toolBar.add(button_1);
		toolBar.addSeparator();
		
		JButton btnSql = new JButton("SQL编辑");
		btnSql.setIcon(pen);
		toolBar.add(btnSql);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(Color.YELLOW);
		menuBar.setBounds(0, 0, 542, 28);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("文件(Z)  ");
		mnNewMenu.setBackground(Color.MAGENTA);
		mnNewMenu.setToolTipText("这是文件");
		mnNewMenu.getToolkit().getMaximumCursorColors();
		
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("连接管理（R）...");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("打开（S）");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(arg0.getActionCommand());
				System.out.println(mnNewMenu.getToolkit().getScreenSize());
				
			}
		});
		mntmNewMenuItem_1.setMnemonic('S');
		mnNewMenu.addSeparator();
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("保存（T）");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				System.out.println(e.getModifiers());
			}
		});
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_MASK));	
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("另存为（U）");
		mntmNewMenuItem_4.setMnemonic(KeyEvent.VK_U);
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_8 = new JMenu("导出（X）");
		mnNewMenu.add(mnNewMenu_8);
		mnNewMenu_8.setEnabled(false);
		
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("SQL文件（S）...");
		mnNewMenu_8.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("CSV文件（C）...");
		mnNewMenu_8.add(mntmNewMenuItem_7);
		
		mnNewMenu.addSeparator();
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("关闭（Y）");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("退出（Z）");
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_1 = new JMenu("编辑(Y)  ");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmq_1 = new JMenuItem("撤销（Q）...");
		mnNewMenu_1.add(mntmq_1);
		
		JMenuItem mntmq = new JMenuItem("重做（R）...");
		mnNewMenu_1.add(mntmq);
		
		mnNewMenu_1.addSeparator();
		
		JMenuItem mntmt = new JMenuItem("复制（T）");
		mnNewMenu_1.add(mntmt);
		
		JMenuItem mntmu = new JMenuItem("黏贴（U）");
		mnNewMenu_1.add(mntmu);
		
		mnNewMenu_1.addSeparator();
		
		JMenuItem mntmz = new JMenuItem("重命名（Z）");
		mnNewMenu_1.add(mntmz);
		
		JMenu mnNewMenu_2 = new JMenu("搜索(X)  ");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmx = new JMenuItem("搜索（X）");
		mnNewMenu_2.add(mntmx);
		
		JMenu mnNewMenu_3 = new JMenu("视图(W)  ");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("对象浏览（T）");
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmu_1 = new JMenuItem("数据浏览（U）");
		mnNewMenu_3.add(mntmu_1);
		
		JMenuItem mntmSql_1 = new JMenuItem("SQL编辑（S）");
		mnNewMenu_3.add(mntmSql_1);
		
		mnNewMenu_3.addSeparator();
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("刷新（Y）");
		mnNewMenu_3.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_4 = new JMenu("数据库(V)  ");
		mnNewMenu_4.setVisible(false);
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_9 = new JMenu("New menu");
		mnNewMenu_4.add(mnNewMenu_9);
		
		JMenu mnNewMenu_10 = new JMenu("New menu");
		mnNewMenu_4.add(mnNewMenu_10);
		
		JMenu mnNewMenu_11 = new JMenu("New menu");
		mnNewMenu_4.add(mnNewMenu_11);
		
		JMenu mnNewMenu_5 = new JMenu("其他(T)  ");
		mnNewMenu_5.setEnabled(false);
		mnNewMenu_5.setToolTipText("暂无服务提供");
		menuBar.add(mnNewMenu_5);
		
		JMenu mnNewMenu_6 = new JMenu("设置(U)  ");
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmx_1 = new JMenuItem("连接设置（X）...");
		mnNewMenu_6.add(mntmx_1);
		
		JMenu mnNewMenu_7 = new JMenu("帮助(S)");
		menuBar.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("索引（W）...");
		mnNewMenu_7.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("SQL帮助（S)...");
		mnNewMenu_7.add(mntmNewMenuItem_9);
		
		JMenuItem mntmSql = new JMenuItem("SQL手册（M）");
		mnNewMenu_7.add(mntmSql);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(556, 0, 229, 33);
		contentPane.add(toolBar_1);
		
		JTextArea textArea = new JTextArea();
		toolBar_1.add(textArea);
		textArea.setBackground(Color.WHITE);
		textArea.setText("请输入");
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(128, 128, 128), null, null));
		
		toolBar_1.addSeparator();
		
		JButton button_2 = new JButton("搜索");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(button_2.isEnabled());
				
			}
		});
//		button_2.setFont(new Font("华文行楷", 100, 25));
		ImageIcon icn =new ImageIcon("src/pic/mir.png");
		icn.setImage(icn.getImage().getScaledInstance(30, 20, Image.SCALE_DEFAULT));
		button_2.setIcon(icn);
		toolBar_1.add(button_2);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		splitPane.setBounds(0, 65, 830, 450);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		//设置表（JTree来设置表）
		JTree tree = new JTree();
		panel.add(tree);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.black);
		splitPane.setRightComponent(layeredPane);
		
		//分层页宽度与高度
		int lw=721;
		int lh=446;
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(0, 0, lw, lh);
		layeredPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 0, lw, lh);
		layeredPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(0, 0, lw, lh);
		layeredPane.add(panel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.GRAY, null, null));
		separator.setBounds(0, 32, 830, 2);
		contentPane.add(separator);
		System.out.println(this.getWidth());
		
		//监听事件实现区域
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lyc==3){
					lyc=0;
					layeredPane.moveToFront(layeredPane.getComponent(lyc));
				}
				if(lyc<=layeredPane.getComponentCount()-1){
					layeredPane.moveToFront(layeredPane.getComponent(lyc));
					lyc++;
				}
				
			}
		});
		
		
	}
}
