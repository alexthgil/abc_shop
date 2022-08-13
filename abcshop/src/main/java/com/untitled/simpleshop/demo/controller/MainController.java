package com.untitled.simpleshop.demo.controller;

import com.untitled.simpleshop.demo.domain.Basket;
import com.untitled.simpleshop.demo.domain.Product;
import com.untitled.simpleshop.demo.domain.User;
import com.untitled.simpleshop.demo.repos.BasketRepository;
import com.untitled.simpleshop.demo.repos.ProductRepository;
import com.untitled.simpleshop.demo.service.BasketService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BasketService basketService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/product")
    public String main(@AuthenticationPrincipal User user, Map<String, Object> model) {
        Iterable<Product> messages = productRepository.findAll();
        model.put("products", messages);
        return "product";
    }

    @PostMapping("/product")
    public String addNewProduct (@AuthenticationPrincipal User user,
                                 @RequestParam String name,
                                 @RequestParam String description,
                                 Map<String, Object> model,
                                 @RequestParam("file") MultipartFile file) throws IOException
    {

        Product newProduct = new Product(name, description);

        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (uploadDir.exists() == false) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));

            newProduct.setFilename(resultFilename);
        }

        productRepository.save(newProduct);

        Iterable<Product> products = productRepository.findAll();
        model.put("products", products);

        return "product";
    }

}
