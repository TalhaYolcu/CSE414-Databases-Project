package gui;

import models.Guide;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{
    private JPanel mainPanel;
    private JButton personButton;
    private JButton guideButton;
    private JButton generalButton;

    private JPanel mainlayout = new JPanel(new GridBagLayout());
    private JPanel btnPanel = new JPanel(new GridLayout(10, 1, 10, 5));

    private JButton button1;
    public MainWindow() {
        // Create the main panel
        mainPanel.setBorder(new EmptyBorder(2, 3, 2, 3));

        setContentPane(mainPanel);

        setTitle("Travel Booking System");
        setSize(800,800);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainlayout.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Create the buttons
        personButton = new JButton("Person Views");
        guideButton = new JButton("Guide Views");
        generalButton = new JButton("General Views");

        btnPanel.add(personButton);
        btnPanel.add(guideButton);
        btnPanel.add(generalButton);

        mainlayout.add(btnPanel);

        mainPanel.add(mainlayout,BorderLayout.CENTER);


        // Add action listeners to the buttons
        personButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPersonViews();
            }
        });

        guideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showGuideViews();
            }
        });

        generalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showGeneralViews();
            }
        });


    }
    private void showPersonViews() {
        mainlayout.setVisible(false);
        mainPanel.add(new PersonView(mainlayout),BorderLayout.CENTER);
    }
    private void showGuideViews() {
        mainlayout.setVisible(false);
        mainPanel.add(new GuideView(mainlayout),BorderLayout.CENTER);
    }
    private void showGeneralViews() {
        mainlayout.setVisible(false);
        mainPanel.add(new GeneralView(mainlayout),BorderLayout.CENTER);
    }
}
