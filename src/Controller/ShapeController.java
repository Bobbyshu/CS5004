package Controller;

/**
 * interface for shape create and move.
 *
 * @param <T> generic type
 */
public interface ShapeController<T> {
  /**
   * build model.
   *
   * @return generic type
   */
  public T initialize();

  /**
   * create shape based on input type.
   *
   * @param name  name of shape
   * @param type  type of shape
   * @param XCord x-cord for min corner of shape
   * @param YCord y-cord for min corner of shape
   * @param para1 size parameter1
   * @param para2 size parameter2
   * @param r     red parameter
   * @param g     green parameter
   * @param b     blue parameter
   * @return new collection after creating
   */
  public ShapeController<T> createShape(String name, String type, int XCord, int YCord,
                                        int para1, int para2, int r, int g, int b);

  /**
   * move shape to new coordinate.
   *
   * @param name  name of moved shape
   * @param XCord x-cord for target position
   * @param YCord y-cord for target position
   * @return new collection after moving
   */
  public ShapeController<T> moveShape(String name, int XCord, int YCord);

  /**
   * remove target shape.
   *
   * @param name name of removed one
   * @return new collection after removing
   */
  public ShapeController<T> removeShape(String name);

  /**
   * resize target shape.
   *
   * @param name  name of resized one
   * @param para1 resize parameter1
   * @param para2 resize parameter2
   * @return new collection after resizing
   */
  public ShapeController<T> resizeShape(String name, int para1, int para2);

  /**
   * change color of target shape.
   *
   * @param name name of changed color one
   * @param r    red para for new color
   * @param g    green para for new color
   * @param b    blue para for new color
   * @return new collection after changing color
   */
  public ShapeController<T> changeShapeColor(String name, int r, int g, int b);

  /**
   * snapshot current shape with inputted description.
   *
   * @param desc description
   * @return collection of shape
   */
  public ShapeController<T> snapShot(String desc);
}
