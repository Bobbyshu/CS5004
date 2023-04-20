package Model;

import Entity.IShape;

import java.util.List;

/**
 * interface of IShape (Model level).
 */
public interface IShapeModel {
  /**
   * add snapshot into map based on input description.
   *
   * @param desc input description
   */
  public void addSnapShot(String desc);

  /**
   * add shape into list and two map.
   *
   * @param name  name of shape
   * @param type  type of shape
   * @param cordX x coordinate of shape
   * @param cordY y coordinate of shape
   * @param para1 parameter 1 of shape
   * @param para2 parameter 2 of shape
   * @param r     red number of shape
   * @param g     green number of shape
   * @param b     blue number of shape
   */
  public void addShape(String name, String type, double cordX, double cordY, double para1,
                       double para2, double r, double g, double b);

  /**
   * remove shape based on input name.
   *
   * @param name name of target removed shape
   */
  public void removeShape(String name);

  /**
   * change color of shape based on input name.
   *
   * @param name name of target shape
   * @param r    new red number
   * @param g    new green number
   * @param b    new blue number
   */
  public void changeColor(String name, double r, double g, double b);

  /**
   * change coordinate of shape based on input name.
   *
   * @param name  name of target shape
   * @param cordX new x coordinate
   * @param cordY new y coordinate
   */
  public void changeCoordinate(String name, double cordX, double cordY);

  /**
   * resize shape based on input name.
   *
   * @param name  name of target shape
   * @param para1 parameter 1 for new size
   * @param para2 parameter 2 for new size
   */
  public void resize(String name, double para1, double para2);

  /**
   * reset 3 containers.
   */
  public void reset();

  /**
   * print shape information.
   *
   * @return Shape info
   */
  public String printShapeList();

  /**
   * print each snapshot that stored in list.
   *
   * @return integrated info.
   */
  public String printSnapShotList();

  /**
   * print snap ID that comes from snapshot.
   *
   * @return snap ID string
   */
  public String printIdList();

  /**
   * getter for shape list.
   *
   * @return shape list
   */
  public List<IShape> getShapeList();

  /**
   * getter for list of snapshot.
   *
   * @return snapShot list
   */
  public List<SnapShot> getSnapShotList();
}
