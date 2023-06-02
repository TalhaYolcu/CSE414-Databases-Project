package listeners;

import constants.CONSTANTS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class TourListener extends MyListener implements ActionListener {
    public TourListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel, upperPanel, st);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        JCheckBox tour_id=new JCheckBox(CONSTANTS.TOUR_TABLE.tour_id);
        JCheckBox transport_id=new JCheckBox(CONSTANTS.TOUR_TABLE.transport_id);
        JCheckBox acc_id=new JCheckBox(CONSTANTS.TOUR_TABLE.acc_id);
        JCheckBox capacity=new JCheckBox(CONSTANTS.TOUR_TABLE.capacity);
        JCheckBox tot_price=new JCheckBox(CONSTANTS.TOUR_TABLE.tot_price);
        JCheckBox company_id=new JCheckBox(CONSTANTS.TOUR_TABLE.company_id);
        JCheckBox guide_id=new JCheckBox(CONSTANTS.TOUR_TABLE.guide_id);
        JButton okButton=new JButton("OK");
        JButton backB=new JButton("Back");
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.add(tour_id);
        checkboxPanel.add(transport_id);
        checkboxPanel.add(acc_id);
        checkboxPanel.add(capacity);
        checkboxPanel.add(tot_price);
        checkboxPanel.add(company_id);
        checkboxPanel.add(guide_id);
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
                columns += tour_id.isSelected() ? CONSTANTS.TOUR_TABLE.tour_id + "," : "";
                columns += transport_id.isSelected() ? CONSTANTS.TOUR_TABLE.transport_id + "," : "";
                columns += acc_id.isSelected() ? CONSTANTS.TOUR_TABLE.acc_id + "," : "";
                columns += capacity.isSelected() ? CONSTANTS.TOUR_TABLE.capacity + "," : "";
                columns += tot_price.isSelected() ? CONSTANTS.TOUR_TABLE.tot_price + "," : "";
                columns += company_id.isSelected() ? CONSTANTS.TOUR_TABLE.company_id + "," : "";
                columns += guide_id.isSelected() ? CONSTANTS.TOUR_TABLE.guide_id + "," : "";
                getQuery(columns, checkboxPanel,CONSTANTS.TABLE_NAMES.tour);
            }
        });
    }
}
