//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


package ma.fstt.model;


public class Livreur {
    private Long id_livreur;
    private String nom;
    private String telephone;
    private String vehicule;


    public Livreur() {
    }


    public Livreur(Long id_livreur, String nom, String telephone, String vehicule) {
        this.id_livreur = id_livreur;
        this.nom = nom;
        this.telephone = telephone;
        this.vehicule = vehicule;
    }


    public Long getId_livreur() {
        return this.id_livreur;
    }


    public void setId_livreur(Long id_livreur) {
        this.id_livreur = id_livreur;
    }


    public String getNom() {
        return this.nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getTelephone() {
        return this.telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getVehicule() {
        return this.vehicule;
    }


    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }


    public String toString() {
        return "Livreur{id_livreur=" + this.id_livreur + ", nom='" + this.nom + "', telephone='" + this.telephone + "', vehicule='" + this.vehicule + "'}";
    }
}
