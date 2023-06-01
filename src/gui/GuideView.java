package gui;

import db.TravelBookingConnection;
import listeners.FlightListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class GuideView extends JPanel {
    private JButton flights=new JButton("Flights");
    private JButton bus=new JButton("Bus");
    private JButton car_rental=new JButton("Car Rental");
    private JButton hotels=new JButton("Hotel");
    private JButton tours=new JButton("Tour");
    private JButton tour_companies=new JButton("Tour Companies");
    private JTextField query_text_field=new JTextField();
    private  JButton special_query= new JButton("Special Query");
    private JButton back=new JButton("Back");

    private JPanel btnPanel = new JPanel(new GridLayout(20, 1, 10, 5));

    private JPanel backPanel;
    private Statement st=null;

    public GuideView(JPanel backPanel) {
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
        btnPanel.add(flights);
        btnPanel.add(bus);
        btnPanel.add(hotels);
        btnPanel.add(tours);
        btnPanel.add(tour_companies);
        btnPanel.add(query_text_field);
        btnPanel.add(special_query);
        btnPanel.add(back);
    }

    private void setActionListeners() {
        flights.addActionListener(new FlightListener(btnPanel,this,st));

        bus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for bus button in GuideView
            }
        });

        hotels.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for hotels button in GuideView
            }
        });

        tours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for tours button in GuideView
            }
        });



        tour_companies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for tour_companies button in GuideView
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
                GuideView.this.setVisible(false);
            }
        });
    }
}
