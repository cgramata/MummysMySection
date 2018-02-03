/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Orders;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author syntel
 */
public class OrdersRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int index) throws SQLException {
        Orders order = new Orders();
        
        order.setOrderID(rs.getInt(1));
        order.setCustomerID(rs.getInt(2));
        order.setCreditID(rs.getInt(3));
        order.setPaymentType(rs.getInt(4));
        order.setTotalPrice(rs.getDouble(5));
        order.setStreet(rs.getString(6));
        order.setCity(rs.getString(7));
        order.setAreaCode(rs.getInt(8));
        order.setPhoneNumber(rs.getString(9));
        order.setDeliveryDate(rs.getString(10));
        order.setOrderDate(rs.getString(11));
        order.setOrderStatus(rs.getInt(12));
        
        return order;
    }
    
}
