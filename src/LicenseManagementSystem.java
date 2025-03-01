
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class LicenseManagementSystem {
        private static Map<String, User> users = new HashMap<>();
        private static Map<String, Application> applications = new HashMap<>();
        private static Map<String, License> licenses = new HashMap<>(); // Store licenses
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            while (true) {
                System.out.println("Welcome to the License Management System");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        registerUser();
                        break;
                    case 2:
                        loginUser();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private static void registerUser() {
            System.out.println("Enter User ID:");
            String userID = scanner.nextLine();
            System.out.println("Enter Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Email:");
            String email = scanner.nextLine();
            System.out.println("Enter Citizenship Number:");
            String citizenshipNumber = scanner.nextLine();
            System.out.println("Enter Password:");
            String password = scanner.nextLine();
            System.out.println("Select Role (1 for Normal User, 2 for Admin):");
            int roleChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            User user;
            if (roleChoice == 1) {
                user = new NormalUser(userID, name, email, citizenshipNumber, password);
            } else if (roleChoice == 2) {
                user = new Admin(userID, name, email, citizenshipNumber, password);
            } else {
                System.out.println("Invalid role selected. Registration failed.");
                return;
            }

            users.put(userID, user);
            System.out.println("User  registered successfully!");
        }

        private static void loginUser() {
            System.out.println("Enter User ID:");
            String userID = scanner.nextLine();
            System.out.println("Enter Password:");
            String password = scanner.nextLine();

            User user = users.get(userID);
            if (user != null && user.password.equals(password)) {
                System.out.println("Login successful! Welcome, " + user.getName());
                if (user instanceof Admin) {
                    adminDashboard((Admin) user);
                } else {
                    normalUserDashboard((NormalUser) user);
                }
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }

        private static void adminDashboard(Admin admin) {
            while (true) {
                System.out.println("Admin Dashboard");
                System.out.println("1. Approve Application");
                System.out.println("2. Reject Application");
                System.out.println("3. Generate Report");
                System.out.println("4. Logout");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        approveApplication();
                        break;
                    case 2:
                        rejectApplication();
                        break;
                    case 3:
                        admin.generateReport();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private static void normalUserDashboard(NormalUser user) {
            while (true) {
                System.out.println("Normal User Dashboard");
                System.out.println("1. Apply for License");
                System.out.println("2. Check Application Status");
                System.out.println("3. Renew License");
                System.out.println("4. Logout");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        applyForLicense(user);
                        break;
                    case 2:
                        checkApplicationStatus();
                        break;
                    case 3:
                        renewLicense(user);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private static void applyForLicense(NormalUser user) {
            System.out.println("Enter License Category(A,B or C:");
            String category = scanner.nextLine();
            Application application = user.applyForLicense(category);
            applications.put(application.getApplicationID(), application);
        }

        private static void checkApplicationStatus() {
            System.out.println("Enter Application ID:");
            String applicationID = scanner.nextLine();
            try {
                Application application = applications.get(applicationID);
                if (application != null) {
                    System.out.println("Application Status: " + application.getStatus());
                } else {
                    System.out.println("Application not found.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred while checking the application status: " + e.getMessage());
            }
        }


        private static void renewLicense(NormalUser user) {
            System.out.println("Enter License ID to renew:");
            String licenseID = scanner.nextLine();
            License license = licenses.get(licenseID);
            if (license != null) {
                user.renewLicense(license);
            } else {
                System.out.println("License not found.");
            }
        }

        private static void approveApplication() {
            System.out.println("Enter Application ID to approve:");
            String applicationID = scanner.nextLine();
            Application application = applications.get(applicationID);
            if (application != null) {
                Admin admin = (Admin) users.get(application.getUserID());
                admin.approveApplication(application);
            } else {
                System.out.println("Application not found.");
            }
        }

        private static void rejectApplication() {
            System.out.println("Enter Application ID to reject:");
            String applicationID = scanner.nextLine();
            Application application = applications.get(applicationID);
            if (application != null) {
                Admin admin = (Admin) users.get(application.getUserID());
                admin.rejectApplication(application);
            } else {
                System.out.println("Application not found.");
            }
        }
    }


























