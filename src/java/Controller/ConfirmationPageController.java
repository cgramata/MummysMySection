/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.OrdersDAO;
import Model.Orders;
import Service.PkgOrderDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author syntel
 */
@Controller
@RequestMapping("/confirmationPage")
public class ConfirmationPageController {
    
    private PkgOrderDAO pkgOrderDAO;
    
    public void setPkgOrderDAO (PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    @RequestMapping(value = "/confirmationPage", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        int customerID = Integer.parseInt(request.getSession().getAttribute("customerID").toString());
        //returns DB queried object into seeAllOrders.jsp, variable: "listOfOrders"
        model.addAttribute("finalPrice",pkgOrderDAO.getFinalPrice(customerID));
        return new ModelAndView("confirmationPage","pkgOrderInfo",pkgOrderDAO.getOpenPkgOrdersByCustomerAll(customerID));
    }
}
