package com.example.testproject;

import com.example.testproject.domain.PdwPfsStatBanCarrierRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Service
public class RecordService {

    @Autowired
    UserDao userDao;

    public int insertService(){
        PdwPfsStatBanCarrierRecord pdwPfsStatBanCarrierRecord = new PdwPfsStatBanCarrierRecord();

        pdwPfsStatBanCarrierRecord.setInvoiceNumber("NN111100014");
        pdwPfsStatBanCarrierRecord.setInvoiceDate("20240218");
        pdwPfsStatBanCarrierRecord.setSellerId("11302");
        pdwPfsStatBanCarrierRecord.setProcessTime(Instant.now());
        pdwPfsStatBanCarrierRecord.setInvYm("11302");
        pdwPfsStatBanCarrierRecord.setCarrierType("1K0001");
        pdwPfsStatBanCarrierRecord.setCarrierId2("/0123456789012345");
        pdwPfsStatBanCarrierRecord.setTotalAmount(BigDecimal.valueOf(100));
        pdwPfsStatBanCarrierRecord.setCreatedBy("SYS");
        pdwPfsStatBanCarrierRecord.setCreatedDate(Instant.now());
        pdwPfsStatBanCarrierRecord.setCreatedIp("");
        pdwPfsStatBanCarrierRecord.setCreatedFunc("SYS");
        pdwPfsStatBanCarrierRecord.setLastModifiedBy("");
        pdwPfsStatBanCarrierRecord.setLastModifiedDate(Instant.now());
        pdwPfsStatBanCarrierRecord.setLastModifiedIp("");
        pdwPfsStatBanCarrierRecord.setLastModifiedFunc("");

        return userDao.insertDataByJdbcTem(pdwPfsStatBanCarrierRecord);
    }
}
