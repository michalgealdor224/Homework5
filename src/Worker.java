import java.util.Date;

public class Worker extends Client{

    private int rank;
    private String rankOfWorker;
    public static final int REGULAR_WORKER = 1;
    public static final int MANAGER = 2;
    public static final int MANAGEMENT_TEAM = 3;

    public Worker (String firstName,String typeOfUser, String lastName, String userName, String password,
                   boolean vip, int amountOfBuys, int sumOfBuys, Date lastBuy, int rank) {
        super(firstName,typeOfUser, lastName, userName, password,vip, amountOfBuys,sumOfBuys,lastBuy);
        this.rank=rank;
    }

    public int getRank() {
        return rank;
    }


    public void setRank(int rank) {
        this.rank = rank;
    }


    @Override
    public String toString() {
        if (rank==REGULAR_WORKER) {
            rankOfWorker= "regular worker";
        }
        if (rank==MANAGER) {
            rankOfWorker= "manager";
        }
        if (rank == MANAGEMENT_TEAM) {
            rankOfWorker= "management team";
        }
            return super.toString() + " " + "\n" + rankOfWorker;



    }
}
