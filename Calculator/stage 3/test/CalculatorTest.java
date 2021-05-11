import calculator.Calculator;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JLabelFixture;
import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.SwingTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.swing.SwingComponent;

import static org.hyperskill.hstest.testcase.CheckResult.correct;
import static org.hyperskill.hstest.testcase.CheckResult.wrong;

public class CalculatorTest extends SwingTest {
    
    @SwingComponent(name = "ButtonEquals")
    private JButtonFixture mEqual;
    @SwingComponent(name = "ButtonAdd")
    private JButtonFixture mAdd;
    @SwingComponent(name = "ButtonSubtract")
    private JButtonFixture mSub;
    @SwingComponent(name = "ButtonDivide")
    private JButtonFixture mDiv;
    @SwingComponent(name = "ButtonMultiply")
    private JButtonFixture mMult;
    @SwingComponent(name = "ButtonZero")
    private JButtonFixture mZero;
    @SwingComponent(name = "ButtonOne")
    private JButtonFixture mOne;
    @SwingComponent(name = "ButtonTwo")
    private JButtonFixture mTwo;
    @SwingComponent(name = "ButtonThree")
    private JButtonFixture mThree;
    @SwingComponent(name = "ButtonFour")
    private JButtonFixture mFour;
    @SwingComponent(name = "ButtonFive")
    private JButtonFixture mFive;
    @SwingComponent(name = "ButtonSix")
    private JButtonFixture mSix;
    @SwingComponent(name = "ButtonSeven")
    private JButtonFixture mSeven;
    @SwingComponent(name = "ButtonEight")
    private JButtonFixture mEight;
    @SwingComponent(name = "ButtonNine")
    private JButtonFixture mNine;
    @SwingComponent(name = "ButtonDot")
    private JButtonFixture mDot;
    @SwingComponent(name = "ButtonClear")
    private JButtonFixture mClear;
    @SwingComponent(name = "ButtonDelete")
    private JButtonFixture mDel;
    
    @SwingComponent(name = "EquationLabel")
    private JLabelFixture mEquationLabel;
    @SwingComponent(name = "ResultLabel")
    private JLabelFixture mResultLabel;
    
    private final String divideSymbol = "\u00F7";
    private final String multiplySymbol = "\u00D7";
    private final String addSymbol = "\u002B";
    private final String subtractSymbol = "-";
    
    public CalculatorTest () {
        
        super(new Calculator());
    }
    
    @DynamicTest
    CheckResult test1 () {
        
        requireEnabled(mEqual, mAdd, mSub, mDiv, mMult, mOne, mTwo, mThree, mFour, mFive, mSix,
                       mSeven, mEight, mNine, mZero, mDot, mClear, mDel, mEquationLabel,
                       mResultLabel);
        
        requireVisible(mEqual, mAdd, mSub, mDiv, mMult, mOne, mTwo, mThree, mFour, mFive, mSix,
                       mSeven, mEight, mNine, mZero, mDot, mClear, mDel, mEquationLabel,
                       mResultLabel);
        
        return correct();
    }
    
    @DynamicTest()
    CheckResult test2 () {
        
        mOne.click();
        if (!mEquationLabel.text().trim().equals("1")) {
            return wrong("Clicking ButtonOne adds a wrong number to the EquationLabel");
        }
        
        mDel.click();
        if (!mEquationLabel.text().trim().equals("")) {
            return wrong("Clicking on the ButtonDelete should delete the last character from the " +
                                 "EquationLabel");
        }
        
        mOne.click();
        mOne.click();
        mOne.click();
        if (!mEquationLabel.text().trim().equals("111")) {
            return wrong("Clicking ButtonOne adds a wrong number to the EquationLabel");
        }
        
        mClear.click();
        if (!mEquationLabel.text().trim().equals("")) {
            return wrong("Clicking on the ButtonClear should delete all the characters from the " +
                                 "EquationLabel");
        }
        
        
        return correct();
    }
    
    // Pushing buttons
    @DynamicTest()
    CheckResult test3 () {
        
        mOne.click();
        if (!mEquationLabel.text().trim().equals("1")) {
            return wrong("Clicking ButtonOne adds a wrong number to the EquationLabel");
        }
        mClear.click();
        
        mTwo.click();
        if (!mEquationLabel.text().trim().equals("2")) {
            return wrong("Clicking ButtonTwo adds a wrong number to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mThree.click();
        if (!mEquationLabel.text().trim().equals("3")) {
            return wrong("Clicking ButtonThree adds a wrong number to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mFour.click();
        if (!mEquationLabel.text().trim().equals("4")) {
            return wrong("Clicking ButtonFour adds a wrong number to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mFive.click();
        if (!mEquationLabel.text().trim().equals("5")) {
            return wrong("Clicking ButtonFive adds a wrong number to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mSix.click();
        if (!mEquationLabel.text().trim().equals("6")) {
            return wrong("Clicking ButtonSix adds a wrong number to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mSeven.click();
        if (!mEquationLabel.text().trim().equals("7")) {
            return wrong("Clicking ButtonSeven adds a wrong number to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mEight.click();
        if (!mEquationLabel.text().trim().equals("8")) {
            return wrong("Clicking ButtonEight adds a wrong number to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mNine.click();
        if (!mEquationLabel.text().trim().equals("9")) {
            return wrong("Clicking ButtonNine adds a wrong number to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mZero.click();
        if (!mEquationLabel.text().trim().equals("0")) {
            return wrong("Clicking ButtonZero adds a wrong number to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mAdd.click();
        if (!mEquationLabel.text().trim().equals("+") && !mEquationLabel.text().trim().equals(addSymbol)) {
            return wrong("Clicking ButtonAdd adds a wrong character to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mSub.click();
        if (!mEquationLabel.text().trim().equals("-") && !mEquationLabel.text().trim().equals(subtractSymbol)) {
            return wrong("Clicking ButtonSubtract adds a wrong character to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mMult.click();
        if (!mEquationLabel.text().trim().equals("x") && !mEquationLabel.text().trim().equals(multiplySymbol)) {
            return wrong("Clicking ButtonDivide adds a wrong character to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        mDiv.click();
        if (!mEquationLabel.text().trim().equals("/") && !mEquationLabel.text().trim().equals(divideSymbol)) {
            return wrong("Clicking ButtonMultiply adds a wrong character to the " +
                                 "EquationTextField");
        }
        mClear.click();
        
        return correct();
    }
    
    //Testing calculations
    @DynamicTest()
    CheckResult test4 () {
        //Addition
        mOne.click();
        mAdd.click();
        mOne.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("2")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 2");
        }
        mClear.click();
        
        mNine.click();
        mAdd.click();
        mOne.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("10")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 10");
        }
        mClear.click();
        
        //Subtraction
        mOne.click();
        mSub.click();
        mNine.click();
        mNine.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("-98")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected -98");
        }
        mClear.click();
        
        mNine.click();
        mZero.click();
        mSub.click();
        mThree.click();
        mSix.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("54")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 54");
        }
        mClear.click();
        
        //Division
        mNine.click();
        mDiv.click();
        mTwo.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("4.5")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 4.5");
        }
        mClear.click();
        
        mZero.click();
        mDiv.click();
        mSeven.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("0")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 0");
        }
        mClear.click();
        
        //Multiplication
        mFour.click();
        mDot.click();
        mFive.click();
        mMult.click();
        mTwo.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("9")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 9");
        }
        mClear.click();
        
        return correct();
    }
    
    //Test operator precedence
    @DynamicTest()
    CheckResult test5 () {
        //Add & Subtract
        mTwo.click();
        mAdd.click();
        mFive.click();
        mSub.click();
        mThree.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("4")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 4");
        }
        mClear.click();
        
        mOne.click();
        mOne.click();
        mSub.click();
        mFive.click();
        mAdd.click();
        mFour.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("10")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 10");
        }
        mClear.click();
        
        mThree.click();
        mAdd.click();
        mTwo.click();
        mSub.click();
        mSeven.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("-2")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected -2");
        }
        mClear.click();
        
        mTwo.click();
        mSub.click();
        mOne.click();
        mSeven.click();
        mAdd.click();
        mFive.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("-10")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected -10");
        }
        mClear.click();
        
        //Multiply & Divide
        mFour.click();
        mMult.click();
        mFive.click();
        mDiv.click();
        mOne.click();
        mZero.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("2")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 2");
        }
        mClear.click();
        
        mNine.click();
        mDiv.click();
        mTwo.click();
        mMult.click();
        mEight.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("36")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 36");
        }
        mClear.click();
        
        //Combined
        mTwo.click();
        mAdd.click();
        mThree.click();
        mSub.click();
        mFive.click();
        mMult.click();
        mSix.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("-25")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected -25");
        }
        mClear.click();
        
        mTwo.click();
        mSub.click();
        mThree.click();
        mAdd.click();
        mFive.click();
        mMult.click();
        mSix.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("29")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 29");
        }
        mClear.click();
        
        mOne.click();
        mSix.click();
        mAdd.click();
        mNine.click();
        mSub.click();
        mSeven.click();
        mDiv.click();
        mFive.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("23.6")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 23.6");
        }
        mClear.click();
        
        mOne.click();
        mSix.click();
        mSub.click();
        mNine.click();
        mAdd.click();
        mSeven.click();
        mDiv.click();
        mFive.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("8.4")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 8.4");
        }
        mClear.click();
        
        mTwo.click();
        mFive.click();
        mAdd.click();
        mNine.click();
        mDiv.click();
        mThree.click();
        mSub.click();
        mEight.click();
        mMult.click();
        mEight.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("-36")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected -36");
        }
        mClear.click();
        
        mTwo.click();
        mFive.click();
        mAdd.click();
        mNine.click();
        mMult.click();
        mThree.click();
        mSub.click();
        mEight.click();
        mDiv.click();
        mEight.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("51")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 51");
        }
        mClear.click();
        
        mNine.click();
        mDiv.click();
        mThree.click();
        mMult.click();
        mSix.click();
        mDiv.click();
        mTwo.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("9")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 9");
        }
        mClear.click();
        
        mNine.click();
        mMult.click();
        mThree.click();
        mDiv.click();
        mSix.click();
        mMult.click();
        mTwo.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("9")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 9");
        }
        mClear.click();
        
        mThree.click();
        mDot.click();
        mEight.click();
        mMult.click();
        mSeven.click();
        mDot.click();
        mFive.click();
        mDiv.click();
        mTwo.click();
        mDot.click();
        mFive.click();
        mMult.click();
        mFive.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("57")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 57");
        }
        mClear.click();
        
        mNine.click();
        mDot.click();
        mTwo.click();
        mDiv.click();
        mTwo.click();
        mDot.click();
        mThree.click();
        mMult.click();
        mOne.click();
        mTwo.click();
        mDiv.click();
        mTwo.click();
        mDot.click();
        mFour.click();
        mEqual.click();
        
        if (!mResultLabel.text().trim().equals("20")) {
            return wrong(
                    "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                            ". Expected 20");
        }
        mClear.click();
        
        return correct();
    }
    
}