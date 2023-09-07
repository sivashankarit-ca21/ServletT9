// Connect.java
 

package com.cslc.MainPackage;
import java.sql.*;

public class Connect {
    public ResultSet rs;
    public Connection con;

    public void getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3310/mysql", "root", "root");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void executeSelectQuery(String query) {
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void executeUpdateQuery(String query) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

// Controller.java

package com.cslc.MainPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
     public class Controller extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
        UserData ud=new UserData();
        ud.storeUserCredentials (req.getParameter("user_name"), req.getParameter("user_password"));  
        resp.getOutputStream().println("User Inserted");

}
 

}

//UserData.java


package com.cslc.MainPackage;

public class UserData {
    public void storeUserCredentials (String user_name, String user_password) {
         Connect con=new Connect();
         con.getConnection();
         String query="insert into test.user_credentials values (NULL, '"+user_name+"',sha("+user_password+"))";
         con.executeUpdateQuery (query);
         con.closeConnection();
    }
    public void viewUserCredentials() {
   
   }
}

//index.jsp


<html>
<body>
    <form action="controller.do" method="POST">
    <input type="text" name="user_name" >
    <input type="password" name="user_password">
    <input type="submit">
</form>
 </body>
 </html>


//data.jsp


<%@page import="com.cslc.MainPackage.Connect"%>

<html>
<body>
<h2>Hello Universe!</h2>
<%

   Connect con= new Connect();
   con.getConnection();
   con.executeSelectQuery("select user_name,user_password from test.user_credentials");

%>
<table border = "1">
   <tr>
            <th>User_Name</th>
            <th>User_Password</th
   </tr>

<%   while (con.rs.next()) {%>
      <tr>
                <td><%=con.rs.getString("user_name") %></td>
                <td><%=con.rs.getString("user_password") %></td>
   <%}%>
   <% con.closeConnection(); %>


 </tbody>
 </table>
</body>
</html>































































