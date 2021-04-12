package models;
import java.io.File;

public interface Notify {
    void update(String eventType, File file);
}
