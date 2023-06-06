package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuideView extends JFrame {
    private JButton viewToursButton;
    private JButton viewRentingsButton;
    private JButton rentCarButton;
    private JButton cancelCarRentingButton;
    private JButton viewHotelsButton;
    private JButton viewHotelRoomsButton;
    private JButton accommodateButton;
    private JButton cancelAccommodationButton;
    private JButton viewFlightsButton;
    private JButton buyFlightButton;
    private JButton cancelFlightButton;
    private JButton viewBusesButton;
    private JButton buyBusButton;
    private JButton cancelBusButton;
    private JButton joinTourButton;
    private JButton cancelTourJoiningButton;
    private JButton viewGuidedToursButton;

    public GuideView() {
        initializeComponents();
        setupLayout();
        setupListeners();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Guide View");
        setSize(400, 600);
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        viewRentingsButton = new JButton("View Rentings");
        rentCarButton = new JButton("Rent a Car");
        cancelCarRentingButton = new JButton("Cancel Car Renting");
        viewHotelsButton = new JButton("View Hotels");
        viewHotelRoomsButton = new JButton("View Hotel Rooms");
        accommodateButton = new JButton("Accommodate");
        cancelAccommodationButton = new JButton("Cancel Accommodation");
        viewFlightsButton = new JButton("View Flights");
        buyFlightButton = new JButton("Buy a Flight");
        cancelFlightButton = new JButton("Cancel a Flight");
        viewBusesButton = new JButton("View Buses");
        buyBusButton = new JButton("Buy a Bus");
        cancelBusButton = new JButton("Cancel a Bus");
        viewToursButton = new JButton("View Tours");
        joinTourButton = new JButton("Join a Tour");
        cancelTourJoiningButton = new JButton("Cancel Tour Joining");
        viewGuidedToursButton = new JButton("View Guided Tours");
    }

    private void setupLayout() {
        setLayout(new GridLayout(6, 3));
        //TODO copy person
        add(viewRentingsButton);
        add(rentCarButton);
        add(cancelCarRentingButton);
        add(viewFlightsButton);
        add(buyFlightButton);
        add(cancelFlightButton);
        add(viewBusesButton);
        add(buyBusButton);
        add(cancelBusButton);
        add(viewHotelsButton);
        add(viewHotelRoomsButton);
        add(accommodateButton);
        add(cancelAccommodationButton);
        add(viewToursButton);
        add(joinTourButton);
        add(cancelTourJoiningButton);
        add(viewGuidedToursButton);


    }

    private void setupListeners() {
        viewToursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTours();
            }
        });

        viewRentingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewRentings();
            }
        });

        rentCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentCar();
            }
        });

        cancelCarRentingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelCarRenting();
            }
        });

        viewHotelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHotels();
            }
        });

        viewHotelRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHotelRooms();
            }
        });

        accommodateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accommodate();
            }
        });

        cancelAccommodationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAccommodation();
            }
        });

        viewFlightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewFlights();
            }
        });

        buyFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyFlight();
            }
        });

        cancelFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelFlight();
            }
        });

        viewBusesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBuses();
            }
        });

        buyBusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyBus();
            }
        });

        cancelBusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelBus();
            }
        });
    }

    private void viewTours() {
        // Implement the logic for viewing all tours
        JOptionPane.showMessageDialog(this, "Viewing all tours");
    }

    private void addTour() {
        // Implement the logic for adding a tour
        JOptionPane.showMessageDialog(this, "Adding a tour");
    }

    private void removeTour() {
        // Implement the logic for removing a tour
        JOptionPane.showMessageDialog(this, "Removing a tour");
    }

    private void viewRentings() {
        // Implement the logic for viewing all rentings
        JOptionPane.showMessageDialog(this, "Viewing all rentings");
    }

    private void rentCar() {
        // Implement the logic for renting a car
        JOptionPane.showMessageDialog(this, "Renting a car");
    }

    private void cancelCarRenting() {
        // Implement the logic for canceling a car renting
        JOptionPane.showMessageDialog(this, "Canceling car renting");
    }

    private void viewHotels() {
        // Implement the logic for viewing all hotels
        JOptionPane.showMessageDialog(this, "Viewing all hotels");
    }

    private void viewHotelRooms() {
        // Implement the logic for viewing hotel rooms
        JOptionPane.showMessageDialog(this, "Viewing hotel rooms");
    }

    private void accommodate() {
        // Implement the logic for accommodating in a hotel room
        JOptionPane.showMessageDialog(this, "Accommodating in a hotel room");
    }

    private void cancelAccommodation() {
        // Implement the logic for canceling accommodation
        JOptionPane.showMessageDialog(this, "Canceling accommodation");
    }

    private void viewFlights() {
        // Implement the logic for viewing all flights
        JOptionPane.showMessageDialog(this, "Viewing all flights");
    }

    private void buyFlight() {
        // Implement the logic for buying a flight
        JOptionPane.showMessageDialog(this, "Buying a flight");
    }

    private void cancelFlight() {
        // Implement the logic for canceling a flight
        JOptionPane.showMessageDialog(this, "Canceling a flight");
    }

    private void viewBuses() {
        // Implement the logic for viewing all buses
        JOptionPane.showMessageDialog(this, "Viewing all buses");
    }

    private void buyBus() {
        // Implement the logic for buying a bus
        JOptionPane.showMessageDialog(this, "Buying a bus");
    }

    private void cancelBus() {
        // Implement the logic for canceling a bus
        JOptionPane.showMessageDialog(this, "Canceling a bus");
    }
}
