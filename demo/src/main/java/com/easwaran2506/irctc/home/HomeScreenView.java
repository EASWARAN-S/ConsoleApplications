package com.easwaran2506.irctc.home;

public class HomeScreenView {
    private HomeScreenModel homeScreenModel;

    public HomeScreenView() {
        homeScreenModel = new HomeScreenModel(this);
    }
Scanner sc = new Scanner(System.in);
  
    public void init(int userId) {
         
           
            System.out.println("Welcome to Indian Railways  - IRCTC ");
            System.out.println( " \n 1. Book Tickets \n 2.Get Pnr Status \n 3 Book Tickets \n 4 Cancel Tickets \n 5 Search Passenger\n 0. Exit \n Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
    
            switch (choice) {
      
    
            
        }
    
    }

}
