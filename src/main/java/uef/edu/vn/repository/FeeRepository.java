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
import uef.edu.vn.model.Fee;

/**
 *
 * @author LAB12-PC15
 */
@Repository
public class FeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Fee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Fee f = new Fee();
        f.setFeeID(rs.getInt("FeeID"));
        f.setHouseholdID(rs.getInt("HouseholdID"));
        f.setFeeType(rs.getString("FeeType"));
        f.setAmount(rs.getDouble("Amount"));
        f.setDueDate(rs.getDate("DueDate").toLocalDate());
        f.setStatus(rs.getString("Status"));
        return f;
    }

    public List<Fee> findAll() {
        return jdbcTemplate.query("SELECT * FROM Fees", this::mapRow);
    }

    public Fee findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Fees WHERE FeeID=?",
                this::mapRow, id);
    }

    public void save(Fee f) {
        String sql = "INSERT INTO Fees (HouseholdID, FeeType, Amount, DueDate, Status)VALUES( ?,  ?,  ?,  ?,  ?)        ";
        jdbcTemplate.update(sql, f.getHouseholdID(), f.getFeeType(), f.getAmount(),
                f.getDueDate(), f.getStatus());
    }

    public void update(Fee f) {
        String sql = "UPDATE Fees SET HouseholdID=?, FeeType=?, Amount=?, DueDate=?,Status =  ? WHERE  FeeID =  ?        ";
        jdbcTemplate.update(sql, f.getHouseholdID(), f.getFeeType(), f.getAmount(),
                f.getDueDate(), f.getStatus(), f.getFeeID());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Fees WHERE FeeID=?", id);
    }

}
