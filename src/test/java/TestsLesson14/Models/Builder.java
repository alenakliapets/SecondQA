package TestsLesson14.Models;

public class Builder {
    private User newUser;

    public Builder() {
        newUser = new User();
    }

    public Builder withFirstName(String firstName){
        newUser.setFirstname(firstName);
        return this;
    }
    public Builder withLastName(String lastName){
        newUser.setFirstname(lastName);
        return this;
    }

    public Builder withEmailName(String email){
        newUser.setFirstname(email);
        return this;
    }
    public Builder withPasswordName(String password){
        newUser.setFirstname(password);
        return this;
    }
    public User build(){
        return newUser;
    }
}
