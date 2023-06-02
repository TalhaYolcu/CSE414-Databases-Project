package listeners;

import constants.CONSTANTS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class TourHistoryListener extends MyListener implements ActionListener {
    public TourHistoryListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel, upperPanel, st);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        JTextField person_id_text_field = new JTextField();
        person_id_text_field.setPreferredSize(new Dimension(300,30));
        JLabel enterPersonId = new JLabel("Enter person_id here : ");

        JCheckBox tour_id=new JCheckBox(CONSTANTS.TOUR_TABLE.tour_id);
        JCheckBox person_id=new JCheckBox(CONSTANTS.TOUR_TABLE.person_id);
        JCheckBox transport_id=new JCheckBox(CONSTANTS.TOUR_TABLE.transport_id);
        JCheckBox acc_id=new JCheckBox(CONSTANTS.TOUR_TABLE.acc_id);
        JCheckBox capacity=new JCheckBox(CONSTANTS.TOUR_TABLE.capacity);
        JCheckBox tot_price= new JCheckBox(CONSTANTS.TOUR_TABLE.tot_price);
        JCheckBox company_id=new JCheckBox(CONSTANTS.TOUR_TABLE.company_id);
        JCheckBox guide_id=new JCheckBox(CONSTANTS.TOUR_TABLE.guide_id);

        JButton okButton=new JButton("OK");
        JButton backB=new JButton("Back");

        JPanel checkboxPanel = new JPanel();
        JPanel personIdPanel = new JPanel();
        checkboxPanel.add(tour_id);
        checkboxPanel.add(person_id);
        checkboxPanel.add(transport_id);
        checkboxPanel.add(acc_id);
        checkboxPanel.add(capacity);
        checkboxPanel.add(tot_price);
        checkboxPanel.add(company_id);
        checkboxPanel.add(guide_id);

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
                    columns += tour_id.isSelected() ? "t."+CONSTANTS.TOUR_TABLE.tour_id + ", " : "";
                    columns += person_id.isSelected() ? "t."+CONSTANTS.TOUR_TABLE.person_id + ", " : "";
                    columns += transport_id.isSelected() ? "t."+CONSTANTS.TOUR_TABLE.transport_id + ", " : "";
                    columns += acc_id.isSelected() ? "t."+CONSTANTS.TOUR_TABLE.acc_id + ", " : "";
                    columns += capacity.isSelected() ? "t."+CONSTANTS.TOUR_TABLE.capacity + ", " : "";
                    columns += tot_price.isSelected() ? "t."+CONSTANTS.TOUR_TABLE.tot_price + ", " : "";
                    columns += company_id.isSelected() ? "t."+CONSTANTS.TOUR_TABLE.company_id + ", " : "";
                    columns += guide_id.isSelected() ? "t."+CONSTANTS.TOUR_TABLE.guide_id + ", " : "";

                    if(columns.length()==0) {
                        columns += "t.tour_id, t.person_id, t.transport_id, t.acc_id, t.capacity, t.tot_price, t.company_id, t.guide_id ";
                    }


                    String select = "SELECT "+columns+" ";
                    String from = "FROM "+CONSTANTS.TABLE_NAMES.tour+" t ";
                    String left_join = "LEFT JOIN "+ CONSTANTS.TABLE_NAMES.transport + " tr ON t."
                            + CONSTANTS.TRANSPORT_TABLE.transport_id + " = tr."+CONSTANTS.TRANSPORT_TABLE.transport_id+" " +
                            "LEFT JOIN  " + CONSTANTS.TABLE_NAMES.accomodation + " a ON" +
                            " t."+CONSTANTS.ACCOMODATION_TABLE.acc_id+" =a."+CONSTANTS.ACCOMODATION_TABLE.acc_id+" "+
                            "LEFT JOIN " + CONSTANTS.TABLE_NAMES.person + " p ON t.person_id = p."+CONSTANTS.PERSON_TABLE.person_id;

                    String where = " WHERE p.person_id = " +person_id_text_field.getText();
                /*
                SELECT t.tour_id, t.person_id, t.transport_id, t.acc_id, t.capacity, t.tot_price, t.company_id, t.guide_id,
                       tr.transport_type, a.hotel_id, a.room_id, p.person_name
                FROM tour t
                LEFT JOIN transport tr ON t.transport_id = tr.transport_id
                LEFT JOIN accommodation a ON t.acc_id = a.acc_id
                LEFT JOIN persons p ON t.person_id = p.person_id;




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