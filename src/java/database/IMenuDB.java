package database;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bob
 */
public interface IMenuDB {
    public abstract void openConnection() throws IllegalArgumentException, ClassNotFoundException, SQLException;
    public abstract void closeConnection() throws SQLException;
    public abstract List findRecords(String sqlString, boolean closeConnection) 
	throws SQLException, Exception;
    public abstract Map getRecordByID(String table, String primaryKeyField, Object keyValue, boolean closeConnection)
	throws SQLException, Exception;
    public abstract boolean insertRecord(String tableName, List colDescriptors, List colValues, boolean closeConnection)
	throws SQLException, Exception;
    public abstract int deleteRecords(String tableName, String whereField, Object whereValue, boolean closeConnection)
	throws SQLException, Exception;
    public abstract int updateRecords(String tableName, List colDescriptors, List colValues,
							 String whereField, Object whereValue, boolean closeConnection)
							 throws SQLException, Exception;
}

