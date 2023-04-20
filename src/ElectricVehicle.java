import java.text.DecimalFormat;

/**
 * a class that represents a ElectricVehicle including his name, battery Size, State of Charge
 * and default Efficiency. We will calculate his current Efficiency by his current Temperature.
 * This class supplies 4 get methods to know the carName, batterySize, stateOfCharge adn default
 * efficiency, and it also supplies 1 set method to set state of charge.
 * Besides, it has overrided the toString() method and supplies the method range() for calculating
 * range of car and updateEfficiency method to calculate actual efficiency under different Temp.
 */
public class ElectricVehicle {
  private String carName;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private final double defaultEfficiency;
  private final int MaxBattery = 150;
  private final int MinBattery = 10;
  private final double MaxCharge = 1;
  private final double MinCharge = 0.15;
  private final double MaxEff = 4.5;
  private final double MinEff = 0.5;

  /**
   * the constructor of the ElectricVehicle.
   *
   * @param carName           name of the vehicle
   * @param batterySize       size of battery
   * @param stateOfCharge     current state of charge
   * @param defaultEfficiency rated efficiency for car
   */

  public ElectricVehicle(String carName, double batterySize,
                         double stateOfCharge, double defaultEfficiency) {
    // assign carName
    if (carName == null || carName.length() == 0) {
      this.carName = "unknown EV";
    } else {
      this.carName = carName;
    }

    /*
    assign batterySize
    if battery size > 150 it will equal to 150
    else it will equal to the max one for given number or 10
     */
    this.batterySize = generateBatterySize(batterySize);

    /*
    assign chargeState
    if SOC > 1 it will equal to 1
    else it will equal to the max one for given number or 0.15
     */
    this.stateOfCharge = generateCharge(stateOfCharge);

    /*
    assign defaultEfficiency
    if defaultEfficiency > 4.5 it will equal to 4.5
    else it will equal to the max one for given number or 0.5
     */
    this.defaultEfficiency = generateDefaultEff(defaultEfficiency);

    //assign currentEfficiency(rated)
    this.currentEfficiency = this.defaultEfficiency;
  }

  /**
   * rules for clamping batterySize.
   *
   * @param batterySize input number
   * @return actual number after clamping
   */
  private double generateBatterySize(double batterySize) {
    return batterySize > MaxBattery
        ? MaxBattery : Math.max(batterySize, MinBattery);
  }

  /**
   * rules for clamping SOC.
   *
   * @param stateOfCharge input number
   * @return actual number after clamping
   */
  private double generateCharge(double stateOfCharge) {
    return stateOfCharge > MaxCharge
        ? MaxCharge : Math.max(stateOfCharge, MinCharge);
  }

  /**
   * rules for clamping default efficiency.
   *
   * @param defaultEfficiency input number
   * @return actual number after clamping
   */
  private double generateDefaultEff(double defaultEfficiency) {
    return defaultEfficiency > MaxEff
        ? MaxEff : Math.max(defaultEfficiency, MinEff);
  }

  /**
   * This function is to calculate the range for car by his current Efficiency,
   * state of charge and size of battery.
   *
   * @return (double) range for driving
   */
  public double range() {
    return this.currentEfficiency * this.stateOfCharge * this.batterySize;
  }

  /**
   * This function is to calculate the current efficiency
   * if temperature > 77.0F, it will gain 85% default efficiency
   * if 65F <= temperature <= 77F, it will gain 100% efficiency
   * if 15F <= temperature <= 65F, it will decrease the efficiency depends on temperature
   * However, it will gain at least 50% default efficiency
   *
   * @param currentTemp the current temperature when driving this car
   */
  public void updateEfficiency(double currentTemp) {
    // distribute value by different temperature
    if (currentTemp > 77.0) { // (77.0, maximum)
      this.currentEfficiency = 0.85 * this.defaultEfficiency;
    } else if (currentTemp >= 65.0) { // [65.0, 77.0]
      this.currentEfficiency = this.defaultEfficiency;
    } else {
      // set the maximum lostEffi cuz efficiency can't lose over 50%
      double lostEffi = Math.min(65.0 - currentTemp, 50.0);
      this.currentEfficiency = (1.0 - (lostEffi / 100)) * this.defaultEfficiency;
    }
  }

  /**
   * get the default efficiency.
   *
   * @return current efficiency of car
   */
  public double getEfficiency() {
    return this.currentEfficiency;
  }

  /**
   * get the battery size.
   *
   * @return the battery size of car
   */
  public double getBatterySize() {
    return this.batterySize;
  }

  /**
   * get the state of charge.
   *
   * @return the state of charge for car
   */
  public double getStateOfCharge() {
    return this.stateOfCharge;
  }

  /**
   * get the name of car.
   *
   * @return the name of car
   */
  public String getName() {
    return this.carName;
  }

  /**
   * set the default efficiency from external(extends constructor rules).
   */
  public void setStateOfCharge(double stateOfCharge) {
    this.stateOfCharge = stateOfCharge > MaxCharge
        ? MaxCharge : Math.max(stateOfCharge, MinCharge);
  }

  /**
   * modify the specific description for car.
   *
   * @return String for output the information of car
   */
  @Override
  public String toString() {
    // transfer double to format String "0.0%"
    DecimalFormat df = new DecimalFormat("0.0%");
    String outputState = df.format(this.stateOfCharge);
    DecimalFormat df2 = new DecimalFormat("0.0");
    String outputRange = df2.format(range());
    return this.carName + " SOC: " + outputState + " Range (miles): " + outputRange;
  }
}
