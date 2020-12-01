class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        StringBuilder stringBuilder = new StringBuilder();

        if (!"".equals(firstName)) {
            stringBuilder.append(firstName);
            if (!"".equals(lastName)) {
                stringBuilder.append(" ");
            }
        }
        if (!"".equals(lastName)) {
            stringBuilder.append(lastName);
        }
        if ("".equals(firstName) && "".equals(lastName)) {
            stringBuilder.append("Unknown");
        }

        return stringBuilder.toString(); // write your code here
    }
}