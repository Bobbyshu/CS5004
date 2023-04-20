package Controller;

import java.util.Objects;
import java.util.Scanner;

/**
 * controller of input command.
 */
public class fileReader {
  /**
   * match file.
   *
   * @param readable   readable content
   * @param controller shape controller
   * @param <T>        model
   * @return model
   */
  public static <T> T matchFile(Readable readable, ShapeController<T> controller) {
    Objects.requireNonNull(readable, "You can't input null file");
    Objects.requireNonNull(controller, "You can't input null controller");

    Scanner scanner = new Scanner(readable);

    while (scanner.hasNextLine()) {
      String eachLine = scanner.nextLine();
      if (eachLine.length() == 0) {
        continue;
      }

      // return two separation
      String[] words = eachLine.split("\\s+", 2);
      // ignore the comment
      if (words[0].equals("#")) {
        continue;
      }
      if (words[0].length() == 0) {
        words = words[1].split("\\s+", 2);
      }
      String action = words[0];

      if (action.equalsIgnoreCase("shape")) {
        createShape(words, controller);
      } else if (action.equalsIgnoreCase("move")) {
        moveShape(words, controller);
      } else if (action.equalsIgnoreCase("remove")) {
        removeShape(words, controller);
      } else if (action.equalsIgnoreCase("resize")) {
        resizeShape(words, controller);
      } else if (action.equalsIgnoreCase("color")) {
        changeShapeColor(words, controller);
      } else if (action.equalsIgnoreCase("snapshot")) {
        snapShot(words, controller);
      } else {
        throw new IllegalStateException("Unexpected error happen!");
      }
    }

    return controller.initialize();
  }

  /**
   * create shape using input command.
   *
   * @param words      command
   * @param controller controller
   * @param <T>        model
   */
  private static <T> void createShape(String[] words, ShapeController<T> controller) {
    words = split(words[1]);
    // no enough elements.
    if (words.length < 9) {
      return;
    }

    // switch para to int
    int[] para = new int[7];
    for (int i = 0; i < 7; i++) {
      para[i] = Integer.parseInt(words[i + 2]);
    }

    // words[0] for name and words[1] for type
    controller.createShape(words[0], words[1], para[0], para[1], para[2], para[3], para[4],
        para[5], para[6]);
  }

  /**
   * move shape using input command.
   *
   * @param words      command
   * @param controller controller
   * @param <T>        model
   */
  private static <T> void moveShape(String[] words, ShapeController<T> controller) {
    words = split(words[1]);
    // no enough elements.
    if (words.length < 3) {
      return;
    }
    // switch para to int
    int[] para = getIntArr(words);

    controller.moveShape(words[0], para[0], para[1]);
  }

  /**
   * remove shape using input command.
   *
   * @param words      command
   * @param controller controller
   * @param <T>        model
   */
  private static <T> void removeShape(String[] words, ShapeController<T> controller) {
    words = split(words[1]);
    controller.removeShape(words[0]);
  }

  /**
   * resize shape using input command.
   *
   * @param words      command
   * @param controller controller
   * @param <T>        model
   */
  private static <T> void resizeShape(String[] words, ShapeController<T> controller) {
    words = split(words[1]);
    // no enough elements.
    if (words.length < 3) {
      return;
    }
    // switch para to int
    int[] para = getIntArr(words);

    controller.resizeShape(words[0], para[0], para[1]);
  }

  /**
   * change shape color using input command.
   *
   * @param words      command
   * @param controller controller
   * @param <T>        model
   */
  private static <T> void changeShapeColor(String[] words, ShapeController<T> controller) {
    words = split(words[1]);
    // no enough elements.
    if (words.length < 4) {
      return;
    }

    // switch para to int
    int[] para = getIntArr(words);
    controller.changeShapeColor(words[0], para[0], para[1], para[2]);
  }

  /**
   * take snapshot using input command.
   *
   * @param words      command
   * @param controller controller
   * @param <T>        model
   */
  private static <T> void snapShot(String[] words, ShapeController<T> controller) {
    // once nothing after snapshot
    String desc = words.length > 1 ? words[1] : null;
    controller.snapShot(desc);
  }

  /**
   * split the command into different parameters.
   *
   * @param words command
   * @return String array
   */
  private static String[] split(String words) {
    return words.split("\\s+");
  }

  /**
   * get int array included parameter.
   *
   * @param words input string command parameter
   * @return int without first name parameter
   */
  private static int[] getIntArr(String[] words) {
    int n = words.length;
    int[] res = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      try {
        res[i] = Integer.parseInt(words[i + 1]);
      } catch (Exception e) {
        throw new NumberFormatException("Parameter invalid(should be number)");
      }
    }
    return res;
  }
}
