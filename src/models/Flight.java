package models;

import interfaces.ModelInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Flight implements ModelInterface<Flight> {

    private int flight_id;
    private String departure_p;
    private String aperture_p;
    private Timestamp departure_t;
    private Timestamp aperture_t;
    private int capacity;
    private int price;
    private int spare_place;

    public Flight() {
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getDeparture_p() {
        return departure_p;
    }

    public void setDeparture_p(String departure_p) {
        this.departure_p = departure_p;
    }

    public String getAperture_p() {
        return aperture_p;
    }

    public void setAperture_p(String aperture_p) {
        this.aperture_p = aperture_p;
    }

    public Timestamp getDeparture_t() {
        return departure_t;
    }

    public void setDeparture_t(Timestamp departure_t) {
        this.departure_t = departure_t;
    }

    public Timestamp getAperture_t() {
        return aperture_t;
    }

    public void setAperture_t(Timestamp aperture_t) {
        this.aperture_t = aperture_t;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpare_place() {
        return spare_place;
    }

    public void setSpare_place(int spare_place) {
        this.spare_place = spare_place;
    }

    public Flight(int flight_id, String departure_p, String aperture_p, Timestamp departure_t, Timestamp aperture_t, int capacity, int price, int spare_place) {
        this.flight_id = flight_id;
        this.departure_p = departure_p;
        this.aperture_p = aperture_p;
        this.departure_t = departure_t;
        this.aperture_t = aperture_t;
        this.capacity = capacity;
        this.price = price;
        this.spare_place = spare_place;
    }

    @Override
    public Flight exportTableInstance(ResultSet rs) throws SQLException {
        return new Flight(
                rs.getInt("flight_id"),
                rs.getString("departure_p"),
                rs.getString("aperture_p"),
                rs.getTimestamp("departure_t"),
                rs.getTimestamp("aperture_t"),
                rs.getInt("capacity"),
                rs.getInt("price"),
                rs.getInt("spare_place")
        );
    }

    @Override
    public String getSelectQuery(int id) {
        return "SELECT * FROM flights WHERE flight_id = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM flights";
    }

    @Override
    public String getDeleteQuery(int id) {
        return "DELETE FROM flights WHERE flight_id = " + id;
    }

    @Override
    public String getDeleteAllQuery() {
        return "DELETE FROM flights";
    }

    @Override
    public String getInsertQuery(Flight object) {
        return "INSERT INTO flights (flight_id, departure_p, aperture_p, departure_t, aperture_t, capacity, price, spare_place) VALUES (" +
                "'" + object.getFlight_id() + "'," +
                "'" + object.getDeparture_p() + "'," +
                "'" + object.getAperture_p() + "'," +
                "'" + object.getDeparture_t() + "'," +
                "'" + object.getAperture_t() + "'," +
                object.getCapacity() + "," +
                object.getPrice() + "," +
                object.getSpare_place() +
                ")";
    }

    @Override
    public String getUpdateQuery(Flight object, int id) {
        return "UPDATE flights SET " +
                "flight_id = '" + object.getFlight_id() + "', " +
                "departure_p = '" + object.getDeparture_p() + "', " +
                "aperture_p = '" + object.getAperture_p() + "', " +
                "departure_t = '" + object.getDeparture_t() + "', " +
                "aperture_t = '" + object.getAperture_t() + "', " +
                "capacity = " + object.getCapacity() + ", " +
                "price = " + object.getPrice() + ", " +
                "spare_place = " + object.getSpare_place() +
                " WHERE flight_id = " + id;
    }
}
