package listeners;

import constants.CONSTANTS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class TourCompanyListener extends MyListener implements ActionListener {
    public TourCompanyListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel, upperPanel, st);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        JCheckBox company_id=new JCheckBox(CONSTANTS.TOUR_COMPANY_TABLE.company_id);
        JCheckBox company_name=new JCheckBox(CONSTANTS.TOUR_COMPANY_TABLE.company_name);

        JButton okButton=new JButton("OK");
        JButton backB=new JButton("Back");
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.add(company_id);
        checkboxPanel.add(company_name);

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
                columns += company_id.isSelected() ? CONSTANTS.TOUR_COMPANY_TABLE.company_id + "," : "";
                columns += company_name.isSelected() ? CONSTANTS.TOUR_COMPANY_TABLE.company_name + "," : "";

                getQuery(columns, checkboxPanel,CONSTANTS.TABLE_NAMES.tour_company);
            }
        });
    }
}
