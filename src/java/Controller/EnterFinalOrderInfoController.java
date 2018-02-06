/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.OrdersDAO;
import Model.DeliveryAddress;
import Model.Orders;
import Service.PkgOrderDAO;
import java.net.BindException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author syntel
 * This is linked to the enterfinalOrderInfo.jsp
 */
@Controller
@RequestMapping("/enterFinalOrderInfo")
public class EnterFinalOrderInfoController{
    
    private OrdersDAO ordersDAO;
    private PkgOrderDAO pkgOrderDAO;
    
    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }
    
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO){
        this.pkgOrderDAO = pkgOrderDAO;
    }
  
    @RequestMapping(value="/enterFinalOrderInfo", method=RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, 
                                      HttpServletResponse response, 
                                      Model model) throws Exception {
        //instantiates an empty DeliveryAddress object
        DeliveryAddress deliveryInformation = new DeliveryAddress();
        //establishes an empty vessel that updated information goes into once the
        //the submit button is clicked and passes it down to the insertNewOrder method
        model.addAttribute("newOrderInfo", deliveryInformation);
        //retrieves the enterFinalOrderInfo page
        return new ModelAndView("enterFinalOrderInfo");
    }
    
    @RequestMapping(value="/enterFinalOrderInfo", method=RequestMethod.POST)
    protected String insertNewOrder(HttpServletRequest request,
                                       HttpServletResponse response,
                                       @ModelAttribute("newOrderInfo") DeliveryAddress deliveryInformation,
                                       BindException errors) throws Exception{
        //generates new order id
        int orderID = ordersDAO.idOrdersGenerator()+1;
        //updates the orderID in the session state
        HttpSession session = request.getSession();
        session.setAttribute("orderId", orderID);
        //gets customerID from session state
        int customerID = Integer.parseInt(request.getSession().getAttribute("customerId").toString());
        //retrieves final price
        double totalPrice = pkgOrderDAO.getFinalPrice(customerID);
        //creates ArrayList to hold pkgOrderIDs
        ArrayList<Integer> pkgOrderIDList;
        
        //creates new order row to insert, utilizes deliveryInformation
        Orders newOrder = new Orders();
        newOrder.setOrderID(orderID);
        newOrder.setCustomerID(customerID);
        newOrder.setCreditID(3);
        newOrder.setPaymentType(1);
        newOrder.setStreet(deliveryInformation.getStreet());
        newOrder.setCity(deliveryInformation.getCity());
        newOrder.setPhoneNumber(deliveryInformation.getPhoneNumber());
        //TODO need to figure out how to set dates
        newOrder.setDeliveryDate(deliveryInformation.getDeliveryDate());
        newOrder.setOrderDate(ordersDAO.getTodaysDate());
        newOrder.setAreaCode(Integer.parseInt(deliveryInformation.getAreaCode()));
        newOrder.setOrderStatus(0);
        newOrder.setTotalPrice(totalPrice);
        //inserts into new order to Orders
        ordersDAO.insertNewOrder(newOrder);
        
        //Creates list of pkgOrderIDs then interates over it to close them and assigns orderIDs
        pkgOrderIDList = ordersDAO.getOpenPkgOrderIDs(newOrder.getCustomerID());
        pkgOrderIDList.forEach((pkgOrderId) -> {
            pkgOrderDAO.closePkgOrder(pkgOrderId, orderID);
        });
        
        //redirects to the receiptPage.htm (the receiptPage controller)
        return "redirect:/receiptPage.htm";
    }
    
}
