package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * for close listener.
 */
public class MyCloseListener implements ActionListener {
  /**
   * exit button listener.
   *
   * @param e event
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    System.exit(0);
  }
}
