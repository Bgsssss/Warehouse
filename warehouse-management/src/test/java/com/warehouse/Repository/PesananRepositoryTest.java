package com.warehouse.Repository;

import com.warehouse.entity.Pesanan;
import com.warehouse.repository.PesananRepository;
import com.warehouse.repository.PesananRepositoryImpl;
import com.warehouse.util.DatabaseUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PesananRepositoryTest {

    private Connection connection;

    private PesananRepository pesananRepository;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DatabaseUtil.getConnection();
        pesananRepository = new PesananRepositoryImpl();
    }

    @Test
    void add() {
        Pesanan pesanan = new Pesanan();
        pesanan.setIdPelanggan(1);
        pesanan.setTanggalPemesanan(LocalDateTime.now());
        pesanan.setJumlahTotal(50000);

        pesananRepository.addPesanan(pesanan);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }
}