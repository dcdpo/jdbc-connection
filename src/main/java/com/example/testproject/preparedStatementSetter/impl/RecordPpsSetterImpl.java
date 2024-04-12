package com.example.testproject.preparedStatementSetter.impl;

import com.example.testproject.preparedStatementSetter.RecordPpsSetter;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class RecordPpsSetterImpl implements RecordPpsSetter {
    private HashMap<String, Object> externalParams;

    @Override
    public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, String.valueOf(externalParams.get("InvoiceNumber")));
        ps.setString(2, String.valueOf(externalParams.get("InvoiceDate")));
        ps.setString(3, String.valueOf(externalParams.get("InvNum")));
        ps.setString(4, String.valueOf(externalParams.get("SellerId")));
        ps.setString(5, String.valueOf(externalParams.get("CarrierType")));
        ps.setString(6, String.valueOf(externalParams.get("CarrierId2")));
        ps.setBigDecimal(7, (BigDecimal) externalParams.get("Total_Amount"));
        ps.setString(8, String.valueOf(externalParams.get("ProcessTime")));
        ps.setString(9, String.valueOf(externalParams.get("CreatdeBy")));
        ps.setString(10, String.valueOf(externalParams.get("CreatedDate")));
        ps.setString(11, String.valueOf(externalParams.get("CreatedIP")));
        ps.setString(12, String.valueOf(externalParams.get("CreatedFunc")));
        ps.setString(13, String.valueOf(externalParams.get("LastModifiedBy")));
        ps.setString(14, String.valueOf(externalParams.get("LastModifiedDate")));
        ps.setString(15, String.valueOf(externalParams.get("LasModifiedIP")));
        ps.setString(16, String.valueOf(externalParams.get("LastModifiedFunc")));
    }

    @Override
    public void setExternalParams(HashMap<String, Object> externalParams) throws SQLException {
        this.externalParams = externalParams;
    }
}
