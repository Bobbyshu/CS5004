package Entity;

import java.util.Objects;

/**
 * abstract class of shape.
 */
public abstract class AbstractShape implements IShape {
  protected String name;
  protected Coordinate coordinate;
  protected Color color;

  /**
   * constructor of abstract shape.
   *
   * @param name       name of shape
   * @param coordinate coordinate of shape
   * @param color      color of shape
   * @throws IllegalArgumentException once name or coordinate is null or empty
   */
  public AbstractShape(String name, Coordinate coordinate, Color color)
      throws IllegalArgumentException {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name can't be null or empty");
    }
    if (coordinate == null || color == null) {
      throw new IllegalArgumentException("Coordinate or color can't be null");
    }

    this.name = name;
    this.coordinate = coordinate;
    this.color = color;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Coordinate getCoordinate() {
    return coordinate;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public String getType() {
    return null;
  }

  @Override
  public double[] getPara() {
    return new double[0];
  }

  @Override
  public IShape move(Coordinate target) {
    return null;
  }

  @Override
  public IShape changeColor(Color target) {
    return null;
  }

  @Override
  public IShape resize(double para1, double para2) {
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof AbstractShape)) {
      return false;
    }

    AbstractShape cur = (AbstractShape) obj;
    return name.equals(cur.name)
        && coordinate.equals(cur.coordinate)
        && color.equals(cur.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, coordinate, color);
  }
}
