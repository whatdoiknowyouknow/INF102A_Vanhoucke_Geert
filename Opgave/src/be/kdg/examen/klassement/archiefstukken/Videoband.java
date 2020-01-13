package be.kdg.examen.klassement.archiefstukken;

import be.kdg.examen.klassement.archiefhouders.ArchiefHouder;

import java.time.LocalDateTime;

// gegeven, mag je wijzigen
public final class Videoband extends Archiefstuk{

    private static final double LENGTH = 0.187;
    private static final double WIDTH = 0.103;
    private static final double HEIGHT = 0.025;
    private static final ArchiefHouder.Soort SOORT = ArchiefHouder.Soort.DoosType;


    public Videoband(){

        super(LocalDateTime.now());
    }

    public double getSize(){
        return LENGTH*WIDTH*HEIGHT;
    }

    @Override
    public ArchiefHouder.Soort hoortIn() {
        return SOORT;
    }
}
