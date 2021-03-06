import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String generator(int n)
    {

        int k = 0;
        char[] password = new char[1000];

        int randInt;

        Random rand = new Random();

        boolean capCheck = false, smallCheck = false, specialCheck = false, numCheck = false;

        for (int i = 1; i <= n; i++) {
            randInt = rand.nextInt(128);

            if (randInt >= 97 && randInt <= 122)    //small letter
            {

                password[k++] = (char) randInt;
                smallCheck = true;

            } else if (randInt >= 65 && randInt <= 90) //capital letter
            {

                password[k++] = (char) randInt;
                capCheck = true;

            } else if (randInt >= 48 && randInt <= 57) //number
            {
                password[k++] = (char) randInt;
                numCheck = true;
            } else if (randInt == 33 || (randInt >= 35 && randInt <= 38) || randInt == 42 || randInt == 64)
            //special characters -- ! # $ % & * @
            {
                password[k++] = (char) randInt;
                specialCheck = true;
            } else i = i - 1;
        }

        password[k] = '\0';
        String psswd = new String(password);

        if (!(smallCheck && capCheck && numCheck && specialCheck)) {
            psswd=generator(n);
        }
        return psswd;
    }

    public static void main(String[] args) {
        int n;
        System.out.println("Enter the required length of password:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        if (n >= 6) {
            String ans = generator(n);
            System.out.println(ans);
        }
        else
        {
            System.out.println("Please enter a length greater than equal to 6");
        }
    }
}