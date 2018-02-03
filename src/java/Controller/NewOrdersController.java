/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.OrdersDAO;
import Model.NewOrderID;
import Model.Orders;
import java.io.Console;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 *
 * @author syntel
 */
public class NewOrdersController extends SimpleFormController{
    private OrdersDAO orderDAO;
    
    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.orderDAO = ordersDAO;
    }
    
    public NewOrdersController(){
        setCommandClass (Orders.class);
        setCommandName ("newOrders");
    }
    
    @Override
    protected ModelAndView onSubmit (Object command) throws Exception{
        Orders newOrder=(Orders)command;
        orderDAO.insertNewOrder(newOrder);
        return new ModelAndView("Success","orderDetail",newOrder);
    }
}
