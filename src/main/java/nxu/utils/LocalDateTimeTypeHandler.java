package nxu.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author 张宏业
 * @apiNote 数据库中的DateTime与Java中的LocalDateTime进行转换的工具类
 */
public class LocalDateTimeTypeHandler extends BaseTypeHandler<LocalDateTime> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("Tips:用到了时间转换器 " + parameter);
        ps.setTimestamp(i, java.sql.Timestamp.valueOf(parameter));
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        java.sql.Timestamp timestamp = rs.getTimestamp(columnName);
        if (timestamp != null) {
            return timestamp.toLocalDateTime();
        }
        return null;
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        java.sql.Timestamp timestamp = rs.getTimestamp(columnIndex);
        if (timestamp != null) {
            return timestamp.toLocalDateTime();
        }
        return null;
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        java.sql.Timestamp timestamp = cs.getTimestamp(columnIndex);
        if (timestamp != null) {
            return timestamp.toLocalDateTime();
        }
        return null;
    }
}