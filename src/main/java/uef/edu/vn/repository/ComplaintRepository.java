/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uef.edu.vn.model.Complaint;

/**
 *
 * @author LAB12-PC15
 */
@Repository
public class ComplaintRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Complaint mapRow(ResultSet rs, int rowNum) throws SQLException {
        Complaint c = new Complaint();
        c.setComplaintID(rs.getInt("ComplaintID"));
        c.setHouseholdID(rs.getInt("HouseholdID"));
        c.setDescription(rs.getString("Description"));
        c.setSubmissionDate(rs.getDate("SubmissionDate").toLocalDate());
        c.setStatus(rs.getString("Status"));
        return c;
    }

    public List<Complaint> findAll() {
        return jdbcTemplate.query("SELECT * FROM Complaints", this::mapRow);
    }

    public Complaint findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Complaints WHERE ComplaintID =  ?", this::mapRow, id);
    }

    public void save(Complaint c) {
        String sql = "INSERT INTO Complaints (HouseholdID, Description, SubmissionDate,Status) VALUES( ?,  ?,  ?,  ?)";
        jdbcTemplate.update(sql, c.getHouseholdID(), c.getDescription(),
                c.getSubmissionDate(), c.getStatus());
    }

    public void update(Complaint c) {
        String sql = "UPDATE Complaints SET HouseholdID=?, Description=?,SubmissionDate =? , Status ? WHERE  ComplaintID = ?";
        jdbcTemplate.update(sql, c.getHouseholdID(), c.getDescription(),
                c.getSubmissionDate(), c.getStatus(), c.getComplaintID());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Complaints WHERE ComplaintID=?", id);
    }
}
