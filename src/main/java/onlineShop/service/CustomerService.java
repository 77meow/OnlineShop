
package onlineShop.service;

import onlineShop.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineShop.dao.CustomerDao;
import onlineShop.entity.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        // Enable Customer
        // soft delete : setEnables(false);
        customer.getUser().setEnabled(true);
        // 分配一个购物车
        Cart cart = new Cart();
        customer.setCart(cart);

        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String userName) {
        return customerDao.getCustomerByUserName(userName);
    }
}
