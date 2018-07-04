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
	    this("δ����", null);
	}
	public CircleButton(String label) {
	    this(label, null);
	}
	public CircleButton(String label, Color bgColor) {
	    super(label); // ���ø��๹�췽��
	    this.setText(label);
	    this.setFont(new Font("����", Font.PLAIN, 10));
	    if (bgColor != null) {
	      this.bgColor = bgColor;
	    }
	    Dimension size = this.getPreferredSize();
	    //System.out.println(size);
	    //size.width = size.height = Math.max(size.width, size.height);
	    size.width=10;
	    size.height=10;
	    this.setPreferredSize(size); // ���ÿ�ߵȾ�
	    this.setContentAreaFilled(false); // ��������������
	    this.setBorderPainted(false); // �����Ʊ߿�
	    this.setFocusPainted(false); // �����ƽ���״̬
	}
	protected void paintComponent(Graphics g) {
	    // �����갴�£�isArmed()��������true
	    if (this.getModel().isArmed()) {
	      g.setColor(java.awt.SystemColor.controlHighlight);
	    } else {
	      g.setColor(java.awt.SystemColor.controlShadow);
	      g.setColor(this.bgColor); // ���ñ�����ɫ
	    }
	    g.fillOval(0, 0, this.getSize().width - 1, this.getSize().height - 1); // ����Բ�α�������
	    g.setColor(java.awt.SystemColor.controlShadow); // ���ñ߿���ɫ
	    g.drawOval(0, 0, this.getSize().width - 1, this.getSize().height - 1); // ���Ʊ߿���
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
		
		
		JFrame panel = new JFrame("�Զ��尴ť");
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setSize(350, 280);
		panel.setLocationRelativeTo(null);
		panel.setLayout(null);
	    
		
		
		Color arrColor[] = new Color[] { Color.red, Color.green, Color.blue};
		
    	CircleButton cb = new CircleButton("",arrColor[0]);
    	panel.add(cb);
    	cb.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			System.out.println("��ť");
    		}
    	});
    	cb.setBounds(10, 5, 20, 20);
    	
    	CircleButton cb1 = new CircleButton("",arrColor[1]);
    	panel.add(cb1);
    	cb1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			System.out.println("��ť");
    		}
    	});
    	cb1.setBounds(35, 5, 20, 20);
    	
    	
    	CircleButton cb2 = new CircleButton("",arrColor[2]);
    	panel.add(cb2);
    	cb2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			System.out.println("��ť");
    		}
    	});
    	cb2.setBounds(60, 5, 20, 20);
    	//��������Բ�ΰ�ť   ����
    	panel.setVisible(true);
	}
}
**/