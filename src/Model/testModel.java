package Model;

/**
 * test model.
 */
public class testModel {
  /**
   * test.
   *
   * @param args
   */
  public static void main(String[] args) {
    // check the output format of instant and format
    // Instant instant = Instant.now();
    // SimpleDateFormat TimeStampFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    // System.out.println(instant);
    // System.out.println(TimeStampFormat1.format(new Date()));

    // check shape model
    ShapeModel s = new ShapeModel();
    s.addShape("R", "Rectangle", 200, 200, 50, 100, 1, 0, 0);
    s.addShape("O", "Oval", 500, 100, 60, 30, 0, 0, 1);
    s.addSnapShot("After first selfie");
    s.addSnapShot("2nd selfie");
    s.printSnapShotList();
    System.out.println(s.printShapeList());
    System.out.println(s.printIdList());
    System.out.println(s.printSnapShotList());
  }
}
