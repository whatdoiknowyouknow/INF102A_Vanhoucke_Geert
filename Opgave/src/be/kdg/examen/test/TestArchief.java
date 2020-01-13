package be.kdg.examen.test;

import be.kdg.examen.klassement.Archief;
import be.kdg.examen.klassement.exceptions.ArchiveringsException;

// heel de klasse is gegeven en moet enkel gebruikt worden
// mag je pas gebruiken na het oplossen van Vraag 4 anders geeft het een oneindige loop

public class TestArchief {
    public static void main(String[] args) {

        Archief archief = new Archief(25, 100);

        try {
            while (true) {
                archief.stockeer(ArchiefStukGenerator.maakRandomArchiefStuk());
            }
        } catch (ArchiveringsException exception) {
            System.out.println(exception);
        }
        System.out.println(archief);
    }
}

