import javax.swing.*;
import java.awt.*;

public class Score extends JFrame {
    String name ;
    int score ;
    Score(String name , int score){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/score.png"));
        Image i2 = i1.getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,100,400,350);
        add(image);

        JLabel heading = new JLabel("Thank you " + name + " for playing ");
        heading.setBounds(150,20,600,50);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel scoree = new JLabel(score + " / 100"  );
        scoree.setBounds(600,250,700,100);
        scoree.setFont(new Font("Viner Hand ITC",Font.BOLD,70));
        scoree.setForeground(Color.BLACK);
        add(scoree);

        getContentPane().setBackground(Color.WHITE);
        setSize(1000,600);
        setLocation(150,100);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {

        new Score("user " , 0);
    }
}
