package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private final JButton mSolveButton;
    private final JTextField mEquationTextField;
    private int a = 0;
    private int b = 0;
    private int result = 0;

    public Calculator() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setTitle("Calculator");
        setLayout(null);

        mEquationTextField = new JTextField();
        mEquationTextField.setBounds(70, 30, 130, 20);
        mEquationTextField.setName("TextField");
        add(mEquationTextField);

        mSolveButton = new JButton("Solve");
        mSolveButton.setBounds(100, 200, 70, 20);
        mSolveButton.setName("SolveButton");
        mSolveButton.addActionListener(this);
        add(mSolveButton);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == mSolveButton) {
            if (mEquationTextField.getText().isEmpty()) {
                mEquationTextField.setText(String.valueOf(result));
            } else {
                try {
                    a = Integer.parseInt(mEquationTextField.getText().split("[+]")[0]);
                    b = Integer.parseInt(mEquationTextField.getText().split("[+]")[1]);
                    result = a + b;

                    mEquationTextField.setText(a + "+" + b + "=" + result);

                } catch (NumberFormatException e){
                    System.out.println("Not a number");
                }
            }
        }
    }
}
