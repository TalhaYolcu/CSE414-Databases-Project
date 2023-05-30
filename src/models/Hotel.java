package models;

import interfaces.ModelInterface;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Hotel implements ModelInterface<Hotel> {

    private int hotel_id;
    private String hotel_name;
    private String location;

    public Hotel() {
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Hotel(int hotel_id, String hotel_name, String location) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.location = location;
    }

    @Override
    public Hotel exportTableInstance(ResultSet rs) throws SQLException {
        return new Hotel(
                rs.getInt("hotel_id"),
                rs.getString("hotel_name"),
                rs.getString("location")
        );
    }

    @Override
    public String getSelectQuery(int id) {
        return "SELECT * FROM hotels WHERE hotel_id = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM hotels";
    }

    @Override
    public String getDeleteQuery(int id) {
        return "DELETE FROM hotels WHERE hotel_id = " + id;
    }

    @Override
    public String getDeleteAllQuery() {
        return "DELETE FROM hotels";
    }

    @Override
    public String getInsertQuery(Hotel object) {
        return "INSERT INTO hotels (hotel_id, hotel_name, location) VALUES (" +
                "'" + object.getHotel_id() + "'," +
                "'" + object.getHotel_name() + "'," +
                "'" + object.getLocation() + "'" +
                ")";
    }

    @Override
    public String getUpdateQuery(Hotel object, int id) {
        return "UPDATE hotels SET " +
                "hotel_id = '" + object.getHotel_id() + "', " +
                "hotel_name = '" + object.getHotel_name() + "', " +
                "location = '" + object.getLocation() + "' " +
                "WHERE hotel_id = " + id;
    }
}
