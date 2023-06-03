package listeners;

import models.TableModel;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MyListener implements ActionListener{
    public static JPanel btnPanel;
    public static JPanel upperPanel;
    public static Statement st;

    public MyListener(JPanel btnPanel,JPanel upperPanel,Statement st) {
        MyListener.btnPanel =btnPanel;
        MyListener.upperPanel=upperPanel;
        MyListener.st=st;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    protected static void executeQuery(String query, JPanel[] panels) throws SQLException {

        try {
            ResultSet rs = st.executeQuery(query);

            JTable table = new JTable(TableModel.buildTableModel(rs));
            table.setPreferredSize(new Dimension(700,700));
            JButton backToBox= new JButton("Back");



            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(700,700));
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
                    for (JPanel panel : panels) {
                        panel.setVisible(true);
                    }
                    backToBox.setVisible(false);
                    upperPanel.repaint();
                }
            });



        }
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

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

            executeQuery(query, new JPanel[]{checkboxPanel});

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
