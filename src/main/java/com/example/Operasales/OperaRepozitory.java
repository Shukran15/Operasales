package com.example.Operasales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Random;

@Repository
public class OperaRepozitory {

    @Autowired
    private ArrayList <Primera> prs;

    public void addPr(Primera pr){
        prs.add(pr);

    }

    public void printAll() {
        for(Primera primera: prs){
            System.out.println(primera);
        }
    }

    public void minusplace(long id){
        for(Primera primera: prs) {
            if(primera.getId() == id){
                primera.setFreeplace(primera.getFreeplace() - 1);
            }
        }
    }

    public void plusplace(long id){
        for(Primera primera: prs) {
            if(primera.getId() == id){
                primera.setFreeplace(primera.getFreeplace() + 1);
            }
        }
    }

    public void minusprimera(long id){
        for(Primera primera: prs) {
            if(primera.getId() == id){
               prs.remove(primera);
            }
        }
    }

    public void printPrimera (String name){
        for(Primera primera: prs){
            if (primera.getName().equals(name)){
                System.out.println(primera);
            }
        }

    }

    public Ticket buy(String name){

        Random random = new Random();
        Ticket t = null;
        for(Primera primera: prs){
            if (primera.getName().equals(name)){
                int place = random.nextInt(120);
                t = new Ticket(primera, 100, place);

                primera.setFreeplace(primera.getFreeplace() - 1);
            }
        }

        return t;
    }

    public void vozvrat(Ticket ticket){

        Primera primera = ticket.getPr();
        long id = primera.getId();
        plusplace(id);

    }

}


