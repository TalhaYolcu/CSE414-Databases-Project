package models;

import interfaces.ModelInterface;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Guide implements ModelInterface<Guide> {

    private int guide_id;
    private int person_id;
    private int company_id;
    private String company_name;
    private int tot_guide;

    public Guide() {
    }

    public int getGuide_id() {
        return guide_id;
    }

    public void setGuide_id(int guide_id) {
        this.guide_id = guide_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
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

    public int getTot_guide() {
        return tot_guide;
    }

    public void setTot_guide(int tot_guide) {
        this.tot_guide = tot_guide;
    }

    public Guide(int guide_id, int person_id, int company_id, String company_name, int tot_guide) {
        this.guide_id = guide_id;
        this.person_id = person_id;
        this.company_id = company_id;
        this.company_name = company_name;
        this.tot_guide = tot_guide;
    }

    @Override
    public Guide exportTableInstance(ResultSet rs) throws SQLException {
        return new Guide(
                rs.getInt("guide_id"),
                rs.getInt("person_id"),
                rs.getInt("company_id"),
                rs.getString("company_name"),
                rs.getInt("tot_guide")
        );
    }

    @Override
    public String getSelectQuery(int id) {
        return "SELECT * FROM guide WHERE guide_id = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM guide";
    }

    @Override
    public String getDeleteQuery(int id) {
        return "DELETE FROM guide WHERE guide_id = " + id;
    }

    @Override
    public String getDeleteAllQuery() {
        return "DELETE FROM guide";
    }

    @Override
    public String getInsertQuery(Guide object) {
        return "INSERT INTO guide (guide_id, person_id, company_id, company_name, tot_guide) VALUES (" +
                "'" + object.getGuide_id() + "'," +
                "'" + object.getPerson_id() + "'," +
                object.getCompany_id() + "," +
                "'" + object.getCompany_name() + "'," +
                object.getTot_guide() +
                ")";
    }

    @Override
    public String getUpdateQuery(Guide object, int id) {
        return "UPDATE guide SET " +
                "guide_id = '" + object.getGuide_id() + "', " +
                "person_id = '" + object.getPerson_id() + "', " +
                "company_id = " + object.getCompany_id() + ", " +
                "company_name = '" + object.getCompany_name() + "', " +
                "tot_guide = " + object.getTot_guide() + " " +
                "WHERE guide_id = " + id;
    }
}
