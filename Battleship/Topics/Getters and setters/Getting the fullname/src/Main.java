class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        if (firstName == null && lastName == null) {
            return "Unknown";
        } else if (firstName == null) {
            return lastName;
        } else if (lastName == null) {
            return firstName;
        } else {
            return firstName + " " + lastName;
        }
    }
}