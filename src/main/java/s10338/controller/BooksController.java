package s10338.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import s10338.domain.Product;
import s10338.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/books")
public class BooksController {


    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/all")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

//    @RequestMapping(value = "/book", method = RequestMethod.GET)
//    public String getBookByTitle(@RequestParam("title") String bookTitle, Model model) {
//        model.addAttribute("books", bookService.getBookByTitle(bookTitle));
//        return "books";
//    }

//    @RequestMapping("/{title}")
//    public String listByCategory(Model model, @PathVariable("title") String bookTitle) {
//        model.addAttribute("books", bookService.getBookByTitle(bookTitle));
//        return "products";
//    }


    @RequestMapping("/bookid")
    public String getProductById(@RequestParam("id") int bookId, Model model) {
        model.addAttribute("book", bookService.getBookById(bookId));
        return "book";
    }


    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation(@RequestParam("id") String bookTitle, Model model) {
        model.addAttribute("books", bookService.getBookByTitle(bookTitle));
        return "books";
    }

}
