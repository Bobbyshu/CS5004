package View;


import Entity.IShape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * class of generating panel.
 */
public class GenerateWindow extends JPanel {
  private List<IShape> shapeList;

  /**
   * default constructor.
   */
  public GenerateWindow() {
    super();
    this.setBackground(Color.WHITE);
  }

  /**
   * render shape based on input list.
   *
   * @param shapeList input list
   */
  public void renderShape(List<IShape> shapeList) {
    this.shapeList = shapeList;
    this.repaint();
  }

  /**
   * draw something on JPanel besides background.
   *
   * @param g the <code>Graphics</code> object to protect
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // avoid null pointer
    if (this.shapeList == null) {
      return;
    }

    for (IShape shape : shapeList) {
      g.setColor(new Color((int) shape.getColor().getR(),
          (int) shape.getColor().getG(),
          (int) shape.getColor().getB()));

      if (shape.getType().equals("Oval")) {
        g.fillOval((int) shape.getCoordinate().getX(),
            (int) shape.getCoordinate().getY(),
            (int) shape.getPara()[0], (int) shape.getPara()[1]);
      } else if (shape.getType().equals("Rectangle")) {
        g.fillRect((int) shape.getCoordinate().getX(),
            (int) shape.getCoordinate().getY(),
            (int) shape.getPara()[0], (int) shape.getPara()[1]);
      } else {
        System.out.println("Unexpected error");
      }
    }
  }
}
