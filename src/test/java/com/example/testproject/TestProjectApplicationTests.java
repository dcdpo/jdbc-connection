package com.example.testproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestProjectApplicationTests {

    @Autowired
    RecordService recordService;
    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testInsertRecord() {
        userDao.insertNewData();
    }

    @Test
    void testInsertRecordByJdbcTemplate() {
        recordService.insertService();
    }
}
