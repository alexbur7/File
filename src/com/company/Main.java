package com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("A.txt", false)){
            String text = " Abba Andrei arm table clion air";
            writer.write(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String s1="";
        boolean v=false;
        boolean d=false;
        try(FileReader reader = new FileReader("A.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                if (c==' '){
                    d=true;
                }
                if (d==true && c!='a'){
                    v=false;
                }
                else if(d==true && c=='a' || v==true){
                    v=true;
                }
                if (c==' ') { s1+=" ";}
                if (v==true){
                    s1 += (char) c;
                }
                if (c!=' '){
                    d=false;
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(FileWriter writer = new FileWriter("B.txt", false)){
            String text = s1;
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try(FileReader reader = new FileReader("B.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char) c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
