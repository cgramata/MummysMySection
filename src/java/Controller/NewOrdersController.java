/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.OrdersDAO;
import Model.Orders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 *
 * @author syntel
 * linked to the newOrders.jsp
 */
public class NewOrdersController extends SimpleFormController{
    private OrdersDAO orderDAO;
    
    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.orderDAO = ordersDAO;
    }
    
    //this snippet binds to newOrders.jsp via setCommandName
    public NewOrdersController(){
        setCommandClass (Orders.class);
        setCommandName ("newOrders");
    }
    
    //Inserts new order into Orders table and redirects to success.jsp
    @Override
    protected ModelAndView onSubmit (Object command) throws Exception{
        Orders newOrder=(Orders)command;
        orderDAO.insertNewOrder(newOrder);
        return new ModelAndView("Success");
    }
}
