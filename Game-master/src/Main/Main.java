package Main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Inicia o Swing na thread correta (melhor prática)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }
}