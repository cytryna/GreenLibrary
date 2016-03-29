package s10338.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import s10338.service.BookService;

@Controller
public class SearchController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/search")
    public String welcome(Model model) {
//        bookService.getAllCustomers().forEach(customer -> System.out.println(customer.getName()));
        model.addAttribute("books", bookService.getAllBooks());
        return "search";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("title") String title, Model model) {
        model.addAttribute("books", bookService.getBookById());
        return "search";
    }


}
