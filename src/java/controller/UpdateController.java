package controller;

import database.DBconfig;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MenuItem;
import model.service.IMenuService;
import model.service.MenuService;

/**
 *
 * @author rbath1
 */
public class UpdateController extends HttpServlet {
    private static final String UPDATE_LIST_PAGE = "/update.jsp";
    private static final String UPDATE_ITEM_PAGE = "/update_item.jsp";
    
    private static final String UPDATE_ACTION = "updateItem";
    private static final String STORE_ACTION = "store";
    private static final String SAVE_BTN = "Save";
    private static final String ACTION_KEY = "action";
    
   
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, IllegalArgumentException, ClassNotFoundException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        //sets database's connection values
//        DBconfig dbConfig = new DBconfig(getServletConfig().getInitParameter("UrlString"),
//                getServletConfig().getInitParameter("driverClass"), getServletConfig().getInitParameter("user"),
//                getServletConfig().getInitParameter("password"));
        DBconfig dbConfig = (DBconfig)getServletContext().getAttribute("dbConfig");
        
        IMenuService service = new MenuService(dbConfig);
        
        String destination = UPDATE_LIST_PAGE;

        List<MenuItem> menuItems = service.getMenu();
        request.setAttribute("menuList", menuItems);
        
        //ACTION_KEY = "action"
        String action = request.getParameter(ACTION_KEY);
        
        //UPDATE_ACTION = "updateItem"
        if (UPDATE_ACTION.equals(action)){
             String addEdit = request.getParameter("addEdit");
                if(addEdit != null) {
                    //clicked the Add/Edit button
                    String[] id = request.getParameterValues("itemId");
                    if(id == null) {
                        //new record
                        MenuItem item = new MenuItem();
                        request.setAttribute("menuItem", item);      
                    } 
                    else {
                        //selects chosen record
                       MenuItem item = service.findItemById(request.getParameter("itemId"));
                        request.setAttribute("menuItem", item);
                     }
                    destination = UPDATE_ITEM_PAGE;
                    } 
                else {
                    //delete button
                    String id = request.getParameter("itemId");
                    service.deleteItem(id);
                    menuItems = service.getMenu();
                    request.setAttribute("menuList", menuItems);
                    destination = UPDATE_LIST_PAGE;  
                }
       
         }
         //STORE_ACTION = "store"
         else if(STORE_ACTION.equals(action)){
            //SAVE_BTN = "Save"
                    String save = request.getParameter(SAVE_BTN);
                    if(save != null){
                        //clicked save
                        String id = request.getParameter("itemId");
                        
                        if (id.equals("0")){
                            String itemName = request.getParameter("itemName");
                            Double itemPrice = Double.valueOf(request.getParameter("itemPrice"));
                            MenuItem item = new MenuItem(itemName,itemPrice);
                            service.insertNewItem(item);
                          } 
                        else if (!id.equals("0")){
                            String itemName = request.getParameter("itemName");
                            Double itemPrice = Double.valueOf(request.getParameter("itemPrice"));
                            int itemId = Integer.valueOf(request.getParameter("itemId"));
                            
                            MenuItem item = new MenuItem(itemId,itemName,itemPrice);
                            service.updateItem(item); 
                        }
                        menuItems = service.getMenu();
                        request.setAttribute("menuList", menuItems);
                        destination = UPDATE_LIST_PAGE;
                        
                    }else {
                        //clicked cancel
                        menuItems = service.getMenu();
                        request.setAttribute("menuList", menuItems);
                        destination = UPDATE_LIST_PAGE;
                    }
                }
 
                RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
