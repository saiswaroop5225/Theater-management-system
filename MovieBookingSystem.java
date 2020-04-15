import java.util.*;
import java.io.*;
import java.util.Random;
interface Movie
{
    void price();
}

abstract class Viewer
{
    abstract void getDetails();
    abstract void printDetails();
}

class silver implements Movie
{
    public void  price()
    {
        int Bill;
        Bill = 130;
        System.out.println("Total Bill: "+Bill);
    }
}
class Golden implements Movie
{
    public void price()
    {
        int Bill;
        Bill =190;
        System.out.println("Total Bill: "+Bill);
    }
}
class Platinum implements Movie
{
    public void price()
    {
        int Bill;
        Bill = 250;
        System.out.println("Total Bill: "+Bill);

    }
}
class Customer extends Viewer
{
    String Name,Mail,MyMobile,MyMovie,option;
    String MyTheater,MovieName,myseat;
    String regex1 = "(0/91)?[7-9][0-9]{9}";
    String regex2 = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    long Mobile;

    void getDetails() {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        Name = Sc.nextLine();
        System.out.println("Enter Your Mobile Number:");
        Mobile = Sc.nextLong();
        MyMobile = Long.toString(Mobile);
        Sc.nextLine();
        System.out.println("Enter Your Email Id:");
        Mail = Sc.nextLine();
        System.out.println("\t\t\t\t\tEnter Your Movie Theater");
        MyTheater = Sc.nextLine();
        System.out.println("\t\t\t\t\tEnter Your myseat");
        System.out.println("Enter 1 For Avengers\tEnter 2 For baahubali\tEnter 3 For Godzilla \t\tEnter 4 For war\tEnter 5 Forjoker");
        MovieName = Sc.nextLine();
        System.out.println("\t\t\t\t\tEnter Type Of Your MyMovie:");
        System.out.println("Enter 1 For Platinum\tEnter 2 For silver\tEnter 3 For Golden");
        option = Sc.nextLine();
    }

    void printDetails() {
        try{
            FileWriter fw = new FileWriter("Booking.txt");
            PrintWriter pw = new PrintWriter(fw);
            silver S = new silver();
            Golden Gn = new Golden();
            Platinum PL = new Platinum();
            Random rand = new Random();
            System.out.println("\t\t\tYour MyMovie Details");
            int rand_int1 = rand.nextInt(10000);
//        System.out.println("Booking Id: "+rand_int1);
            pw.println("Booking Id: "+rand_int1);
//        System.out.println("Name: " + Name);
            pw.println("Name: " + Name);
            if(MyMobile.matches(regex1) && Mail.matches(regex2))
            {
//                System.out.println("Mobile: " + MyMobile);
                pw.println("Mobile: " + MyMobile);
//                System.out.println("MailID:"+ Mail);
                pw.println("MailID:"+ Mail);
                pw.println("MyTheater:"+MyTheater);
                if (MovieName.equals("1"))
                {
                    myseat = "Avengers";
                    pw.write("mymoviename:"+myseat+"\n");

                }
                else if (MovieName.equals("2"))
                {
                    myseat = "Baahubali";
                    pw.write("mymoviename:"+myseat+"\n");

                }

                else if (MovieName.equals("3"))
                {
                    myseat = "Godzilla";
                    pw.write("mymoviename:"+myseat+"\n");

                }
                else if (MovieName.equals("4"))
                                {
                                    myseat = "war";
                                    pw.write("mymoviename:"+myseat+"\n");

                                }
                 else if (MovieName.equals("5"))
                                 {
                                     myseat = "joker";
                                     pw.write("mymoviename:"+myseat+"\n");

                                 }

                else
                {
                    System.out.println("Only These five movies are Available");
                }
                if (option.equals("1")) {
                    MyMovie = "Platinum";
		    int upperbound = 60;
		    int int_random = rand.nextInt(upperbound);
//                  System.out.println("Myseat_section: " + MyMovie +"and your seat number is"+int_random);
                    pw.println("Myseat: " + MyMovie);
		    pw.println("Your Bill is 250");
                    PL.price();
                } else if (option.equals("2")) {
                    MyMovie = "silver";
		    int upperbound = 60;
		    int int_random = rand.nextInt(upperbound);
//                  System.out.println("Myseat_section: " + MyMovie +"and your seat number is"+int_random);
                    pw.println("MyMovie: " + MyMovie);
		    pw.println("Your Bill is 130");
                    S.price();
                } else if (option.equals("3")) {
                    MyMovie = "Golden";
		    int upperbound = 60;
		    int int_random = rand.nextInt(upperbound);
//                  System.out.println("Myseat_section: " + MyMovie +"and your seat number is"+int_random);
                    pw.println("MyMovie: " + MyMovie);
		    pw.println("Your Bill is 190");
                    Gn.price();

                } else {
                    System.out.println("Only Enter Available MyMovies");
                }
                pw.close();

                FileReader fr = new FileReader("Booking.txt");
                BufferedReader br = new BufferedReader(fr);

                String str;
                while ((str = br.readLine()) != null)
                {
                    System.out.println(str);
                }
                br.close();
                System.out.println("\t\t\t\t\tBooking Successful");
            }
            else
            {
                System.out.println("Invalid Mobile no or EmailId ");
                getDetails();
                printDetails();
            }
         }

        catch(IOException e)
        {
            System.out.println("Please Book Your Movie");
        }

    }

}
class AddandDelticket
{
    void showMyMovie()
    {
        try
        {
            FileReader fr = new FileReader("Booking.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null)
            {
                System.out.println(str);
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("Please Book Your Movie");
        }
    }
    void cancelMyMovie()
    {
        File file = new File("Booking.txt");

        if(file.delete())
        {
            System.out.println("MyMovie Cancelled successfully");
        }
        else
        {
            System.out.println("Failed to Cancel the MyMovie");
        }
    }
}
class TheatermanagementSystem
{
    public static void main(String[] args)
    {
        Scanner In = new Scanner(System.in);
        Viewer P = new Customer();
        AddandDelticket AD = new AddandDelticket();
        System.out.println("\t\t\t\t\tTheater Management System by SUNNAM SAI JYOTHI SWAROOP");
        System.out.println("Enter 1 To Book Tickets\tEnter 2 To Cancel ticket\tEnter 3 To View ticket");
        String choice = In.nextLine();
        if(choice.equals("1"))
        {
            P.getDetails();
            P.printDetails();
        }
        else if (choice.equals("2"))
        {
            AD.cancelMyMovie();
        }
        else if(choice.equals("3"))
        {
            System.out.println("\t\t\t\t\tThis Will Only Show Last Booked ticket.");
            AD.showMyMovie();
        }
        else
        {
            System.out.println("Please Enter Available Option");
        }

    }

}
