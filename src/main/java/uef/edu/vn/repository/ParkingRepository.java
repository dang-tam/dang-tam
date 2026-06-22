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
import uef.edu.vn.model.Parking;

/**
 *
 * @author LAB12-PC15
 */
@Repository
public class ParkingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Parking mapRow(ResultSet rs, int rowNum) throws SQLException {
        Parking p = new Parking();
        p.setParkingID(rs.getInt("ParkingID"));
        p.setHouseholdID((Integer) rs.getObject("HouseholdID")); // Nullable
        p.setParkingNumber(rs.getString("ParkingNumber"));
        p.setVehicleType(rs.getString("VehicleType"));
        p.setStatus(rs.getString("Status"));
        return p;
    }

    public List<Parking> findAll() {
        return jdbcTemplate.query("SELECT * FROM Parking", this::mapRow);
    }

    public Parking findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Parking WHERE ParkingID=?", this::mapRow, id);
    }

    public void save(Parking p) {
        String sql = "INSERT INTO Parking (HouseholdID, ParkingNumber, VehicleType,Status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, p.getHouseholdID(), p.getParkingNumber(),
                p.getVehicleType(), p.getStatus());
    }

    public void update(Parking p) {
        String sql = "UPDATE Parking SET HouseholdID=?, ParkingNumber=?,VehicleType=?, Status=? WHERE ParkingID=?";
        jdbcTemplate.update(sql, p.getHouseholdID(), p.getParkingNumber(),
                p.getVehicleType(), p.getStatus(), p.getParkingID());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Parking WHERE ParkingID=?", id);
    }
}
