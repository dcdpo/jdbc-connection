package com.example.testproject.service;

import com.example.testproject.dao.UserDao;
import com.example.testproject.domain.PdwPfsStatBanCarrierRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Service
public class RecordService {

    @Autowired
    UserDao userDao;

    public int insertService(){
        PdwPfsStatBanCarrierRecord pdwPfsStatBanCarrierRecord = new PdwPfsStatBanCarrierRecord();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateTime = formatter.format(Date.from(Instant.now()));

        pdwPfsStatBanCarrierRecord.setInvoiceNumber("NN111100014");
        pdwPfsStatBanCarrierRecord.setInvoiceDate("20240218");
        pdwPfsStatBanCarrierRecord.setSellerId("11302");
        pdwPfsStatBanCarrierRecord.setProcessTime(dateTime);
        pdwPfsStatBanCarrierRecord.setInvYm("11302");
        pdwPfsStatBanCarrierRecord.setCarrierType("1K0001");
        pdwPfsStatBanCarrierRecord.setCarrierId2("/0123456789012345");
        pdwPfsStatBanCarrierRecord.setTotalAmount(BigDecimal.valueOf(100));
        pdwPfsStatBanCarrierRecord.setCreatedBy("SYS");
        pdwPfsStatBanCarrierRecord.setCreatedDate(dateTime);
        pdwPfsStatBanCarrierRecord.setCreatedIp("");
        pdwPfsStatBanCarrierRecord.setCreatedFunc("SYS");
        pdwPfsStatBanCarrierRecord.setLastModifiedBy("");
        pdwPfsStatBanCarrierRecord.setLastModifiedDate(dateTime);
        pdwPfsStatBanCarrierRecord.setLastModifiedIp("");
        pdwPfsStatBanCarrierRecord.setLastModifiedFunc("");

        return userDao.insertDataByJdbcTem(pdwPfsStatBanCarrierRecord);
    }
}
