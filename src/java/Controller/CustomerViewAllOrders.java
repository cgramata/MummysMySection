/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.OrdersDAO;
import Model.Orders;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author syntel
 */
@Controller
@RequestMapping("/customerViewAllOrders")
public class CustomerViewAllOrders{
    
    private OrdersDAO ordersDAO;
    
    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }
    
    @RequestMapping(value = "/customerViewAllOrders", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, 
                                      HttpServletResponse response, 
                                      Model model) throws Exception {
        Orders order = new Orders();
        //Retrieves customerId from session state
        int customerID = Integer.parseInt(request.getSession().getAttribute("customerId").toString());
        //establishes an empty vessel that updated information goes into in seeAllOrders.jsp
        model.addAttribute("orderInfo", order);
        //returns DB queried object into seeAllOrders.jsp, variable: "listOfOrders"
        return new ModelAndView("customerViewAllOrders","listOfOrders",ordersDAO.getAllCustomerOrders(customerID));
    }
}
