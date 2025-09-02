public class Plane {
  private boolean isInTheAir;
  private final int id;

  public Plane(int id) {
    this.id = id;
    isInTheAir = false;
  }

  public boolean getIsInTheAir() {
    return isInTheAir;
  }

  public void setIsInTheAir(boolean isInTheAir) {
    this.isInTheAir = isInTheAir;
  }

  public int getId() {
    return id;
  }
}
