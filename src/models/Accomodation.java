package models;

import interfaces.ModelInterface;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Accomodation implements ModelInterface<Accomodation> {

    private int acc_id;
    private int room_id;
    private int person_id;
    private int hotel_id;

    public Accomodation() {
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Accomodation(int acc_id, int room_id, int person_id, int hotel_id) {
        this.acc_id = acc_id;
        this.room_id = room_id;
        this.person_id = person_id;
        this.hotel_id = hotel_id;
    }

    @Override
    public Accomodation exportTableInstance(ResultSet rs) throws SQLException {
        return new Accomodation(
                rs.getInt("acc_id"),
                rs.getInt("room_id"),
                rs.getInt("person_id"),
                rs.getInt("hotel_id")
        );
    }

    @Override
    public String getSelectQuery(int id) {
        return "SELECT * FROM accomodation WHERE acc_id = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM accomodation";
    }

    @Override
    public String getDeleteQuery(int id) {
        return "DELETE FROM accomodation WHERE acc_id = " + id;
    }

    @Override
    public String getDeleteAllQuery() {
        return "DELETE FROM accomodation";
    }

    @Override
    public String getInsertQuery(Accomodation object) {
        return "INSERT INTO accomodation (acc_id, room_id, person_id, hotel_id) VALUES (" +
                "'" + object.getAcc_id() + "'," +
                "'" + object.getRoom_id() + "'," +
                "'" + object.getPerson_id() + "'," +
                object.getHotel_id() +
                ")";
    }

    @Override
    public String getUpdateQuery(Accomodation object, int id) {
        return "UPDATE accomodation SET " +
                "acc_id = '" + object.getAcc_id() + "', " +
                "room_id = '" + object.getRoom_id() + "', " +
                "person_id = '" + object.getPerson_id() + "', " +
                "hotel_id = " + object.getHotel_id() + " " +
                "WHERE acc_id = " + id;
    }
}
