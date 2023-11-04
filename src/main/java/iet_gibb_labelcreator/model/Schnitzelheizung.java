package iet_gibb_labelcreator.model;

import iet_gibb_labelcreator.property.Property;

import java.util.List;

/**
 * Die Class Schnitzelheizung mit den Attributen, Methoden und Getter/Setter.
@author     Lorin Baumann
@version    2023.2.2
@since      07.09.2023
*/
public class Schnitzelheizung extends Heizung{

    /**
     * Attribut Holzart(holzart).
     */
    private String holzart;

    /**
     * Konstruktor für das Object Schnitzelheizung. Dazu wird der Input validiert und wenn der Input richtig ist, wird die Umrechnung gestartet.
     * @param kWh
     * @param holzart
     */
    public Schnitzelheizung(Integer kWh, String holzart){
        super(kWh);
        this.holzart = holzart;
        if (validation()){
            umrechnung();
        }
    }

    /**
     * Mit den vorhanden Werten, werden die weiteren Attribute berechnet und abgefüllt. Es wird auch überprüft welcher Holztyp es ist und je nach dem anders berechnet.
     */
    public void umrechnung(){
        setKg(getkWh()/3.5);
        if (getHolzart()=="Buche"){
            setM3(getKg()/280);
        } else if (getHolzart()=="Tanne") {
            setM3(getKg()/230);
        }else {
            setM3(getKg()/250);
        }
    }

    /**
     * Macht die Liste für die Properties. Die werden dann an der View weitergegeben.
     * @return properties
     */
    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();
        Property holzart = new Property("Holzart:", getHolzart());
        properties.add(holzart);
        return properties;
    }

    /**
     * Der Titel von der Heizung
     * @return "Schnitzelheizung"
     */
    @Override
    public String getTitle() {
        return "Schnitzelheizung";
    }

    /**
     * Validiert denn Input. Generel wird immer überprüft ob der Input null ist, aber man kann noch weitere Bedingungen hinzufügen
     * @return boolean
     */
    public boolean validation(){
         if (getHolzart()== null) {
            return false;
        }
        return true;
    }

    /**
     * Gibt ein String zurück mit allen Attributen. Aufbau = titel: attributname + attributwert
     * @return String
     */
    @Override
    public String toString(){
        return "Schnitzelheizung"+"\n"+
                " Holzart: " + holzart + "\n"+
                " Kg: "+ getKg() + "\n"+
                " kWh: "+ getkWh() + "\n"+
                " m3: "+ getM3() + "\n";
    }

    /**
     * Getter für Holzart
     * @return holzart
     */
    public String getHolzart() {
        return holzart;
    }

    /**
     * Setter für Holzart
     * @param holzart
     */
    public void setHolzart(String holzart) {
        this.holzart = holzart;
    }
}
