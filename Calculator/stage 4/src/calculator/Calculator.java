package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Operator {
    ADD, SUBTRACT, DIVIDE, MULTIPLY
}

public class Calculator extends JFrame implements ActionListener {
    
    private JButton mAdd;
    private JButton mSub;
    private JButton mDiv;
    private JButton mMult;
    private JButton mZero;
    private JButton mOne;
    private JButton mTwo;
    private JButton mThree;
    private JButton mFour;
    private JButton mFive;
    private JButton mSix;
    private JButton mSeven;
    private JButton mEight;
    private JButton mNine;
    private JButton mEquals;
    private JButton mDot;
    private JButton mClear;
    private JButton mDel;
    private JLabel mEquationLabel;
    private JLabel mResultLabel;
    
    private Operator mOperator;
    private final String divideSymbol = "\u00F7";
    private final String multiplySymbol = "\u00D7";
    private final String addSymbol = "\u002B";
    private final String subtractSymbol = "-";
    
    private final String[] mOperationArray = new String[]{divideSymbol, multiplySymbol, addSymbol,
            subtractSymbol};
    private int indexOfCurrentOperation;
    
    private StringBuilder mResultBuilder;
    private final StringBuilder mEquationBuilder = new StringBuilder();
    
    private final NumberFormat mNumberFormatter = new DecimalFormat("#0.000000");
    
    public Calculator () {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 500);
        setTitle("Calculator");
        setLayout(null);
        
        showUI();
        setListener();
        
        setVisible(true);
    }
    
    private void setListener () {
        
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
        mDel.addActionListener(this);
        mClear.addActionListener(this);
        mDot.addActionListener(this);
        
    }
    
    private void showUI () {
        //Create labels
        mResultLabel = new JLabel("0", SwingConstants.RIGHT);
        mResultLabel.setName("ResultLabel");
        mResultLabel.setFont(mResultLabel.getFont().deriveFont(40f));
        mResultLabel.setBounds(10, 20, 310, 50);
        add(mResultLabel);
        
        mEquationLabel = new JLabel("", SwingConstants.RIGHT);
        mEquationLabel.setName("EquationLabel");
        mEquationLabel.setForeground(Color.GREEN.darker());
        mEquationLabel.setBounds(10, 90, 310, 30);
        add(mEquationLabel);
        
        //Create buttons
        mEquals = new JButton("=");
        mAdd = new JButton(addSymbol);
        mSub = new JButton(subtractSymbol);
        mDiv = new JButton(divideSymbol);
        mMult = new JButton(multiplySymbol);
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
        mDot = new JButton(".");
        mClear = new JButton("C");
        mDel = new JButton("Del");
        mDot = new JButton(".");
        
        //Design buttons
        mOne.setBackground(Color.WHITE);
        mTwo.setBackground(Color.WHITE);
        mThree.setBackground(Color.WHITE);
        mFour.setBackground(Color.WHITE);
        mFive.setBackground(Color.WHITE);
        mSix.setBackground(Color.WHITE);
        mSeven.setBackground(Color.WHITE);
        mEight.setBackground(Color.WHITE);
        mNine.setBackground(Color.WHITE);
        mZero.setBackground(Color.WHITE);
        mSub.setBackground(Color.WHITE);
        mAdd.setBackground(Color.WHITE);
        mMult.setBackground(Color.WHITE);
        mDiv.setBackground(Color.WHITE);
        mEquals.setBackground(Color.WHITE);
        mDel.setBackground(Color.WHITE);
        mDot.setBackground(Color.WHITE);
        mClear.setBackground(Color.WHITE);
        mDot.setBackground(Color.WHITE);
        
        //Position buttons
        mDel.setBounds(250, 170, 70, 40);
        mClear.setBounds(170, 170, 70, 40);
        
        mSeven.setBounds(10, 220, 70, 40);
        mEight.setBounds(90, 220, 70, 40);
        mNine.setBounds(170, 220, 70, 40);
        mDiv.setBounds(250, 220, 70, 40);
        
        mFour.setBounds(10, 270, 70, 40);
        mFive.setBounds(90, 270, 70, 40);
        mSix.setBounds(170, 270, 70, 40);
        mMult.setBounds(250, 270, 70, 40);
        
        mOne.setBounds(10, 320, 70, 40);
        mTwo.setBounds(90, 320, 70, 40);
        mThree.setBounds(170, 320, 70, 40);
        mAdd.setBounds(250, 320, 70, 40);
        
        mDot.setBounds(10, 370, 70, 40);
        mZero.setBounds(90, 370, 70, 40);
        mEquals.setBounds(170, 370, 70, 40);
        mSub.setBounds(250, 370, 70, 40);
        
        mEquals.setName("Equals");
        mAdd.setName("Add");
        mSub.setName("Subtract");
        mDiv.setName("Divide");
        mMult.setName("Multiply");
        mZero.setName("Zero");
        mOne.setName("One");
        mTwo.setName("Two");
        mThree.setName("Three");
        mFour.setName("Four");
        mFive.setName("Five");
        mSix.setName("Six");
        mSeven.setName("Seven");
        mEight.setName("Eight");
        mNine.setName("Nine");
        mDot.setName("Dot");
        mDel.setName("Delete");
        mClear.setName("Clear");
        
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
        add(mClear);
        add(mDel);
        add(mDot);
    }
    
    @Override
    public void actionPerformed (ActionEvent actionEvent) {
        mEquationLabel.setForeground(Color.GREEN.darker());
        
        if (actionEvent.getSource() == mOne) {
            formatEquation("1", true);
        } else if (actionEvent.getSource() == mTwo) {
            formatEquation("2", true);
        } else if (actionEvent.getSource() == mThree) {
            formatEquation("3", true);
        } else if (actionEvent.getSource() == mFour) {
            formatEquation("4", true);
        } else if (actionEvent.getSource() == mFive) {
            formatEquation("5", true);
        } else if (actionEvent.getSource() == mSix) {
            formatEquation("6", true);
        } else if (actionEvent.getSource() == mSeven) {
            formatEquation("7", true);
        } else if (actionEvent.getSource() == mEight) {
            formatEquation("8", true);
        } else if (actionEvent.getSource() == mNine) {
            formatEquation("9", true);
        } else if (actionEvent.getSource() == mZero) {
            formatEquation("0", true);
        } else if (actionEvent.getSource() == mAdd) {
            if (!mEquationBuilder.toString().isBlank()) {
                formatEquation(addSymbol, false);
            }
        } else if (actionEvent.getSource() == mSub) {
            if (!mEquationBuilder.toString().isBlank()) {
                formatEquation(subtractSymbol, false);
            }
        } else if (actionEvent.getSource() == mMult) {
            if (!mEquationBuilder.toString().isBlank()) {
                formatEquation(multiplySymbol, false);
            }
        } else if (actionEvent.getSource() == mDiv) {
            if (!mEquationBuilder.toString().isBlank()) {
                formatEquation(divideSymbol, false);
            }
        } else if (actionEvent.getSource() == mDot) {
            mEquationBuilder.append(".");
        } else if (actionEvent.getSource() == mClear) {
            mEquationBuilder.delete(0, mEquationBuilder.length());
            mResultLabel.setText("0");
        } else if (actionEvent.getSource() == mDel) {
            if (!mEquationLabel.getText().isEmpty()) {
                mEquationBuilder.deleteCharAt(mEquationBuilder.length() - 1);
            }
        } else if (actionEvent.getSource() == mEquals) {
            
            boolean validEquation = isValidEquation(mEquationBuilder.toString());
            if (validEquation) {
                formatEquation("", false);
                mResultBuilder = new StringBuilder(mEquationBuilder.toString());
                indexOfCurrentOperation = getIndexFromOperatorArray(mResultBuilder.toString());
    
                mResultLabel.setText(solveEquation());
            } else {
                mEquationLabel.setForeground(Color.RED.darker());
            }
            
        }
        mEquationLabel.setText(mEquationBuilder.toString());
    }
    
    //Engine room
    private String solveEquation () {
        
        char[] chars = mResultBuilder.toString().toCharArray();
        if (!mResultBuilder.toString().matches("^-?\\d*\\.?\\d+$")) {
            
            while (indexOfCurrentOperation < mOperationArray.length
                    && !mResultBuilder.toString().matches("^-?\\d*\\.?\\d+$")) {
                
                for (int k = 0; k < chars.length; k++) {
                    boolean operatorFound = String.valueOf(chars[k])
                                                  .equals(mOperationArray[indexOfCurrentOperation]) || String
                            .valueOf(chars[k])
                            .equals(mOperationArray[indexOfCurrentOperation + 1]);
                    if (operatorFound) {
                        
                        if (k == 0) {
                            continue;
                        }
                        updateOperator(String.valueOf(chars[k]));
                        String subStringIndex = getSubStringEquation(k, mResultBuilder.toString());
                        int startIndex = Integer.parseInt(subStringIndex.split("\\s")[0]);
                        int endIndex = Integer.parseInt(subStringIndex.split("\\s")[1]);
                        
                        String calcResult = calculate(subStringIndex, mResultBuilder.toString());
                        mResultBuilder.replace(startIndex, endIndex + 1, calcResult);
                        
                        break;
                    }
                }
                
                indexOfCurrentOperation = getIndexFromOperatorArray(mResultBuilder.toString());
                if (indexOfCurrentOperation >= mOperationArray.length) {
                    break;
                }
                solveEquation();
            }
            
        }
        
        return mResultBuilder.toString();
    }
    
    //Get the position of the operator with the highest precedence in the current equation
    private int getIndexFromOperatorArray (String currentEquation) {
        
        if (currentEquation.contains(multiplySymbol) || currentEquation.contains(divideSymbol)) {
            return 0;
        } else if (currentEquation.contains(addSymbol) || currentEquation
                .contains(subtractSymbol)) {
            return 2;
        } else {
            return mOperationArray.length + 1;
        }
    }
    
    //Update current operator to be performed
    private void updateOperator (String operatorAtIndex) {
        
        switch (operatorAtIndex) {
            case divideSymbol:
                mOperator = Operator.DIVIDE;
                break;
            case multiplySymbol:
                mOperator = Operator.MULTIPLY;
                break;
            case addSymbol:
                mOperator = Operator.ADD;
                break;
            case subtractSymbol:
                mOperator = Operator.SUBTRACT;
                break;
        }
        
    }
    
    private void formatEquation (String symbol, boolean forDigit) {
        
        String equation = mEquationBuilder.toString();
        String regex =  String.format("[%s%s%s%s]", multiplySymbol, divideSymbol, addSymbol,
                                      subtractSymbol);
        
        if (forDigit) {
            boolean containsOperator =
                    equation.contains(addSymbol) || equation.contains(divideSymbol) || equation
                            .contains(multiplySymbol) || equation.contains(subtractSymbol);
            if (containsOperator) {
                String[] arr = equation.split(regex);
                String lastDigits = arr[arr.length - 1];
                
                if (lastDigits.matches("0") && !(String.valueOf(equation.charAt(equation.length() - 1)).matches(regex))) {
                    mEquationBuilder.replace(mEquationBuilder.length() - 1, mEquationBuilder.length()
                            , symbol);
                } else {
                    mEquationBuilder.append(symbol);
                }
            } else {
                if (equation.matches("0")) {
                    mEquationBuilder.replace(mEquationBuilder.length() - 1, mEquationBuilder.length()
                            , symbol);
                } else {
                    mEquationBuilder.append(symbol);
                }
            }
            
        } else {
            if (equation.startsWith(".")) {
                mEquationBuilder.insert(0, "0");
            }
            if (equation.endsWith(".")) {
                mEquationBuilder.insert(mEquationBuilder.length(), "0");
            }
            boolean endsWithOperator =
                    equation.endsWith(addSymbol) || equation.endsWith(subtractSymbol) || equation
                            .endsWith(divideSymbol) || equation.endsWith(multiplySymbol);
            if (endsWithOperator) {
                mEquationBuilder.replace(mEquationBuilder.length() - 1, mEquationBuilder.length()
                        , symbol);
            } else {
                mEquationBuilder.append(symbol);
                
            }
        }
        
        
    }
    
    //Checks if equation is valid
    private boolean isValidEquation (String equation) {
        
        boolean endsWithOperator =
                equation.endsWith(addSymbol) || equation.endsWith(multiplySymbol) || equation
                        .endsWith(divideSymbol) || equation.endsWith(subtractSymbol);
        if (endsWithOperator) {
            return false;
        }
        
        Pattern pattern = Pattern.compile("\\d+[" + divideSymbol + "]0");
        Matcher matcher = pattern.matcher(equation);
    
        return !matcher.find();
    }
    
    //Calculate mini equations
    private String calculate (String subStringIndex, String currentEquation) {
        
        int startIndex = Integer.parseInt(subStringIndex.split("\\s")[0]);
        int endIndex = Integer.parseInt(subStringIndex.split("\\s")[1]);
        
        String miniEqu = currentEquation.substring(startIndex, endIndex + 1);
        String regex = String.format("(?<!^)[%s%s%s%s]", multiplySymbol, divideSymbol, addSymbol,
                                     subtractSymbol);
        
        //System.out.println("Mini Equation: " + miniEqu);
        
        double a = Double.parseDouble(miniEqu.split(regex)[0]);
        double b = Double.parseDouble(miniEqu.split(regex)[1]);
        double result;
        
        switch (mOperator) {
            case MULTIPLY:
                result = a * b;
                break;
            case ADD:
                result = a + b;
                break;
            case DIVIDE:
                result = a / b;
                break;
            case SUBTRACT:
                result = a - b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mOperator);
        }
    
        if (result % 1 == 0) {
            return String.valueOf((int) result);
        } else {
            if (String.valueOf(result).length() >= 7) {
                return mNumberFormatter.format(result);
            }
            return String.valueOf(result);
        }
    }
    
    //Gets the start and end index of the next equation to be solved
    private String getSubStringEquation (int indexOfOperator, String equation) {
        
        String leftSideOfOperator = equation.substring(0, indexOfOperator);
        String rightSideOfOperator = equation.substring(indexOfOperator + 1);

//        System.out.println("Left: " + leftSideOfOperator);
//        System.out.println("RIGHT: " + rightSideOfOperator);
        
        int startIndex = 0;
        int endIndex = equation.length() - 1;
        
        for (int i = leftSideOfOperator.length() - 1; i >= 0; i--) {
            String characterAtCurrentIndex = String.valueOf(equation.charAt(i));
            boolean matches =
                    characterAtCurrentIndex.equals(multiplySymbol)
                            || characterAtCurrentIndex.equals(divideSymbol)
                            || characterAtCurrentIndex.equals(addSymbol)
                            || characterAtCurrentIndex.equals(subtractSymbol);
            if (matches) {
                if (i != 0) {
                    startIndex = i + 1;
                }
                break;
            }
        }
        
        for (int i = 1; i < rightSideOfOperator.length(); i++) {
            int index = indexOfOperator + i;
            String characterAtCurrentIndex = String.valueOf(equation.charAt(index));
            boolean matches =
                    characterAtCurrentIndex.equals(multiplySymbol)
                            || characterAtCurrentIndex.equals(divideSymbol)
                            || characterAtCurrentIndex.equals(addSymbol)
                            || characterAtCurrentIndex.equals(subtractSymbol);
            if (matches) {
                endIndex = index - 1;
                break;
            }
        }
        
        return startIndex + " " + endIndex;
    }
}
