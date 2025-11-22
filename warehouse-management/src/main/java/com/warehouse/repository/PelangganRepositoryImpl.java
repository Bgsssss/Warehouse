package com.warehouse.repository;

import com.warehouse.entity.Pelanggan;
import com.warehouse.entity.Pengiriman;
import com.warehouse.util.DatabaseUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class PelangganRepositoryImpl implements PelangganRepository{

    @Override
    public void add(Pelanggan pelanggan) {

    }

    @Override
    public void update(Pelanggan pelanggan) {

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Pelanggan findById(Integer id) {
        String sql = "SELECT * FROM pelanggan WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new Pelanggan(
                            rs.getInt("id"),
                            rs.getString("nama"),
                            rs.getString("alamat"),
                            rs.getString("no_hp")
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pelanggan> findAll() {
        return List.of();
    }
}
