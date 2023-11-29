package com.brocamp.AcousticAlchemy.controller;

import com.brocamp.AcousticAlchemy.dto.OfferDTO;
import com.brocamp.AcousticAlchemy.model.Category;
import com.brocamp.AcousticAlchemy.model.Offer;
import com.brocamp.AcousticAlchemy.model.Product;
import com.brocamp.AcousticAlchemy.service.CategoryService;
import com.brocamp.AcousticAlchemy.service.OfferService;
import com.brocamp.AcousticAlchemy.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class OfferController {
    private OfferService offerService;
    private ProductService productService;
    private CategoryService categoryService;

    @GetMapping("/admin_panel/offer")
    public String showAllOffers(Model model){
        List<Offer> offerList = offerService.findAllOffers();
        model.addAttribute("offerList",offerList);
        model.addAttribute("size",offerList.size());
        return "admin/viewAllOffers";
    }
    @GetMapping("/admin_panel/offer/add")

    public String showAddOfferPage(Model model){
        List<Product> productList = productService.findCurrentProducts();
        List<Category> categoryList = categoryService.findAllCurrentCategories();
        model.addAttribute("products",productList);
        model.addAttribute("categories",categoryList);
        model.addAttribute("offerDTO",new OfferDTO());
        return "admin/add-offer";
    }
    @PostMapping("/admin_panel/offer/add")

    public String saveOffers(@Valid @ModelAttribute("offerDTO")OfferDTO offerDTO, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("dtoError","fill the form properly");
            return  "admin/add-offer";

        }else{

        if(offerDTO.getOffPercentage()>100 && offerDTO.getOffPercentage()<0){
            model.addAttribute("discountError","pleace enter the discount persentage below or equals to 100");
            return  "admin/add-offer";

        }else {
            try {

                offerService.SaveOffer(offerDTO);
                redirectAttributes.addFlashAttribute("success", "Added new Offer successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("error", "Failed to add new Offer!");
            }
            return "redirect:/admin_panel/offer";
        }}
    }
    @GetMapping("/admin_panel/offer/update/{id}")
    public String updateOffer(@PathVariable long id,
                              Model model){
        List<Product> productList = productService.findCurrentProducts();
        List<Category> categoryList = categoryService.findAllCurrentCategories();

        model.addAttribute("products",productList);
        model.addAttribute("categories",categoryList);

        Offer offer = offerService.findById(id);
        model.addAttribute("offer",offer);


        return "admin/update-offer";
    }
    @PostMapping("/admin_panel/offer/update/{id}")
    public String updateOffer(@ModelAttribute("offer") Offer offer,
                              RedirectAttributes redirectAttributes){

        try {
            offerService.update(offer);
            redirectAttributes.addFlashAttribute("success", "Updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error server, please try again!");
        }
        return "redirect:/admin_panel/offer";
    }
    @GetMapping("/admin_panel/offer/disable/{id}")
    public String disableOffer(@PathVariable long id,
                               RedirectAttributes redirectAttributes){
        offerService.disable(id);
        redirectAttributes.addFlashAttribute("success","Offer Disabled");
        return "redirect:/admin_panel/offer";
    }
    @GetMapping("/admin_panel/offer/enable/{id}")
    public String enableOffer(@PathVariable long id,
                              RedirectAttributes redirectAttributes){
        offerService.enable(id);

        redirectAttributes.addFlashAttribute("success","Offer Enabled");
        return "redirect:/admin_panel/offer";
    }
    @GetMapping("/admin_panel/offer/delete/{id}")
    public String deleteOffer(@PathVariable long id,
                              RedirectAttributes redirectAttributes){
        offerService.deleteOffer(id);

        redirectAttributes.addFlashAttribute("success","Offer deleted");

        return "redirect:/admin_panel/offer";
    }
}
