package pingce;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login_Frame {
private static JTextField name_textField;
	private static JPasswordField psd_textField;
	public static JFrame frame;
	public JTextField getname_textField () {
		return name_textField;
	}
	public JPasswordField getpsd_textField () {
		return psd_textField;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JFrame.setDefaultLookAndFeelDecorated(true);//删除界面原有样式
		frame = new JFrame();
		frame.setUndecorated(true);
		//Border b = new CompoundBorder(new EtchedBorder(),new LineBorder(Color.RED));
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(360,331);
		//panel.setBorder(b);
		panel.addMouseMotionListener(new MouseAdapter() {
			private boolean top = false;
			private boolean down = false;
		    private boolean left = false;
		    private boolean right = false;
		    private Point draggingAnchor = null;
		            @Override
			public void mouseMoved(MouseEvent e) {
				if(  e.getPoint().getY() == 0 ){
		             frame.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
		             top = true;
	             }else if(Math.abs(e.getPoint().getY()- frame.getSize().getHeight()) <= 1 ){
		             frame.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
		             down = true;
	             }else if(e.getPoint().getX() == 0 ){
		             frame.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
		             left = true;
	             }else if(Math.abs(e.getPoint().getX()- frame.getSize().getWidth()) <=1 ){
		             frame.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
		             right = true;
	             }else{
		             frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		             draggingAnchor = new Point(e.getX() + panel.getX(), e.getY() + panel.getY());
		             top = false;
		             down = false;
		             left = false;
		             right = false;
	             }
		    }
            @Override
            public void mouseDragged(MouseEvent e) {
            	Dimension dimension = frame.getSize();
            	if(top){
            		dimension.setSize(dimension.getWidth() ,dimension.getHeight()-e.getY());
            		frame.setSize(dimension);
            		frame.setLocation(frame.getLocationOnScreen().x, frame.getLocationOnScreen().y + e.getY());
            	}else if(down){
            	 	dimension.setSize(dimension.getWidth() , e.getY());
            	 	frame.setSize(dimension);
            	}else if(left){
            		dimension.setSize(dimension.getWidth() - e.getX() ,dimension.getHeight() );
            		frame.setSize(dimension);
            		frame.setLocation(frame.getLocationOnScreen().x + e.getX(),frame.getLocationOnScreen().y );
            	}else if(right){
		             dimension.setSize(e.getX(),dimension.getHeight());
		             frame.setSize(dimension);
            	}else { 
                     frame.setLocation(e.getLocationOnScreen().x - draggingAnchor.x, e.getLocationOnScreen().y - draggingAnchor.y);
            	}
            }
        });
		
		
		panel.setBackground(new Color(176, 224, 230));//为panel设背景色
		panel.addKeyListener(new keylistener());//设置panel的keylistener方法，用于登陆
		//添加用户名输入框
		name_textField = new JTextField();
		name_textField.setFont(new Font("黑体", Font.PLAIN, 16));
		name_textField.setBounds(42, 150, 180, 21);
		panel.add(name_textField);
		name_textField.setColumns(10);
		name_textField.setOpaque(false);//设置透明
		name_textField.setBorder(new EmptyBorder(0,0,0,0));
		name_textField.addKeyListener(new keylistener());//设置name_textField的keylistener方法，用于登陆
		
		//添加密码输入框
		psd_textField = new JPasswordField();
		psd_textField.setEchoChar((char) 0);
		psd_textField.setFont(new Font("黑体", Font.PLAIN, 16));
		psd_textField.setForeground(Color.BLACK);
		psd_textField.setBackground(Color.WHITE);
		psd_textField.setToolTipText("");
		psd_textField.setBounds(42, 201, 180, 21);
		psd_textField.setOpaque(false);//设置透明
		panel.add(psd_textField);
		psd_textField.setBorder(null);//设置无边框
		psd_textField.addKeyListener(new keylistener());//设置psd_textField的keylistener方法，用于登陆
		
		//设置 窗体居中
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 268) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 266) / 2;
		frame.setLocation(w, h);
		//frame.setLocation(200,100);///////////////设置初始位置
		
		frame.getContentPane().add(panel);//添加panel
		
		
		///////////////////////////设置用户名         开始         输入下划线//////////////////////////////////////
		JLabel label = new JLabel("___________________________");
		label.setBounds(42, 165, 191, 15);
		panel.add(label);
		///////////////////////////设置用户名         结束         输入下划线//////////////////////////////////////
		
		
		////////////////////////////设置密码          开始          输入下划线//////////////////////////////////////
		JLabel label_1 = new JLabel("___________________________");
		label_1.setBounds(42, 216, 191, 15);
		panel.add(label_1);
		////////////////////////////设置密码          结束          输入下划线//////////////////////////////////////
		
		
		////////////////////////设置用户名输入框，密码输入框，无焦点时候的样式    开始
		String info1 = "请输入账号";
	    String info2 = "请输入密码";
		name_textField.setText(info1);
		psd_textField.setText(info2);
		name_textField.addFocusListener(new MyFocusListener(info1, name_textField));//添加焦点事件反映
		psd_textField.addFocusListener(new MyFocusListener1(info2, psd_textField));
		////////////////////////设置用户名输入框，密码输入框，无焦点时候的样式    结束
		
		
		//////////////////////////////设置头像    开始
		java.util.Random r=new java.util.Random();
		int t = r.nextInt(2)+2;
		System.out.println(t);
		JLabel lblTest = new JLabel();
		lblTest.setBounds(78, 26, 104, 104);
		lblTest.setIcon(new ImageIcon(Login_Frame.class.getResource("/res/head"+Integer.toString(t)+".png")));
		lblTest.setHorizontalAlignment(0);
		panel.add(lblTest);
		///////////////////////////////设置头像    结束
		
		//////////////////////////////设置三个圆形按钮   开始
		int circle_r=15;
		Color arrColor[] = new Color[] { Color.red, Color.green, Color.YELLOW};
	    
    	CircleButton cb = new CircleButton("",arrColor[0]);
    	panel.add(cb);
    	cb.addActionListener(new RedClickAction());
    	cb.setBounds(10, 5, circle_r, circle_r);
    	
    	CircleButton cb1 = new CircleButton("",arrColor[1]);
    	panel.add(cb1);
    	cb1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.setExtendedState(JFrame.ICONIFIED);
    		}
    	});
    	cb1.setBounds(35, 5, circle_r, circle_r);
    	
    	
    	CircleButton cb2 = new CircleButton("",arrColor[2]);
    	panel.add(cb2);
    	cb2.addActionListener(new YellowClickAction());
    	cb2.setBounds(60, 5, circle_r, circle_r);
    	//////////////////////////////设置三个圆形按钮   结束
		
    	panel.setBorder(BorderFactory.createLineBorder(Color.RED, 0, true));
    	
    	
    	
    	
		frame.setSize(268,266);//设置窗体大小
		frame.setResizable(false);//设置用户不可以改变窗口大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}



