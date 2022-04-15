package com.example.junitreport;

/**
 * @author Gohar Ohanyan. Created on 4/13/2022.
 */
public class RandomIntProvider {

    public int generate(){
        return (int) (Math.random() * Integer.MAX_VALUE);
    }
}
