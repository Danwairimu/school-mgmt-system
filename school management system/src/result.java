import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static javax.swing.BoxLayout.Y_AXIS;

public class result extends login {
    static JPanel panel;
    static JTextField name;
    static JTextField id;
    static JTextField maths;
    static JTextField english;
    static JTextField physics;
    static JTextField kiswahili;
    static JTextField chemistry;
    static JTextField cre;
    static JTextField history;
    static JTextField biology;
    static JButton register;
    public result(){
        panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.DARK_GRAY);

        name=new JTextField(20);
        name.setBackground(Color.WHITE);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("seriff",Font.BOLD,20));
        panel.add(new JLabel("Name"));
        panel.add(name);



        id=new JTextField(20);
        id.setBackground(Color.WHITE);
        id.setForeground(Color.BLACK);
        id.setFont(new Font("seriff",Font.BOLD,20));
        panel.add(new JLabel("ID"));
        panel.add(id);


        maths=new JTextField(20);
        maths.setBackground(Color.WHITE);
        maths.setForeground(Color.BLACK);
        maths.setFont(new Font("seriff",Font.BOLD,20));
        panel.add(new JLabel("maths"));
        panel.add(maths);


        english=new JTextField(20);
        english.setBackground(Color.WHITE);
        english.setForeground(Color.BLACK);
        english.setFont(new Font("seriff",Font.BOLD,20));
        panel.add(new JLabel("english"));
        panel.add(english);

        physics=new JTextField(20);
        physics.setBackground(Color.WHITE);
        physics.setForeground(Color.BLACK);
        physics.setFont(new Font("seriff",Font.BOLD,20));
        panel.add(new JLabel("physics"));
        panel.add(physics);


        kiswahili=new JTextField(20);
        kiswahili.setBackground(Color.WHITE);
        kiswahili.setForeground(Color.BLACK);
        kiswahili.setFont(new Font("seriff",Font.BOLD,20));
        panel.add(new JLabel("Kiswahili"));
        panel.add(kiswahili);


        chemistry=new JTextField(20);
        chemistry.setBackground(Color.WHITE);
        chemistry.setForeground(Color.BLACK);
        chemistry.setFont(new Font("seriff",Font.BOLD,20));
        panel.add(new JLabel("chemistry"));
        panel.add(chemistry);


        cre=new JTextField(20);
        cre.setBackground(Color.WHITE);
        cre.setForeground(Color.BLACK);
        cre.setFont(new Font("seriff",Font.BOLD,20));
        panel.add(new JLabel("CRE"));
        panel.add(cre);


        history=new JTextField(20);
        history.setBackground(Color.WHITE);
        history.setForeground(Color.BLACK);
        history.setFont(new Font("seriff",Font.BOLD,20));
        panel.add(new JLabel("history"));
        panel.add(history);


        biology=new JTextField(20);
        biology.setBackground(Color.WHITE);
        biology.setForeground(Color.BLACK);
        biology.setFont(new Font("seriff",Font.BOLD,20));
        panel.add(new JLabel("biology"));
        panel.add(biology);

        register=new JButton("Register");
        panel.add(register);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n=name.getText();
                String i=id.getText();
                String m=maths.getText();
                String g=english.getText();
                String p=physics.getText();
                String k=kiswahili.getText();
                String c= chemistry.getText();
                String r=cre.getText();
                String h=history.getText();
                String b=biology.getText();



                name.setText("");
                id.setText("");
                maths.setText("");
                english.setText("");
                physics.setText("");
                kiswahili.setText("");
                chemistry.setText("");
                cre.setText("");
                history.setText("");
                biology.setText("");

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
                    Statement st=con.createStatement();
                    String sql="INSERT INTO rports(name,id,maths,english,physics,kiswahili,chemistry,cre,history,biology) values('"+n+"','"+i+"','"+m+"','"+g+"','"+p+"','"+k+"','"+c+"','"+r+"','"+h+"','"+b+"')";
                    st.executeQuery(sql);

                    con.close();
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"failed to connect to Datbase");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"failedto exeecute the sql");

                }
            }
        });



        this.add(panel);

    }
}
