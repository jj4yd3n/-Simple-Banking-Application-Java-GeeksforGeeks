public class Banking {
    private int accountNo;
    private Double balance;
    private Double diff;

    public Banking(Integer accountNo, Double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public Double viewBalance(){
        return balance;
    }

    public void setBalance(Double balance){
        this.balance = balance;
    }

    public void withdrawBal(Double diff){
        this.diff = diff;
        this.balance = balance - diff;
    }

    public Double getDiff(){
        return diff;
    }

    public String reportUser(){
        return "Account no. " + accountNo + " has a balance of " + "$" + balance + ".";
    }
}
