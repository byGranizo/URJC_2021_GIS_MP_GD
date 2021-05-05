package Database;

import org.junit.jupiter.api.Test;
import System.Systems;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void saveData() {
        Database.saveData();
        boolean existFile = Database.existsData();
        assertTrue(existFile);
    }

    @Test
    void loadData() {
        Database.saveData();
        Database.loadData();
        assertNotNull(Systems.getInstance());
    }

    @Test
    void existsData() {
        Database.saveData();
        boolean existFile = Database.existsData();
        assertTrue(existFile);
    }
}