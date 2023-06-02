package listeners;

import constants.CONSTANTS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelHistoryListener extends MyListener implements ActionListener {
    public HotelHistoryListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel, upperPanel, st);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        JTextField person_id_text_field = new JTextField();
        person_id_text_field.setPreferredSize(new Dimension(300,30));
        JLabel enterPersonId = new JLabel("Enter person_id here : ");

        JCheckBox acc_id=new JCheckBox(CONSTANTS.ACCOMODATION_TABLE.acc_id);
        JCheckBox hotel_id=new JCheckBox(CONSTANTS.ACCOMODATION_TABLE.person_id);
        JCheckBox room_id=new JCheckBox(CONSTANTS.ACCOMODATION_TABLE.room_id);
        JCheckBox person_id=new JCheckBox(CONSTANTS.ACCOMODATION_TABLE.person_id);
        JCheckBox room_properties= new JCheckBox(CONSTANTS.ROOMS_TABLE.room_properties);
        JCheckBox daily_price=new JCheckBox(CONSTANTS.ROOMS_TABLE.daily_price);
        JCheckBox check_in_date=new JCheckBox(CONSTANTS.ROOMS_TABLE.check_in_date);
        JCheckBox check_out_date = new JCheckBox(CONSTANTS.ROOMS_TABLE.check_out_date);

        JButton okButton=new JButton("OK");
        JButton backB=new JButton("Back");

        JPanel checkboxPanel = new JPanel();
        JPanel personIdPanel = new JPanel();
        checkboxPanel.add(acc_id);
        checkboxPanel.add(hotel_id);
        checkboxPanel.add(room_id);
        checkboxPanel.add(person_id);
        checkboxPanel.add(room_properties);
        checkboxPanel.add(daily_price);
        checkboxPanel.add(check_in_date);
        checkboxPanel.add(check_out_date);

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
                    columns += acc_id.isSelected() ? "a."+CONSTANTS.ACCOMODATION_TABLE.acc_id + ", " : "";
                    columns += hotel_id.isSelected() ? "r."+CONSTANTS.ROOMS_TABLE.hotel_id + ", " : "";
                    columns += room_id.isSelected() ? "r."+CONSTANTS.ROOMS_TABLE.room_id + ", " : "";
                    columns += person_id.isSelected() ? "a."+CONSTANTS.ACCOMODATION_TABLE.person_id + ", " : "";
                    columns += room_properties.isSelected() ? "r."+CONSTANTS.ROOMS_TABLE.room_properties + ", " : "";
                    columns += daily_price.isSelected() ? "r."+CONSTANTS.ROOMS_TABLE.daily_price + ", " : "";
                    columns += check_in_date.isSelected() ? "r."+CONSTANTS.ROOMS_TABLE.check_in_date + ", " : "";
                    columns += check_out_date.isSelected() ? "r."+CONSTANTS.ROOMS_TABLE.check_out_date + ", " : "";

                    if(columns.length()==0) {
                        columns += "a.acc_id, r.hotel_id, r.room_id, a.person_id, r.room_properties," +
                                " r.daily_price, r.check_in_date, r.check_out_date ";
                    }


                    String select = " SELECT "+columns+" ";
                    String from = "FROM "+CONSTANTS.TABLE_NAMES.accomodation+" a ";
                    String left_join = "LEFT JOIN "+ CONSTANTS.TABLE_NAMES.rooms + " r ON a."
                            + CONSTANTS.ACCOMODATION_TABLE.hotel_id + " = r."+CONSTANTS.ROOMS_TABLE.hotel_id+" AND " +
                            "a."+CONSTANTS.ACCOMODATION_TABLE.room_id+" = r."+CONSTANTS.ROOMS_TABLE.room_id+" ";
                    String where = "WHERE a."+CONSTANTS.PERSON_TABLE.person_id + " =" + person_id_text_field.getText()+" ";
                /*
                SELECT a.acc_id, r.hotel_id, r.room_id, a.person_id, r.room_properties, r.daily_price, r.check_in_date, r.check_out_date
                FROM accommodation a
                LEFT JOIN rooms r ON a.hotel_id = r.hotel_id AND a.room_id = r.room_id
                WHERE a.person_id = <person_id>;


                 */
                    String query = select + from + left_join + where;
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