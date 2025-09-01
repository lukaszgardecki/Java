public class CheckboxButton extends Button {
  private final ButtonSize sizeButton;

  public CheckboxButton(ButtonSize sizeButton) {
    this.sizeButton = sizeButton;
  }

  public void draw() {
    sizeButton.setSize();
    System.out.println("Drawing a checkbox button.\n");
  }

}
