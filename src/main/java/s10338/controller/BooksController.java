package s10338.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import s10338.service.BookService;

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

    @RequestMapping(method = RequestMethod.GET)
    public String getBookByTitle(@RequestParam("title") String bookTitle, Model model) {
        model.addAttribute("books", bookService.getBooksLikeTitle(bookTitle));
        return "books";
    }


    //TODO-rwichrowski zmienić na tytuł
    @RequestMapping("/{id}")
    public String listByCategory(Model model, @PathVariable("id") int bookId) {
        model.addAttribute("book", bookService.getBookById(bookId));
//        model.addAttribute("books", bookService.getConcreteBookByTitle(bookTitle));
        return "book";
//        return "redirect:/books";
    }


    @RequestMapping("/bookid")
    public String getProductById(@RequestParam("id") int bookId, Model model) {
        model.addAttribute("book", bookService.getBookById(bookId));
        return "book";
    }


    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation(@RequestParam("id") int bookId,@RequestParam("userid") int userId, Model model) {
        bookService.reservation(bookId, userId);
        model.addAttribute("books", bookService.getAllBooks());
        return "reservation";
    }

}
