/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.OrdersDAO;
import Model.Orders;
import Model.CartPkg;
import Service.PkgOrderDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    public void setPkgOrderDAO (PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }
    
    @RequestMapping(value="/receiptPage", method=RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, 
                                      HttpServletResponse response, 
                                      Model model) throws Exception {
        //retrieves orderID from session state
        int orderID = Integer.parseInt(request.getSession().getAttribute("orderID").toString());
        //poulates selected with specified order information from Orders table
        Orders selectedOrder = (Orders)ordersDAO.getOrdersByOrderID(orderID).get(0);
        //total price is set from selectedOrder
        double totalPrice = selectedOrder.getTotalPrice();
        //retrieves a list of closed pkgOrders associated with the custemer and order
        List<CartPkg> listOfClosedPkgs = ordersDAO.getPkgOrdersByCustomerAll(
                selectedOrder.getCustomerID(), orderID);
        //gives the receiptPage.jsp variables to work to populate fields
        model.addAttribute("finalPrice", totalPrice);
        model.addAttribute("itemsOrdered", listOfClosedPkgs);
        //returns the receiptPage view with order details
        return new ModelAndView("receiptPage","orderDetails",selectedOrder);
    }
}
