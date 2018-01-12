package com.internship.repayment.controller;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.entity.Seller;
import com.internship.repayment.repository.CustomerRepository;
import com.internship.repayment.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/repayment/customer")
public class CustomerController{
    // 创建线程安全的Map
    static Map<Long,Customer> customers = Collections.synchronizedMap(new HashMap<Long, Customer>());
    @Autowired
    private CustomerService customerService;



    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer_index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute Customer customer, ModelMap map){
        Result<Customer> result = customerService.login(customer.getUsername(),customer.getPassword());
        if (result.getState().equals(Result.SUCCESS)){
            map.addAttribute("customer",result.getResult());
            map.addAttribute("query_seller","/repayment/customer/querySeller");
            return "customer_login_success";
        }else {
            Exception e = new Exception("密码错误");
            map.addAttribute("exception",e);
            map.addAttribute("url",customer.getUsername());
            return "error";
        }
    }

    @RequestMapping(value = "/querySeller",method = RequestMethod.GET)
    public  String querySeller(@RequestParam String username,ModelMap map){
        List<Seller> sellers=customerService.querySeller(username);
        if(sellers!=null)
        {
            map.addAttribute("sellers",sellers);



            return "customer_querySeller";
        }
        else
        {
            Exception e=new Exception("没有责任销售员");
            map.addAttribute("exception",e);

            return "error";

        }


    }

    @RequestMapping(value = "/queryContract",method = RequestMethod.GET)
    public  String queryContract(@RequestParam String username,ModelMap map){
        List<Contract> contracts=customerService.queryContract(username);
        if (contracts!=null)
        {
            map.addAttribute("contracts",contracts);
            return "customer_queryContract";
        }
        else
        {
            Exception e=new Exception("没有合同");
            map.addAttribute("exception",e);

            return "error";

        }

    }


    /*
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/get", method= RequestMethod.GET)
    public List<Customer> getCustomerList() {
        // 处理"/Customer/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递

        List<Customer> r = customerRepository.findAll();
        Logger logger = LoggerFactory.getLogger(CustomerController.class);
        logger.info(r.toString());
        return r;
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postCustomer(@ModelAttribute Customer customer) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        customers.put(customer.getId(), customer);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Customer getCustomer(@PathVariable Integer id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return customers.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putCustomer(@PathVariable Long id, @ModelAttribute Customer customer) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        Customer c = customers.get(id);
        c.setName(customer.getName());
        c.setPassword(customer.getPassword());
        customers.put(id, c);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        customers.remove(id);
        return "success";
    }*/
}
