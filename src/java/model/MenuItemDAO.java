package model;

import database.DBconfig;
import database.IMenuDB;
import database.MenuDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bob
 */
public class MenuItemDAO implements IMenuItemDAO {
    private IMenuDB database;
    
    public MenuItemDAO(DBconfig dbConfig){
        database = new MenuDB(dbConfig);  
    }
    
    public List<MenuItem> getMenu() throws RuntimeException, SQLException {
        List<MenuItem> items = new ArrayList<MenuItem>();
        try {
            database.openConnection();
            
            String query = "SELECT * FROM item";
                     
            List<Map> rawData = database.findRecords(query, true);
            for(Map record : rawData) {
                MenuItem item = new MenuItem();
                int id = Integer.valueOf(record.get("item_id").toString());
                item.setItemId(id);
                String name = String.valueOf(record.get("item_name"));
                item.setItemName(name);
                Double price = Double.valueOf(record.get("item_price").toString());
                item.setItemPrice(price);
                items.add(item); 
            }
            return items;
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch(Exception ex) {
             throw new RuntimeException(ex.getMessage(), ex);
        } 
    }
    public MenuItem findById(String id) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception {
        database.openConnection();
        Map rawData = database.getRecordByID("item", "item_id", id, true);
        MenuItem i = new MenuItem();
        i.setItemId(Integer.valueOf(rawData.get("item_id").toString()));
        i.setItemName(String.valueOf(rawData.get("item_name").toString()));
        i.setItemPrice(Double.valueOf(rawData.get("item_price").toString()));
        return i;
        
    }
    public void delete(String id) throws SQLException, Exception {
        database.openConnection();
        database.deleteRecords("item", "item_id", id, true);
        
    }
    public void insert(MenuItem item) throws IllegalArgumentException, SQLException, ClassNotFoundException, Exception {
       if(item == null) return;

       List cols = new ArrayList();
       cols.add("item_name");
       cols.add("item_price");
       List values = new ArrayList();
       values.add(item.getItemName());
       values.add(item.getItemPrice());
            database.openConnection();
            database.insertRecord("item", cols, values, true);
    }
    public void update(MenuItem item) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception{
        
        List cols = new ArrayList();
        cols.add("item_name");
        cols.add("item_price");
        List values = new ArrayList();
        values.add(item.getItemName().toString());
        values.add(Double.valueOf(item.getItemPrice()));
        int whereValue = item.getItemId();
        
        database.openConnection();
        database.updateRecords("item", cols, values, "item_id", whereValue, true);
        
    }
}
    

