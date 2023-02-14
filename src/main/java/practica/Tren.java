/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

/**
 *
 * @author jorge
 */
public class Tren {
    
    // Atributos
    private int idTren;
    private int numVagones;
    private int pasaTotales;
    
    // Constructores
    public Tren (){
        
    }
    
    public Tren (int idTren, int numVagones, int pasaTotales){
        this.idTren = idTren;
        this.numVagones = numVagones;
        this.pasaTotales = pasaTotales;
    }
    
    // Getters y setters
    public int getIdTren() {
        return idTren;
    }

    public void setIdTren(int idTren) {
        this.idTren = idTren;
    }

    public int getNumVagones() {
        return numVagones;
    }

    public void setNumVagones(int numVagones) {
        this.numVagones = numVagones;
    }

    public int getPasaTotales() {
        return pasaTotales;
    }

    public void setPasaTotales(int pasaTotales) {
        this.pasaTotales = pasaTotales;
    }
    
    // Método equals y hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idTren;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tren other = (Tren) obj;
        return this.idTren == other.idTren;
    }
    
    // Método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tren{");
        sb.append("idTren=").append(idTren);
        sb.append(", numVagones=").append(numVagones);
        sb.append(", pasaTotales=").append(pasaTotales);
        sb.append('}');
        return sb.toString();
    }
}
