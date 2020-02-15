package utils;

import java.sql.ResultSet;

@FunctionalInterface
public interface RowMap<T> {
    T RowMapping(ResultSet rs);
}
