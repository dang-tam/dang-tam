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
import uef.edu.vn.model.Apartment;

/**
 *
 * @author LAB12-TEACHER
 */
@Repository
public class ApartmentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    // Mapping ResultSet to Apartment object

    private Apartment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Apartment apartment = new Apartment();
        apartment.setApartmentID(rs.getInt("apartment_id"));
        apartment.setApartmentNumber(rs.getString("apartment_number"));
        apartment.setFloor(rs.getInt("floor"));
        apartment.setArea(rs.getDouble("area"));
        apartment.setStatus(rs.getString("status"));
        return apartment;
    }
    
    // SELECT * FROM apartment

    public List<Apartment> findAll() {
        String sql = "SELECT * FROM Apartments";
        return jdbcTemplate.query(sql, this::mapRow);
    }
    // SELECT * FROM apartment WHERE ApartmentID = ?

    public Apartment findById(int id) {
        String sql = "SELECT * FROM Apartments WHERE apartment_id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRow, id);
    }
    // INSERT INTO apartment (...)

    public void save(Apartment apartment) {
        String sql = "INSERT INTO Apartments (apartment_number, floor, area, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                apartment.getApartmentNumber(),
                apartment.getFloor(),
                apartment.getArea(),
                apartment.getStatus());
    }
    // UPDATE apartment SET ... WHERE ApartmentID = ?

    public void update(Apartment apartment) {
        String sql = "UPDATE Apartments SET apartment_number = ?, floor = ?, area = ?,status =  ? WHERE  apartment_id =  ?";
        jdbcTemplate.update(sql,
                apartment.getApartmentNumber(),
                apartment.getFloor(),
                apartment.getArea(),
                apartment.getStatus(),
                apartment.getApartmentID());
    }
    // DELETE FROM apartment WHERE ApartmentID = ?

    public void delete(int id) {
        String sql = "DELETE FROM Apartments WHERE apartment_id = ?";
        jdbcTemplate.update(sql, id);
    }

}
