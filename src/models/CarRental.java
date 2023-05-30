package models;

import interfaces.ModelInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CarRental implements ModelInterface<CarRental> {

    private int car_id;
    private String office;
    private String car_properties;
    private int daily_price;
    private Timestamp start_date;
    private Timestamp end_date;

    public CarRental() {
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getCar_properties() {
        return car_properties;
    }

    public void setCar_properties(String car_properties) {
        this.car_properties = car_properties;
    }

    public int getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(int daily_price) {
        this.daily_price = daily_price;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public CarRental(int car_id, String office, String car_properties, int daily_price, Timestamp start_date, Timestamp end_date) {
        this.car_id = car_id;
        this.office = office;
        this.car_properties = car_properties;
        this.daily_price = daily_price;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    @Override
    public CarRental exportTableInstance(ResultSet rs) throws SQLException {
        return new CarRental(
                rs.getInt("car_id"),
                rs.getString("office"),
                rs.getString("car_properties"),
                rs.getInt("daily_price"),
                rs.getTimestamp("start_date"),
                rs.getTimestamp("end_date")
        );
    }

    @Override
    public String getSelectQuery(int id) {
        return "SELECT * FROM car_rental WHERE car_id = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM car_rental";
    }

    @Override
    public String getDeleteQuery(int id) {
        return "DELETE FROM car_rental WHERE car_id = " + id;
    }

    @Override
    public String getDeleteAllQuery() {
        return "DELETE FROM car_rental";
    }

    @Override
    public String getInsertQuery(CarRental object) {
        return "INSERT INTO car_rental (car_id, office, car_properties, daily_price, start_date, end_date) VALUES (" +
                "'" + object.getCar_id() + "'," +
                "'" + object.getOffice() + "'," +
                "'" + object.getCar_properties() + "'," +
                object.getDaily_price() + "," +
                "'" + object.getStart_date() + "'," +
                "'" + object.getEnd_date() + ")";
    }

    @Override
    public String getUpdateQuery(CarRental object, int id) {
        return "UPDATE car_rental SET " +
                "car_id = '" + object.getCar_id() + "', " +
                "office = '" + object.getOffice() + "', " +
                "car_properties = '" + object.getCar_properties() + "', " +
                "daily_price = " + object.getDaily_price() + ", " +
                "start_date = '" + object.getStart_date() + "', " +
                "end_date = '" + object.getEnd_date() + "' " +
                "WHERE car_id = " + id;
    }
}

