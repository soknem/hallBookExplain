import java.util.*;

public class Main {

    static String[] seats=new String[50];

   static String[] extractSeat(String seatsString){

        return seatsString.replace(" ","").split(",");

    }

   static void books(String[] seatsString){

       for (String s : seatsString) {

           seats[Integer.parseInt(s) - 1] = "BC";

       }
    }

    static String checkingSeats(String[] checkinSeats){

       String bcSeats=null;

       for (String s : checkinSeats) {
           //seats[5]=BC
           if(seats[Integer.parseInt(s) - 1]!=null){

               if(bcSeats==null){
                   bcSeats=s+",";
               }else{
                   bcSeats+=s+",";
               }

           }
        }
       return bcSeats;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        seats[4]="BC";//5
        seats[6]="BC";//7

        do{

            System.out.print("Enter number of seats: ");

            String seatsInput = scanner.nextLine();

            String[] seatsEx = extractSeat(seatsInput);

            String checkSeats =checkingSeats(seatsEx);

            if(checkSeats==null){
                books(seatsEx);
                break;
            }else {
                System.out.println("Seat = "+checkSeats+"\balready booked!!!!");
            }

        }while (true);


        for(String item:seats){
            System.out.println("item:"+(item==null?"GREEN":"RED"));
        }

    }
}