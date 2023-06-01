package listeners;

import models.TableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract  class MyListener {
    public static JPanel btnPanel;
    public static JPanel upperPanel;
    public static Statement st;

    public MyListener(JPanel btnPanel,JPanel upperPanel,Statement st) {
        FlightListener.btnPanel =btnPanel;
        FlightListener.upperPanel=upperPanel;
        FlightListener.st=st;
    }
    protected static void getQuery(String columns, JPanel checkboxPanel,String table_name) {
        if(columns.length()==0) {
            columns += "*";
        }
        else {
            columns = columns.substring(0,columns.length()-1);
        }
        try {

            String query = "select "+columns+" from "+table_name;
            System.out.println("QUERY : "+query);

            ResultSet rs = st.executeQuery(query);

            JTable table = new JTable(TableModel.buildTableModel(rs));
            JButton backToBox= new JButton("Back");

            JScrollPane scrollPane = new JScrollPane(table);
            JPanel scrollPanel = new JPanel();
            scrollPanel.add(scrollPane);

            upperPanel.add(scrollPane);
            upperPanel.add(backToBox);
            upperPanel.repaint();

            backToBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    scrollPanel.setVisible(false);
                    scrollPane.setVisible(false);
                    checkboxPanel.setVisible(true);
                    backToBox.setVisible(false);
                    upperPanel.repaint();
                }
            });

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
