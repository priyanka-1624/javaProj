package MyProjects.movieDatabase;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

public class CineverseViewer {
    private Connection con;
    private JTextField searchField;

    public static void main(String[] args) {
    new CineverseViewer().createAndShowGUI();
    }

    public void createAndShowGUI() {
        try {
            establishDatabaseConnection();

            JFrame frame = new JFrame("Cineverse");
            frame.setLayout(null);
            frame.setSize(400, 300);

            ImageIcon img=new ImageIcon("C:/Users/gouth/Downloads/icons8-film-camera-64.png");
            frame.setIconImage(img.getImage());

            Font myFont = new Font("Fantasy", Font.ITALIC, 20);

            JLabel lblTitle = new JLabel("Cineverse");
            lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
            lblTitle.setBounds(120, 10, 400, 30);
            frame.add(lblTitle);

            
            JButton viewTableButton = new JButton("View Table");
            viewTableButton.setFont(myFont);
            viewTableButton.setBounds(90, 60, 190, 30);
            viewTableButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    displayMovies();
                }
            });
            frame.add(viewTableButton);

            JLabel searchLabel = new JLabel("Search by:");
            searchLabel.setBounds(130, 110, 100, 25);
            searchLabel.setFont(myFont);
            frame.add(searchLabel);

            JComboBox<String> searchComboBox = new JComboBox<>();
            searchComboBox.addItem("Movie");
            searchComboBox.addItem("Actors");
            searchComboBox.addItem("Director");
            searchComboBox.addItem("Genre");
            searchComboBox.addItem("Released_year");
            searchComboBox.setFont(myFont);
            searchComboBox.setBounds(100, 135, 170, 30);
            frame.add(searchComboBox);

            searchField = new JTextField();
            searchField.setFont(myFont);
            searchField.setBounds(100, 165, 170, 50);
            frame.add(searchField);

            JButton searchButton = new JButton("Search");
            searchButton.setFont(myFont);
            searchButton.setBounds(130, 220, 100, 25);
            frame.add(searchButton);

            searchButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    searchMovies(searchField.getText(), (String) searchComboBox.getSelectedItem());
                }
            });

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    private void establishDatabaseConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/newdatabase";
            String user = "root";
            String pass = "Gowtami@1624";
            con = DriverManager.getConnection(url, user, pass);
            if (con != null)
                System.out.println("Successfully connected");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void searchMovies(String searchTerm, String searchCategory) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Cineverse");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Movie");
            model.addColumn("Actors");
            model.addColumn("Director");
            model.addColumn("Genre");
            model.addColumn("Released_year");

            boolean found = false;

            while (rs.next()) {
                boolean matches = false;
                switch (searchCategory) {
                    case "Movie":
                        matches = rs.getString("movie").equalsIgnoreCase(searchTerm);
                        break;
                    case "Actors":
                        matches = rs.getString("actors").equalsIgnoreCase(searchTerm);
                        break;
                    case "Director":
                        matches = rs.getString("director").equalsIgnoreCase(searchTerm);
                        break;
                    case "Genre":
                        matches = rs.getString("genre").equalsIgnoreCase(searchTerm);
                        break;
                    case "Released_year":
                        try {
                            int releaseYear = Integer.parseInt(searchTerm);
                            matches = rs.getInt("released_year") == releaseYear;
                        } catch (NumberFormatException ignored) {

                        }

                        break;
                }

                if (matches) {
                    found = true;
                    model.addRow(new Object[] {
                            rs.getString("Movie"),
                            rs.getString("Actors"),
                            rs.getString("Director"),
                            rs.getString("Genre"),
                            rs.getInt("Released_year")
                    });
                }
            }

            if (!found) {
                int option = JOptionPane.showConfirmDialog(null,
                        "The searched item is not available. Do you want to add it?", "Movie Not Found",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // Show add movie dialog
                    String Movie = JOptionPane.showInputDialog("Enter movie name:");
                    String Actors = JOptionPane.showInputDialog("Enter actor names:");
                    String Director = JOptionPane.showInputDialog("Enter director name:");
                    String Genre = JOptionPane.showInputDialog("Enter genre:");
                    String Released_year = JOptionPane.showInputDialog("Enter released year:");
                    int ReleasedYear = Integer.parseInt(Released_year);

                    addMovieToDatabase(Movie, Actors, Director, Genre, ReleasedYear);
                }
            } else {
                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);

                JFrame searchResultsFrame = new JFrame("Searched Results");
                searchResultsFrame.add(scrollPane);
                searchResultsFrame.setSize(600, 400);
                searchResultsFrame.setLocationRelativeTo(null); // Center the frame
                searchResultsFrame.setVisible(true);

            }
            searchField.setText("");
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error searching movies: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayMovies() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Cineverse");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Movie");
            model.addColumn("Actors");
            model.addColumn("Director");
            model.addColumn("Genre");
            model.addColumn("Released_year");

            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getString("Movie"),
                        rs.getString("Actors"),
                        rs.getString("Director"),
                        rs.getString("Genre"),
                        rs.getInt("Released_year")
                });
            }
            //String[] arr={"Movie","Actors","Director","Genre","Released_year"};
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JFrame tableFrame = new JFrame("Cineverse Table");
            tableFrame.add(scrollPane);
            tableFrame.setSize(800, 400);
            tableFrame.setLocationRelativeTo(null); // Center the frame
            tableFrame.setVisible(true);

            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error displaying movies: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addMovieToDatabase(String Movie, String Actors, String Director, String Genre, int Released_year) {
        try {
            String query = "INSERT INTO Cineverse (Movie, Actors, Director, Genre, Released_year) VALUES ('" + Movie
                    + "','" + Actors + "','" + Director + "','" + Genre + "'," + Released_year + ")";
            Statement statement = con.createStatement();
            int rowsInserted = statement.executeUpdate(query);
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Movie added successfully to the database", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add movie to the database", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error adding movie to the database: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
