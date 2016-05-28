package s10338.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import s10338.domain.User;
import s10338.service.BookService;
import s10338.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/books")
public class BooksController {


    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;


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

//    @RequestMapping(value = "/account", method = RequestMethod.GET)
//    public String accountPage(Model model, HttpServletRequest request, HttpServletResponse response) {
//        User remoteUser = userRepository.findByLogin(request.getRemoteUser());
//        System.out.println(remoteUser);
//        model.addAttribute("user", remoteUser);
//        return "account";
//    }
    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation(@RequestParam("id") int bookId, Model model) {
//        System.err.println(request.getRemoteUser());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(auth.getName());
        bookService.reservation(bookId, user);
        model.addAttribute("books", bookService.getAllBooks());
        return "reservation";
    }

}
