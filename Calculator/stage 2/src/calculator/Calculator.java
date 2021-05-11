package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
enum Operator {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}

public class Calculator extends JFrame implements ActionListener {
    private JButton mAdd, mSub, mDiv, mMult, mZero, mOne, mTwo, mThree, mFour, mFive, mSix,
            mSeven, mEight, mNine, mEquals;
    private JTextField mEquationTextField;
    private Operator mOp;
    private double a, b = 0;

    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 500);
        setTitle("Calculator");
        setLayout(null);

        showUI();
        setListener();

        setVisible(true);
    }

    private void setListener() {
        mEquals.addActionListener(this);
        mSub.addActionListener(this);
        mAdd.addActionListener(this);
        mMult.addActionListener(this);
        mDiv.addActionListener(this);
        mZero.addActionListener(this);
        mOne.addActionListener(this);
        mTwo.addActionListener(this);
        mThree.addActionListener(this);
        mFour.addActionListener(this);
        mFive.addActionListener(this);
        mSix.addActionListener(this);
        mSeven.addActionListener(this);
        mEight.addActionListener(this);
        mNine.addActionListener(this);

    }

    private void showUI() {
        mEquationTextField = new JTextField();
        mEquationTextField.setBounds(30, 40, 280, 25);
        mEquationTextField.setName("EquationTextField");
        add(mEquationTextField);

        mEquals = new JButton("=");
        mAdd = new JButton("+");
        mSub = new JButton("-");
        mDiv = new JButton("/");
        mMult = new JButton("x");
        mZero = new JButton("0");
        mOne = new JButton("1");
        mTwo = new JButton("2");
        mThree = new JButton("3");
        mFour = new JButton("4");
        mFive = new JButton("5");
        mSix = new JButton("6");
        mSeven = new JButton("7");
        mEight = new JButton("8");
        mNine = new JButton("9");

        mSeven.setBounds(40, 100, 50, 40);
        mEight.setBounds(110, 100, 50, 40);
        mNine.setBounds(180, 100, 50, 40);
        mDiv.setBounds(250, 100, 50, 40);

        mFour.setBounds(40, 170, 50, 40);
        mFive.setBounds(110, 170, 50, 40);
        mSix.setBounds(180, 170, 50, 40);
        mMult.setBounds(250, 170 ,50, 40);

        mOne.setBounds(40, 240, 50, 40);
        mTwo.setBounds(110, 240, 50,40);
        mThree.setBounds(180, 240, 50 ,40);
        mAdd.setBounds(250, 240, 50, 40);

        mZero.setBounds(110, 310, 50, 40);
        mEquals.setBounds(180, 310, 50, 40);
        mSub.setBounds(250, 310, 50, 40);

        mEquals.setName("ButtonEquals");
        mAdd.setName("ButtonAdd");
        mSub.setName("ButtonSubtract");
        mDiv.setName("ButtonDivide");
        mMult.setName("ButtonMultiply");
        mZero.setName("ButtonZero");
        mOne.setName("ButtonOne");
        mTwo.setName("ButtonTwo");
        mThree.setName("ButtonThree");
        mFour.setName("ButtonFour");
        mFive.setName("ButtonFive");
        mSix.setName("ButtonSix");
        mSeven.setName("ButtonSeven");
        mEight.setName("ButtonEight");
        mNine.setName("ButtonNine");

        add(mAdd);
        add(mSub);
        add(mDiv);
        add(mMult);
        add(mEquals);
        add(mZero);
        add(mOne);
        add(mTwo);
        add(mThree);
        add(mFour);
        add(mFive);
        add(mSix);
        add(mSeven);
        add(mEight);
        add(mNine);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == mOne) {
            mEquationTextField.setText(mEquationTextField.getText() + "1");
        } else if (actionEvent.getSource() == mTwo) {
            mEquationTextField.setText(mEquationTextField.getText() + "2");
        } else if (actionEvent.getSource() == mThree) {
            mEquationTextField.setText(mEquationTextField.getText() + "3");
        } else if (actionEvent.getSource() == mFour) {
            mEquationTextField.setText(mEquationTextField.getText() + "4");
        } else if (actionEvent.getSource() == mFive) {
            mEquationTextField.setText(mEquationTextField.getText() + "5");
        } else if (actionEvent.getSource() == mSix) {
            mEquationTextField.setText(mEquationTextField.getText() + "6");
        } else if (actionEvent.getSource() == mSeven) {
            mEquationTextField.setText(mEquationTextField.getText() + "7");
        } else if (actionEvent.getSource() == mEight) {
            mEquationTextField.setText(mEquationTextField.getText() + "8");
        } else if (actionEvent.getSource() == mNine) {
            mEquationTextField.setText(mEquationTextField.getText() + "9");
        } else if (actionEvent.getSource() == mZero) {
            mEquationTextField.setText(mEquationTextField.getText() + "0");
        } else if (actionEvent.getSource() == mAdd) {
            mEquationTextField.setText(mEquationTextField.getText() + "+");
             mOp = Operator.ADD;
        } else if (actionEvent.getSource() == mSub) {
            mEquationTextField.setText(mEquationTextField.getText() + "-");
            mOp = Operator.SUBTRACT;
        } else if (actionEvent.getSource() == mMult) {
            mEquationTextField.setText(mEquationTextField.getText() + "x");
            mOp = Operator.MULTIPLY;
        } else if (actionEvent.getSource() == mDiv) {
            mEquationTextField.setText(mEquationTextField.getText() + "/");
            mOp = Operator.DIVIDE;
        } else if (actionEvent.getSource() == mEquals) {
            solveEquation();
        }
    }

    private void solveEquation() {

        String equ = mEquationTextField.getText();

        a = Double.parseDouble(equ.split("[+x/-]")[0]);
        b = Double.parseDouble(equ.split("[+x/-]")[1]);
        double result = 0;

        switch (mOp) {
            case ADD:
                result = a + b;
                break;
            case DIVIDE:
                result = a / b;
                break;
            case SUBTRACT:
                result = a - b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
        }
        
        

        mEquationTextField.setText(mEquationTextField.getText().concat(" = " + (int) result));
    }
}
