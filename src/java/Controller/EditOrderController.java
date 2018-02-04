/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.OrdersDAO;
import Model.Orders;
import java.net.BindException;
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
@RequestMapping("/editOrder")
public class EditOrderController {
    private OrdersDAO ordersDAO;
    
    public void setOrdersDAO(OrdersDAO ordersDAO){
        this.ordersDAO = ordersDAO;
    }
    
    //takes in orderID param from seeAllOrders.jsp, queries, and uploads to input fields
    @RequestMapping(value="/editOrder",  method=RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, 
                                      HttpServletResponse response, 
                                      Model model) throws Exception {
        Orders order = new Orders();
        //establishes an empty vessel that updated information goes into in editOrders.jsp
        model.addAttribute("orderInfo", order);
        //takes in the param passed in from seeAllOrders.jsp
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        //returns the order details, from the db, to the proper input fields in editOrders.jsp
        return new ModelAndView("editOrder", "orderDetail", ordersDAO.getOrdersByOrderID(orderID).get(0));
    }
    
    
    //this is called when the update/submit button is clicked on the .jsp
    @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
    protected ModelAndView updateOrder(@ModelAttribute("orderInfo") Orders order, 
                                       BindingResult result, 
                                       BindException errors) throws Exception{
        //updates the specific row in the table, the variable order is passed from
        //the method above, the empty vessel is filled and passed to this method
        ordersDAO.updateOrderRow(order);
        //returns the view, seeAllOrders.jsp, and is given a new list after the row is deleted
        return new ModelAndView("seeAllOrders","listOfOrders",ordersDAO.getAllOrders());
    }
}
