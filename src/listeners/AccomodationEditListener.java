package listeners;

import constants.CONSTANTS;
import models.Accomodation;
import models.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccomodationEditListener extends EditListener implements ActionListener {
    private JButton insertButton=new JButton(CONSTANTS.OPERATIONS.insert);
    private JButton deleteButton = new JButton(CONSTANTS.OPERATIONS.delete);
    private JButton editButton = new JButton(CONSTANTS.OPERATIONS.edit);
    private JButton backButton = new JButton("Back");
    private JPanel operationPanel=new JPanel();
    private JPanel inputTakePanel=new JPanel();
    private JButton insertOKButton=new JButton("OK");
    private JButton insertBackButton=new JButton("Back");
    private JLabel[] columns=new JLabel[CONSTANTS.ACCOMODATION_TABLE.column_count];
    private JTextField[] entries=new JTextField[CONSTANTS.ACCOMODATION_TABLE.column_count];
    private JTable table;
    private JScrollPane scrollPane;
    private JPanel scrollPanel;

    public AccomodationEditListener(JPanel btnPanel, JPanel upperPanel, Statement st) {
        super(btnPanel, upperPanel, st);

        operationPanel.add(insertButton);
        operationPanel.add(deleteButton);
        operationPanel.add(editButton);
        operationPanel.add(backButton);

        for (int i=0;i<columns.length;i++) {
            columns[i]=new JLabel(CONSTANTS.ACCOMODATION_TABLE.column_names[i]);
            entries[i]=new JTextField();
            entries[i].setPreferredSize(new Dimension(300,30));
            inputTakePanel.add(columns[i]);
            inputTakePanel.add(entries[i]);
        }

        inputTakePanel.add(insertOKButton);
        inputTakePanel.add(insertBackButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPanel.setVisible(true);
                operationPanel.setVisible(false);
                upperPanel.remove(operationPanel);
                upperPanel.repaint();
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ResultSet rs = st.executeQuery(new Accomodation().getSelectAllQuery());
                    table = new JTable(TableModel.buildTableModel(rs));

                    scrollPanel = new JPanel();
                    scrollPanel.setLayout(new BorderLayout());

                    // Create a scroll pane and add the table to it
                    scrollPane = new JScrollPane(table);

                    scrollPanel.add(scrollPane,BorderLayout.CENTER);



                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }

                operationPanel.setVisible(false);
                upperPanel.remove(operationPanel);

                inputTakePanel.setVisible(true);
                scrollPanel.setVisible(true);

                inputTakePanel.repaint();
                scrollPanel.repaint();

                upperPanel.add(inputTakePanel);
                upperPanel.add(scrollPanel);

                upperPanel.repaint();

            }
        });
        insertOKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    /*
                    INSERT INTO `travel_booking`.`accomodation` (`acc_id`, `hotel_id`, `room_id`, `person_id`) VALUES ('125', '123123', '3', '1');
                     */
                for(int i=0;i<columns.length;i++) {
                    if(entries[i]==null || entries[i].getText()==null || entries[i].getText().length()==0) {
                        return;
                    }
                }
                String query = "INSERT INTO "+CONSTANTS.DB_NAME+"."+CONSTANTS.TABLE_NAMES.accomodation+" (" +
                        CONSTANTS.ACCOMODATION_TABLE.acc_id+", "+CONSTANTS.ACCOMODATION_TABLE.hotel_id+", "+
                        CONSTANTS.ACCOMODATION_TABLE.room_id+", "+
                        CONSTANTS.ACCOMODATION_TABLE.person_id+") VALUES ("+entries[0].getText()+", "+
                        entries[1].getText()+", "+entries[2].getText()+", "+entries[3].getText()+");";

                System.out.println(query);
                try {

                    //insert and update the table
                    st.execute(query);

                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }

                scrollPanel.setVisible(false);

                //update the table
                updateTable(table,scrollPane,scrollPanel);
                upperPanel.repaint();
            }
        });
        insertBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTakePanel.setVisible(false);
                scrollPane.setVisible(false);
                scrollPanel.setVisible(false);


                upperPanel.revalidate();
                upperPanel.repaint();

                // Reset variables
                scrollPanel = null;
                scrollPane = null;
                table = null;

                operationPanel.setVisible(true);
                upperPanel.add(operationPanel);

                // Remove scrollPanel from upperPanel
                upperPanel.remove(scrollPanel);

                upperPanel.revalidate();
                upperPanel.repaint();
            }
        });



    }

    private void updateTable(JTable table, JScrollPane scrollPane, JPanel scrollPanel) {
        try {
            table.setVisible(false);
            scrollPane.setVisible(false);
            scrollPanel.setVisible(false);

            scrollPane.remove(table);
            scrollPanel.remove(scrollPane);

            // Remove existing scrollPanel from upperPanel
            upperPanel.remove(scrollPanel);

            ResultSet rs = st.executeQuery(new Accomodation().getSelectAllQuery());
            table = new JTable(TableModel.buildTableModel(rs));

            scrollPanel = new JPanel();
            scrollPanel.setLayout(new BorderLayout());

            // Create a scroll pane and add the table to it
            scrollPane = new JScrollPane(table);

            scrollPanel.add(scrollPane,BorderLayout.CENTER);

            table.setVisible(true);
            scrollPane.setVisible(true);
            scrollPanel.setVisible(true);

            //upperPanel.add(scrollPanel);
            upperPanel.repaint();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setVisible(false);
        operationPanel.setVisible(true);
        upperPanel.add(operationPanel);
        upperPanel.remove(scrollPanel);
        upperPanel.remove(inputTakePanel);

    }
}
