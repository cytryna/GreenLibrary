package s10338.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import s10338.domain.Product;
import s10338.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public String listAll(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/{category}")
    public String listByCategory(Model model, @PathVariable("category") String category) {
        model.addAttribute("products", productService.getProductsByCategory(category));
        return "products";
    }

    @RequestMapping("/filter/{byCryteria}")
    public String listByFilter(Model model, @MatrixVariable(pathVar = "byCryteria") Map filter) {
        model.addAttribute("products", productService.getProductsByFilter(filter));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/product/{product}/{price}")
    public String filterProducts(@PathVariable("product") String product, @MatrixVariable(pathVar = "price") Map filter, @RequestParam("manufacturer") String manufacturer, Model model) {
        model.addAttribute("products", productService.getProductsByManufacturer(manufacturer));
        // TODO: 15.03.16 Dodać implementację do wszystkich parametrów, narazie jest filtr założony tylko na manufacturer
        return "products";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("newProduct", product);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded, BindingResult result, HttpServletRequest request) {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Próba wiązania niedozwolonych pól: "+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        MultipartFile productImage = productToBeAdded.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        if (productImage!=null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDirectory+"resources\\images\\"+productToBeAdded.getProductId() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException("Próba zapisu obrazka zakończona niepowodzeniem", e);
            }
        }

        productService.addProduct(productToBeAdded);
        return "redirect:/products";

    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setDisallowedFields("unitsInOrder", "discontinued");
    }
}
