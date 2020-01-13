package be.kdg.examen.klassement.archiefstukken;

import be.kdg.examen.klassement.archiefhouders.ArchiefHouder;

import java.time.LocalDateTime;

// gegeven, mag je wijzigen
public final class Kaart extends Archiefstuk{

    private static final ArchiefHouder.Soort SOORT = ArchiefHouder.Soort.KokerType;

    public Kaart(){
        super(LocalDateTime.now());
    }

    public double getSize(){
        return 0.0;
    }

    @Override
    public ArchiefHouder.Soort hoortIn() {
        return SOORT;
    }
// hier aanvullen
}