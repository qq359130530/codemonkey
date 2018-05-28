<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${config.basePackage}.mapper.ColumnMapper">

	<!-- 查询指定表的列信息 -->
	<select id="listColumnByTable" resultType="column" databaseId="mysql">
		SELECT
			TABLE_SCHEMA, TABLE_NAME, COLUMN_NAME, IS_NULLABLE, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, 
			NUMERIC_PRECISION, NUMERIC_SCALE, COLUMN_COMMENT, COLUMN_KEY
		FROM
			COLUMNS
		WHERE
			TABLE_SCHEMA = ${entity.source.tableSchema} AND TABLE_NAME = ${entity.source.tableName}
		ORDER BY
			ORDINAL_POSITION
	</select>
	
</mapper>