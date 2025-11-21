package com.warehouse.view;

import com.warehouse.repository.PemasokRepository;
import com.warehouse.repository.PemasokRepositoryImpl;
import com.warehouse.service.PemasokService;
import com.warehouse.service.PemasokServiceImpl;
import com.warehouse.util.DatabaseUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class PemasokViewTest {

    //private Connection connection;

    private PemasokRepository pemasokRepository;

    private PemasokService pemasokService;

    @BeforeEach
    void setUp(){
        pemasokRepository = new PemasokRepositoryImpl();
        pemasokService = new PemasokServiceImpl(pemasokRepository);
    }

    @Test
    void add() {
        new PemasokView(pemasokService).menampilkanPemasok();
    }

    @AfterEach
    void tearDown(){
        System.out.println("Done");
    }
}
