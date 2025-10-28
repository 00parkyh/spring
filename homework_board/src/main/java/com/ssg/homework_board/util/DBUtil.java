package com.ssg.homework_board.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public class DBUtil {
    private static HikariDataSource ds;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/sqldb?serverTimezone=Asia/Seoul&charEncoding=UTF-8");
        config.setUsername("root");
        config.setPassword("mysql1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }
    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    }
}
