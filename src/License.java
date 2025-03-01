import java.util.Date;
import java.util.Calendar;

    public class License {
        private String licenseID;
        private String category;
        private Date issueDate;
        private Date expiryDate;

        public License(String licenseID, String category, Date issueDate, Date expiryDate) {
            this.licenseID = licenseID;
            this.category = category;
            this.issueDate = issueDate;
            this.expiryDate = expiryDate;
        }

        // Getters
        public String getLicenseID() { return licenseID; }
        public String getCategory() { return category; }
        public Date getIssueDate() { return issueDate; }
        public Date getExpiryDate() { return expiryDate; }

        // Method to renew the license
        public void renew() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(expiryDate);
            calendar.add(Calendar.YEAR, 5); // Extend expiry by 5 years
            this.expiryDate = calendar.getTime();
        }
    }

