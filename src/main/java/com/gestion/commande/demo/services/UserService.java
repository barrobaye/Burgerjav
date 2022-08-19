package com.gestion.commande.demo.services;
import com.gestion.commande.demo.models.Gestionnaire;
import com.gestion.commande.demo.models.Role;
import com.gestion.commande.demo.models.Users;
import com.gestion.commande.demo.repositories.GestionnaireRepository;
import com.gestion.commande.demo.repositories.RoleRepository;
import com.gestion.commande.demo.repositories.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    private GestionnaireRepository gestionnaireRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Gestionnaire findAdminByEmail(String email) {
        return gestionnaireRepository.findByEmail(email);
    }

    public Role findRoleByLibelle(String libelle) {
        return roleRepository.findByLibelle(libelle);
    }

    public Users saveUser(Users users) {
        try {
            userRepository.save(users);
            return users;
        } catch(Exception e) {
            throw e;
        }
    }
}
