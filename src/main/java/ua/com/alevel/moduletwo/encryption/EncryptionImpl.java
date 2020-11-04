package ua.com.alevel.moduletwo.encryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EncryptionImpl{
    private Map<Integer, String> list = new HashMap<>();
    private int count = 2;
    private int action;
    private Integer a;
    private String s;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Integer encode(String pass){
        if(pass != null){
            a = pass.hashCode();
            if(list.size() != 0){
                for(Map.Entry<Integer, String> entry : list.entrySet()){
                    if(entry.getKey() != a){
                        list.put(a, pass);
                        return a;
                    }
                }
            }else{
                list.put(a,pass);
                return a;
            }
        } else{
            return 0;
        }
        return a;
    }

    private String decode(int pass){
        for(Map.Entry<Integer, String> entry : list.entrySet()){
            if(entry.getKey() == pass){
                return entry.getValue();
            }
        }
        return null;
    }

    private String read(){
        s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    private void read1(){
        String password = read();
        a = encode(password);
        if(a != 0) {
            System.out.println("Your encoding password " + a);
        } else if(count !=0 && a == 0){
                System.out.println("You don't enter anything. Try again\n" +
                        "You have " + count + " tries");
                count--;
                read1();
        } else {
            System.out.println("You are loser");
            count = 2;
        }
    }

    private void read2(){
        s = read();
        int temp = Integer.parseInt(s);
        if(temp !=0) {
            System.out.println("Your decoding password: " + decode(temp));
        } else if(count !=0 && a == 0){
            System.out.println("You don't enter anything. Try again\n" +
                    "You have " + count + " tries");
            count--;
            read2();
        } else {
            System.out.println("You are loser");
            count = 2;
        }
    }

    public void run(){
        while (true){
            System.out.println("What are you want to do?\n" +
                    "1 - encode your password\n" +
                    "2 - decode your password\n" +
                    "3 - exit");

            try {
                action = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (action){
                case 1:
                    System.out.println("Enter your password");
                    read1();
                    break;
                case 2:
                    System.out.println("Enter your encoding password");
                    read2();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("You enter something wrong. Try again");
            }
        }
    }
}