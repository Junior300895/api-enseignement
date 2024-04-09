package sn.esp.enseignement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.esp.enseignement.dao.CompteRepository;
import sn.esp.enseignement.entite.Compte;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class EnseignementAPI {

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping("/compte/all")
    public ResponseEntity<?> getAllCompte() {
        List<Compte> comptes = compteRepository.findAll();
        return new ResponseEntity<>(comptes, HttpStatus.OK);
    }

    @PostMapping("/compte/verificationUser")
    public ResponseEntity<?> verifierUtilisateur(@RequestBody Compte compte) {
        Compte compteToGet = compteRepository.findByLoginAndMotdePasse(compte.getLogin(), compte.getMot_de_passe());
        if (compteToGet != null) {
            return new ResponseEntity<>(compteToGet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("user non authentifié", HttpStatus.UNAUTHORIZED);
        }

    }
}