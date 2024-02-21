import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class SignedInCustomer extends JFrame
{
	int total = 0;
    JTable table, table2, table3;
    jButton b1, orderButton, pastOrdersButton, menuButton, searchButton;
    JTextField txt1, txt2;
    jTextField txt3;
    JLabel l1, l2, l3, l4, l5, l6;
    JPanel panel1, panel5, panel14, menuPanel, pastOrdersPanel, panel6;
    JScrollPane sp, sp2, sp3;
    DefaultTableModel model, model2, model3, model4, model5;
    String serial, name, id;
    jPanel panel2, panel4, panel3;
    Map<Integer, Integer> map;
    
    public SignedInCustomer(String email)
    {
        setSize(1300, 795);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setResizable(false);
        setTitle("FoodThanda");

        map = new HashMap<>();
        Database database = new Database();
        String customerName = database.getCustomerName(email);

        Font Font_1 = new Font("Arial", Font.BOLD, 50);
        Font Font_2 = new Font("Arial", Font.BOLD, 20);
        Font Font_3 = new Font("Arial", Font.BOLD, 35);
        Font Font_4 = new Font("Arial", Font.BOLD, 17);

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
        
        pastOrdersPanel = new JPanel();
        pastOrdersPanel.setLayout(null);
        pastOrdersPanel.setBounds(430, 20, 835, 715);
        pastOrdersPanel.setBackground(new Color(247, 42, 129));
        panel1.add(pastOrdersPanel);
        
        l5 = new JLabel("Total: Tk " + String.valueOf(total));
        l5.setFont(Font_3);
        l5.setBounds(30, 660, 580, 95);
        l5.setForeground(Color.WHITE);
        panel1.add(l5);
        
        l6 = new JLabel("Your past orders");
        l6.setFont(Font_1);
        l6.setBounds(230, 5, 580, 95);
        l6.setForeground(Color.WHITE);
        pastOrdersPanel.add(l6);

        l1 = new JLabel("Order your food");
        l1.setFont(Font_1);
        l1.setBounds(230, 5, 580, 95);
        l1.setForeground(Color.WHITE);
        menuPanel.add(l1);

        l2 = new JLabel("Signed in as");
        l2.setFont(Font_2);
        l2.setBounds(30, 25, 580, 95);
        l2.setForeground(Color.WHITE);
        panel1.add(l2);

        l3 = new JLabel(customerName);
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
        
        orderButton = new jButton("Order");
        orderButton.setBounds(263, 683, 130, 50);
        orderButton.buttonSetBounds(285, 683, 80, 44);
        orderButton.fillRoundRect(124, 44, 50, 50);
        orderButton.setFont(Font_2);
        orderButton.add(panel1);
        
        pastOrdersButton = new jButton("Past orders");
        pastOrdersButton.setBounds(630, 660, 190, 44);
        pastOrdersButton.buttonSetBounds(650, 660, 150, 44);
        pastOrdersButton.fillRoundRect(190, 44, 50, 50);
        pastOrdersButton.setFont(Font_2);
        pastOrdersButton.add(menuPanel);
        
        searchButton = new jButton("Search");
        searchButton.setBounds(480, 660, 130, 44);
        searchButton.buttonSetBounds(500, 660, 90, 44);
        searchButton.fillRoundRect(130, 44, 50, 50);
        searchButton.setFont(Font_2);
        searchButton.add(menuPanel);
        
        txt3 = new jTextField("Search food");
        txt3.setTextBounds(230, 658, 273, 48);
        txt3.setBounds(205, 657, 325, 50);
        txt3.fillRoundRect(325, 50, 50, 50);
        txt3.setFont(Font_2);
        txt3.add(menuPanel);
        
        menuButton = new jButton("Check menu");
        menuButton.setBounds(630, 660, 190, 44);
        menuButton.buttonSetBounds(650, 660, 150, 44);
        menuButton.fillRoundRect(190, 44, 50, 50);
        menuButton.setFont(Font_2);
        menuButton.add(pastOrdersPanel);
        
        l4 = new JLabel("Your cart");
        l4.setFont(Font_3);
        l4.setBounds(130, 220, 580, 95);
        l4.setForeground(Color.WHITE);
        panel1.add(l4);
        
        panel2 = new jPanel();
        panel2.setBounds(10, 10, 400, 200);
        panel2.setColor(new Color(247, 42, 129));
        panel2.fillRoundRect(400, 200, 50, 50);
        panel1.add(panel2);
        
        panel14 = new JPanel();
        panel14.setBounds(20, 300, 380, 370);
        panel14.setBackground(new Color(247, 42, 129));
        panel1.add(panel14);

        panel3 = new jPanel();
        panel3.setBounds(10, 220, 400, 525);
        panel3.setColor(new Color(247, 42, 129));
        panel3.fillRoundRect(400, 525, 50, 50);
        panel1.add(panel3);

        panel5 = new JPanel();
        panel5.setBounds(440, 110, 820, 610);
        panel5.setBounds(7, 100, 820, 540);
        panel5.setBackground(new Color(247, 42, 129));
        menuPanel.add(panel5);
        
        panel6 = new JPanel();
        panel6.setBounds(440, 110, 820, 610);
        panel6.setBounds(7, 100, 820, 540);
        panel6.setBackground(new Color(247, 42, 129));
        pastOrdersPanel.add(panel6);

        panel4 = new jPanel();
        panel4.setBounds(420, 10, 855, 735);
        panel4.setColor(new Color(247, 42, 129));
        panel4.fillRoundRect(855, 735, 50, 50);
        panel1.add(panel4);
        
        Object[][] data = new Object[0][3];
        String column_names[] = {"Food_ID", "Food Name", "Price"};
        model = new DefaultTableModel(data, column_names);
        
        Object[][] data3 = new Object[0][4];
        String column_names3[] = {" ", "Name", "Price", "Restaurant"};
        model3 = new DefaultTableModel(data3, column_names3)
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
        
        Object[][] data4 = new Object[0][3];
        String column_names4[] = {"Food_ID", "Food Name", "Price"};
        model4 = new DefaultTableModel(data4, column_names4);
        
        database.getModel(model, model3);
        
        table = new JTable(model3);
        table.setFont(Font_2);
        table.setPreferredScrollableViewportSize(new Dimension(810, 510));
        table.setRowHeight(100);
        table.setShowVerticalLines(false);
        table.setBackground(Color.WHITE);
        table.setTableHeader(null);
        table.setForeground(new Color(247, 42, 129));
        table.setGridColor(new Color(247, 42, 129));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.setBorder(null);

        sp = new JScrollPane(table);
        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.getViewport().setBackground(new Color(247, 42, 129));
        panel5.add(sp);
        
        Object[][] data2 = new Object[0][2];
        String column_names2[] = {"Food Name", "Price"};
        model2 = new DefaultTableModel(data2, column_names2);
        
        table2 = new JTable(model2);
        table2.setFont(Font_4);
        table2.setPreferredScrollableViewportSize(new Dimension(350, 360));
        table2.setRowHeight(40);
        table2.setShowVerticalLines(false);
        table2.setTableHeader(null);
        table2.setBackground(Color.WHITE);
        table2.setForeground(new Color(247, 42, 129));
        table2.setGridColor(new Color(247, 42, 129));
        
        table2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table2.setBorder(null);

        sp2 = new JScrollPane(table2);
        sp2.setBorder(BorderFactory.createEmptyBorder());
        sp2.getViewport().setBackground(new Color(247, 42, 129));
        panel14.add(sp2);
        
        Object[][] data5 = new Object[0][3];
        String column_names5[] = {"Name", "Quantity", "Status"};
        model5 = new DefaultTableModel(data5, column_names5);
        database.getModel(model, model3);
        
        table3 = new JTable(model5);
        table3.setFont(Font_2);
        table3.setPreferredScrollableViewportSize(new Dimension(800, 510));
        table3.setRowHeight(40);
        table3.setShowVerticalLines(false);
        table3.setBackground(Color.WHITE);
        table3.setForeground(new Color(247, 42, 129));
        table3.setGridColor(new Color(247, 42, 129));
        
        table3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table3.setBorder(null);
        
        JTableHeader header = table3.getTableHeader();
        header.setDefaultRenderer(centerRenderer);

        sp3 = new JScrollPane(table3);
        sp3.setBorder(BorderFactory.createEmptyBorder());
        sp3.getViewport().setBackground(new Color(247, 42, 129));
        panel6.add(sp3);
        
        b1.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Home();
            }
        });
        
        orderButton.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	pastOrdersPanel.setVisible(false);
            	menuPanel.setVisible(true);
            	
            	if(total==0)
            		JOptionPane.showMessageDialog(null, "Cart is empty");
            	else
            	{
            		String[] options = {"Yes", "No"};
                	int result = JOptionPane.showOptionDialog(null, "Are you sure you want to order?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                	
                	if(result==JOptionPane.YES_OPTION)
                	{
                		database.addOrder(map, email);
                		
                		total = 0;
                		l5.setText("Total: Tk " + String.valueOf(total));
                		
                		map.clear();
                		model2.setRowCount(0);
                		JOptionPane.showMessageDialog(null, "Ordered");
                	}
            	}
            }
        });
        
        pastOrdersButton.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	model5.setRowCount(0);
            	database.getPastOrdersModel(model5, email);
            	menuPanel.setVisible(false);
            	pastOrdersPanel.setVisible(true);
            }
        });
        
        menuButton.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	model.setRowCount(0);
            	model3.setRowCount(0);
            	database.getModel(model, model3);
            	
            	pastOrdersPanel.setVisible(false);
            	menuPanel.setVisible(true);
            }
        });
        
        searchButton.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	String keyword = txt3.text.getText();
            	
            	model.setRowCount(0);
            	model3.setRowCount(0);
            	database.getSearchModel(model, model3, keyword);
            }
        });
        
        table.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
            	String[] options = {"Yes", "No"};
            	int result = JOptionPane.showOptionDialog(null, "Do you want to add this item to your cart?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            	
            	if(result==JOptionPane.YES_OPTION)
            	{
            		int rowIndex = table.getSelectedRow();
            		int Food_ID = (int) model.getValueAt(rowIndex, 0);
            		String Food_Name = (String) model3.getValueAt(rowIndex, 1);
                    int price = (int) model.getValueAt(rowIndex, 2);
                    
                    Object newRow[] = {Food_Name, price};
                    Object newRow4[] = {Food_ID, Food_Name, price};
                    
                    model2.addRow(newRow);
                    model4.addRow(newRow4);
                    
                    total += price;
                    l5.setText("Total: Tk " + String.valueOf(total));
                    
                    Integer count = map.get(Food_ID);
                    
                    if(count == null) map.put(Food_ID, 1);
                    else map.put(Food_ID, count+1);
            	}
            }
        });
        
        table2.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
            	String[] options = {"Yes", "No"};
            	int result = JOptionPane.showOptionDialog(null, "Do you want to remove this item?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            	
            	if(result==JOptionPane.YES_OPTION)
            	{
            		int rowIndex = table2.getSelectedRow();
            		int Food_ID = (int) model4.getValueAt(rowIndex, 0);
            		int price = (int) model2.getValueAt(rowIndex, 1);
            		
            		model2.removeRow(rowIndex);
            		model4.removeRow(rowIndex);
            		
            		total -= price;
                    l5.setText("Total: Tk " + String.valueOf(total));
                    
                    Integer count = map.get(Food_ID);
                    
                    if(count==1) map.put(Food_ID, null);
                    else map.put(Food_ID, count-1);
            	}
            }
        });
        
        setVisible(true);
    }
}
