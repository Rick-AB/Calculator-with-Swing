import calculator.Calculator;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
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
    
    @SwingComponent(name = "EquationTextField")
    private JTextComponentFixture mEquation;
    
    
    public CalculatorTest () {
        
        super(new Calculator());
    }
    
    @DynamicTest
    CheckResult test1 () {
        
        requireEnabled(mEqual, mAdd, mSub, mDiv, mMult, mOne, mTwo, mThree, mFour, mFive, mSix,
                       mSeven, mEight, mNine, mZero);
        
        requireVisible(mEqual, mAdd, mSub, mDiv, mMult, mOne, mTwo, mThree, mFour, mFive, mSix,
                       mSeven, mEight, mNine, mZero);
        
        return correct();
    }
    
    // Pushing buttons
    @DynamicTest()
    CheckResult test2 () {
        
        mOne.click();
        if (!mEquation.text().trim().equals("1")) {
            return wrong("Clicking ButtonOne adds a wrong number to the EquationTextField");
        }
        mEquation.setText("");
        
        mTwo.click();
        if (!mEquation.text().trim().equals("2")) {
            return wrong("Clicking ButtonTwo adds a wrong number to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mThree.click();
        if (!mEquation.text().trim().equals("3")) {
            return wrong("Clicking ButtonThree adds a wrong number to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mFour.click();
        if (!mEquation.text().trim().equals("4")) {
            return wrong("Clicking ButtonFour adds a wrong number to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mFive.click();
        if (!mEquation.text().trim().equals("5")) {
            return wrong("Clicking ButtonFive adds a wrong number to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mSix.click();
        if (!mEquation.text().trim().equals("6")) {
            return wrong("Clicking ButtonSix adds a wrong number to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mSeven.click();
        if (!mEquation.text().trim().equals("7")) {
            return wrong("Clicking ButtonSeven adds a wrong number to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mEight.click();
        if (!mEquation.text().trim().equals("8")) {
            return wrong("Clicking ButtonEight adds a wrong number to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mNine.click();
        if (!mEquation.text().trim().equals("9")) {
            return wrong("Clicking ButtonNine adds a wrong number to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mZero.click();
        if (!mEquation.text().trim().equals("0")) {
            return wrong("Clicking ButtonZero adds a wrong number to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mAdd.click();
        if (!mEquation.text().trim().equals("+")) {
            return wrong("Clicking ButtonAdd adds a wrong character to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mSub.click();
        if (!mEquation.text().trim().equals("-")) {
            return wrong("Clicking ButtonSubtract adds a wrong character to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mMult.click();
        if (!mEquation.text().trim().equals("x")) {
            return wrong("Clicking ButtonDivide adds a wrong character to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        mDiv.click();
        if (!mEquation.text().trim().equals("/")) {
            return wrong("Clicking ButtonMultiply adds a wrong character to the " +
                                 "EquationTextField");
        }
        mEquation.setText("");
        
        return correct();
    }
    
    //Testing calculations
    @DynamicTest()
    CheckResult test3 () {
        //Add operations
        mOne.click();
        mAdd.click();
        mOne.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("1+1=2")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mNine.click();
        mAdd.click();
        mOne.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("9+1=10")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mNine.click();
        mNine.click();
        mAdd.click();
        mOne.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("99+1=100")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mNine.click();
        mNine.click();
        mNine.click();
        mNine.click();
        mAdd.click();
        mOne.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("9999+1=10000")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mZero.click();
        mAdd.click();
        mZero.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("0+0=0")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mZero.click();
        mAdd.click();
        mSeven.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("0+7=7")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mFive.click();
        mNine.click();
        mNine.click();
        mAdd.click();
        mSix.click();
        mNine.click();
        mNine.click();
        mEqual.click();
        
        if (mEquation.text().contains("599+699=1298")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        return correct();
    }
    
    @DynamicTest()
    CheckResult test4 () {
        //Subtract operations
        mOne.click();
        mSub.click();
        mOne.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("1-1=0")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mNine.click();
        mSub.click();
        mOne.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("9-1=8")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mNine.click();
        mNine.click();
        mSub.click();
        mOne.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("99-1=98")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mFour.click();
        mEight.click();
        mSub.click();
        mThree.click();
        mSix.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("48-36=12")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mOne.click();
        mTwo.click();
        mSub.click();
        mSeven.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("12-7=5")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mFour.click();
        mZero.click();
        mSub.click();
        mThree.click();
        mZero.click();
        mEqual.click();
        
        if (mEquation.text().contains("40-30=10")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        return correct();
    }
    
    @DynamicTest()
    CheckResult test5 () {
        //Multiply operations
        mOne.click();
        mMult.click();
        mOne.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("1x1=1")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mNine.click();
        mMult.click();
        mOne.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("9x1=9")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mNine.click();
        mNine.click();
        mMult.click();
        mThree.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("99x3=297")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mFour.click();
        mEight.click();
        mMult.click();
        mThree.click();
        mSix.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("48x36=1728")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mOne.click();
        mTwo.click();
        mMult.click();
        mZero.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("12x0=0")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mTwo.click();
        mFour.click();
        mThree.click();
        mMult.click();
        mOne.click();
        mThree.click();
        mEqual.click();
        
        if (mEquation.text().contains("243x13=3159")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        return correct();
    }
    
    @DynamicTest()
    CheckResult test6 () {
        //Divide operations
        mOne.click();
        mDiv.click();
        mOne.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("1/1=1")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mNine.click();
        mDiv.click();
        mThree.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("9/3=3")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mNine.click();
        mNine.click();
        mDiv.click();
        mThree.click();
        mThree.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("99/33=3")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mFour.click();
        mNine.click();
        mDiv.click();
        mSeven.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("49/7=7")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        mEight.click();
        mOne.click();
        mDiv.click();
        mNine.click();
        mEqual.click();
        
        if (mEquation.text().trim().equals("81/9=9")) {
            return wrong("The calculation result your app shows is wrong");
        }
        mEquation.setText("");
        
        return correct();
    }
    
}