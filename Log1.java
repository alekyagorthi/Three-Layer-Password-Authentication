import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.*;

import javax.swing.*;

public class Log1 extends JFrame implements ActionListener
{
	JPanel card1,card2,pane;
	Container c;
	CardLayout c1;
	JLabel user,l1;
	JLabel pass,txt;
	JButton submit;
	JButton reset;
	JTextField use;
	JPasswordField pas;
	String cipher;
	int counter=0;
	Log1()
	{
		cipher="";
		setTitle("Login Layer 1");
		card1=new JPanel();
		card2=new JPanel();
		pane=new JPanel();
		c1=new CardLayout();
		pane.setLayout(c1);
		card1.setLayout(null);
		card2.setLayout(null);
		ImageIcon imageIcon=new ImageIcon("G:/Mega Project/Authentication/src/i4.jpeg");
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1500, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		l1=new JLabel(imageIcon);
		txt=new JLabel("Login Layer 1");
		txt.setBounds(50,0,800,100);
		txt.setFont(new Font("SERIF",Font.BOLD,50));
		txt.setForeground(Color.WHITE);
		user=new JLabel("User Name");
		user.setFont(new Font("SERIF",Font.PLAIN,30));
		pass=new JLabel("Password");
		pass.setFont(new Font("SERIF",Font.PLAIN,30));
		use=new JTextField(30);
		pas=new JPasswordField(30);
		submit=new JButton("SUBMIT");
		reset=new JButton("RESET");
		user.setBounds(600, 250, 150, 30);
		user.setForeground(Color.WHITE);
		pass.setForeground(Color.WHITE);
		pass.setBounds(600, 300, 150, 30);
		use.setBounds(750, 250, 150, 30);
		pas.setBounds(750, 300, 150, 30);
		submit.setBounds(625, 400, 100, 30);
		reset.setBounds(775, 400, 100, 30);
		l1.setBounds(0, -100, 1500, 1000);
		card1.add(user);
		card1.add(pass);
		card1.add(use);
		card1.add(pas);
		card1.add(submit);
		card1.add(reset);
		card2.add(l1);
		card1.add(txt);
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
	}
	public static void main(String[] arg0)
	{
		Log1 l=new Log1();
		l.setVisible(true);
		l.setSize(1500,1000);
		l.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		String us=use.getText();
		String pa=pas.getText();
		String s=arg0.getActionCommand();
		if(s=="SUBMIT")
		{
			if(us.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Please enter the username","alert",1);
			}
			else if(pa.length()<8)
			{
				JOptionPane.showMessageDialog(null, "Please give a passord of min 8 char", "Invalid Password", 1);
			}
			try
			{
				System.out.println("H0");
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/threelayerauthen","alekya", "alekya");
				Statement smt=conn.createStatement();
				System.out.println("H3");
				String sql="Select * from usercredentials where userid='"+us+"';";
				ResultSet rs=smt.executeQuery(sql);
				System.out.println("H2");
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid username","alert",1);
				}
				else
				{
					System.out.println("H1");
					String password=rs.getString("pass1");
					String flag=rs.getString("flag");
					System.out.println(password);
					for(int i=0;i<password.length();i++)
					{
						int k=password.charAt(i);
						BigInteger mes=BigInteger.valueOf(password.charAt(i));
						System.out.println(flag+" "+mes);
						if(flag.charAt(i)=='1')
						{
							k=k-32;
						}
						mes=BigInteger.valueOf(k);
						System.out.print(mes+" ");
						BigInteger bn=mes.multiply(mes);
						for(k=1;k<10;k++)
						{
							bn=bn.multiply(mes);
						}
						BigInteger n=bn.mod(BigInteger.valueOf(221));
						int m=n.intValue();
						System.out.println(m);
						cipher=(new StringBuilder()).append(cipher).append((char)m).toString();
					}
					System.out.println(cipher);
					if(!cipher.equals(pa))
					{
						JOptionPane.showMessageDialog(null,"Please enter correct password","alert",1);
						counter++;
						pas.setText("");
						if(counter==3)
						{
						this.dispose();
						Home h=new Home();
						h.setVisible(true);
						h.setSize(1500,1000);
						h.setDefaultCloseOperation(EXIT_ON_CLOSE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Password Correct","Success",1);
						System.out.println("success");
			            this.dispose();
						Log2 lo=new Log2(us);
						lo.setVisible(true);
						lo.setSize(1500,1000);
						lo.setDefaultCloseOperation(EXIT_ON_CLOSE);
					}
				}
			}
			catch(Exception e)
			{}
			/*if(pa.length()>=8)
			{
				this.dispose();
				Log2 lo=new Log2(us);
				lo.setVisible(true);
				lo.setSize(1500,1000);
				lo.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
			else
				JOptionPane.showMessageDialog(null,"Please enter correct password","alert",1);*/
		}	
		else
		{
			use.setText("");
			pas.setText("");
		}
		// TODO Auto-generated method stub
		
	}
}
