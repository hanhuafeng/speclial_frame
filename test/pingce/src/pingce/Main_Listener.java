package pingce;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_Listener {

}
class BarClick implements ActionListener{
	private int a;
	private JPanel b;
	private JPanel c[]= {};
	private JFrame d;
	public BarClick(int a,JPanel b,JPanel c[],JFrame d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		setPanel_False();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (a == 0) {//修改学生信息
			System.out.println("修改学生信息");
			setPanel_False();
			b.setVisible(true);
			d.setSize(b.getWidth(), b.getHeight());
			//d.setSize(b.getWidth()+18, b.getHeight()+61);
		}else if(a == 1) {//删除学生信息
			System.out.println("删除学生信息");
			setPanel_False();
			b.setVisible(true);
			d.setSize(b.getWidth()+18, b.getHeight()+61);
		}else if(a == 2) {//查询学生信息
			System.out.println("浏览学生信息");
			setPanel_False();
			
		}
	}
	private void setPanel_False() {
		for(int i = 0;i < c.length;i++) {
			c[i].setVisible(false);
		}
	}
}


class InputKey implements KeyListener{  //限定数字输入
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar=e.getKeyChar();
		if ((keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) || (keyChar == KeyEvent.VK_BACK_SPACE)) {
			
		} else {
			e.consume();  
		}
	}
}