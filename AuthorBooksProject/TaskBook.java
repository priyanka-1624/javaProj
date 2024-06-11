package MyProjects.AuthorBooksProject;
import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class TaskBook {
    public static void main(String[] args) {
        //1.Connecting to the data base
        //URL,Username,password
        
        try{
            String Url="jdbc:mysql://localhost:3306/newdatabase";
            String User="root";
            String Passwd="Gowtami@1624";
            Connection con=DriverManager.getConnection(Url,User,Passwd);
            if(con!=null) System.out.println("Successfully connected");
            Statement st=con.createStatement();
           st.executeUpdate("create table Book_details(id int,title varchar(30),author varchar(20),price int,genre varchar(40))");
            Scanner sc=new Scanner(System.in);
            System.out.println("How many insertions:");
            int n=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                String id=JOptionPane.showInputDialog("Enter id of Book"+(i));
                String title=JOptionPane.showInputDialog("Enter title of book"+(i));
                String author=JOptionPane.showInputDialog("Enter author of book"+(i));
                String price=JOptionPane.showInputDialog("Enter price of book"+(i));
                String genre=JOptionPane.showInputDialog("Enter genre of book"+(i));
                String query="insert into Book_details values(" +id+", '" + title + "', '"+ author +"'," +price+ ",'" +genre+"')";
                st.executeUpdate(query);

            }
        }
        catch(SQLException e){
                System.out.println(e);
        }
        
    }
}


