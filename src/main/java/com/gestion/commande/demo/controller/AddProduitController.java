package com.gestion.commande.demo.controller;
import com.gestion.commande.demo.models.Boissons;
import com.gestion.commande.demo.models.Burgers;
import com.gestion.commande.demo.services.BurgerService;
import com.gestion.commande.demo.services.BoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.lang.annotation.Target;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller

public class AddProduitController {
    @Autowired
    BoissonService boissonService;
    @Autowired
    BurgerService burgerService;
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/img";

    @GetMapping({"/burger", "/burger"})
    public String getViewAddBurger(Model model) {
        Burgers burgers = new Burgers();
        model.addAttribute("burgers",burgers);
        return "index";
    }

    @GetMapping({"/liste-produit", "/liste-produit"})
    public String getViewListProduit(Model model) {
        List<Burgers> burgers = burgerService.getAllBurgers();
        model.addAttribute("burgers",burgers);
        return "index";
    }
    @GetMapping({"/add", "/add"})
    public String getViewAdd(Model model) {
        Burgers burgers = new Burgers();
        Boissons boissons = new Boissons();
        model.addAttribute("burgers",burgers);
        model.addAttribute("boissons",boissons);
        return "burger/addproduit.html";
    }
    @PostMapping("/addBurger")
    public String addBurgers(@ModelAttribute("burgers") Burgers burgers, Model model,@RequestParam("fileImage") MultipartFile fileImage)throws IOException {
                if(burgers == null || burgers.getLibelle() == null || burgers.getLibelle().equals("")) {
                    model.addAttribute("errorNom", "Champ obligatoire");
                    return "burger/addproduit.html";
                }
      boolean valide = true;
      String image;
      if(valide) {
          if (!fileImage.isEmpty()) {
              image = fileImage.getOriginalFilename();
              Path fileNameAndPath = Paths.get(uploadDirectory, image);
              Files.write(fileNameAndPath, fileImage.getBytes());
              burgers.setImage(image);
              burgerService.addBurgers(burgers);
          }
          if (burgers.getId() != null) {
              return "index";
          } else {
              model.addAttribute("error", "Echec de l'operation");
              return "burger/addproduit.html";
            }
      }
        return "index";

    }
    @PostMapping("/addBoisson")
    public String addBoisson(@ModelAttribute("boissons") Boissons boissons, Model model,@RequestParam("fileImage") MultipartFile fileImage)throws IOException {
        if(boissons == null || boissons.getMark() == null || boissons.getMark().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "burger/addproduit.html";
        }
        boolean valide = true;
        String image;
        if(valide) {
            if (!fileImage.isEmpty()) {
                image = fileImage.getOriginalFilename();
                Path fileNameAndPath = Paths.get(uploadDirectory, image);
                Files.write(fileNameAndPath, fileImage.getBytes());
                boissons.setImage(image);
                boissonService.addBoissons(boissons);
            }
            if (boissons.getId() != null) {
                return "index";
            } else {
                model.addAttribute("error", "Echec de l'operation");
                return "burger/index";
            }
        }
        return "index";

    }
    

}
