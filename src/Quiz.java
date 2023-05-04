import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    String[][] questions = new String[10][5];
    String[][] answers = new String[10][1];
    String[][] userans = new String[10][1];
    JLabel qno , ques;
    JRadioButton opt1,opt2,opt3,opt4;
    JButton submit , next ;
    ButtonGroup groupoptions;
    int count = 0;
    int score = 0;
    String name ;

    Quiz(String name){
        this.name = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quizz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1200,270);
        add(image);

        qno = new JLabel("1");
        qno.setBounds(50,285,50,30);
        qno.setFont(new Font("Times New Roman",Font.PLAIN,24));
        add(qno);

        ques = new JLabel("");
        ques.setBounds(80,285,1100,30);
        ques.setFont(new Font("Times New Roman",Font.PLAIN,19));
        add(ques);

        questions[0][0] = " What is Half of 2 + 2 ?";
        questions[0][1] = "1";
        questions[0][2] = "2";
        questions[0][3] = "3";
        questions[0][4] = "4";

        questions[1][0] = "Pointing to a photograph of a boy Suresh said ,'He is the " +
                "son of the only son of my mother.'How is Suresh related to that boy?";
        questions[1][1] = "Brother";
        questions[1][2] = "Uncle";
        questions[1][3] = "Cousin";
        questions[1][4] = "Father";

        questions[2][0] = "If A+B means A is the sister of B,A*B means A is the wife of B,A%B means A is the father of B and" +
                " A-B means A is the brother of B.Which means T is the daughter of p?";
        questions[2][1] = "P*Q%R+S-T";
        questions[2][2] = "P*Q%R-T+S";
        questions[2][3] = "P*Q%R+T-S";
        questions[2][4] = "P*Q%R+S+T";

        questions[3][0] = "which is the correctly spelt word? ";
        questions[3][1] = "Klaptomania";
        questions[3][2] = "Klepptomania";
        questions[3][3] = "Kleptemania";
        questions[3][4] = "Kleptomania";

        questions[4][0] = "Whicch is the correctly spelt word?";
        questions[4][1] = "Miscelaneous";
        questions[4][2] = "Miscellaneous";
        questions[4][3] = "Misselaneous";
        questions[4][4] = "Misellaneous";

        questions[5][0] = "A man walks 5 km to south and then turns to the right.After walking 3 km he turns to the left and walks 5 km." +
                " Now in which direction is he from the starting place ";
        questions[5][1] = "West";
        questions[5][2] = "South";
        questions[5][3] = "North-East";
        questions[5][4] = "South-West";

        questions[6][0] = "A,P,R,X,S and Z are sitting in a row.S and Z are in the centre." +
                "A and P are at the ends.R is sitting to the left of A.Who is to the right of P";
        questions[6][1] = "A";
        questions[6][2] = "X";
        questions[6][3] = "S";
        questions[6][4] = "Z";

        questions[7][0] = "Divide 30 by half and add 10 ";
        questions[7][1] = "40.5";
        questions[7][2] = "25";
        questions[7][3] = "70";
        questions[7][4] = "None";

        questions[8][0] = "Find the missing series : 21, 25, 33, 49, 81, __ ";
        questions[8][1] = "144";
        questions[8][2] = "133";
        questions[8][3] = "154";
        questions[8][4] = "145";

        questions[9][0] = "Find the missing series : 2, 3, 8, 63, __ ";
        questions[9][1] = "3900";
        questions[9][2] = "3636";
        questions[9][3] = "3968";
        questions[9][4] = "3988";

        answers[0][0] = "3";
        answers[1][0] = "Father";
        answers[2][0] = "P*Q%R-T+S";
        answers[3][0] = "Kleptomania";
        answers[4][0] = "Miscellaneous";
        answers[5][0] = "South-West";
        answers[6][0] = "X";
        answers[7][0] = "70";
        answers[8][0] = "145";
        answers[9][0] = "3968";

        opt1 = new JRadioButton("Julie");
        opt1.setBounds(50,345,700,30);
        opt1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(opt1);

        opt2 = new JRadioButton("Moti");
        opt2.setBounds(50,390,700,30);
        opt2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(opt2);

        opt3 = new JRadioButton("Jimmy");
        opt3.setBounds(50,435,700,30);
        opt3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(opt3);

        opt4 = new JRadioButton("Nandu");
        opt4.setBounds(50,480,700,30);
        opt4.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(opt4);

        //grouping so that only on option will be selected
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(820,390,100,30);
        next.setFont(new Font("Times New Roman",Font.PLAIN,22));
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(820,465,100,30);
        submit.setFont(new Font("Times New Roman",Font.PLAIN,22));
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);

        //declaring frame dimension and layout
        getContentPane().setBackground(Color.WHITE);
        setSize(1200,700);
        setLocation(70,30);
        setLayout(null);
        setVisible(true);

    }


    //method for action listener
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            if(groupoptions.getSelection()==null){
                userans[count][0]="";
            }else{
                userans[count][0]=groupoptions.getSelection().getActionCommand();
                //get selection gives selected option and getActionCommand gives exact value
                //of the selected option
            }
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);

        }else if(ae.getSource()==submit){
            if(groupoptions.getSelection()==null){
                userans[count][0]=" ";
            }else{
                userans[count][0]=groupoptions.getSelection().getActionCommand();
                //get selection gives selected option and getActionCommand gives exact value
                //of the selected option
            }
            for(int i=0 ; i<userans.length ; i++){
                if(userans[i][0].equals(answers[i][0])){
                    score +=10;
                }
            }
            setVisible(false);
            new Score(name , score);
        }
    }

    public void ans(){
        if(groupoptions.getSelection()==null){
            userans[count][0]=" ";
        }else{
            userans[count][0]=groupoptions.getSelection().getActionCommand();
            //get selection gives selected option and getActionCommand gives exact value
            //of the selected option
        }
        count++;
        start(count);
    }

    //function to traverse array of ques
    public void start(int count){
        qno.setText(""+(count + 1)+". ");
        ques.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("user");
    }
}
