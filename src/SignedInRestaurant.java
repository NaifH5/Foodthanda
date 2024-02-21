import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.regex.*;

import javax.sql.rowset.serial.SerialBlob;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;

public class SignedInRestaurant extends JFrame
{
	int foodID;
    JTable table, table2;
    JButton addImageButton;
    jButton b1, addButton, updateButton, removeButton, b5, b6;
    jTextField txt1, txt2;
    JLabel l1, l2, l3, l4, l5, l6;
    JPanel panel1, panel5, panel8, panel16, menuPanel, ordersPanel;
    jPanel panel2, panel3, panel4, panel6, panel7;
    JScrollPane sp, sp2;
    DefaultTableModel model, model2, model3;
    String serial, name, id, imagePath=null;
    ImageIcon icon4;

    public SignedInRestaurant(String email)
    {
        setSize(1300, 795);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setResizable(false);
        setTitle("FoodThanda");

        Database database = new Database();
        Database database2 = new Database();
        String RestaurantName = database.getRestaurantName(email);
        
        String path1 = "images\\addImageIcon.png";
        String path2 = "images\\defaultFoodIcon.png";
        String path3 = "images\\editImageIcon.png";

        Font Font_1 = new Font("Arial", Font.BOLD, 50);
        Font Font_2 = new Font("Arial", Font.BOLD, 20);
        Font Font_3 = new Font("Arial", Font.BOLD, 35);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 1300, 760);
        panel1.setBackground(Color.WHITE);
        add(panel1);
        
        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(430, 20, 835, 715);
        menuPanel.setBackground(new Color(247, 42, 129));
        panel1.add(menuPanel);
        
        ordersPanel = new JPanel();
        ordersPanel.setLayout(null);
        ordersPanel.setBounds(430, 20, 835, 715);
        ordersPanel.setBackground(new Color(247, 42, 129));
        ordersPanel.setVisible(false);
        panel1.add(ordersPanel);
        
        l1 = new JLabel("Your Menu");
        l1.setFont(Font_1);
        l1.setBounds(300, 5, 580, 95);
        l1.setForeground(Color.WHITE);
        menuPanel.add(l1);
        
        l5 = new JLabel("Pending orders");
        l5.setFont(Font_1);
        l5.setBounds(250, 5, 580, 95);
        l5.setForeground(Color.WHITE);
        ordersPanel.add(l5);

        l2 = new JLabel("Signed in as");
        l2.setFont(Font_2);
        l2.setBounds(30, 25, 580, 95);
        l2.setForeground(Color.WHITE);
        panel1.add(l2);

        l3 = new JLabel(RestaurantName);
        l3.setFont(Font_3);
        l3.setBounds(30, 55, 580, 95);
        l3.setForeground(Color.WHITE);
        panel1.add(l3);
        
        b1 = new jButton("Sign out");
		b1.setBounds(33, 143, 130, 50);
		b1.buttonSetBounds(55, 143, 80, 44);
		b1.fillRoundRect(124, 44, 50, 50);
		b1.setFont(Font_2);
		b1.add(panel1);
		
		l4 = new JLabel("Add or remove food from your menu");
        l4.setFont(Font_2);
        l4.setBounds(35, 210, 580, 95);
        l4.setForeground(Color.WHITE);
        panel1.add(l4);
        
        addButton = new jButton("Add");
        addButton.setBounds(143, 560, 130, 50);
        addButton.buttonSetBounds(165, 560, 80, 44);
        addButton.fillRoundRect(124, 44, 50, 50);
        addButton.setFont(Font_2);
        addButton.add(panel1);
        
        updateButton = new jButton("Update");
        updateButton.setBounds(143, 620, 130, 50);
        updateButton.buttonSetBounds(165, 620, 80, 44);
        updateButton.fillRoundRect(124, 44, 50, 50);
        updateButton.setFont(Font_2);
        updateButton.add(panel1);
        
        removeButton = new jButton("Remove");
        removeButton.setBounds(143, 680, 130, 50);
        removeButton.buttonSetBounds(165, 680, 80, 44);
        removeButton.fillRoundRect(124, 44, 50, 50);
        removeButton.setFont(Font_2);
        removeButton.add(panel1);
        
        ImageIcon icon2 = new ImageIcon(path1);
		Image newImage2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newImage2);
		
		addImageButton = new JButton(icon2);
		addImageButton.setBounds(320, 300, 50, 50);
		addImageButton.setBorder(null);
		addImageButton.setFocusPainted(false);
		addImageButton.setContentAreaFilled(false);
		addImageButton.setBackground(null);
		panel1.add(addImageButton);

		ImageIcon icon5 = new ImageIcon(path2);
		Image newImage5 = icon5.getImage().getScaledInstance(268, 134, Image.SCALE_SMOOTH);
		icon5 = new ImageIcon(newImage5);
		
		l6 = new JLabel(icon5);
		l6.setLayout(null);
		l6.setBounds(75, 293, 268, 134);
        panel1.add(l6);
        
        panel6 = new jPanel();
        panel6.setBounds(36, 293, 344, 134);
        panel6.setColor(new Color(247, 42, 129));
        panel6.fillRoundRect(344, 134, 50, 50);
        panel1.add(panel6);
        
        panel7 = new jPanel();
        panel7.setBounds(33, 290, 350, 140);
        panel7.setColor(Color.WHITE);
        panel7.fillRoundRect(350, 140, 50, 50);
        panel1.add(panel7);
        
        txt1 = new jTextField("Food name");
        txt1.setTextBounds(50, 451, 315, 33);
        txt1.setBounds(33, 450, 350, 35);
        txt1.fillRoundRect(350, 35, 40, 40);
        txt1.setFont(Font_2);
        txt1.add(panel1);
        
        txt2 = new jTextField("Price");
        txt2.setTextBounds(50, 501, 315, 33);
        txt2.setBounds(33, 500, 350, 35);
        txt2.fillRoundRect(350, 35, 40, 40);
        txt2.setFont(Font_2);
        txt2.add(panel1);
        
        panel2 = new jPanel();
        panel2.setBounds(10, 10, 400, 200);
        panel2.setColor(new Color(247, 42, 129));
        panel2.fillRoundRect(400, 200, 50, 50);
        panel1.add(panel2);

        panel3 = new jPanel();
        panel3.setBounds(10, 220, 400, 525);
        panel3.setColor(new Color(247, 42, 129));
        panel3.fillRoundRect(400, 525, 50, 50);
        panel1.add(panel3);

        panel5 = new JPanel();
        panel5.setBounds(7, 100, 820, 540);
        panel5.setBackground(new Color(247, 42, 129));
        menuPanel.add(panel5);
        
        panel16 = new JPanel();
        panel16.setBounds(7, 100, 820, 540);
        panel16.setBackground(new Color(247, 42, 129));
        ordersPanel.add(panel16);

        panel4 = new jPanel();
        panel4.setBounds(420, 10, 855, 735);
        panel4.setColor(new Color(247, 42, 129));
        panel4.fillRoundRect(855, 735, 50, 50);
        panel1.add(panel4);

        Object[][] data = new Object[0][4];
        String column_names[] = {" ", "ID", "Name", "Price"};
        model = new DefaultTableModel(data, column_names)
		{

			private static final long serialVersionUID = 1L;

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
			
			@Override
            public boolean isCellEditable(int row, int column)
			{
                return false;
            }
		};
		
		database.loadMenuTable(email, model);
        
        table = new JTable(model);
        table.setFont(Font_2);
        table.setPreferredScrollableViewportSize(new Dimension(810, 510));
        table.setRowHeight(100);
        table.setShowVerticalLines(false);
        table.setBackground(Color.WHITE);
        table.setForeground(new Color(247, 42, 129));
        table.setGridColor(new Color(247, 42, 129));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.setBorder(null);
        
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(centerRenderer);
        

        sp = new JScrollPane(table);
        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.getViewport().setBackground(new Color(247, 42, 129));
        panel5.add(sp);
        
        Object[][] data2 = new Object[0][4];
        String column_names2[] = {"ID", "Name", "Quantity", "Customer Name"};
        model2 = new DefaultTableModel(data2, column_names2);
        
        Object[][] data3 = new Object[0][5];
        String column_names3[] = {"Order ID", "Food ID", "Name", "Quantity", "Customer Name"};
        model3 = new DefaultTableModel(data3, column_names3);
        
        loadOrdersTable(database, database2, email);

        table2 = new JTable(model2);
        table2.setFont(Font_2);
        table2.setPreferredScrollableViewportSize(new Dimension(810, 510));
        table2.setRowHeight(40);
        table2.setShowVerticalLines(false);
        table2.setBackground(Color.WHITE);
        table2.setForeground(new Color(247, 42, 129));
        table2.setGridColor(new Color(247, 42, 129));
        
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table2.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table2.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table2.setBorder(null);
        
        header = table2.getTableHeader();
        header.setDefaultRenderer(centerRenderer);

        sp2 = new JScrollPane(table2);
        sp2.setBorder(BorderFactory.createEmptyBorder());
        sp2.getViewport().setBackground(new Color(247, 42, 129));
        panel16.add(sp2);
        
        b5 = new jButton("Pending Orders");
        b5.setBounds(630, 660, 190, 44);
        b5.buttonSetBounds(650, 660, 150, 44);
        b5.fillRoundRect(190, 44, 50, 50);
        b5.setFont(Font_2);
        b5.add(menuPanel);
        
        b6 = new jButton("Your menu");
        b6.setBounds(630, 660, 190, 44);
        b6.buttonSetBounds(650, 660, 150, 44);
        b6.fillRoundRect(190, 44, 50, 50);
        b6.setFont(Font_2);
        b6.add(ordersPanel);
        
        table.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int rowIndex = table.getSelectedRow();
                ImageIcon img = (ImageIcon) model.getValueAt(rowIndex, 0);
                int foodID = (int) model.getValueAt(rowIndex, 1);
                String Food_Name = (String) model.getValueAt(rowIndex, 2);
                String Food_Price = (String) model.getValueAt(rowIndex, 3);
                
                imagePath = database.getImagePath(foodID);
                
                if(imagePath==null)
                {
                	imagePath = path2;
                	img = new ImageIcon(imagePath);
                	Image img2 = img.getImage().getScaledInstance(268, 134, Image.SCALE_SMOOTH);
                	img = new ImageIcon(img2);
                	imagePath = null;
                }
                else
                {
                	imagePath = database.getImagePath(foodID);
                	img = new ImageIcon(imagePath);
                	Image img2 = img.getImage().getScaledInstance(268, 134, Image.SCALE_SMOOTH);
                	img = new ImageIcon(img2);
                	
                	File file = new File(imagePath);
		        	file.delete();
                }
                
                l6.setIcon(img);
                txt1.text.setText(Food_Name);
                txt2.text.setText(Food_Price);
            }
        });
        
        b1.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Home();
            }
        });
        
        addButton.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	menuPanel.setVisible(true);
            	ordersPanel.setVisible(false);
            	
                String foodName = txt1.text.getText();
                String price = txt2.text.getText();
                String priceRegex = "^\\d+$";

                if(!Pattern.matches(priceRegex, price))
                {
                	JOptionPane.showMessageDialog(null, "Price contains numbers only");
                }
                else
                {
                	int foodPrice = Integer.parseInt(price);
                    database.insertInFoodTable(foodName, foodPrice, email, imagePath);
                    database.loadMenuTable(email, model);
                }
            }
        });
        
        updateButton.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	menuPanel.setVisible(true);
            	ordersPanel.setVisible(false);
            	
                try
                {
                    int id = (int) model.getValueAt(table.getSelectedRow(), 1);
                    String foodName = txt1.text.getText();
                    String price = txt2.text.getText();
                    String priceRegex = "^\\d+$";

                    if(!Pattern.matches(priceRegex, price))
                    {
                    	JOptionPane.showMessageDialog(null, "Price contains numbers only");
                    }
                    else
                    {
                        database.updateRow(id, foodName, price, imagePath);
                        database.loadMenuTable(email, model);
                        
                        JOptionPane.showMessageDialog(null, "Updated");
                    }
                }
                catch(Exception exception)
                {
                    JOptionPane.showMessageDialog(null, "Select a row to update");
                }
            }
        });
        
        removeButton.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	menuPanel.setVisible(true);
            	ordersPanel.setVisible(false);
            	
                try
                {
                    int rowIndex = table.getSelectedRow();
                    int id = (int) model.getValueAt(rowIndex, 1);

                    database.deleteRow(id);
                    database.loadMenuTable(email, model);
                    
                    ImageIcon img = new ImageIcon(path2);
                    Image img2 = img.getImage().getScaledInstance(268, 134, Image.SCALE_SMOOTH);
                    img = new ImageIcon(img2);
                    
                    l6.setIcon(img);
                    txt1.text.setText("Food name");
                    txt2.text.setText("Price");
                    imagePath = null;
                }
                catch(Exception exception)
                {
                    JOptionPane.showMessageDialog(null, "Select a row to delete");
                }
            }
        });
        
        b5.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	loadOrdersTable(database, database2, email);
            	menuPanel.setVisible(false);
            	ordersPanel.setVisible(true);
            }
        });
        
        b6.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	ordersPanel.setVisible(false);
            	menuPanel.setVisible(true);
            }
        });
        
        addImageButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	try
            	{
            		JFileChooser fileChooser = new JFileChooser();
            		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
            		fileChooser.setFileFilter(filter);

            		int result = fileChooser.showOpenDialog(null);
            		
            		if(result == JFileChooser.APPROVE_OPTION)
            		{
            		    File selectedFile = fileChooser.getSelectedFile();
            		    imagePath = selectedFile.getPath();
            		    System.out.println(imagePath);

            		    icon4 = new ImageIcon(selectedFile.getPath());
            		    Image newImage4 = icon4.getImage().getScaledInstance(268, 134, Image.SCALE_SMOOTH);
            		    icon4 = new ImageIcon(newImage4);
            		    l6.setIcon(icon4);
            		    
            		    ImageIcon icon3 = new ImageIcon(path3);
                		Image newImage3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                		icon3 = new ImageIcon(newImage3);
                    	addImageButton.setIcon(icon3);
            		}
                }
            	catch(Exception e1)
            	{
                    e1.printStackTrace();
                }
            }
        });
        
        table2.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
            	int rowIndex = table2.getSelectedRow();
        		int Order_ID = (int) model3.getValueAt(rowIndex, 0);
        		
        		String[] options = {"Yes", "No"};
            	int result = JOptionPane.showOptionDialog(null, "Do you want to mark this order as 'delivered'?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            	
            	if(result==JOptionPane.YES_OPTION)
            	{
            		database.updateOrder(Order_ID);
            		model2.removeRow(rowIndex);
            		model3.removeRow(rowIndex);
            	}
            }
        });

        setVisible(true);
    }

    public void loadOrdersTable(Database database, Database database2, String email)
    {
    	model2.setRowCount(0);
    	model3.setRowCount(0);
    	database.setConnection();
        String q1 = "SELECT Orders.Order_ID, Orders.Food_ID, Orders.Quantity, Orders.Customer_Email FROM Food_Details,Orders WHERE Food_Details.Owner_Email='"+email+"' and Food_Details.Food_ID=Orders.Food_ID and Orders.Status='pending'";
        
        try
        {
            database.rs = database.st.executeQuery(q1);
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    	
    	try
    	{
			while(database.rs.next())
			{
				int Order_ID = database.rs.getInt(1);
			    int Food_ID = database.rs.getInt(2);
			    int Quantity = database.rs.getInt(3);
			    String customerEmail = database.rs.getString(4);
			    String foodName = database2.getFoodName(Food_ID);
			    String customerName = database2.getCustomerName(customerEmail);
			    
			    Object newRow[] = {Food_ID, foodName, Quantity, customerName};
			    Object newRow2[] = {Order_ID, Food_ID, foodName, Quantity, customerName};
			    
			    model2.addRow(newRow);
			    model3.addRow(newRow2);
			}
		}
    	catch(SQLException e)
    	{
			e.printStackTrace();
		}
    	
    	database.closeConnection();
    }
}
