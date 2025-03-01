
    public class Admin extends User {
        public Admin(String userID, String name, String email, String citizenshipNumber, String password) {
            super(userID, name, "admin", email, citizenshipNumber, password);
        }

        public void approveApplication(Application application) {
            application.setStatus("Approved");
            System.out.println("Application approved for user: " + application.getUserID());
        }

        public void rejectApplication(Application application) {
            application.setStatus("Rejected");
            System.out.println("Application rejected for user: " + application.getUserID());
        }

        public void generateReport() {
            // Logic to generate reports
            System.out.println("Generating report...");
        }
    }

