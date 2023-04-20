package Model;

import Entity.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * shape model implements.
 */
public class ShapeModel implements IShapeModel {
  private List<IShape> shapeList;
  private List<SnapShot> snapShotList;
  private static final int MIN = 0;
  private static final int MAX = 255;

  /**
   * default constructor to initialize containers.
   */
  public ShapeModel() {
    this.shapeList = new ArrayList<>();
    this.snapShotList = new ArrayList<>();
  }

  @Override
  public void addSnapShot(String desc) {
    Instant snapId = Instant.now();
    // should generate a new one
    // cuz obj pass in value
    snapShotList.add(new SnapShot(new ArrayList<>(shapeList), snapId.toString(), desc));
  }

  @Override
  public void addShape(String name, String type, double cordX, double cordY,
                       double para1, double para2, double r, double g, double b)
      throws IllegalArgumentException {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name can't be null or empty");
    }

    if (type == null || type.length() == 0) {
      throw new IllegalArgumentException("Type can't be null or empty");
    }

    if (!type.equalsIgnoreCase("Oval")
        && !type.equalsIgnoreCase("Rectangle")) {
      throw new IllegalArgumentException("Can only accept Oval or Rectangle now.");
    }

    // check duplicate
    for (IShape shape : shapeList) {
      if (shape.getName().equals(name)) {
        return;
      }
    }

    IShape shape = null;
    Color curColor = new Color(r, g, b);
    Coordinate curCord = new Coordinate(cordX, cordY);
    if (type.equalsIgnoreCase("Rectangle")) {
      shape = new Rectangle(name, curCord, curColor, para1, para2);
    } else if (type.equalsIgnoreCase("Oval")) {
      shape = new Oval(name, curCord, curColor, para1, para2);
    }

    shapeList.add(shape);
  }

  @Override
  public void removeShape(String name) throws IllegalArgumentException {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name can't be null or empty");
    }

    for (IShape shape : shapeList) {
      if (shape.getName().equals(name)) {
        shapeList.remove(shape);
        return;
      }
    }

  }


  @Override
  public void changeColor(String name, double r, double g, double b)
      throws IllegalArgumentException {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name can't be null or empty");
    }
    if (invalid(r) || invalid(g) || invalid(b)) {
      throw new IllegalArgumentException("The input of RGB must between 0 to 255");
    }

    for (int i = 0; i < shapeList.size(); ++i) {
      if (shapeList.get(i) != null && shapeList.get(i).getName().equals(name)) {
        shapeList.set(i, shapeList.get(i).changeColor(new Color(r, g, b)));
        return;
      }
    }

  }

  private boolean invalid(double num) {
    return num < MIN || num > MAX;
  }

  @Override
  public void changeCoordinate(String name, double cordX, double cordY)
      throws IllegalArgumentException {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name can't be null or empty");
    }

    for (int i = 0; i < shapeList.size(); ++i) {
      if (shapeList.get(i) != null && shapeList.get(i).getName().equals(name)) {
        shapeList.set(i, shapeList.get(i).move(new Coordinate(cordX, cordY)));
        return;
      }
    }
  }

  @Override
  public void resize(String name, double para1, double para2) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name can't be null or empty");
    }

    for (int i = 0; i < shapeList.size(); ++i) {
      if (shapeList.get(i) != null && shapeList.get(i).getName().equals(name)) {
        shapeList.set(i, shapeList.get(i).resize(para1, para2));
        return;
      }
    }
  }

  @Override
  public String printShapeList() {
    StringBuilder sb = new StringBuilder();
    for (IShape s : shapeList) {
      sb.append(s.toString()).append("\n\n");
    }

    return sb.toString();
  }

  @Override
  public String printSnapShotList() {
    StringBuilder sb = new StringBuilder("Printing Snapshots");
    sb.append("\n");
    for (SnapShot s : snapShotList) {
      sb.append(s.toString());
    }
    return sb.toString();
  }

  @Override
  public String printIdList() {
    StringBuilder sb = new StringBuilder("List of SnapShot taken before reset: [");
    for (SnapShot s: snapShotList) {
      sb.append(s.getId()).append(", ");
    }
    // delete " "
    sb.deleteCharAt(sb.length() - 1);
    // set last one comma to right square bracket
    sb.setCharAt(sb.length() - 1, ']');
    return sb.toString();
  }

  @Override
  public void reset() {
    shapeList.clear();
    snapShotList.clear();
  }

  @Override
  public List<IShape> getShapeList() {
    return shapeList;
  }

  public List<SnapShot> getSnapShotList() {
    return snapShotList;
  }
}
