import java.util.Scanner;
class Main {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    Airplane airplane = new Airplane();
    boolean isTrue = false;

    while(!isTrue){
      System.out.println("\n\nA)dd, S)how, or Q)uit?");
      String planeMenu = input.nextLine();

      if(planeMenu.equalsIgnoreCase("q")){
        System.out.println("Goodbye");
        isTrue = false;
        break;
        //this break method ends the whole if-else statment. since we are not taking in any input any more, we can simply exit it.
      }
      //simply call the printPlane method
      else if(planeMenu.equalsIgnoreCase("s")){
        System.out.println(airplane.printPlane());
      }
      else if(planeMenu.equalsIgnoreCase("a")){
        String pos = "";
        String num = "";
        String cls = "";

        System.out.println("F)irst or E)conomy?");
        cls = input.nextLine();

        if(cls.equalsIgnoreCase("f")){
          System.out.println("Number of Passengers (1-2)");
          num = input.nextLine();
          
          if(num.equals("1")){
            System.out.println("A)isle or W)indow");
            pos = input.nextLine();
            //in order to show that the input is invalid, we have to assign the pos value to something else so taht we can get the error message to show up.
            if(!pos.equalsIgnoreCase("a") && !pos.equalsIgnoreCase("w")){
              pos = "";
            }
          }
          else if(num.equals("2")){
            pos = "Don't ask";
          }
        }
        else if(cls.equalsIgnoreCase("e")){
          System.out.println("Number of Passengers (1-3)");
          num = input.nextLine();
          if(num.equals("1")){
            System.out.println("A)isle, M)iddle, or W)indow");
            pos = input.nextLine();
            if(!pos.equalsIgnoreCase("a") && !pos.equalsIgnoreCase("m") && !pos.equalsIgnoreCase("w")){
              //same thing here.                
              pos = "";
            }
          }
          else if(num.equals("2")){
            System.out.println("A)isle or W)indow");
            pos = input.nextLine();
            if(!pos.equalsIgnoreCase("a") && !pos.equalsIgnoreCase("w")){
              pos = "";
            }            
          }
          else if(num.equals("3")){
            pos = "Don't ask";
          }
        }

        if(pos.equals("")){
          System.out.println("Invalid entry, please try again.");
        }
        else{
          String booked = airplane.seats(cls, pos, Integer.parseInt(num));
          if(booked == null){
            System.out.println("No seats matching that description were found, try again.");
          }
          else{
            System.out.println("You booked " + booked);
          }          
        }

      }
      else{
          System.out.println("Invalid entry, please try again.");
          }
    }
  }
}
