package ma.fstt.model;

import java.util.Date;

public class Commande {

    private Long id_com;
        private Date date_deb;
        private Date date_fin;
        private float km;
        private String etat;

        public Commande() {
        }


        public Commande( Long id_com, Date date_deb, Date date_fin,float km,String etat) {
            this. id_com =  id_com;
            this.date_deb = date_deb;
            this.date_fin = date_fin;
            this.km=km;
            this.etat = etat;
        }


        public Long getId_com() {
            return this.id_com;
        }


        public void setId_com(Long id_pro) {
            this.id_com = id_com;
        }


        public Date getDate_deb() {
            return this.date_deb;
        }


        public void setDate_deb(Date lib) {
            this.date_deb = date_deb;
        }


        public Date getDate_fin() {
            return this.date_fin;
        }


        public void setDate_fin(Date date_fin) {
            this.date_fin = date_fin;
        }


        public float getKm() {
            return this.km;
        }


        public void setKm(float km) {
            this.km = km;
        }
        public String getEtat() {
            return this.etat;
        }
        public void setEtat(String etat) {
            this.etat = etat;
        }


        public String toString() {
            return "Commande{id_Commande=" + this.id_com + ", date debut='" + this.date_deb + "', date fin='" + this.date_fin + "', km='" + this.km + "'}"+"etat="+this.etat;
        }


}
