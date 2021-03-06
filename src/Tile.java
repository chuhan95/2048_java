import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The type Tile. It represent each tile in the 2048 game board.
 */
public class Tile extends JPanel implements ITile {
  private JPanel tile;
  private JLabel text;
  private ValueEnum valueEnum;
  private final Font font = new Font("Arial", 1, 30);


  /**
   * Instantiates a new Tile a value enum specified.
   *
   * @param valueEnum the value enum
   */
  public Tile(ValueEnum valueEnum) {
    tile = new JPanel();
    tile.setLayout(new BorderLayout());
    text = new JLabel();
    // Center the text
    text.setHorizontalAlignment(JLabel.CENTER);
    tile.add(text, BorderLayout.CENTER);

    this.valueEnum = valueEnum;
    // Font won't change for all tiles.
    text.setFont(font);
    setTile(valueEnum);

  }

  /**
   * Set the text label for the tile.
   *
   * @param label     JLabel stored in the tile class.
   * @param valueEnum Enum for value.
   */
  private void setLabel(JLabel label, ValueEnum valueEnum) {
    if (valueEnum != ValueEnum.V_0) {
      label.setText(Integer.toString(valueEnum.getValue()));
      label.setForeground(valueEnum.getFontColor());
    } else {
      label.setText("");
    }
  }

  /**
   * Set the tile with value, font color, background colors.
   *
   * @param valueEnum valueEnum for possible value in 2048.
   */
  @Override
  public void setTile(ValueEnum valueEnum) {
    tile.setBackground(valueEnum.getBgColor());
    setLabel(text, valueEnum);
    this.valueEnum = valueEnum;
  }

  /**
   * Getter for the ValueEnum stored in the tile class.
   *
   * @return valueEnum.
   */
  @Override
  public ValueEnum getEnum() {
    return this.valueEnum;
  }

  /**
   * Getter for the JPanel.
   *
   * @return JPanel of the tile.
   */
  @Override
  public JPanel getTile() {
    return this.tile;
  }


  /**
   * Check if this tile is equal to other tile.
   * @param other other tile
   * @return true if equal, false otherwise.
   */
  @Override
  public boolean equals(ITile other) {
    return this.valueEnum == other.getEnum();
  }
}
