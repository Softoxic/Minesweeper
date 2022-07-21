package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JLabel difficulties;
    private JPanel mainPanel;
    private JButton beginner, intermediate, expert;
    
    public Menu(){
        Components();
    }

    private void Components(){
        creatorMethod();
        addMethod();

//        setMinimumSize(new Dimension(600,750));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    private void creatorMethod(){
        mainPanel = new JPanel(new FlowLayout());

        setTitle("Minesweeper");
        
        // Label of buttons
        difficulties = new JLabel("Difficulties: ");

        buttonsCreator();
    }

    private void expertButton(){
        setVisible(false);
        new Game("expert").setVisible(true);
    }

    private void intermediateButton(){
        setVisible(false);
        new Game("intermediate").setVisible(true);
    }

    private void beginnerButton(){
        setVisible(false);
        new Game("beginner").setVisible(true);
    }

    private void addMethod(){
        mainPanel.add(difficulties);
        mainPanel.add(beginner);
        mainPanel.add(intermediate);
        mainPanel.add(expert);
        add(mainPanel);
    }

    private void buttonsCreator(){
        beginner = new JButton("Beginner");
        beginner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beginnerButton();
            }
        });

        intermediate = new JButton("Intermediate");
        intermediate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intermediateButton();
            }
        });

        expert = new JButton("Expert");
        expert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expertButton();
            }
        });
    }
}