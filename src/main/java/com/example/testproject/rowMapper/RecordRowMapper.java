package com.example.testproject.rowMapper;

import com.example.testproject.domain.PdwPfsStatBanCarrierRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordRowMapper implements RowMapper<PdwPfsStatBanCarrierRecord> {
    @Override
    public PdwPfsStatBanCarrierRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        PdwPfsStatBanCarrierRecord pdwPfsStatBanCarrierRecord = new PdwPfsStatBanCarrierRecord();

        pdwPfsStatBanCarrierRecord.setInvoiceNumber(rs.getString("INVOICE_NUMBER"));
        pdwPfsStatBanCarrierRecord.setInvoiceDate(rs.getString("INVOICE_DATE"));
        pdwPfsStatBanCarrierRecord.setInvYm(rs.getString("INV_YM"));
        pdwPfsStatBanCarrierRecord.setSellerId(rs.getString("SELLER_ID"));
        pdwPfsStatBanCarrierRecord.setCarrierType(rs.getString("CARRIER_TYPE"));
        pdwPfsStatBanCarrierRecord.setCarrierId2(rs.getString("CARRIER_ID2"));
        pdwPfsStatBanCarrierRecord.setTotalAmount(rs.getBigDecimal("TOTAL_AMOUNT"));
        pdwPfsStatBanCarrierRecord.setProcessTime(rs.getString("PROCESS_TIME"));
        pdwPfsStatBanCarrierRecord.setCreatedBy(rs.getString("CREATED_BY"));
        pdwPfsStatBanCarrierRecord.setCreatedDate(rs.getString("CREATED_DATE"));
        pdwPfsStatBanCarrierRecord.setCreatedIp(rs.getString("CREATED_IP"));
        pdwPfsStatBanCarrierRecord.setCreatedFunc(rs.getString("CREATED_FUNC"));
        pdwPfsStatBanCarrierRecord.setLastModifiedBy(rs.getString("LAST_MODIFIED_BY"));
        pdwPfsStatBanCarrierRecord.setLastModifiedDate(rs.getString("LAST_MODIFIED_DATE"));
        pdwPfsStatBanCarrierRecord.setLastModifiedIp(rs.getString("LAST_MODIFIED_IP"));
        pdwPfsStatBanCarrierRecord.setLastModifiedFunc(rs.getString("LAST_MODIFIED_FUNC"));

        return pdwPfsStatBanCarrierRecord;
    }
}
