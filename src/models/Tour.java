package models;

import interfaces.ModelInterface;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tour implements ModelInterface<Tour> {

    private int tour_id;
    private int transport_id;
    private int acc_id;
    private int capacity;
    private int tot_price;
    private int company_id;
    private int guide_id;

    public Tour() {
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public int getTransport_id() {
        return transport_id;
    }

    public void setTransport_id(int transport_id) {
        this.transport_id = transport_id;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getTot_price() {
        return tot_price;
    }

    public void setTot_price(int tot_price) {
        this.tot_price = tot_price;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getGuide_id() {
        return guide_id;
    }

    public void setGuide_id(int guide_id) {
        this.guide_id = guide_id;
    }

    public Tour(int tour_id, int transport_id, int acc_id, int capacity, int tot_price, int company_id, int guide_id) {
        this.tour_id = tour_id;
        this.transport_id = transport_id;
        this.acc_id = acc_id;
        this.capacity = capacity;
        this.tot_price = tot_price;
        this.company_id = company_id;
        this.guide_id = guide_id;
    }

    @Override
    public Tour exportTableInstance(ResultSet rs) throws SQLException {
        return new Tour(
                rs.getInt("tour_id"),
                rs.getInt("transport_id"),
                rs.getInt("acc_id"),
                rs.getInt("capacity"),
                rs.getInt("tot_price"),
                rs.getInt("company_id"),
                rs.getInt("guide_id")
        );
    }

    @Override
    public String getSelectQuery(int id) {
        return "SELECT * FROM tour WHERE tour_id = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM tour";
    }

    @Override
    public String getDeleteQuery(int id) {
        return "DELETE FROM tour WHERE tour_id = " + id;
    }

    @Override
    public String getDeleteAllQuery() {
        return "DELETE FROM tour";
    }

    @Override
    public String getInsertQuery(Tour object) {
        return "INSERT INTO tour (tour_id, transport_id, acc_id, capacity, tot_price, company_id, guide_id) VALUES (" +
                "'" + object.getTour_id() + "'," +
                "'" + object.getTransport_id() + "'," +
                "'" + object.getAcc_id() + "'," +
                object.getCapacity() + "," +
                object.getTot_price() + "," +
                object.getCompany_id() + "," +
                object.getGuide_id() +
                ")";
    }

    @Override
    public String getUpdateQuery(Tour object, int id) {
        return "UPDATE tour SET " +
                "tour_id = '" + object.getTour_id() + "', " +
                "transport_id = '" + object.getTransport_id() + "', " +
                "acc_id = '" + object.getAcc_id() + "', " +
                "capacity = " + object.getCapacity() + ", " +
                "tot_price = " + object.getTot_price() + ", " +
                "company_id = " + object.getCompany_id() + ", " +
                "guide_id = " + object.getGuide_id() + " " +
                "WHERE tour_id = " + id;
    }
}
