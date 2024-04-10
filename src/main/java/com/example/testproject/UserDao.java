package com.example.testproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@Component
public class UserDao {

    @Value("${spring.datasource.driver.class-name}")
    private String driverName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public void insertNewData() {

        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        String sql = "INSERT INTO PFS_STAT_BAN_CARRIER_RECORD " +
                "(INVOICE_NUMBER, " +
                "INVOICE_DATE, " +
                "INV_YM, " +
                "SELLER_ID, " +
                "CARRIER_TYPE, " +
                "CARRIER_ID2, " +
                "TOTAL_AMOUNT, " +
                "PROCESS_TIME, " +
                "CREATED_BY, " +
                "CREATED_DATE, " +
                "CREATED_IP, " +
                "CREATED_FUNC, " +
                "LAST_MODIFIED_BY, " +
                "LAST_MODIFIED_DATE, " +
                "LAST_MODIFIED_IP, " +
                "LAST_MODIFIED_FUNC) values (?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'yyyyMMddHH24MIss'), ?, TO_DATE(?, 'yyyyMMddHH24MIss'), ?, ? , ?, TO_DATE(?, 'yyyyMMddHH24MIss'), ?, ?)";
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(sql);


            Date sysDt = Date.from(Instant.parse("2024-03-06T06:30:00Z"));

            // 計算開始時間
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sysDt);
            calendar.add(Calendar.HOUR_OF_DAY, -2);
            Date twoHoursAgo = calendar.getTime();

            calendar.setTime(twoHoursAgo);
            calendar.set(Calendar.MINUTE, 30);

            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date startTime = calendar.getTime();

            stat.setString(1, "NN111100014");
            stat.setString(2, "20240218");
            stat.setString(3, "11302");
            stat.setString(4, "12345678");
            stat.setString(5, "1K0001");
            stat.setString(6, "/0123456789012345");
            stat.setBigDecimal(7, BigDecimal.valueOf(100));
            stat.setString(8, "20240226143000");
            stat.setString(9, "SYS");
            stat.setString(10, "20240226143000");
            stat.setString(11, "");
            stat.setString(12, "SYS");
            stat.setString(13, "");
            stat.setString(14, "20240226143000");
            stat.setString(15, "");
            stat.setString(16, "");

            stat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
