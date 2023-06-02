package listeners;

import constants.CONSTANTS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class CarRentalHistoryListener extends MyListener implements ActionListener {
    public CarRentalHistoryListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel, upperPanel, st);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        JTextField person_id_text_field = new JTextField();
        person_id_text_field.setPreferredSize(new Dimension(300,30));
        JLabel enterPersonId = new JLabel("Enter person_id here : ");

        JCheckBox rental_id=new JCheckBox(CONSTANTS.RENTAL_TABLE.rental_id);
        JCheckBox person_id=new JCheckBox(CONSTANTS.RENTAL_TABLE.person_id);
        JCheckBox car_id=new JCheckBox(CONSTANTS.RENTAL_TABLE.car_id);
        JCheckBox company_id=new JCheckBox(CONSTANTS.RENTAL_TABLE.company_id);
        JCheckBox car_properties = new JCheckBox(CONSTANTS.CAR_RENTAL_TABLE.car_properties);
        JCheckBox daily_price=new JCheckBox(CONSTANTS.CAR_RENTAL_TABLE.daily_price);
        JCheckBox start_date=new JCheckBox(CONSTANTS.CAR_RENTAL_TABLE.start_date);
        JCheckBox end_date = new JCheckBox(CONSTANTS.CAR_RENTAL_TABLE.end_date);

        JButton okButton=new JButton("OK");
        JButton backB=new JButton("Back");

        JPanel checkboxPanel = new JPanel();
        JPanel personIdPanel = new JPanel();
        checkboxPanel.add(rental_id);
        checkboxPanel.add(person_id);
        checkboxPanel.add(car_id);
        checkboxPanel.add(company_id);
        checkboxPanel.add(car_properties);
        checkboxPanel.add(daily_price);
        checkboxPanel.add(start_date);
        checkboxPanel.add(end_date);
        personIdPanel.add(enterPersonId);
        personIdPanel.add(person_id_text_field);
        personIdPanel.add(okButton);
        personIdPanel.add(backB);
        upperPanel.add(checkboxPanel);
        upperPanel.add(personIdPanel);

        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPanel.setVisible(true);
                checkboxPanel.setVisible(false);
                personIdPanel.setVisible(false);

            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(person_id_text_field.getText()!=null && person_id_text_field.getText().length()!=0) {
                    checkboxPanel.setVisible(false);
                    personIdPanel.setVisible(false);

                    String columns="";
                    columns += rental_id.isSelected() ? "r."+CONSTANTS.RENTAL_TABLE.rental_id + ", " : "";
                    columns += person_id.isSelected() ? "r."+CONSTANTS.RENTAL_TABLE.person_id + ", " : "";
                    columns += car_id.isSelected() ? "r."+CONSTANTS.RENTAL_TABLE.car_id + ", " : "";
                    columns += company_id.isSelected() ? "r."+CONSTANTS.RENTAL_TABLE.company_id + ", " : "";
                    columns += car_properties.isSelected() ? "c."+ CONSTANTS.CAR_RENTAL_TABLE.car_properties + ", " : "";
                    columns += daily_price.isSelected() ? "c."+ CONSTANTS.CAR_RENTAL_TABLE.daily_price + ", " : "";
                    columns += start_date.isSelected() ? "c."+CONSTANTS.CAR_RENTAL_TABLE.start_date + ", " : "";
                    columns += end_date.isSelected() ? "c."+CONSTANTS.CAR_RENTAL_TABLE.end_date + ", " : "";

                    if(columns.length()==0) {
                        columns += "r.rental_id, r.person_id, r.car_id, r.company_id, " +
                                "c.car_properties, c.daily_price, c.start_date, c.end_date ";
                    }


                    String select = "SELECT "+columns;
                    String from = "FROM "+CONSTANTS.TABLE_NAMES.rental+" r ";
                    String right_join = "RIGHT JOIN "+ CONSTANTS.TABLE_NAMES.car_rental + " c ON r."
                            + CONSTANTS.RENTAL_TABLE.car_id + " = c."+CONSTANTS.CAR_RENTAL_TABLE.car_id+" ";
                    String where = "WHERE r."+CONSTANTS.RENTAL_TABLE.person_id + " = " + person_id_text_field.getText();
                /*
                SELECT r.rental_id, r.person_id, r.car_id, r.company_id, c.car_properties, c.daily_price, c.start_date, c.end_date
                FROM rental r
                RIGHT JOIN car_rental c ON r.car_id = c.car_id
                WHERE r.person_id =2565
;


                 */
                    String query = select + from + right_join + where;
                    System.out.println(query);
                    try {
                        executeQuery(query,new JPanel[]{checkboxPanel,personIdPanel});

                    }
                    catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
    }
}
