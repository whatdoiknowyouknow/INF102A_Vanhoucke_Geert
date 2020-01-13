package be.kdg.examen.klassement.archiefstukken;

import be.kdg.examen.klassement.archiefhouders.ArchiefHouder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.Math;


// gegeven, mag je wijzigen
public final class Boek extends Archiefstuk {


    private int numOfPages;
    private double height;

    private static final double LENGTH = 0.29;
    private static final double WIDTH = 0.21;
    private static double PAGE_THICKNESS = 0.00004; // ik heb de paginadikte realistischer gemaakt dan in de opgave, waardoor er ook geen boeken zijn van bijna 1/3 van een m³
    private static double COVER_THICKNESS = 0.0006;
    private static final ArchiefHouder.Soort SOORT = ArchiefHouder.Soort.DoosType;


    public Boek(){
        super(LocalDateTime.now());
        this.numOfPages = (int) (Math.random()*1009) + 10;
        this.height = numOfPages * PAGE_THICKNESS + (2.0*COVER_THICKNESS);
    }

    public double getSize(){
        return LENGTH*WIDTH*height;
    }

    @java.lang.Override
    public java.lang.String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = getArchiveringsDatum().format(formatter);
        return "boek ("+ formatDateTime + ", " + numOfPages + "p, " + Math.round(this.getSize()*10000)/10000d + "m³)";
    }

    @Override
    public ArchiefHouder.Soort hoortIn() {
        return SOORT;
    }

    @Override
    public int compareTo(Archiefstuk a) {
        return Double.compare(this.getSize(), a.getSize());
    }


}
