package gui;

import db.TravelBookingConnection;
import listeners.BusListener;
import listeners.CarRentalListener;
import listeners.FlightListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class PersonView extends JPanel{
    private JButton flights=new JButton("Flights");
    private JButton bus=new JButton("Bus");
    private JButton car_rental=new JButton("Car Rental");
    private JButton hotels=new JButton("Hotel");
    private JButton tours=new JButton("Tour");
    private JButton guides=new JButton("Guides");
    private JButton tour_companies=new JButton("Tour Companies");
    private JButton flight_history=new JButton("Flight history");
    private JButton bus_history=new JButton("Bus history");
    private JButton car_rental_history=new JButton("Car Rental history");
    private JButton hotel_history=new JButton("Hotel history");
    private JButton tour_history=new JButton("Tour history");
    private JTextField query_text_field=new JTextField();
    private  JButton special_query= new JButton("Special Query");
    private JButton back=new JButton("Back");

    private JPanel btnPanel = new JPanel(new GridLayout(20, 1, 10, 5));

    private JPanel backPanel;
    private Statement st=null;

    public PersonView(JPanel backPanel) {
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
        btnPanel.add(car_rental);
        btnPanel.add(hotels);
        btnPanel.add(tours);
        btnPanel.add(guides);
        btnPanel.add(tour_companies);
        btnPanel.add(flight_history);
        btnPanel.add(bus_history);
        btnPanel.add(car_rental_history);
        btnPanel.add(hotel_history);
        btnPanel.add(tour_history);
        btnPanel.add(query_text_field);
        btnPanel.add(special_query);
        btnPanel.add(back);
    }

    private void setActionListeners() {

        flights.addActionListener(new FlightListener(btnPanel,this,st));

        bus.addActionListener(new BusListener(btnPanel,this,st));
        car_rental.addActionListener(new CarRentalListener(btnPanel,this,st));
        hotels.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        guides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        tour_companies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        flight_history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bus_history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        car_rental_history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        hotel_history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tour_history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                PersonView.this.setVisible(false);
            }
        });
    }
}
