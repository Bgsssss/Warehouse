package com.warehouse.Repository;

import com.warehouse.entity.Pemasok;
import com.warehouse.repository.PemasokRepository;
import com.warehouse.repository.PemasokRepositoryImpl;
import com.warehouse.util.DatabaseUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class PemasokTest {

    private Connection connection;

    private PemasokRepository pemasokRepository;

    /*@BeforeEach
    void setUp() throws SQLException {
       connection = DatabaseUtil.getConnection();
       pemasokRepository = new PemasokRepositoryImpl(connection);
    }*/

    @Test
    void addTest() {
        Pemasok pemasok = new Pemasok();
        pemasok.setIdPemasok("S0003");
        pemasok.setNama("Nvidia");
        pemasok.setEmail("ww@example.com");
        pemasok.setNamaKontak("Jensen Huang");

        pemasokRepository.addPemasok(pemasok);
    }

    @Test
    void updateTest() {
        Pemasok pemasok = new Pemasok();
        pemasok.setIdPemasok("S0003");
        pemasok.setNama("Microsoft");
        pemasok.setEmail("microsoft@example.com");
        pemasok.setNamaKontak("Bill");

        pemasokRepository.update(pemasok);
    }

    @Test
    void deleteTest() {
        System.out.println(pemasokRepository.delete("S0003"));
    }

    @Test
    void findByIdTest() {
        Pemasok pemasok = pemasokRepository.findById("S0001");

        Assertions.assertEquals("S0001", pemasok.getIdPemasok());
        Assertions.assertEquals("PT Sumber Makmur", pemasok.getNama());
        Assertions.assertEquals("budi@gmail.com", pemasok.getEmail());
        Assertions.assertEquals("Budi", pemasok.getNamaKontak());
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }
}
