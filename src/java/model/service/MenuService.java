package model.service;

import database.DBconfig;
import java.sql.SQLException;
import java.util.List;
import model.IMenuItemDAO;
import model.MenuItem;
import model.MenuItemDAO;

/**
 *
 * @author Bob
 */
public class MenuService implements IMenuService {
    private IMenuItemDAO dao;
    private List<MenuItem> menuItems;
    
    public MenuService(){ }
    
    public MenuService(DBconfig dbConfig){
        dao = new MenuItemDAO(dbConfig);
    }

    public List<MenuItem> getMenu() throws SQLException{
        menuItems = dao.getMenu();
        return menuItems;
    }
    
    public MenuItem findItemById(String id) throws IllegalArgumentException, ClassNotFoundException, 
            SQLException, Exception{
        return dao.findById(id);
    }
    
    public void deleteItem(String id) throws SQLException, Exception{
        dao.delete(id);
    }
    
    public void insertNewItem(MenuItem item) throws IllegalArgumentException, SQLException,
            ClassNotFoundException, Exception{
        dao.insert(item);
    }
    
    public void updateItem(MenuItem item) throws IllegalArgumentException, ClassNotFoundException, 
            SQLException, Exception{
        dao.update(item);
    }
    
}
