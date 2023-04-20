package Entity;

import java.util.Objects;

/**
 * attribute coordinate of abstract type class.
 */
public class Coordinate {
  private double x;
  private double y;

  /**
   * constructor of coordinate.
   *
   * @param x x coordinate
   * @param y y coordinate
   */
  public Coordinate(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public String toString() {
    String xIdx = String.format("%.1f", x);
    String yIdx = String.format("%.1f", y);
    return "Min corner: (" + xIdx + "," + yIdx + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Coordinate)) {
      return false;
    }

    Coordinate cur = (Coordinate) obj;
    return x == cur.x && y == cur.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
