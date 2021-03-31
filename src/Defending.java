public class Defense extends Ship {
    private int daño;

    private class Shield extends Defense {
        private int energy;

        public Shield (int energy) {
        }
    }

    private class Armor extends Defense {
        private String materialName;
        private int weight;

        public Armor (String materialName, int weight) {
        }
    }

}
