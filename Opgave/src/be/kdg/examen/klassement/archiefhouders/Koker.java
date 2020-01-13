package be.kdg.examen.klassement.archiefhouders;

import be.kdg.examen.klassement.archiefstukken.Archiefstuk;
import be.kdg.examen.klassement.archiefstukken.Kaart;

import java.util.ArrayList;
import java.util.List;

// gegeven, mag je wijzigen
public class Koker implements ArchiefHouder {

    private static final double HEIGTH = 0.45;
    private static final double RADIUS = 0.25;
    private Archiefstuk archiefstuk;
    private boolean isFull = false;

    @Override
    public double getMaxVolume() {
        return (2.0 * Math.PI * RADIUS * RADIUS * HEIGTH);
    }

    @Override
    public boolean isFull() {
        return isFull;
    }

    @Override
    public void acceptArchiefstuk(Archiefstuk archiefstuk) {
        if (archiefstuk.hoortIn().equals(Soort.KokerType) && !isFull()) {
            this.archiefstuk = archiefstuk;
            isFull = true;
        }

    }



}

