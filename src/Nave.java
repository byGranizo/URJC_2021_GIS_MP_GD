public abstract class Nave {

    private String NumRegistro;
    // private Propietario;
    // private Propulsor;
    private int NumTripulantes;

    public String getNumRegistro() {
        return NumRegistro;
    }

    public int getNumTripulantes() {
        return NumTripulantes;
    }

    public void setNumRegistro(String numRegistro) {
        NumRegistro = numRegistro;
    }

    public void setNumTripulantes(int numTripulantes) {
        NumTripulantes = numTripulantes;
    }
}
