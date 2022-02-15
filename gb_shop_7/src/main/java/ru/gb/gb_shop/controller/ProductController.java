package ru.gb.gb_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.gb_shop.entity.Product;
import ru.gb.gb_shop.service.ProductService;



@Controller
@RequiredArgsConstructor
@RequestMapping("/gb_shop")
public class ProductController {

    private final ProductService productService;

    // показать все элементы productList
    @GetMapping(path = "/all")
    public String showProductList(Model model){
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

        // показать один элемент
    @GetMapping(path = "/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }

    // удаление элемента  "/gb_shop/delete/{id}"
    @GetMapping(path = "/delete")
    public String deleteProductById(@RequestParam(name = "id") Long id){
        productService.deleteById(id);
        return "redirect:/gb_shop/all";
    }

    @PostMapping
    public String saveProduct(Product product) {
        productService.save(product);
        return "redirect:/product/all";
    }

    @RequestMapping(path = "/sort", method = RequestMethod.GET)    //localhost:8080/gb_shop/sort?sort=desk
    public String showProductListSort(Model model,
                                      @RequestParam(name = "sort", defaultValue = "ask", required = true) String orderSort){
        if (orderSort.equals("desk")) {
            model.addAttribute("products", productService.findSortedByCost(Sort.Direction.DESC));
        } else {
            model.addAttribute("products", productService.findSortedByCost(Sort.Direction.ASC));
        }
        return "product-list";
    }

    // форма для создания product
    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }



//    @GetMapping(path = "/{id}") // localhost:8080/spring/message/{id}?random=true
//    public String getMessageById(Model model,
//                                 @PathVariable Long id,
//                                 @RequestParam(name = "random", defaultValue = "false", required = false) Boolean isRandom) {
//        Message message;
//
//        if (isRandom) {
//            message = messageService.getRandomMessage();
//        } else {
//            message = messageService.findById(id.intValue());
//        }
//
//        model.addAttribute("message", message);
//        return "message";
//    }




}
