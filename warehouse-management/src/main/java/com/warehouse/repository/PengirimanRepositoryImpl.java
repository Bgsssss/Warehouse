package com.warehouse.repository;

import com.warehouse.entity.Pemasok;
import com.warehouse.entity.Pengiriman;
import com.warehouse.util.DatabaseUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.TIMESTAMP;

public class PengirimanRepositoryImpl implements PengirimanRepository {

    @Override
    public void add(Pengiriman pengiriman) {
        String sql = "INSERT INTO pengiriman (id_pesanan, id_gudang, tanggal_pengiriman, status) values (?,?,?,?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, pengiriman.getIdPesanan());
            statement.setString(2, pengiriman.getIdGudang());
            if (pengiriman.getTanggalPengiriman() != null) {
                statement.setTimestamp(3, Timestamp.valueOf(pengiriman.getTanggalPengiriman()));
            } else {
                statement.setNull(3, TIMESTAMP);
            }
            statement.setString(4, pengiriman.getStatus());
            statement.executeUpdate();

            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    int generateId = rs.getInt(1);
                    pengiriman.setId(generateId);
                    System.out.println("ID Pesanan: " + generateId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Pengiriman pengiriman) {
        String sql = "UPDATE pengiriman SET tanggal_pengiriman = ?, status = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setTimestamp(1, Timestamp.valueOf(pengiriman.getTanggalPengiriman()));
            statement.setString(2, pengiriman.getStatus());
            statement.setInt(3, pengiriman.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pengiriman findById(Integer id) {
        String sql = "SELECT * FROM pengiriman WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Timestamp ts = rs.getTimestamp("tanggal_pengiriman");
                    LocalDateTime tgl = (ts != null) ? ts.toLocalDateTime() : null;
                    return new Pengiriman(
                            rs.getInt("id"),
                            rs.getInt("id_pesanan"),
                            rs.getString("id_gudang"),
                            tgl,
                            rs.getString("status")
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
    public List<Pengiriman> findAll() {
        String sql = "SELECT * FROM pengiriman";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            List<Pengiriman> list = new ArrayList<>();
            while (rs.next()){
                Timestamp ts = rs.getTimestamp("tanggal_pengiriman");
                LocalDateTime tgl = (ts != null) ? ts.toLocalDateTime() : null;
                list.add(new Pengiriman(
                        rs.getInt("id"),
                        rs.getInt("id_pesanan"),
                        rs.getString("id_gudang"),
                        tgl,
                        rs.getString("status")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
