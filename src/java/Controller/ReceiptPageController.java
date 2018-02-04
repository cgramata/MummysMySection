/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import Service.OrdersDAO;
import Model.DeliveryAddress;
import Model.Orders;
import Model.CartPkg;
import Service.PkgOrderDAO;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/receiptPage")
public class ReceiptPageController {
    
    private OrdersDAO ordersDAO;
    private PkgOrderDAO pkgOrderDAO;
    
    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }
    
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO){
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    @RequestMapping(value="/receiptPage", method=RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, 
                                      Model model) throws Exception {
        System.out.println("in the receipt controller");
        int orderID = Integer.parseInt(request.getSession().getAttribute("orderID").toString());
        
        Orders selectedOrder = (Orders)ordersDAO.getOrdersByOrderID(orderID).get(0);
        System.out.println(selectedOrder);
        
        double totalPrice = selectedOrder.getTotalPrice();
        
        List<CartPkg> listOfClosedPkgs = ordersDAO.getOpenPkgOrdersByCustomerAll(
                selectedOrder.getCustomerID(), orderID);
        
        //establishes an empty vessel that updated information goes into in editOrders.jsp
        model.addAttribute("finalPrice", totalPrice);
        model.addAttribute("itemsOrdered", listOfClosedPkgs);
        //returns the order details, from the db, to the proper input fields in editOrders.jsp
        return new ModelAndView("receiptPage","orderDetails",selectedOrder);
    }
}
