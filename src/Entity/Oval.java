package Entity;

import java.util.Objects;

/**
 * concrete class of oval.
 */
public class Oval extends AbstractShape {
  private double XRadius;
  private double YRadius;

  /**
   * constructor of oval.
   *
   * @param name       name of oval
   * @param coordinate coordinate of oval
   * @param color      color of oval
   * @param XRadius    XRadius of oval
   * @param YRadius    YRadius of oval
   * @throws IllegalArgumentException once name or coordinate is null or empty
   */
  public Oval(String name, Coordinate coordinate, Color color, double XRadius, double YRadius)
      throws IllegalArgumentException {
    super(name, coordinate, color);
    this.XRadius = XRadius;
    this.YRadius = YRadius;
  }

  public double getXRadius() {
    return XRadius;
  }

  public double getYRadius() {
    return YRadius;
  }

  @Override
  public String getType() {
    return "Oval";
  }

  @Override
  public double[] getPara() {
    return new double[]{XRadius, YRadius};
  }

  @Override
  public IShape move(Coordinate target) {
    return new Oval(name, target, color, XRadius, YRadius);
  }

  @Override
  public IShape changeColor(Color target) {
    return new Oval(name, coordinate, target, XRadius, YRadius);
  }

  @Override
  public IShape resize(double para1, double para2) {
    return new Oval(name, coordinate, color, para1, para2);
  }

  @Override
  public String toString() {
    return "Name: " + name + "\n"
        + "Type: oval" + "\n"
        + coordinate.toString()
        + ", " + "X radius: " + String.format("%.1f", XRadius)
        + ", " + "Y radius:" + String.format("%.1f", YRadius)
        + ", " + color.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Oval)) {
      return false;
    }

    Oval cur = (Oval) obj;
    return name.equals(cur.name) && coordinate.equals(cur.coordinate)
        && color.equals(cur.color) && XRadius == cur.XRadius && YRadius == cur.YRadius;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, coordinate, color, XRadius, YRadius);
  }
}
