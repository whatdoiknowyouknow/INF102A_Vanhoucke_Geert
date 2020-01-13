package be.kdg.examen.klassement.archiefhouders;

import be.kdg.examen.klassement.Archief;
import be.kdg.examen.klassement.archiefstukken.Archiefstuk;
import be.kdg.examen.klassement.archiefstukken.Boek;

import java.util.ArrayList;
import java.util.List;

// gegeven, mag je wijzigen
public class Doos implements ArchiefHouder {

    private static final double LENGTH = 0.305;
    private static final double WIDTH = 0.215;
    private static final double HEIGTH = 0.11;
    private List<Archiefstuk> content;


    public Doos() {
        content = new ArrayList<>();
    }

    @Override
    public double getMaxVolume() {
        return LENGTH * WIDTH * HEIGTH;
    }

    @Override
    public double getFilledPercentage() {
        return (getTotalVolume() / getMaxVolume() * 100);
    }

    public double getTotalVolume() {
        double totalVolume = 0.0;
        for (Archiefstuk temp : content) {
            totalVolume += temp.getSize();
        }
        return totalVolume;
    }

    @Override
    public boolean isFull() {
        if (getFilledPercentage() > 95) {
            return true;
        }
        return false;
    }


    public boolean isEmpty() {

        return content.isEmpty();
    }

    @Override
    public boolean canAccept(Archiefstuk archiefstuk) {
        if ((archiefstuk.getSize() + getTotalVolume()) <= getMaxVolume() && archiefstuk.hoortIn().equals(Soort.DoosType)) {
            return true;
        }
        return false;
    }

    @Override
    public void acceptArchiefstuk(Archiefstuk archiefstuk) {
        if (canAccept(archiefstuk)) {
            content.add(archiefstuk);
        }
    }


    public List<Boek> getBoeken() {
        List<Boek> boeken = new ArrayList<>();
        for (Archiefstuk archiefstuk : content) {
            if (archiefstuk instanceof Boek) {
                boeken.add((Boek) archiefstuk);
            }
        }
        return boeken;
    }


}
