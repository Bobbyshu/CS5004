import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class testPet {
    private Pet Cat;
    private Pet Dog;

    @Before
    public void setUp() {
        Cat = new Pet("Homer", 5);
        Dog = new Pet("Chester", 6);

    }

    @Test
    public void testGetName() {
        assertEquals("Homer", Cat.getName());
        assertEquals("Chester", Dog.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(5, Cat.getAge());
        assertEquals(6, Dog.getAge());
    }
}
