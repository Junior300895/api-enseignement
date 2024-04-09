package sn.esp.enseignement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.esp.enseignement.entite.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {

    @Query("SELECT c from Compte c WHERE c.login =:login AND c.mot_de_passe =:mdp")
    Compte findByLoginAndMotdePasse(@Param("login") String login, @Param("mdp") String mdp);
}
