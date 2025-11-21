package com.warehouse.repository;

import com.warehouse.entity.Pemasok;
import com.warehouse.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PemasokRepositoryImpl implements PemasokRepository {

    /*//buat unit test doang
    public PemasokRepositoryImpl(Connection connection) {
    }*/

    @Override
    public void addPemasok(Pemasok pemasok) {
        String sql = "INSERT INTO pemasok (id, nama, email, nama_kontak) values (?,?,?,?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, pemasok.getIdPemasok());
            statement.setString(2, pemasok.getNama());
            statement.setString(3, pemasok.getEmail());
            statement.setString(4, pemasok.getNamaKontak());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Pemasok pemasok) {
        String sql = "UPDATE pemasok SET nama = ?, email = ?, nama_kontak = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, pemasok.getNama());
            statement.setString(2, pemasok.getEmail());
            statement.setString(3, pemasok.getNamaKontak());
            statement.setString(4, pemasok.getIdPemasok());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isExist(String id) {
        String sql = "SELECT id FROM pemasok WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String id) {
        if (isExist(id)) {
            String sql = "DELETE FROM pemasok WHERE id = ?";
            try (Connection connection = DatabaseUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, id);
                statement.executeUpdate();

                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return false;
        }
    }

    @Override
    public Pemasok findById(String idPemasok) {
        String sql = "SELECT * FROM pemasok WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, idPemasok);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new Pemasok(
                            rs.getString("id"),
                            rs.getString("nama"),
                            rs.getString("email"),
                            rs.getString("nama_kontak")
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
    public List<Pemasok> findAll() {
        String sql = "SELECT * FROM pemasok";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            List<Pemasok> list = new ArrayList<>();
            while (rs.next()){
                list.add(new Pemasok(
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("nama_kontak")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
