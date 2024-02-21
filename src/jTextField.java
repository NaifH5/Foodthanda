import java.awt.*;
import javax.swing.*;

public class jTextField
{
	JTextField text;
	jPanel panel;
	
	public jTextField(String s)
	{
		 text = new JTextField(s);
		 text.setForeground(new Color(154, 154, 154));
		 text.setBackground(Color.WHITE);
		 text.setBorder(null);
		 panel = new jPanel();
		 panel.setColor(Color.WHITE);
	}
	
	public void setTextBounds(int posX, int posY, int x, int y)
	{
		text.setBounds(posX, posY, x, y);
	}
	
	public void setBounds(int posX, int posY, int x, int y)
	{
		panel.setBounds(posX, posY, x, y);
	}
	
	public void fillRoundRect(int posX, int posY, int x, int y)
	{
		panel.fillRoundRect(posX, posY, x, y);
	}
	
	public void setFont(Font font)
	{
		text.setFont(font);
	}
	
	public void add(JPanel pan)
	{
		pan.add(text);
		pan.add(panel);
	}
}
