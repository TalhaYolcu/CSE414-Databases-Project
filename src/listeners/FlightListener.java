package listeners;

import constants.CONSTANTS;
import models.TableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightListener extends MyListener implements ActionListener  {



    public FlightListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel,upperPanel,st);

    }

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
                columns += flight_id.isSelected() ? CONSTANTS.FLIGHT_TABLE.flight_id + "," : "";
                columns += flight_id.isSelected() ? CONSTANTS.FLIGHT_TABLE.flight_id + "," : "";
                columns += departure_p.isSelected() ? CONSTANTS.FLIGHT_TABLE.departure_p + "," : "";
                columns += aperture_p.isSelected() ? CONSTANTS.FLIGHT_TABLE.aperture_p + "," : "";
                columns += departure_t.isSelected() ? CONSTANTS.FLIGHT_TABLE.departure_t + "," : "";
                columns += aperture_t.isSelected() ? CONSTANTS.FLIGHT_TABLE.aperture_t + "," : "";
                columns += capacity.isSelected() ? CONSTANTS.FLIGHT_TABLE.capacity + "," : "";
                columns += price.isSelected() ? CONSTANTS.FLIGHT_TABLE.price + "," : "";
                columns += spare_place.isSelected() ? CONSTANTS.FLIGHT_TABLE.spare_place + "," : "";


                getQuery(columns, checkboxPanel,CONSTANTS.TABLE_NAMES.flights);
            }
        });
    }
}

