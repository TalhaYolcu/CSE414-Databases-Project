package listeners;

import constants.CONSTANTS;
import models.Accomodation;
import models.Flight;
import models.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightEditListener extends EditListener implements ActionListener {
    private JButton insertButton=new JButton(CONSTANTS.OPERATIONS.insert);
    private JButton deleteButton = new JButton(CONSTANTS.OPERATIONS.delete);
    private JButton editButton = new JButton(CONSTANTS.OPERATIONS.edit);
    private JButton backButton = new JButton("Back");
    private JPanel operationPanel=new JPanel();
    private JPanel inputTakePanel=new JPanel();
    private JButton insertOKButton=new JButton("OK");
    private JButton insertBackButton=new JButton("Back");
    private JLabel[] columns=new JLabel[CONSTANTS.FLIGHT_TABLE.column_count];
    private JTextField[] entries=new JTextField[CONSTANTS.FLIGHT_TABLE.column_count];
    private JTable table;
    private JScrollPane scrollPane;
    private JPanel scrollPanel=new JPanel();

    public FlightEditListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel, upperPanel, st);

        operationPanel.add(insertButton);
        operationPanel.add(deleteButton);
        operationPanel.add(editButton);
        operationPanel.add(backButton);

        for (int i=0;i<columns.length;i++) {
            columns[i]=new JLabel(CONSTANTS.FLIGHT_TABLE.column_names[i]);
            entries[i]=new JTextField();
            entries[i].setPreferredSize(new Dimension(100,30));
            inputTakePanel.add(columns[i]);
            inputTakePanel.add(entries[i]);
        }

        inputTakePanel.add(insertOKButton);
        inputTakePanel.add(insertBackButton);

        try {
            ResultSet rs = st.executeQuery(new Flight().getSelectAllQuery());
            table = new JTable(TableModel.buildTableModel(rs));
            table.setPreferredSize(new Dimension(700,700));

            scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(700,700));
            scrollPanel = new JPanel();
            scrollPanel.add(scrollPane);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void updateTable(JTable table, JScrollPane scrollPane, JPanel scrollPanel) {
        try {
            table.setVisible(false);
            scrollPane.setVisible(false);
            scrollPanel.setVisible(false);

            scrollPane.remove(table);
            scrollPanel.remove(scrollPane);
            upperPanel.remove(scrollPanel);

            ResultSet rs = st.executeQuery(new Flight().getSelectAllQuery());
            table = new JTable(TableModel.buildTableModel(rs));
            table.setPreferredSize(new Dimension(700,700));

            scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(700,700));
            scrollPanel = new JPanel();
            scrollPanel.add(scrollPane);

            table.setVisible(true);

            scrollPane.setVisible(true);
            scrollPanel.setVisible(true);

            upperPanel.add(scrollPanel);
            upperPanel.repaint();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        operationPanel.setVisible(true);
        upperPanel.add(operationPanel);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPanel.setVisible(true);
                operationPanel.setVisible(false);
                upperPanel.remove(operationPanel);
                upperPanel.repaint();
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationPanel.setVisible(false);
                upperPanel.remove(operationPanel);

                inputTakePanel.setVisible(true);
                scrollPanel.setVisible(true);

                inputTakePanel.repaint();
                scrollPanel.repaint();

                upperPanel.add(inputTakePanel);
                upperPanel.add(scrollPanel);

                upperPanel.repaint();
                insertOKButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    /*
                    INSERT INTO travel_booking.flights (flight_id, departure_p, aperture_p, departure_t, aperture_t, capacity,
                    price, spare_place) VALUES (125, Ankara, Istanbul, 2023-06-01 10:00:00, 2023-06-01 12:00:00, 100
                    , 250, 100);
                     */
                        for(int i=0;i<columns.length;i++) {
                            if(entries[i]==null || entries[i].getText()==null || entries[i].getText().length()==0) {
                                return;
                            }
                        }
                        String query = "INSERT INTO " + CONSTANTS.DB_NAME + "." + CONSTANTS.TABLE_NAMES.flights + " (" +
                                CONSTANTS.FLIGHT_TABLE.flight_id + ", " +
                                CONSTANTS.FLIGHT_TABLE.departure_p + ", " +
                                CONSTANTS.FLIGHT_TABLE.aperture_p + ", " +
                                CONSTANTS.FLIGHT_TABLE.departure_t + ", " +
                                CONSTANTS.FLIGHT_TABLE.aperture_t + ", " +
                                CONSTANTS.FLIGHT_TABLE.capacity + ", " +
                                CONSTANTS.FLIGHT_TABLE.price + ", " +
                                CONSTANTS.FLIGHT_TABLE.spare_place + ") VALUES (" +
                                entries[0].getText() + ", " +
                                entries[1].getText() + ", " +
                                entries[2].getText() + ", " +
                                entries[3].getText() + ", " +
                                entries[4].getText() + ", " +
                                entries[5].getText() + ", " +
                                entries[6].getText() + ", " +
                                entries[7].getText() + ");";


                        System.out.println(query);
                        try {

                            //insert and update the table
                            st.execute(query);

                        }
                        catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                        scrollPanel.setVisible(false);

                        //update the table
                        updateTable(table,scrollPane,scrollPanel);
                        upperPanel.add(scrollPanel);
                        upperPanel.repaint();
                    }
                });
                insertBackButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        operationPanel.setVisible(true);
                        upperPanel.add(operationPanel);

                        inputTakePanel.setVisible(false);
                        scrollPanel.setVisible(false);

                        upperPanel.remove(inputTakePanel);
                        upperPanel.remove(scrollPanel);
                        upperPanel.repaint();
                    }
                });
            }
        });

    }
}
