package View;

import Model.IShapeModel;
import Model.SnapShot;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * class of view in graphical.
 */
public class Graphic extends JFrame {
  private JPanel console;
  private JPanel top;
  private JLabel snapLabel;
  private IShapeModel model;
  private GenerateWindow window;
  private String[] snapId;
  private List<SnapShot> snapShotList;
  private int idx;

  /**
   * constructor of graphic view.
   *
   * @param model  input model
   * @param width  input width
   * @param height input height
   */
  public Graphic(IShapeModel model, int width, int height) {
    super();
    // initialize
    this.model = model;
    snapShotList = model.getSnapShotList();
    snapId = new String[snapShotList.size()];
    this.idx = 0;
    for (int i = 0; i < snapId.length; ++i) {
      snapId[i] = snapShotList.get(i).getId();
    }

    // initialize window
    this.setSize(width, height);
    // ??? any color?
    this.setBackground(Color.WHITE);
    this.setLayout(new BorderLayout());

    window = new GenerateWindow();
    window.renderShape(snapShotList.get(0).getShapeList());
    this.setPreferredSize(new Dimension(width, height - 200));
    this.add(window, BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // append button into console
    JButton prev = new JButton("<< Prev <<");
    prev.setActionCommand("Prev");
    JButton select = new JButton("^^ Select ^^");
    select.setActionCommand("Select");
    JButton next = new JButton(">> Next >>");
    next.setActionCommand("Next");
    JButton quit = new JButton("xx Quit xx");
    quit.setActionCommand("Quit");

    // bind prev button to listener
    prev.addActionListener(e -> {
      if (idx == 0) { // at first image
        JOptionPane.showMessageDialog(new JFrame(),
            "Start of the photo album. No snapshots to show before this one",
            "Message", JOptionPane.WARNING_MESSAGE);
      } else {
        --idx;
        window.renderShape(snapShotList.get(idx).getShapeList());
        snapLabel.setText("<html><body>" + snapShotList.get(idx).getId() + "<br/>"
            + snapShotList.get(idx).getDesc() + "<body></html>");
      }
    });

    // bind select button to listener
    select.addActionListener(e -> {
      String str = (String) JOptionPane.showInputDialog(null, "Selection",
          "Menu", JOptionPane.PLAIN_MESSAGE, null, snapId, snapId[0]);

      // find selected one
      for (int i = 0; i < snapId.length; ++i) {
        if (snapId[i].equals(str)) {
          idx = i;
        }
      }

      window.renderShape(snapShotList.get(idx).getShapeList());
      snapLabel.setText("<html><body>" + snapShotList.get(idx).getId() + "<br/>"
          + snapShotList.get(idx).getDesc() + "<body></html>");
    });

    // bind next button to listener
    next.addActionListener(e -> {
      if (idx == snapId.length - 1) {
        JOptionPane.showMessageDialog(new JFrame(),
            "End of the photo album. No snapshots to show beyond this one",
            "Message", JOptionPane.WARNING_MESSAGE);
      } else {
        ++idx;
        window.renderShape(snapShotList.get(idx).getShapeList());
        snapLabel.setText("<html><body>" + snapShotList.get(idx).getId() + "<br/>"
            + snapShotList.get(idx).getDesc() + "<body></html>");
      }
    });

    // bind quit button to listener
    quit.addActionListener(new MyCloseListener());

    // generate console
    this.console = new JPanel(new FlowLayout());
    console.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    console.setBackground(Color.orange);
    console.add(prev);
    console.add(select);
    console.add(next);
    console.add(quit);
    // append console to bottom
    this.add(console, BorderLayout.SOUTH);

    // render top
    this.top = new JPanel(new BorderLayout());
    top.setBackground(Color.pink);
    this.snapLabel = new JLabel("<html><body>" + snapShotList.get(idx).getId() + "<br/>"
        + snapShotList.get(idx).getDesc() + "<body></html>");
    top.add(snapLabel, BorderLayout.LINE_START);
    // append top to top
    this.add(top, BorderLayout.NORTH);

    this.pack();
  }

  /**
   * show the graphical view.
   */
  public void showImage() {
    this.setVisible(true);
  }
}
