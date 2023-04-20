package Controller;

import Model.IShapeModel;
import View.Graphic;

/**
 * controller for graphic view.
 */
public class GraphicController {
  private IShapeModel model;
  private Graphic graphic;

  /**
   * constructor of class.
   *
   * @param model input model
   */
  public GraphicController(IShapeModel model) {
    this.model = model;
  }

  /**
   * show the graphic image.
   *
   * @param width  width of window
   * @param height height of window
   */
  public void go(int width, int height) {
    graphic = new Graphic(model, width, height);
    graphic.showImage();
  }
}
