package pingce;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
@SuppressWarnings("serial")
class CircleButton extends JButton {
	Shape shape;
	Color bgColor = SystemColor.control;
	public CircleButton() {
	    this("未命名", null);
	}
	public CircleButton(String label) {
	    this(label, null);
	}
	public CircleButton(String label, Color bgColor) {
	    super(label); // 调用父类构造方法
	    this.setText(label);
	    this.setFont(new Font("宋体", Font.PLAIN, 10));
	    if (bgColor != null) {
	      this.bgColor = bgColor;
	    }
	    Dimension size = this.getPreferredSize();
	    //System.out.println(size);
	    //size.width = size.height = Math.max(size.width, size.height);
	    size.width=10;
	    size.height=10;
	    this.setPreferredSize(size); // 设置宽高等距
	    this.setContentAreaFilled(false); // 不绘制内容区域
	    this.setBorderPainted(false); // 不绘制边框
	    this.setFocusPainted(false); // 不绘制焦点状态
	}
	protected void paintComponent(Graphics g) {
	    // 如果鼠标按下，isArmed()方法返回true
	    if (this.getModel().isArmed()) {
	      g.setColor(java.awt.SystemColor.controlHighlight);
	    } else {
	      g.setColor(java.awt.SystemColor.controlShadow);
	      g.setColor(this.bgColor); // 设置背景颜色
	    }
	    g.fillOval(0, 0, this.getSize().width - 1, this.getSize().height - 1); // 绘制圆形背景区域
	    g.setColor(java.awt.SystemColor.controlShadow); // 设置边框颜色
	    g.drawOval(0, 0, this.getSize().width - 1, this.getSize().height - 1); // 绘制边框线
	    super.paintComponent(g);
	}
	public boolean contains(int x, int y) {
	    if ((shape == null) || (!shape.getBounds().equals(this.getBounds()))) {
	      this.shape = new Ellipse2D.Float(0, 0, this.getWidth(), this
	          .getHeight());
	    }
	    return shape.contains(x, y);
	}
}


/**
public class CircleButtonTest{
	public static void main(String[] args) {
		
		
		JFrame panel = new JFrame("自定义按钮");
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setSize(350, 280);
		panel.setLocationRelativeTo(null);
		panel.setLayout(null);
	    
		
		
		Color arrColor[] = new Color[] { Color.red, Color.green, Color.blue};
		
    	CircleButton cb = new CircleButton("",arrColor[0]);
    	panel.add(cb);
    	cb.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			System.out.println("按钮");
    		}
    	});
    	cb.setBounds(10, 5, 20, 20);
    	
    	CircleButton cb1 = new CircleButton("",arrColor[1]);
    	panel.add(cb1);
    	cb1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			System.out.println("按钮");
    		}
    	});
    	cb1.setBounds(35, 5, 20, 20);
    	
    	
    	CircleButton cb2 = new CircleButton("",arrColor[2]);
    	panel.add(cb2);
    	cb2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			System.out.println("按钮");
    		}
    	});
    	cb2.setBounds(60, 5, 20, 20);
    	//设置三个圆形按钮   结束
    	panel.setVisible(true);
	}
}
**/