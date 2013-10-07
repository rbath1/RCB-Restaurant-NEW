package model.service;

import java.sql.SQLException;
import java.util.List;
import model.MenuItem;

/**
 *
 * @author Bob
 */
public interface IMenuService {
    public abstract List<MenuItem> getMenu() throws SQLException;
    public abstract MenuItem findItemById(String id) throws IllegalArgumentException, ClassNotFoundException, 
            SQLException, Exception;
    public abstract void deleteItem(String id) throws SQLException, Exception;
    public abstract void insertNewItem(MenuItem item) throws IllegalArgumentException, SQLException,
            ClassNotFoundException, Exception;
    public abstract void updateItem(MenuItem item) throws IllegalArgumentException, ClassNotFoundException, 
            SQLException, Exception; 
}
