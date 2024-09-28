import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class students extends login{
    static JPanel panel;
    static JPanel jpanel;
    static JLabel label;
    static JTextField name;
    static JTextField stid;
    static  JButton add;
    static JButton delete;
    static JButton search;


    public students(){
        //adding panels
        panel=new JPanel(new BorderLayout());
        panel.setBackground(Color.GRAY);


        jpanel=new JPanel( new FlowLayout());
        //panel.setLayout(new BoxLayout(jpanel,BoxLayout.Y_AXIS));
        jpanel.setBackground(Color.lightGray);
        panel.add(jpanel);


        //adding a display area
//        JTextArea text=new JTextArea();
//        text.setLineWrap(true);
//        text.setWrapStyleWord(true);
//        text.setEditable(false);
//
//        JScrollPane pane=new JScrollPane();
//        pane.add(text);
//        jpanel.add(pane);

        //adding top label

        label=new JLabel("STUDENTS ADMISSION");
        label.setBackground(Color.magenta);
        label.setForeground(Color.CYAN);
        label.setSize(new Dimension(30,10));
        label.setFont(new Font("MV Boli",Font.BOLD,40));
        jpanel.add(label);


        //adding text fields and buttons

        name=new JTextField(20);
        name.setFont(new Font("MV Boli",Font.BOLD,20));
        name.setBounds(100,350,100,100);
        name.setBackground(Color.WHITE);
        name.setForeground(Color.BLACK);
        jpanel.add(new JLabel("Name"));
        jpanel.add(name);

        stid=new JTextField(20);
        stid.setFont(new Font("MV Boli",Font.BOLD,20));
        stid.setForeground(Color.BLACK);
        stid.setBackground(Color.WHITE);
        jpanel.add(new JLabel("Student Admn"));
        jpanel.add(stid);

        add=new JButton("Add student");
        add.setFocusable(false);
        jpanel.add(add);
        add.addActionListener(new ActionListener() {
            @Override

            //sqls
            public void actionPerformed(ActionEvent e) {
                String n=name.getText();
                String id=stid.getText();
                addToDatabase(n,id);

                //data setters
                name.setText("");
                stid.setText("");
            }

            private void addToDatabase(String n, String id) {
                String url= "jdbc:mysql://localhost:3306/sms";
                String user= "root";
                String password="";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn= DriverManager.getConnection(url,user,password);
                   //System.out.println("connected");
                    Statement st=conn.createStatement();
                    String sql="INSERT INTO students (name,id)  values('"
                    +n+"','" +id +"')";
                    st.executeUpdate(sql);
                    conn.close();


                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        delete=new JButton("Delete");
        delete.setFocusable(false);
        jpanel.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n=name.getText();
                String id=stid.getText();

                //setters
                name.setText("");
                stid.setText("");
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
                    String Sql="DELETE FROM students WHERE name = ? AND id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(Sql);

                        pstmt.setString(1, n);
                        pstmt.setString(2, id);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Student file deleted ");

                        }else{
                            JOptionPane.showMessageDialog(null, "Student Doesn't Exist");
                        }
                        conn.close();

                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });



        search=new JButton("search");
        search.setFocusable(false);
        jpanel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String n=name.getText();
                String i=stid.getText();
                name.setText("");
                stid.setText("");

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");

                    String sql="SELECT * FROM students WHERE- name=? and id=? ";
                    PreparedStatement pstmt = con.prepareStatement(sql);


                        pstmt.setString(1, n);
                        pstmt.setString(2, i);
                        ResultSet rs = pstmt.executeQuery();  // Execute query

                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Record found: " + rs.getString("name") + ", " + rs.getString("id"));
                        } else {
                            JOptionPane.showMessageDialog(null, "  OOPs!!!! record not found.");
                        }
                        con.close();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });








        this.add(panel);
    }
}
