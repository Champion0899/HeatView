package iet_gibb_labelcreator.model;

import iet_gibb_labelcreator.property.InterfaceHeizung;
import iet_gibb_labelcreator.property.Property;

import java.util.ArrayList;
import java.util.List;

public abstract class Heizung implements InterfaceHeizung {

    /**
     * Attribut Kubikmeter(m3). Type Double weil der Wert mit Division gerechnet wird.
     */
    private Double m3;

    /**
     * Attribut Kilowattstunde(kWh).
     */
    private Integer kWh;

    /**
     * Attribut Kilogramm(kg). Type Double weil der Wert mit Division gerechnet wird.
     */
    private Double kg;

    public Heizung (Integer kWh){
        checkKWhValue(kWh);
    }

    protected void checkKWhValue(Integer kWh){
        if (kWh <200000 && kWh >0){
            this.kWh = kWh;
        }else {
            throw new IllegalArgumentException("Die Kilowatt pro Stunde darf maximal 20000 und minimal 0 sein.");
        }
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();
        Property kWh = new Property("KWh:", Integer.toString(getkWh()));
        properties.add(kWh);
        Property m3 = new Property("Qubik Meter:", Double.toString(getM3()));
        properties.add(m3);
        Property kg = new Property("Kilogramm:", Double.toString(getKg()));
        properties.add(kg);
        return properties;
    }



    public Double getM3() {
        return m3;
    }

    public void setM3(Double m3) {
        this.m3 = m3;
    }

    public Integer getkWh() {
        return kWh;
    }

    public void setkWh(Integer kWh) {
        checkKWhValue(kWh);
    }

    public Double getKg() {
        return kg;
    }

    public void setKg(Double kg) {
        this.kg = kg;
    }
}
