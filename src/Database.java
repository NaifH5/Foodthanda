import java.awt.Image;
import java.io.*;
import java.sql.*;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.table.*;

public class Database
{
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public PreparedStatement ps;
    
    String path1 = "C:\\Users\\Msi\\Desktop\\OOP Project\\Images\\";
    String path2 = "C:\\Users\\Msi\\Desktop\\OOP Project\\Images\\defaultFoodIcon.png";

    public void setConnection()
    {
        try
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch(ClassNotFoundException e)
            {
                e.printStackTrace();
            }

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodthanda", "root", "");
            st = con.createStatement();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e);
        }
        
        changePacketSize();
    }

    public String getRestaurantName(String email)
    {
    	setConnection();
        String result = null;

        try
        {
            String s1 = "SELECT Restaurant_Name FROM restaurant_details WHERE Email='" + email + "'";
            rs = st.executeQuery(s1);
            while(rs.next()) result = rs.getString(1);
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

        closeConnection();
        return result;
    }
    
    public String getCustomerName(String email)
    {
    	setConnection();
        String result = null;

        try
        {
            String s1 = "SELECT Customer_Name FROM customer_details WHERE Email='" + email + "'";
            rs = st.executeQuery(s1);

            if(rs.next()) result = rs.getString(1);
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

        closeConnection();
        return result;
    }

    public void closeConnection()
    {
        try
        {
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        try
        {
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void customerRegister(String customerName, String email, String phoneNumber, String address, String password)
    {
    	setConnection();
    	String Query = "INSERT INTO `customer_details`(`Customer_Name`, `Email`, `Phone_Number`, `Address`, `Password`) VALUES ('"+customerName+"','"+email+"','"+phoneNumber+"','"+address+"','"+password+"')";
    	
        try
        {
            st.executeUpdate(Query);
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e);
        }
        
        closeConnection();
    }
    
    public void restaurantRegister(String restaurantName, String email, String phoneNumber, String address, String password)
    {
    	setConnection();
    	String Query = "INSERT INTO `restaurant_details`(`Restaurant_Name`, `Email`, `Phone_Number`, `Address`, `Password`) VALUES ('"+restaurantName+"','"+email+"','"+phoneNumber+"','"+address+"','"+password+"')";
    	
        try
        {
            st.executeUpdate(Query);
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e);
        }
        
        closeConnection();
    }

    public boolean getRestaurantEmail(String email)
    {
    	setConnection();
        boolean possible = false;

        try
        {
            String s1 = "SELECT Email FROM restaurant_details WHERE Email='" + email + "'";
            rs = st.executeQuery(s1);

            if(!rs.next()) possible = true;
            else possible = false;
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

        closeConnection();
        return possible;
    }
    
    public boolean getCustomerEmail(String email)
    {
    	setConnection();
        boolean possible = false;

        try
        {
            String s1 = "SELECT Email FROM customer_details WHERE Email='" + email + "'";
            rs = st.executeQuery(s1);

            if(!rs.next()) possible = true;
            else possible = false;
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

        closeConnection();
        return possible;
    }

    public boolean RestaurantSignIn(String email, String password)
    {
    	setConnection();
        boolean possible = false;

        try
        {
            String s1 = "SELECT Password FROM restaurant_details WHERE Email='"+email+"'";
            rs = st.executeQuery(s1);

            while(rs.next())
            {
                if(rs.getString(1).equals(password)) possible = true;
                else possible = false;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error - " + e);
        }

        closeConnection();
        return possible;
    }
    
    public boolean CustomerSignIn(String email, String password)
    {
    	setConnection();
        boolean possible = false;

        try
        {
            String s1 = "SELECT Password FROM customer_details WHERE Email='"+email+"'";
            rs = st.executeQuery(s1);

            while(rs.next())
            {
                if(rs.getString(1).equals(password)) possible = true;
                else possible = false;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

        closeConnection();
        return possible;
    }

    public void insertInFoodTable(String Food_Name, int Food_Price, String Email, String imagePath)
    {
    	setConnection();
    	String s2 = "INSERT INTO `food_details`(`Food_Name`, `Food_Price`, `Owner_Email`, `Image`) VALUES (?, ?, ?, ?)";
    	
    	FileInputStream fis;
    	byte[] imageData = null;
    	
		try
		{
			if(imagePath!=null)
			{
				fis = new FileInputStream(imagePath);
				imageData = new byte[(fis.available())];
		    	fis.read(imageData);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
    	
    	try
    	{
			ps = con.prepareStatement(s2);
			ps.setString(1, Food_Name);
			ps.setInt(2, Food_Price);
			ps.setString(3, Email);
			
			if(imagePath==null) ps.setBytes(4, null);
			else ps.setBytes(4, imageData);
		}
    	catch(SQLException e)
    	{
			e.printStackTrace();
		}
    	
    	try
    	{
			ps.executeUpdate();
		}
    	catch(SQLException e)
    	{
			e.printStackTrace();
		}

        closeConnection();
    }

    public void deleteRow(int id)
    {
    	setConnection();
    	
        try
        {
            String s1 = "DELETE FROM `food_details` WHERE Food_ID=" + String.valueOf(id);
            st.executeUpdate(s1);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        closeConnection();
    }
    
    public void updateRow(int id, String foodName, String price, String imagePath)
    {
    	setConnection();
    	String s1;
    	
    	try
        {
    		s1 = "UPDATE `food_details` SET `Food_Name`=?,`Food_Price`=?, `Image`=? WHERE `Food_ID`=?";
    		
    		FileInputStream fis;
        	byte[] imageData = null;
        	
        	if(imagePath!=null)
        	{
        		try
        		{
        			fis = new FileInputStream(imagePath);
        			imageData = new byte[(fis.available())];
        	    	fis.read(imageData);
        		}
        		catch (FileNotFoundException e)
        		{
        			e.printStackTrace();
        		}
        		catch(IOException e)
        		{
        			e.printStackTrace();
        		}
        	}
    		
        	try
        	{
    			ps = con.prepareStatement(s1);
    			ps.setString(1, foodName);
    			ps.setInt(2, Integer.parseInt(price));
    			ps.setInt(4, id);
    			
    			if(imagePath==null) ps.setBytes(3, null);
    			else ps.setBytes(3, imageData);
    		}
        	catch(SQLException e)
        	{
    			e.printStackTrace();
    		}
    		
        	ps.executeUpdate();
        }
    	catch(SQLException e)
        {
            e.printStackTrace();
        }
    	
    	closeConnection();
    }
    
    public void getModel(DefaultTableModel model, DefaultTableModel model2)
    {
    	setConnection();
    	model.setRowCount(0);
    	model2.setRowCount(0);
    	String q1 = "SELECT Food_ID, Food_Name, Food_Price, Restaurant_Name, Image FROM food_details, restaurant_details where Owner_Email=Email";
    	
    	try
    	{
			ps = con.prepareStatement(q1);
	    	rs = ps.executeQuery();
		}
    	catch(SQLException e)
    	{
    		System.out.println("Error 1: " + e);
		}
    	
    	try
    	{
			while(rs.next())
			{
				int Food_ID = rs.getInt(1);
			    String Food_Name = rs.getString(2);
			    int Price = rs.getInt(3);
			    String restaurantName = rs.getString(4);
			    byte[] image = rs.getBytes(5);
			    OutputStream imageData;
			    ImageIcon icon;
			    String path;
			    
			    if(image!=null)
			    {
			    	path = path1+String.valueOf(Food_ID)+".png";
			    	
			    	try
					{
						imageData = new FileOutputStream(path);
						imageData.write(image);
					}
					catch(FileNotFoundException e)
					{
						e.printStackTrace();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
			    	
			    	icon = new ImageIcon(path);
			    }
			    else
			    {
			    	path = path2;
			    	icon = new ImageIcon(path);
			    }
				
			    Image scaled = icon.getImage().getScaledInstance(190, 90, Image.SCALE_SMOOTH);
		    	icon = new ImageIcon(scaled);
		    	
		    	if(image!=null)
			    {
			    	File file = new File(path);
		        	file.delete();
			    }
		    	
		    	Object newRow[] = {Food_ID, Food_Name, Price};
                Object newRow2[] = {icon, Food_Name, "Tk. "+String.valueOf(Price), restaurantName};
                model.addRow(newRow);
                model2.addRow(newRow2);
			}
		}
    	catch(SQLException e)
    	{
			System.out.println("Error 2: " + e);
		}
    	
    	closeConnection();
    }
    
    public void getSearchModel(DefaultTableModel model, DefaultTableModel model2, String keyword)
    {
    	setConnection();
    	model.setRowCount(0);
    	model2.setRowCount(0);
    	String q1 = "SELECT Food_ID, Food_Name, Food_Price, Restaurant_Name, Image FROM food_details, restaurant_details where Owner_Email=Email and Food_Name like '%"+keyword+"%'";
    	
    	try
    	{
			ps = con.prepareStatement(q1);
	    	rs = ps.executeQuery();
		}
    	catch(SQLException e)
    	{
    		System.out.println("Error 1: " + e);
		}
    	
    	try
    	{
			while(rs.next())
			{
				int Food_ID = rs.getInt(1);
			    String Food_Name = rs.getString(2);
			    int Price = rs.getInt(3);
			    String restaurantName = rs.getString(4);
			    byte[] image = rs.getBytes(5);
			    OutputStream imageData;
			    ImageIcon icon;
			    String path;
			    
			    if(image!=null)
			    {
			    	path = path1+String.valueOf(Food_ID)+".png";
			    	
			    	try
					{
						imageData = new FileOutputStream(path);
						imageData.write(image);
					}
					catch(FileNotFoundException e)
					{
						e.printStackTrace();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
			    	
			    	icon = new ImageIcon(path);
			    }
			    else
			    {
			    	path = path2;
			    	icon = new ImageIcon(path);
			    }
				
			    Image scaled = icon.getImage().getScaledInstance(190, 90, Image.SCALE_SMOOTH);
		    	icon = new ImageIcon(scaled);
		    	
		    	if(image!=null)
			    {
			    	File file = new File(path);
		        	file.delete();
			    }
		    	
		    	Object newRow[] = {Food_ID, Food_Name, Price};
                Object newRow2[] = {icon, Food_Name, "Tk. "+String.valueOf(Price), restaurantName};
                model.addRow(newRow);
                model2.addRow(newRow2);
			}
		}
    	catch(SQLException e)
    	{
			System.out.println("Error 2: " + e);
		}
    	
    	closeConnection();
    }
    
    public void addOrder(Map<Integer, Integer> map, String email)
    {
    	setConnection();
    	String query;
    	
    	for(Map.Entry<Integer, Integer> entry : map.entrySet())
    	{
            Integer food_ID = entry.getKey();
            Integer quantity = entry.getValue();
            
            query = "INSERT INTO `orders`(`Food_ID`, `Quantity`, `Customer_Email`, `Status`) VALUES ('"+food_ID+"','"+quantity+"','"+email+"', 'pending')";
            
            try
            {
    	    	st.executeUpdate(query);
            }
        	catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    	
    	closeConnection();
    }
    
    public String getFoodName(int Food_ID)
    {
    	setConnection();
    	String q1 = "SELECT `Food_Name` FROM `food_details` WHERE Food_ID=" + String.valueOf(Food_ID);
    	String Food_Name = null;
    	
    	try
        {
            rs = st.executeQuery(q1);
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    	
    	try
        {
            while(rs.next())
            {
                Food_Name = rs.getString(1);
            }
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    	
    	closeConnection();
    	return Food_Name;
    }
    
    public void updateOrder(int Order_ID)
    {
    	setConnection();
    	String q1 = "UPDATE `orders` SET `Status`='delivered' WHERE Order_ID=" + String.valueOf(Order_ID);
    	
    	try
        {
            st.executeUpdate(q1);
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    	
    	closeConnection();
    }
    
    public DefaultTableModel getPastOrdersModel(DefaultTableModel model, String email)
    {
    	setConnection();
    	String q1 = "SELECT Food_Details.Food_Name, Orders.Quantity, Orders.Status FROM Orders,Customer_Details, Food_Details WHERE Customer_Details.Email=Orders.Customer_Email and Orders.Food_ID=Food_Details.Food_ID and Customer_Details.Email='"+email+"'";
    	
    	try
        {
            rs = st.executeQuery(q1);
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    	
    	try
        {
            while(rs.next())
            {
            	String foodName = rs.getString(1);
            	int quantity = rs.getInt(2);
            	String status = rs.getString(3);
            	
                Object newRow[] = {foodName, quantity, status};
                model.addRow(newRow);
            }
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    	
    	closeConnection();
    	return model;
    }
    
    public String getImageType(int foodID)
    {
    	setConnection();
        String result = null;

        try
        {
            String s1 = "SELECT Image_Type FROM food_details WHERE Food_ID='"+foodID+"'";
            rs = st.executeQuery(s1);

            if(rs.next()) result = rs.getString(1);
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

        closeConnection();
        return result;
    }
    
    public void loadMenuTable(String email, DefaultTableModel model)
    {
    	setConnection();
    	model.setRowCount(0);
    	String q1 = "SELECT `Food_ID`, `Food_Name`, `Food_Price`, `Image` FROM food_details WHERE Owner_Email=?";
    	
    	try
    	{
			ps = con.prepareStatement(q1);
			ps.setString(1, email);
	    	rs = ps.executeQuery();
		}
    	catch(SQLException e)
    	{
    		System.out.println("Error 1: " + e);
		}
    	
    	try
    	{
			while(rs.next())
			{
				int Food_ID = rs.getInt(1);
			    String Food_Name = rs.getString(2);
			    String Price = rs.getString(3);
			    byte[] image = rs.getBytes(4);
			    OutputStream imageData;
			    ImageIcon icon;
			    String path;
			    
			    if(image!=null)
			    {
			    	path = path1+String.valueOf(Food_ID)+".png";
			    	
			    	try
					{
						imageData = new FileOutputStream(path);
						imageData.write(image);
					}
					catch(FileNotFoundException e)
					{
						e.printStackTrace();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
			    	
			    	icon = new ImageIcon(path);
			    }
			    else
			    {
			    	path = path2;
			    	icon = new ImageIcon(path);
			    }
				
			    Image scaled = icon.getImage().getScaledInstance(190, 90, Image.SCALE_SMOOTH);
		    	icon = new ImageIcon(scaled);
		    	
		    	if(image!=null)
			    {
			    	File file = new File(path);
		        	file.delete();
			    }
		    	
		    	Object newRow[] = {icon, Food_ID, Food_Name, Price};
			    model.addRow(newRow);
			}
		}
    	catch(SQLException e)
    	{
			System.out.println("Error 2: " + e);
		}
    	
    	closeConnection();
    }
    
    public String getImagePath(int foodID)
    {
    	setConnection();
    	String q1 = "SELECT `Food_ID`, `Image` FROM food_details WHERE Food_ID=?";
    	String path = null;
    	
    	try
    	{
			ps = con.prepareStatement(q1);
			ps.setInt(1, foodID);
	    	rs = ps.executeQuery();
		}
    	catch(SQLException e)
    	{
    		System.out.println("Error 1: " + e);
		}
    	
    	try
    	{
			while(rs.next())
			{
				int Food_ID = rs.getInt(1);
			    byte[] image = rs.getBytes(2);
			    OutputStream imageData;
			    
			    if(image!=null)
			    {
			    	try
					{
			    		path = path1+String.valueOf(Food_ID)+".png";
						imageData = new FileOutputStream(path);
						imageData.write(image);
					}
					catch(FileNotFoundException e)
					{
						e.printStackTrace();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
			    }
			}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
    	return path;
    }
    
    public void changePacketSize()
    {
    	String s1 = "set global max_allowed_packet = 1024*1024*3";
    	
    	try
        {
            st.executeUpdate(s1);
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }
}