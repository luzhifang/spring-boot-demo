package com.company.dao;


import com.company.domain.Column;
import com.company.domain.Table;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GeneratorMapper {
    List<String> getDatabases(@Param("databaseType") String databaseType);

    List<Table> getTables(@Param("databaseType") String databaseType, @Param("schemaName") String schemaName);

    List<Column> getColumns(@Param("databaseType") String databaseType, @Param("schemaName") String schemaName, @Param("tableName") String tableName);
}
