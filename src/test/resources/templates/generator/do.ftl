package ${basePackage}.${doPackage};

<#if hasDate = true>
import java.util.Date;

</#if>
<#if hasBigDecimal = true>
import java.math.BigDecimal;

</#if>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* ${tableComment} DO
* @author ${author}
* @date ${date}
*/
@ApiModel("${tableComment}")
public class ${doNameUpperCamel} {

    <#if columns?exists>
        <#list columns as model>
    @ApiModelProperty(notes = "${model.columnComment!}")
    <#if (model.columnType = 'varchar' || model.columnType = 'text' || model.columnType = 'uniqueidentifier'
        || model.columnType = 'varchar2' || model.columnType = 'nvarchar' ||model.columnType = 'VARCHAR2' ||model.columnType = 'VARCHAR'|| model.columnType = 'CLOB')>
  private String ${model.doField?uncap_first};

    </#if>
    <#if model.columnType = 'timestamp' || model.columnType = 'date' || model.columnType = 'datetime'||model.columnType = 'TIMESTAMP' || model.columnType = 'DATE' || model.columnType = 'DATETIME'>
    
    private Date ${model.doField?uncap_first};

    </#if>
    <#if model.columnType = 'int' || model.columnType = 'smallint'>
    private Integer ${model.doField?uncap_first};

    </#if>
    <#if model.columnType = 'bigint'>
    private Long ${model.doField?uncap_first};

    </#if>
    <#if model.columnType = 'tinyint'>
    private Byte ${model.doField?uncap_first};

    </#if>
    <#if model.columnType = 'decimal' || model.columnType = 'numeric'>
    private BigDecimal ${model.doField?uncap_first};

    </#if>
        </#list>
    </#if>

<#if columns?exists>
<#list columns as model>
<#if (model.columnType = 'varchar' || model.columnType = 'text' || model.columnType = 'uniqueidentifier'
    || model.columnType = 'varchar2' || model.columnType = 'nvarchar'||model.columnType = 'VARCHAR2' ||model.columnType = 'VARCHAR'|| model.columnType = 'CLOB')>
 
    public String get${model.doField}() {
        return this.${model.doField?uncap_first};
    }

    public void set${model.doField}(String ${model.doField?uncap_first}) {
        this.${model.doField?uncap_first} = ${model.doField?uncap_first};
    }

</#if>
<#if model.columnType = 'timestamp' || model.columnType = 'date' || model.columnType = 'datetime'||model.columnType = 'TIMESTAMP' || model.columnType = 'DATE' || model.columnType = 'DATETIME'>
    
    
    public Date get${model.doField}() {
        return this.${model.doField?uncap_first};
    }

    public void set${model.doField}(Date ${model.doField?uncap_first}) {
        this.${model.doField?uncap_first} = ${model.doField?uncap_first};
    }

</#if>
<#if model.columnType = 'int' || model.columnType = 'smallint'>
    public Integer get${model.doField}() {
        return this.${model.doField?uncap_first};
    }

    public void set${model.doField}(Integer ${model.doField?uncap_first}) {
        this.${model.doField?uncap_first} = ${model.doField?uncap_first};
    }

</#if>
<#if model.columnType = 'bigint'>
    public Long get${model.doField}() {
        return this.${model.doField?uncap_first};
    }

    public void set${model.doField}(Long ${model.doField?uncap_first}) {
        this.${model.doField?uncap_first} = ${model.doField?uncap_first};
    }

</#if>
<#if model.columnType = 'tinyint'>
    public Byte get${model.doField}() {
        return this.${model.doField?uncap_first};
    }

    public void set${model.doField}(Byte ${model.doField?uncap_first}) {
        this.${model.doField?uncap_first} = ${model.doField?uncap_first};
    }

</#if>
<#if model.columnType = 'decimal' || model.columnType = 'numeric'>
    public BigDecimal get${model.doField}() {
        return this.${model.doField?uncap_first};
    }

    public void set${model.doField}(BigDecimal ${model.doField?uncap_first}) {
        this.${model.doField?uncap_first} = ${model.doField?uncap_first};
    }

</#if>
</#list>
</#if>

}