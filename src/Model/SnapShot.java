package Model;

import Entity.IShape;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Snapshot class which replaces the homework-8 idToShape Map.
 */
public class SnapShot {
  private List<IShape> shapeList;
  private String id;
  private String desc;

  /**
   * constructor of snapshot.
   *
   * @param shapeList list of shape in current snapshot
   * @param id        id of snapshot
   * @param desc      description of snapshot
   */
  public SnapShot(List<IShape> shapeList, String id, String desc) {
    if (desc == null) {
      desc = "";
    }
    this.shapeList = shapeList;
    this.id = id;
    this.desc = desc;
  }

  public List<IShape> getShapeList() {
    return shapeList;
  }

  public String getId() {
    return id;
  }

  public String getDesc() {
    return desc;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");

    // append id
    sb.append("Snapshot ID: ");
    sb.append(id).append("\n");

    // append timestamp
    SimpleDateFormat stampFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    sb.append("Timestamp: ");
    sb.append(stampFormat.format(new Date())).append("\n");

    // append description
    sb.append("Description: ");
    sb.append(desc).append("\n");

    // append shape
    sb.append("Shape Information:").append("\n");
    for (IShape shape : shapeList) {
      sb.append(shape.toString()).append("\n\n");
    }

    return sb.toString();
  }
}
