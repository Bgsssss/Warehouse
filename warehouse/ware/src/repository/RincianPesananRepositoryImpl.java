package repository;

import entity.RincianPesanan;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RincianPesananRepositoryImpl implements RincianPesananRepository {

    @Override
    public void addRincianPesanan(RincianPesanan rincianPesanan) {
        String sql = "INSERT INTO rincian_pesanan (id_pesanan, id_produk, jumlah, harga) values (?,?,?,?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, rincianPesanan.getIdPesanan());
            statement.setString(2, rincianPesanan.getIdProduk());
            statement.setInt(3, rincianPesanan.getJumlah());
            statement.setInt(4, rincianPesanan.getHarga());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<RincianPesanan> findByPesananId(Integer idPesanan) {
        String sql = "SELECT * FROM rincian_pesanan WHERE id_pesanan = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idPesanan);
            List<RincianPesanan> list = new ArrayList<>();
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    list.add(new RincianPesanan(
                            rs.getInt("id_pesanan"),
                            rs.getString("id_produk"),
                            rs.getInt("jumlah"),
                            rs.getInt("harga")
                    ));
                    return list;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
