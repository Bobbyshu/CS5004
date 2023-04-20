package Entity;

/**
 * interface of iShape.
 */
public interface IShape {
  /**
   * getter for shape name.
   *
   * @return name of shape
   */
  public String getName();

  /**
   * getter for coordinate.
   *
   * @return coordinate of shape
   */
  public Coordinate getCoordinate();

  /**
   * getter for color.
   *
   * @return color of shape
   */
  public Color getColor();

  /**
   * getter for type.
   * @return type of shape
   */
  public String getType();

  /**
   * Get the size array of shape object.
   * @return size array
   */
  public double[] getPara();

  /**
   * move the min corner of shape to new coordinate.
   *
   * @param target coordinate of target corner
   * @return shape with new corner
   */
  IShape move(Coordinate target);

  /**
   * change the color of shape.
   *
   * @param target target color
   * @return shape with new color
   */
  IShape changeColor(Color target);

  /**
   * resize the shape.
   *
   * @param para1 parameter 1 for new size
   * @param para2 parameter 2 for new size
   * @return shape with new size
   */
  IShape resize(double para1, double para2);
}
