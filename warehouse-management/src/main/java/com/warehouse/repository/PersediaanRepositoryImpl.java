package com.warehouse.repository;

import com.warehouse.entity.Persediaan;
import com.warehouse.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersediaanRepositoryImpl implements PersediaanRepository{

    @Override
    public void updateStokById(String idProduk,int jumlahDipesan, String idGudang) {
        String sql = "UPDATE persediaan SET jumlah = jumlah - ? WHERE id_produk = ? AND id_gudang = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, jumlahDipesan);
                statement.setString(2, idProduk);
                statement.setString(3, idGudang);
                statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Persediaan findByProdukAndGudang(String idProduk, String idGudang) {
        String sql = "SELECT * FROM persediaan WHERE id_produk = ? AND id_gudang = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idProduk);
            ps.setString(2, idGudang);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Persediaan p = new Persediaan();
                    p.setId(rs.getInt("id"));
                    p.setIdProduk(rs.getString("id_produk"));
                    p.setIdGudang(rs.getString("id_gudang"));
                    p.setJumlah(rs.getInt("jumlah"));
                    return p;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Persediaan> findByProduk(String idProduk) {
        String sql = "SELECT * FROM persediaan WHERE id_produk = ? ORDER BY id_gudang ASC";
        List<Persediaan> list = new ArrayList<>();

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idProduk);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Persediaan(
                            rs.getInt("id"),
                            rs.getString("id_produk"),
                            rs.getString("id_gudang"),
                            rs.getInt("jumlah")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
