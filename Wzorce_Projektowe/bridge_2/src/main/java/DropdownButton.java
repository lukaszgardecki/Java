public class DropdownButton extends Button {
  private final ButtonSize sizeButton;

  public DropdownButton(ButtonSize sizeButton) {
    this.sizeButton = sizeButton;
  }

  public void draw() {
    sizeButton.setSize();
    System.out.println("Drawing a dropdown button.\n");
  }

}
