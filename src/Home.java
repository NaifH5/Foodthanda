import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame
{
    JPanel panel1;
    jPanel panel3, panel2;
    JLabel l1, l2, l3;
    JButton b1, b2;

    public Home()
    {
        setSize(1300, 795);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setResizable(false);
        setTitle("FoodThanda");
        
        String path1 = "images\\Logo.png";

        Font Font_1 = new Font("Arial", Font.BOLD, 106);
        Font Font_2 = new Font("Arial", Font.BOLD, 27);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 1300, 760);
        panel1.setBackground(new Color(247, 42, 129));
        add(panel1);

        l1 = new JLabel("foodthanda");
        l1.setFont(Font_1);
        l1.setBounds(350, 320, 580, 95);
        l1.setForeground(Color.WHITE);
        panel1.add(l1);

        ImageIcon icon = new ImageIcon(path1);
        Image newImage = icon.getImage().getScaledInstance(185, 185, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        l2 = new JLabel(icon);
        l2.setLayout(null);
        l2.setBounds(550, 120, 185, 185);
        panel1.add(l2);

        b1 = new JButton("Order Food");
        b1.setBounds(420, 522, 160, 37);
        b1.setFont(Font_2);
        b1.setFocusPainted(false);
        b1.setBackground(new Color(247, 42, 129));
        b1.setForeground(Color.WHITE);
        b1.setBorder(null);
        panel1.add(b1);

        b2 = new JButton("Manage Restaurant");
        b2.setBounds(600, 523, 260, 35);
        b2.setFont(Font_2);
        b2.setFocusPainted(false);
        b2.setForeground(new Color(247, 42, 129));
        b2.setBackground(Color.WHITE);
        b2.setBorder(null);
        panel1.add(b2);

        panel3 = new jPanel();
        panel3.setBounds(405, 520, 460, 50);
        panel3.setColor(new Color(247, 42, 129));
        panel3.fillRoundRect(190, 40, 40, 40);
        panel1.add(panel3);

        panel2 = new jPanel();
        panel2.setBounds(400, 515, 500, 50);
        panel2.setColor(Color.WHITE);
        panel2.fillRoundRect(475, 50, 50, 50);
        panel1.add(panel2);

        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new CustomerSignIn();
            }
        });

        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new RestaurantSignIn();
            }
        });

        setVisible(true);
    }
}