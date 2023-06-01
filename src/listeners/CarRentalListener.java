package listeners;

import constants.CONSTANTS;
import models.TableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarRentalListener extends MyListener implements ActionListener {

    public CarRentalListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel,upperPanel,st);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        JCheckBox car_id=new JCheckBox(CONSTANTS.CAR_RENTAL_TABLE.car_id);
        JCheckBox company=new JCheckBox(CONSTANTS.CAR_RENTAL_TABLE.company);
        JCheckBox car_properties=new JCheckBox(CONSTANTS.CAR_RENTAL_TABLE.car_properties);
        JCheckBox daily_price=new JCheckBox(CONSTANTS.CAR_RENTAL_TABLE.daily_price);
        JCheckBox start_date=new JCheckBox(CONSTANTS.CAR_RENTAL_TABLE.start_date);
        JCheckBox end_date=new JCheckBox(CONSTANTS.CAR_RENTAL_TABLE.end_date);

        JButton okButton=new JButton("OK");
        JButton backB=new JButton("Back");
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.add(car_id);
        checkboxPanel.add(company);
        checkboxPanel.add(car_properties);
        checkboxPanel.add(daily_price);
        checkboxPanel.add(start_date);
        checkboxPanel.add(end_date);

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
                columns += car_id.isSelected() ? CONSTANTS.CAR_RENTAL_TABLE.car_id + "," : "";
                columns += company.isSelected() ? CONSTANTS.CAR_RENTAL_TABLE.company+ "," : "";
                columns += car_properties.isSelected() ? CONSTANTS.CAR_RENTAL_TABLE.car_properties + "," : "";
                columns += daily_price.isSelected() ? CONSTANTS.CAR_RENTAL_TABLE.daily_price + "," : "";
                columns += start_date.isSelected() ? CONSTANTS.CAR_RENTAL_TABLE.start_date + "," : "";
                columns += end_date.isSelected() ? CONSTANTS.CAR_RENTAL_TABLE.end_date + "," : "";


                getQuery(columns, checkboxPanel,CONSTANTS.TABLE_NAMES.car_rental);
            }
        });
    }


}
