public class Customer {
    private int customerId;
    private String customerName;
    private int customerContact;
    private String customerNIC;
    private String customerDrvLicId;

    public Customer(int customerId, String customerName, int customerContact, String customerNIC, String customerDrvLicId) {
        setCustomerId(customerId);
        setCustomerName(customerName);
        setCustomerContact(customerContact);
        setCustomerNIC(customerNIC);
        setCustomerDrvLicId(customerDrvLicId);
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerContact() {
        return customerContact;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public String getCustomerDrvLicId() {
        return customerDrvLicId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerContact(int customerContact) {
        this.customerContact = customerContact;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public void setCustomerDrvLicId(String customerDrvLicId) {
        this.customerDrvLicId = customerDrvLicId;
    }
}
