import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator implements ActionListener {

    JFrame frame;           //frame for calculator
    JTextField textfield;   //a textfield
    JButton[] numberbuttons = new JButton[10];  //10 buttons, representing 0-9
    JButton[] functionbuttons = new JButton[9]; //8 buttons for all functions
    JButton addbutton, subbutton, mulbutton, divbutton; //function buttons
    JButton decbutton, equbutton, delbutton, clrbutton, negbutton; //function buttons
    JPanel panel;       //panel
    
    Font arial = new Font("Arial", Font.BOLD, 30); // font for calculator

    double number1 = 0; //first character
    double number2 = 0; //second character
    double result = 0; //result
    char operator; //operator

    calculator() {
        frame = new JFrame("pedram's calculator"); //creates frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes frame on close
        frame.setSize(420, 550); //sets dimension
        frame.setLayout(null); //setLayout(null) lets us position our components absolutely
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(arial);
        textfield.setEditable(false);

        addbutton = new JButton("+");
        subbutton = new JButton("-");
        mulbutton = new JButton("*");
        divbutton = new JButton("/");
        decbutton = new JButton(".");
        equbutton = new JButton("=");
        delbutton = new JButton("Del");
        clrbutton = new JButton("Clear");
        negbutton = new JButton("(-)");

        functionbuttons[0] = addbutton;
        functionbuttons[1] = subbutton;
        functionbuttons[2] = mulbutton;
        functionbuttons[3] = divbutton;
        functionbuttons[4] = decbutton;
        functionbuttons[5] = equbutton;
        functionbuttons[6] = delbutton;
        functionbuttons[7] = clrbutton;
        functionbuttons[8] = negbutton;

        for(int i = 0; i<9; i++){
            functionbuttons[i].addActionListener(this);
            functionbuttons[i].setFont(arial);
            functionbuttons[i].setFocusable(false); //when you click a button it doesnt focus on it
        }

        for(int i = 0; i<10; i++) {
            numberbuttons[i] = new JButton(String.valueOf(i));
            numberbuttons[i].addActionListener(this);
            numberbuttons[i].setFont(arial);
            numberbuttons[i].setSize(50,50);
            numberbuttons[i].setFocusable(false);
        }


        delbutton.setBounds(150,430,100,50);
        clrbutton.setBounds(250,430,100,50);
        negbutton.setBounds(50, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50,100, 300, 300 );
        panel.setLayout(new GridLayout(4,4,10,10)); //sets the layout for buttons
        //panel.setBackground(Color.GRAY);

        panel.add(numberbuttons[1]);
        panel.add(numberbuttons[2]);
        panel.add(numberbuttons[3]);
        panel.add(addbutton);
        panel.add(numberbuttons[4]);
        panel.add(numberbuttons[5]);
        panel.add(numberbuttons[6]);
        panel.add(subbutton);
        panel.add(numberbuttons[7]);
        panel.add(numberbuttons[8]);
        panel.add(numberbuttons[9]);
        panel.add(mulbutton);
        panel.add(decbutton);
        panel.add(numberbuttons[0]);
        panel.add(equbutton);
        panel.add(divbutton);

        frame.add(negbutton);
        frame.add(panel);
        frame.add(delbutton);
        frame.add(clrbutton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        calculator calc = new calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i =0; i<10; i++){
            if(e.getSource() == numberbuttons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decbutton ){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource() == addbutton ){
            number1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == mulbutton ){
            number1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divbutton ){
            number1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource() == subbutton ){
            number1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == equbutton ){
            number2 = Double.parseDouble(textfield.getText());
            switch (operator){
                case'+':
                    result = number1 + number2;
                    break;
                case'-':
                    result = number1 - number2;
                    break;
                case'*':
                    result = number1 * number2;
                    break;
                case'/':
                    result = number1 / number2;
                    break;
            }
            textfield.setText(String.valueOf(result));
        }
        if(e.getSource() == clrbutton ){
            textfield.setText("");
        }
        if(e.getSource() == delbutton ){
            String str = textfield.getText();
            textfield.setText("");
            if (str.length() == 1 || str.length() == 0){
                textfield.setText("");
            }else {
                String strOut = str.substring(0, str.length() - 1);
                textfield.setText(strOut);
            }
        }
        if(e.getSource() == negbutton){
            double neg = Double.parseDouble(textfield.getText());
            neg = neg *-1;
            textfield.setText(String.valueOf(neg));
        }
    }
}
