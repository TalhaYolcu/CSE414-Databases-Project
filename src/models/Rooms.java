package models;

import interfaces.ModelInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Rooms implements ModelInterface<Rooms> {

    private int hotel_id;
    private int room_id;
    private String room_properties;
    private int room_cap;
    private int daily_price;
    private Timestamp check_in;
    private Timestamp check_out;

    public Rooms() {
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_properties() {
        return room_properties;
    }

    public void setRoom_properties(String room_properties) {
        this.room_properties = room_properties;
    }

    public int getRoom_cap() {
        return room_cap;
    }

    public void setRoom_cap(int room_cap) {
        this.room_cap = room_cap;
    }

    public int getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(int daily_price) {
        this.daily_price = daily_price;
    }

    public Timestamp getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Timestamp check_in) {
        this.check_in = check_in;
    }

    public Timestamp getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Timestamp check_out) {
        this.check_out = check_out;
    }

    public Rooms(int hotel_id, int room_id, String room_properties, int room_cap, int daily_price, Timestamp check_in, Timestamp check_out) {
        this.hotel_id = hotel_id;
        this.room_id = room_id;
        this.room_properties = room_properties;
        this.room_cap = room_cap;
        this.daily_price = daily_price;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    @Override
    public Rooms exportTableInstance(ResultSet rs) throws SQLException {
        return new Rooms(
                rs.getInt("hotel_id"),
                rs.getInt("room_id"),
                rs.getString("room_properties"),
                rs.getInt("room_cap"),
                rs.getInt("daily_price"),
                rs.getTimestamp("check_in"),
                rs.getTimestamp("check_out")
        );
    }

    @Override
    public String getSelectQuery(int id) {
        return "SELECT * FROM rooms WHERE room_id = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM rooms";
    }

    @Override
    public String getDeleteQuery(int id) {
        return "DELETE FROM rooms WHERE room_id = " + id;
    }

    @Override
    public String getDeleteAllQuery() {
        return "DELETE FROM rooms";
    }

    @Override
    public String getInsertQuery(Rooms object) {
        return "INSERT INTO rooms (hotel_id, room_id, room_properties, room_cap, daily_price, check_in, check_out) VALUES (" +
                "'" + object.getHotel_id() + "'," +
                "'" + object.getRoom_id() + "'," +
                "'" + object.getRoom_properties() + "'," +
                object.getRoom_cap() + "," +
                object.getDaily_price() + "," +
                "'" + object.getCheck_in() + "'," +
                "'" + object.getCheck_out() + "'" +
                ")";
    }

    @Override
    public String getUpdateQuery(Rooms object, int id) {
        return "UPDATE rooms SET " +
                "hotel_id = '" + object.getHotel_id() + "', " +
                "room_id = '" + object.getRoom_id() + "', " +
                "room_properties = '" + object.getRoom_properties() + "', " +
                "room_cap = " + object.getRoom_cap() + ", " +
                "daily_price = " + object.getDaily_price() + ", " +
                "check_in = '" + object.getCheck_in() + "', " +
                "check_out = '" + object.getCheck_out() + "' " +
                "WHERE room_id = " + id;
    }
}
