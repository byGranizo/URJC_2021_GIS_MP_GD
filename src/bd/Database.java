package bd;

import java.io.*;

public class Database {
    public static void saveData(Systems object){
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

    public static Systems loadData(){
        FileInputStream fis = null;
        Systems object = null;
        try {
            fis = new FileInputStream("Data.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = (Systems)ois.readObject();
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
        return object;
    }

}
