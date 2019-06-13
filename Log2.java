import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.security.*;
import javax.crypto.spec.*;
import javax.crypto.*;
public class Log2 extends JFrame implements ActionListener
{
	JPanel card1,card2,pane;
	CardLayout c1;
	Container c;
	JLabel l1,l4,txt;
	JButton red;
	JButton yellow;
	JButton blue;
	JButton green;
	JButton black;
	JButton violet;
	JButton pink;
	JButton orange;
	JButton grey;
	JPasswordField pf;
	JPasswordField conpf;
	JLabel l2;
	JButton submit;
	JButton reset;
	String s,usr;
	Log2(String userid)
	{
		usr=userid;
		setTitle("Login Layer 2");
		card1=new JPanel();
		card2=new JPanel();
		pane=new JPanel();
		c1=new CardLayout();
		pane.setLayout(c1);
		card1.setLayout(null);
		card2.setLayout(null);
		ImageIcon imageIcon=new ImageIcon("G:/Mega Project/Authentication/src/i5.jpeg");
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1500, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		l4=new JLabel(imageIcon);
		txt=new JLabel("Login Layer 2");
		txt.setBounds(50,0,800,100);
		txt.setFont(new Font("SERIF",Font.BOLD,50));
		txt.setForeground(Color.WHITE);
		red=new JButton("Red");
		blue=new JButton("Blue");
		green=new JButton("Green");
		yellow=new JButton("Yellow");
		black=new JButton("Black");
		violet=new JButton("Violet");
		pink=new JButton("Pink");
		orange=new JButton("Orange");
		grey=new JButton("Grey");
		submit=new JButton("SUBMIT");
		reset=new JButton("RESET");
		pf=new JPasswordField(30);
		conpf=new JPasswordField(30);
		l1=new JLabel("Pattern");
		pf.setEditable(false);
		pf.setText("");
		card1.add(red);
		card1.add(black);
		card1.add(blue);
		card1.add(grey);
		card1.add(green);
		card1.add(orange);
		card1.add(pink);
		card1.add(violet);
		card1.add(yellow);
		card1.add(reset);
		card1.add(submit);
		card1.add(l1);
		card1.add(pf);
		card1.add(txt);
		l1.setForeground(Color.WHITE);
		red.setForeground(Color.WHITE);
		black.setForeground(Color.WHITE);
		blue.setForeground(Color.WHITE);
		grey.setForeground(Color.WHITE);
		red.setBackground(Color.RED);
		black.setBackground(Color.BLACK);
		blue.setBackground(Color.BLUE);
		green.setBackground(Color.GREEN);
		grey.setBackground(Color.GRAY);
		orange.setBackground(Color.ORANGE);
		pink.setBackground(Color.PINK);
		yellow.setBackground(Color.YELLOW);
		violet.setBackground(Color.MAGENTA);
		red.setFont(new Font("SERIF",Font.PLAIN,30));
		black.setFont(new Font("SERIF",Font.PLAIN,30));
		blue.setFont(new Font("SERIF",Font.PLAIN,30));
		grey.setFont(new Font("SERIF",Font.PLAIN,30));
		green.setFont(new Font("SERIF",Font.PLAIN,30));
		orange.setFont(new Font("SERIF",Font.PLAIN,30));
		pink.setFont(new Font("SERIF",Font.PLAIN,30));
		yellow.setFont(new Font("SERIF",Font.PLAIN,30));
		violet.setFont(new Font("SERIF",Font.PLAIN,30));
		l1.setFont(new Font("SERIF",Font.PLAIN,30));
		reset.setBounds(500, 460, 200, 50);
		submit.setBounds(725, 460, 200, 50);
		l1.setBounds(425, 410, 100, 30);
		pf.setBounds(550, 410, 400, 30);
		red.setBounds(400, 200, 200, 50);
		blue.setBounds(625, 200, 200, 50);
		green.setBounds(850,200,200,50);
		yellow.setBounds(400, 270, 200, 50);
		violet.setBounds(625, 270, 200, 50);
		black.setBounds(850, 270, 200, 50);
		pink.setBounds(400, 340, 200, 50);
		grey.setBounds(625, 340, 200, 50);
		orange.setBounds(850, 340, 200, 50);
		l4.setBounds(-10,-100, 1500, 1000);
		card2.add(l4);
		card1.setOpaque(false);
		card2.setOpaque(true);
		pane.add(card1,"1");
		pane.add(card2,"2");
		c1.show(pane,"1");
		c=getContentPane();
		c.add(pane,BorderLayout.CENTER);
		card1.setVisible(true);
		card2.setVisible(true);
		submit.addActionListener(this);
		reset.addActionListener(this);	
		red.addActionListener(this);
		blue.addActionListener(this);
		green.addActionListener(this);
		yellow.addActionListener(this);
		violet.addActionListener(this);
		black.addActionListener(this);
		pink.addActionListener(this);
		grey.addActionListener(this);
		orange.addActionListener(this);
		
		
	}
	public static void main(String args[])
	{
		Log2 log=new Log2("");
		log.setVisible(true);
		log.setSize(1500,1000);
		log.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String ch=arg0.getActionCommand();
		if(ch=="Red")
		{
			s=(new StringBuilder()).append(pf.getText()).append("R").toString();
			pf.setText(s);
		}
		if(ch=="Blue")
		{
			s=(new StringBuilder()).append(pf.getText()).append("B").toString();
			pf.setText(s);
		}
		if(ch=="Black")
		{
			s=(new StringBuilder()).append(pf.getText()).append("C").toString();
			pf.setText(s);
		}
		if(ch=="Green")
		{
			s=(new StringBuilder()).append(pf.getText()).append("G").toString();
			pf.setText(s);
		}
		if(ch=="Grey")
		{
			s=(new StringBuilder()).append(pf.getText()).append("H").toString();
			pf.setText(s);
		}
		if(ch=="Yellow")
		{
			s=(new StringBuilder()).append(pf.getText()).append("Y").toString();
			pf.setText(s);
		}
		if(ch=="Pink")
		{
			s=(new StringBuilder()).append(pf.getText()).append("P").toString();
			pf.setText(s);
		}
		if(ch=="Orange")
		{
			s=(new StringBuilder()).append(pf.getText()).append("O").toString();
			pf.setText(s);
		}
		if(ch=="Violet")
		{
			s=(new StringBuilder()).append(pf.getText()).append("V").toString();
			pf.setText(s);
		}
		if(ch=="SUBMIT")
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/threelayerauthen","alekya", "alekya");
				Statement smt=conn.createStatement();
				String sql="Select * from usercredentials where userid='"+usr+"';";
				ResultSet rs=smt.executeQuery(sql);
				rs.next();
				String password=rs.getString("pass2");
				int k1=32;
				int k2=26;
				int k3=25;
				String decrypted=decrypt(password,k3);
				decrypted=encrypt(decrypted,k2);
				decrypted=decrypt(decrypted,k1);
				System.out.println(decrypted+" "+pf.getText());
				//String decrypted=decrypt(password.getBytes(),"password");
				if(decrypted.equals(pf.getText()))
				{
					JOptionPane.showMessageDialog(null,"Password Correct","Success",1);
					this.dispose();
					Log3 r=new Log3(usr);
					r.setVisible(true);
					r.setSize(1500,1000);
					r.setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Password Not Correct","alert",1);
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception : "+e.getMessage());
			}
		}
		if(ch=="RESET")
		{
			pf.setText("");
		}
		// TODO Auto-generated method stub
		
	}
	/*public String decrypt(byte[] message,String key) throws Exception
	{
		SecureRandom sr=new SecureRandom(key.getBytes());
		KeyGenerator kg=KeyGenerator.getInstance("DESede");
		kg.init(sr);
		SecretKey sk=kg.generateKey();
		Cipher cipher=Cipher.getInstance("DESede");
		cipher.init(Cipher.DECRYPT_MODE, sk);
		byte[] decrypted=cipher.doFinal(message);
		return new String(decrypted);
	}*/
	public String encrypt(String message,int key)
	{
		String s="";
		char a=' ';
		int len=message.length();
		for(int i=0;i<len;i++)
		{
			a=message.charAt(i);
			int k=a+key;
			s=(new StringBuilder()).append(s).append((char)k).toString();
			System.out.println(k+" "+a);
		}
		System.out.println(s+" "+a);
		return s;
	}
	public String decrypt(String message,int key)
	{
		String s="";
		char a=' ';
		int len=message.length();
		for(int i=0;i<len;i++)
		{
			a=message.charAt(i);
			int k=a-key;
			s=(new StringBuilder()).append(s).append((char)k).toString();
			System.out.println(k+" "+a);
		}
		System.out.println(s+" "+a);
		return s;
	}
	

}
