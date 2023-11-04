package iet_gibb_labelcreator.model;

import iet_gibb_labelcreator.property.Property;

import java.util.List;

/**
 * Die Class Pelletsheizung mit den Attributen, Methoden und Getter/Setter.
 @author     Lorin Baumann
 @version    2023.2.2
 @since      07.09.2023
 */

public class Pelletsheizung extends Heizung{

    /**
     * Konstruktor für das Object Pelletsheizung. Dazu wird der Input validiert und wenn der Input richtig ist, wird die Umrechnung gestartet.
     * @param kWh
     */
    public Pelletsheizung(Integer kWh){
        super(kWh);
        if (validation()){
            umrechnung();
        }else {
            System.out.println("Wrong Input");
        }
    }


    /**
     * Setzt die Properties für die View. Die Properties sind alle Werte die die Heizung hat.
     * @return properties
     */
    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();
        return properties;
    }

    /**
     * Setzt den Titel der Heizung.
     * @return "Pelletheizung"
     */
    @Override
    public String getTitle() {
        return "Pelletheizung";
    }

    /**
     * Mit den vorhanden Werten, werden die weiteren Attribute berechnet und abgefüllt.
     */
    public void umrechnung(){
        setKg(getkWh()/4.8);
        setM3(getKg()/650);
    }

    /**
     * Validiert denn Input. Generel wird immer überprüft ob der Input null ist, aber man kann noch weitere Bedingungen hinzufügen
     * @return boolean
     */

    public boolean validation(){
        return true;
    }


    /**
     * Gibt ein String zurück mit allen Attributen. Aufbau = titel: attributname + attributwert
     * @return String
     */
    @Override
    public String toString(){
        return "Pelletsheizung"+"\n"+
                " Kg: "+ getKg() + "\n"+
                " kWh: "+ getkWh() + "\n"+
                " m3: "+ getM3() + "\n";
    }


}
