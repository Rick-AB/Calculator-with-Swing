package calculators;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        new Calculator();
        String[] fonts =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    
        for (String font : fonts) {
            System.out.println(font);
        }
    }
}
