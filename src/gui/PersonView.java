package gui;

import db.TravelBookingConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import models.Accommodation;
import models.Car;
import db.TravelBookingConnection;
import models.Hotel;
import models.Room;

public class PersonView extends JFrame {
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
    private JButton viewToursButton;
    private JButton joinTourButton;
    private JButton cancelTourJoiningButton;
    private Statement st ;

    public PersonView() {
        initializeComponents();
        setupLayout();
        setupListeners();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Person View");
        setSize(400, 600);
        setLocationRelativeTo(null);
        try {
            st = TravelBookingConnection.getConnection().createStatement();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
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
    }

    private void setupLayout() {
        setLayout(new GridLayout(7, 2));
        add(viewRentingsButton);
        add(rentCarButton);
        add(cancelCarRentingButton);
        add(viewHotelsButton);
        add(viewHotelRoomsButton);
        add(accommodateButton);
        add(cancelAccommodationButton);
        add(viewFlightsButton);
        add(buyFlightButton);
        add(cancelFlightButton);
        add(viewBusesButton);
        add(buyBusButton);
        add(cancelBusButton);
        //add(viewToursButton);
        //add(joinTourButton);
        //add(cancelTourJoiningButton);
    }

    private void setupListeners() {
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

        viewToursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTours();
            }
        });

        joinTourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                joinTour();
            }
        });

        cancelTourJoiningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelTourJoining();
            }
        });
    }

    private void viewRentings() {
        try {
            Car carModel = new Car();
            ResultSet resultSet = st.executeQuery(carModel.getSelectAllQuery());
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a table model to hold the data
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the table model
            JTable table = new JTable(tableModel);

            // Display the table in a dialog
            JOptionPane.showMessageDialog(this, new JScrollPane(table), "Rentings", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void rentCar() {
        try {
            Car carModel = new Car();
            ResultSet resultSet = st.executeQuery(carModel.getSelectAllQuery()) ;
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a table model to hold the data
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the table model
            JTable table = new JTable(tableModel);

            // Create a panel to hold the table and input field
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JScrollPane(table), BorderLayout.CENTER);

            // Prompt the user to enter a car ID
            JTextField carIdField = new JTextField();
            panel.add(carIdField, BorderLayout.SOUTH);

            // Display the table and input field in a dialog
            int option = JOptionPane.showOptionDialog(
                    this,
                    panel,
                    "Available Rentings",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[]{"OK", "Cancel"},
                    null
            );

            // Check if the user clicked OK and a car ID is entered
            if (option == JOptionPane.OK_OPTION && !carIdField.getText().isEmpty()) {
                int selectedCarId = Integer.parseInt(carIdField.getText());

                // TODO
                // Perform necessary SQL operations to update the car_rental table
                //carModel.rentCar(selectedCarId);

                JOptionPane.showMessageDialog(this, "Car rented successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid car ID entered or canceled!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void cancelCarRenting() {
        try {
            // Prompt the user to enter a person ID
            String personIdString = JOptionPane.showInputDialog(this, "Enter Person ID:");
            if (personIdString == null || personIdString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Person ID entered or canceled!");
                return;
            }

            int personId = Integer.parseInt(personIdString);

            // Execute the query to retrieve car rental entries for the person
            String query = "SELECT * FROM car_rental WHERE person_id = " + personId;
            ResultSet resultSet = st.executeQuery(query);

            // Check if there are any car rental entries for the person
            if (!resultSet.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "No car rental entries found for Person ID: " + personId);
                return;
            }

            // Create a table model to hold the data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the table model
            JTable table = new JTable(tableModel);

            // Display the table in a dialog
            JOptionPane.showMessageDialog(this, new JScrollPane(table), "Car Rental Entries for Person ID: " + personId, JOptionPane.PLAIN_MESSAGE);

            // Prompt the user to enter a rental ID to delete
            String rentalIdString = JOptionPane.showInputDialog(this, "Enter Rental ID to delete:");
            if (rentalIdString == null || rentalIdString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Rental ID entered or canceled!");
                return;
            }

            int rentalId = Integer.parseInt(rentalIdString);

            // Delete the entry from the car_rental table
            String deleteQuery = "DELETE FROM car_rental WHERE rental_id = " + rentalId;
            int deleteCount = st.executeUpdate(deleteQuery);

            if (deleteCount > 0) {
                JOptionPane.showMessageDialog(this, "Car rental entry deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete car rental entry!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void viewHotels() {
        try {
            // Create a HotelModel instance to interact with the hotel table
            Hotel hotelModel = new Hotel();

            // Execute the query to retrieve all hotels
            ResultSet resultSet = st.executeQuery(hotelModel.getSelectAllQuery());

            // Create a table model to hold the data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the table model
            JTable table = new JTable(tableModel);

            // Display the table in a dialog
            JOptionPane.showMessageDialog(this, new JScrollPane(table), "Hotels", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void viewHotelRooms() {
        try {
            // Create a HotelModel instance to interact with the hotel table
            Hotel hotelModel = new Hotel();

            // Execute the query to retrieve all hotels
            ResultSet resultSet = st.executeQuery(hotelModel.getSelectAllQuery());

            // Create a table model to hold the hotel data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the hotel table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add hotel rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the hotel table model
            JTable hotelTable = new JTable(tableModel);

            // Create a panel to hold the hotel table
            JPanel hotelPanel = new JPanel(new BorderLayout());
            hotelPanel.add(new JScrollPane(hotelTable), BorderLayout.CENTER);

            // Display the hotel table in a dialog
            JOptionPane.showMessageDialog(this, hotelPanel, "Hotels", JOptionPane.PLAIN_MESSAGE);

            // Prompt the user to enter a hotel ID
            String hotelID = JOptionPane.showInputDialog(this, "Enter Hotel ID:", "View Hotel Rooms",
                    JOptionPane.QUESTION_MESSAGE);

            // Create a RoomModel instance to interact with the room table
            Room roomModel = new Room();

            // Execute the query to retrieve rooms of the specified hotel ID
            ResultSet roomResultSet = st.executeQuery(roomModel.getRoomsByHotelIDQuery(hotelID));

            // Create a table model to hold the room data
            ResultSetMetaData roomMetaData = roomResultSet.getMetaData();
            int roomColumnCount = roomMetaData.getColumnCount();
            DefaultTableModel roomTableModel = new DefaultTableModel();

            // Add column names to the room table model
            for (int columnIndex = 1; columnIndex <= roomColumnCount; columnIndex++) {
                roomTableModel.addColumn(roomMetaData.getColumnName(columnIndex));
            }

            // Add room rows to the table model
            while (roomResultSet.next()) {
                Object[] row = new Object[roomColumnCount];
                for (int columnIndex = 1; columnIndex <= roomColumnCount; columnIndex++) {
                    row[columnIndex - 1] = roomResultSet.getObject(columnIndex);
                }
                roomTableModel.addRow(row);
            }

            // Create a JTable with the room table model
            JTable roomTable = new JTable(roomTableModel);

            // Create a panel to hold the room table
            JPanel roomPanel = new JPanel(new BorderLayout());
            roomPanel.add(new JScrollPane(roomTable), BorderLayout.CENTER);

            // Display the room table in a dialog
            JOptionPane.showMessageDialog(this, roomPanel, "Hotel Rooms", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    private void accommodate() {
        try {
            // Create a HotelModel instance to interact with the hotel table
            Hotel hotelModel = new Hotel();

            // Execute the query to retrieve all hotels
            ResultSet resultSet = st.executeQuery(hotelModel.getSelectAllQuery());

            // Create a table model to hold the hotel data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the hotel table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add hotel rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the hotel table model
            JTable hotelTable = new JTable(tableModel);

            // Create a panel to hold the hotel table
            JPanel hotelPanel = new JPanel(new BorderLayout());
            hotelPanel.add(new JScrollPane(hotelTable), BorderLayout.CENTER);

            // Display the hotel table in a dialog
            JOptionPane.showMessageDialog(this, hotelPanel, "Hotels", JOptionPane.PLAIN_MESSAGE);

            // Prompt the user to enter a hotel ID
            String hotelID = JOptionPane.showInputDialog(this, "Enter Hotel ID:", "View Hotel Rooms",
                    JOptionPane.QUESTION_MESSAGE);

            // Create a RoomModel instance to interact with the room table
            Room roomModel = new Room();

            // Execute the query to retrieve rooms of the specified hotel ID
            ResultSet roomResultSet = st.executeQuery(roomModel.getRoomsByHotelIDQuery(hotelID));

            // Create a table model to hold the room data
            ResultSetMetaData roomMetaData = roomResultSet.getMetaData();
            int roomColumnCount = roomMetaData.getColumnCount();
            DefaultTableModel roomTableModel = new DefaultTableModel();

            // Add column names to the room table model
            for (int columnIndex = 1; columnIndex <= roomColumnCount; columnIndex++) {
                roomTableModel.addColumn(roomMetaData.getColumnName(columnIndex));
            }

            // Add room rows to the table model
            while (roomResultSet.next()) {
                Object[] row = new Object[roomColumnCount];
                for (int columnIndex = 1; columnIndex <= roomColumnCount; columnIndex++) {
                    row[columnIndex - 1] = roomResultSet.getObject(columnIndex);
                }
                roomTableModel.addRow(row);
            }

            // Create a JTable with the room table model
            JTable roomTable = new JTable(roomTableModel);

            // Create a panel to hold the room table
            JPanel roomPanel = new JPanel(new BorderLayout());
            roomPanel.add(new JScrollPane(roomTable), BorderLayout.CENTER);

            // Display the room table in a dialog
            JOptionPane.showMessageDialog(this, roomPanel, "Hotel Rooms", JOptionPane.PLAIN_MESSAGE);

            // Prompt the user to enter a room ID to accommodate
            String roomID = JOptionPane.showInputDialog(this, "Enter Room ID to Accommodate:", "Accommodation",
                    JOptionPane.QUESTION_MESSAGE);

            // Create an AccommodationModel instance to interact with the accommodation table
            Accommodation accommodationModel = new Accommodation();

            //TODO
            // Execute the SQL command to insert the accommodation entry

            //String insertQuery = accommodationModel.getInsertQuery(roomID);
            //st.executeUpdate(insertQuery);

            JOptionPane.showMessageDialog(this, "Accommodation successful!", "Accommodation",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void cancelAccommodation() {
        try {
            // Prompt the user to enter a person ID
            String personID = JOptionPane.showInputDialog(this, "Enter Person ID:", "Cancel Accommodation",
                    JOptionPane.QUESTION_MESSAGE);

            // Execute the query to retrieve accommodation entries for the specified person ID
            String query = "SELECT * FROM accommodation WHERE person_id = " + personID;
            ResultSet resultSet = st.executeQuery(query);

            // Check if there are any accommodation entries for the specified person ID
            if (!resultSet.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "No accommodation entries found for Person ID: " + personID,
                        "Cancel Accommodation", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Create a table model to hold the accommodation data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the accommodation table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add accommodation rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the accommodation table model
            JTable accommodationTable = new JTable(tableModel);

            // Create a panel to hold the accommodation table
            JPanel accommodationPanel = new JPanel(new BorderLayout());
            accommodationPanel.add(new JScrollPane(accommodationTable), BorderLayout.CENTER);

            // Display the accommodation table in a dialog
            JOptionPane.showMessageDialog(this, accommodationPanel, "Accommodation Entries",
                    JOptionPane.PLAIN_MESSAGE);

            // Prompt the user to enter an accommodation ID to cancel
            String accommodationID = JOptionPane.showInputDialog(this, "Enter Accommodation ID to Cancel:",
                    "Cancel Accommodation", JOptionPane.QUESTION_MESSAGE);

            // Execute the SQL command to delete the accommodation entry
            String deleteQuery = "DELETE FROM accommodation WHERE accommodation_id = " + accommodationID;
            st.executeUpdate(deleteQuery);

            JOptionPane.showMessageDialog(this, "Accommodation cancellation successful!", "Cancel Accommodation",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void viewFlights() {
        try {
            // Execute the query to retrieve all flights
            String query = "SELECT * FROM flight";
            ResultSet resultSet = st.executeQuery(query);

            // Create a table model to hold the flight data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the flight table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add flight rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the flight table model
            JTable flightTable = new JTable(tableModel);

            // Create a panel to hold the flight table
            JPanel flightPanel = new JPanel(new BorderLayout());
            flightPanel.add(new JScrollPane(flightTable), BorderLayout.CENTER);

            // Display the flight table in a dialog
            JOptionPane.showMessageDialog(this, flightPanel, "Flights", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void buyFlight() {
        try {
            // Execute the query to retrieve all flights
            String query = "SELECT * FROM flight";
            ResultSet resultSet = st.executeQuery(query);

            // Create a table model to hold the flight data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the flight table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add flight rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the flight table model
            JTable flightTable = new JTable(tableModel);

            // Create a panel to hold the flight table
            JPanel flightPanel = new JPanel(new BorderLayout());
            flightPanel.add(new JScrollPane(flightTable), BorderLayout.CENTER);

            // Display the flight table in a dialog
            int option = JOptionPane.showConfirmDialog(this, flightPanel, "Flights", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            // Process the user's selection
            if (option == JOptionPane.OK_OPTION) {
                // Get the selected row index
                int selectedRowIndex = flightTable.getSelectedRow();

                if (selectedRowIndex != -1) {
                    // Get the flight_id from the selected row
                    String flightId = flightTable.getValueAt(selectedRowIndex, 0).toString();

                    //TODO
                    // Insert the flight into the transport table
                    String insertQuery = "INSERT INTO transport (transport_id, company_id, respective_id, person_id, transport_type" +
                            ") VALUES ('123123', '" + flightId + "')";


                    int rowsAffected = st.executeUpdate(insertQuery);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Flight purchased successfully");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to purchase flight", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    private void cancelFlight() {
        try {
            // Prompt the user to enter the person ID
            String personId = JOptionPane.showInputDialog(this, "Enter Person ID:");

            // Execute the query to retrieve the flights for the given person ID
            String query = "SELECT * FROM transport WHERE transport_type = 'flight' AND person_id = '" + personId + "'";
            ResultSet resultSet = st.executeQuery(query);

            // Check if there are any flights for the given person ID
            if (!resultSet.next()) {
                JOptionPane.showMessageDialog(this, "No flights found for the specified person ID", "No Flights", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Create a table model to hold the flight data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the flight table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add flight rows to the table model
            resultSet.beforeFirst(); // Move the cursor back to the beginning
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the flight table model
            JTable flightTable = new JTable(tableModel);

            // Create a panel to hold the flight table
            JPanel flightPanel = new JPanel(new BorderLayout());
            flightPanel.add(new JScrollPane(flightTable), BorderLayout.CENTER);

            // Display the flight table in a dialog
            int option = JOptionPane.showConfirmDialog(this, flightPanel, "Cancel Flight", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            // Process the user's selection
            if (option == JOptionPane.OK_OPTION) {
                // Prompt the user to enter the transport ID
                String transportId = JOptionPane.showInputDialog(this, "Enter Transport ID:");

                // Delete the flight from the transport table
                String deleteQuery = "DELETE FROM transport WHERE transport_id = '" + transportId + "'";
                int rowsAffected = st.executeUpdate(deleteQuery);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Flight canceled successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to cancel flight", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void viewBuses() {
        try {
            // Execute the query to retrieve all buses
            String query = "SELECT * FROM bus";
            ResultSet resultSet = st.executeQuery(query);

            // Create a table model to hold the bus data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the bus table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add bus rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the bus table model
            JTable busTable = new JTable(tableModel);

            // Create a panel to hold the bus table
            JPanel busPanel = new JPanel(new BorderLayout());
            busPanel.add(new JScrollPane(busTable), BorderLayout.CENTER);

            // Display the bus table in a dialog
            JOptionPane.showMessageDialog(this, busPanel, "Buses", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void buyBus() {
        try {
            // Execute the query to retrieve all buses
            String query = "SELECT * FROM bus";
            ResultSet resultSet = st.executeQuery(query);

            // Create a table model to hold the bus data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the bus table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add bus rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the bus table model
            JTable busTable = new JTable(tableModel);

            // Create a panel to hold the bus table
            JPanel busPanel = new JPanel(new BorderLayout());
            busPanel.add(new JScrollPane(busTable), BorderLayout.CENTER);

            // Display the bus table in a dialog and prompt for bus ID
            int selectedOption = JOptionPane.showOptionDialog(this, busPanel, "Buy a Bus",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

            if (selectedOption == JOptionPane.OK_OPTION) {
                // Get the selected row from the bus table
                int selectedRow = busTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Get the bus ID from the selected row
                    int busId = (int) busTable.getValueAt(selectedRow, 0);


                    // TODO
                    // Insert a new entry in the transport table for the purchased bus
                    String insertQuery = "INSERT INTO transport (transport_type, transport_id) VALUES ('bus', " + busId + ")";
                    int rowsAffected = st.executeUpdate(insertQuery);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Bus purchased successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to purchase bus.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No bus selected.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void cancelBus() {
        try {
            // Prompt the user to enter the person ID
            String personIdString = JOptionPane.showInputDialog(this, "Enter person ID:");
            if (personIdString == null || personIdString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid person ID.");
                return;
            }

            // Parse the person ID
            int personId;
            try {
                personId = Integer.parseInt(personIdString);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid person ID.");
                return;
            }

            // Execute the query to retrieve the buses for the given person ID
            String query = "SELECT * FROM transport WHERE transport_type = 'bus' AND person_id = " + personId;
            ResultSet resultSet = st.executeQuery(query);

            // Check if there are any bus entries for the given person ID
            if (!resultSet.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "No bus entries found for person ID: " + personId);
                return;
            }

            // Create a table model to hold the bus entries
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the bus table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add bus entries to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the bus entries table model
            JTable busEntriesTable = new JTable(tableModel);

            // Create a panel to hold the bus entries table
            JPanel busEntriesPanel = new JPanel(new BorderLayout());
            busEntriesPanel.add(new JScrollPane(busEntriesTable), BorderLayout.CENTER);

            // Display the bus entries table in a dialog and prompt for bus ID to cancel
            int selectedOption = JOptionPane.showOptionDialog(this, busEntriesPanel, "Cancel Bus",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

            if (selectedOption == JOptionPane.OK_OPTION) {
                // Get the selected row from the bus entries table
                int selectedRow = busEntriesTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Get the transport ID from the selected row
                    int transportId = (int) busEntriesTable.getValueAt(selectedRow, 0);

                    // Delete the bus entry from the transport table
                    String deleteQuery = "DELETE FROM transport WHERE transport_id = " + transportId;
                    int rowsAffected = st.executeUpdate(deleteQuery);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Bus entry canceled successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to cancel bus entry.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No bus entry selected.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void viewTours() {
        try {
            // Execute the query to retrieve all tours
            String query = "SELECT * FROM tour";
            ResultSet resultSet = st.executeQuery(query);

            // Create a table model to hold the tour entries
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the tour table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add tour entries to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(row);
            }

            // Create a JTable with the tour entries table model
            JTable tourEntriesTable = new JTable(tableModel);

            // Create a panel to hold the tour entries table
            JPanel tourEntriesPanel = new JPanel(new BorderLayout());
            tourEntriesPanel.add(new JScrollPane(tourEntriesTable), BorderLayout.CENTER);

            // Display the tour entries table in a dialog
            JOptionPane.showMessageDialog(this, tourEntriesPanel, "View Tour", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void joinTour() {
        // Implement the logic for joining a tour
        JOptionPane.showMessageDialog(this, "Joining a tour");
    }

    private void cancelTourJoining() {
        // Implement the logic for canceling tour joining
        JOptionPane.showMessageDialog(this, "Canceling tour joining");
    }
}
