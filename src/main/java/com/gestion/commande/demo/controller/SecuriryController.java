package com.gestion.commande.demo.controller;

import com.gestion.commande.demo.models.Client;
import com.gestion.commande.demo.models.Role;
import com.gestion.commande.demo.models.Users;
import com.gestion.commande.demo.services.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class SecuriryController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginView() {
        return "security/login";
    }

    @GetMapping("/dash/index")
    public String home(Model model){

        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.findUserByEmail(auth.getName());
        model.addAttribute("msg", "Bonjour " + user.getNom() + " " + user.getPrenom());
        return "dash/index";
    }
    ////registration
    @GetMapping({"/inscription"})
    public String registration(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Users users = new Client();

        model.addAttribute("users", users);
        modelAndView.setViewName("inscription");
        return "security/inscription";
    }

    // @GetMapping({"/registration"})
    // public String addUser(Model model){
    //     User user = new User();
    //     model.addAttribute("burger", burger);

    //     return null;

    // }

    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public String createNewUser(@Validated Users users, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Users userExists = userService.findUserByEmail(users.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("inscription");
        } else {
            userService.saveUser(users);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            Role role = userService.findRoleByLibelle("Client");
            users.setRole(role);
            modelAndView.addObject("user", new Client());
            modelAndView.setViewName("inscription");

        }
        return "Security/inscription";
    }


}
