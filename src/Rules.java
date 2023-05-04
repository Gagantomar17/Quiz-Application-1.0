import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    String name;
    JButton Back , Start;
    Rules(String name) {
        this.name = name;

        JLabel heading = new JLabel("Welcome " + name + " to the quiz");
        heading.setBounds(320,50,700,30);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(50,100,700,350);
        rules.setFont(new Font("Viner Hand ITC",Font.PLAIN,18));
        rules.setForeground(Color.BLACK);
        rules.setText("<html>"+
                "1. do not unnecessarily smile at the person sitting next to you , they may also not know the answer"+"<br><br>"+
                "2. You may have a lot of options in life but here all questions are compulsory "+"<br><br>"+
                "3.Only a fool asks and a wise answers"+"<br><br>"+
                "4. This Quiz is not for faint hearted"+"<br><br>"+
                "5. May you know more than your best friend "+
                "<html>");
        add(rules);

        Back = new JButton("Back");
        Back.setBounds(300,450,120,25);
        Back.addActionListener(this);
        add(Back);

        Start = new JButton("Start");
        Start.setBounds(450,450,120,25);
        Start.addActionListener(this);
        add(Start);

        getContentPane().setBackground(Color.WHITE);
        setSize(1000,600);
        setLocation(150,100);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Start){
            new Quiz(name);
            setVisible(false);

        }else if(ae.getSource()==Back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");


    }
}

