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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author syntel
 * This controller is mapped to the confirmationPage.jsp
 */
@Controller
@RequestMapping("/confirmationPage")
public class ConfirmationPageController {
    
    private PkgOrderDAO pkgOrderDAO;
    
    public void setPkgOrderDAO (PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    @RequestMapping(value = "/confirmationPage", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, 
                                      HttpServletResponse response, 
                                      Model model) throws Exception {
        //retrieves customerID from the sesssion state
        int customerID = Integer.parseInt(request.getSession().getAttribute("customerID").toString());
        //gives confirmationPage.jsp a variable("finalPrice") through model.addAttribute
        model.addAttribute("finalPrice",pkgOrderDAO.getFinalPrice(customerID));
        //returns another variable("pkgOrderInfo") to confirmationPage view
        return new ModelAndView("confirmationPage","pkgOrderInfo",
                                pkgOrderDAO.getOpenPkgOrdersByCustomerAll(customerID));
    }
}
