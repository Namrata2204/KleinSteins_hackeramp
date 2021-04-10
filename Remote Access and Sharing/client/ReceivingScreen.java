import java.io.ObjectInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.io.IOException;
import java.io.ByteArrayInputStream;

class ReceivingScreen extends Thread
{
	private ObjectInputStream = null;
	private JPanel cPanel = null;
	private boolean continueLoop= true;
	InputStream oin=null;
	Image image1 =null;
	
	public ReceivingScreen(InputStream in, JPanel p)
	{
		oin=in;
		cPanel=p;
		start();
	}
	public void run()
	{
		try
		{
		while(continueLoop)
		{
			byte[] = new byte[1024*1024];
			int count =0;
			do
			{
				count+=cin.read(bytes,count,length-count);
			}while(count >4 && bytes[count-2]==(bytes)-1 && bytes[count-1]==(byte)-39);
			
			image1 = ImageIO.read(new ByteArrayInputStream(bytes));
			image1 = image1.getScaledInstance(cPanel.getWidth, cPanel.getHeight,Image.SCALE_FAST);
			
			Graphics graphics = cPanel.Graphics();
			graphics.drawImage(image1,0 , 0,cPanel.getWidth,cPanel.getHeight,cPanel);
	
		}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}