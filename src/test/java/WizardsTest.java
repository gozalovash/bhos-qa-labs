import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WizardsTest extends Wizards {

    Wizards wizard;

    @BeforeEach
    void setUp(){
        wizard =  new Wizards();
    }

    @Test
    void testSetwName() {
        wizard.setwName("Hermione");
        assertEquals("Hermione", wizard.getwName());
    }


    @Test
    void testSetwPasswd() {
        wizard.setwPasswd("blabla");
        assertEquals("blabla", wizard.getwPasswd());
    }
}