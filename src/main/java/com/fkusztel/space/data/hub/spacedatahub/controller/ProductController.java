package com.fkusztel.space.data.hub.spacedatahub.controller;

import com.fkusztel.space.data.hub.spacedatahub.dto.FootprintDto;
import com.fkusztel.space.data.hub.spacedatahub.entity.Mission;
import com.fkusztel.space.data.hub.spacedatahub.entity.Product;
import com.fkusztel.space.data.hub.spacedatahub.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @author Filip.Kusztelak
 */
@Slf4j
@Controller
@RequestMapping(path = "product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(path = "/create")
    public @ResponseBody
    String createProduct(@RequestParam LocalDate acquisitionDate, @RequestParam Mission mission,
                         @RequestParam FootprintDto footprint, @RequestParam Double price, String url) {

        Product product = Product.builder()
                .acquisitionDate(acquisitionDate)
                .mission(mission)
                .footprint(footprint)
                .price(price)
                .url(url)
                .build();

        log.info("createProduct: {}", product.toString());
        return "Created " + product.toString();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping(path = "/lower")
    public @ResponseBody
    Iterable<Product> findProductByDateLower(LocalDate date) {
        return productService.findProductByDateLower(date);
    }

    @GetMapping(path = "/greater")
    public @ResponseBody
    Iterable<Product> findProductByDateGreater(LocalDate date) {
        return productService.findProductByDateGreater(date);
    }

    @GetMapping(path = "/between")
    public @ResponseBody
    Iterable<Product> findProductByDateBetween(LocalDate startDate,
                                               LocalDate endDate) {

        return productService.findProductByDateBetween(startDate, endDate);
    }
}
