import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome extends login{
    static JPanel outer;
    static JPanel inner;
    static JButton student;
    static JButton teachers;
    static  JButton  reportcards;
    static JButton resultentry;
    public welcome(){
        //setting up frame
//        setVisible(true);
//        setSize(500,400);

        //panels
        outer=new JPanel(new BorderLayout());
        outer.setBackground(Color.DARK_GRAY);
        panel.add(new JLabel("WELCOME"));

        inner=new JPanel();
       // inner.setLayout(new BoxLayout(inner,BoxLayout.Y_AXIS));
        inner.setBackground(Color.LIGHT_GRAY);
        outer.add(inner,BorderLayout.CENTER);

        //adding buttons

        student=new JButton("Student");
        student.setFocusable(true);
        inner.add(student);

        teachers=new JButton("teachers");
        teachers.setFocusable(true);
        inner.add(teachers);


        reportcards=new JButton("report cards");
        student.setFocusable(true);
        inner.add(reportcards);

        //adding action actionlisteners to the buttons
        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                students students=new students();

            }
        });

        teachers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teachers techer=new teachers();
            }
        });

        reportcards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reports report=new reports();
            }
        });





        resultentry=new JButton("Result entry");
        inner.add(resultentry);
        resultentry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result result=new result();
            }
        });






        this.add(outer);








    }
}
