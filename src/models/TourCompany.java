package models;

import interfaces.ModelInterface;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TourCompany implements ModelInterface<TourCompany> {

    private int company_id;
    private String company_name;

    public TourCompany() {
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public TourCompany(int company_id, String company_name) {
        this.company_id = company_id;
        this.company_name = company_name;
    }

    @Override
    public TourCompany exportTableInstance(ResultSet rs) throws SQLException {
        return new TourCompany(
                rs.getInt("company_id"),
                rs.getString("company_name")
        );
    }

    @Override
    public String getSelectQuery(int id) {
        return "SELECT * FROM tour_guide WHERE company_id = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM tour_guide";
    }

    @Override
    public String getDeleteQuery(int id) {
        return "DELETE FROM tour_guide WHERE company_id = " + id;
    }

    @Override
    public String getDeleteAllQuery() {
        return "DELETE FROM tour_guide";
    }

    @Override
    public String getInsertQuery(TourCompany object) {
        return "INSERT INTO tour_guide (company_id, company_name) VALUES (" +
                object.getCompany_id() + "," +
                "'" + object.getCompany_name() + "'" +
                ")";
    }

    @Override
    public String getUpdateQuery(TourCompany object, int id) {
        return "UPDATE tour_guide SET " +
                "company_id = " + object.getCompany_id() + ", " +
                "company_name = '" + object.getCompany_name() + "' " +
                "WHERE company_id = " + id;
    }
}
