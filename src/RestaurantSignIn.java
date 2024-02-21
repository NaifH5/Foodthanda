import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;

public class RestaurantSignIn extends JFrame
{
    JPanel mainPanel, panel1, loginPanel, registerPanel;
    jPanel panel2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JButton b3;
    jButton b1, b2, b4, b5;
    jTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;
    
    public RestaurantSignIn()
    {
		 setSize(1300, 795);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(3);
		 setLayout(null);
		 setResizable(false);
		 setTitle("FoodThanda");
		 
		 String path1 = "images\\Home_icon.png";
		 String path2 = "images\\Logo.png";
		 String path3 = "images\\Background.png";
		 
		 Font Font_1 = new Font("Arial", Font.BOLD, 45);
		 Font Font_2 = new Font("Arial", Font.BOLD, 23);
		 Font Font_3 = new Font("Arial", Font.BOLD, 14);
		 
		 Database database = new Database();
		 
		 mainPanel = new JPanel();
		 mainPanel.setLayout(null);
		 mainPanel.setBounds(0, 0, 1300, 760);
		 mainPanel.setBackground(new Color(247, 42, 129));
		 add(mainPanel);
		 
		 l9 = new JLabel("foodthanda");
		 l9.setFont(Font_1);
		 l9.setBounds(1015, 15, 300, 50);
		 l9.setForeground(new Color(247, 42, 129));
		 mainPanel.add(l9);
		 
		 loginPanel = new JPanel();
		 loginPanel.setLayout(null);
		 loginPanel.setBounds(45, 0, 480, 760);
		 loginPanel.setBackground(new Color(247, 42, 129));
		 loginPanel.setVisible(true);
		 mainPanel.add(loginPanel);
		 
		 ImageIcon icon3 = new ImageIcon(path1);
		 Image newImage3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		 icon3 = new ImageIcon(newImage3);
		 b3 = new JButton(icon3);
		 b3.setBounds(1210, 680, 50, 50);
		 b3.setBorder(null);
		 b3.setFocusPainted(false);
		 b3.setContentAreaFilled(false);
		 b3.setBackground(null);
		 mainPanel.add(b3);
		 
		 txt1 = new jTextField("Email");
		 txt1.setTextBounds(130,351,230,43);
		 txt1.setBounds(110, 350, 270, 45);
		 txt1.fillRoundRect(270, 45, 50, 50);
		 txt1.setFont(Font_3);
		 txt1.add(loginPanel);
		 
		 txt2 = new jTextField("Password");
		 txt2.setTextBounds(130,411,230,43);
		 txt2.setBounds(110, 410, 270, 45);
		 txt2.fillRoundRect(270, 45, 50, 50);
		 txt2.setFont(Font_3);
		 txt2.add(loginPanel);
		 
		 b1 = new jButton("Sign In");
		 b1.setBounds(167, 482, 156, 46);
		 b1.buttonSetBounds(185, 483, 120, 44);
		 b1.fillRoundRect(156, 46, 50, 50);
		 b1.setFont(Font_2);
		 b1.add(loginPanel);
		 
		 l4 = new JLabel("Don't have an account?");
		 l4.setFont(Font_3);
		 l4.setBounds(160, 595, 170, 50);
		 l4.setForeground(Color.WHITE);
		 loginPanel.add(l4);
		 
		 b2 = new jButton("Register");
		 b2.setBounds(182, 642, 126, 31);
		 b2.buttonSetBounds(195, 644, 100, 28);
		 b2.fillRoundRect(126, 31, 40, 40);
		 b2.setFont(Font_3);
		 b2.add(loginPanel);
		 
		 l3 = new JLabel("Sign In");
		 l3.setFont(Font_1);
		 l3.setBounds(170, 245, 150, 50);
		 l3.setForeground(Color.WHITE);
		 loginPanel.add(l3);
		 
		 registerPanel = new JPanel();
		 registerPanel.setLayout(null);
		 registerPanel.setBounds(45, 0, 480, 760);
		 registerPanel.setBackground(new Color(247, 42, 129));
		 registerPanel.setVisible(false);
		 mainPanel.add(registerPanel);
		 
		 ImageIcon icon4 = new ImageIcon(path2);
		 Image newImage4 = icon4.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		 icon4 = new ImageIcon(newImage4);
		 l7 = new JLabel(icon4);
		 l7.setLayout(null);
		 l7.setBounds(200, 60, 80, 80);
		 registerPanel.add(l7);
		 
		 l8 = new JLabel("Register");
		 l8.setFont(Font_2);
		 l8.setBounds(192, 140, 150, 50);
		 l8.setForeground(Color.WHITE);
		 registerPanel.add(l8);
		 
		 txt3 = new jTextField("Restaurant name");
		 txt3.setTextBounds(130, 201, 230, 43);
		 txt3.setBounds(110, 200, 270, 45);
		 txt3.fillRoundRect(270, 45, 50, 50);
		 txt3.setFont(Font_3);
		 txt3.add(registerPanel);
		 
		 txt4 = new jTextField("Email");
		 txt4.setTextBounds(130,256,230,43);
		 txt4.setBounds(110, 255, 270, 45);
		 txt4.fillRoundRect(270, 45, 50, 50);
		 txt4.setFont(Font_3);
		 txt4.add(registerPanel);
		 
		 txt5 = new jTextField("Phone number");
		 txt5.setTextBounds(130,311,230,43);
		 txt5.setBounds(110, 310, 270, 45);
		 txt5.fillRoundRect(270, 45, 50, 50);
		 txt5.setFont(Font_3);
		 txt5.add(registerPanel);
		 
		 txt6 = new jTextField("Address");
		 txt6.setTextBounds(130,366,230,43);
		 txt6.setBounds(110, 365, 270, 45);
		 txt6.fillRoundRect(270, 45, 50, 50);
		 txt6.setFont(Font_3);
		 txt6.add(registerPanel);
		 
		 txt7 = new jTextField("Password");
		 txt7.setTextBounds(130,421,230,43);
		 txt7.setBounds(110, 420, 270, 45);
		 txt7.fillRoundRect(270, 45, 50, 50);
		 txt7.setFont(Font_3);
		 txt7.add(registerPanel);
		 
		 txt8 = new jTextField("Repeat password");
		 txt8.setTextBounds(130,476,230,43);
		 txt8.setBounds(110, 475, 270, 45);
		 txt8.fillRoundRect(270, 45, 50, 50);
		 txt8.setFont(Font_3);
		 txt8.add(registerPanel);
		 
		 b4 = new jButton("Register");
		 b4.setBounds(167, 542, 156, 46);
		 b4.buttonSetBounds(185, 543, 120, 44);
		 b4.fillRoundRect(156, 46, 50, 50);
		 b4.setFont(Font_2);
		 b4.add(registerPanel);
		 
		 l6 = new JLabel("Already have an account?");
		 l6.setFont(Font_3);
		 l6.setBounds(155, 612, 190, 50);
		 l6.setForeground(Color.WHITE);
		 registerPanel.add(l6);
		 
		 b5 = new jButton("Sign in");
		 b5.setBounds(182, 657, 126, 31);
		 b5.buttonSetBounds(195, 659, 100, 28);
		 b5.fillRoundRect(126, 31, 40, 40);
		 b5.setFont(Font_3);
		 b5.add(registerPanel);
		 
		 ImageIcon icon2 = new ImageIcon(path2);
		 Image newImage2 = icon2.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
		 icon2 = new ImageIcon(newImage2);
		 l2 = new JLabel(icon2);
		 l2.setLayout(null);
		 l2.setBounds(190, 90, 110, 110);
		 loginPanel.add(l2);
		 
		 panel2 = new jPanel();
		 panel2.setBounds(0, 0, 600, 760);
		 panel2.setColor(new Color(247, 42, 129));
		 panel2.fillRoundRect(570, 760, 80, 80);
		 mainPanel.add(panel2);
		 
		 panel1 = new JPanel();
		 panel1.setLayout(null);
		 panel1.setBounds(530, 0, 755, 760);
		 mainPanel.add(panel1);
		
		 ImageIcon icon = new ImageIcon(path3);
		 Image newImage = icon.getImage().getScaledInstance(770, 770, Image.SCALE_DEFAULT);
		 icon = new ImageIcon(newImage);
		 l1 = new JLabel(icon);
		 l1.setLayout(null);
		 l1.setBounds(0, 0, 770, 770);
		 panel1.add(l1);
		 
		 b3.addActionListener(new ActionListener()
		 {
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 dispose();
				 new Home();
			 }
		 });
		 
		 b1.button.addActionListener(new ActionListener()
		 {
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				String email = txt1.text.getText();
				String password = txt2.text.getText();
				
				if(database.RestaurantSignIn(email, password)==true)
				{
					dispose();
					new SignedInRestaurant(email);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "incorrect email or password");
					System.out.println("Couldn't sign in");
				}
			 }
		 });
		 
		 b2.button.addActionListener(new ActionListener()
		 {
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 registerPanel.setVisible(true);
				 loginPanel.setVisible(false);
			 }
		 });
		 
		 b4.button.addActionListener(new ActionListener()
		 {
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 String restaurantName = txt3.text.getText();
				 String email = txt4.text.getText();
				 String phoneNumber = txt5.text.getText();
				 String address = txt6.text.getText();
				 String password = txt7.text.getText();
				 String confirmPassword = txt8.text.getText();
				 
				 String restaurantNameRegex = "^[a-zA-Z\\s]{1,20}$";
				 String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
				 String phoneNumberRegex = "^(\\+88)?01[2-9]\\d{8}$";
				 String passwordRegex = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+])).{6,20}$";
				 
				 if(!Pattern.matches(restaurantNameRegex, restaurantName))
					 JOptionPane.showMessageDialog(null, "Name should contain only alphabets and spaces and maximum of 20 characters");
				 else if(!Pattern.matches(emailRegex, email))
					 JOptionPane.showMessageDialog(null, "Invalid email");
				 else if(!Pattern.matches(phoneNumberRegex, phoneNumber))
					 JOptionPane.showMessageDialog(null, "Invalid phone number");
				 else if(!Pattern.matches(passwordRegex, password))
					 JOptionPane.showMessageDialog(null, "Password should have combination of uppercase, lowercase letters, numbers, special characters and minimum length of 6 characters");
				 else if(!Pattern.matches(password, confirmPassword))
					 JOptionPane.showMessageDialog(null, "Passwords do not match");
				 else
				 {
					if(database.getRestaurantEmail(email)==true)
					{
						database.restaurantRegister(restaurantName, email, phoneNumber, address, password);
						JOptionPane.showMessageDialog(null, "Registered");
						new SignedInRestaurant(email);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Email already exists");
					}
				 }
			 }
		 });
		 
		 b5.button.addActionListener(new ActionListener()
		 {
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 registerPanel.setVisible(false);
				 loginPanel.setVisible(true);
			 }
		 });
		
		 setVisible(true);
    }
}