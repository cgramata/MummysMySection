package Service;

import java.util.List;
import Model.PkgOrder;
import Model.CartPkg;

//Pkg Order DAO Abstract class that PkgOrderDAOImpl implements
//Declares functions to be used by various controllers to communicated between the database
public interface PkgOrderDAO {  
    public void addOpenPkgOrder(PkgOrder pkgOrder);
    public void editOrderId(int pkgOrderId, int newOrderId);
    public void editPackageId(int pkgOrderId, int newPackageId);
    public void editCustomerId(int pkgOrderId, int newCustomerId);
    public void editQuantity(int pkgOrderId, int newQuantity);
    public void editIsOpen(int pkgOrderId, int newIsOpen);
    public void closePkgOrder (int pkgOrderId, int orderId);
    public void deletePkgOrder(int deletePkgOrderId);
    public int getNextPkgOrderId();
    public PkgOrder getSinglePkgOrder(int pkgOrderId);
    public List<PkgOrder> getOpenPkgOrdersByCustomer(int Customer_Id);
    public List<PkgOrder> getAllPkgOrdersByOrder(int OrderId);
    public List<PkgOrder> getAllClosedPkgOrders();
    public double getFinalPrice(int customer_id);
    public List<CartPkg> getOpenPkgOrdersByCustomerAll(int Customer_Id);
}
