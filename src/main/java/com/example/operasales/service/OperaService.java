package com.example.operasales.service;

import com.example.operasales.model.Primera;
import com.example.operasales.model.Ticket;
import com.example.operasales.repository.OperaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class OperaService {


    @Autowired
    private OperaRepository operaRepository;



    public void addPr(Primera pr) {
        operaRepository.save(pr);

    }

    public void printAll() {
        for (Primera primera : operaRepository.getAll()) {
            System.out.println(primera);
        }
    }



    public void minusplace(long id) {
        for (Primera primera : operaRepository.getAll()) {
            if (primera.getId() == id) {
                primera.setFreeplace(primera.getFreeplace() - 1);
            }
        }
    }

    public void plusplace(long id) {
        for (Primera primera : operaRepository.getAll()) {
            if (primera.getId() == id) {
                primera.setFreeplace(primera.getFreeplace() + 1);
            }
        }
    }

    public void minusprimera(long id) {
        for (Primera primera : operaRepository.getAll()) {
            if (primera.getId() == id) {
                operaRepository.removeById(primera.getId());
                break;
            }
        }
    }

    public void printPrimera(String name) {
        for (Primera primera : operaRepository.getAll()) {
            if (primera.getName().equals(name)) {
                System.out.println(primera);
            }
        }

    }

    public Ticket buy(String name) {

        Random random = new Random();
        Ticket t = null;
        for (Primera primera : operaRepository.getAll()) {
            if (primera.getName().equals(name)) {
                int place = random.nextInt(120);
                t = new Ticket(primera, 100, place);

                primera.setFreeplace(primera.getFreeplace() - 1);
            }
        }

        return t;
    }

    public void vozvrat(Ticket ticket) {

        Primera primera = ticket.getPr();
        long id = primera.getId();
        plusplace(id);

    }

    public Primera getPremieraById(long id) {
        for (Primera primera : operaRepository.getAll()) {
            if (primera.getId() == id) {
                return primera;
            }
        }

        return null;
    }

}
