package nz.ac.massey.cs251;

import javax.swing.*;
import java.awt.*;

public class Main {
    static void main(String[] args) {
        //Create an empty window for the text editor
        //Set it to exit the program when you close it
        //Set the window to fit the whole screen
        //Set the minimum size to be 800 by 600
        JFrame textWindow = new JFrame("Text Window");
        textWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        textWindow.setMinimumSize(new Dimension(800, 600));

        // Adds a menu bar with File, Edit, Search, View, and Help
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu searchMenu = new JMenu("Search");
        JMenu viewMenu = new JMenu("View");
        JMenu manageMenu = new JMenu("Manage");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(searchMenu);
        menuBar.add(viewMenu);
        menuBar.add(manageMenu);
        menuBar.add(helpMenu);
        textWindow.setJMenuBar(menuBar);
        textWindow.setSize(800, 600);

        // Adds sub-menu items
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Save"));
        fileMenu.add(new JMenuItem("Exit"));
        fileMenu.add(new JMenuItem("Print"));

        //Adds a text area into the window.
        JTextArea textArea = new JTextArea();

        //Sets a container to the full size of the JFrame
        Container text = textWindow.getContentPane();

        //Adds the text area to the container
        text.add(textArea);

        //Makes the JFrame visible
        textWindow.setVisible(true);
    }
}
