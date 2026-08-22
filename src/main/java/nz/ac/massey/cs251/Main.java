package nz.ac.massey.cs251;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        //Create an empty window for the text editor
        //Set it to exit the program when you close it
        //Set the window to fit the whole screen
        //Set the minimum size to be 800 by 600
        JFrame textWindow = new JFrame("Text Window");
        textWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        textWindow.setMinimumSize(new Dimension(800, 600));

        //Adds a text area into the window.
        JTextArea textArea = new JTextArea();

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

        // Adds sub-menu items
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(e -> createAndShowGUI());

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Text files (txt, java, cpp, py, html, css, js)",
                    "txt", "java", "cpp", "py", "html", "css", "js");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(textWindow);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    String content = java.nio.file.Files.readString(chooser.getSelectedFile().toPath());
                    textArea.setText(content);
                } catch (java.io.IOException ex) {
                    JOptionPane.showMessageDialog(textWindow,
                            "Could not open file:\n" + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showSaveDialog(textWindow);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                java.io.File file = chooser.getSelectedFile();
                if (!file.getName().toLowerCase().endsWith(".txt")) {
                    file = new java.io.File(file.getParentFile(), file.getName() + ".txt");
                }
                try {
                    java.nio.file.Files.writeString(file.toPath(), textArea.getText());
                } catch (java.io.IOException ex) {
                    JOptionPane.showMessageDialog(textWindow,
                            "Could not save file:\n" + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));

        JMenuItem printMenuItem = new JMenuItem("Print");
        printMenuItem.addActionListener(e -> {
            try {
                textArea.print();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(textWindow,
                        "Printing failed:\n" + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        fileMenu.add(printMenuItem);

        //Sets a container to the full size of the JFrame
        Container text = textWindow.getContentPane();

        //Adds the text area to the container
        text.add(textArea);

        //Makes the JFrame visible
        textWindow.setVisible(true);
    }
}
