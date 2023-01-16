public class tryIt {
  public static void main(String[] args) {
    ElectricVehicle ev = new ElectricVehicle("Tesla", 75, 0.5, 3.5);
    System.out.println(ev.range());
    ev.updateEfficiency(0);
    System.out.println(ev.range());
  }
}
