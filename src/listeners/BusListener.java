package listeners;

import constants.CONSTANTS;
import models.TableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusListener extends MyListener implements ActionListener {
    public BusListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel,upperPanel,st);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        JCheckBox bus_trip_id = new JCheckBox(CONSTANTS.BUS_TRIP_TABLE.bus_trip_id);
        JCheckBox departure_p = new JCheckBox(CONSTANTS.BUS_TRIP_TABLE.departure_p);
        JCheckBox aperture_p = new JCheckBox(CONSTANTS.BUS_TRIP_TABLE.aperture_p);
        JCheckBox departure_t = new JCheckBox(CONSTANTS.BUS_TRIP_TABLE.departure_t);
        JCheckBox aperture_t = new JCheckBox(CONSTANTS.BUS_TRIP_TABLE.aperture_t);
        JCheckBox capacity = new JCheckBox(CONSTANTS.BUS_TRIP_TABLE.capacity);
        JCheckBox price = new JCheckBox(CONSTANTS.BUS_TRIP_TABLE.price);

        JButton okButton=new JButton("OK");
        JButton backB=new JButton("Back");
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.add(bus_trip_id);
        checkboxPanel.add(departure_p);
        checkboxPanel.add(aperture_p);
        checkboxPanel.add(departure_t);
        checkboxPanel.add(aperture_t);
        checkboxPanel.add(capacity);
        checkboxPanel.add(price);

        checkboxPanel.add(okButton);
        checkboxPanel.add(backB);
        upperPanel.add(checkboxPanel);


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
                columns += bus_trip_id.isSelected() ? CONSTANTS.BUS_TRIP_TABLE.bus_trip_id + "," : "";
                columns += departure_p.isSelected() ? CONSTANTS.BUS_TRIP_TABLE.departure_p + "," : "";
                columns += aperture_p.isSelected() ? CONSTANTS.BUS_TRIP_TABLE.aperture_p + "," : "";
                columns += departure_t.isSelected() ? CONSTANTS.BUS_TRIP_TABLE.departure_t + "," : "";
                columns += aperture_t.isSelected() ? CONSTANTS.BUS_TRIP_TABLE.aperture_t + "," : "";
                columns += capacity.isSelected() ? CONSTANTS.BUS_TRIP_TABLE.capacity + "," : "";
                columns += price.isSelected() ? CONSTANTS.BUS_TRIP_TABLE.price + "," : "";


                getQuery(columns, checkboxPanel,CONSTANTS.TABLE_NAMES.bus_trip);
            }
        });
    }
}
