package by.gsu.pms.task11.controller;

import by.gsu.pms.task11.repo.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Controller
public class ResolverController {
    @Autowired
    private ProductsRepo productsRepo;

    @GetMapping("/resolve/paramsForGroup")
    public String paramsForGroup(@RequestParam(name = "productGroup") String productGroup, Model model
    ){

        model.addAttribute("results", productsRepo.getProductGroupParamsById(
                productsRepo.getProductGroupsIdByName(productGroup)
        ));
        return "results";
    }

    @GetMapping("/resolve/productsWithNotHaveParam")
    public String productsWithNotHaveParam(@RequestParam(name = "param") String param, Model model
    ){
        model.addAttribute("results", Collections.singletonList(productsRepo.getProductWithoutParamGroupById(
                productsRepo.getParamGroupIdByParam(param))));
        return "results";
    }

    @GetMapping("/resolve/productsWithProductsGroup")
    public String productsWithProductsGroup(@RequestParam(name = "group") String group, Model model
    ){
        model.addAttribute("results", productsRepo.getProductByPrGroup(group));
        return "results";
    }

    @GetMapping("/resolve/allProducts")
    public String allProducts(Model model){
        model.addAttribute("results", productsRepo.getAllProducts());
        return "results";
    }

    @GetMapping("/resolve/deleteProductsByParam")
    public String deleteProductsByParam(@RequestParam(name = "param") String param
    ){
        productsRepo.deleteProductByParamId(productsRepo.getParamGroupIdByParam(param));
        return "main";
    }

    @GetMapping("/resolve/transferPramGroupToProductGroup")
    public String transferPramGroupToProductGroup(@RequestParam(name = "paramGroup") String paramGroup,
                                                  @RequestParam(name = "productGroup") String productGroup
    ){
        productsRepo.transferParamGroupToProductGroup(productsRepo.getParamGroupIdByName(paramGroup), productGroup);
        return "main";
    }

}
