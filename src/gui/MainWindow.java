package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JButton personButton;
    private JButton guideButton;
    private JButton companyButton;

    public MainWindow() {
        initializeComponents();
        setupLayout();
        setupListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents() {
        personButton = new JButton("Person View");
        guideButton = new JButton("Guide View");
        companyButton = new JButton("Company View");
    }

    private void setupLayout() {
        setLayout(new GridLayout(3, 1));
        add(personButton);
        add(guideButton);
        add(companyButton);
    }

    private void setupListeners() {
        personButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPersonView();
            }
        });

        guideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGuideView();
            }
        });
        companyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCompanyView();
            }
        });
    }

    private void openPersonView() {
        PersonView personView = new PersonView();
        personView.setVisible(true);
    }

    private void openGuideView() {
        GuideView guideView = new GuideView();
        guideView.setVisible(true);
    }

    private void openCompanyView() {
        CompanyView companyView = new CompanyView();
        companyView.setVisible(true);
    }
}
