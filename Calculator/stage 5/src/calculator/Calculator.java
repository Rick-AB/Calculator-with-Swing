package calculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Operator {
    ADD, SUBTRACT, DIVIDE, MULTIPLY, POW, ROOT
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
    private JButton mPow;
    private JButton mPowY;
    private JButton mRoot;
    private JButton mPlusMinus;
    private JButton mClearEqu;
    private JButton mParentheses;
    private JLabel mEquationLabel;
    private JLabel mResultLabel;
    
    private final Color mBackgroundColor = new Color(211, 211, 211);
    private final Color mLightGray = new Color(220, 220, 220);
    private final Color mLightBlue = new Color(176, 196, 222);
    
    private Operator mOperator;
    private final String powSymbol = "^";
    private final String rootSymbol = "\u221A\u221A";
    private final String plusMinusSymbol = "\u00b1";
    private final String divideSymbol = "\u00F7";
    private final String multiplySymbol = "\u00D7";
    private final String addSymbol = "\u002B";
    private final String subtractSymbol = "-";
    private final String xSquared = powSymbol.concat("(2)");
    private final String squareRootX = rootSymbol.concat("(");
    private final String xPowY = powSymbol.concat("(");
    
    private final String[] mOperationArray = new String[]{powSymbol, rootSymbol, divideSymbol,
            multiplySymbol, addSymbol,
            subtractSymbol};
    private int mIndexOfCurrentOperation;
    
    private StringBuilder mResultBuilder;
    private final StringBuilder mEquationBuilder = new StringBuilder();
    
    private final NumberFormat mNumberFormatter = new DecimalFormat("#0.000000");
    
    
    public Calculator () {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 600);
        setTitle("Calculator");
        setLayout(null);
        
        getContentPane().setBackground(mBackgroundColor);
        
        showUI();
        
        setVisible(true);
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
        mEquationLabel.setFont(mEquationLabel.getFont().deriveFont(13f));
        mEquationLabel.setForeground(Color.GREEN.darker());
        mEquationLabel.setBounds(10, 90, 310, 30);
        add(mEquationLabel);
        
        //Create buttons
        JButton emptyButton = new JButton();
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
        mPlusMinus = new JButton(plusMinusSymbol);
        mClearEqu = new JButton("CE");
        mPow = new JButton("x\u00b2");
        mPowY = new JButton("x\u02b8");
        mRoot = new JButton(rootSymbol);
        mParentheses = new JButton("( )");
        
        //Style buttons
        Border emptyBorder = BorderFactory.createEmptyBorder();
        Font numberFont = new Font("Arial", Font.PLAIN, 18);
        Font otherFont = new Font("Arial", Font.PLAIN, 18);
        Font italicFont = new Font("Arial", Font.ITALIC, 18);
        
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
        mDot.setBackground(Color.WHITE);
        mSub.setBackground(mLightGray);
        mAdd.setBackground(mLightGray);
        mMult.setBackground(mLightGray);
        mDiv.setBackground(mLightGray);
        mEquals.setBackground(mLightBlue);
        mDel.setBackground(mLightGray);
        mClear.setBackground(mLightGray);
        mRoot.setBackground(mLightGray);
        mClearEqu.setBackground(mLightGray);
        mPow.setBackground(mLightGray);
        mPowY.setBackground(mLightGray);
        mParentheses.setBackground(mLightGray);
        mPlusMinus.setBackground(Color.WHITE);
        emptyButton.setBackground(mBackgroundColor);
        
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
        mParentheses.setName("Parentheses");
        mPow.setName("PowerTwo");
        mPowY.setName("PowerY");
        mRoot.setName("SquareRoot");
        mPlusMinus.setName("PlusMinus");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(7, 170, 320, 300);
        buttonPanel.setBackground(mBackgroundColor);
        buttonPanel.setLayout(new GridLayout(6, 4, 3, 3));
        
        
        buttonPanel.add(mParentheses);
        buttonPanel.add(mClearEqu);
        buttonPanel.add(mClear);
        buttonPanel.add(mDel);
        buttonPanel.add(mPow);
        buttonPanel.add(mPowY);
        buttonPanel.add(mRoot);
        buttonPanel.add(mDiv);
        buttonPanel.add(mSeven);
        buttonPanel.add(mEight);
        buttonPanel.add(mNine);
        buttonPanel.add(mMult);
        buttonPanel.add(mFour);
        buttonPanel.add(mFive);
        buttonPanel.add(mSix);
        buttonPanel.add(mSub);
        buttonPanel.add(mOne);
        buttonPanel.add(mTwo);
        buttonPanel.add(mThree);
        buttonPanel.add(mAdd);
        buttonPanel.add(mPlusMinus);
        buttonPanel.add(mZero);
        buttonPanel.add(mDot);
        buttonPanel.add(mEquals);
        
        
        for (Component c : buttonPanel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(this);
                ((JButton) c).setBorder(emptyBorder);
                if (((JButton) c).getText().matches("\\d")) {
                    c.setFont(numberFont);
                } else if (((JButton) c).getText().matches("x.")) {
                    c.setFont(italicFont);
                } else {
                    c.setFont(otherFont);
                }
                
            }
        }
        
        add(buttonPanel);
    }
    
    @Override
    public void actionPerformed (ActionEvent actionEvent) {
        
        updateUI(true);
        
        if (actionEvent.getSource() == mOne) {
            formatEquation("1");
        } else if (actionEvent.getSource() == mTwo) {
            formatEquation("2");
        } else if (actionEvent.getSource() == mThree) {
            formatEquation("3");
        } else if (actionEvent.getSource() == mFour) {
            formatEquation("4");
        } else if (actionEvent.getSource() == mFive) {
            formatEquation("5");
        } else if (actionEvent.getSource() == mSix) {
            formatEquation("6");
        } else if (actionEvent.getSource() == mSeven) {
            formatEquation("7");
        } else if (actionEvent.getSource() == mEight) {
            formatEquation("8");
        } else if (actionEvent.getSource() == mNine) {
            formatEquation("9");
        } else if (actionEvent.getSource() == mZero) {
            formatEquation("0");
        } else if (actionEvent.getSource() == mAdd) {
            formatEquation(addSymbol);
        } else if (actionEvent.getSource() == mSub) {
            if (!mEquationBuilder.toString().isBlank()) {
                formatEquation(subtractSymbol);
            }
        } else if (actionEvent.getSource() == mMult) {
            if (!mEquationBuilder.toString().isBlank()) {
                formatEquation(multiplySymbol);
            }
        } else if (actionEvent.getSource() == mDiv) {
            if (!mEquationBuilder.toString().isBlank()) {
                formatEquation(divideSymbol);
            }
        } else if (actionEvent.getSource() == mPow) {
            if (!mEquationBuilder.toString().isBlank()) {
                formatEquation(xSquared);
            }
        } else if (actionEvent.getSource() == mPowY) {
            if (!mEquationBuilder.toString().isBlank()) {
                formatEquation(xPowY);
            }
        } else if (actionEvent.getSource() == mRoot) {
            formatEquation(squareRootX);
        } else if (actionEvent.getSource() == mDot) {
            formatEquation(".");
        } else if (actionEvent.getSource() == mClear) {
            mEquationBuilder.delete(0, mEquationBuilder.length());
            mResultLabel.setText("0");
        } else if (actionEvent.getSource() == mDel) {
            if (!mEquationLabel.getText().isEmpty()) {
                mEquationBuilder.deleteCharAt(mEquationBuilder.length() - 1);
            }
        } else if (actionEvent.getSource() == mParentheses) {
            handleOpenAndCloseParentheses();
        } else if (actionEvent.getSource() == mPlusMinus) {
            handleNegate();
        } else if (actionEvent.getSource() == mClearEqu) {
            mEquationBuilder.delete(0, mEquationBuilder.length());
        } else if (actionEvent.getSource() == mEquals) {
            
            boolean validEquation = isValidEquation(mEquationBuilder.toString());
            if (validEquation) {
                formatEquation("");
                mResultBuilder = new StringBuilder(mEquationBuilder.toString());
                mIndexOfCurrentOperation = getIndexFromOperatorArray(mResultBuilder.toString());
                
                mResultLabel.setText(solveEquation());
            } else {
                updateUI(false);
            }
            
        }
        mEquationLabel.setText(mEquationBuilder.toString());
    }
    
    private void updateUI (boolean validEquation) {
        
        if (validEquation) {
            mEquationLabel.setForeground(Color.GREEN.darker());
        } else {
            mEquationLabel.setForeground(Color.RED.darker());
        }
        
    }
    
    //negate expression
    private void handleNegate () {
        
        if (mEquationBuilder.toString().length() >= 2 &&
                mEquationBuilder.reverse().substring(0, 2).equals(subtractSymbol + "(")) {
            mEquationBuilder.delete(0, 2);
            mEquationBuilder.reverse();
        } else {
            mEquationBuilder.reverse();
            if (mEquationBuilder.toString().matches(".+[)]")) {
                mEquationBuilder.append(multiplySymbol).append("(").append(subtractSymbol);
            } else if (mEquationBuilder.toString().matches("") ||
                    mEquationBuilder.toString().matches(".+[^0-9]") || mEquationBuilder.toString()
                                                                                       .endsWith(
                                                                                               "(")) {
                mEquationBuilder.append("(").append(subtractSymbol);
            } else {
                boolean isNegated = false;
                int indexToBeInserted = 0;
                int start = 0;
                int end = 0;
                char[] c = mEquationBuilder.toString().toCharArray();
                for (int i = c.length - 1; i >= 0; i--) {
                    
                    if (String.valueOf(c[i]).matches("[^0-9]") && c[i - 1] != '(') {
                        indexToBeInserted = i;
                        break;
                    }
                    
                    if (c[i] == '-' && c[i - 1] == '(') {
                        isNegated = true;
                        start = i - 1;
                        end = i;
                        break;
                    }
                }
                
                if (isNegated) {
                    mEquationBuilder.delete(start, end + 1);
                } else {
                    mEquationBuilder.insert(indexToBeInserted,
                                            "(" + subtractSymbol);
                }
            }
        }
        
        
    }
    
    // Insert open brace or close brace
    private void handleOpenAndCloseParentheses () {
        
        int openParentheses = 0;
        int closeParentheses = 0;
        
        for (int i = 0; i < mEquationBuilder.length(); i++) {
            if (mEquationBuilder.toString().charAt(i) == '(') {
                openParentheses += 1;
            }
            if (mEquationBuilder.toString().charAt(i) == ')') {
                closeParentheses += 1;
            }
        }
        
        if (openParentheses == closeParentheses ||
                mEquationBuilder.toString().charAt(mEquationBuilder.length() - 1) == '(' ||
                String.valueOf(mEquationBuilder.toString().charAt(mEquationBuilder.length() - 1))
                      .matches("[" + addSymbol + multiplySymbol + divideSymbol + subtractSymbol + "]")) {
            
            if (!mEquationBuilder.toString().isEmpty()) {
                if (String.valueOf(mEquationBuilder.charAt(mEquationBuilder.length() - 1))
                          .matches("[\\d)]")) {
                    mEquationBuilder.append(multiplySymbol).append("(");
                } else {
                    mEquationBuilder.append("(");
                }
            } else {
                mEquationBuilder.append("(");
            }
            
        } else if (closeParentheses < openParentheses &&
                mEquationBuilder.toString().charAt(mEquationBuilder.length() - 1) != '(') {
            
            mEquationBuilder.append(")");
        }
        
    }
    
    //Engine room
    private String solveEquation () {
        
        char[] chars;
        if (!mResultBuilder.toString().matches("^-?\\d*\\.?\\d+$")) {
            
            
            while (mResultBuilder.toString().contains("(")) {
                int indexOfLastOpenBrace = 0;
                int indexOfFirstCloseBrace = mResultBuilder.length();
                char[] bracesChar = mResultBuilder.toString().toCharArray();
                
                for (int i = 0; i < bracesChar.length; i++) {
                    if (bracesChar[i] == '(') {
                        indexOfLastOpenBrace = i;
                    }
                    
                    if (bracesChar[i] == ')') {
                        indexOfFirstCloseBrace = i;
                        break;
                        
                    }
                    
                }
                
                String bracesEqu = mResultBuilder.substring(indexOfLastOpenBrace,
                                                            indexOfFirstCloseBrace + 1);
                
                if (bracesEqu.substring(1, bracesEqu.length() - 1).matches("^-?\\d*\\.?\\d+$")) {
                    String subString = bracesEqu.substring(1, bracesEqu.length() - 1);
                    mResultBuilder.replace(indexOfLastOpenBrace, indexOfFirstCloseBrace + 1,
                                           subString);
                    continue;
                }
                
                for (int j = indexOfLastOpenBrace; j < indexOfFirstCloseBrace; j++) {
                    mIndexOfCurrentOperation = getIndexFromOperatorArray(bracesEqu);
                    
                    boolean operatorFound = String.valueOf(bracesChar[j])
                                                  .equals(mOperationArray[mIndexOfCurrentOperation]) ||
                            String.valueOf(bracesChar[j])
                                  .equals(mOperationArray[mIndexOfCurrentOperation + 1]);
                    
                    
                    if (operatorFound) {
                        if (j == 0 || bracesChar[j - 1] == '(') {
                            continue;
                        }
                        updateOperator(String.valueOf(bracesChar[j]));
                        String braceEquIndex = getSubStringEquation(j, mResultBuilder.toString());
                        int startIndex = Integer.parseInt(braceEquIndex.split("\\s")[0]);
                        int endIndex = Integer.parseInt(braceEquIndex.split("\\s")[1]);
                        
                        String calcResult = calculate(braceEquIndex, mResultBuilder.toString());
                        mResultBuilder.replace(startIndex, endIndex + 1, calcResult);
                        
                        
                        
                        
                        break;
                    }
                }
                
                mIndexOfCurrentOperation = getIndexFromOperatorArray(bracesEqu);
                if (mIndexOfCurrentOperation >= mOperationArray.length) {
                    break;
                }
                solveEquation();
                
            }
            
            mIndexOfCurrentOperation = getIndexFromOperatorArray(mResultBuilder.toString());
            
            if (!isValidEquation(mResultBuilder.toString())) {
                updateUI(false);
                return "0";
            }
            
            chars = mResultBuilder.toString().toCharArray();
            while (mIndexOfCurrentOperation < mOperationArray.length
                    && !mResultBuilder.toString().matches("^-?\\d*\\.?\\d+$")) {
                
                for (int k = 0; k < chars.length; k++) {
                    String operator = String.valueOf(chars[k]);
                    boolean operatorFound = operator
                            .equals(mOperationArray[mIndexOfCurrentOperation]) || operator
                            .equals(mOperationArray[mIndexOfCurrentOperation + 1]);
                    if (operatorFound) {
                        
                        if (k == 0 && !operator.equals(rootSymbol)) {
                            continue;
                        }
                        updateOperator(operator);
                        String subStringIndex = getSubStringEquation(k, mResultBuilder.toString());
                        int startIndex = Integer.parseInt(subStringIndex.split("\\s")[0]);
                        int endIndex = Integer.parseInt(subStringIndex.split("\\s")[1]);
                        
                        String calcResult = calculate(subStringIndex, mResultBuilder.toString());
                        mResultBuilder.replace(startIndex, endIndex + 1, calcResult);
                        
                        break;
                    }
                }
                
                mIndexOfCurrentOperation = getIndexFromOperatorArray(mResultBuilder.toString());
                if (mIndexOfCurrentOperation >= mOperationArray.length) {
                    break;
                }
                solveEquation();
            }
            
        }
        
        return mResultBuilder.toString();
    }
    
    //Get the position of the operator with the highest precedence in the current equation
    private int getIndexFromOperatorArray (String currentEquation) {
        
        if (currentEquation.contains(powSymbol) || currentEquation.contains(rootSymbol)) {
            return 0;
        } else if (currentEquation.contains(multiplySymbol) || currentEquation
                .contains(divideSymbol)) {
            return 2;
        } else if (currentEquation.contains(addSymbol) || currentEquation
                .contains(subtractSymbol)) {
            return 4;
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
            case powSymbol:
                mOperator = Operator.POW;
                break;
            case rootSymbol:
                mOperator = Operator.ROOT;
                break;
        }
        
    }
    
    private void formatEquation (String symbol) {
        
        String equation = mEquationBuilder.toString();
        String percentSymbol = "%";
        boolean containsOperator =
                equation.contains(addSymbol) || equation.contains(divideSymbol) || equation
                        .contains(multiplySymbol) || equation.contains(subtractSymbol) || equation
                        .contains(powSymbol) || equation.contains(rootSymbol) || equation
                        .contains(percentSymbol);
        
        String regex = String.format("[%s%s%s%s%s%s%s]", multiplySymbol, divideSymbol,
                                     addSymbol, powSymbol, rootSymbol, percentSymbol,
                                     subtractSymbol);
        
        String[] arr;
        String lastDigits = "";
        
        if (containsOperator) {
            arr = equation.split(regex);
            lastDigits = arr[arr.length - 1];
        }
        
        
        if (symbol.matches("\\d")) {
            
            if (containsOperator) {
                
                if (lastDigits.matches("0") && !(String
                        .valueOf(equation.charAt(equation.length() - 1)).matches(regex))) {
                    mEquationBuilder
                            .replace(mEquationBuilder.length() - 1, mEquationBuilder.length()
                                    , symbol);
                } else {
                    if (!mEquationBuilder.toString().isEmpty()) {
                        if (mEquationBuilder.charAt(mEquationBuilder.length() - 1) == ')') {
                            mEquationBuilder.append(multiplySymbol).append(symbol);
                        } else {
                            mEquationBuilder.append(symbol);
                        }
                    } else {
                        mEquationBuilder.append(symbol);
                    }
                    
                }
            } else {
                if (equation.matches("0")) {
                    mEquationBuilder
                            .replace(mEquationBuilder.length() - 1, mEquationBuilder.length()
                                    , symbol);
                } else {
                    if (!mEquationBuilder.toString().isEmpty()) {
                        if (mEquationBuilder.charAt(mEquationBuilder.length() - 1) == ')') {
                            mEquationBuilder.append(multiplySymbol).append(symbol);
                        } else {
                            mEquationBuilder.append(symbol);
                        }
                    } else {
                        mEquationBuilder.append(symbol);
                    }
                }
            }
            
        } else if (symbol.equals(".")) {
            if (containsOperator) {
                if (!lastDigits.contains(".") || equation.matches("^.*" + regex + "$")) {
                    if (!equation.matches("^.*[\\d.]$")) {
                        mEquationBuilder.append("0").append(".");
                    } else if (equation.matches("^.*\\d$")) {
                        mEquationBuilder.append(".");
                    }
                }
            } else {
                if (!equation.contains(".")) {
                    if (!equation.matches("^.*[\\d.]$")) {
                        mEquationBuilder.append("0").append(".");
                    } else if (equation.matches("^.*\\d$")) {
                        mEquationBuilder.append(".");
                    }
                }
            }
            
        } else {
            if (!mEquationBuilder.toString().isEmpty() || symbol.equals(squareRootX)) {
                if (containsOperator) {
                    if (lastDigits.startsWith(".")) {
                        mEquationBuilder
                                .insert(mEquationBuilder.length() - lastDigits.length(), "0");
                    }
                }
                
                if (equation.endsWith(".")) {
                    mEquationBuilder.insert(mEquationBuilder.length(), "0");
                }
                boolean endsWithOperator =
                        equation.endsWith(addSymbol) || equation
                                .endsWith(subtractSymbol) || equation
                                .endsWith(divideSymbol) || equation.endsWith(multiplySymbol);
                if (endsWithOperator && !symbol.equals(squareRootX)) {
                    mEquationBuilder
                            .replace(mEquationBuilder.length() - 1, mEquationBuilder.length()
                                    , symbol);
                } else {
                    
                    if (symbol.equals(squareRootX) && (equation.endsWith(")") || equation
                            .matches("^.*\\d$"))) {
                        mEquationBuilder.append(multiplySymbol).append(symbol);
                    } else {
                        mEquationBuilder.append(symbol);
                    }
                }
            }
        }
    }
    
    //Checks if equation is valid
    private boolean isValidEquation (String equation) {
        
        boolean equalNumOfBraces = checkNumOfBraces();
        boolean endsWithOperator =
                equation.endsWith(addSymbol) || equation.endsWith(multiplySymbol) || equation
                        .endsWith(divideSymbol) || equation.endsWith(subtractSymbol);
        
        Pattern patternDivideByZero = Pattern.compile("\\d+[" + divideSymbol + "]0");
        Matcher matcherDivideByZero = patternDivideByZero.matcher(equation);
        
        Pattern patternNegativeRoot = Pattern.compile(rootSymbol + "-\\d+");
        Matcher matcherNegativeRoot = patternNegativeRoot.matcher(equation);
        
        return !matcherDivideByZero.find() && !matcherNegativeRoot
                .find() && !endsWithOperator && equalNumOfBraces;
    }
    
    private boolean checkNumOfBraces () {
        
        int openBrace = 0;
        int closeBrace = 0;
        
        char[] chars = mEquationBuilder.toString().toCharArray();
        for (char aChar : chars) {
            if (aChar == '(') {
                openBrace += 1;
            } else if (aChar == ')') {
                closeBrace += 1;
            }
        }
        return openBrace == closeBrace;
    }
    
    //Calculate mini equations
    private String calculate (String subStringIndex, String currentEquation) {
        
        double a;
        double b = 0;
        double result;
        
        int startIndex = Integer.parseInt(subStringIndex.split("\\s")[0]);
        int endIndex = Integer.parseInt(subStringIndex.split("\\s")[1]);
        String regex;
        
        String miniEqu = currentEquation.substring(startIndex, endIndex + 1);
        //
        if (miniEqu.contains(rootSymbol)) {
            regex = rootSymbol;
            
            a = Double.parseDouble(miniEqu.split(regex)[1]);
        } else {
            String format = String.format("(?<!^)[%s%s%s%s%s%s]", rootSymbol, powSymbol,
                                          multiplySymbol, divideSymbol, addSymbol, subtractSymbol);
            Pattern pattern = Pattern.compile("[^0-9]" + subtractSymbol);
            Matcher matcher = pattern.matcher(miniEqu);
            if (miniEqu.startsWith(subtractSymbol)) {
                regex = format;
                
                String[] split = miniEqu.split(regex);
                a = Double.parseDouble(split[0]);
                b = Double.parseDouble(split[1]);
                //
            } else if (matcher.find()) {
                regex = format;
                
                String[] split = miniEqu.split(regex);
                //
                a = Double.parseDouble(split[0]);
                b = Double.parseDouble(split[split.length - 1].trim());
                b = -b;
            } else {
                regex = format;
                
                a = Double.parseDouble(miniEqu.split(regex)[0]);
                b = Double.parseDouble(miniEqu.split(regex)[1]);
            }
        }

//
//
        
        switch (mOperator) {
            case ADD:
                result = a + b;
                break;
            case SUBTRACT:
                result = a - b;
                break;
            case DIVIDE:
                result = a / b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
            case POW:
                result = Math.pow(a, b);
                break;
            case ROOT:
                result = Math.sqrt(a);
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

//
//
        
        int startIndex = 0;
        int endIndex = equation.length() - 1;
        
        for (int i = leftSideOfOperator.length() - 1; i >= 0; i--) {
            String characterAtCurrentIndex = String.valueOf(equation.charAt(i));
            boolean matches =
                    characterAtCurrentIndex.equals(multiplySymbol)
                            || characterAtCurrentIndex.equals(divideSymbol)
                            || characterAtCurrentIndex.equals(addSymbol)
                            || characterAtCurrentIndex.equals(subtractSymbol)
                            || characterAtCurrentIndex.equals("(");
            
            if (i != 0 && characterAtCurrentIndex.equals(subtractSymbol) && equation
                    .charAt(i - 1) == '(') {
                startIndex = 1;
                break;
            }
//
            if (matches) {
                if (i != 0 || characterAtCurrentIndex.equals("(")) {
                    startIndex = i + 1;
                }
                break;
            }
        }
        
        for (int i = 1; i <= rightSideOfOperator.length(); i++) {
            int index = indexOfOperator + i;
            String characterAtCurrentIndex = String.valueOf(equation.charAt(index));
            boolean matches =
                    characterAtCurrentIndex.equals(multiplySymbol)
                            || characterAtCurrentIndex.equals(divideSymbol)
                            || characterAtCurrentIndex.equals(addSymbol)
                            || characterAtCurrentIndex.equals(subtractSymbol)
                            || characterAtCurrentIndex.equals(")");
            if (matches) {
                if (characterAtCurrentIndex
                        .equals(subtractSymbol) && index == indexOfOperator + 1) {
                    continue;
                }
                endIndex = index - 1;
                break;
            }
        }
        
        return startIndex + " " + endIndex;
    }
}

