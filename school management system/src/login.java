import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class login extends JFrame{
   // static JFrame frame =new JFrame();
    static JPanel panel;
    static JLabel label;
    static JTextField user;
    static JTextField pass;
    static JButton login;
    public  login(){
        setTitle("School Management System");
        setSize(500,500);
        setVisible(true);

        //panels
        panel=new JPanel(new FlowLayout());

        panel.setBackground(Color.cyan);

//        //school name
        label=new JLabel("LOGIN");
       panel.add(label);


        user=new JTextField(20);
        user.setBackground(Color.white);
        user.setForeground(Color.black);
        user.setFont(new Font("Mv Boli",Font.BOLD,20));
        panel.add(new JLabel("Username"));
        panel.add(user);

        pass=new JTextField(20);
        pass.setBackground(Color.white);
        pass.setForeground(Color.black);
        pass.setFont(new Font("Mv Boli",Font.BOLD,20));
        panel.add(new JLabel("password"));
        panel.add(pass);

        login=new JButton("login");
        login.setFocusable(false);

        login.setBackground(Color.blue);
        panel.add(login);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



              // database connection
                String u= user.getText();
                String p=pass.getText();

                user.setText("");
                pass.setText("");
                try{
                    // database connection


                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
                    Statement st=conn.createStatement();
                    String sql= "select * from login";
                    ResultSet rs= st.executeQuery(sql);
                    while(rs.next()){
                        String username=rs.getString("username");
                        String password=rs.getString("password");
                        if (u.equals(username)&& p.equals(password)){
                            welcome welcome=new welcome();

                        }else {
                                JOptionPane.showMessageDialog(login,"username and password incorrect");}

                   }

                    conn.close();
                }

                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"error while establishing the connection");

               }
//


            }

        });











        //adding object to the frame
        this.add(panel);


    }
}
