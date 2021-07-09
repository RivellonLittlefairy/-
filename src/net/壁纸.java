package net;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class 壁纸  {
    public static void main(String[] args) {

    }
}
class student implements Serializable {
    int num;
    student res = null;
    public student clone(){
        try {
            ByteArrayOutputStream BAO = new ByteArrayOutputStream();
            ObjectOutput OO = new ObjectOutputStream(BAO);
            OO.writeObject(this);
            ByteArrayInputStream BAI = new ByteArrayInputStream(BAO.toByteArray());
            ObjectInputStream OI = new ObjectInputStream(BAI);
            res = (student) OI.readObject();
        }catch (Exception e){

        }finally {
            return res;
        }

    }


}
