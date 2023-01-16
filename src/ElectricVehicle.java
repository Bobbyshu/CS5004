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
    else it will equal to the max one between given number or 10
     */
    this.batterySize = batterySize > 150 ? 150 : Math.max(batterySize, 10);

    /*
    assign chargeState
    if SOC > 1 it will equal to 1
    else it will equal to the max one between given number or 0.15
     */
    this.stateOfCharge = stateOfCharge > 1 ? 1 : Math.max(stateOfCharge, 0.15);

    /*
    assign defaultEfficiency
    if defaultEfficiency > 4.5 it will equal to 4.5
    else it will equal to the max one between given number or 0.5
     */
    this.defaultEfficiency = defaultEfficiency > 4.5 ? 4.5 : Math.max(defaultEfficiency, 0.5);

    // assign currentEfficiency(rated)
    this.currentEfficiency = this.defaultEfficiency;
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
   * So, we should choose the maximum percent.
   *
   * @param currentTemp the current temperature when driving this car
   */
  public void updateEfficiency(double currentTemp) {
    // avoid Math.max(1 - lostEff, 0.5) increase percent of efficiency
    if (currentTemp < 15) {
      this.currentEfficiency *= 0.5;
      return;
    }
    // if currentTemp between [65.0 77.0] we don't need to change currentEfficiency
    if (currentTemp < 65.0) {
      // percent of lost efficiency
      double lostEff = (65.0 - currentTemp) * 0.01;
      double remainEff = Math.max(1 - lostEff, 0.5);
      this.currentEfficiency *= remainEff;
    } else if (currentTemp > 77.0) {    //upper 77.0F -> only 85% efficiency
      this.currentEfficiency *= 0.85;
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
    this.stateOfCharge = stateOfCharge > 1 ? 1 : Math.max(stateOfCharge, 0.15);
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
