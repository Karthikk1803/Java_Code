package Swing;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JframeOne f1 = new JframeOne();
            }
        });
    }
}
