package Controller;

import Model.IShapeModel;
import View.Web;

import java.io.IOException;

/**
 * controller for web view.
 */
public class WebController {
  private IShapeModel model;
  private Web web;
  private String out;

  /**
   * constructor of class.
   *
   * @param model input model
   * @param out   input out string
   */
  public WebController(IShapeModel model, String out) {
    this.model = model;
    this.out = out;
  }

  /**
   * initialize.
   *
   * @param width  window width
   * @param height window height
   * @throws IOException IO
   */
  public void go(int width, int height) throws IOException {
    web = new Web(model, width, height);
    web.showImage();
    web.saveFile(out);
  }
}
