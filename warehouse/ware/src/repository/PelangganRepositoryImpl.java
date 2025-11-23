package repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

import entity.Pelanggan;
import util.DatabaseUtil;

public class PelangganRepositoryImpl implements PelangganRepository{

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

    @Override
    public void add(Pelanggan pelanggan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update(Pelanggan pelanggan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
