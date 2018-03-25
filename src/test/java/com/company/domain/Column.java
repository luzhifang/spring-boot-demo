package com.company.domain;

public class Column {
    // 字段名称
    private String columnName;
    // 字段类型
    private String columnType;
    // 字段注释
    private String columnComment;
    // 对应的do下的字段属性
    private String doField;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getDoField() {
        return doField;
    }

    public void setDoField(String doField) {
        this.doField = doField;
    }
}
