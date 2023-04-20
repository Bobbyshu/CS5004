package Entity;

import java.util.Objects;

/**
 * attribute color of abstract type class.
 */
public class Color {
  private double r;
  private double g;
  private double b;
  private static final int MIN = 0;
  private static final int MAX = 255;

  /**
   * constructor of color.
   *
   * @param r red number
   * @param g green number
   * @param b blue number
   * @throws IllegalArgumentException once r or g or b out of [0, 255]
   */
  public Color(double r, double g, double b) throws IllegalArgumentException {
    if (invalid(r) || invalid(g) || invalid(b)) {
      throw new IllegalArgumentException("The input of RGB must between 0 to 255");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  private boolean invalid(double num) {
    return num < MIN || num > MAX;
  }

  public double getR() {
    return r;
  }

  public double getG() {
    return g;
  }

  public double getB() {
    return b;
  }

  @Override
  public String toString() {
    String red = String.format("%.1f", r);
    String green = String.format("%.1f", g);
    String blue = String.format("%.1f", b);
    return "Color: (" + red + "," + green + "," + blue + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Color)) {
      return false;
    }

    Color cur = (Color) obj;
    return r == cur.r && g == cur.g && b == cur.b;
  }

  @Override
  public int hashCode() {
    return Objects.hash(r, g, b);
  }
}
