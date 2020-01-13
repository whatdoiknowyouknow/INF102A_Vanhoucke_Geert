package be.kdg.examen.test;

import be.kdg.examen.klassement.archiefstukken.Archiefstuk;
import be.kdg.examen.klassement.archiefstukken.Boek;
import be.kdg.examen.klassement.archiefstukken.Kaart;
import be.kdg.examen.klassement.archiefstukken.Videoband;

import java.util.Random;

// heel de klasse is gegeven en moet enkel gebruikt worden
// kan gebruikt worden na vraag 1
public class ArchiefStukGenerator {
    private static Random random = new Random();

    public static Archiefstuk maakRandomArchiefStuk() {

        // haal onderstaande regels uit commentaar na vraag 1
        switch (random.nextInt(3)) {
            case 0:
                return new Boek();
            case 1:
                return new Kaart();
            default:
                return new Videoband();
        }

        // plaats deze regel in commentaar na vraag 1
//        return null;
    }
}
