package pingce;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main_Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	//private JPanel contentPane;
	public static JTextField stu_id;
	public static JTextField stu_name;
	public static JTextField address;
	public static JTextField stu_tel;
	public static JRadioButton true_gender;
	public static JRadioButton false_gender;
	public static JTextField find_id;
	public static JPanel[] panel_arr = new JPanel[7];
	public static JTextField msg_find;
	public static Connection t;
	public static PreparedStatement sql;/////////要添加
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JTextField textField_6;
	public static JTextField textField_7;
	public static JTextField textField_8;
	public static JTextField textField_9;
	public static JTable table;
	public static JTable table_6;
	public static JTable table_7;
	public static JTextField textField_10;
	public static JTable table_1;
	public static DefaultTableModel defaultModel = null;
	public static DefaultTableModel defaultModel_1 = null;
	public static DefaultTableModel defaultModel_2 = null;
	public static DefaultTableModel defaultModel_3 = null;
	public static JFrame frame = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main_Frame();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_Frame() {
		
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.setUndecorated(true);
		//Border b = new CompoundBorder(new EtchedBorder(),new LineBorder(Color.RED));
		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 497, 387);
		
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
		frame.getContentPane().setLayout(null);
		//////////////////////////////设置三个圆形按钮   结束
		
		
		//////////////////////////////////////////////设置menuBar 开始
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(45, 0, 310, 40);///////////重设menuBar位置
		frame.getContentPane().add(menuBar);
		menuBar.setOpaque(false);
		//////////////////////////////////////////////设置menuBar 结束
		
		frame.getContentPane().add(panel);
		frame.setSize(497, 387);  ///设置窗体大小
		frame.setResizable(false);//设置用户不可以改变窗口大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//设置 窗体居中
		int x=(int)(frame.getWidth()*0.091);
		menuBar.setBounds(x, 0, 310, 40);///////////重设menuBar位置
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 268) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 266) / 2;
		frame.setLocation(w, h);///////////////设置初始位置
		/////////////////////////////////////////////////////////窗体设置                           结束
		
		panel.setBackground(new Color(255, 240, 245));//为panel设背景色
		//panel.setOpaque(false);//设置panel透明
		//////////////////////////////设置三个圆形按钮   开始
		int circle_r=15;
		Color arrColor[] = new Color[] { Color.red, Color.green, Color.YELLOW};
    	panel.setLayout(null);
	    
    	CircleButton cb = new CircleButton("",arrColor[0]);
    	cb.setBounds(472, 10, circle_r, circle_r);
    	panel.add(cb);
    	cb.addActionListener(new RedClickAction());
    	
    	CircleButton cb1 = new CircleButton("",arrColor[1]);
    	cb1.setBounds(422, 10, circle_r, circle_r);
    	panel.add(cb1);
    	cb1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.setExtendedState(JFrame.ICONIFIED);
    		}
    	});
    	
    	
    	CircleButton cb2 = new CircleButton("",arrColor[2]);
    	cb2.setBounds(447, 10, circle_r, circle_r);
    	cb2.addActionListener(new YellowClickAction());
    	panel.add(cb2);
    	//////////////////////////////设置三个圆形按钮   结束
    	
    	///////////////常量初始化
    	final String info[]= {"请输入学号","请输入姓名","请输入家庭住址","请输入联系方式","请输入删除学生学号","请输入学号","请输入语文成绩","请输入数学成绩","请输入英语成绩"};
    	ButtonGroup group = new ButtonGroup();
		//JPanel panel_arr[] = {};
		
    	//////////////////初始化结束
    	//test
  ///////////////////////////////////////以下是所有关于test的代码/////////////////////////////////////////////////////////  	
    	panel_arr[0] = new JPanel();
    	panel_arr[0].setBounds(55, 68, 336, 286);
    	panel.add(panel_arr[0]);
    	panel_arr[0].setBackground(new Color(255, 255, 255));
    	panel_arr[0].setLayout(null);
    	panel_arr[0].setVisible(false);
    	panel_arr[0].setOpaque(false);//设置panel透明
    	
    	stu_id = new JTextField();
    	stu_id.setText(info[0]);//////请输入学号
    	stu_id.setBounds(35, 32, 164, 21);
    	stu_id.setBorder(null);//设置无边框
    	stu_id.setOpaque(false);//设置透明
    	stu_id.addFocusListener(new MyFocusListener(info[0],stu_id));   //////学生id
    	stu_id.addKeyListener(new InputKey());
    	stu_id.setFont(new Font("黑体", Font.PLAIN, 16));
    	stu_id.addKeyListener(new insert_stu_msg());///////////////////////加入输入事件
    	panel_arr[0].add(stu_id);
    	stu_id.setColumns(10);
    	
    	stu_name = new JTextField();
    	stu_name.setText(info[1]);////请输入姓名
    	stu_name.setColumns(10);
    	stu_name.setBounds(36, 80, 163, 21);
    	stu_name.setBorder(null);//设置无边框
    	stu_name.setOpaque(false);//设置透明
    	stu_name.addFocusListener(new MyFocusListener(info[1],stu_name));
    	stu_name.setFont(new Font("黑体", Font.PLAIN, 16));
    	stu_name.addKeyListener(new insert_stu_msg());//////////////////加入输入事件
    	panel_arr[0].add(stu_name);
    	true_gender = new JRadioButton("\u7537");///男
    	true_gender.setBounds(40, 125, 57, 23);
    	true_gender.setOpaque(false);//设置透明
    	true_gender.setSelected(true);
    	panel_arr[0].add(true_gender);
    	
    	false_gender = new JRadioButton("\u5973");//女
    	false_gender.setBounds(131, 125, 45, 23);
    	false_gender.setOpaque(false);//设置透明
    	panel_arr[0].add(false_gender);
    	group.add(false_gender);
    	group.add(true_gender);
    	//////////////////////////////////////////////////设置男女         结束
    	
    	
    	
    	////////////////////////////////////////////////////////////
    	address = new JTextField();
    	address.setText(info[2]);////请输入家庭住址
    	address.setColumns(10);
    	address.setBounds(36, 173, 297, 21);
    	address.setBorder(null);//设置无边框
    	address.setOpaque(false);//设置透明
    	address.addFocusListener(new MyFocusListener(info[2],address));
    	address.setFont(new Font("黑体", Font.PLAIN, 16));
    	address.addKeyListener(new insert_stu_msg());//////////////////加入输入事件
    	panel_arr[0].add(address);
    	///////////////////////////////////////////////////////////
    	
    	
    	//////////////学生联系方式     开始
    	stu_tel = new JTextField();
    	stu_tel.setText(info[3]);///请输入联系方式
    	stu_tel.setColumns(10);
    	stu_tel.setBounds(36, 219, 163, 21);
    	stu_tel.setBorder(null);//设置无边框
    	stu_tel.setOpaque(false);//设置透明
    	stu_tel.addFocusListener(new MyFocusListener(info[3],stu_tel));
    	stu_tel.setFont(new Font("黑体", Font.PLAIN, 16));
    	stu_tel.addKeyListener(new insert_stu_msg());//////////////////加入输入事件
    	stu_tel.addKeyListener(new InputKey());
    	panel_arr[0].add(stu_tel);
    	/////////////学生联系方式结束
    	
    	JLabel label_5 = new JLabel("_______________________");
    	label_5.setBounds(37, 49, 184, 15);
    	panel_arr[0].add(label_5);
    	
    	JLabel label_6 = new JLabel("_______________________");
    	label_6.setBounds(37, 97, 184, 15);
    	panel_arr[0].add(label_6);
    	
    	JLabel label_7 = new JLabel("__________________________________________");
    	label_7.setBounds(37, 190, 296, 15);
    	panel_arr[0].add(label_7);
    	
    	JLabel label_8 = new JLabel("_______________________");
    	label_8.setBounds(37, 236, 210, 15);
    	panel_arr[0].add(label_8);
  ///////////////////////////////////////以上是所有关于test的代码/////////////////////////////////////////////////////////    	
  ///////////////////////////////////////以下是所有关于panel_arr[1]的代码///////////////////////////////////////////////////////// 
    	panel_arr[1] = new JPanel();
		panel_arr[1].setBounds(55, 68, 336, 116);
		panel.add(panel_arr[0]);
		panel_arr[1].setLayout(null);
		panel_arr[1].setVisible(false);
		panel_arr[1].setOpaque(false);//设置panel透明
		panel.add(panel_arr[1]);
		
		
		
		
		//////////////////////////////////学生学号输入  开始
		JLabel sure_name = new JLabel("姓名");
		sure_name.setBounds(37, 80, 254, 27);
		panel_arr[1].add(sure_name);
		//////////////////////////////////学生学号输入  结束 	
		JLabel label = new JLabel("____________________________________");
		label.setBounds(37, 40, 254, 15);
		panel_arr[1].add(label);
		
		find_id = new JTextField();
		find_id.setBounds(37, 20, 254, 27);
		panel_arr[1].add(find_id);
		find_id.setBorder(null);//设置无边框
		find_id.setOpaque(false);//设置透明
		find_id.setFont(new Font("黑体", Font.PLAIN, 16));
		find_id.setText("请输入删除学生学号");//请输入学生学号
		find_id.addFocusListener(new MyFocusListener(info[4], find_id));
		find_id.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER && sure_name.getText() == "姓名") {
					GetConn ge = new GetConn();
					Connection t = ge.getConnectin();
					try {
						Statement state = t.createStatement();
						ResultSet res = state.executeQuery("select * from Student_info");
						
						while(res.next()){
							String id = res.getString("stud_id");
							String name = res.getString("stud_name");
							//System.out.println(id+"   "+name+"   ");
							if (id.equals(find_id.getText())) {
								sure_name.setText(name);
								JOptionPane.showMessageDialog(null, "请核对姓名后再次回车确认,若要取消，请回删");
								break;
							}
						}
						
						if(sure_name.getText().equals("姓名")) {
							JOptionPane.showMessageDialog(null, "查不到此学生");
						}
					}catch(SQLException ee) {
						ee.printStackTrace();
					}
				}else if(e.getKeyCode() == KeyEvent.VK_ENTER && sure_name.getText() != "姓名"){
					GetConn ge = new GetConn();
					Connection t = ge.getConnectin();
					int m=0;
					try {

						sql=t.prepareStatement("delete from Student_info where stud_id=?");
						sql.setString(1,find_id.getText());
					    m =sql.executeUpdate();
					}catch(SQLException ee) {
						ee.printStackTrace();
					}
					if (m != 0) {
						JOptionPane.showMessageDialog(null, "已经删除完毕");
					}else {
						JOptionPane.showMessageDialog(null, "删除失败，请确认后再重试");
					}
					
					sure_name.setText("姓名");
					find_id.setText("请输入删除学生学号");
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					sure_name.setText("姓名");
				}
			}
		});
		find_id.setColumns(10);
		
		
		///////////////////////////绘制线条
  ///////////////////////////////////////以上是所有关于panel_arr[1]的代码/////////////////////////////////////////////////////////
 
  ///////////////////////////////////////////以下是所有关于panel_arr[3]的代码//////////////////////用于录入学生成绩/////////////////////////////

		
		panel_arr[3] = new JPanel();
		panel_arr[3].setBounds(28, 51, 409, 296);
		panel.add(panel_arr[3]);
		panel_arr[3].setLayout(null);
		panel_arr[3].setVisible(false);
		panel_arr[3].setOpaque(false);//设置panel透明
		
		textField = new JTextField();
		textField.setText(info[6]);
		textField.setToolTipText("请输入语文成绩");
		textField.setFont(new Font("黑体", Font.PLAIN, 16));
		textField.setBorder(null);//设置无边框
		textField.setOpaque(false);//设置透明
		textField.addFocusListener(new MyFocusListener(info[6], textField));
		textField.addKeyListener(new add_student_grade());
		textField.setBounds(29, 36, 150, 29);
		panel_arr[3].add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(info[7]);
		textField_1.setToolTipText("请输入数学成绩");
		textField_1.setFont(new Font("黑体", Font.PLAIN, 16));
		textField_1.setBorder(null);//设置无边框
		textField_1.setOpaque(false);//设置透明
		textField_1.addFocusListener(new MyFocusListener(info[7], textField_1));
		textField_1.addKeyListener(new add_student_grade());
		textField_1.setColumns(10);
		textField_1.setBounds(29, 93, 150, 29);
		panel_arr[3].add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText(info[8]);
		textField_2.setToolTipText("请输入英语成绩");
		textField_2.setFont(new Font("黑体", Font.PLAIN, 16));
		textField_2.setBorder(null);//设置无边框
		textField_2.setOpaque(false);//设置透明
		textField_2.addFocusListener(new MyFocusListener(info[8], textField_2));
		textField_2.addKeyListener(new add_student_grade());
		textField_2.setColumns(10);
		textField_2.setBounds(29, 150, 150, 29);
		panel_arr[3].add(textField_2);
		
		JLabel label_2 = new JLabel("_____________________");
		label_2.setBounds(29, 60, 150, 15);
		panel_arr[3].add(label_2);
		
		JLabel label_3 = new JLabel("_____________________");
		label_3.setBounds(29, 117, 150, 15);
		panel_arr[3].add(label_3);
		
		JLabel label_4 = new JLabel("_____________________");
		label_4.setBounds(29, 174, 150, 15);
		panel_arr[3].add(label_4);
		
		
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("请输入互评成绩");
		textField_5.setText("请输入互评成绩");
		textField_5.setFont(new Font("黑体", Font.PLAIN, 16));
		textField_5.addFocusListener(new MyFocusListener("请输入互评成绩", textField_5));
		textField_5.addKeyListener(new add_student_grade());
		textField_5.setColumns(10);
		textField_5.setOpaque(false);//设置透明
		textField_5.setBorder(null);//设置无边框
		textField_5.setBounds(249, 36, 150, 29);
		panel_arr[3].add(textField_5);
		
		JLabel label_9 = new JLabel("_____________________");
		label_9.setBounds(249, 60, 150, 15);
		panel_arr[3].add(label_9);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("请输入品德成绩");
		textField_6.setText("请输入品德成绩");
		textField_6.setOpaque(false);
		textField_6.setFont(new Font("黑体", Font.PLAIN, 16));
		textField_6.addFocusListener(new MyFocusListener("请输入品德成绩", textField_6));
		textField_6.addKeyListener(new add_student_grade());
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBounds(249, 93, 150, 29);
		panel_arr[3].add(textField_6);
		
		JLabel label_10 = new JLabel("_____________________");
		label_10.setBounds(249, 117, 150, 15);
		panel_arr[3].add(label_10);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("请输入语文教师评测");
		textField_7.setText("请输入语文教师评测");
		textField_7.setOpaque(false);
		textField_7.setFont(new Font("黑体", Font.PLAIN, 16));
		textField_7.addFocusListener(new MyFocusListener("请输入语文教师评测", textField_7));
		textField_7.addKeyListener(new add_student_grade());
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBounds(249, 150, 150, 29);
		panel_arr[3].add(textField_7);
		
		JLabel label_11 = new JLabel("_____________________");
		label_11.setBounds(249, 174, 150, 15);
		panel_arr[3].add(label_11);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("请输入数学教师评测");
		textField_8.setText("请输入数学教师评测");
		textField_8.setOpaque(false);
		textField_8.setFont(new Font("黑体", Font.PLAIN, 16));
		textField_8.addFocusListener(new MyFocusListener("请输入数学教师评测", textField_8));
		textField_8.addKeyListener(new add_student_grade());
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBounds(29, 199, 150, 29);
		panel_arr[3].add(textField_8);
		
		JLabel label_12 = new JLabel("_____________________");
		label_12.setBounds(29, 223, 150, 15);
		panel_arr[3].add(label_12);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("请输入英语教师评测");
		textField_9.setText("请输入英语教师评测");
		textField_9.setOpaque(false);
		textField_9.setFont(new Font("黑体", Font.PLAIN, 16));
		textField_9.addFocusListener(new MyFocusListener("请输入英语教师评测", textField_9));
		textField_9.addKeyListener(new add_student_grade());
		textField_9.setColumns(10);
		textField_9.setBorder(null);
		textField_9.setBounds(249, 199, 150, 29);
		panel_arr[3].add(textField_9);
		
		JLabel label_13 = new JLabel("_____________________");
		label_13.setBounds(249, 223, 150, 15);
		panel_arr[3].add(label_13);	
///////////////////////////////////////////以上是所有关于panel_arr[3]的代码//////////////////////用于录入学生成绩/////////////////////////////
		
		
///////////////////////////////////////////以下是所有关于panel_arr[4]的代码//////////////////////用于录入学生成绩/////////////////////////////		
		panel_arr[4] = new JPanel();
		panel_arr[4].setBounds(60, 49, 390, 248);
		panel.add(panel_arr[4]);
		panel_arr[4].setLayout(null);
		panel_arr[4].setVisible(false);
		panel_arr[4].setOpaque(false);//设置panel透明
		
		JLabel label_14 = new JLabel("小组成员：");
		label_14.setBounds(0, 0, 105, 41);
		panel_arr[4].add(label_14);
		label_14.setFont(new Font("幼圆", Font.BOLD, 20));
		
		JLabel label_15 = new JLabel("后端的蠢货们 → →");
		label_15.setFont(new Font("幼圆", Font.BOLD, 15));
		label_15.setBounds(60, 56, 170, 36);
		panel_arr[4].add(label_15);
		
		JLabel label_16 = new JLabel("陈伊俊");
		label_16.setFont(new Font("幼圆", Font.BOLD, 15));
		label_16.setBounds(240, 45, 78, 36);
		panel_arr[4].add(label_16);
		
		JLabel label_17 = new JLabel("鲁梦婷");
		label_17.setFont(new Font("幼圆", Font.BOLD, 15));
		label_17.setBounds(240, 77, 78, 36);
		panel_arr[4].add(label_17);
		
		JLabel label_18 = new JLabel("前后端通吃的蠢货→→");
		label_18.setFont(new Font("幼圆", Font.BOLD, 15));
		label_18.setBounds(60, 123, 163, 36);
		panel_arr[4].add(label_18);
		
		JLabel label_19 = new JLabel("韩华锋");
		label_19.setFont(new Font("幼圆", Font.BOLD, 15));
		label_19.setBounds(240, 123, 78, 36);
		panel_arr[4].add(label_19);
		
		JLabel lblHcl = new JLabel("©版权归   HCL小组   所有");
		lblHcl.setFont(new Font("华文中宋", Font.BOLD, 12));
		lblHcl.setBounds(95, 203, 175, 15);
		panel_arr[4].add(lblHcl);
		
///////////////////////////////////////////以上是所有关于panel_arr[4]的代码//////////////////////用于录入学生成绩/////////////////////////////
///////////////////////////////////////////以下是所有关于panel_arr[5]的代码//////////////////////用于录入学生成绩/////////////////////////////		
		panel_arr[5] = new JPanel();
		panel_arr[5].setBounds(62, 57, 375, 247);
		panel.add(panel_arr[5]);
		panel_arr[5].setLayout(null);
		panel_arr[5].setOpaque(false);//设置panel_arr[5]透明
		panel_arr[5].setVisible(false);
		
		JLabel label_20 = new JLabel("请提供您宝贵的反馈信息，并按回车键发送");
		label_20.setFont(new Font("幼圆", Font.BOLD, 16));
		label_20.setBounds(10, 10, 355, 32);
		panel_arr[5].add(label_20);
		
		JTextArea textArea = new JTextArea();////////////////////////////用于输入反馈信息
		textArea.setBounds(10, 52, 355, 185);
		textArea.setLineWrap(true);// 如果内容过长。自动换行
		textArea.setBackground(new Color(209,237,255));/////////////////////////////////////////////////////////////////////////////////////////////颜色需重构
		textArea.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					int n = JOptionPane.showConfirmDialog(null, "请问您是否确认发送", "警告", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION && textArea.getText().equals("") == false ) {
						JOptionPane.showMessageDialog(null, "登录成功");
						//JOptionPane.showConfirmDialog(null, "发送成功", "提示", n);
						textArea.setText("");
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		panel_arr[5].add(textArea);
///////////////////////////////////////////以上是所有关于panel_arr[5]的代码//////////////////////用于录入学生成绩/////////////////////////////		
///////////////////////////////////////////以下是所有关于panel_arr[6]的代码//////////////////////用于查询学生成绩/////////////////////////////		
		panel_arr[6] = new JPanel();
		panel_arr[6].setBounds(10, 67, 477, 310);
		panel.add(panel_arr[6]);
		panel_arr[6].setLayout(null);
		panel_arr[6].setVisible(false);
		
		textField_10 = new JTextField();
		textField_10.setToolTipText("若要查询全部，请直接回车");
		textField_10.setText("请输入要查询的学号");
		textField_10.setBounds(153, 10, 163, 29);
		textField_10.setFont(new Font("黑体", Font.PLAIN, 16));
		textField_10.addFocusListener(new MyFocusListener("请输入要查询的学号", textField_10));
		textField_10.setBorder(null);//设置无边框
		textField_10.setOpaque(false);//设置透明
		panel_arr[6].setOpaque(false);//设置透明
		panel_arr[6].add(textField_10);
		textField_10.setColumns(10);
		textField_10.addKeyListener(new find_student_info());
///////////////////////////////////////////////////////////////////////////////////////////////////////需要添加一个响应事件
		JLabel lblNewLabel = new JLabel("_______________________");
		lblNewLabel.setBounds(153, 39, 163, 15);
		panel_arr[6].add(lblNewLabel);
		
		String[] columnNames_3 = {"学号","姓名","性别","家庭住址","联系方式"};
		//Object[][] cellData_1 = {{"","","","","","","","",""}};
		Object[][] cellData_1 = {};
		
		defaultModel = new DefaultTableModel(cellData_1, columnNames_3);
		table_1 = new JTable(defaultModel);

		//table_1 = new JTable(cellData_1, columnNames_3);
		//table_1 = new JTable(null, columnNames_3);
		table_1.setBounds(51, 65, 340, 44);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 设置表格调整尺寸模式
		table_1.getColumnModel().getColumn(3).setPreferredWidth(210);///////////////////////设置某一列的长度
		table_1.getColumnModel().getColumn(4).setPreferredWidth(100);///////////////////////设置某一列的长度
		table_1.setCellSelectionEnabled(false);// 设置单元格选择方式
		table_1.setShowVerticalLines(true);//  // 设置是否显示单元格间的分割线
		table_1.setShowHorizontalLines(true);
		
		
		JScrollPane scrollPane_3 = new JScrollPane(table_1);
		scrollPane_3.setBounds(10, 68, 457, 232);
		panel_arr[6].add(scrollPane_3);
		
		
///////////////////////////////////////////以上是所有关于panel_arr[6]的代码//////////////////////用于录入学生成绩/////////////////////////////	
		
///////////////////////////////////////////以下是所有关于panel_arr[2]的代码//////////////////////用于查询学生成绩/////////////////////////////
		panel_arr[2] = new JPanel();
		panel_arr[2].setBounds(10, 63, 477, 275);
		panel.add(panel_arr[2]);  ////往panel中添加panel_arr[2]
		
		panel_arr[2].setLayout(null);
		panel_arr[2].setOpaque(false);//设置panel透明
		panel_arr[2].setVisible(false);
		
		msg_find = new JTextField();
		msg_find.setText("请输入学号");
		msg_find.setBounds(120, 10, 243, 26);
		msg_find.setFont(new Font("黑体", Font.PLAIN, 16));
		msg_find.setBorder(null);//设置无边框
		msg_find.setOpaque(false);//设置透明
		msg_find.addFocusListener(new MyFocusListener(info[5], msg_find));
		panel_arr[2].add(msg_find);
		msg_find.addKeyListener(new find_student_grade());//////////////////////////////////////////////////////查询学生信息
		msg_find.setColumns(10);
		
		JLabel label_1 = new JLabel("__________________________________");
		label_1.setBounds(120, 26, 243, 15);
		label_1.setOpaque(false);//设置label_1透明
		panel_arr[2].add(label_1);
		//dsad;
		Object[][] cellData = {};
		String[] columnNames = {"学号","姓名","语文", "数学","英语","成绩排名"};
		String[] columnNames_1 = {"学号","姓名","语文教评", "数学教评","英语教评","互评成绩","品德成绩"};
		String[] columnNames_2 = {"学号","姓名","综合测评","综合排名"};
		
		
		defaultModel_1 = new DefaultTableModel(cellData, columnNames);
		table = new JTable(defaultModel_1);
		table.setBounds(51, 65, 340, 44);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 设置表格调整尺寸模式
		table.setCellSelectionEnabled(false);// 设置单元格选择方式
		table.setShowVerticalLines(true);//  // 设置是否显示单元格间的分割线
		table.setShowHorizontalLines(true);
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(47, 63, 377, 63);
		scrollPane.setOpaque(false);//设置透明
		panel_arr[2].add(scrollPane);
		
		defaultModel_2 = new DefaultTableModel(cellData, columnNames_1);
		table_6 = new JTable(defaultModel_2);
		table_6.setBounds(51, 65, 340, 44);
		table_6.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 设置表格调整尺寸模式
		table_6.setCellSelectionEnabled(false);// 设置单元格选择方式
		table_6.setShowVerticalLines(true);//  // 设置是否显示单元格间的分割线
		table_6.setShowHorizontalLines(true);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_6);
		scrollPane_1.setOpaque(false);
		scrollPane_1.setBounds(47, 128, 377, 63);
		panel_arr[2].add(scrollPane_1);
		
		defaultModel_3 = new DefaultTableModel(cellData, columnNames_2);
		table_7 = new JTable(defaultModel_3);
		table_7.setBounds(51, 65, 340, 44);
		table_7.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 设置表格调整尺寸模式
		table_7.setCellSelectionEnabled(false);// 设置单元格选择方式
		table_7.setShowVerticalLines(true);//  // 设置是否显示单元格间的分割线
		table_7.setShowHorizontalLines(true);
		table_7.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_7.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_7.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_7.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		JScrollPane scrollPane_2 = new JScrollPane(table_7);
		scrollPane_2.setOpaque(false);
		scrollPane_2.setBounds(47, 193, 377, 63);
		panel_arr[2].add(scrollPane_2);
		

		
		
///////////////////////////////////////////以上是所有关于panel_arr[2]的代码////////////////////////////////////////////////////////////
    	JMenu menu = new JMenu("信息处理");
    	menu.setForeground(SystemColor.controlDkShadow);
		menu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu);
		
	/////////////////////////////////////////////////////menu添加item      开始//////
		//Bar添加学生信息   开始
		JMenuItem add_stu_msg = new JMenuItem("增加学生信息");
		add_stu_msg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setPanel_False();
				panel_arr[0].setVisible(true);
				frame.setSize(frame.getWidth(), 387);
				
				Main_Frame.stu_id.setText("请输入学号");
				Main_Frame.stu_id.requestFocus();
				Main_Frame.stu_name.setText("请输入姓名");
				Main_Frame.address.setText("请输入家庭住址");
				Main_Frame.stu_tel.setText("请输入联系方式");
				Main_Frame.stu_id.addFocusListener(new MyFocusListener("请输入学号",Main_Frame.stu_id));
				Main_Frame.stu_name.addFocusListener(new MyFocusListener("请输入姓名",Main_Frame.stu_id));
				Main_Frame.address.addFocusListener(new MyFocusListener("请输入家庭住址",Main_Frame.stu_id));
				Main_Frame.stu_tel.addFocusListener(new MyFocusListener("请输入联系方式",Main_Frame.stu_id));
			}
		});
		menu.add(add_stu_msg); 
		
		//Bar添加学生信息   结束
		
		//Bar删除学生信息   开始
		JMenuItem delete_stu_msg = new JMenuItem("删除学生信息");
		delete_stu_msg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				find_id.setText("请输入删除学生学号");
				setPanel_False();
				panel_arr[1].setVisible(true);
				frame.setSize(frame.getWidth(), 220);
				
				
			}
		});
		menu.add(delete_stu_msg);
		//Bar删除学生信息   结束
		
		//Bar查询学生信息   开始
		JMenuItem lookup_stu_msg = new JMenuItem("浏览学生信息");
		lookup_stu_msg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setPanel_False();
				panel_arr[6].setVisible(true);
				frame.setSize(frame.getWidth(), 390);
				
				
				int rowcount = Main_Frame.defaultModel.getRowCount() - 1;
				while(rowcount>=0) {
					// getRowCount返回行数，rowcount<0代表已经没有行了
					if (rowcount >= 0) {
			        	Main_Frame.defaultModel.removeRow(rowcount);
			        	Main_Frame.defaultModel.setRowCount(rowcount);
			            /**
			             * 删除行比较简单，只要用DefaultTableModel的removeRow方法即可
			             * 删除行完毕后必须重新设置列数，也就是使用DefaultTableModel的setRowCount()方法来设置当前行
			             **/
			        }
			        rowcount--;
				}
			}
		});
		menu.add(lookup_stu_msg);
		
		JMenu mnNewMenu = new JMenu("            ");
		mnNewMenu.setEnabled(false);
		menuBar.add(mnNewMenu);
		//Bar查询学生信息   结束
    	
	/////////////////////////////////////////////////////menu添加item      结束//////
		
	/////////////////////////////////////////////////////menu_1添加item      开始//////
		JMenu menu_1 = new JMenu("数据处理");
		menu_1.setForeground(SystemColor.controlDkShadow);
		menu_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu_1);
		
		JMenuItem add_nor_grade = new JMenuItem("成绩录入");
		add_nor_grade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//panel_arr[3]
				setPanel_False();
				panel_arr[3].setVisible(true);
				frame.setSize(frame.getWidth(), 350);
				
				Main_Frame.textField.setText("请输入语文成绩");
				Main_Frame.textField_1.setText("请输入数学成绩");
				Main_Frame.textField_2.setText("请输入英语成绩");
				Main_Frame.textField_7.setText("请输入语文教师评测");
				Main_Frame.textField_8.setText("请输入数学教师评测");
				Main_Frame.textField_9.setText("请输入英语教师评测");
				Main_Frame.textField_5.setText("请输入互评成绩");
				Main_Frame.textField_6.setText("请输入品德成绩");
				Main_Frame.textField.requestFocus();//////设置文本框焦点
			}
		});
		menu_1.add(add_nor_grade);
		
		JMenuItem lookup_grade = new JMenuItem("数据查询");
		lookup_grade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setPanel_False();
				panel_arr[2].setVisible(true);
				frame.setSize(frame.getWidth(), 350);
				
				msg_find.setText("请输入学号");
				
				int rowcount = Main_Frame.defaultModel_1.getRowCount() - 1;
				while(rowcount>=0) {
					// getRowCount返回行数，rowcount<0代表已经没有行了
					if (rowcount >= 0) {
			        	Main_Frame.defaultModel_1.removeRow(rowcount);
			        	Main_Frame.defaultModel_1.setRowCount(rowcount);
			        }
			        rowcount--;
				}
				rowcount = Main_Frame.defaultModel_2.getRowCount() - 1;
				while(rowcount>=0) {
					// getRowCount返回行数，rowcount<0代表已经没有行了
					if (rowcount >= 0) {
			        	Main_Frame.defaultModel_2.removeRow(rowcount);
			        	Main_Frame.defaultModel_2.setRowCount(rowcount);
			        }
			        rowcount--;
				}
				rowcount = Main_Frame.defaultModel_3.getRowCount() - 1;
				while(rowcount>=0) {
					// getRowCount返回行数，rowcount<0代表已经没有行了
					if (rowcount >= 0) {
			        	Main_Frame.defaultModel_3.removeRow(rowcount);
			        	Main_Frame.defaultModel_3.setRowCount(rowcount);
			        }
			        rowcount--;
				}
				//初始化数据表
				
			}
		});
		menu_1.add(lookup_grade);
		
		JMenu mnNewMenu_1 = new JMenu("            ");
		mnNewMenu_1.setEnabled(false);
		menuBar.add(mnNewMenu_1);
	/////////////////////////////////////////////////////menu_1添加item      结束//////
		
		
	/////////////////////////////////////////////////////help添加item      开始//////
		JMenu help = new JMenu("关于我们");
		help.setForeground(SystemColor.controlDkShadow);
		help.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(help);
		
		JMenuItem mntmhelp = new JMenuItem("帮助（help）");//帮助（help）
		mntmhelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setPanel_False();
				panel_arr[5].setVisible(true);
				frame.setSize(frame.getWidth(), 350);
			}
		});
		help.add(mntmhelp);
		
		JMenuItem information = new JMenuItem("版权信息");//版权信息
		information.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setPanel_False();
				panel_arr[4].setVisible(true);
				frame.setSize(frame.getWidth(), 280);
			}
		});
		help.add(information);
	/////////////////////////////////////////////////////help添加item      结束//////
		
		

	}
	public static void setPanel_False() {
		for(int i = 0;i < panel_arr.length;i++) {
			panel_arr[i].setVisible(false);
		}
	}
}
class insert_stu_msg implements KeyListener{//////////////////////////////用于学生信息的更新和插入
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			String id = Main_Frame.stu_id.getText();
			String name = Main_Frame.stu_name.getText();
			String stu_address = Main_Frame.address.getText();
			String tel = Main_Frame.stu_tel.getText();
			String sex;
			String old_name = null;
			String old_stu_address = null;
			String old_sex = null;
			String old_tel = null;
			if(Main_Frame.true_gender.isSelected()) {
				sex = "男";
			}else {
				sex = "女";
			}
			if(id.equals("") || id.equals("请输入学号") ) {
				JOptionPane.showMessageDialog(null, "您的学号未输入");
				Main_Frame.stu_id.requestFocus();//////设置文本框焦点
			}else if(name.equals("") || name.equals("请输入姓名")) {
				JOptionPane.showMessageDialog(null, "您的姓名未输入");
				Main_Frame.stu_name.requestFocus();//////设置文本框焦点
			}else if(stu_address.equals("") || stu_address.equals("请输入家庭住址")) {
				JOptionPane.showMessageDialog(null, "您的家庭住址未输入");
				Main_Frame.address.requestFocus();//////设置文本框焦点
			}else if(tel.equals("")|| tel.equals("请输入联系方式")){
				JOptionPane.showMessageDialog(null, "您的联系方式未输入");
				Main_Frame.stu_tel.requestFocus();//////设置文本框焦点
			}else if(tel.length() != 11) {
				JOptionPane.showMessageDialog(null, "您的联系方式长度不正确");
				Main_Frame.stu_tel.requestFocus();//////设置文本框焦点
			}else {
				Boolean flag = false;
				GetConn ge = new GetConn();
				Connection t = ge.getConnectin();
				PreparedStatement sql;/////////要添加
				
				Statement state = null;
				ResultSet res = null;
				try {
					state = t.createStatement();
					res = state.executeQuery("select * from Student_info");
					while(res.next()){
						String stu_id = res.getString("stud_id");
						String stu_name = res.getString("stud_name");
						String sql_sex = res.getString("sex");
						String address = res.getString("home_address");
						String telphone = res.getString("phone");
						//System.out.println(id+"   "+name+"   ");
						if (id.equals(stu_id)) { 
							flag = true;//表示存在相同id，数据存在
							old_name = stu_name;
							old_sex=sql_sex;
							old_stu_address=address;
							old_tel=telphone;
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				int msg;
				if(flag) {//如果存在相同数据，采用更新数据的方法：
		////////////////////////////////////////////////////////////////////////////////////////////////////未写完
					int n = JOptionPane.showConfirmDialog(null, "当前学号已经存在\n学生姓名为："+old_name+"\n性别："+old_sex+"\n地址："+old_stu_address+"\n联系方式："+old_tel+"\n请问是否要更新？", "Warming", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {  //////////////需要更新数据
						try {
							int m;
							
							sql = t.prepareStatement("update Student_info set stud_name=? where stud_id=?");
							sql.setString(1, name);
							sql.setString(2, id);
							m = sql.executeUpdate();///////////////更新名字
							sql = t.prepareStatement("exec rewrite_1 ?,?,?,?");
							sql.setString(1, id);
							sql.setString(2, sex);
							sql.setString(3, stu_address);
							sql.setString(4, tel); 
							if(m == 1) {
								JOptionPane.showMessageDialog(null, "信息录入成功");
								msg = JOptionPane.showConfirmDialog(null, "是否清空当前内容", "An", JOptionPane.YES_NO_OPTION);
								if(msg == JOptionPane.YES_OPTION) {
									rollback();
								}else {
										
								}
							}else {
								JOptionPane.showMessageDialog(null, "信息录入失败");
							}
							t.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							} else if (n == JOptionPane.NO_OPTION) {
								msg = JOptionPane.showConfirmDialog(null, "是否清空当前内容", "An", JOptionPane.YES_NO_OPTION);
								if(msg == JOptionPane.YES_OPTION) {
									rollback();
								}else {
								}
							}
					}else {//如果不存在相同数据，采用插入数据的方法：
						try {
							int m;
							sql = t.prepareStatement("insert into Student_info Values(?,?,?,?,?)");
							sql.setString(1, id);
							sql.setString(2, name);
							sql.setString(3, sex);
							sql.setString(4, stu_address);
							sql.setString(5, tel);
							m = sql.executeUpdate();
							if(m == 1) {
								JOptionPane.showMessageDialog(null, "信息录入成功");
								msg = JOptionPane.showConfirmDialog(null, "是否清空当前内容", "An", JOptionPane.YES_NO_OPTION);
								if(msg == JOptionPane.YES_OPTION) {
									rollback();
								}else {
									
								}
							}else {
								JOptionPane.showMessageDialog(null, "信息录入失败");
								msg = JOptionPane.showConfirmDialog(null, "是否清空当前内容", "An", JOptionPane.YES_NO_OPTION);
								if(msg == JOptionPane.YES_OPTION) {
									rollback();
								}else {
									
								}
							}
							t.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}	
				}
			}
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public  void rollback(){
		Main_Frame.stu_id.setText("请输入学号");
		Main_Frame.stu_id.requestFocus();
		Main_Frame.stu_name.setText("请输入姓名");
		Main_Frame.address.setText("请输入家庭住址");
		Main_Frame.stu_tel.setText("请输入联系方式");
		Main_Frame.stu_id.addFocusListener(new MyFocusListener("请输入学号",Main_Frame.stu_id));
		Main_Frame.stu_name.addFocusListener(new MyFocusListener("请输入姓名",Main_Frame.stu_id));
		Main_Frame.address.addFocusListener(new MyFocusListener("请输入家庭住址",Main_Frame.stu_id));
		Main_Frame.stu_tel.addFocusListener(new MyFocusListener("请输入联系方式",Main_Frame.stu_id));
	}
}

class find_student_info implements KeyListener{

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		int rowcount = Main_Frame.defaultModel.getRowCount() - 1;
		while(rowcount>=0) {
			// getRowCount返回行数，rowcount<0代表已经没有行了
			if (rowcount >= 0) {
	        	Main_Frame.defaultModel.removeRow(rowcount);
	        	Main_Frame.defaultModel.setRowCount(rowcount);
	        }
	        rowcount--;
		}
        
		
		
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER && Main_Frame.textField_10.getText().equals("")) {
			//写全部信息
			GetConn ge = new GetConn();
			Connection t = ge.getConnectin();
			Statement state = null;
			ResultSet res = null;
			try {
				state = t.createStatement();
				res = state.executeQuery("select * from Student_info");
				int i=0;
				while(res.next()){
					String stu_id = res.getString("stud_id");
					String stu_name = res.getString("stud_name");
					String sex = res.getString("sex");
					String home_address = res.getString("home_address");
					String tel = res.getString("phone");
					Main_Frame.defaultModel.addRow(new Vector<Object>());//增加一行新的数据行
					Main_Frame.table_1.setValueAt (stu_id, i, 0);//设置某个单元格的值,这个值是一个对象
					Main_Frame.table_1.setValueAt (stu_name, i, 1);//设置某个单元格的值,这个值是一个对象
					Main_Frame.table_1.setValueAt (sex, i, 2);//设置某个单元格的值,这个值是一个对象
					Main_Frame.table_1.setValueAt (home_address, i, 3);//设置某个单元格的值,这个值是一个对象
					Main_Frame.table_1.setValueAt (tel, i, 4);//设置某个单元格的值,这个值是一个对象
					i++;
					//System.out.println(id+"   "+name+"   ");
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}else if(arg0.getKeyCode() == KeyEvent.VK_ENTER && Main_Frame.textField_10.getText().equals("")==false){
			//写一个人的信息
			GetConn ge = new GetConn();
			Connection t = ge.getConnectin();
			Statement state = null;
			ResultSet res = null;
			try {
				state = t.createStatement();
				res = state.executeQuery("select * from Student_info");
				while(res.next()){
					String stu_id = res.getString("stud_id");
					String stu_name = res.getString("stud_name");
					String sex = res.getString("sex");
					String home_address = res.getString("home_address");
					String tel = res.getString("phone");
					if(stu_id.equals(Main_Frame.textField_10.getText())) {
						Main_Frame.defaultModel.addRow(new Vector<Object>());//增加一行新的数据行
						Main_Frame.table_1.setValueAt (stu_id, 0, 0);//设置某个单元格的值,这个值是一个对象
						Main_Frame.table_1.setValueAt (stu_name, 0, 1);//设置某个单元格的值,这个值是一个对象
						Main_Frame.table_1.setValueAt (sex, 0, 2);//设置某个单元格的值,这个值是一个对象
						Main_Frame.table_1.setValueAt (home_address, 0, 3);//设置某个单元格的值,这个值是一个对象
						Main_Frame.table_1.setValueAt (tel, 0, 4);//设置某个单元格的值,这个值是一个对象
						break;
					}
					
					//System.out.println(id+"   "+name+"   ");
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
class find_student_grade implements KeyListener{
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			int rowcount = Main_Frame.defaultModel_1.getRowCount() - 1;
			while(rowcount>=0) {
				// getRowCount返回行数，rowcount<0代表已经没有行了
				if (rowcount >= 0) {
		        	Main_Frame.defaultModel_1.removeRow(rowcount);
		        	Main_Frame.defaultModel_1.setRowCount(rowcount);
		        }
		        rowcount--;
			}
			rowcount = Main_Frame.defaultModel_2.getRowCount() - 1;
			while(rowcount>=0) {
				// getRowCount返回行数，rowcount<0代表已经没有行了
				if (rowcount >= 0) {
		        	Main_Frame.defaultModel_2.removeRow(rowcount);
		        	Main_Frame.defaultModel_2.setRowCount(rowcount);
		        }
		        rowcount--;
			}
			rowcount = Main_Frame.defaultModel_3.getRowCount() - 1;
			while(rowcount>=0) {
				// getRowCount返回行数，rowcount<0代表已经没有行了
				if (rowcount >= 0) {
		        	Main_Frame.defaultModel_3.removeRow(rowcount);
		        	Main_Frame.defaultModel_3.setRowCount(rowcount);
		        }
		        rowcount--;
			}
			//初始化数据表
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && Main_Frame.msg_find.getText().equals("") == false) {
			
			String find_rules = Main_Frame.msg_find.getText();
			String[] split =find_rules.split("");
			
			int rules =0;////用来判断是用学号还是姓名     0学号，1姓名
			int len = find_rules.length();
			
			for(int i = 0;i<len;i++) {
				if(split[i].equals("0") || split[i].equals("1") || split[i].equals("2") || split[i].equals("3") || split[i].equals("4")
						|| split[i].equals("5") || split[i].equals("6") || split[i].equals("7") || split[i].equals("8") || split[i].equals("9")) {
				}else {
					rules =1;//存在汉字或拼音，采用名字查询
					break;
				}
			}
			//System.out.println(find_rules);
			//System.out.println(rules);
			if(rules == 0) {
				//采用学号查询
				GetConn ge = new GetConn();
				Connection t = ge.getConnectin();
				Statement state = null;
				ResultSet res = null;
				try {
					state = t.createStatement();
					res = state.executeQuery("select * from Student_grade");
					int i=0;
					while(res.next()){
						String stu_id = res.getString("stud_id");
						//System.out.println(stu_id);
						if(find_rules.equals(stu_id)) {
							String stu_name = res.getString("stud_name");
							String Chinese_grade = res.getString("Chinese_grade");
							String Math_grade = res.getString("Math_grade");
							String English_grade = res.getString("English_grade");
							String ranking = res.getString("ranking");
							Main_Frame.defaultModel_1.addRow(new Vector<Object>());//增加一行新的数据行
							Main_Frame.table.setValueAt (stu_id, i, 0);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table.setValueAt (stu_name, i, 1);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table.setValueAt (Chinese_grade, i, 2);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table.setValueAt (Math_grade, i, 3);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table.setValueAt (English_grade, i, 4);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table.setValueAt (ranking, i, 5);//设置某个单元格的值,这个值是一个对象
							i++;
						}
					}
					//String[] columnNames_1 = {"学号","姓名","语文教评", "数学教评","英语教评","互评成绩","品德成绩"};
					state = t.createStatement();
					res = state.executeQuery("select * from Avggrade");
					i=0;
					while(res.next()){
						String stu_id = res.getString("stud_id");
						//System.out.println(stu_id);
						if(find_rules.equals(stu_id)) {
							String stu_name = res.getString("stud_name");
							String Chinese_grade = res.getString("Chinese_teacher_grade");
							String Math_grade = res.getString("Math_teacher_grade");
							String English_grade = res.getString("English_teacher_grade");
							String classmate_score = res.getString("classmate_score");
							String character_grade = res.getString("Character_grade");
							
							Main_Frame.defaultModel_2.addRow(new Vector<Object>());//增加一行新的数据行
							Main_Frame.table_6.setValueAt (stu_id, i, 0);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table_6.setValueAt (stu_name, i, 1);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table_6.setValueAt (Chinese_grade, i, 2);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table_6.setValueAt (Math_grade, i, 3);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table_6.setValueAt (English_grade, i, 4);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table_6.setValueAt (classmate_score, i, 5);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table_6.setValueAt (character_grade, i, 6);//设置某个单元格的值,这个值是一个对象
							i++;
						}
					}
					
					//String[] columnNames_2 = {"学号","姓名","综合测评","综合排名"};
					state = t.createStatement();
					res = state.executeQuery("select * from Comprehensive_evaluation");
					i=0;
					while(res.next()){
						String stu_id = res.getString("stud_id");
						//System.out.println(stu_id);
						if(find_rules.equals(stu_id)) {
							String stu_name = res.getString("stud_name");
							String Chinese_grade = res.getString("Total_score");
							String Math_grade = res.getString("Total_ranking");
							
							Main_Frame.defaultModel_3.addRow(new Vector<Object>());//增加一行新的数据行
							Main_Frame.table_7.setValueAt (stu_id, i, 0);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table_7.setValueAt (stu_name, i, 1);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table_7.setValueAt (Chinese_grade, i, 2);//设置某个单元格的值,这个值是一个对象
							Main_Frame.table_7.setValueAt (Math_grade, i, 3);//设置某个单元格的值,这个值是一个对象
							i++;
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}else {
				//采用姓名查询
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


class add_student_grade implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String chinese_grade = Main_Frame.textField.getText();
		String math_grade = Main_Frame.textField_1.getText();
		String english_grade = Main_Frame.textField_2.getText();
		String chinese_teacher_grade = Main_Frame.textField_7.getText();
		String math_teacher_grade = Main_Frame.textField_8.getText();
		String english_teacher_grade = Main_Frame.textField_9.getText();
		String classmate_grade = Main_Frame.textField_5.getText();
		String pinde_grade = Main_Frame.textField_6.getText();
				
		//互评 品德请输入互评成绩
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(chinese_grade.equals("请输入语文成绩") || chinese_grade.equals("")) {
				JOptionPane.showMessageDialog(null, "您的语文成绩未输入");
				Main_Frame.textField.requestFocus();//////设置文本框焦点
			}else if(math_grade.equals("请输入数学成绩") || math_grade.equals("")){
				JOptionPane.showMessageDialog(null, "您的数学成绩未输入");
				Main_Frame.textField_1.requestFocus();//////设置文本框焦点
			}else if(english_grade.equals("请输入英语成绩") || english_grade.equals("")) {
				JOptionPane.showMessageDialog(null, "您的英语成绩未输入");
				Main_Frame.textField_2.requestFocus();//////设置文本框焦点
			}else if(chinese_teacher_grade.equals("请输入语文教师评测") || chinese_teacher_grade.equals("")) {
				JOptionPane.showMessageDialog(null, "您的语文教师评测未输入");
				Main_Frame.textField_7.requestFocus();//////设置文本框焦点
			}else if(math_teacher_grade.equals("请输入数学教师评测") || math_teacher_grade.equals("")) {
				JOptionPane.showMessageDialog(null, "您的数学教师评测未输入");
				Main_Frame.textField_8.requestFocus();//////设置文本框焦点
			}else if(english_teacher_grade.equals("请输入英语教师评测") || english_teacher_grade.equals("")) {
				JOptionPane.showMessageDialog(null, "您的英语教师评测未输入");
				Main_Frame.textField_9.requestFocus();//////设置文本框焦点
			}else if(classmate_grade.equals("请输入互评成绩") || classmate_grade.equals("")){
				JOptionPane.showMessageDialog(null, "您的互评成绩未输入");
				Main_Frame.textField_5.requestFocus();//////设置文本框焦点
			}else if(pinde_grade.equals("请输入品德成绩") || pinde_grade.equals("")){
				JOptionPane.showMessageDialog(null, "您的品德成绩未输入");
				Main_Frame.textField_6.requestFocus();//////设置文本框焦点
			}else {
				//执行输入操作
				//insert into Avggrade
				//values('50','华电话费','62','85','67','76','50','80')
				
				String id = JOptionPane.showInputDialog(null, "请输入学生ID", "");
				if (id != null) {
					double main_ave=(Integer.parseInt(chinese_grade)+Integer.parseInt(math_grade)+Integer.parseInt(english_grade))/3;
					
					double all_ave=main_ave*0.6+
							Integer.parseInt(classmate_grade)*0.1+
							Integer.parseInt(pinde_grade)*0.1+
							(Integer.parseInt(chinese_teacher_grade)+Integer.parseInt(math_teacher_grade)+Integer.parseInt(english_teacher_grade))/3*0.2;
					int test;
					test = ((int)((all_ave-(int)all_ave)*10))/10 + (int)all_ave;
					GetConn ge = new GetConn();
					Connection t = ge.getConnectin();
					Statement state = null;
					ResultSet res = null;
					String id_name = null;
					Boolean index = false;////////////用来输出书否能通过id找到姓名
					try {
						state = t.createStatement();
						res = state.executeQuery("select * from Student_info");
						while(res.next()){
							String stu_id = res.getString("stud_id");
							String stu_name = res.getString("stud_name");
							if(id.equals(stu_id)) {
								id_name = stu_name;
								index = true;
								break;
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "信息查询失败，错误代码：001");
					}
					if(index) {//说明在   Student_info  存在id
						try {
							PreparedStatement sql;
							sql = t.prepareStatement("delete from Avggrade where stud_id=?");
							sql.setString(1, id);
							int m = sql.executeUpdate();
							sql = t.prepareStatement("insert into Avggrade values(?,?,?,?,?,?,?,?)");
							sql.setString(1, id);
							sql.setString(2, id_name);
							String avrg_grade = Integer.toString((int)((Integer.parseInt(chinese_grade)+Integer.parseInt(math_grade)+Integer.parseInt(english_grade))/3));
							sql.setString(3, avrg_grade);
							sql.setString(4, classmate_grade);
							sql.setString(5, pinde_grade);
							sql.setString(6, chinese_teacher_grade);
							sql.setString(7, math_teacher_grade);
							sql.setString(8, english_teacher_grade);
							m = sql.executeUpdate();
							
							sql = t.prepareStatement("delete from Student_grade where stud_id=?");
							sql.setString(1, id);
							m = sql.executeUpdate();
							
							sql = t.prepareStatement("exec stu_grade ?,?,?,?,?,?");
							sql.setString(1, id);
							sql.setString(2, id_name);
							sql.setString(3, chinese_grade);
							sql.setString(4, math_grade);
							sql.setString(5, english_grade);
							sql.setInt(6, 1);
							m = sql.executeUpdate();
							
							sql = t.prepareStatement("delete from Comprehensive_evaluation where stud_id=?");
							sql.setString(1, id);
							m = sql.executeUpdate();
							
							sql = t.prepareStatement("insert into Comprehensive_evaluation values (?,?,?,?)");
							sql.setString(1, id);
							sql.setString(2, id_name);
							sql.setString(3, String.valueOf(test));
							sql.setInt(4, 1);
							m = sql.executeUpdate();
							
							
							//以下为排名：：：：
							String[] rank_id;
							int k = 0;
							state = t.createStatement();
							//获取总人数
							res = state.executeQuery("exec count_person");
							res.next();
							int cout = res.getInt("总人数");
							rank_id = new String[cout];
							res = state.executeQuery("exec proc_get_rank");
							while(res.next()) {
								String cou_id = res.getString("学号");
								rank_id[k]=new String(cou_id);
								k++;
							}
							for(int i=0;i<cout;i++) {
								sql = t.prepareStatement("exec proc_set_rank ?,?");
								sql.setInt(1, i+1);
								sql.setString(2, rank_id[i]);
								m = sql.executeUpdate();
							}
							
							
							//获取总人数
							k=0;
							res = state.executeQuery("exec count_person_1");
							res.next();
							cout = res.getInt("总人数");
							rank_id = new String[cout];
							res = state.executeQuery("exec proc_get_rank_1");
							while(res.next()) {
								String cou_id = res.getString("学号");
								rank_id[k]=new String(cou_id);
								k++;
							}
							for(int i=0;i<cout;i++) {
								sql = t.prepareStatement("exec proc_set_rank_1 ?,?");
								sql.setInt(1, i+1);
								sql.setString(2, rank_id[i]);
								m = sql.executeUpdate();
							}
							
							
							if (m == 1) {
								JOptionPane.showMessageDialog(null, "成绩信息录入成功");
								int msg;
								msg = JOptionPane.showConfirmDialog(null, "是否清空当前内容", "An", JOptionPane.YES_NO_OPTION);
								if(msg == JOptionPane.YES_OPTION) {
									Main_Frame.textField.setText("请输入语文成绩");
									Main_Frame.textField_1.setText("请输入数学成绩");
									Main_Frame.textField_2.setText("请输入英语成绩");
									Main_Frame.textField_7.setText("请输入语文教师评测");
									Main_Frame.textField_8.setText("请输入数学教师评测");
									Main_Frame.textField_9.setText("请输入英语教师评测");
									Main_Frame.textField_5.setText("请输入互评成绩");
									Main_Frame.textField_6.setText("请输入品德成绩");
									Main_Frame.textField.requestFocus();//////设置文本框焦点
								}
								
								
								
							}else {
								JOptionPane.showMessageDialog(null, "成绩信息录入失败");
							}
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "成绩信息录入失败，错误代码：002");
						}
					}else {//说明在   Student_info  不存在id
						JOptionPane.showMessageDialog(null, "未能查到此id，请先录入信息");
						Main_Frame.setPanel_False();
						Main_Frame.panel_arr[0].setVisible(true);
						Main_Frame.frame.setSize(Main_Frame.frame.getWidth(), 387);
					}
				}
			}
		}
			
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}