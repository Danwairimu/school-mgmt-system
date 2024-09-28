import javax.swing.*;
import java.awt.*;

public class reports extends login{
    static JPanel panel;
    static JPanel pane;
    static JPanel down;
    static JTextField name;
    static JTextField id;
    static JLabel label;
    static JButton report;
    static JButton button;


    public reports(){
        //adding panels
        panel=new JPanel(new BorderLayout());
        panel.setBackground(Color.magenta);

        pane=new JPanel(new FlowLayout());
        pane.setBackground(Color.cyan);
        panel.add(pane,BorderLayout.NORTH);

        down=new JPanel(new FlowLayout());
        down.setBackground(Color.blue);
        panel.add(down,BorderLayout.SOUTH);


        //new label
        label=new JLabel("REPORTCARDS");
        label.setFont(new Font("seriff",Font.ROMAN_BASELINE,20));
        pane.add(label);


        //adding a scroll pane and a text area
        JTextArea text=new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);

        JScrollPane pane=new JScrollPane();
        pane.add(text);
        panel.add(pane,BorderLayout.CENTER);


        //adding JTextfields

        name=new JTextField(20);
        name.setFont(new Font("seriff",Font.ROMAN_BASELINE,20));
        name.setBackground(Color.WHITE);
      //  name.setLayout(new BoxLayout(id,4));
        name.setForeground(Color.black);
        down.add(new JLabel("name"));
        down.add(name);

        id=new JTextField(20);
        id.setFont(new Font("seriff",Font.ROMAN_BASELINE,20));
        id.setBackground(Color.WHITE);
        //id.setLayout(new BoxLayout(name,0));
        id.setForeground(Color.black);
        down.add(new JLabel("Admno"));
        down.add(id);

        report=new JButton("report");
        report.setFocusable(true);
        down.add(report);





        this.add(panel);

    }
}
