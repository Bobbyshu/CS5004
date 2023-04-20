package Entity;

import java.util.Objects;

/**
 * concrete class of rectangle.
 */
public class Rectangle extends AbstractShape {
  private double width;
  private double height;

  /**
   * constructor of rectangle.
   *
   * @param name       name of rectangle
   * @param coordinate coordinate rectangle
   * @param color      color of rectangle
   * @param width      width rectangle
   * @param height     height rectangle
   * @throws IllegalArgumentException once name or coordinate is null or empty
   */
  public Rectangle(String name, Coordinate coordinate, Color color, double width, double height)
      throws IllegalArgumentException {
    super(name, coordinate, color);
    this.width = width;
    this.height = height;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public String getType() {
    return "Rectangle";
  }

  @Override
  public double[] getPara() {
    return new double[]{width, height};
  }

  @Override
  public IShape move(Coordinate target) {
    return new Rectangle(name, target, color, width, height);
  }

  @Override
  public IShape changeColor(Color target) {
    return new Rectangle(name, coordinate, target, width, height);
  }

  @Override
  public IShape resize(double para1, double para2) {
    return new Rectangle(name, coordinate, color, para1, para2);
  }

  @Override
  public String toString() {
    return "Name: " + name + "\n"
        + "Type: rectangle" + "\n"
        + coordinate.toString()
        + ", " + "Width: " + String.format("%.1f", width)
        + ", " + "Height: " + String.format("%.1f", height)
        + ", " + color.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Rectangle)) {
      return false;
    }

    Rectangle cur = (Rectangle) obj;
    return name.equals(cur.name) && coordinate.equals(cur.coordinate)
        && color.equals(cur.color) && width == cur.width && height == cur.height;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, coordinate, color, width, height);
  }
}
