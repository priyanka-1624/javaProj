package MyProjects.AuthorBooksProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class ComboBox {
    public static void main(String[] args) {
        JFrame f = new JFrame("Author and Books");
        f.setSize(500, 500);
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        f.setLayout(null);

        Font myFont = new Font("Fantasy", Font.ITALIC, 25);
        try {
            String Url = "jdbc:mysql://localhost:3306/newdatabase";
            String User = "root";
            String Passwd = "Gowtami@1624";
            Connection con = DriverManager.getConnection(Url, User, Passwd);
            if (con != null)
                System.out.println("Successfully Connected");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select distinct(author) from Book_details");

            JComboBox box = new JComboBox<>();

            while (rs.next()) {
                String val = rs.getString(1);
                box.addItem(val);
            }
            box.setSelectedItem(null);
            box.setBackground(Color.white);
            box.setForeground(Color.BLACK);
            box.setFont(myFont);
            box.setBounds(150, 100, 200, 50);
            f.add(box);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Textarea
            JTextArea l1 = new JTextArea();

            box.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String author1 = (String) box.getSelectedItem();
                    
                    try {
                        ResultSet rs = st.executeQuery("select title from Book_details where author='" + author1 + "'");
                        String title="";
                        while (rs.next()) {
                         title+=rs.getString(1)+"\n";
                        }
                        l1.setText(title);
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
            });
            l1.setFont(new Font("Fantasy", Font.BOLD, 15));
            l1.setBounds(150, 170, 200, 100);
            l1.setBackground(Color.WHITE);
            l1.setOpaque(true);
            l1.setEnabled(false);//to make the field uneditable
            l1.setForeground(Color.BLACK);
            f.add(l1);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
