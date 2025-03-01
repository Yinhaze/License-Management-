
import java.io.Serializable;

public class Userimpletment {

    public class User implements Serializable {
        protected String userID;
        protected String name;
        protected String role; // "admin" or "normal"
        protected String email;
        protected String citizenshipNumber;
        protected String password;

        public User(String userID, String name, String role, String email, String citizenshipNumber, String password) {
            this.userID = userID;
            this.name = name;
            this.role = role;
            this.email = email;
            this.citizenshipNumber = citizenshipNumber;
            this.password = password;
        }

        // Getters
        public String getUserID() { return userID; }
        public String getRole() { return role; }
        public String getEmail() { return email; }
        public String getName() { return name; }
        public String getCitizenshipNumber() {
            return citizenshipNumber;
        }
    }
}
