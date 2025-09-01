public class RadioButton extends Button {
  private final ButtonSize sizeButton;

  public RadioButton(ButtonSize sizeButton) {
    this.sizeButton = sizeButton;
  }

  public void draw() {
    sizeButton.setSize();
    System.out.println("Drawing a radio button.\n");
  }

}
