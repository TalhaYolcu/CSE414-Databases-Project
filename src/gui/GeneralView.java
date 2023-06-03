package gui;

import constants.CONSTANTS;
import db.TravelBookingConnection;
import listeners.AccomodationEditListener;
import listeners.FlightEditListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class GeneralView extends JPanel {
    private JButton accomodationEdit = new JButton("Accomodation Edit");
    private JButton busEdit = new JButton("Bus Edit");
    private JButton carRentalEdit = new JButton("Car Rental Edit");
    private JButton flightEdit = new JButton("Flight Edit");
    private JButton guideEdit = new JButton("Guide Edit");
    private JButton hotelEdit = new JButton("Hotel Edit");
    private JButton personEdit = new JButton("Person Edit");
    private JButton rentalEdit = new JButton("Rental Edit");
    private JButton roomEdit = new JButton("Room Edit");
    private JButton tourEdit = new JButton("Tour Edit");
    private JButton tourCompanyEdit = new JButton("Tour Company Edit");
    private JButton transportEdit = new JButton("Transport Edit");
    private JTextField query_text_field=new JTextField();

    private  JButton special_query= new JButton("Special Query");
    private JButton back = new JButton("Back");

    private JPanel btnPanel = new JPanel(new GridLayout(20, 1, 10, 5));

    private JPanel backPanel;
    private Statement st=null;


    public GeneralView(JPanel backPanel) {
        try {
            st = TravelBookingConnection.getConnection().createStatement();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        setActionListeners();
        query_text_field.setPreferredSize(new Dimension(300,30));
        query_text_field.setToolTipText("Enter your query here");
        addButtonsToView();
        this.add(btnPanel);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        this.backPanel=backPanel;
    }

    private void addButtonsToView() {
        btnPanel.add(accomodationEdit);
        btnPanel.add(busEdit);
        btnPanel.add(carRentalEdit);
        btnPanel.add(flightEdit);
        btnPanel.add(guideEdit);
        btnPanel.add(hotelEdit);
        btnPanel.add(personEdit);
        btnPanel.add(rentalEdit);
        btnPanel.add(roomEdit);
        btnPanel.add(tourEdit);
        btnPanel.add(tourCompanyEdit);
        btnPanel.add(transportEdit);
        btnPanel.add(query_text_field);
        btnPanel.add(special_query);
        btnPanel.add(back);
    }

    private void setActionListeners() {

        accomodationEdit.addActionListener(new AccomodationEditListener(btnPanel,this,st));

        personEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for personEdit button in GeneralView
            }
        });

        flightEdit.addActionListener(new FlightEditListener(btnPanel,this,st));

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
        special_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = query_text_field.getText();
                System.out.println("QUERY : "+query);
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
