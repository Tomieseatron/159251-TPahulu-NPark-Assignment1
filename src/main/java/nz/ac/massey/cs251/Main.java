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
