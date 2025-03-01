import java.io.Serializable;
public class Application implements Serializable {
        private String applicationID;
        private String userID;
        private String requestedCategory;
        private String status; // "Pending", "Approved", "Rejected"

        public Application(String userID, String requestedCategory) {
            this.applicationID = generateApplicationID();
            this.userID = userID;
            this.requestedCategory = requestedCategory;
            this.status = "Pending";
        }

        private String generateApplicationID() {
            return "APP" + System.currentTimeMillis(); // Unique ID
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUserID() {
            return userID;
        }

        public String getApplicationID() {
            return applicationID;
        }

        public String getRequestedCategory() {
            return requestedCategory;
    }
}
