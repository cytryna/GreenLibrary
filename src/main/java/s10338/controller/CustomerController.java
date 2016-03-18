package s10338.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import s10338.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String welcome(Model model) {
        customerService.getAllCustomers().forEach(customer -> System.out.println(customer.getName()));
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

}
