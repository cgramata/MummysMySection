package Service;

import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import Model.PkgOrder;
import javax.sql.DataSource;
import Model.CartPkg;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//PkgOrderDAOImplclass that impelments the PkgOrderDAO class
//creates functions to be used by various controllers to communicated between the database
public class PkgOrderDAOImpl implements PkgOrderDAO{
    //creates and initializes the jdbcTemplate object, that allows communication to the data base
    private static JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    @Override
    public void addOpenPkgOrder(PkgOrder pkgOrder) {
        try {
        String updateStr = ("INSERT INTO PkgOrders (Pkg_Order_Id, Order_Id, Package_Id, Customer_Id, Price_Per_Pkg, Quantity, Is_Open) "
                + " VALUES (?,?,?,?,?,?,?)");
        
        jdbcTemplate.update(updateStr, new Object[]{
                this.getNextPkgOrderId(), pkgOrder.getOrderId(), pkgOrder.getPackageIdKey(), pkgOrder.getCustomerId(), 
                pkgOrder.getPricePerPkg(), pkgOrder.getQuantity(), pkgOrder.getIsOpen()});
       
        } catch (Exception e){System.out.println(e);}
    }
    @Override
    public void editOrderId(int pkgOrderId, int newOrderId) {
        String updateStr = ("UPDATE PkgOrders SET Order_Id=? WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newOrderId, pkgOrderId});
    }
    @Override
    public void editPackageId(int pkgOrderId, int newPackageId){
        String updateStr = ("UPDATE PkgOrders SET Package_Id=? WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newPackageId, pkgOrderId});        
    }
    @Override
    public void editCustomerId(int pkgOrderId, int newCustomerId){
        String updateStr = ("UPDATE PkgOrders SET Customer_Id=? WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newCustomerId, pkgOrderId});           
    }
    @Override
    public void editQuantity(int pkgOrderId, int newQuantity){
        String updateStr = ("UPDATE PkgOrders SET Quantity=? WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newQuantity, pkgOrderId});           
    }
    @Override
    public void editIsOpen(int pkgOrderId, int newIsOpen){
        String updateStr = ("UPDATE PkgOrders SET Is_Open=? WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newIsOpen, pkgOrderId});           
    }
    @Override
    public void closePkgOrder (int pkgOrderId, int newOrderId){
        //Object o[]={newOrderId};
        //int argsTypes[]={Types.INTEGER};
        //RowMapper mapper=new OrderRowMapper();
        //List results = jdbcTemplate.query("SELECT * from Orders WHERE Order_Id=?",o,argsTypes,mapper);
        //if (!results.isEmpty()) {
            String updateStr = ("UPDATE PkgOrders SET Order_Id=? WHERE Pkg_Order_Id=?");
            jdbcTemplate.update(updateStr, new Object[]{newOrderId, pkgOrderId}); 
            updateStr = ("UPDATE PkgOrders SET Is_Open=0 WHERE Pkg_Order_Id=?");
            jdbcTemplate.update(updateStr, new Object[]{pkgOrderId});
        //}
        //else
        //    System.out.println(">>>>Error: Order doesn't exist");
    }
    @Override
    public void deletePkgOrder(int deletePkgOrderId){
        String updateStr = ("DELETE FROM PkgOrders WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{deletePkgOrderId});
    }
    @Override
    public int getNextPkgOrderId(){
        return jdbcTemplate.queryForObject("SELECT MAX(Pkg_Order_Id)FROM PkgOrders",Integer.class)+1;
    }
    @Override
    public PkgOrder getSinglePkgOrder(int pkgOrderId){
        Object o[]={pkgOrderId};
        int argsTypes[]={Types.INTEGER};
        RowMapper mapper=new PkgOrderRowMapper();
        List l = jdbcTemplate.query("SELECT * FROM PkgOrders WHERE Pkg_Order_Id=?",o,argsTypes,mapper);
        Iterator it=l.iterator();
        Model.PkgOrder p=(Model.PkgOrder)it.next();
        return p;
    }
    @Override
    public List<PkgOrder> getOpenPkgOrdersByCustomer(int Customer_Id){
        Object o[]={Customer_Id};
        return jdbcTemplate.query("SELECT * FROM PkgOrders WHERE Customer_Id=? AND Is_Open=1",o, new PkgOrderRowMapper());
    }
    @Override
    public List<PkgOrder> getAllPkgOrdersByOrder(int OrderId){
        Object o[]={OrderId};
        return jdbcTemplate.query("SELECT * FROM PkgOrders WHERE Order_Id=?",o, new PkgOrderRowMapper());
    }
    @Override
    public List<PkgOrder> getAllClosedPkgOrders(){
        return jdbcTemplate.query("SELECT * FROM PkgOrders WHERE Is_Open=0", new PkgOrderRowMapper());
    }
    @Override
    public double getFinalPrice(int customer_id){
        try {
            return jdbcTemplate.queryForObject("SELECT SUM(Price_Per_Pkg*Quantity) FROM PkgOrders WHERE Is_Open=1 AND Customer_Id="+customer_id, Double.class);
        } catch (Exception e) {return 0.0;}
    }
    
    @Override
    public List<CartPkg> getOpenPkgOrdersByCustomerAll(int Customer_Id){
        Object o[]={Customer_Id};
        return jdbcTemplate.query("SELECT * FROM PkgOrders O, Packages P WHERE O.Customer_Id=? AND O.Is_Open= 1 AND O.Package_Id=P.Package_Id",o, new CartPkgRowMapper());
    }
}