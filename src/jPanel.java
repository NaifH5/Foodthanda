import java.awt.*;
import javax.swing.*;

public class jPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Color newColor;
	private int x, y, arcX, arcY;
	
	public void setColor(Color newColor)
	{
		this.newColor = newColor;
	}
	
	public void fillRoundRect(int x, int y, int arcX, int arcY)
	{
		this.x = x;
		this.y = y;
		this.arcX = arcX;
		this.arcY = arcY;
	}
	
	@Override
    public void paint(Graphics g)
    {
        g.setColor(newColor);
        g.fillRoundRect(0, 0, x, y, arcX, arcY);
    }
}
