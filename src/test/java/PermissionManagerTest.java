import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermissionManagerTest extends PermissionManager {
    PermissionManager pManager;

    @BeforeEach
    void setUp(){
        pManager = new PermissionManager();
    }

    @Test
    void testGetPermissionLevel() {
        assertEquals("User", pManager.getPermissionLevel());
    }

    @Test
    void testSetPermissionLevelDeveloper() {
        pManager.setPermissionLevel(PermissionLevel.DEVELOPER);
        assertEquals("Developer", pManager.getPermissionLevel());
    }

    @Test
    void testSetPermissionLevelAdmin() {
        pManager.setPermissionLevel(PermissionLevel.ADMIN);
        assertEquals("Admin", pManager.getPermissionLevel());
    }

    @Test
    void testSetPermissionLevelUser() {
        pManager.setPermissionLevel(PermissionLevel.USER);
        assertEquals("User", pManager.getPermissionLevel());
    }

}