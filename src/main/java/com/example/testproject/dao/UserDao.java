package com.example.testproject.dao;

import com.example.testproject.domain.PdwPfsStatBanCarrierRecord;
import com.example.testproject.preparedStatementSetter.impl.RecordPpsSetterImpl;
import com.example.testproject.rowMapper.RecordRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Component
public class UserDao {

    @Autowired(required = false)
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired(required = false)
    JdbcTemplate jdbcTemplate;

    //使用namedParameterJdbcTemplate
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

    //使用jdbcTemplatem用param的寫法去處理參數
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
                "LAST_MODIFIED_FUNC) values (:InvoiceNumber, :InvoiceDate, :InvNum, :SellerId, :CarrierType, :CarrierId2, :Total_Amount, TO_DATE(:ProcessTime, 'yyyyMMddHH24MIss'), :CreatdeBy, TO_DATE(:CreatedDate, 'yyyyMMddHH24MIss'), :CreatedIP, :CreatedFunc, :LastModifiedBy, TO_DATE(:LastModifiedDate, 'yyyyMMddHH24MIss'), :LasModifiedIP, :LastModifiedFunc)";

        try {
            HashMap<String, Object> map = new HashMap<>();

            map.put("InvoiceNumber", pdwRecord.getInvoiceNumber());
            map.put("InvoiceDate", pdwRecord.getInvoiceDate());
            map.put("InvNum", pdwRecord.getInvYm());
            map.put("SellerId", pdwRecord.getSellerId());
            map.put("CarrierType", pdwRecord.getCarrierType());
            map.put("CarrierId2", pdwRecord.getCarrierId2());
            map.put("Total_Amount", pdwRecord.getTotalAmount());
            map.put("ProcessTime", pdwRecord.getProcessTime());
            map.put("CreatdeBy", pdwRecord.getCreatedBy());
            map.put("CreatedDate", pdwRecord.getCreatedDate());
            map.put("CreatedIP", pdwRecord.getCreatedIp());
            map.put("CreatedFunc", pdwRecord.getCreatedFunc());
            map.put("LastModifiedBy", pdwRecord.getLastModifiedBy());
            map.put("LastModifiedDate", pdwRecord.getLastModifiedDate());
            map.put("LasModifiedIP", pdwRecord.getLastModifiedIp());
            map.put("LastModifiedFunc", pdwRecord.getLastModifiedFunc());

            RecordPpsSetterImpl pss = new RecordPpsSetterImpl();

            pss.setExternalParams(map);

            int successCount = jdbcTemplate.update(sql, pss);

            return successCount;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }


    public List<PdwPfsStatBanCarrierRecord> findAll() {
        String sql = "SELECT * FROM PFS_STAT_BAN_CARRIER_RECORD";

        List<PdwPfsStatBanCarrierRecord> recordList = jdbcTemplate.query(sql, new RecordRowMapper());

        return recordList;
    }


}
