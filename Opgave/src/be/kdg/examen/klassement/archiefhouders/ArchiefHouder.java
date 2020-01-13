package be.kdg.examen.klassement.archiefhouders;

import be.kdg.examen.klassement.archiefstukken.Archiefstuk;

// gegeven, mag je wijzigen
public interface ArchiefHouder {

    // gegeven
    enum Soort {
        DoosType, KokerType;
    }

    double getMaxVolume();

    default double getFilledPercentage() {
        return 100;
    }

    boolean isFull();

    default boolean isEmpty(){
        return !isFull();
    }

    void acceptArchiefstuk(Archiefstuk archiefstuk);

    default boolean canAccept(Archiefstuk archiefstuk){
        if (getFilledPercentage() > 95){
            return false;
        }
        return true;
    }

    // hier aanvullen
}


