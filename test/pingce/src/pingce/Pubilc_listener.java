package pingce;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Pubilc_listener {

}
class MyFocusListener implements FocusListener {  //��ͨ�ı���
    String info;  
    JTextField jtf; 
    public MyFocusListener(String info, JTextField jtf) {  
        this.info = info;  
        this.jtf = jtf;  
    }  
    @Override  
    public void focusGained(FocusEvent e) {//��ý����ʱ��,�����ʾ����  
        String temp = jtf.getText();  
        if(temp.equals(info)){  
            jtf.setText("");
            jtf.setFont(new Font("����", Font.PLAIN, 16));
        }  
    }  
    @Override  
    public void focusLost(FocusEvent e) {//ʧȥ�����ʱ��,�ж����Ϊ��,����ʾ��ʾ����  
        String temp = jtf.getText();  
        if(temp.equals("")){
            jtf.setText(info);
            jtf.setFont(new Font("����", Font.PLAIN, 16));
        }  
    }  
}

class MyFocusListener1 implements FocusListener {  //�����ı���
    String info;  
    JPasswordField jtf; 
    public MyFocusListener1(String info, JPasswordField jtf) {  
        this.info = info;  
        this.jtf = jtf;  
    }  
    @Override  
    public void focusGained(FocusEvent e) {//��ý����ʱ��,�����ʾ����  
    	String temp = new String(jtf.getPassword()).trim();
        if(temp.equals(info)){
        	jtf.setEchoChar('��');
            jtf.setText("");
            jtf.setFont(new Font("����", Font.PLAIN, 12));
        }  
    }  
    @Override  
	public void focusLost(FocusEvent e) {//ʧȥ�����ʱ��,�ж����Ϊ��,����ʾ��ʾ���� 
    	String temp = new String(jtf.getPassword()).trim();
        if(temp.equals("")){
        	((JPasswordField) jtf).setEchoChar((char) 0);
            jtf.setText(info);
            jtf.setFont(new Font("����", Font.PLAIN, 16));
        }  
    }  
}  
class Input_Check implements KeyListener{

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
		
	}
	
}




