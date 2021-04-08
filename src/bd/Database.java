package bd;

import java.io.*;

public class Database {
    public static void saveData(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Data.out");
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(object);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void loadData(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("Data.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = (Videojuego)ois.readObject();
            return object;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
