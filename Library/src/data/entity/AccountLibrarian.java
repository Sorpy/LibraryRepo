package data.entity;

public class AccountLibrarian extends Account {
    private AccountLibrarianStatus accountLibrarianStatus;

    public AccountLibrarianStatus getAccountLibrarianStatus() {
        return accountLibrarianStatus;
    }

    public void setAccountLibrarianStatus(AccountLibrarianStatus accountLibrarianStatus) {
        this.accountLibrarianStatus = accountLibrarianStatus;
    }
}
