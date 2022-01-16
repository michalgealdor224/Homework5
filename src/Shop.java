import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Shop {
    public static final int WORKER = 1;
    public static final int CLIENT = 2;
    public static final int LENGTH_OF_ARRAY= 0;
    public static final int LENGTH_OF_PASSWORD= 6;
    public static final int MINIMUM_TYPE = 1;
    public static final int MAXIMUM_TYPE = 3;
    public static final int REGULAR_WORKER = 1;
    public static final int MANAGER = 2;
    public static final int MANAGEMENT_TEAM = 3;
    public static final int NO_BUYS= 0;
    public static final int LOCATION_NOT_VALID= 0;
    public static final int MINIMUM_NOT_VALID= -2;
    public static final int FINISH_THE_BUY= -1;
    public static final float DISCOUNT_OF_REGULAR_WORKER= (float) 0.1;
    public static final float DISCOUNT_OF_MANAGER = (float) 0.2;
    public static final float DISCOUNT_OF_MANAGEMENT_TEAM = (float) 0.3;
    public static final int NO_HAVE_PRODUCTS=1;
    public static final int NUMBER_NOT_VALID = 0;
    public static final int HUNDRED=100;
    public static final int ADD_A_PURCHASE =1;
    public static final int NO_HAVE_PRODUCTS_IN_STOCK =0;


    private Client[] clients;
    private Worker [] workers;
    private Product [] products;
    private ShoppingCart [] shoppingCarts;

    public void setProduct (Product[] product) {
        for (int i=0;i< products.length-1; i++) {
            this.products[i] = products[i];
        }
    }

    public Shop() {
       clients = new Client[LENGTH_OF_ARRAY];
       workers= new Worker[LENGTH_OF_ARRAY];
       products= new Product[LENGTH_OF_ARRAY];
       shoppingCarts= new ShoppingCart[LENGTH_OF_ARRAY];
    }

    public Product[] getProducts() {
        return products;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] newClient) {
        for (int i=0; i<clients.length-1;i++) {
            clients[i]= newClient[i];
        }
    }
    public void setWorkers(Worker[] newWorkers) {
        for (int i=0; i<workers.length-1;i++) {
            workers[i] =newWorkers[i];
        }
    }

    public void createUser() {
            Scanner scanner = new Scanner(System.in);
            int typeOfUser;
            boolean isFirstNameValid = true;
            boolean isLastNameValid = true;
            String firstName;
            String lastName;
            String userName;
            String password;
            String whichUser="";
            boolean vip;
            do {
                System.out.println("enter 1- for worker, 2- for client");
                typeOfUser = new Scanner(System.in).nextInt();
            } while (typeOfUser!= CLIENT && typeOfUser != WORKER);
            if (typeOfUser==WORKER) {
                whichUser= "worker";
            }
            if (typeOfUser==CLIENT) {
                whichUser= "client";
            }
            do {
                isFirstNameValid= true;
                System.out.println("enter first name:");
                firstName = new Scanner(System.in).nextLine();
                for (int i = 0; i < firstName.length(); i++) {
                    if (Character.isDigit(firstName.charAt(i))) {
                        isFirstNameValid = false;
                    }
                }
                if (!isFirstNameValid) {
                    System.out.println("the first name is not valid");
                }
            } while (!isFirstNameValid);

            do {
                isLastNameValid= true;
                System.out.println("enter last name:");
                lastName = new Scanner(System.in).nextLine();
                for (int i = 0; i < lastName.length(); i++) {
                    if (Character.isDigit(lastName.charAt(i))) {
                        isLastNameValid = false;
                    }
                }
                if (!isLastNameValid) {
                    System.out.println("the last name is not valid");

                }
            } while (!isLastNameValid);
            boolean ifValid;
            do {
                ifValid= true;
                System.out.println("enter user name:");
                userName = new Scanner(System.in).nextLine();
                for (int i = 0; i < clients.length; i++) {
                    if (Objects.equals(clients[i].getUserName(), userName)) {
                        ifValid = false;
                        System.out.println("the user name is exists");
                    }
                }
                for (int i = 0; i < workers.length; i++) {
                    if (Objects.equals(workers[i].getUserName(), userName)) {
                        ifValid = false;
                        System.out.println("the user name is exists");
                    }
                }
            }while (!ifValid);
            boolean lengthValid;
            do {
                System.out.println("enter password: The password must be 6 characters long");
                password = new Scanner(System.in).nextLine();
                if (password.length()<LENGTH_OF_PASSWORD) {
                    lengthValid= false;
                    System.out.println("the password is too short");
                }
                else {
                    lengthValid=true;
                }
            } while (!lengthValid);
        System.out.println("enter true if you are vip, else false");
        vip = scanner.nextBoolean();
        int sumOfBuys = NO_BUYS;
        int amountOfBuys=NO_BUYS;
        Date lastBuy = null;
            int rankOfWorker;
            if (typeOfUser== WORKER) {
                do {
                    System.out.println("what is your rank?" + " \n" +
                            "1- regular worker" + "\n" +
                            "2- manager" + " \n" +
                            "3- member in the management team");
                    rankOfWorker = scanner.nextInt();
                } while (rankOfWorker < MINIMUM_TYPE || rankOfWorker > MAXIMUM_TYPE);
                Worker worker = new Worker(firstName,whichUser, lastName, userName, password, vip,sumOfBuys,amountOfBuys,lastBuy, rankOfWorker);
                Worker[] newWorker = new Worker[workers.length];
                for (int i = 0; i < workers.length; i++) {
                    newWorker[i] = workers[i];
                }
                workers = new Worker [workers.length + 1];
                setWorkers(newWorker);
                workers[workers.length - 1] = worker;
            }
                if (typeOfUser== CLIENT){
                    Client client = new Client(firstName,whichUser ,lastName, userName, password, vip,sumOfBuys,amountOfBuys,lastBuy);
                    Client[] newClient =  new Client [clients.length];

                    for (int i=0; i<clients.length;i++) {
                        newClient[i] =clients[i];
                    }
                    clients = new Client[clients.length+1];
                    setClients(newClient);
                    clients[clients.length-1] = client;
                }
            }

         public Client login (){
        Scanner scanner= new Scanner(System.in);
        int choiceOfUser;
        String userName;
        String password;
        do {
            System.out.println("enter 1- for login to worker account" + "\n" +
                    "2- for login to client account");
            choiceOfUser = scanner.nextInt();
        } while (choiceOfUser != WORKER && choiceOfUser != CLIENT);

        boolean ifExist = false;
             do {
                 System.out.println("enter your user name");
                 userName = new Scanner(System.in).nextLine();
                 System.out.println("enter your password");
                 password = new Scanner(System.in).nextLine();
                 if (choiceOfUser == WORKER) {
                        ifExist= ifUserExist(workers,userName,password);
                 }
                 if (choiceOfUser==CLIENT) {
                     ifExist= ifUserExist(clients,userName,password);
                 }
                 if (!ifExist) {
                     System.out.println("the username or password is incorrect");
                 }
             }while (!ifExist);

             String firstName="";
             String lastName="";
             int rank=0;
             String rankOfWorker="";
             int i;
             boolean vip= false;
             Client current= new Client("","","","","",false,0,0,null);

             if (choiceOfUser == WORKER) {
                 for (i=0;i< workers.length; i++) {
                 if (Objects.equals(workers[i].getUserName(), userName)) {
                     firstName = workers[i].getFirstName();
                     lastName = workers[i].getLastName();
                     vip = workers[i].getVip();
                     rank = workers[i].getRank();
                 }
             }
                 if(rank==REGULAR_WORKER) {
                     rankOfWorker = "regular worker";
                 }
                 if (rank==MANAGER){
                     rankOfWorker= "manager";
                 }
                 if (rank==MANAGEMENT_TEAM){
                     rankOfWorker= "management team";
                 }
                 i--;

                 if (vip) {
                     System.out.println( "hello"+ " "+ firstName + " " + lastName +" "+ rankOfWorker  +" " + "vip!" );
                 }
                 else {
                     System.out.println( "hello"+ " "+ firstName + " " + lastName +" "+ rankOfWorker );
                 }                 current = workers[i];
             }
             if (choiceOfUser== CLIENT) {
                 for (i=0;i<clients.length; i++) {
                     if (Objects.equals(clients[i].getUserName(), userName)) {
                         firstName= clients[i].getFirstName();
                         lastName= clients[i].getLastName();
                         vip= clients[i].getVip();
                     }
                     if (vip) {
                         System.out.println( "hello"+ " "+ firstName + " " + lastName + " " + "vip!" );
                     }
                     else {
                         System.out.println( "hello"+ " "+ firstName + " " + lastName );
                     }
                     current = clients[i];

                 }
             }
             return current;
         }

         public void printAllClients(){
            for (int i=0; i<clients.length; i++) {
            System.out.println( "~"+clients[i]);
            }
             for (int i=0; i<workers.length; i++) {
                 System.out.println( "~"+workers[i]);
             }

         }
         public void printVipClients(){
             for (int i=0; i<clients.length; i++) {
                 if (clients[i].getVip()) {
                     System.out.println("~" + clients[i]);
                 }
             }
                 for (int i=0; i<workers.length; i++) {
                     if (workers[i].getVip()) {
                         System.out.println("~"+workers[i]);
                     }
             }
    }
         public void printClientsWhoBuy(){
        boolean ifHaveBuys= false;
        for (int i=0; i<clients.length; i++) {
            if (clients[i].getAmountOfBuys() > NO_BUYS) {
                System.out.println(clients[i]);
                ifHaveBuys=true;
            }
        }
             for (int i=0; i<workers.length; i++) {
                 if (workers[i].getAmountOfBuys() > NO_BUYS) {
                     System.out.println(workers[i]);
                     ifHaveBuys= true;
                 }
             }
             if(!ifHaveBuys){
                 System.out.println("no buys were made");
             }
    }
         public void printClientWithHighestSumOfBuys(){
        float maxOfSum=0;
        float currentSum;
        Client client= new Client("","","","","",false,0,0,null);
          for (int i=0;i< clients.length; i++) {
              currentSum= clients[i].getSumOfBuys();
              if (currentSum > maxOfSum) {
                  maxOfSum= currentSum;
                  client= clients[i];
              }
          }
             for (int i=0;i< workers.length; i++) {
                 currentSum= workers[i].getSumOfBuys();
                 if (currentSum > maxOfSum) {
                     maxOfSum= currentSum;
                     client= workers[i];
                 }
             }
          if (client.getAmountOfBuys()==NO_BUYS)
          {
              System.out.println("no buys were made");
          }
          else {
              System.out.println(client);
          }
         }

        public void addNewProduct(){
        boolean ifMore;
        int priceOfProduct;
        do {
            Scanner scanner= new Scanner(System.in);
            System.out.println("enter product description");
            String productDescription = scanner.nextLine();
            do {
                System.out.println("enter price of product");
                priceOfProduct = scanner.nextInt();
            } while (priceOfProduct <= NUMBER_NOT_VALID);
            int discountPercentages;
            do {
                System.out.println("enter discount percentages of the product");
                discountPercentages = scanner.nextInt();
            } while (discountPercentages < NUMBER_NOT_VALID);
            Product product = new Product(productDescription,true,priceOfProduct,discountPercentages);
            Product[] newArray = new Product[products.length+1];
            for (int i = 0; i < this.products.length; i++) {
                newArray[i] = this.products[i];
            }
            newArray[this.products.length] = product;
            this.products = newArray;

            System.out.println("enter true to enter more product, else false.");
            ifMore = scanner.nextBoolean();
        } while (ifMore);

         }
         public void changeStatusOfProductStock(){
        Scanner scanner = new Scanner(System.in);
             int location=1;
             for (int i=0; i< products.length; i++) {
             System.out.println(location +" " +products[i]);
             location++;
         }
             int numberProductToChangeStatus;
             do {
                 if (location==NO_HAVE_PRODUCTS) {
                     System.out.println("no have products");
                     return;
                 }
                 System.out.println("enter product number to change status");
                 numberProductToChangeStatus = scanner.nextInt();
             } while (numberProductToChangeStatus <= NUMBER_NOT_VALID || numberProductToChangeStatus>=location);

             numberProductToChangeStatus--;

         if (products[numberProductToChangeStatus].isIfInStock()) {
             products[numberProductToChangeStatus].setIfInStock(false);
             System.out.println("Product status changed");
             return;
         }
             if (!products[numberProductToChangeStatus].isIfInStock()) {
                 products[numberProductToChangeStatus].setIfInStock(true);
             }
             System.out.println("Product status changed");
         }


         public void buy(Client client) {
             Scanner scanner = new Scanner(System.in);
             int locationNumberOfProduct = 1;
             Product[] tempProductArray = new Product[products.length];
             int locationInNewArray = 0;
             for (int j = 0; j < products.length; j++) {
                 if (products[j].isIfInStock()) {
                     tempProductArray[locationInNewArray] = products[j];
                     locationInNewArray++;
                 }
             }
             if (tempProductArray.length== NO_HAVE_PRODUCTS_IN_STOCK) {
                 System.out.println("There are no products in stock");
             }
             Product[] productsInStock= new Product[LENGTH_OF_ARRAY];
             if (locationInNewArray!= LOCATION_NOT_VALID) {
                 productsInStock = new Product[locationInNewArray];
                 for (int k = 0; k < locationInNewArray; k++) {
                     productsInStock[k] = tempProductArray[k];
                 }
             }

             int numberOfProduct;
             float sumOfBuy = 0;
             do {
                     for (int i = 0; i < productsInStock.length; i++) {

                             System.out.println(locationNumberOfProduct + "-" + " "+productsInStock[i]);
                             locationNumberOfProduct++;
                         }

                     if (locationNumberOfProduct==NO_HAVE_PRODUCTS) {
                         System.out.println("sorry,no have products in stock");
                         return;
                     }
                     locationNumberOfProduct--;
                     do {
                         System.out.println("enter number of product, or -1 to finish");
                         numberOfProduct = scanner.nextInt();
                     } while (numberOfProduct <= MINIMUM_NOT_VALID || numberOfProduct > locationNumberOfProduct || numberOfProduct == LOCATION_NOT_VALID);
                  if (numberOfProduct== FINISH_THE_BUY) {
                      break;
                  }
                  float priceAfterDiscount;
                  float discount;
                 int amountOfProduct;
                 do {
                     System.out.println("enter amount of this product you want to buy");
                     amountOfProduct = scanner.nextInt();
                 } while (amountOfProduct <=NUMBER_NOT_VALID );

                 numberOfProduct--;
                 if (productsInStock.length != NO_HAVE_PRODUCTS_IN_STOCK) {
                     ShoppingCart shoppingCart = new ShoppingCart(productsInStock[numberOfProduct]
                             , amountOfProduct, productsInStock[numberOfProduct].getPrice());
                     ShoppingCart[] tempShoppingCart = new ShoppingCart[shoppingCarts.length];

                     for (int i = 0; i < shoppingCarts.length; i++) {
                         tempShoppingCart[i] = shoppingCarts[i];
                     }
                     shoppingCarts = new ShoppingCart[shoppingCarts.length + 1];

                     for (int j = 0; j < tempShoppingCart.length; j++) {
                         shoppingCarts[j] = tempShoppingCart[j];
                     }
                     shoppingCarts[shoppingCarts.length - 1] = shoppingCart;
                     sumOfBuy = 0;
                     for (int f = 0; f < shoppingCarts.length; f++) {
                         System.out.println(shoppingCarts[f]);
                         if (client.getVip()) {
                             discount = (products[numberOfProduct].getPrice() * products[numberOfProduct].getDiscountPercentages()) / HUNDRED;
                             priceAfterDiscount = products[numberOfProduct].getPrice() - discount;
                             sumOfBuy += priceAfterDiscount * shoppingCarts[f].getAmountOfProduct();

                         } else if (!client.getVip()) {
                             sumOfBuy += shoppingCarts[f].getPrice() * shoppingCarts[f].getAmountOfProduct();
                         }
                     }
                 }
                 System.out.println("the sum of the buy is:" + " " + sumOfBuy+"₪");
                 locationNumberOfProduct=1;
              } while (numberOfProduct != FINISH_THE_BUY);
             if (client instanceof Worker) {
                 if (((Worker) client).getRank()==REGULAR_WORKER) {
                     float discountOfRegularWorker = sumOfBuy*DISCOUNT_OF_REGULAR_WORKER;
                     sumOfBuy= sumOfBuy- discountOfRegularWorker;
                 }
                 if (((Worker) client).getRank()==MANAGER) {
                     float discountOfManager = sumOfBuy*DISCOUNT_OF_MANAGER;
                     sumOfBuy= sumOfBuy- discountOfManager;
                 }
                 if (((Worker) client).getRank()==MANAGEMENT_TEAM) {
                     float discountOfManagementTeam = sumOfBuy*DISCOUNT_OF_MANAGEMENT_TEAM;
                     sumOfBuy= sumOfBuy- discountOfManagementTeam;
                 }
             }
             System.out.println("the sum of the buy is:" + " " + sumOfBuy+"₪");
             client.setAmountOfBuys((int) (client.getAmountOfBuys()+ADD_A_PURCHASE));
             client.setSumOfBuys((int) (client.getSumOfBuys()+sumOfBuy));
             Date dateOfBuy = new Date();
             client.setLastBuy(dateOfBuy);
         }

         public static boolean ifUserExist (Client [] clients,String userName, String password) {
        boolean ifExist=false;
          for (int i=0; i< clients.length; i++) {
              if (Objects.equals(clients[i].getUserName(), userName) && Objects.equals(clients[i].getPassword(), password)) {
                  ifExist= true;
                  break;
              }
              else {
                  ifExist= false;
              }
          }
          return ifExist;
         }
}