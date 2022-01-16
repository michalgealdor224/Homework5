import java.util.Date;

public class Client  {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean vip;
    private int amountOfBuys;
    private float sumOfBuys;
    private Date lastBuy;
    private String typeOfUser;

    public void setLastBuy(Date lastBuy) {
        this.lastBuy = lastBuy;
    }

    public Date getLastBuy() {
        return lastBuy;
    }

    public Client (String firstName, String typeOfUser, String lastName, String userName, String password, boolean vip, int amountOfBuys, float sumOfBuys, Date lastBuy) {
        this.firstName = firstName;
        this.lastName= lastName;
        this.userName= userName;
        this.password= password;
        this.vip= vip;
        this.amountOfBuys = amountOfBuys;
        this.sumOfBuys= sumOfBuys;
        this.lastBuy = lastBuy;
        this.typeOfUser= typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    @Override
    public String toString() {
        if (vip) {
            return  firstName + " " + lastName +  " " + "vip" + "\n"+
                    " amountOfBuys:" + amountOfBuys + "\n"+
                    "sumOfBuys:" + sumOfBuys +"\n"+
                    "lastBuy:" + lastBuy;
        }
        else  {
            return  firstName + " " + lastName +  " " + "\n"+
                    " amountOfBuys:" + amountOfBuys + "\n"+
                    "sumOfBuys:" + sumOfBuys +"\n"+
                    "lastBuy:" + lastBuy;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getSumOfBuys() {
        return sumOfBuys;
    }

    public void setSumOfBuys(float sumOfBuys) {
        this.sumOfBuys = sumOfBuys;
    }

    public double getAmountOfBuys() {
        return amountOfBuys;
    }

    public void setAmountOfBuys(int amountOfBuys) {
        this.amountOfBuys = amountOfBuys;
    }

    public Boolean getVip() {
        return vip;
    }


}
