package iet_gibb_labelcreator.model;

import iet_gibb_labelcreator.property.Property;

import java.util.List;

/**
     *
 * The Wood Heating class with the attributes, methods and getters/setters.
@author     Lorin Baumann
@version    2023.2.2
@since      07.09.2023
*/
public class Holzheizung extends  Heizung{



    /**
     * Attribut Ster(ster). Type Double weil der Wert mit Division gerechnet wird.
     */
    private Double ster;


    /**
     * Attribut Holzart(holzart).
     */
    private String holzart;

    /**
     * Mit den vorhanden Werten, werden die weiteren Attribute berechnet und abgefüllt. Es wird auch überprüft welcher Holztyp es ist und je nach dem anders berechnet.
     */

    /**
     * Konstruktor für das Object Holzheizung. Dazu wird der Input validiert und wenn der Input richtig ist, wird die Umrechnung gestartet.
     * @param   kWh the kWh that the House need
     * @param   holzart the holzart that, that house use
     */
    public Holzheizung( Integer kWh, String holzart){
        super(kWh);
        this.holzart = holzart;
        if (validation()){
            umrechnung();
        }else {
            System.out.println("Wrong input");
        }
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();
        Property holzart = new Property("Holzart:", getHolzart());
        properties.add(holzart);
        Property ster = new Property("Ster:", Double.toString(getSter()));
        properties.add(ster);
        return properties;
    }
    @Override
    public String getTitle() {
        return "Holzheizung";
    }

    private void umrechnung(){
        setKg(getkWh()/4d);
        if (this.holzart=="Buche"){
            setM3(getKg()/500);
        }else if (this.holzart=="Tanne"){
            setM3(getKg()/400);
        }else {
            setM3(getKg()/425);
        }
        this.ster= getM3()*0.75;
    }

    /**
     * Validiert denn Input. Generel wird immer überprüft ob der Input null ist, aber man kann noch weitere Bedingungen hinzufügen
     * @return boolean
     */
    private boolean validation(){
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
        return "Holzheizung"+"\n"+
                " Holzart: " + holzart + "\n"+
                " Ster: " + ster + "\n"+
                " Kg: "+ getKg() + "\n"+
                " kWh: "+ getkWh() + "\n"+
                " m3: "+ getM3() + "\n";
    }

    public Double getSter() {
        return ster;
    }

    public void setSter(Double ster) {
        this.ster = ster;
    }



    public String getHolzart() {
        return holzart;
    }

    public void setHolzart(String holzart) {
        this.holzart = holzart;
    }
}
