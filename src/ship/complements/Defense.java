package ship.complements;

import java.io.Serializable;

public abstract class Defense {
    private int damage;

    public static class Shield extends Defense implements Serializable {
        private int energy;

        public Shield (int energy) {
        }
    }

    public static class Armor extends Defense implements Serializable{
        private String materialName;
        private int weight;

        public Armor (String materialName, int weight) {
        }
    }

}
