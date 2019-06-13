import java.util.*;
import java.awt.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

import java.io.*;
import java.security.Key;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.*;
import java.awt.image.*;
public class Reg3 extends JFrame implements ActionListener
{
	JButton browse;
	JPanel card1,card2,pane;
	CardLayout c1;
	Container c;
	JButton clear;
	JButton crop;
	JLabel l1,l2,txt;
	JFileChooser cho;
	BufferedImage img;
	File file;
	String filename,s1;
	JButton b00,b01,b02,b10,b11,b12,b20,b21,b22;
	JButton submit,reset,ok;
	JPasswordField pf,cpf;
	JLabel pass,conpas;
	int flag=0;	
	String usr;
	byte[] skey = new byte[1000];
	String skeyString;
	static byte[] raw;
	String inputMessage,encryptedData;
	ImageIcon icon;
	static byte[] keyValue=new byte[] {'T','h','e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
	Reg3(String userid)
	{
		usr=userid;
		setTitle("Registration Layer 3");
		card1=new JPanel();
		card2=new JPanel();
		pane=new JPanel();
		c1=new CardLayout();
		txt=new JLabel("Registration Layer 3");
		txt.setBounds(50,0,800,100);
		txt.setFont(new Font("SERIF",Font.BOLD,50));
		txt.setForeground(Color.WHITE);
		pane.setLayout(c1);
		ImageIcon imageIcon=new ImageIcon("G:/Mega Project/Authentication/src/i1.jpeg");
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1500, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		l2=new JLabel(imageIcon);
		browse=new JButton("Browse");
		card1.setLayout(null);
		clear=new JButton("Clear");
		crop=new JButton("Crop");
		cho=new JFileChooser();
		l1=new JLabel();
		pass=new JLabel("Pattern");
		conpas=new JLabel("Confirm Pattern");
		pf=new JPasswordField(10);
		cpf=new JPasswordField(10);
		submit=new JButton("Submit");
		reset=new JButton("Reset");
		ok=new JButton("OK");
		b00=new JButton("b1");
		b01=new JButton("b2");
		b02=new JButton("b3");
		b10=new JButton("b4");
		b11=new JButton("b5");
		b12=new JButton("b6");
		b20=new JButton("b7");
		b21=new JButton("b8");
		b22=new JButton("b9");
		l1.setBounds(250, 100, 1000, 600);
		browse.setBounds(550, 50, 100, 40);
		clear.setBounds(625, 50, 100, 40);
		crop.setBounds(825, 50, 100, 40);
		b00.setBounds(100, 100, 250, 200);
		b01.setBounds(375, 100, 250, 200);
		b02.setBounds(650, 100, 250, 200);
		b10.setBounds(100, 325, 250, 200);
		b11.setBounds(375, 325, 250, 200);
		b12.setBounds(650, 325, 250, 200);
		b20.setBounds(100, 550, 250, 200);
		b21.setBounds(375, 550, 250, 200);
		b22.setBounds(650, 550, 250, 200);
		pass.setBounds(1000, 200, 250, 40);
		pf.setBounds(1000, 260, 250, 40);
		conpas.setBounds(1000, 380, 250, 40);
		cpf.setBounds(1000, 440, 250, 40);
		submit.setBounds(1000, 500, 125, 40);
		reset.setBounds(1150,500,100,40);
		ok.setBounds(1000, 320, 100, 40);
		pass.setForeground(Color.white);
		conpas.setForeground(Color.white);
		pass.setFont(new Font("SERIF",Font.PLAIN,30));
		conpas.setFont(new Font("SERIF",Font.PLAIN,30));
		submit.setFont(new Font("SERIF",Font.PLAIN,30));
		reset.setFont(new Font("SERIF",Font.PLAIN,30));
		ok.setFont(new Font("SERIF",Font.PLAIN,30));
		pf.setEditable(false);
		cpf.setEditable(false);
		pf.setText("");
		cpf.setText("");
		b00.setBorderPainted(false);
		b00.setFocusPainted(false);
		b00.setContentAreaFilled(false);
		b01.setBorderPainted(false);
		b01.setFocusPainted(false);
		b01.setContentAreaFilled(false);
		b02.setBorderPainted(false);
		b02.setFocusPainted(false);
		b02.setContentAreaFilled(false);
		b10.setBorderPainted(false);
		b10.setFocusPainted(false);
		b10.setContentAreaFilled(false);
		b11.setBorderPainted(false);
		b11.setFocusPainted(false);
		b11.setContentAreaFilled(false);
		b12.setBorderPainted(false);
		b12.setFocusPainted(false);
		b12.setContentAreaFilled(false);
		b20.setBorderPainted(false);
		b20.setFocusPainted(false);
		b20.setContentAreaFilled(false);
		b21.setBorderPainted(false);
		b21.setFocusPainted(false);
		b21.setContentAreaFilled(false);
		b22.setBorderPainted(false);
		b22.setFocusPainted(false);
		b22.setContentAreaFilled(false);
		card1.add(browse);
		card1.add(l1);
		card1.add(crop);
		card2.add(l2);
		card1.add(txt);
		card1.setOpaque(false);
		card2.setOpaque(true);
		pane.add(card1,"1");
		pane.add(card2,"2");
		c1.show(pane,"2");
		c=getContentPane();
		c.add(pane,BorderLayout.CENTER);
		card1.setVisible(true);
		card2.setVisible(true);
		browse.addActionListener(this);
		crop.addActionListener(this);
		clear.addActionListener(this);
		b00.addActionListener(this);
		b01.addActionListener(this);
		b02.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b20.addActionListener(this);
		b21.addActionListener(this);
		b22.addActionListener(this);
		submit.addActionListener(this);
		reset.addActionListener(this);
		ok.addActionListener(this);
		crop.setEnabled(false);
	}
	public static void main(String[] args)
	{
		Reg3 r=new Reg3("mamatha");
		r.setVisible(true);
		r.setSize(1500, 1000);
		r.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String s=arg0.getActionCommand();
		if(s=="Browse")
		{
			cho.showOpenDialog(null);
			file=cho.getSelectedFile();
			try
			{
				img=ImageIO.read(file);
				icon=new ImageIcon(img);
				l1.setIcon(icon);
				Dimension imageSize = new Dimension(1000,500);
                l1.setPreferredSize(imageSize);
				l1.revalidate();
				l1.repaint();
				crop.setEnabled(true);
			}
			catch(IOException e) {}
			
		}			
		if(s=="Crop")
		{
			browse.setVisible(false);
			crop.setVisible(false);
			clear.setVisible(false);
			l1.setVisible(false);
			int row=3,col=3;
			try 
			{
				int twidth=img.getWidth();
				int theight=img.getHeight();
				int ewidth=twidth/col;
				int eheight=theight/row;
				b00.setIcon(new ImageIcon(img.getSubimage(0, 0, ewidth, eheight)));
				b01.setIcon(new ImageIcon(img.getSubimage(ewidth, 0, ewidth, eheight)));
				b02.setIcon(new ImageIcon(img.getSubimage((ewidth*2), 0, ewidth, eheight)));
				b10.setIcon(new ImageIcon(img.getSubimage(0, eheight, ewidth, eheight)));
				b11.setIcon(new ImageIcon(img.getSubimage(ewidth, eheight, ewidth, eheight)));
				b12.setIcon(new ImageIcon(img.getSubimage((ewidth*2), eheight, ewidth, eheight)));
				b20.setIcon(new ImageIcon(img.getSubimage(0, (eheight*2), ewidth, eheight)));
				b21.setIcon(new ImageIcon(img.getSubimage(ewidth, (eheight*2), ewidth, eheight)));
				b22.setIcon(new ImageIcon(img.getSubimage((ewidth*2), (eheight*2), ewidth, eheight)));
				card1.add(b00);
				card1.add(b01);
				card1.add(b02);
				card1.add(b10);
				card1.add(b11);
				card1.add(b12);
				card1.add(b20);
				card1.add(b21);
				card1.add(b22);
				card1.add(cpf);
				card1.add(pf);
				card1.add(pass);
				card1.add(conpas);
				card1.add(submit);
				card1.add(reset);
				card1.add(ok);
			}
			catch(Exception e) {}
		}
		if(flag==0)
		{
		if(s=="b1")
		{
			b00.setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append("0").toString();
			pf.setText(s1);
		}
		if(s=="b2")
		{
			b01.setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append("1").toString();
			pf.setText(s1);
		}
		if(s=="b3")
		{
			b02.setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append("2").toString();
			pf.setText(s1);
		}
		if(s=="b4")
		{
			b10.setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append("3").toString();
			pf.setText(s1);
		}
		if(s=="b5")
		{
			b11.setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append("4").toString();
			pf.setText(s1);
		}
		if(s=="b6")
		{
			b12.setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append("5").toString();
			pf.setText(s1);
		}
		if(s=="b7")
		{
			b20.setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append("6").toString();
			pf.setText(s1);
		}
		if(s=="b8")
		{
			b21.setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append("7").toString();
			pf.setText(s1);
		}
		if(s=="b9")
		{
			b22.setVisible(false);
			s1=(new StringBuilder()).append(pf.getText()).append("8").toString();
			pf.setText(s1);
		}
		}
		if(s=="OK")
		{
			flag=1;
			b00.setVisible(true);
			b01.setVisible(true);
			b02.setVisible(true);
			b10.setVisible(true);
			b11.setVisible(true);
			b12.setVisible(true);
			b20.setVisible(true);
			b21.setVisible(true);
			b22.setVisible(true);
		}
		if(flag==1)
		{
			if(s=="b1")
			{
				b00.setVisible(false);
				s1=(new StringBuilder()).append(cpf.getText()).append("0").toString();
				cpf.setText(s1);
			}
			if(s=="b2")
			{
				b01.setVisible(false);
				s1=(new StringBuilder()).append(cpf.getText()).append("1").toString();
				cpf.setText(s1);
			}
			if(s=="b3")
			{
				b02.setVisible(false);
				s1=(new StringBuilder()).append(cpf.getText()).append("2").toString();
				cpf.setText(s1);
			}
			if(s=="b4")
			{
				b10.setVisible(false);
				s1=(new StringBuilder()).append(cpf.getText()).append("3").toString();
				cpf.setText(s1);
			}
			if(s=="b5")
			{
				b11.setVisible(false);
				s1=(new StringBuilder()).append(cpf.getText()).append("4").toString();
				cpf.setText(s1);
			}
			if(s=="b6")
			{
				b12.setVisible(false);
				s1=(new StringBuilder()).append(cpf.getText()).append("5").toString();
				cpf.setText(s1);
			}
			if(s=="b7")
			{
				b20.setVisible(false);
				s1=(new StringBuilder()).append(cpf.getText()).append("6").toString();
				cpf.setText(s1);
			}
			if(s=="b8")
			{
				b21.setVisible(false);
				s1=(new StringBuilder()).append(cpf.getText()).append("7").toString();
				cpf.setText(s1);
			}
			if(s=="b9")
			{
				b22.setVisible(false);
				s1=(new StringBuilder()).append(cpf.getText()).append("8").toString();
				cpf.setText(s1);
			}
		}
		if(s=="Reset")
		{
			flag=0;
			pf.setText("");
			cpf.setText("");
			b00.setVisible(true);
			b01.setVisible(true);
			b02.setVisible(true);
			b10.setVisible(true);
			b11.setVisible(true);
			b12.setVisible(true);
			b20.setVisible(true);
			b21.setVisible(true);
			b22.setVisible(true);			
		}
		if(s=="Submit")
		{
			if(pf.getText().equals(cpf.getText()) && pf.getText().length()==9)
			{
				try 
				{
					//generateSymmetricKey();
					// SecretKey secKey = getSecretEncryptionKey();
					inputMessage=pf.getText();
					//byte[] ibyte=inputMessage.getBytes();
					//String pas=encrypt(ibyte.toString());
					AESenc aes=new AESenc();
					String pas=aes.encrypt(inputMessage);
					//ByteArrayOutputStream bos = new ByteArrayOutputStream();
				    //ObjectOutputStream oos = new ObjectOutputStream(bos);
				    //oos.writeObject(aes);
				    //byte[] data=bos.toByteArray();
					FileInputStream input=new FileInputStream(file);					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/threelayerauthen","alekya", "alekya");
					PreparedStatement smt=(PreparedStatement) conn.prepareStatement("UPDATE usercredentials set pass3pass=?,pass3img=? where userid=?;");
					smt.setString(1,pas);
					smt.setBinaryStream(2, (InputStream)input,(int)file.length());
					//byte encode[]=secKey.getEncoded();
					//String key=Base64.getEncoder().encodeToString(encode);
					//smt.setObject(3,aes);
					smt.setString(3, usr);
					//System.out.println(secKey);
					smt.executeUpdate();
					//oos.flush();
				    //oos.close();
				    //bos.close();
					//System.out.println(sql);
				}
				catch(Exception e)
				{
					System.out.println("Exception : "+e.getMessage());
					e.printStackTrace();
				}
				this.dispose();
				//JFrame fr=new JFrame("Success");
				//JLabel S=new JLabel("SUCCESS");
				//S.setFont(new Font("SERIF",Font.PLAIN,100));
				//S.setBounds(700, 300, 500, 100);
				//fr.setBackground(Color.magenta);
				//fr.add(S);
				//fr.setVisible(true);
				//fr.setSize(1500,1500);
				Home h=new Home();
				h.setSize(1500,1000);
				h.setVisible(true);
				h.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please enter the correct password ","alert",1);				
			}
		}
		// TODO Auto-generated method stub
		
	}
	/*void generateSymmetricKey() 
	{
		try
		{
			Random r = new Random();
			int num = r.nextInt(10000);
			String knum = String.valueOf(num);
			byte[] knumb = knum.getBytes();
			skey=getRawKey(knumb);
			skeyString = new String(skey);
			System.out.println("AES Symmetric key = "+skeyString);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private static byte[] getRawKey(byte[] seed) throws Exception 
	{
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(seed);
		kgen.init(128, sr); // 192 and 256 bits may not be available
		SecretKey skey = kgen.generateKey();
		raw = skey.getEncoded();
		return raw;
	}
	public static SecretKey getSecretEncryptionKey() throws Exception
	{
		        KeyGenerator generator = KeyGenerator.getInstance("AES");
		        generator.init(256); // The AES key size in number of bits
		        SecretKey secKey = generator.generateKey();
		        return secKey;
	}*/
	 public static String encrypt(String plainText) throws Exception
	 {
		 		 Key key=generateKey();
		 		 System.out.println(key);
		         // AES defaults to AES/ECB/PKCS5Padding in Java 7
		         Cipher aesCipher = Cipher.getInstance("AES");
		         aesCipher.init(Cipher.ENCRYPT_MODE, key);
		         byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
		         System.out.println(byteCipherText);
		         return Base64.getEncoder().encodeToString(byteCipherText);
	 }
	 static Key generateKey()
	 {
		return new SecretKeySpec(keyValue,"AES"); 
	 }


	/*private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception 
	{
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(clear);
		return encrypted;
	}*/

}
