import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


class Authentication extends JFrame implements ActionListener
{
	private Socket cSocket =null;
	DataOutputStream passchk=null;
	DataInputStream verification=null;
	String verify="";
	JButton submit;
	JPanel panel;
	JLabel label;
	JLabel label1;
	String width="",height="";
	JTextField text1;
	Authentication(Socket cSocket)
	{
		label1=new JLabel();
		label1.setText("Password");
		text1=new JTextField(15);
		this.cSocket=cSocket;
		label=new JLabel();
		label.setText("");
		this.setLayout(new BorderLayout());
		submit = new JButton("Submit");
		panel = new JPanel(new GridLayout(2,1));
		panel.add(label1);
		panel.add(text1);
		panel.add(label);
		panel.add(submit);
		add(panel,BorderLayout.CENTER);
		submit.addActionListener(this);
		setTitle("Login Form");
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String value1 =text1.getText();
		try
		{
			passchk= new DataOutputStream(cSocket.getOutputStream());
			verification = new DataInputStream(cSocket.getInputStream());
			verify = verification.readUTF();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		if (verify.equals("valid"))
		{
			try
			{
				width=verification.readUTF();
				height=verification.readUTF();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			CreateFrame abc =new CreateFrame(cSocket,width,height);
			dispose();
		}
		else
		{
			System.out.println("Plese enter valid Password");
			JOptionPane.showMessageDialog(this,"Password is incorrect","Error",JOptionPane.ERROR_MESSAGE);
			dispose();
		}
	}
}