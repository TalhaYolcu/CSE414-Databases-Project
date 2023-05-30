package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralView extends JPanel {
    private JButton personEdit = new JButton("Person Edit");
    private JButton flightEdit = new JButton("Flight Edit");
    private JButton busEdit = new JButton("Bus Edit");
    private JButton carRentalEdit = new JButton("Car Rental Edit");
    private JButton hotelEdit = new JButton("Hotel Edit");
    private JButton tourEdit = new JButton("Tour Edit");
    private JButton guideEdit = new JButton("Guide Edit");
    private JButton tourCompanyEdit = new JButton("Tour Company Edit");
    private JButton back = new JButton("Back");

    private JPanel btnPanel = new JPanel(new GridLayout(20, 1, 10, 5));

    private JPanel backPanel;

    public GeneralView(JPanel backPanel) {
        setActionListeners();
        addButtonsToView();
        this.add(btnPanel);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        this.backPanel = backPanel;
    }

    private void addButtonsToView() {
        btnPanel.add(personEdit);
        btnPanel.add(flightEdit);
        btnPanel.add(busEdit);
        btnPanel.add(carRentalEdit);
        btnPanel.add(hotelEdit);
        btnPanel.add(tourEdit);
        btnPanel.add(guideEdit);
        btnPanel.add(tourCompanyEdit);
        btnPanel.add(back);
    }

    private void setActionListeners() {
        personEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for personEdit button in GeneralView
            }
        });

        flightEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for flightEdit button in GeneralView
            }
        });

        busEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for busEdit button in GeneralView
            }
        });

        carRentalEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for carRentalEdit button in GeneralView
            }
        });

        hotelEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for hotelEdit button in GeneralView
            }
        });

        tourEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for tourEdit button in GeneralView
            }
        });

        guideEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for guideEdit button in GeneralView
            }
        });

        tourCompanyEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for tourCompanyEdit button in GeneralView
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backPanel.setVisible(true);
                GeneralView.this.setVisible(false);
            }
        });
    }
}
