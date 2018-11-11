package try2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.MemoryImageSource;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Graphics3 extends JFrame  implements MouseListener, MouseMotionListener, ActionListener{

	public static int mouseAtX;
	public static int mouseAtY;
	public static int w;
	public static int h;
	private  MJPanel panel;
	private int c=0;
	private int cy=50;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Graphics3 f = new Graphics3();
					f.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public Graphics3() {		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                System.exit(0);
	            }
				
				if (e.getKeyCode() == 65) {
	                repaint();
	            }
			}
		});
	
//		addMouseListener(new MouseAdapter(){
//            public void mousePressed(MouseEvent e) 
//            {
//              
//                mouseAtX = e.getPoint().x;
//                mouseAtY = e.getPoint().y;
//            }
//         });      
//          addMouseMotionListener(new MouseMotionAdapter(){
//              public void mouseDragged(MouseEvent e) 
//              {
//                  setLocation((e.getXOnScreen()-mouseAtX),(e.getYOnScreen()-mouseAtY));//设置拖拽后，窗口的位置
//              }
//          });

        
  		
  		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Image image = defaultToolkit.createImage(new MemoryImageSource(0, 0, null, 0, 0));
        Cursor invisibleCursor = defaultToolkit.createCustomCursor(image, new Point(0, 0), "cursor");
        setCursor(invisibleCursor);

		this.setUndecorated(true);
		this.getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
		
	
        
        panel = new MJPanel();	
        w=this.getWidth();
  		h=this.getHeight();
  		
  		
  		
        setLayout(new BorderLayout());       
        add(panel, BorderLayout.CENTER);
        this.setBackground(Color.black);    
	    System.out.println("这是"+ w+" "+h);
	    
	    new Timer(250,this).start();
		
	}
	
	public class MJPanel extends JPanel {
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			for (int i = 0; i < 250; i++) {
		          g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
		          g.setFont(new Font("微软雅黑", Font.BOLD, (int) (Math.random() * 80)));
		          g.drawString("★", (int) (Math.random() *w), (int) (Math.random() * h));	
//		          g.drawString(String.valueOf((char) (new Random().nextInt(94) + 33)),(int) (Math.random() * 1366+1), (int) (Math.random() * 768+1));
		         
		          
		          
		      }			      
//		      g.setFont(new Font("微软雅黑", Font.BOLD, 150));     
//		      g.setColor(new Color((int) (Math.random() * 256),(int) (Math.random() * 256), (int) (Math.random() * 256)));
//		      g.drawString(new Date().toLocaleString(), 5, 200);
//		      g.drawString(String.valueOf((char) (new Random().nextInt(94) + 33)),(int) (Math.random() * 1366+1), (int) (Math.random() * 768+1));
//		      g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
		      g.setFont(new Font("微软雅黑", Font.BOLD, (int) (Math.random() * 256)));
		      g.drawString(String.valueOf((char) (new Random().nextInt(94) + 33)),(int) (Math.random() * w), (int) (Math.random() * h));
//			g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
//			g.fillOval(c+100, cy, 53, 60);
//			c=c+50;
//			if(c>w){
//				c=100;
//				cy=cy+50;
//			}
		
		}

		
		}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("1561");
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	
}
