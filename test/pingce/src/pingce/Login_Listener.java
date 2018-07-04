package pingce;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;


public class Login_Listener {
}



//红色按钮
class RedClickAction implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("RedClickAction");
        System.exit(0);
    }
}//红色按钮

//黄色按钮
class YellowClickAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "目前我只是装饰作用");
	}
}//黄色按钮




class ButtonTest implements KeyListener{
	 public void keyReleased(KeyEvent ke){
	 }
	 
	 @SuppressWarnings("static-access")
	public void keyPressed(KeyEvent ke){
		 System.out.println("1111");
		 if(ke.getKeyChar() == ke.VK_ENTER){
			 System.out.println ("ok................") ;
		 }
	 }
	 
	 public void keyTyped(KeyEvent ke){
	 }
}

class  keylistener implements  KeyListener{
	public void keyPressed(KeyEvent e) {     
		int keyCode=e.getKeyCode();
		if(keyCode==KeyEvent.VK_ENTER){
			Login_Frame test = new Login_Frame();
			String username = test.getname_textField().getText();
			String a = "";
			String password = new String(test.getpsd_textField().getPassword()).trim();
			if(username.equals("admin") && password.equals("admin")) {  ///登录部分   超级账户superadmin   普通账户 admin
				System.out.println("登录成功");
				JOptionPane.showMessageDialog(null, "登录成功");
				
				Login_Frame.frame.setVisible(false);
				new Main_Frame();
			}else if(username.equals(a)){
				JOptionPane.showMessageDialog(null, "用户名不能为空");
			}else if(password.equals(a)) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
			}else {
				JOptionPane.showMessageDialog(null, "账号或者密码错误");
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}







