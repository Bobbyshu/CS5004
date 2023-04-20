package photoalbum;

import Controller.GraphicController;
import Controller.ShapeControllerImpl;
import Controller.WebController;
import Controller.fileReader;
import Model.IShapeModel;
import Model.ShapeModel;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * main class.
 */
public class PhotoAlbumMain {
  /**
   * match command line.
   * @param args command line
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    IShapeModel model = new ShapeModel();
    String typeOfView = "";
    String output = "";
    Readable in = new StringReader("");
    int width = 1000;
    int height = 1000;
    for (int i = 0; i < args.length; i ++) {
      if (args[i].equals("-in")) {
        in = new FileReader(args[i + 1]);
      }

      if (args[i].equals("-v") || args[i].equals("-view")) {
        typeOfView = args[i + 1];
      }

      if (args[i].equals("-out")) {
        output = args[i + 1];
      }

      try {
        width = Integer.parseInt(args[i]);
        height = Integer.parseInt(args[i]);
      } catch (Exception ignored) {

      }
    }

    model = fileReader.matchFile(in, new ShapeControllerImpl());

    if (typeOfView.equals("web")) {
      WebController web = new WebController(model, output);
      web.go(width, height);
    } else if (typeOfView.equals("graphical")) {
      GraphicController graphic = new GraphicController(model);
      graphic.go(width, height);
    } else {
      System.out.println("Unexpected error!");
    }
  }
}
