package com.warehouse.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.warehouse.entity.Produk;
import com.warehouse.util.DatabaseUtil;

public class ProdukRespositoryImpl implements ProdukRepository {

    @Override
    public void addProduct(Produk produk) {

    }

    @Override
    public void update(Produk produk) {

    }

    @Override
    public void delete(String productId) {

    }

    @Override
    public Integer getHargaById(String idProduk) {
        String sql = "SELECT harga FROM produk WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idProduk);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("harga");
                } else {
                    throw new IllegalArgumentException("Produk dengan ID " + idProduk + " tidak ditemukan");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Produk findById(String idProduk) {
        String sql = "SELECT * FROM produk WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, idProduk);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new Produk(
                            rs.getString("id"),
                            rs.getString("nama"),
                            rs.getString("deskripsi"),
                            rs.getInt("harga"),
                            rs.getString("kategori"),
                            rs.getString("id_pemasok")
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
    public List<Produk> findAll() {
        return List.of();
    }
}
