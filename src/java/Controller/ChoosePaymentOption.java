/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.PkgOrderDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author syntel
 * This class populates chosePaymentOption.jsp with information
 * 
 */
@Controller
@RequestMapping("/choosePaymentOption")
public class ChoosePaymentOption {
    
    private PkgOrderDAO pkgOrderDAO;
    
    public void setPkgOrderDAO (PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    /**
     * instantiates customerID and retrieves value from session state
     * calls the choosePaymentOption view, and gives it a list of pkgOrders that
     * that can be iterated over
    */
    @RequestMapping(value = "/choosePaymentOption", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, 
                                      HttpServletResponse response) throws Exception {
        int customerID = Integer.parseInt(request.getSession().getAttribute("customerId").toString());
        //returns DB queried object into seeAllOrders.jsp, variable: "listOfOrders"
        return new ModelAndView("choosePaymentOption","pkgOrderInfo",
                                pkgOrderDAO.getOpenPkgOrdersByCustomerAll(customerID));
    }    
}

