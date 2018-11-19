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
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import javax.swing.JSplitPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.CellEditor;

import java.awt.event.WindowStateListener;
import java.util.ArrayList;
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
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Choice;
import java.awt.Scrollbar;
import javax.swing.event.CaretListener;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.event.CaretEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import java.awt.ComponentOrientation;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class SqlUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JTable table;
	private JTable table_1;
	private static int ju=-1;//(jundge),判断popupmenu的上层组件
	private static int ra=-1;//(rowAll),判断整行删除,不然表格改动的监听器会报错。。。。。
	
	

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
		
		//-----设置界面与系统保持一致
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
		//设置图片(并无卵用)
		ImageIcon img =new ImageIcon("src/pic/co.png");
		img.setImage(img.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setBounds(417, 39, 413, 21);
		contentPane.add(toolBar);
		
		//设置按钮图标------------------------------------------------------------------------------
		ImageIcon pen =new ImageIcon("src/pic/penc.png");
		pen.setImage(pen.getImage().getScaledInstance(15, 20, Image.SCALE_DEFAULT));
		
		ImageIcon bt =new ImageIcon("src/pic/bt.png");
		bt.setImage(bt.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		
		ImageIcon st =new ImageIcon("src/pic/st.png");
		st.setImage(st.getImage().getScaledInstance(15, 20, Image.SCALE_DEFAULT));
		
		ImageIcon net =new ImageIcon("src/pic/NET.png");
		net.setImage(net.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		
		//设置JTree叶节点图标
		ImageIcon le =new ImageIcon("src/pic/le.png");
		le.setImage(le.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		
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
		toolBar.addSeparator();
		
		JButton btnNet = new JButton("同网传输");
		btnNet.setIcon(net);
		toolBar.add(btnNet);
		
		//弹出按钮
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(0, 0, 200, 60);
		
		JMenuItem mntmAdd = new JMenuItem("新建记录（I）");		
		popupMenu.add(mntmAdd);
		
		popupMenu.addSeparator();
		
		JMenuItem mntmMin = new JMenuItem("删减记录（D）");
		popupMenu.add(mntmMin);
		
		//JTree弹出按钮
		JPopupMenu popup = new JPopupMenu();
		popupMenu.setBounds(0, 0, 200, 60);
		
		JMenuItem mnd = new JMenuItem("新建表格（N）");		
		popup.add(mnd);
		
		popup.addSeparator();
		
		JMenuItem mnm = new JMenuItem("删除表格（N）");		
		popup.add(mnm);
		
		
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
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "这是索引菜单栏", "索引通知", JOptionPane.WARNING_MESSAGE, null);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("SQL帮助（S)...");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "寻求帮助请发送1716794359@qq.com", "SQL帮助", JOptionPane.WARNING_MESSAGE, null);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_9);
		
		JMenuItem mntmSql = new JMenuItem("SQL手册（M）");
		mntmSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "本手册仅用于测试人员", "SQL手册", JOptionPane.WARNING_MESSAGE, null);
			}
		});
		mnNewMenu_7.add(mntmSql);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setEnabled(false);
		toolBar_1.setBounds(556, 0, 229, 26);
		contentPane.add(toolBar_1);
		
		JTextArea textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				
			}
		});
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

		ImageIcon icn =new ImageIcon("src/pic/mir.png");
		icn.setImage(icn.getImage().getScaledInstance(30, 20, Image.SCALE_DEFAULT));
		button_2.setIcon(icn);
		toolBar_1.add(button_2);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 65, 830, 450);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		//设置表（JTree来设置表）--------------------------------------------------------	
		DefaultMutableTreeNode rt=new DefaultMutableTreeNode("localhost");
		JTree tree = new JTree(rt);
		
		//修改节点神器
		DefaultTreeModel treeModel=(DefaultTreeModel)tree.getModel();
		
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger())
					popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		tree.setEditable(true);
		panel.add(tree);
		
		
		DefaultTreeCellRenderer dtc=(DefaultTreeCellRenderer)tree.getCellRenderer();
		dtc.setLeafIcon(le);
		
		//设置叶节点，根节点的参数
		String[][] strr=new String[][]{
			   {"Moon","Cow","Milk"},{"Min","Plus","Pay"}
		   };
//		DefaultMutableTreeNode[] node=new DefaultMutableTreeNode[5];
//		tree.setShowsRootHandles(false);
		for(int i=0;i<strr.length;i++){
			DefaultMutableTreeNode[] node=new DefaultMutableTreeNode[strr.length+1];
			node[0] =new DefaultMutableTreeNode(strr[i][0]);
			rt.add(node[0]);
			for(int j=1;j<strr[i].length;j++){
				node[j] =new DefaultMutableTreeNode(strr[i][j]);
				node[0].add(node[j]);		
			}			
		}
		
		
		//分层面板
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.black);
		splitPane.setRightComponent(layeredPane);
		
		//分层页宽度与高度
		int lw=721;
		int lh=446;
		
		//layeredPane 里的三个页面：panel1，对象浏览；panel2，数据浏览；panel3，SQL编辑（黄，灰色，蓝色）
		panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(0, 0, lw, lh);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 721, 446);		
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()){
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
					ju=1;//table唤醒的弹出菜单
				}
			}
		});
		scrollPane_1.setViewportView(table);
		//对象浏览视图表格
		String[] title={"名称","类型","记录","大小"};
		DefaultTableModel dtm =(DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(title);
		
		//排序器
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(dtm));				
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 0, lw, lh);
		layeredPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 721, 446);
		panel_2.add(scrollPane_2);
		
		//数据浏览表格
		table_1 = new JTable();
		table_1.setRowHeight(25);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_2.setViewportView(table_1);
		//-------------------------怎么设置数据（要根据树来设置col数组的值），要等唐宇轩给数据。。。。。。
		String[] col={"武功名称","任务","武学等级","年龄","门派"};
		DefaultTableModel d =(DefaultTableModel)table_1.getModel();
		d.setColumnIdentifiers(col);
		d.addRow(col);
		//排序器
		table_1.setRowSorter(new TableRowSorter(d));
		//右键点击表格，弹出菜单出现
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()){
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
					ju=2;
				}			
			}
		});
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.blue);
		panel_3.setBounds(0, 0, lw, lh);
		layeredPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 721, 446);
		panel_3.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font(null, Font.ITALIC, 25));
		textArea_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//---这一块代码不用管。。。。。。就是给特效的
				try {
					Rectangle re=textArea_1.modelToView(textArea_1.getCaretPosition());
					int h=re.y/re.height;
					int st=textArea_1.getLineStartOffset(h);
					int end=textArea_1.getLineEndOffset(h);
					//防止高亮叠加
					textArea_1.getHighlighter().removeAllHighlights();
					textArea_1.getHighlighter().addHighlight(st, end, DefaultHighlighter.DefaultPainter);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   //------------------------------------------------------------
				
				
			}
		});
		textArea_1.setSelectedTextColor(Color.white);
		textArea_1.setSelectionColor(new Color(217,232,252));
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 31, 828, 2);
		contentPane.add(separator);
		
		//监听事件实现区域---------------------------------------------------------------------------------------------------------------------------------		
		//对象浏览按钮
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.moveToFront(panel_1);
			}
		});
		
		//数据浏览按钮
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.moveToFront(panel_2);				
			}
		});
		
		//SQL编辑按钮
		btnSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.moveToFront(panel_3);
			}
		});
		
		//同网传输按钮
		btnNet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		//JTree的cell修改事件监听
		tree.getCellEditor().addCellEditorListener(new CellEditorListener(){
			@Override
			public void editingCanceled(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("修改取消");
				JOptionPane.showMessageDialog(null, "取消修改", "失败界面", JOptionPane.CANCEL_OPTION);
			}

			@Override
			public void editingStopped(ChangeEvent e) {
				// TODO Auto-generated method stub
				CellEditor editor = (CellEditor)e.getSource();
				String nodeAfterEditer = (String)editor.getCellEditorValue();               				 
                System.out.println("After eidtor:"+nodeAfterEditer ); 
                JOptionPane.showMessageDialog(null, "修改成功，修改后的节点名称为："+nodeAfterEditer+",请记得点击数据库图标，刷新对象浏览界面", "成功界面", JOptionPane.WARNING_MESSAGE);
                //打印修改之前的节点的名称
                DefaultMutableTreeNode node =(DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
                System.out.println("Befor editor："+node);
 
			}
			
		});
		
		
		
		//实现菜单项新建表格方法
		mnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("新建数据表");
				DefaultMutableTreeNode node =new DefaultMutableTreeNode("new node");
				TreePath p=tree.getSelectionPath();
				DefaultMutableTreeNode par =(DefaultMutableTreeNode)p.getLastPathComponent();
				if(par.isLeaf()){
					System.out.println("不可以给表格添加表格");
					return;	
				}
				System.out.println("本节点看来不是叶节点，可以添加表格");	
				treeModel.insertNodeInto(node, par, par.getChildCount());
				//增加一行表格
				String[] c={"武功名称","任务","武学等级","年龄","门派"};
        		dtm.addRow(c);
				
			}
		});
		
		//实现菜单项删除数据表方法
		mnm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("删除数据表");
				TreePath p=tree.getSelectionPath();
				
				if(p==null){
					JOptionPane.showMessageDialog(null, "先选择一个路径啊删掉，不然咋删啊", "失败界面", JOptionPane.ERROR_MESSAGE);
				}
				else{
					DefaultMutableTreeNode node =(DefaultMutableTreeNode)p.getLastPathComponent();
					if(node.isRoot()){//判断根节点
						JOptionPane.showMessageDialog(null, "不可删除根节点", "失败界面", JOptionPane.ERROR_MESSAGE);
					}
					else{						
						treeModel.removeNodeFromParent(node);
						d.removeRow(table_1.getRowCount()-1);//删除一行
						JOptionPane.showMessageDialog(null, "你把想删掉的给删了", "成功界面", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("删除成功");
					}
				}						
			}
		});
				
		//实现菜单项新建记录方法
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("新建记录");
				if(ju==1){
					System.out.println("table修改ing");
					System.out.println("对象表不可修改");
				}
				else{
					if(ju==2){
						System.out.println("table_1修改ing");
					}
					else{
						System.out.println("不存在表格");
					}
				}
				
			}
		});
		//实现菜单项删减记录方法
		mntmMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("删减记录");
				if(ju==1){
					System.out.println("table删减ing");
					System.out.println("table中"+(table.getSelectedRow()+1));
					System.out.println("对象表不可修改");
					
				}
				else{
					if(ju==2){
						System.out.println("table1111删减ing");
						System.out.println("table_1中删去的是："+(table_1.getSelectedRow()+1));
						d.removeRow(table_1.getSelectedRow());						
					}
					else{
						System.out.println("删减，table就不存在");
					}
				}
			}
		});
		
		//table的修改监听
		table.getModel().addTableModelListener(new TableModelListener(){

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub				
				try{
					int col=e.getColumn();
					int row=e.getFirstRow();
					System.out.println(row+"行，"+col+"列"+"的值变化为"+table.getValueAt(row, col));
				}catch(Exception a){					
					System.out.println("table本来会报错。。。。。但是嘿嘿嘿，整行变动");
				}
			}
			
		});
		
		//table_1的修改监听
		table_1.getModel().addTableModelListener(new TableModelListener(){
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub							
				try{
					int col=e.getColumn();
					int row=e.getFirstRow();
					System.out.println(row+"行，"+col+"列"+"的值变化为"+table_1.getValueAt(row, col));
				}catch(Exception a){					
					System.out.println("table_1本来会报错。。。。。但是嘿嘿嘿，整行变动");
				}
				
				
			}	
		});
		
		//点击树，可以显示数据图都有啥表
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				TreePath p=tree.getSelectionPath();
				DefaultMutableTreeNode node =(DefaultMutableTreeNode)p.getLastPathComponent();
				if(node.isRoot()||node.isLeaf()){
					System.out.println("得点击数据库才行");
				}
				else{						
					dtm.setRowCount(0);//清除之前的表格数据
					for(int i=0;i<=node.getChildCount()-1;i++){
						dtm.addRow(new Object[]{node.getChildAt(i),"InnoDB","~5","16KB"});
						System.out.println();
					}
					
					
				}
			}
		});

		
		
	}//-------------SqlUI的设置尽头--------------------
}
