import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Home extends JFrame implements ActionListener
{
	JButton login;
	JButton register;
	JLabel l1,title1,title2;
	JPanel pane1,pane2,cpanel;
	Container c = null;
	CardLayout c1;
	Home() 
	{
		c1=new CardLayout();
		ImageIcon imageIcon=new ImageIcon("G:/Mega Project/Authentication/src/i8.jpeg");
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1500, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		l1=new JLabel(imageIcon);
		title1=new JLabel("Three Layer Password");
		title1.setFont(new Font("SERIF",Font.BOLD,80));
		title1.setBounds(275, 0, 1000, 200);
		title1.setForeground(Color.WHITE);
		title2=new JLabel("Authentication");
		title2.setFont(new Font("SERIF",Font.BOLD,80));
		title2.setForeground(Color.WHITE);
		title2.setBounds(375, 100, 1000, 200);
		cpanel= new JPanel();
		cpanel.setLayout(c1);
		pane1=new JPanel();
		pane1.setLayout(null);
		pane2=new JPanel();
		pane2.setLayout(null);
		login=new JButton("Login");
		register=new JButton("Register");
		login.setBounds(700, 300, 300, 70);
		register.setBounds(300, 300, 300, 70);
		l1.setBounds(0, 0, 1500, 800);
		login.setFont(new Font("SERIF",Font.PLAIN,50));
		register.setFont(new Font("SERIF",Font.PLAIN,50));
		pane1.add(login);
		pane1.add(register);
		pane1.add(title1);
		pane1.add(title2);
		pane2.add(l1);
		pane1.setOpaque(false);
		pane2.setOpaque(true);
		//register.setHorizontalAlignment(SwingConstants.CENTER);
		//login.setHorizontalAlignment(SwingConstants.CENTER);
		register.addActionListener(this);
		login.addActionListener(this);
		cpanel.add(pane1,"1");
		cpanel.add(pane2,"2");
		c1.show(cpanel, "1");
		cpanel.setVisible(true);
		pane1.setVisible(true);
		pane2.setVisible(true);
		c=getContentPane();
		c.add(cpanel, BorderLayout.CENTER);
		
	}
	public static void main(String[] args)
	{
	Home sp = new Home();
	sp.setVisible(true);
	sp.setSize(1500, 1000);//main method to initiate the starting process
	sp.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		String ch=arg0.getActionCommand();
		if(ch=="Register")
		{
			System.out.println("Registration");
			this.dispose();
			Reg1 re=new Reg1();
			re.setVisible(true);
			re.setSize(1500,1000);
			re.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		else
	
		{
			this.dispose();
			Log1 lo=new Log1();
			lo.setVisible(true);
			lo.setSize(1500,1000);
			lo.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}

}
