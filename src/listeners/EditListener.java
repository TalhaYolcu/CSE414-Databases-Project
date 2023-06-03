package listeners;

import constants.CONSTANTS;
import models.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class EditListener {
    public static JPanel btnPanel;
    public static JPanel upperPanel;
    public static Statement st;


    public EditListener(JPanel btnPanel,JPanel upperPanel,Statement st) {
        EditListener.btnPanel =btnPanel;
        EditListener.upperPanel=upperPanel;
        EditListener.st=st;
    }




}
