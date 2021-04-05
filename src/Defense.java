public abstract class Defense {
    private int damage;

    public class Shield extends Defense {
        private int energy;

        public Shield (int energy) {
        }
    }

    public class Armor extends Defense {
        private String materialName;
        private int weight;

        public Armor (String materialName, int weight) {
        }
    }

}
