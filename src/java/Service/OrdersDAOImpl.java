/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.CartPkg;
import Model.Orders;
import Model.PkgOrder;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 *
 * @author syntel
 * implements the necessary methods
 */
public class OrdersDAOImpl implements OrdersDAO{
    
    //creates the jdbc connection to be utilized in this class
    private static JdbcTemplate jdbcTemplate;
    
    //constructor
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    //retrieves all orders from the Orders table
    @Override
    public List getAllOrders() {
        return jdbcTemplate.query("select * from ORDERS", new OrdersRowMapper());
    }
    
    //retrieves the current date, will be used to instantiate an order's date and filter for searching
    @Override
    public String getTodaysDate(){
        String query = "select to_char(trunc(sysdate), 'DD-MON-YYYY') from dual";
        return jdbcTemplate.queryForObject(query, String.class);
    }
    
    //get all open pkgOrdersIDs (items in carts) from a customer that hasn't checked out
    @Override
    public ArrayList<Integer> getOpenPkgOrderIDs(int customerID){
        PkgOrderDAOImpl pkgOrderMethods = new PkgOrderDAOImpl();
        //retrieves the list of pkgOrders
        List<PkgOrder> listOfPkgOrder = pkgOrderMethods.getOpenPkgOrdersByCustomer(customerID);
        
        ArrayList<Integer> listOfPkgOrderIDs = new ArrayList();
        //iterate over listOfPkgeOrder objects to retrieve pkgOrderID
        listOfPkgOrder.forEach((pkgOrder) -> {
            listOfPkgOrderIDs.add(pkgOrder.getPkgOrderId());
        });
        
        return (listOfPkgOrderIDs);
    }
    
    //retrieve a specific order by orderID
    @Override
    public List getOrdersByOrderID(int orderID){
        String query = "select * from ORDERS where ORDER_ID = " + orderID;
        
        return jdbcTemplate.query(query, new OrdersRowMapper());
    }
    
    //retrieve all the orders for a customer
    @Override
    public List getAllCustomerOrders(int customerID) {
        String query = "select * from ORDERS where CUSTOMER_ID = " + customerID;
        
        return jdbcTemplate.query(query, new OrdersRowMapper());
    }
    
    //retrieves orders specified for "today's" date
    @Override
    public List getAllOfTodaysOrders() {
        String query = "SELECT * FROM ORDERS WHERE TO_DATE(DELIVERY_DATE) = TRUNC(SYSDATE)";
        return jdbcTemplate.query(query, new OrdersRowMapper());
    }
    
    //generates an orderID from an existing orderID 
    @Override
    public int idOrdersGenerator(){
        return jdbcTemplate.queryForObject("select max(order_id) from orders", Integer.class);
    }
    
    //retrieves all open order items that are closed, associated with an order and customer
    @Override
    public List<CartPkg> getPkgOrdersByCustomerAll(int customerID, int orderID){
        return jdbcTemplate.query("SELECT * FROM PkgOrders O, Packages P WHERE O.Customer_Id=" + customerID
                + " AND O.ORDER_ID= " + orderID + " AND O.Package_Id=P.Package_Id", new CartPkgRowMapper());
    }
    
    //Updates an Orders row
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
    
    //Inserts a new order into the Orders table
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
    
    //deletes an order from the Orders table
    @Override
    public void deleteOrder(int orderID) {
        String query = "delete from ORDERS where ORDER_ID = " + orderID;
        
        jdbcTemplate.execute(query);
        System.out.println("Order Deleted");
    }
}
