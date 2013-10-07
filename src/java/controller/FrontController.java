package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rbath1
 */
public class FrontController extends HttpServlet {
    private static final String HOME = "/index.jsp";
    private static final String MENU_CONTROLLER = "/MenuController";
    private static final String UPDATE_CONTROLLER = "/UpdateController";
    private static final String INPUT_KEY = "action";
    private static final String INPUT_TYPE1 = "menu";
    private static final String INPUT_TYPE2 = "update";
    private static final String THEME_UPDATE_PAGE = "/update_theme.jsp";
    private static final String THEME_UPDATE = "change";
    private static final String THEME_CHANGE = "update_theme";
    private static final String THEME_END = "end";
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String destination = HOME;
        String key = request.getParameter(INPUT_KEY);
        String action = request.getParameter("action");
        
    	if( key.equals(INPUT_TYPE1)) {
    		destination = MENU_CONTROLLER;
                
    	} else if(key.equals(INPUT_TYPE2)) {
    		destination = UPDATE_CONTROLLER;
                
                //THEME_UPDATE = "change"
        } else if(action.equals(THEME_UPDATE)) {
            destination = THEME_UPDATE_PAGE;
            
            //THEME_END = "end"
        } else if(action.equals(THEME_END)){
            session.invalidate();
            destination = HOME;
            
            //THEME_CHANGE = "update_theme"
        } else if(action.equals(THEME_CHANGE)){
            String color = request.getParameter("color");
            session.setAttribute("color", color);
            destination = HOME;  
            
        }else{
            destination = HOME;
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
        processRequest(request, response);
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
        processRequest(request, response);
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
