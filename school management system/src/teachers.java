import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;

public class teachers extends login{
    static JPanel pane;
    static JPanel teachers;
    static JLabel teach;
    static JTextField name;
    static JTextField id;
    static JButton hire;
    static JButton fire;
    static JButton find;


    public  teachers(){
        //panel
        pane=new JPanel(new BorderLayout());
        pane.setBackground(Color.GRAY);

        teachers=new JPanel( );
        teachers.setBackground(Color.GRAY);
        pane.add(teachers);

        teach=new JLabel("Teachers Center");
        teach.setForeground(Color.BLACK);
        teach.setForeground(Color.BLUE);
        teach.setFont(new Font("MV Boli",Font.BOLD,20));
        teachers.add(teach);





        //Jtextfield
        name=new JTextField(20);
        name.setFont(new Font("MV Boli",Font.BOLD,20));
        name.setBackground(Color.WHITE);
        name.setForeground(Color.BLACK);
        teachers.add(new JLabel("name"));
        teachers.add(name);

        id=new JTextField(20);
        id.setFont(new Font("MV Boli",Font.BOLD,20));
        id.setBackground(Color.WHITE);
        id.setForeground(Color.BLACK);
        teachers.add(new JLabel("id"));
        teachers.add(id);

        //buttons

        hire=new JButton("Hire");
        hire.setFocusable(false);
        teachers.add(hire);
        hire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n=name.getText();
                String i=id.getText();
                name.setText("");
                id.setText("");
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
                    Statement st=conn.createStatement();
                    String sql="INSERT into teacher (name,id)  values('"+n+"' ,'"+i+"')";
                   int rs=st.executeUpdate(sql);
                   if(rs>0){
                       JOptionPane.showMessageDialog(null,"teacher hired");
                   }else{
                       JOptionPane.showMessageDialog(null,"failed to hire the teacher");
                   }

                    conn.close();

                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        fire=new JButton("Fire");
        fire.setFocusable(false);
        teachers.add(fire);
        fire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n=name.getText();
                String i=id.getText();
                name.setText("");
                id.setText("");
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
                    String sql="DELETE FROM teacher WHERE name=? and Id=?";
                    PreparedStatement stmt= conn.prepareStatement(sql);
                    stmt.setString(1, n);
                    stmt.setString(2, i);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Teacher Fired ");

                    }else{
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                    conn.close();


                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        find=new JButton("Find");
        find.setFocusable(false);
        teachers.add(find);
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n=name.getText();
                String i=id.getText();
                name.setText("");
                id.setText("");
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










        this.add(pane);

    }
}
