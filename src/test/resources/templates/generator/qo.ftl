package ${basePackage}.${qoPackage};

import com.company.project.common.page.AbstractPage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* ${tableComment} qo
* @author ${author}
* @date ${date}
*/
@ApiModel("${tableComment}")
public class ${doNameUpperCamel}QO extends AbstractPage {

    <#if columns?exists>
        <#list columns as model>
    <#if (model.columnType = 'varchar' || model.columnType = 'text'
        || model.columnType = 'varchar2' || model.columnType = 'nvarchar'
        || model.columnType = 'timestamp' || model.columnType = 'date' || model.columnType = 'datetime')>
    @ApiModelProperty(notes = "${model.columnComment!}")
    private String ${model.doField?uncap_first};

    </#if>
        </#list>
    </#if>

<#if columns?exists>
<#list columns as model>
<#if (model.columnType = 'varchar' || model.columnType = 'text'
    || model.columnType = 'varchar2' || model.columnType = 'nvarchar'
    || model.columnType = 'timestamp' || model.columnType = 'date' || model.columnType = 'datetime')>
    public String get${model.doField}() {
        return this.${model.doField?uncap_first};
    }

    public void set${model.doField}(String ${model.doField?uncap_first}) {
        this.${model.doField?uncap_first} = ${model.doField?uncap_first};
    }

</#if>
</#list>
</#if>

}