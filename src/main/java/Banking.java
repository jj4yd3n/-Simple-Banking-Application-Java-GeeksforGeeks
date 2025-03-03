public class Banking {
    private int accountNo;
    private Double balance;
    private Double diff;
    private Double sum;
    private Double recipientBal;

    public Banking(Integer accountNo, Double balance){
        this.balance = balance;
        this.accountNo = accountNo;
    }

    public void setBalance(Double amount){
        this.balance = amount;
    }

    public void transferMoney(){

    }

    public void withdrawBal(Double diff){
        this.diff = diff;
        this.balance = balance - diff;
    }
    public void depositBal(Double sum){
        this.sum = sum;
        this.balance = this.balance + sum;
    }

    public Double getSum(){
        return sum;
    }

    public Double getDiff(){
        return diff;
    }

    public String reportUser(){
        return "Account no. " + accountNo + " has a balance of " + "$" + balance + ".";
    }

    public Double viewBalance(){
        return balance;
    }

}
