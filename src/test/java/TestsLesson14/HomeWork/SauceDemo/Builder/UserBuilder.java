package TestsLesson14.HomeWork.SauceDemo.Builder;

public class UserBuilder {
    String firstname;
    String lastname;
    String postalCode;

    public static class Builder {
        private UserBuilder user;

        public Builder(){
            user = new UserBuilder();
        }
        public Builder withFirstname(String firstname){
            user.firstname = firstname;
            return this;
        }

        public Builder withLastname(String lastname){
            user.lastname = lastname;
            return this;
        }

        public Builder withPostalCode (String postalCode){
            user.postalCode = postalCode;
            return this;
        }
        public UserBuilder build(){
            return user;
        }

    }
}
