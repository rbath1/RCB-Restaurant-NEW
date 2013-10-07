package model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Bob
 */
public interface IMenuItemDAO {
    public abstract List<MenuItem> getMenu() throws RuntimeException, SQLException;
    public abstract MenuItem findById(String id) throws IllegalArgumentException,
            ClassNotFoundException, SQLException, Exception;
    public abstract void delete(String id) throws SQLException, Exception;
    public abstract void insert(MenuItem item) throws IllegalArgumentException,
            SQLException, ClassNotFoundException, Exception;
    public abstract void update(MenuItem item) throws IllegalArgumentException,
            ClassNotFoundException, SQLException, Exception;
}
