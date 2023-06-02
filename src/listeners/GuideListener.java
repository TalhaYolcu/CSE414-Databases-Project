package listeners;

import constants.CONSTANTS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class GuideListener extends MyListener implements ActionListener {
    public GuideListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel, upperPanel, st);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        JCheckBox guide_id=new JCheckBox(CONSTANTS.GUIDE_TABLE.guide_id);
        JCheckBox person_id=new JCheckBox(CONSTANTS.GUIDE_TABLE.person_id);
        JCheckBox company_id=new JCheckBox(CONSTANTS.GUIDE_TABLE.company_id);
        JCheckBox company_name=new JCheckBox(CONSTANTS.GUIDE_TABLE.company_name);
        JCheckBox tot_guide=new JCheckBox(CONSTANTS.GUIDE_TABLE.tot_guide);

        JButton okButton=new JButton("OK");
        JButton backB=new JButton("Back");
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.add(guide_id);
        checkboxPanel.add(person_id);
        checkboxPanel.add(company_name);
        checkboxPanel.add(company_id);
        checkboxPanel.add(company_name);
        checkboxPanel.add(tot_guide);
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
                columns += guide_id.isSelected() ? CONSTANTS.GUIDE_TABLE.guide_id + "," : "";
                columns += person_id.isSelected() ? CONSTANTS.GUIDE_TABLE.person_id + "," : "";
                columns += company_id.isSelected() ? CONSTANTS.GUIDE_TABLE.company_id + "," : "";
                columns += company_name.isSelected() ? CONSTANTS.GUIDE_TABLE.company_name + "," : "";
                columns += tot_guide.isSelected() ? CONSTANTS.GUIDE_TABLE.tot_guide + "," : "";
                getQuery(columns, checkboxPanel,CONSTANTS.TABLE_NAMES.guide);
            }
        });
    }
}