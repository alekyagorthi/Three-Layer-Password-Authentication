import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Log3 extends JFrame implements ActionListener
{
	Container c;
	CardLayout c1;
	JPanel card1,card2,pane;
	JLabel l4,txt;
	JFileChooser cho;
	BufferedImage img;
	File file;
	String filename,s1;
	JButton b[];
	JButton submit,reset,ok;
	JPasswordField pf;
	JLabel pass;
	String usr;
	ImageIcon i[];
	Integer[] visit;
	Integer bp[];
	int rand,index;
	static byte[] keyValue=new byte[] {'T','h','e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
	Log3(String userid)
	{
		usr=userid;
		setTitle("Login Layer 3");
		card1=new JPanel();
		card2=new JPanel();
		pane=new JPanel();
		c1=new CardLayout();
		pane.setLayout(c1);
		card1.setLayout(null);
		card2.setLayout(null);
		ImageIcon imageIcon=new ImageIcon("G:/Mega Project/Authentication/src/i9.png");
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1500, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		l4=new JLabel(imageIcon);
		txt=new JLabel("Login Layer 3");
		txt.setBounds(50,0,800,100);
		txt.setFont(new Font("SERIF",Font.BOLD,50));
		txt.setForeground(Color.WHITE);
		cho=new JFileChooser();
		pass=new JLabel("Pattern");
		pf=new JPasswordField(10);
		submit=new JButton("Submit");
		reset=new JButton("Reset");
		ok=new JButton("OK");
		b=new JButton[9];
		b[0]=new JButton("b1");
		b[1]=new JButton("b2");
		b[2]=new JButton("b3");
		b[3]=new JButton("b4");
		b[4]=new JButton("b5");
		b[5]=new JButton("b6");
		b[6]=new JButton("b7");
		b[7]=new JButton("b8");
		b[8]=new JButton("b9");
		pass.setForeground(Color.WHITE);
		b[0].setBounds(100, 100, 250, 200);
		b[1].setBounds(375, 100, 250, 200);
		b[2].setBounds(650, 100, 250, 200);
		b[3].setBounds(100, 325, 250, 200);
		b[4].setBounds(375, 325, 250, 200);
		b[5].setBounds(650, 325, 250, 200);
		b[6].setBounds(100, 550, 250, 200);
		b[7].setBounds(375, 550, 250, 200);
		b[8].setBounds(650, 550, 250, 200);
		pass.setBounds(1000, 200, 250, 40);
		pf.setBounds(1000, 260, 250, 40);
		submit.setBounds(1000, 380, 125, 40);
		reset.setBounds(1150,380,100,40);
		ok.setBounds(1000, 320, 100, 40);
		pass.setFont(new Font("SERIF",Font.PLAIN,30));
		submit.setFont(new Font("SERIF",Font.PLAIN,30));
		reset.setFont(new Font("SERIF",Font.PLAIN,30));
		ok.setFont(new Font("SERIF",Font.PLAIN,30));
		pf.setEditable(false);
		pf.setText("");
		b[0].setBorderPainted(false);
		b[0].setFocusPainted(false);
		b[0].setContentAreaFilled(false);
		b[1].setBorderPainted(false);
		b[1].setFocusPainted(false);
		b[1].setContentAreaFilled(false);
		b[2].setBorderPainted(false);
		b[2].setFocusPainted(false);
		b[2].setContentAreaFilled(false);
		b[3].setBorderPainted(false);
		b[3].setFocusPainted(false);
		b[3].setContentAreaFilled(false);
		b[4].setBorderPainted(false);
		b[4].setFocusPainted(false);
		b[4].setContentAreaFilled(false);
		b[5].setBorderPainted(false);
		b[5].setFocusPainted(false);
		b[5].setContentAreaFilled(false);
		b[6].setBorderPainted(false);
		b[6].setFocusPainted(false);
		b[6].setContentAreaFilled(false);
		b[7].setBorderPainted(false);
		b[7].setFocusPainted(false);
		b[7].setContentAreaFilled(false);
		b[8].setBorderPainted(false);
		b[8].setFocusPainted(false);
		b[8].setContentAreaFilled(false);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/threelayerauthen","alekya", "alekya");
			Statement smt=conn.createStatement();
			String sql1="Select * from usercredentials where userid='"+usr+"'";
			ResultSet rs=smt.executeQuery(sql1);
			if(rs.next())
			{
				Blob blob=rs.getBlob(4);
				byte[] immage=blob.getBytes(1, (int)blob.length());
				InputStream in=new ByteArrayInputStream(immage);
				//Image imge = Toolkit.getDefaultToolkit().createImage(immage);
	            //BufferedImage img = new BufferedImage(200,200,BufferedImage.TYPE_INT_ARGB);
	            BufferedImage img=ImageIO.read(in);
				System.out.println("hoooooooooo");
	            int row=3,col=3;
	            int twidth=img.getWidth();
				int theight=img.getHeight();
				int ewidth=twidth/col;
				int eheight=theight/row;
				System.out.println(ewidth+" "+eheight);
				i=new ImageIcon[9];
				i[0]=new ImageIcon(img.getSubimage(0, 0, ewidth, eheight));
				i[1]=new ImageIcon(img.getSubimage(ewidth, 0, ewidth, eheight));
				i[2]=new ImageIcon(img.getSubimage((ewidth*2), 0, ewidth, eheight));
				i[3]=new ImageIcon(img.getSubimage(0, eheight, ewidth, eheight));
				i[4]=new ImageIcon(img.getSubimage(ewidth, eheight, ewidth, eheight));
				i[5]=new ImageIcon(img.getSubimage((ewidth*2), eheight, ewidth, eheight));
				i[6]=new ImageIcon(img.getSubimage(0, (eheight*2), ewidth, eheight));
				i[7]=new ImageIcon(img.getSubimage(ewidth, (eheight*2), ewidth, eheight));
				i[8]=new ImageIcon(img.getSubimage((ewidth*2), (eheight*2), ewidth, eheight));
				visit=new Integer[9];
				System.out.println("hiiiiiiiiiiii");
				bp=new Integer[9];
				for(int j=0;j<9;j++)
					visit[j]=-1;
				for(int j=0;j<9;j++)
				{
					while(true)
					{
						rand=(int)(Math.random()*10);
						index=rand%9;
						if(visit[index]==-1)
						{
							bp[j]=index;
							b[j].setIcon(i[index]);
							visit[index]=0;
							break;
						}
						//System.out.println(rand);
					}
					
				}
				System.out.println("hellllllloooooo");
				card1.add(b[0]);
				card1.add(b[1]);
				card1.add(b[2]);
				card1.add(b[3]);
				card1.add(b[4]);
				card1.add(b[5]);
				card1.add(b[6]);
				card1.add(b[7]);
				card1.add(b[8]);
				card1.add(pf);
				card1.add(pass);
				card1.add(submit);
				card1.add(reset);
	            
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		card1.add(txt);
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
		b[0].setVisible(true);
		b[1].setVisible(true);
		b[2].setVisible(true);
		b[3].setVisible(true);
		b[4].setVisible(true);
		b[5].setVisible(true);
		b[6].setVisible(true);
		b[7].setVisible(true);
		b[8].setVisible(true);
		b[0].addActionListener(this);
		b[1].addActionListener(this);
		b[2].addActionListener(this);
		b[3].addActionListener(this);
		b[4].addActionListener(this);
		b[5].addActionListener(this);
		b[6].addActionListener(this);
		b[7].addActionListener(this);
		b[8].addActionListener(this);
		submit.addActionListener(this);
		reset.addActionListener(this);
	}
	public static void main(String[] args)
	{
		Log3 r=new Log3("mamatha");
		r.setVisible(true);
		r.setSize(1500,1000);
		r.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String s=arg0.getActionCommand();
		if(s=="b1")
		{
			b[0].setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append(bp[0].toString()).toString();
			pf.setText(s1);
		}
		if(s=="b2")
		{
			b[1].setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append(bp[1].toString()).toString();
			pf.setText(s1);
		}
		if(s=="b3")
		{
			b[2].setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append(bp[2].toString()).toString();
			pf.setText(s1);
		}
		if(s=="b4")
		{
			b[3].setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append(bp[3].toString()).toString();
			pf.setText(s1);
		}
		if(s=="b5")
		{
			b[4].setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append(bp[4].toString()).toString();
			pf.setText(s1);
		}
		if(s=="b6")
		{
			b[5].setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append(bp[5].toString()).toString();
			pf.setText(s1);
		}
		if(s=="b7")
		{
			b[6].setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append(bp[6].toString()).toString();
			pf.setText(s1);
		}
		if(s=="b8")
		{
			b[7].setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append(bp[7].toString()).toString();
			pf.setText(s1);
		}
		if(s=="b9")
		{
			b[8].setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append(bp[8].toString()).toString();
			pf.setText(s1);
		}
		if(s=="Reset")
		{
			pf.setText("");
			b[0].setVisible(true);
			b[1].setVisible(true);
			b[2].setVisible(true);
			b[3].setVisible(true);
			b[4].setVisible(true);
			b[5].setVisible(true);
			b[6].setVisible(true);
			b[7].setVisible(true);
			b[8].setVisible(true);			
		}
		if(s=="Submit")
		{
			if(pf.getText().length()==9)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/threelayerauthen","alekya", "alekya");
					Statement smt=conn.createStatement();
					String sql="Select * from usercredentials where userid='"+usr+"';";
					ResultSet rs=smt.executeQuery(sql);
					rs.next();
					String password=rs.getString("pass3pass");
					System.out.println(password);
					
					//ByteArrayInputStream bais = new ByteArrayInputStream(rs.getBytes("javaObject"));
					//ObjectInputStream ins = new ObjectInputStream(bais);
		            //String raw=rs.getString(6);
					/*Key key=generateKey();
					System.out.println(key);
					//byte[] key=Base64.getDecoder().decode(raw);
					//SecretKey skey=new SecretKeySpec(key,0,key.length,"AES");
					//System.out.println(skey);					
					//SecretKeySpec skeySpec = new SecretKeySpec(raw.getBytes(), "AES");
					Cipher cipher = Cipher.getInstance("AES");
					cipher.init(Cipher.DECRYPT_MODE, key);
					byte[] pas = Base64.getDecoder().decode(password);
					System.out.println(pas);
					byte[] decrypted = cipher.doFinal(pas);
					System.out.println(decrypted.toString());
					String decr=new String(decrypted);
					System.out.println(decr);*/
					//String dec=decrypt(password);
					AESenc aes=new AESenc();
					System.out.println(pf.getText());
					String dec=aes.decrypt1(pf.getText());
					System.out.println(dec);
					if(password.equals(dec))
					{
						JOptionPane.showMessageDialog(null,"Password Correct","Success",1);
						this.dispose();
						JFrame fr=new JFrame("Success");
						ImageIcon imageIcon=new ImageIcon("G:/Mega Project/Authentication/src/success.png");
						Image image = imageIcon.getImage(); // transform it 
						Image newimg = image.getScaledInstance(1500, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
						imageIcon = new ImageIcon(newimg);
						JLabel S=new JLabel(imageIcon);
						//S.setFont(new Font("SERIF",Font.PLAIN,100));
						//fr.setBackground(Color.magenta);
						fr.add(S);
						fr.setVisible(true);
						fr.setSize(1500,1500);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Password not Correct","alert",1);
					}
					
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please enter the correct password ","alert",1);				
			}
		}
		
	}
	public static String decrypt(String encryptedData) throws Exception 
    {
        Key key = generateKey();
        System.out.println(key);
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        System.out.println(decordedValue);
        byte[] decValue = c.doFinal(decordedValue);
        System.out.println(decValue);
        return new String(decValue);
    }
	private static Key generateKey() throws Exception {
        return new SecretKeySpec(keyValue, "AES");
    }

}
