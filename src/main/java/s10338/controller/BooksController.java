package s10338.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import s10338.service.BookService;

@Controller
@RequestMapping("/books")
public class BooksController {


    @Autowired
    private BookService bookService;

    @RequestMapping("/all")
    public String welcome(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "search";
    }

    @RequestMapping("/search")
    public String getProductByTitle(@RequestParam("title") String bookTitle, Model model) {
        model.addAttribute("books", bookService.getBookByTitle(bookTitle));
//        bookService.getAllCustomers().forEach(customer -> System.out.println(customer.getName()));
        return "search";
    }

    @RequestMapping("/book")
    public String getProductById(@RequestParam("id") int bookId, Model model) {
        model.addAttribute("book", bookService.getBookById(bookId));
        return "book";
    }

}
