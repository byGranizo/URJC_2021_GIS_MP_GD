package Database;

import org.junit.jupiter.api.Test;

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
        Database.loadData();
        
    }

    @Test
    void existsData() {
        boolean existFile = Database.existsData();
        assertFalse(existFile);
    }
}