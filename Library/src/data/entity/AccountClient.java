package data.entity;

public class AccountClient extends Account {
    private AccountClientStatus accountClientStatus;

    public AccountClientStatus getAccountClientStatus() {
        return accountClientStatus;
    }

    public void setAccountClientStatus(AccountClientStatus accountClientStatus) {
        this.accountClientStatus = accountClientStatus;
    }
}
