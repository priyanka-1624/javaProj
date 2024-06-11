package MyProjects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

class MyCalci extends JFrame implements ActionListener {
    JLabel l1, l2;
    JButton bCA, b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bDec, bAdd, bSub, bMul, bDiv, bMod, bCalc;
    double value, num1, num2, res;

    MyCalci() {
        setSize(450, 500);
        setResizable(true);
        setLayout(null);
        setTitle("MyCalci");
        getContentPane().setBackground(Color.LIGHT_GRAY);

        Font myFont = new Font("MV Boli", Font.BOLD, 30);

        // label
        l1 = new JLabel();
        l1.setFont(new Font("MV Boli", Font.BOLD, 40));
        l1.setText("Calculator");
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);
        l1.setBounds(130, 10, 200, 30);
        add(l1);

        // CLEAR
        bCA = new JButton();
        bCA.setText("C");
        bCA.setFont(myFont);
        bCA.setBounds(20, 150, 100, 55);
        bCA.addActionListener(this);
        add(bCA);

        // ÷
        bDiv = new JButton();
        bDiv.setText("÷");
        bDiv.setFont(myFont);
        bDiv.setBounds(320, 150, 100, 55);
        bDiv.addActionListener(this);
        add(bDiv);

        // 1
        b1 = new JButton();
        b1.setText("1");
        b1.setFont(myFont);
        b1.setBounds(20, 205, 100, 55);
        b1.addActionListener(this);
        add(b1);

        // 2
        b2 = new JButton();
        b2.setText("2");
        b2.setFont(myFont);
        b2.setBounds(120, 205, 100, 55);
        b2.addActionListener(this);
        add(b2);

        // 3
        b3 = new JButton();
        b3.setText("3");
        b3.setFont(myFont);
        b3.setBounds(220, 205, 100, 55);
        b3.addActionListener(this);
        add(b3);

        // +
        bAdd = new JButton();
        bAdd.setText("+");
        bAdd.setFont(myFont);
        bAdd.setBounds(320, 205, 100, 55);
        bAdd.addActionListener(this);
        add(bAdd);

        // 4
        b4 = new JButton();
        b4.setText("4");
        b4.setFont(myFont);
        b4.setBounds(20, 260, 100, 55);
        b4.addActionListener(this);
        add(b4);

        // 5
        b5 = new JButton();
        b5.setText("5");
        b5.setFont(myFont);
        b5.setBounds(120, 260, 100, 55);
        b5.addActionListener(this);
        add(b5);

        // 6
        b6 = new JButton();
        b6.setText("6");
        b6.setFont(myFont);
        b6.setBounds(220, 260, 100, 55);
        b6.addActionListener(this);
        add(b6);

        // -
        bSub = new JButton();
        bSub.setText("-");
        bSub.setFont(myFont);
        bSub.setBounds(320, 260, 100, 55);
        bSub.addActionListener(this);
        add(bSub);

        // 7
        b7 = new JButton();
        b7.setText("7");
        b7.setFont(myFont);
        b7.setBounds(20, 315, 100, 55);
        b7.addActionListener(this);
        add(b7);

        // 8
        b8 = new JButton();
        b8.setText("8");
        b8.setFont(myFont);
        b8.setBounds(120, 315, 100, 55);
        b8.addActionListener(this);
        add(b8);

        // 9
        b9 = new JButton();
        b9.setText("9");
        b9.setFont(myFont);
        b9.setBounds(220, 315, 100, 55);
        b9.addActionListener(this);
        add(b9);

        // x
        bMul = new JButton();
        bMul.setText("x");
        bMul.setFont(myFont);
        bMul.setBounds(320, 315, 100, 55);
        bMul.addActionListener(this);
        add(bMul);

        // .
        bDec = new JButton();
        bDec.setText(".");
        bDec.setFont(myFont);
        bDec.setBounds(20, 370, 100, 55);
        bDec.addActionListener(this);
        add(bDec);

        // 0
        b0 = new JButton();
        b0.setText("0");
        b0.setFont(myFont);
        b0.setBounds(120, 370, 100, 55);
        b0.addActionListener(this);
        add(b0);

        // %
        bMod = new JButton();
        bMod.setText("%");
        bMod.setFont(myFont);
        bMod.setBounds(220, 370, 100, 55);
        bMod.addActionListener(this);
        add(bMod);

        // =
        bCalc = new JButton();
        bCalc.setText("=");
        bCalc.setFont(myFont);
        bCalc.setBounds(320, 370, 100, 55);
        bCalc.addActionListener(this);
        add(bCalc);

        // result
        l2 = new JLabel();
        l2.setFont(new Font("Fantasy", Font.ITALIC, 30));
        l2.setOpaque(true);
        l2.setBounds(45, 80, 350, 60);
        add(l2);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String btntext, lbltext;
        if (e.getSource() == b1) {
            btntext = l2.getText();
            lbltext = btntext + "1";
            l2.setText(lbltext);
        }
        if (e.getSource() == b2) {
            btntext = l2.getText();
            lbltext = btntext + "2";
            l2.setText(lbltext);
        }
        if (e.getSource() == b3) {
            btntext = l2.getText();
            lbltext = btntext + "3";
            l2.setText(lbltext);
        }
        if (e.getSource() == b4) {
            btntext = l2.getText();
            lbltext = btntext + "4";
            l2.setText(lbltext);
        }
        if (e.getSource() == b5) {
            btntext = l2.getText();
            lbltext = btntext + "5";
            l2.setText(lbltext);
        }
        if (e.getSource() == b6) {
            btntext = l2.getText();
            lbltext = btntext + "6";
            l2.setText(lbltext);
        }
        if (e.getSource() == b7) {
            btntext = l2.getText();
            lbltext = btntext + "7";
            l2.setText(lbltext);
        }
        if (e.getSource() == b8) {
            btntext = l2.getText();
            lbltext = btntext + "8";
            l2.setText(lbltext);
        }
        if (e.getSource() == b9) {
            btntext = l2.getText();
            lbltext = btntext + "9";
            l2.setText(lbltext);
        }
        if (e.getSource() == bDec) {
            btntext = l2.getText();
            lbltext = btntext + ".";
            l2.setText(lbltext);
        }
        if (e.getSource() == b0) {
            btntext = l2.getText();
            lbltext = btntext + "0";
            l2.setText(lbltext);
        }
        if (e.getSource() == bAdd) {
            try {
                num1 = Double.parseDouble(l2.getText());
            } catch (NumberFormatException f) {
                l2.setText("Enter a number");
                return;
            }
            lbltext = "";
            l2.setText(lbltext);
            value = 1;
        }
        if (e.getSource() == bSub) {
            try {
                num1 = Double.parseDouble(l2.getText());
            } catch (NumberFormatException f) {
                l2.setText("Enter a number");
                return;
            }
            lbltext = "";
            l2.setText(lbltext);
            value = 2;
        }
        if (e.getSource() == bMul) {
            try {
                num1 = Double.parseDouble(l2.getText());
            } catch (NumberFormatException f) {
                l2.setText("Enter a number");
                return;
            }
            lbltext = "";
            l2.setText(lbltext);
            value = 3;
        }
        if (e.getSource() == bDiv) {
            try {
                num1 = Double.parseDouble(l2.getText());
            } catch (NumberFormatException f) {
                l2.setText("Enter a number");
                return;
            }
            lbltext = "";
            l2.setText(lbltext);
            value = 4;
        }
        if (e.getSource() == bMod) {
            try {
                num1 = Double.parseDouble(l2.getText());
            } catch (NumberFormatException f) {
                l2.setText("Enter a number");
                return;
            }
            lbltext = "";
            l2.setText(lbltext);
            value = 5;
        }
        if (e.getSource() == bCalc) {
            try {
                num2 = Double.parseDouble(l2.getText());
            } catch (Exception f) {
                l2.setText("Enter a Number first!");
                return;
            }
            if (value == 1)
                res = num1 + num2;
            if (value == 2)
                res = num1 - num2;
            if (value == 3)
                res = num1 * num2;
            if (value == 4)
                res = num1 / num2;
            if (value == 5)
                res = num1 % num2;

            l2.setText(String.valueOf(res));
        }
        if (e.getSource() == bCA) {
            num1 = 0;
            num2 = 0;
            res = 0;
            value = 0;
            lbltext = " ";
            l2.setText(lbltext);
        }
    }

    public static void main(String[] args) {
        new MyCalci();
    }
}
