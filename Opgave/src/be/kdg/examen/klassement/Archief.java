package be.kdg.examen.klassement;

import be.kdg.examen.klassement.archiefhouders.ArchiefHouder;
import be.kdg.examen.klassement.archiefhouders.Doos;
import be.kdg.examen.klassement.archiefhouders.Koker;
import be.kdg.examen.klassement.archiefstukken.Archiefstuk;
import be.kdg.examen.klassement.exceptions.ArchiveringsException;

import java.util.*;

// gegeven
public class Archief {

    Map<ArchiefHouder.Soort, List<ArchiefHouder>> archiefHouders;

    private int doosIndex = 0;
    private int kokerIndex = 0;

    // hier aanvullen

    // gegeven mag je wijzigen
    public Archief(int aantalDozen, int aantalKokers) {

        archiefHouders = new HashMap<>();
        archiefHouders.put(ArchiefHouder.Soort.DoosType, new ArrayList<>());
        archiefHouders.put(ArchiefHouder.Soort.KokerType, new ArrayList<>());

        initialiseerArchief(aantalDozen, aantalKokers);
    }

    // gegeven
    private void initialiseerArchief(int aantalDozen, int aantalKokers) {

        for (int i = 0; i < aantalDozen; i++) {
            archiefHouders.get(ArchiefHouder.Soort.DoosType).add(new Doos());
        }

        for (int i = 0; i < aantalKokers; i++) {
            archiefHouders.get(ArchiefHouder.Soort.KokerType).add(new Koker());
        }
    }

    // gegeven
    public void stockeer(Archiefstuk archiefstuk) {

        ArchiefHouder houder = bepaalHouder(archiefstuk);
        houder.acceptArchiefstuk(archiefstuk);

    }

    // gegeven
    private ArchiefHouder bepaalHouder(Archiefstuk archiefstuk) {
        // gegeven
        List<ArchiefHouder> houders;
        ArchiefHouder houder = null;


        // archiefstuk hoort in koker
        if (archiefstuk.hoortIn().equals(ArchiefHouder.Soort.KokerType)) {

            houders = archiefHouders.get(ArchiefHouder.Soort.KokerType);

            if (kokerIndex > (houders.size() - 1)) {
                throw new ArchiveringsException("Archief: geen kokers meer beschikbaar");
            }

            houder = houders.get(kokerIndex);
            kokerIndex++;
        }


        // archiefstuk hoort in doos
        if (archiefstuk.hoortIn().equals(ArchiefHouder.Soort.DoosType)) {

            houders = archiefHouders.get(ArchiefHouder.Soort.DoosType);

            if (houders.size() == 0) {
                throw new ArchiveringsException("Geen dozen beschikbaar");
            }

            if (!houders.get(doosIndex).canAccept(archiefstuk)) {    // huidige doos is vol
                doosIndex++;
            }

            if (doosIndex > houders.size() - 1) {
                throw new ArchiveringsException("Archief: geen dozen meer beschikbaar");
            }

            houder = houders.get(doosIndex);

        }

        return houder;
    }

    // gegeven
    public List<Archiefstuk> getSorteerdeBoeken() {


        List<ArchiefHouder> houders = archiefHouders.get(ArchiefHouder.Soort.DoosType);
        List<Archiefstuk> alleBoeken = new ArrayList<>();

        for (ArchiefHouder houder : houders) {
            Doos doos = (Doos) houder;
            alleBoeken.addAll(doos.getBoeken());
        }

        Collections.sort(alleBoeken);
        return alleBoeken;
    }

    private Inventaris getInventaris() {


        List<ArchiefHouder> houders = archiefHouders.get(ArchiefHouder.Soort.DoosType);

        int temp = doosIndex + 1;

        if (!houders.isEmpty()) {
            if (houders.get(0).isEmpty()) {
                temp = 0;   // first 'Doos' in archive is empty (thus normally all are empty, none are used)
            }
        } else {
            temp = 0;  // there are no 'Doos' in archive
        }

        // doosIndex always points to the doos which was last used (and which will be used next time too if not full). Default value is zero. If it is zero, it can mean we used 1 doos, or that we used 0 doos, and it's still empty.
        // Kokerindex always points to the koker which will be used next time.

        Inventaris inventaris = new Inventaris(temp, kokerIndex);
        return inventaris;
    }


    private class Inventaris {

        private int gebruikteDozen;
        private int gebruikteKokers;

        private Inventaris(int gebruikteDozen, int gebruikteKokers) {
            this.gebruikteDozen = gebruikteDozen;
            this.gebruikteKokers = gebruikteKokers;
        }

        @Override
        public String toString() {
            return "Aantal gebruikte dozen: " + gebruikteDozen + "\nAantal gebruikte kokers: " + gebruikteKokers;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Inhoud archief: \n");

        Inventaris inventaris = getInventaris();
        sb.append(inventaris.toString() + "\n");

        for (Archiefstuk temp : getSorteerdeBoeken()) {
            sb.append(temp.toString() + "\n");
        }

        return sb.toString();
    }


}
