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
    void testSetPermissionLevel() {
        pManager.setPermissionLevel(PermissionLevel.DEVELOPER);
        assertEquals("Developer", pManager.getPermissionLevel());
    }

}