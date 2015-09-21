package com.telis.patreopolis;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Random;

//@HttpSessionScope
//@WebService
public class Die {

    private static int die;
    private final static Random rand = new Random();


    public void Roll() {
        die = rand.nextInt(6) + 1;
    }

//    @WebMethod(operationName = "roll")
    public int roll() {
        die = rand.nextInt(6) + 1;
        return die;
    }

    public static int getDie() {
        return die;
    }
}
