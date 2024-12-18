
package project_java;

import javax.swing.*;

public class Processor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGuessGame());
    }
}
