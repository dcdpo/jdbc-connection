package com.example.testproject.preparedStatementSetter;

import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public interface RecordPpsSetter extends PreparedStatementSetter {

    void setExternalParams(HashMap<String, Object> map) throws SQLException;
}
