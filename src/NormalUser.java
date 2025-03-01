import java.util.Date;
public class NormalUser  extends User {
    public NormalUser(String userID, String name, String email, String citizenshipNumber, String password) {
        super(userID, name, "normal", email, citizenshipNumber, password);
    }

    public Application applyForLicense(String requestedCategory) {
        Application application = new Application(this.userID, requestedCategory);
        System.out.println("License application submitted for category: " + requestedCategory);
        return application;
    }

    public String checkStatus(Application application) {
        return application.getStatus();
    }

    public void renewLicense(License license) {
        if (license.getExpiryDate().before(new Date())) { // Check if the license is expired
            license.renew(); // Renew the license
            System.out.println("License " + license.getLicenseID() + " has been renewed successfully. New expiry date: " + license.getExpiryDate());
        } else {
            System.out.println("License " + license.getLicenseID() + " is not expired. No renewal needed.");
        }
    }
}