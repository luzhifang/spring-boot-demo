<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${basePackage}.${daoPackage}.${doNameUpperCamel}Dao">

    <sql id="${doNameUpperCamel ? uncap_first}Columns">
        <#list columns as model>
            a.${model.columnName} ${model.doField ? uncap_first}<#if model_has_next>,</#if>
        </#list>
    </sql>

    <sql id="${doNameUpperCamel ? uncap_first}Joins">

    </sql>

    <select id="getById" resultType="${basePackage}.${doPackage}.${doNameUpperCamel}">
        SELECT
        <include refid="${doNameUpperCamel ? uncap_first}Columns"/>
        FROM ${tableName} a
        <include refid="${doNameUpperCamel ? uncap_first}Joins"/>
        WHERE a.id = ${"#"}{id}
    </select>

    <select id="get" resultType="${basePackage}.${doPackage}.${doNameUpperCamel}" parameterType="${basePackage}.${doPackage}.${doNameUpperCamel}">
        SELECT
        <include refid="${doNameUpperCamel ? uncap_first}Columns"/>
        FROM ${tableName} a
        <include refid="${doNameUpperCamel ? uncap_first}Joins"/>
        <where>

        </where>
    </select>

    <select id="findPage" resultType="${basePackage}.${doPackage}.${doNameUpperCamel}">
        SELECT
        <include refid="${doNameUpperCamel ? uncap_first}Columns"/>
        FROM ${tableName} a
        <include refid="${doNameUpperCamel ? uncap_first}Joins"/>
        <where>

        </where>
    </select>

    <insert id="insert" useGeneratedKeys="true" keyProperty="id">
        INSERT INTO ${tableName} (
            <#list columns as model>
                ${model.columnName}<#if model_has_next>,</#if>
            </#list>
        ) VALUES (
            <#list columns as model>
                ${"#"}{${model.doField ? uncap_first}}<#if model_has_next>,</#if>
            </#list>
        )
    </insert>

    <update id="update">
        UPDATE ${tableName} SET
            <#list columns as model>
            <#if (model.columnType = 'varchar' || model.columnType = 'text')>
            <if test="${model.doField ? uncap_first} != null and ${model.doField ? uncap_first} != ''">
            <#else>
            <if test="${model.doField ? uncap_first} != null">
            </#if>
                ${model.columnName} = ${"#"}{${model.doField ? uncap_first}}<#if model_has_next>,</#if>
            </if>
            </#list>
        WHERE id = ${"#"}{id}
    </update>

    <delete id="delete">
        DELETE FROM ${tableName}
        WHERE id = ${"#"}{id}
    </delete>
</mapper>