package com.example.testproject;

import com.example.testproject.domain.PdwPfsStatBanCarrierRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Component
public class UserDao {

    @Autowired(required = false)
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired(required = false)
    JdbcTemplate jdbcTemplate;

    public void insertNewData() {
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
                "LAST_MODIFIED_FUNC) values (:InvoiceNumber, :InvoiceDate, :InvNum, :SellerId, :CarrierType, :CarrierId2, :Total_Amount, TO_DATE(:ProcessTime, 'yyyyMMddHH24MIss'), :CreatdeBy, TO_DATE(:CreatedDate, 'yyyyMMddHH24MIss'), :CreatedIP, :CreatedFunc, :LastModifiedBy, TO_DATE(:LastModifiedDate, 'yyyyMMddHH24MIss'), :LasModifiedIP, :LastModifiedFunc)";

        HashMap<String, Object> map = new HashMap<>();

        map.put("InvoiceNumber", "NN111100014");
        map.put("InvoiceDate", "20240218");
        map.put("InvNum", "11302");
        map.put("SellerId", "12345678");
        map.put("CarrierType", "1K0001");
        map.put("CarrierId2", "/0123456789012345");
        map.put("Total_Amount", BigDecimal.valueOf(100));
        map.put("ProcessTime", "20240226143000");
        map.put("CreatdeBy", "SYS");
        map.put("CreatedDate", "20240226143000");
        map.put("CreatedIP", "");
        map.put("CreatedFunc", "SYS");
        map.put("LastModifiedBy", "");
        map.put("LastModifiedDate", "20240226143000");
        map.put("LasModifiedIP", "");
        map.put("LastModifiedFunc", "");

        namedParameterJdbcTemplate.update(sql, map);
    }

    public int insertDataByJdbcTem(PdwPfsStatBanCarrierRecord pdwRecord) {
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

        return jdbcTemplate.update(sql, pdwRecord.getInvoiceNumber(), pdwRecord.getInvoiceDate(), pdwRecord.getInvYm(),
                pdwRecord.getSellerId(), pdwRecord.getCarrierType(), pdwRecord.getCarrierId2(), pdwRecord.getTotalAmount(),
                formatter.format(Date.from(pdwRecord.getProcessTime())), pdwRecord.getCreatedBy(), formatter.format(Date.from(pdwRecord.getCreatedDate())), pdwRecord.getCreatedIp(),
                pdwRecord.getCreatedFunc(), pdwRecord.getLastModifiedBy(), formatter.format(Date.from(pdwRecord.getLastModifiedDate())),
                pdwRecord.getLastModifiedIp(), pdwRecord.getLastModifiedFunc());
    }
}
