/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uef.edu.vn.model.Household;

/**
 *
 * @author LAB12-PC15
 */
@Repository
public class HouseholdRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Household> householdMapper = (rs, rowNum) -> {
        Household h = new Household();

        h.setHouseholdID(rs.getInt("household_id"));
        h.setApartmentID(rs.getInt("apartment_id"));
        h.setHeadOfHousehold(rs.getString("head_of_household"));
        h.setContactNumber(rs.getString("contact_number"));
        h.setEmail(rs.getString("email"));

        return h;
    };

    public List<Household> findAll() {
        String sql = "SELECT * FROM Household";
        return jdbcTemplate.query(sql, householdMapper);
    }

    public Household findById(int id) {
        String sql = "SELECT * FROM Household WHERE household_id = ?";

        List<Household> result =
                jdbcTemplate.query(sql, householdMapper, id);

        return result.isEmpty() ? null : result.get(0);
    }

    public boolean save(Household household) {

        String sql = "INSERT INTO Household(apartment_id, head_of_household, contact_number, email) VALUES (?, ?, ?, ?)";

        int rows = jdbcTemplate.update(
                sql,
                household.getApartmentID(),
                household.getHeadOfHousehold(),
                household.getContactNumber(),
                household.getEmail()
        );

        return rows > 0;
    }

    public boolean update(Household household) {

        String sql = " UPDATE Household SET apartment_id = ?, head_of_household = ?, contact_number = ?, email = ? WHERE household_id = ?";

        int rows = jdbcTemplate.update(
                sql,
                household.getApartmentID(),
                household.getHeadOfHousehold(),
                household.getContactNumber(),
                household.getEmail(),
                household.getHouseholdID()
        );

        return rows > 0;
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM Household WHERE household_id = ?";

        int rows = jdbcTemplate.update(sql, id);

        return rows > 0;
    }
}
