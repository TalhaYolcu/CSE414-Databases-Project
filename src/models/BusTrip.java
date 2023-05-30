package models;

import interfaces.ModelInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BusTrip implements ModelInterface<BusTrip> {

    private int bus_trip_id;
    private String departure_p;
    private String aperture_p;
    private Timestamp departure_t;
    private Timestamp aperture_t;
    private int capacity;
    private int price;

    public BusTrip() {
    }

    public int getBus_trip_id() {
        return bus_trip_id;
    }

    public void setBus_trip_id(int bus_trip_id) {
        this.bus_trip_id = bus_trip_id;
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

    public BusTrip(int bus_trip_id, String departure_p, String aperture_p, Timestamp departure_t, Timestamp aperture_t, int capacity, int price) {
        this.bus_trip_id = bus_trip_id;
        this.departure_p = departure_p;
        this.aperture_p = aperture_p;
        this.departure_t = departure_t;
        this.aperture_t = aperture_t;
        this.capacity = capacity;
        this.price = price;
    }

    @Override
    public BusTrip exportTableInstance(ResultSet rs) throws SQLException {
        return new BusTrip(
                rs.getInt("bus_trip_id"),
                rs.getString("departure_p"),
                rs.getString("aperture_p"),
                rs.getTimestamp("departure_t"),
                rs.getTimestamp("aperture_t"),
                rs.getInt("capacity"),
                rs.getInt("price")
        );
    }

    @Override
    public String getSelectQuery(int id) {
        return "SELECT * FROM bus_trip WHERE bus_trip_id = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM bus_trip";
    }

    @Override
    public String getDeleteQuery(int id) {
        return "DELETE FROM bus_trip WHERE bus_trip_id = " + id;
    }

    @Override
    public String getDeleteAllQuery() {
        return "DELETE FROM bus_trip";
    }

    @Override
    public String getInsertQuery(BusTrip object) {
        return "INSERT INTO bus_trip (bus_trip_id, departure_p, aperture_p, departure_t, aperture_t, capacity, price) VALUES (" +
                "'" + object.getBus_trip_id() + "'," +
                "'" + object.getDeparture_p() + "'," +
                "'" + object.getAperture_p() + "'," +
                "'" + object.getDeparture_t() + "'," +
                "'" + object.getAperture_t() + "'," +
                object.getCapacity() + "," +
                object.getPrice() +
                ")";
    }

    @Override
    public String getUpdateQuery(BusTrip object, int id) {
        return "UPDATE bus_trip SET " +
                "bus_trip_id = '" + object.getBus_trip_id() + "', " +
                "departure_p = '" + object.getDeparture_p() + "', " +
                "aperture_p = '" + object.getAperture_p() + "', " +
                "departure_t = '" + object.getDeparture_t() + "', " +
                "aperture_t = '" + object.getAperture_t() + "', " +
                "capacity = " + object.getCapacity() + ", " +
                "price = " + object.getPrice() +
                " WHERE bus_trip_id = " + id;
    }
}
