package View;

import Entity.IShape;
import Model.IShapeModel;
import Model.SnapShot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * class for web view.
 */
public class Web {
  private IShapeModel model;
  private List<SnapShot> snapShotList;
  private int width;
  private int height;
  Appendable out;

  /**
   * constructor of web.
   *
   * @param model  input model
   * @param width  width of view
   * @param height height of view
   */
  public Web(IShapeModel model, int width, int height) {
    this.model = model;
    this.snapShotList = model.getSnapShotList();
    this.width = width;
    this.height = height;
    out = new StringBuilder();
  }

  /**
   * append the outside framework
   * and show the web view.
   *
   * @throws IOException once input is null
   */
  public void showImage() throws IOException {
    // append title
    out.append("<!DOCTYPE html>\n")
        .append("<html>\n")
        .append("<body>\n");
    // System.out.println(snapShotList);

    for (SnapShot s : snapShotList) {
      appendSvg(s);
    }

    // append tail
    out.append("</body>\n")
        .append("</html>");
  }

  /**
   * append label into html.
   *
   * @param snapShot input snapshot
   * @throws IOException once input is null
   */
  public void appendSvg(SnapShot snapShot) throws IOException {
    if (snapShot == null) {
      return;
    }
    out.append("<div>\n").append("<svg width=\"").append(String.valueOf(this.width))
        .append("\" height=\"").append(String.valueOf(this.height))
        .append("\" version=\"1.0\"")
        .append(" style =\"border: solid 5px red; background-color:rgb(173,216,230)\">\n");

    // intro info into svg
    List<IShape> shapeList = snapShot.getShapeList();
    if (shapeList == null) {
      return;
    }
    String id = snapShot.getId();
    String desc = snapShot.getDesc();
    for (IShape shape : shapeList) {
      String type = null;
      String label = null;
      if (shape.getType().equals("Rectangle")) {
        type = "rect";
        label = String.format(
            "<%s id=\"%s\" x=\"%.2f\" y=\"%.2f\" "
                + "width=\"%.2f\" height=\"%.2f\" "
                + "fill=\"rgb(%f,%f,%f)\" "
                + "visibility=\"visible\" /> \n",
            type, shape.getName(), shape.getCoordinate().getX(), shape.getCoordinate().getY() + 200,
            shape.getPara()[0], shape.getPara()[1],
            shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB()
        );
      } else if (shape.getType().equals("Oval")) {
        type = "ellipse";
        label = String.format(
            "<%s id=\"%s\" x=\"%.2f\" y=\"%.2f\" "
                + "width=\"%.2f\" height=\"%.2f\" "
                + "fill=\"rgb(%f,%f,%f)\" "
                + "visibility=\"visible\" /> \n",
            type, shape.getName(), shape.getCoordinate().getX(), shape.getCoordinate().getY() + 200,
            shape.getPara()[0] / 2, shape.getPara()[1] / 2,
            shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB()
        );
      }
      out.append(label);
    }
    out.append("<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">")
        .append(id).append("</text>\n");
    out.append("<text x=\"10\" y=\"90\" font-weight=\"bold\" font-size=\"20\">")
        .append("Description: ").append(desc).append("</text>\n");
    out.append("</svg>\n").append("</div>\n").append("<p></p>\n");
  }

  /**
   * save file.
   *
   * @param savePath target save path
   * @throws IOException once input null
   */
  public void saveFile(String savePath) throws IOException {
    FileWriter writer = new FileWriter(savePath);
    writer.write(out.toString());
    writer.flush();
    writer.close();
  }

  public Appendable getOut() {
    return out;
  }
}
