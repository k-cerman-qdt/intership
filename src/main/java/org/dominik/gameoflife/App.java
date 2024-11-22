package org.dominik.gameoflife;

import org.dominik.gameoflife.gui.MainFrame;

import javax.swing.SwingUtilities;


public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
