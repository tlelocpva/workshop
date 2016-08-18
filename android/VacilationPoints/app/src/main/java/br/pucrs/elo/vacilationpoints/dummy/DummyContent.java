package br.pucrs.elo.vacilationpoints.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        addItem(new DummyItem("Andrei", 35));
        addItem(new DummyItem("Armani", 0));
        addItem(new DummyItem("Bernardo", 2));
        addItem(new DummyItem("Eduardo", 0));
        addItem(new DummyItem("Felipe", 2));
        addItem(new DummyItem("Gabriel", 0));
        addItem(new DummyItem("Geovane", 1));
        addItem(new DummyItem("Hélio", 5));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String name;
        public final int points;

        public DummyItem(String name, int points) {
            this.name = name;
            this.points = points;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
