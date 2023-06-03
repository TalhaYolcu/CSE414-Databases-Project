package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class SpecialQueryListener extends MyListener implements ActionListener {
    private JTextField query_text_field;
    public SpecialQueryListener(JPanel btnPanel, JPanel upperPanel, Statement st,JTextField query_text_field) {
        super(btnPanel, upperPanel, st);
        this.query_text_field=query_text_field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        String query = query_text_field.getText();
        try {
            System.out.println(query);
            executeQuery(query,new JPanel[]{btnPanel,upperPanel});
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
