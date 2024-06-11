package MyProjects.movieDatabase;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.sql.*;

public class Cineverse {
    public static void main(String[] args) {
        try {
            String url="jdbc:mysql://localhost:3306/newdatabase";
            String user="root";
            String pass="Gowtami@1624";

            Connection con = DriverManager.getConnection(url, user, pass);
            if(con!=null) System.out.println("Successfully connected");

            //create a statement object
            Statement st=con.createStatement();
            Scanner sc=new Scanner(System.in);
           // st.executeUpdate("create table Cineverse(Movie varchar(100), Actors varchar(200), Director varchar(100), Genre varchar(100), Released_year int)");
            System.out.println("How many insertions: ");
            int n=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                String movie=JOptionPane.showInputDialog("Enter movie name:");
                String actors=JOptionPane.showInputDialog("Enter actor names (comma separated):");
                String director=JOptionPane.showInputDialog("Enter director name:");
                String genre=JOptionPane.showInputDialog("Enter genre:");
                int Released_year=Integer.parseInt(JOptionPane.showInputDialog("released year:"));
                String query="insert into Cineverse values('"+movie+"','"+actors+"','"+director+"','"+genre+"',"+Released_year+")";
                st.executeUpdate(query);
            }

            
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}

