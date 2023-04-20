package Controller;

import Model.IShapeModel;
import Model.ShapeModel;

/**
 * implement class for shape builder interface.
 */
public class ShapeControllerImpl implements ShapeController<IShapeModel> {
  private IShapeModel model = new ShapeModel();

  @Override
  public IShapeModel initialize() {
    return model;
  }

  @Override
  public ShapeController<IShapeModel> createShape(String name, String type, int XCord, int YCord,
                                                  int para1, int para2, int r, int g, int b) {
    model.addShape(name, type, XCord, YCord, para1, para2, r, g, b);
    return this;
  }

  @Override
  public ShapeController<IShapeModel> moveShape(String name, int XCord, int YCord) {
    model.changeCoordinate(name, XCord, YCord);
    return this;
  }

  @Override
  public ShapeController<IShapeModel> removeShape(String name) {
    model.removeShape(name);
    return this;
  }

  @Override
  public ShapeController<IShapeModel> resizeShape(String name, int para1, int para2) {
    model.resize(name, para1, para2);
    return this;
  }

  @Override
  public ShapeController<IShapeModel> changeShapeColor(String name, int r, int g, int b) {
    model.changeColor(name, r, g, b);
    return this;
  }

  @Override
  public ShapeController<IShapeModel> snapShot(String desc) {
    model.addSnapShot(desc);
    return this;
  }
}
