
package com.intiformation.gestionCargaison.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IN-MP-003
 */

@Entity(name = "marchandise")
@Table(name = "marchandises")
@XmlRootElement// annotation JAX_B pour le web service REST
public class Marchandises implements Serializable{

    /*=======================================================================*/
 /*======================== Attributs ====================================*/
 /*=======================================================================*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private long numero;
    @Column(name = "nom")
    private String nom;
    @Column(name = "poids")
    private double poids;
    @Column(name = "volume")
    private double volume;

    /*========================================================================*/
 /*================ association avec la classe Cargaison ===============*/
 /*========================================================================*/
    @ManyToOne
    // coté porter de la clé FK => @JoinColumn
    @JoinColumn(name = "cargaison_id", referencedColumnName = "id_cargaison")
    private Cargaison cargaison;

    public Cargaison getCargaison() {
        return cargaison;
    }

    public void setCargaison(Cargaison cargaison) {
        this.cargaison = cargaison;
    }

    /*========================================================================*/
 /*========================== Constructeurs ===============================*/
 /*========================================================================*/
    public Marchandises() {
    }

    public Marchandises(int numero, String nom, double poids, double volume) {
        this.numero = numero;
        this.nom = nom;
        this.poids = poids;
        this.volume = volume;
    }

    public Marchandises(String nom, double poids, double volume) {
        this.nom = nom;
        this.poids = poids;
        this.volume = volume;
    }

    /*========================================================================*/
 /*========================== Encapsulation ===============================*/
 /*========================================================================*/
    public long getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

}
