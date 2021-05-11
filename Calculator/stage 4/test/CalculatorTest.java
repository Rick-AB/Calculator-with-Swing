import calculator.Calculator;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JLabelFixture;
import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.SwingTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.swing.SwingComponent;

import java.awt.*;

import static org.hyperskill.hstest.testcase.CheckResult.correct;
import static org.hyperskill.hstest.testcase.CheckResult.wrong;

public class CalculatorTest extends SwingTest {
  
  @SwingComponent(name = "Equals")
  private JButtonFixture mEqual;
  @SwingComponent(name = "Add")
  private JButtonFixture mAdd;
  @SwingComponent(name = "Subtract")
  private JButtonFixture mSub;
  @SwingComponent(name = "Divide")
  private JButtonFixture mDiv;
  @SwingComponent(name = "Multiply")
  private JButtonFixture mMult;
  @SwingComponent(name = "Zero")
  private JButtonFixture mZero;
  @SwingComponent(name = "One")
  private JButtonFixture mOne;
  @SwingComponent(name = "Two")
  private JButtonFixture mTwo;
  @SwingComponent(name = "Three")
  private JButtonFixture mThree;
  @SwingComponent(name = "Four")
  private JButtonFixture mFour;
  @SwingComponent(name = "Five")
  private JButtonFixture mFive;
  @SwingComponent(name = "Six")
  private JButtonFixture mSix;
  @SwingComponent(name = "Seven")
  private JButtonFixture mSeven;
  @SwingComponent(name = "Eight")
  private JButtonFixture mEight;
  @SwingComponent(name = "Nine")
  private JButtonFixture mNine;
  @SwingComponent(name = "Dot")
  private JButtonFixture mDot;
  @SwingComponent(name = "Clear")
  private JButtonFixture mClear;
  @SwingComponent(name = "Delete")
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
      return wrong("Clicking One adds a wrong number to the EquationLabel");
    }
    
    mDel.click();
    if (!mEquationLabel.text().trim().equals("")) {
      return wrong("Clicking on the Delete should delete the last character from the " +
                           "EquationLabel");
    }
    
    mOne.click();
    mOne.click();
    mOne.click();
    if (!mEquationLabel.text().trim().equals("111")) {
      return wrong("Clicking One adds a wrong number to the EquationLabel");
    }
    
    mClear.click();
    if (!mEquationLabel.text().trim().equals("")) {
      return wrong("Clicking on the Clear should delete all the characters from the " +
                           "EquationLabel");
    }
    
    
    return correct();
  }
  
  // Pushing buttons
  @DynamicTest()
  CheckResult test3 () {
    String lastChar;
    
    mOne.click();
    if (!mEquationLabel.text().trim().equals("1")) {
      return wrong("Clicking One adds a wrong number to the EquationLabel");
    }
    mClear.click();
    
    mTwo.click();
    if (!mEquationLabel.text().trim().equals("2")) {
      return wrong("Clicking Two adds a wrong number to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mThree.click();
    if (!mEquationLabel.text().trim().equals("3")) {
      return wrong("Clicking Three adds a wrong number to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mFour.click();
    if (!mEquationLabel.text().trim().equals("4")) {
      return wrong("Clicking Four adds a wrong number to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mFive.click();
    if (!mEquationLabel.text().trim().equals("5")) {
      return wrong("Clicking Five adds a wrong number to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mSix.click();
    if (!mEquationLabel.text().trim().equals("6")) {
      return wrong("Clicking Six adds a wrong number to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mSeven.click();
    if (!mEquationLabel.text().trim().equals("7")) {
      return wrong("Clicking Seven adds a wrong number to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mEight.click();
    if (!mEquationLabel.text().trim().equals("8")) {
      return wrong("Clicking Eight adds a wrong number to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mNine.click();
    if (!mEquationLabel.text().trim().equals("9")) {
      return wrong("Clicking Nine adds a wrong number to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mZero.click();
    if (!mEquationLabel.text().trim().equals("0")) {
      return wrong("Clicking Zero adds a wrong number to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mOne.click();
    mAdd.click();
    
    lastChar =
            String.valueOf(mEquationLabel.text().trim().charAt(mEquationLabel.text().length() - 1));
    if (!lastChar.equals("+") && !lastChar.equals(addSymbol)) {
      return wrong("Clicking Add adds a wrong character to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mOne.click();
    mSub.click();
    
    lastChar =
            String.valueOf(mEquationLabel.text().trim().charAt(mEquationLabel.text().length() - 1));
    if (!lastChar.equals("-") && !lastChar.equals(subtractSymbol)) {
      return wrong("Clicking Subtract adds a wrong character to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mOne.click();
    mMult.click();
    
    lastChar =
            String.valueOf(mEquationLabel.text().trim().charAt(mEquationLabel.text().length() - 1));
    if (!lastChar.equals("x") && !lastChar.equals(multiplySymbol)) {
      return wrong("Clicking Multiply adds a wrong character to the " +
                           "EquationLabel");
    }
    mClear.click();
    
    mOne.click();
    mDiv.click();
    
    lastChar =
            String.valueOf(mEquationLabel.text().trim().charAt(mEquationLabel.text().length() - 1));
    if (!lastChar.equals("/") && !lastChar.equals(divideSymbol)) {
      return wrong("Clicking Divide adds a wrong character to the " +
                           "EquationLabel");
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
  
  //test operator precedence
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
  
  //test formatting equations
  @DynamicTest
  CheckResult test6() {
    String lastChar;
    
    mDot.click();
    mSix.click();
    mAdd.click();
    
    if (!mEquationLabel.text().trim().contains("0.6")) {
      return wrong("Your program should properly format the equation whenever an operator is " +
                           "inserted.");
    }
    mClear.click();
    
    mSeven.click();
    mDot.click();
    mMult.click();
    
    if (!mEquationLabel.text().trim().contains("7.0")) {
      return wrong("Your program should properly format the equation whenever an operator is " +
                           "inserted.");
    }
    mClear.click();
    
    mAdd.click();
    if (!mEquationLabel.text().trim().isBlank() || !mEquationLabel.text().trim().isEmpty()) {
      return wrong("Equations should not start with an operator");
    }
    mClear.click();
    
    mMult.click();
    if (!mEquationLabel.text().trim().isBlank() || !mEquationLabel.text().trim().isEmpty()) {
      return wrong("Equations should not start with an operator");
    }
    mClear.click();
    
    mDiv.click();
    if (!mEquationLabel.text().trim().isBlank() || !mEquationLabel.text().trim().isEmpty()) {
      return wrong("Equations should not start with an operator");
    }
    mClear.click();
    
    mSub.click();
    if (!mEquationLabel.text().trim().isBlank() || !mEquationLabel.text().trim().isEmpty()) {
      return wrong("Equations should not start with an operator");
    }
    mClear.click();
    
    mTwo.click();
    mAdd.click();
    mMult.click();
    
    lastChar =
            String.valueOf(mEquationLabel.text().trim().charAt(mEquationLabel.text().length() - 1));
    if (!lastChar.equals(multiplySymbol) && !lastChar.equals("x")) {
      return wrong("Clicking on an operator should override the preceding operator");
    }
    mClear.click();
    
    mFive.click();
    mDiv.click();
    mAdd.click();
    
    lastChar =
            String.valueOf(mEquationLabel.text().trim().charAt(mEquationLabel.text().length() - 1));
    if (!lastChar.equals(addSymbol) && !lastChar.equals("+")) {
      return wrong("Clicking on an operator should override the preceding operator");
    }
    mClear.click();
    
    mSix.click();
    mAdd.click();
    mDiv.click();
    mTwo.click();
    mEqual.click();
    
    if (!mResultLabel.text().trim().equals("3")) {
      return wrong(
              "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                      ". Expected 3");
    }
    mClear.click();
    
    mSeven.click();
    mMult.click();
    mSub.click();
    mFour.click();
    mEqual.click();
    
    if (!mResultLabel.text().trim().equals("3")) {
      return wrong(
              "The calculation result your app shows is wrong. " + mEquationLabel.text() +
                      ". Expected 3");
    }
    mClear.click();
    
    return correct();
  }
  
  //test equation validation
  @DynamicTest(feedback = "The color of EquationLabel should change to indicate invalid equations" +
          " when the EqualButton is clicked")
  CheckResult test7() {
    
    mTwo.click();
    mAdd.click();
    mEqual.click();
    
    mEquationLabel.foreground().requireEqualTo(Color.RED.darker());
    mClear.click();
    
    mFive.click();
    mDiv.click();
    mZero.click();
    mEqual.click();
    
    mEquationLabel.foreground().requireEqualTo(Color.RED.darker());
    mClear.click();
    
    return correct();
  }
  
}