package Zad_28_Studenci;

class Student {
    private String firstName;
    private String lastName;
    private String numOfIndex;
    static int num = 0;

    public Student(String firstName, String lastName, String numOfIndex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numOfIndex = numOfIndex;
        num++;
    }

    public static int getNum() {
        return num;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumOfIndex() {
        return numOfIndex;
    }

    public void setNumOfIndex(String numOfIndex) {
        this.numOfIndex = numOfIndex;
    }
}
