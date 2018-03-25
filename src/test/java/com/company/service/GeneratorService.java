package com.company.service;

import com.company.domain.Table;
import com.company.dao.GeneratorMapper;
import com.company.domain.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneratorService {
    @Autowired
    private GeneratorMapper generatorMapper;

    public List<String> getDatabases(String databaseType){
        return generatorMapper.getDatabases(databaseType);
    }

    public List<Table> getTables(String databaseType, String schemaName) {
        return generatorMapper.getTables(databaseType, schemaName);
    }

    public List<Column> getColumns(String databaseType, String schemaName, String tableName) {
        return generatorMapper.getColumns(databaseType, schemaName, tableName);
    }
}
