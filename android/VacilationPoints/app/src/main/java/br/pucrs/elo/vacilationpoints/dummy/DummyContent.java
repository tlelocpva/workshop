package br.pucrs.elo.vacilationpoints.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.pucrs.elo.vacilationpoints.worker.Vacillation;
import br.pucrs.elo.vacilationpoints.worker.Worker;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (Worker) items.
     */
    //public static final List<DummyItem> ITEMS = new ArrayList<>();
    public static final List<Worker> ITEMS = new ArrayList<>();

    /**
     * A map of sample (Worker) items, by ID.
     */
    public static final Map<String, Worker> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 25;

    static {
        Worker andrei = new Worker(1, "Andrei Martins", "andrei.jpg");
        andrei.addVacillation(new Vacillation("Atraso", "08/08/2016", 1));
        andrei.addVacillation(new Vacillation("Atraso", "10/08/2016", 1));
        andrei.addVacillation(new Vacillation("Atraso", "11/08/2016", 1));
        andrei.addVacillation(new Vacillation("Atraso", "12/08/2016", 2));
        andrei.addVacillation(new Vacillation("Atraso", "17/08/2016", 1));
        andrei.addVacillation(new Vacillation("Atraso", "18/08/2016", 1));
        andrei.addVacillation(new Vacillation("Atraso", "19/08/2016", 1));
        //FOR TEST
        andrei.addVacillation(new Vacillation("Atraso", "11/08/2016", 1));
        andrei.addVacillation(new Vacillation("Atraso", "12/08/2016", 2));
        andrei.addVacillation(new Vacillation("Atraso", "17/08/2016", 1));
        andrei.addVacillation(new Vacillation("Atraso", "18/08/2016", 1));
        andrei.addVacillation(new Vacillation("Atraso", "19/08/2016", 1));

        Worker armani = new Worker(2, "Armani", "armani.jpg");

        Worker bernardo = new Worker(3, "Bernardo Koefender", "bernardo.jpg");
        bernardo.addVacillation(new Vacillation("Atraso", "10/08/2016", 1));
        bernardo.addVacillation(new Vacillation("Atraso", "15/08/2016", 1));

        Worker eduardo = new Worker(4, "Eduardo Lorandi", "lorandi.jpg");

        Worker felipe = new Worker(5, "Felipe Angnes", "felipe.jpg");
        felipe.addVacillation(new Vacillation("Atraso", "12/08/2016", 1));
        felipe.addVacillation(new Vacillation("Atraso", "17/08/2016", 1));

        Worker gabriel = new Worker(6, "Gabriel Chiele", "gabriel.jpg");

        Worker geovane = new Worker(7, "Geovane Wickert", "geovane.jpg");
        geovane.addVacillation(new Vacillation("Atraso", "08/08/2016", 1));

        Worker helio = new Worker(1, "Hélio Fuques", "helio.jpg");
        helio.addVacillation(new Vacillation("Atraso", "09/08/2016", 1));
        helio.addVacillation(new Vacillation("Atraso", "11/08/2016", 1));
        helio.addVacillation(new Vacillation("Atraso", "12/08/2016", 1));
        helio.addVacillation(new Vacillation("Atraso", "15/08/2016", 1));
        helio.addVacillation(new Vacillation("Atraso", "18/08/2016", 1));

        addItem(andrei);
        addItem(armani);
        addItem(bernardo);
        addItem(eduardo);
        addItem(felipe);
        addItem(gabriel);
        addItem(geovane);
        addItem(helio);
    }

    private static void addItem(Worker item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getName(), item);
    }
}
