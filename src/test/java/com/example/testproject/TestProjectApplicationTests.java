package com.example.testproject;

import com.example.testproject.dao.UserDao;
import com.example.testproject.domain.PdwPfsStatBanCarrierRecord;
import com.example.testproject.service.RecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

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

    @Test
    void testFindAll() {
        List<PdwPfsStatBanCarrierRecord> recordList = userDao.findAll();

        for (PdwPfsStatBanCarrierRecord map : recordList) {
            System.out.println("INVOICE_NUMBER: " + map.getInvoiceNumber());
        }
    }
}
