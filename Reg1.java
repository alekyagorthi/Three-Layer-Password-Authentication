import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.math.BigInteger;
import java.sql.*;
public class Reg1 extends JFrame implements ActionListener
{
	JPanel card1,card2,pane;
	JLabel user;
	JLabel pass,txt;
	JButton submit;
	JButton reset;
	JTextField use;
	JPasswordField pas;
	JLabel confirm;
	JPasswordField conpass;
	Container c=null;
	CardLayout c1;
	String cipher;
	JLabel l1;
	String flag;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/threelayerauthen";
	Reg1()
	{
		this.setTitle("Registration 1");
		cipher="";
		txt=new JLabel("Registration Layer 1");
		c1=new CardLayout();
		card1=new JPanel();
		card2=new JPanel();
		pane=new JPanel();
		pane.setLayout(c1);
		card1.setLayout(null);
		card2.setLayout(null);
		flag="";
		ImageIcon imageIcon=new ImageIcon("G:/Mega Project/Authentication/src/i2.jpeg");
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1500, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		l1=new JLabel(imageIcon);
		user=new JLabel("User Name");
		user.setFont(new Font("SERIF",Font.PLAIN,20));
		pass=new JLabel("Password");
		pass.setFont(new Font("SERIF",Font.PLAIN,20));
		use=new JTextField(30);
		pas=new JPasswordField(30);
		submit=new JButton("SUBMIT");
		reset=new JButton("RESET");
		confirm=new JLabel("Confirm Password");
		confirm.setFont(new Font("SERIF",Font.PLAIN,20));
		conpass=new JPasswordField(30);
		txt.setBounds(50,50,800,100);
		txt.setFont(new Font("SERIF",Font.BOLD,50));
		txt.setForeground(Color.WHITE);
		user.setBounds(500, 250, 150, 30);
		pass.setBounds(500, 300, 150, 30);
		use.setBounds(650, 250, 150, 30);
		pas.setBounds(650, 300, 150, 30);
		submit.setBounds(525, 400, 100, 30);
		reset.setBounds(675, 400, 100, 30);
		confirm.setBounds(500, 350, 150, 30);
		conpass.setBounds(650, 350, 150, 30);
		l1.setBounds(0, 0, 1500, 800);
		user.setForeground(Color.WHITE);
		pass.setForeground(Color.WHITE);
		confirm.setForeground(Color.WHITE);
		card1.add(user);
		card1.add(pass);
		card1.add(use);
		card1.add(pas);
		card1.add(submit);
		card1.add(reset);
		card1.add(confirm);
		card1.add(conpass);
		card1.add(txt);
		card2.add(l1);
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

	public static void main(String[] args) 
	{
		System.out.print("inside rege1 main");
		Reg1 a=new Reg1();
		a.setVisible(true);
		a.setSize(1500, 1000);
		a.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String ch=arg0.getActionCommand();
		if(ch=="SUBMIT")
		{
			String us=use.getText();
			String pa=pas.getText();
			String con=conpass.getText();
			if(us.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Please enter the username","alert",1);
			}
			else if(con.length()<8)
			{
				JOptionPane.showMessageDialog(null, "Please give a passord of min 8 char", "Invalid Password", 1);
			}
			else if(!con.equals(pa))
			{
				JOptionPane.showMessageDialog(null, "Please give same password in both sections", "Incorect Password", 1);
			}
			else if(us.length()>0 && con.length()>=8 && con.equals(pa))
			{
				try
				{                                               //RSA Encryption Start
					for(int i=0;i<pa.length();i++)
					{
						BigInteger mes=BigInteger.valueOf(pa.charAt(i));//converting the message char into ASCII values
						BigInteger bn=mes.multiply(mes);
						for(int k=1;k<34;k++)
						{
							bn=bn.multiply(mes);                         //doing the message power "d" the public key
						}
						System.out.print(bn.intValue());
						BigInteger n=bn.mod(BigInteger.valueOf(221));                 //Converting the n value into BigIntiger
						int m=n.intValue();
						if(m>=129 && m<=160)
						{
							flag=(new StringBuilder()).append(flag).append("1").toString(); //setting flag 1 at the position where 
							m+=32;      //we are adding a value to the ascii value of the message so that to avoid the garbage values 
						}
						else
							flag=(new StringBuilder()).append(flag).append("0").toString();
						System.out.println("  "+m+"  "+(char)m);
						System.out.println(flag);
						cipher=(new StringBuilder()).append(cipher).append((char)m).toString();       //concat the cipher characters
					}
					System.out.println(cipher);
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/threelayerauthen","alekya", "alekya");
					Statement smt=conn.createStatement();
					String sql1="Select userid from usercredentials where userid='"+us+"'";
					ResultSet rs=smt.executeQuery(sql1);
					if(!rs.next())
					{
						System.out.println("\nhii");
					String sql="INSERT INTO usercredentials (userid, pass1,flag)values('"+us+"','"+cipher+"','"+flag+"')";
					System.out.println("  " + sql);
					smt.executeUpdate(sql);                       //executing the database query
					this.dispose();
					Reg2 r=new Reg2(us);
					r.setVisible(true);
					r.setSize(1500,1000);
					r.setDefaultCloseOperation(EXIT_ON_CLOSE);
					}
					else
					{
						System.out.println("\nhii1");
						String sam=rs.getString("userid");
						System.out.println(sam);
						JOptionPane.showMessageDialog(null,"Username is already in use","alert",1);
						//System.out.println(rs.getString("userid"));
					}
					/*while(rs.next())
					{
				         //Retrieve by column name
				         String usrid=rs.getString("userid");
				         System.out.println(usrid);
					}*/
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			
		}
		else
		{
			use.setText("");
			pas.setText("");
			conpass.setText("");
			cipher="";
		}
		// TODO Auto-generated method stub
		
	}

}
