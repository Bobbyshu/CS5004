import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Using this class to test methods and variables in class ElectricVehicle.
 */
public class testElectricVehicle {
  private ElectricVehicle tesla;
  private ElectricVehicle ford;
  private ElectricVehicle kia;

  /**
   * Initialize testing object.
   */
  @Before
  public void setUp() {
    // test normal input
    tesla = new ElectricVehicle("Tesla", 75, 0.5, 3.5);
    // test upper boundary input
    ford = new ElectricVehicle("Ford", 151, 1.1, 4.6);
    // test lower boundary input
    kia = new ElectricVehicle("KIA", 9, 0.14, 0.4);
  }

  /**
   * test current Efficiency in 3 intervals
   * Because current efficiency equals to default efficiency
   * before we use updateEfficiency()
   * [0, 0.5) [0.5, 4.5] (4.5, maximum)
   */
  @Test
  public void getEfficiency() {
    assertEquals(3.5, tesla.getEfficiency(), 0);
    assertEquals(4.5, ford.getEfficiency(), 0);
    assertEquals(0.5, kia.getEfficiency(), 0);
  }

  /**
   * test battery size in 3 intervals.
   * [0, 15) [15, 150] (150, maximum)
   */
  @Test
  public void getBatterySize() {
    assertEquals(75, tesla.getBatterySize(), 0);
    assertEquals(150, ford.getBatterySize(), 0);
    assertEquals(10, kia.getBatterySize(), 0);
  }

  /**
   * test state of charge in 3 intervals
   * [0, 0.15) [0.15, 1] (1, maximum)
   */
  @Test
  public void getStateOfCharge() {
    assertEquals(0.5, tesla.getStateOfCharge(), 0);
    assertEquals(1, ford.getStateOfCharge(), 0);
    assertEquals(0.15, kia.getStateOfCharge(), 0);
  }

  /**
   * test car name allocate.
   */
  @Test
  public void getCarName() {
    assertEquals("Tesla", tesla.getName());
    assertEquals("Ford", ford.getName());
    assertEquals("KIA", kia.getName());
  }

  /**
   * test set SOC in 3 intervals
   * [0, 0.15) [0.15, 1] (1, maximum).
   */
  @Test
  public void setStateOfCharge() {
    tesla.setStateOfCharge(1.1);
    assertEquals(1.0, tesla.getStateOfCharge(), 0);
    tesla.setStateOfCharge(0.1);
    assertEquals(0.15, tesla.getStateOfCharge(), 0);
    tesla.setStateOfCharge(0.5);
    assertEquals(0.5, tesla.getStateOfCharge(), 0);
  }

  /**
   * test the validity of range().
   */
  @Test
  public void range() {
    assertEquals(131.25, tesla.range(), 0);
    assertEquals(675, ford.range(), 0);
    assertEquals(0.75, kia.range(), 0);
  }

  /**
   * test the validity of updateEfficiency()
   * by using getEfficiency()(test valid before)
   * test 3 intervals
   * (minimum, 15), [65, 77], (77, maximum).
   */
  @Test
  public void updateEfficiency() {
    // test normal temperature
    tesla.updateEfficiency(75);
    assertEquals(3.5, tesla.getEfficiency(), 0);

    // test lower temperature
    // 0F -> -50% -> 4.5 * (1 - 50%) -> 2.25
    ford.updateEfficiency(0);
    assertEquals(2.25, ford.getEfficiency(), 0);

    // test higher temperature
    // 100F -> -15% -> 0.5 * 0.85 = 0.425
    kia.updateEfficiency(100);
    assertEquals(0.425, kia.getEfficiency(), 0);
  }

  /**
   * test the validity of toString().
   */
  @Test
  public void testToString() {
    assertEquals("Tesla SOC: 50.0% Range (miles): 131.2", tesla.toString());
    assertEquals("Ford SOC: 100.0% Range (miles): 675.0", ford.toString());
    assertEquals("KIA SOC: 15.0% Range (miles): 0.8", kia.toString());
  }
}
