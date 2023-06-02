package listeners;

import constants.CONSTANTS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class HotelListener extends MyListener implements ActionListener {
    public HotelListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel, upperPanel, st);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        JCheckBox hotel_id=new JCheckBox(CONSTANTS.HOTEL_TABLE.hotel_id);
        JCheckBox hotel_name=new JCheckBox(CONSTANTS.HOTEL_TABLE.hotel_name);
        JCheckBox location=new JCheckBox(CONSTANTS.HOTEL_TABLE.location);
        JButton okButton=new JButton("OK");
        JButton backB=new JButton("Back");
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.add(hotel_id);
        checkboxPanel.add(hotel_name);
        checkboxPanel.add(location);
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
                columns += hotel_id.isSelected() ? CONSTANTS.HOTEL_TABLE.hotel_id + "," : "";
                columns += hotel_name.isSelected() ? CONSTANTS.HOTEL_TABLE.hotel_name + "," : "";
                columns += location.isSelected() ? CONSTANTS.HOTEL_TABLE.location + "," : "";


                getQuery(columns, checkboxPanel,CONSTANTS.TABLE_NAMES.hotels);
            }
        });
    }
}
