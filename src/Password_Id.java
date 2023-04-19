import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;

public class Password_Id extends SignUp{
    HashMap<String,String> map = new HashMap<>();
    String user_name_ = "";
    String pass_word_ = "";
    String[] obj1;
    String[] obj2;
    public void toFetchDataFromDataBase()
    {


        String user_nameList = new String(); // string array to store username
        String pass_wordList = new String(); // String array to store passwords
        int counter = 0;

        String url = "jdbc:mysql://localhost:3306/SE_Project"; // replace "testdb" with your database name
        String username = "root"; // replace with your MySQL username
        String password = "kunn"; // replace with your MySQL password

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Connect to the database
            conn = DriverManager.getConnection(url, username, password);

            // Execute a SQL query
            stmt = conn.createStatement();
            String sql = "SELECT UserName, passwords from firstTable";
            rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                String user_name = rs.getString("UserName");
                user_name_ = user_name_ + " " + user_name;

                String pass_word = rs.getString("Passwords");
                pass_word_ = pass_word_ + " " + pass_word;
                counter = counter + 1;
//                System.out.println("UserName from the Data is: " + user_name);
//                System.out.println("Password from the Data is: " + pass_word);
            }
        } catch (SQLException e) {
//            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
//                e.printStackTrace();
            }

        }
//        System.out.println("This is the ending of the function.......");

        obj1 = user_name_.split(" ");


        obj2= pass_word_.split(" ");

    }

    Password_Id()
    {
        toFetchDataFromDataBase();
        for(int i=0; i<obj1.length; i++)
        {
            if( i == 0)
            {
                continue;
            }
            map.put(obj1[i], obj2[i]);

        }
        if(!usernamefield.getText().equals("") && !firstPassword.equals("")) {
            map.put(usernamefield.getText(), firstPassword);
        }
        System.out.println("List of UserNames: " + map.keySet() + "\nList of Passwords: " + map.values());


    }


    protected HashMap returnMap()
    {
        return map;
    }
}
