import Controller.ShapeControllerImpl;
import Controller.fileReader;
import Model.IShapeModel;
import Model.ShapeModel;
import View.Graphic;
import View.Web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * test demo_input.txt.
 */
public class testDemo {
  /**
   * main test.
   *
   * @param args command line
   * @throws IOException IO
   */
  public static void main(String[] args) throws IOException {
    File file = new File("C:\\Users\\18573\\Desktop\\CSA2022 FALL\\5004\\hw9\\demo_input.txt");
    IShapeModel model = new ShapeModel();
    model = fileReader.matchFile(new BufferedReader(new FileReader(file)),
        new ShapeControllerImpl());


    Graphic graphic = new Graphic(model, 1000, 1000);
    graphic.showImage();

    Web web = new Web(model, 1000, 1000);
    web.showImage();
    web.saveFile("demo_output.html");
  }
}
