package com.warehouse.repository;

import com.warehouse.entity.Pesanan;
import com.warehouse.util.DatabaseUtil;

import java.sql.*;
import java.util.List;

public class PesananRepositoryImpl implements PesananRepository{

    @Override
    public void addPesanan(Pesanan pesanan) {
        String sql = "INSERT INTO pesanan (id_pelanggan, tanggal_pemesanan, jumlah_total) values (?,?,?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1,pesanan.getIdPelanggan());
            statement.setTimestamp(2, Timestamp.valueOf(pesanan.getTanggalPemesanan()));
            statement.setInt(3, pesanan.getJumlahTotal());
            statement.executeUpdate();

            try(ResultSet rs = statement.getGeneratedKeys()){
                if (rs.next()){
                    int generateId = rs.getInt(1);
                    pesanan.setId(generateId);
                    System.out.println("ID Pesanan: " + generateId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Pesanan pesanan) {

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Pesanan findById(Integer id) {
        return null;
    }

    @Override
    public List<Pesanan> findAll() {
        return List.of();
    }
}
