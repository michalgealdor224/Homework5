import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        main();

    }

    public static final int CREATE_ACCOUNT = 1;
    public static final int LOGIN = 2;
    public static final int PRINT_LIST_CLIENTS = 1;
    public static final int PRINT_LIST_CLIENT_VIP = 2;
    public static final int PRINT_LIST_WHO_BUY = 3;
    public static final int PRINT_CLIENT_WITH_HIGHEST_SUM = 4;
    public static final int ADD_PRODUCT = 5;
    public static final int CHANGE_STATUS_OF_PRODUCT = 6;
    public static final int FOR_BUY = 7;
    public static final int LOG_OUT = 8;
    public static final int FINISH = 3;



    public static void main() {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        int choiceOfUser = 0;
        int choiceOfWorker = 0;
        while (choiceOfUser != FINISH) {
            System.out.println("""
                    enter 1 - create new account
                    2- for login
                    3- for exit""");
            choiceOfUser = scanner.nextInt();
            if (choiceOfUser == CREATE_ACCOUNT) {
                shop.createUser();
            }
            if (choiceOfUser == LOGIN) {
                Client p1 = shop.login();
                do {
                    if (Objects.equals(p1.getTypeOfUser(), "worker")) {
                        System.out.println("""
                                enter 1- for print a list of all clients
                                2- for print list of clients in the vip
                                3- for print list of clint who did at least one buy
                                4- for print the clint with the highest sum of buys
                                5- for add new product to the shop
                                6- for change status stock of product
                                7- for buying
                                8- for log out""");
                        choiceOfWorker = scanner.nextInt();
                        if (choiceOfWorker == PRINT_LIST_CLIENTS) {
                            shop.printAllClients();
                        }
                        if (choiceOfWorker == PRINT_LIST_CLIENT_VIP) {
                            shop.printVipClients();
                        }
                        if (choiceOfWorker == PRINT_LIST_WHO_BUY) {
                            shop.printClientsWhoBuy();
                        }
                        if (choiceOfWorker == PRINT_CLIENT_WITH_HIGHEST_SUM) {
                            shop.printClientWithHighestSumOfBuys();
                        }
                        if (choiceOfWorker == ADD_PRODUCT) {
                            shop.addNewProduct();
                        }
                        if (choiceOfWorker == CHANGE_STATUS_OF_PRODUCT) {
                            shop.changeStatusOfProductStock();
                        }
                        if (choiceOfWorker == FOR_BUY) {
                            shop.buy(p1);
                        }
                    }
                } while (choiceOfWorker != LOG_OUT);

                if (Objects.equals(p1.getTypeOfUser(), "client")) {
                    shop.buy(p1);
                }

            }

        }
    }
}
