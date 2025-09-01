public class Canvas {

  public static void main(String[] args) {

    CheckboxButton checkboxButton = new CheckboxButton(new SmallSizeButton());
    checkboxButton.draw();

    RadioButton radioButton = new RadioButton(new MediumSizeButton());
    radioButton.draw();

    DropdownButton dropdownButton = new DropdownButton(new LargeSizeButton());
    dropdownButton.draw();


  }

}
