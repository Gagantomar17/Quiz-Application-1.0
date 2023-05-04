import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//for adding click events to buttons

public class Login extends JFrame implements ActionListener {
    JButton rules , back ;
    JTextField userName;
    Login(){
        // set layout is used to define the layout and null specifies that layout will be
        // user defined i.e.no inbuilt layout is used
        setLayout(null);

        //adding image to the frame
        // j label class is used to show anything on the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,50,600,450);
        add(image);


        //creating heading "are you ready"
        JLabel heading = new JLabel("Are You Ready");
        heading.setBounds(650,100,300,35);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,35));
        heading.setForeground(Color.BLACK);
        add(heading);

        //creating heading enter your name
        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(700,200,220,20);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        name.setForeground(Color.BLACK);
        add(name);

        //creating box for user to enter his/her name here
        userName = new JTextField();
        userName.setBounds(620,230,300 ,30);
        userName.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(userName);

        //creating button rules
        rules = new JButton(" Start ");
        rules.setBounds(620,320,120,25);
        rules.addActionListener(this);
        add(rules);

        //creating button back
        back = new JButton(" Back ");
        back.setBounds(800,320,120,25);
        back.addActionListener(this);
        add(back);


        getContentPane().setBackground(Color.WHITE);
        setSize(1000,600);
        setLocation(150,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==rules){
            String name = userName.getText();
            setVisible(false);
            new Rules(name);
        } else if(ae.getSource()==back){
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new Login();
    }
}
