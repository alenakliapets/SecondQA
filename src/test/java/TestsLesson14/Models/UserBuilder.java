package TestsLesson14.Models;

public class UserBuilder {
    String firstname;
    String lastname;
    String email;
    boolean emailNotifications;
    String language;
    String password;
    public static class Builder {
        private UserBuilder newUser;

        public Builder() {
            newUser = new UserBuilder();
        }

        public Builder withFirstName(String firstName){
            newUser.firstname = firstName;
            return this;
        }
        public Builder withLastName(String lastName){
            newUser.lastname = lastName;
            return this;
        }

        public Builder withEmailName(String email){
            newUser.email = email;
            return this;
        }
        public Builder withPasswordName(String password){
            newUser.password = password;
            return this;
        }
        public UserBuilder build(){
            return newUser;
        }
    }


}
