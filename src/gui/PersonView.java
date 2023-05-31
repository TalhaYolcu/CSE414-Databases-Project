package gui;

import constants.CONSTANTS;
import db.TravelBookingConnection;
import models.TableModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        setActionListeners();
        query_text_field.setPreferredSize(new Dimension(300,30));
        query_text_field.setToolTipText("Enter your query here");
        addButtonsToView();
        this.add(btnPanel);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        this.backPanel=backPanel;


        try {
            st = TravelBookingConnection.getConnection().createStatement();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


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

        flights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                btnPanel.setVisible(false);
                JCheckBox flight_id=new JCheckBox(CONSTANTS.FLIGHT_TABLE.flight_id);
                JCheckBox departure_p=new JCheckBox(CONSTANTS.FLIGHT_TABLE.departure_p);
                JCheckBox aperture_p=new JCheckBox(CONSTANTS.FLIGHT_TABLE.aperture_p);
                JCheckBox departure_t=new JCheckBox(CONSTANTS.FLIGHT_TABLE.departure_t);
                JCheckBox aperture_t=new JCheckBox(CONSTANTS.FLIGHT_TABLE.aperture_t);
                JCheckBox capacity=new JCheckBox(CONSTANTS.FLIGHT_TABLE.capacity);
                JCheckBox price=new JCheckBox(CONSTANTS.FLIGHT_TABLE.price);
                JCheckBox spare_place=new JCheckBox(CONSTANTS.FLIGHT_TABLE.spare_place);
                JButton okButton=new JButton("OK");
                JButton backB=new JButton("Back");
                JPanel checkboxPanel = new JPanel();
                checkboxPanel.add(flight_id);
                checkboxPanel.add(departure_p);
                checkboxPanel.add(aperture_p);
                checkboxPanel.add(departure_t);
                checkboxPanel.add(aperture_t);
                checkboxPanel.add(capacity);
                checkboxPanel.add(price);
                checkboxPanel.add(spare_place);
                checkboxPanel.add(okButton);
                checkboxPanel.add(backB);
                PersonView.this.add(checkboxPanel);

                backB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnPanel.setVisible(true);
                        checkboxPanel.setVisible(false);
                    }
                });


                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        checkboxPanel.setVisible(false);

                        String columns="";
                        if (flight_id.isSelected()) {
                            columns += CONSTANTS.FLIGHT_TABLE.flight_id + ",";
                        }
                        // Add other flight table elements similarly
                        if (departure_p.isSelected()) {
                            columns += CONSTANTS.FLIGHT_TABLE.departure_p + ",";
                        }

                        if (aperture_p.isSelected()) {
                            columns += CONSTANTS.FLIGHT_TABLE.aperture_p + ",";
                        }

                        if (departure_t.isSelected()) {
                            columns += CONSTANTS.FLIGHT_TABLE.departure_t + ",";
                        }

                        if (aperture_t.isSelected()) {
                            columns += CONSTANTS.FLIGHT_TABLE.aperture_t + ",";
                        }

                        if (capacity.isSelected()) {
                            columns += CONSTANTS.FLIGHT_TABLE.capacity + ",";
                        }

                        if (price.isSelected()) {
                            columns += CONSTANTS.FLIGHT_TABLE.price + ",";
                        }

                        if (spare_place.isSelected()) {
                            columns += CONSTANTS.FLIGHT_TABLE.spare_place + ",";
                        }

                        if(columns.length()==0) {
                            columns += "*";
                        }
                        else {
                            columns = columns.substring(0,columns.length()-1);
                        }
                        try {

                            String query = "select "+columns+" from flights";
                            System.out.println("QUERY : "+query);

                            ResultSet rs = st.executeQuery(query);

                            JTable table = new JTable(TableModel.buildTableModel(rs));
                            JButton backToBox= new JButton("Back");

                            JScrollPane scrollPane = new JScrollPane(table);
                            JPanel scrollPanel = new JPanel();
                            scrollPanel.add(scrollPane);



                            PersonView.this.add(scrollPane);
                            PersonView.this.add(backToBox);
                            PersonView.this.repaint();

                            backToBox.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    scrollPanel.setVisible(false);
                                    scrollPane.setVisible(false);
                                    checkboxPanel.setVisible(true);
                                    backToBox.setVisible(false);
                                    PersonView.this.repaint();


                                }
                            });

                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }



                    }
                });




            }
        });

        bus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        car_rental.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
