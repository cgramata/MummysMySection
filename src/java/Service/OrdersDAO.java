/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.CartPkg;
import Model.Orders;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author syntel
 */
public interface OrdersDAO {
    public List getAllOrders();
    public void insertNewOrder(Orders ordersObject);
    public void updateOrderRow(Orders ordersObject);
    public void deleteOrder(int orderID);
    public int idOrdersGenerator();
    public List getOrdersByOrderID(int orderID);
    public ArrayList<Integer> getOpenPkgOrderIDs(int customerID);
    public List<CartPkg> getOpenPkgOrdersByCustomerAll(int customerID, int orderID);
}

