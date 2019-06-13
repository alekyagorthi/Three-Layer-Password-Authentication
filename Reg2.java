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
import javax.crypto.spec.*;
import javax.security.*;
import javax.crypto.*;
public class Reg2 extends JFrame implements ActionListener
{
	Container c;
	JPanel card1,card2,pane;
	CardLayout c1;
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
	JButton ok;
	JPasswordField pf;
	JPasswordField conpf;
	JLabel l2,l3;
	JButton submit;
	JButton reset;
	String s,usr;
	int flag=0;
	Reg2(String userid)
	{
		usr=userid;
		setTitle("Registration Layer 2");
		card1=new JPanel();
		card2=new JPanel();
		txt=new JLabel("Registratin Layer 2");
		txt.setBounds(50,50,800,100);
		txt.setFont(new Font("SERIF",Font.BOLD,50));
		txt.setForeground(Color.WHITE);
		pane=new JPanel();
		c1=new CardLayout();
		pane.setLayout(c1);
		card1.setLayout(null);
		card2.setLayout(null);
		ImageIcon imageIcon=new ImageIcon("G:/Mega Project/Authentication/src/i10.png");
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1500, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		l4=new JLabel(imageIcon);
		red=new JButton("Red");
		blue=new JButton("Blue");
		green=new JButton("Green");
		yellow=new JButton("Yellow");
		black=new JButton("Black");
		violet=new JButton("Violet");
		pink=new JButton("Pink");
		orange=new JButton("Orange");
		grey=new JButton("Grey");
		ok=new JButton("OK");
		submit=new JButton("SUBMIT");
		reset=new JButton("RESET");
		l3=new JLabel("Pattren should be of 9 char atleast");
		pf=new JPasswordField(30);
		conpf=new JPasswordField(30);
		l2=new JLabel("Confirm Pattern");
		l1=new JLabel("Pattern");
		pf.setEditable(false);
		conpf.setEditable(false);
		conpf.setText("");
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
		card1.add(conpf);
		card1.add(l2);
		card1.add(ok);
		card1.add(l3);
		card1.add(pf);
		card1.add(txt);
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.RED);
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
		l2.setFont(new Font("SERIF",Font.PLAIN,30));
		ok.setFont(new Font("SERIF",Font.PLAIN,30));
		l3.setFont(new Font("SERIF",Font.PLAIN,10));
		reset.setBounds(500, 510, 200, 50);
		submit.setBounds(725, 510, 200, 50);
		l1.setBounds(425, 410, 100, 30);
		pf.setBounds(550, 410, 400, 30);
		l3.setBounds(550, 442, 200, 10);
		red.setBounds(400, 200, 200, 50);
		blue.setBounds(625, 200, 200, 50);
		green.setBounds(850,200,200,50);
		yellow.setBounds(400, 270, 200, 50);
		violet.setBounds(625, 270, 200, 50);
		black.setBounds(850, 270, 200, 50);
		pink.setBounds(400, 340, 200, 50);
		grey.setBounds(625, 340, 200, 50);
		orange.setBounds(850, 340, 200, 50);
		conpf.setBounds(550,460,400,30);
		l2.setBounds(325, 460, 200, 30);
		ok.setBounds(1000, 410, 100, 30);
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
		ok.addActionListener(this);
		
	}
	public static void main(String[] args) 
	{
		Reg2 e=new Reg2("");
		e.setVisible(true);
		e.setSize(1500, 1000);
		e.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String ch=arg0.getActionCommand();
		if(flag==0)
		{
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
		}
		if(flag==1)
		{
			if(ch=="Red")
			{
				s=(new StringBuilder()).append(conpf.getText()).append("R").toString();
				conpf.setText(s);
			}
			if(ch=="Blue")
			{
				s=(new StringBuilder()).append(conpf.getText()).append("B").toString();
				conpf.setText(s);
			}
			if(ch=="Black")
			{
				s=(new StringBuilder()).append(conpf.getText()).append("C").toString();
				conpf.setText(s);
			}
			if(ch=="Green")
			{
				s=(new StringBuilder()).append(conpf.getText()).append("G").toString();
				conpf.setText(s);
			}
			if(ch=="Grey")
			{
				s=(new StringBuilder()).append(conpf.getText()).append("H").toString();
				conpf.setText(s);
			}
			if(ch=="Yellow")
			{
				s=(new StringBuilder()).append(conpf.getText()).append("Y").toString();
				conpf.setText(s);
			}
			if(ch=="Pink")
			{
				s=(new StringBuilder()).append(conpf.getText()).append("P").toString();
				conpf.setText(s);
			}
			if(ch=="Orange")
			{
				s=(new StringBuilder()).append(conpf.getText()).append("O").toString();
				conpf.setText(s);
			}
			if(ch=="Violet")
			{
				s=(new StringBuilder()).append(conpf.getText()).append("V").toString();
				conpf.setText(s);
			}
		}
		if(ch=="SUBMIT")
		{
			String pas=pf.getText();
			String conpas=conpf.getText();
			if(!pas.equals(conpas) || pas.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Please enter the same password","alert",1);
			}
			else
			{
				/*if(pas.length() % 8 !=0)
				{
					int z=(8-(pas.length()%8));
					System.out.println(z);
					for(int i=0;i<z;i++)
						pas=(new StringBuilder()).append(pas).append("*").toString();
				}
				System.out.println(pas+pas.length());*/
				try
				{
					int k1=32;
					int k2=26;
					int k3=25;
					pas=encrypt(pas,k1);
					pas=decrypt(pas,k2);
					pas=encrypt(pas,k3);
					//System.out.println(usr);
					//byte[] encrypted=encrypt(pas,"password");
					//String cipher=encrypted.toString();
					//System.out.println(cipher);
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/threelayerauthen","alekya", "alekya");
					Statement smt=conn.createStatement();
					String sql="UPDATE usercredentials set pass2='"+pas+"' where userid='"+usr+"';";
					System.out.println("  " + sql);
					smt.executeUpdate(sql);
				}
				catch(Exception e)
				{
					System.out.println("Exception : "+e.getMessage());
				}
				this.dispose();
				Reg3 r=new Reg3(usr);
				r.setVisible(true);
				r.setDefaultCloseOperation(EXIT_ON_CLOSE);
				r.setSize(1500,1000);
			}
		}
		if(ch=="OK")
		{
			flag=1;
		}
		if(ch=="RESET")
		{
			flag=0;
			conpf.setText("");
			pf.setText("");
		}
		// TODO Auto-generated method stub
		
	}
	/*public byte[] encrypt(String message,String key) throws Exception
	{
		SecureRandom sr=new SecureRandom(key.getBytes());
		KeyGenerator kg=KeyGenerator.getInstance("DESede");
		kg.init(sr);
		SecretKey sk=kg.generateKey();
		Cipher cipher=Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, sk);
		byte[] encrypted=cipher.doFinal(message.getBytes());
		return encrypted;
	}*/
	public String encrypt(String message,int key)
	{
		String s="";
		char a;
		int len=message.length();
		for(int i=0;i<len;i++)
		{
			a=message.charAt(i);
			int k=a+key;
			s=(new StringBuilder()).append(s).append((char)k).toString();
		}
		return s;
	}
	public String decrypt(String message,int key)
	{
		String s="";
		char a;
		int len=message.length();
		for(int i=0;i<len;i++)
		{
			a=message.charAt(i);
			int k=a-key;
			s=(new StringBuilder()).append(s).append((char)k).toString();
		}
		return s;
	}

}
