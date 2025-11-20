package com.warehouse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.warehouse.util.DatabaseUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() throws SQLException {
        Connection conn = DatabaseUtil.getConnection();
        Assertions.assertNotNull(conn, "Koneksi tidak boleh null");
    }
}
