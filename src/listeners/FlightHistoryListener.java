package listeners;

import constants.CONSTANTS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightHistoryListener extends MyListener implements ActionListener {
    public FlightHistoryListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel, upperPanel, st);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        JTextField person_id_text_field = new JTextField();
        person_id_text_field.setPreferredSize(new Dimension(300,30));
        JLabel enterPersonId = new JLabel("Enter person_id here : ");

        JCheckBox transport_id=new JCheckBox(CONSTANTS.TRANSPORT_TABLE.transport_id);
        JCheckBox person_id=new JCheckBox(CONSTANTS.TRANSPORT_TABLE.person_id);
        JCheckBox transport_type=new JCheckBox(CONSTANTS.TRANSPORT_TABLE.transport_type);
        JCheckBox respective_id=new JCheckBox(CONSTANTS.TRANSPORT_TABLE.respective_id);
        JCheckBox flight_id = new JCheckBox(CONSTANTS.FLIGHT_TABLE.flight_id);
        JCheckBox departure_p=new JCheckBox(CONSTANTS.FLIGHT_TABLE.departure_p);
        JCheckBox aperture_p=new JCheckBox(CONSTANTS.FLIGHT_TABLE.aperture_p);
        JCheckBox departure_t = new JCheckBox(CONSTANTS.FLIGHT_TABLE.departure_t);
        JCheckBox aperture_t=new JCheckBox(CONSTANTS.FLIGHT_TABLE.aperture_t);

        JButton okButton=new JButton("OK");
        JButton backB=new JButton("Back");

        JPanel checkboxPanel = new JPanel();
        JPanel personIdPanel = new JPanel();
        checkboxPanel.add(transport_id);
        checkboxPanel.add(person_id);
        checkboxPanel.add(transport_type);
        checkboxPanel.add(respective_id);
        checkboxPanel.add(flight_id);
        checkboxPanel.add(departure_p);
        checkboxPanel.add(aperture_p);
        checkboxPanel.add(departure_t);
        checkboxPanel.add(aperture_t);
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
                    columns += transport_id.isSelected() ? "t."+CONSTANTS.TRANSPORT_TABLE.transport_id + ", " : "";
                    columns += person_id.isSelected() ? "t."+CONSTANTS.TRANSPORT_TABLE.person_id + ", " : "";
                    columns += transport_type.isSelected() ? "t."+CONSTANTS.TRANSPORT_TABLE.transport_type + ", " : "";
                    columns += respective_id.isSelected() ? "t."+CONSTANTS.TRANSPORT_TABLE.respective_id + ", " : "";
                    columns += flight_id.isSelected() ? "f."+CONSTANTS.FLIGHT_TABLE.flight_id + ", " : "";
                    columns += departure_p.isSelected() ? "f."+CONSTANTS.FLIGHT_TABLE.departure_p + ", " : "";
                    columns += aperture_p.isSelected() ? "f."+CONSTANTS.FLIGHT_TABLE.aperture_p + ", " : "";
                    columns += departure_t.isSelected() ? "f."+CONSTANTS.FLIGHT_TABLE.departure_t + ", " : "";
                    columns += aperture_t.isSelected() ? "f."+CONSTANTS.FLIGHT_TABLE.aperture_t +" " : "";

                    if(columns.length()==0) {
                        columns += "t.transport_id, t.person_id, t.transport_type, t.respective_id, " +
                                "f.flight_id, f.departure_p, f.aperture_p, f.departure_t, f.aperture_t ";
                    }


                    String select = "SELECT "+columns+" ";
                    String from = "FROM "+CONSTANTS.TABLE_NAMES.transport+" t ";
                    String left_join = "LEFT JOIN "+ CONSTANTS.TABLE_NAMES.flights + " f ON t."
                            + CONSTANTS.TRANSPORT_TABLE.respective_id + " = f."+CONSTANTS.FLIGHT_TABLE.flight_id+" ";
                    String where = "WHERE t."+CONSTANTS.PERSON_TABLE.person_id + " =" + person_id_text_field.getText()+" AND t."+
                            CONSTANTS.TRANSPORT_TABLE.transport_type+" = '"+CONSTANTS.TABLE_NAMES.flights+"'";
                /*
                SELECT t.transport_id, t.person_id, t.transport_type, t.respective_id,
                       f.flight_id, f.departure_p, f.aperture_p, f.departure_t, f.aperture_t
                FROM transport t
                LEFT JOIN flights f ON t.respective_id = f.flight_id
                WHERE t.person_id = 2565 AND t.transport_type = 'flights';

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
