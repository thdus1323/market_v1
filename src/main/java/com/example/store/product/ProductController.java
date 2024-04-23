package com.example.store.product;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductNativeRepository productNativeRepository;
//
//    @GetMapping({"/product"})
//    public String list()
//    {
//        return  "/product/list";
//    }

    //상품 목록
    @GetMapping({"/product", "/"})
    public String index(HttpServletRequest request) {
        List<Product> productList = productNativeRepository.findAll();
        request.setAttribute("productList", productList);
        return "/product/list";
    }

    //상품 상세
    @GetMapping("/product/{id}")
    public String detail(@PathVariable Integer id){
        return "/product/detail";
    }

    //상품 등록
    @GetMapping("/product/save-form")
    public String saveForm(){
        return "/product/save-form";
    }

    //상품 수정
    @GetMapping("/product/update-form")
    public String update(@PathVariable Integer id, String name,Integer price, Integer qty){
        productNativeRepository.updateById(id, name, price, qty);
        return "/product/update-form";
    }


}
