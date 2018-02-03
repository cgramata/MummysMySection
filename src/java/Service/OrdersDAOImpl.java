/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.CartPkg;
import Model.Orders;
import Service.PkgOrderDAOImpl;
import Model.PkgOrder;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 *
 * @author syntel
 */
public class OrdersDAOImpl implements OrdersDAO{
    
    private static JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public List getAllOrders() {
        return jdbcTemplate.query("select * from ORDERS", new OrdersRowMapper());
    }
    
    @Override
    public ArrayList<Integer> getOpenPkgOrderIDs(int customerID){
        PkgOrderDAOImpl pkgOrderMethods = new PkgOrderDAOImpl();
        List<PkgOrder> listOfPkgOrder = pkgOrderMethods.getOpenPkgOrdersByCustomer(customerID);
        
        ArrayList<Integer> listOfPkgOrderIDs = new ArrayList();
        //iterate over listOfPkgeOrder objects to retrieve pkgOrderID
        for(PkgOrder pkgOrder: listOfPkgOrder) {
            listOfPkgOrderIDs.add(pkgOrder.getPkgOrderId());
        }
        
        return (listOfPkgOrderIDs);
    }
    
    @Override
    public List getOrdersByOrderID(int orderID){
        String query = "select * from ORDERS where ORDER_ID = " + orderID;
        
        return jdbcTemplate.query(query, new OrdersRowMapper());
    }

    @Override
    public int idOrdersGenerator(){
        return jdbcTemplate.queryForObject("select max(order_id) from orders", Integer.class);
    }
    
    @Override
    public List<CartPkg> getOpenPkgOrdersByCustomerAll(int customerID, int orderID){
        return jdbcTemplate.query("SELECT * FROM PkgOrders O, Packages P WHERE O.Customer_Id=" + customerID
                + " AND O.ORDER_ID= " + orderID + " AND O.Package_Id=P.Package_Id", new CartPkgRowMapper());
    }
    
    @Override
    public void updateOrderRow(Orders order) {
        String query = "update ORDERS "
                + "SET CUSTOMER_ID = " + order.getCustomerID()
                + ", CREDIT_ID = " + order.getCreditID()+ ", PAYMENT_TYPE = " + order.getPaymentType()
                + ", TOTAL_PRICE = " + order.getTotalPrice() + ", STREET = '" + order.getStreet()
                + "', CITY = '" + order.getCity() + "', AREA_CODE = " + order.getAreaCode()
                + ", PHONE_NUMBER = '" + order.getPhoneNumber() + "', DELIVERY_DATE = '" + order.getDeliveryDate()
                + "', ORDER_DATE = '" + order.getOrderDate() + "', ORDER_STATUS = " + order.getOrderStatus()
                + " where ORDER_ID = " + order.getOrderID();
        
        jdbcTemplate.execute(query);
    }
    
    @Override
    public void insertNewOrder(Orders orders) {
        String query = "insert into ORDERS values(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        jdbcTemplate.update(query, new Object[]{orders.getOrderID(), orders.getCustomerID(),
                                    orders.getCreditID(), orders.getPaymentType(),
                                    orders.getTotalPrice(), orders.getStreet(),
                                    orders.getCity(), orders.getAreaCode(),
                                    orders.getPhoneNumber(), orders.getDeliveryDate(),
                                    orders.getOrderDate(), orders.getOrderStatus()});
        System.out.println("Inserted Orders Record");
    }
    
    @Override
    public void deleteOrder(int orderID) {
        String query = "delete from ORDERS where ORDER_ID = " + orderID;
        
        jdbcTemplate.execute(query);
        System.out.println("Order Deleted");
    }
}
