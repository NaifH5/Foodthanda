import java.awt.*;
import javax.swing.*;

public class jButton
{
	JButton button;
	jPanel panel1, panel2;
	
	public jButton(String s)
	{
		button = new JButton(s);
		panel1 = new jPanel();
		panel2 = new jPanel();
        
		button.setFocusPainted(false);
		button.setBackground(new Color(247, 42, 129));
		button.setForeground(Color.WHITE);
		button.setBorder(null);

        panel1.setColor(new Color(247, 42, 129));
        panel2.setColor(Color.WHITE);
	}
	
	public void setBounds(int posX, int posY, int x, int y)
	{
		panel1.setBounds(posX, posY, x, y);
		panel2.setBounds(posX-3, posY-3, x+6, y+6);
	}
	
	public void buttonSetBounds(int posX, int posY, int x, int y)
	{
		button.setBounds(posX, posY, x, y);
	}
	
	public void fillRoundRect(int posX, int posY, int x, int y)
	{
		panel1.fillRoundRect(posX, posY, x, y);
		panel2.fillRoundRect(posX+6, posY+6, x, y);
	}
	
	public void setFont(Font font)
	{
		button.setFont(font);
	}
	
	public void add(JPanel jp)
	{
		jp.add(button);
		jp.add(panel1);
		jp.add(panel2);
	}
}
