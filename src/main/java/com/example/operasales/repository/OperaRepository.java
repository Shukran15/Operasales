package com.example.operasales.repository;

import com.example.operasales.model.Primera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

import static com.example.operasales.model.Kategory.PG;
import static com.example.operasales.model.Kategory.R;


@Repository
public class OperaRepository {



   // @Autowired(required = false)
    private ArrayList<Primera> prs;

    {

        this.prs = new ArrayList<>();
        Primera primera1 = new Primera(1L, "Мастер и Маргарита", "Мюзикл, балет", R, 100);
        Primera primera2 = new Primera(2L, "Лебединное озеро", "Мюзикл, балет", PG, 120);
        prs.add(primera1);
        prs.add(primera2);


}



    public void save(Primera pr) {

        System.out.println("Начало добавления примьеры " + pr);
        prs.add(pr);
        System.out.println("Завершение добавления примьеры " + pr);

    }

    public List<Primera> getAll() {
        return prs;
    }





    public void removeById(long id) {
        for (Primera primera : prs) {
            if (primera.getId() == id) {
                prs.remove(primera);
                break;
            }
        }
    }

    public Primera getPremieraById(long id) {
        for (Primera primera : prs) {
            if (primera.getId() == id) {
                return primera;
            }
        }

        return null;
    }

    public Primera getPremieraByName(String name) {
        for (Primera primera : prs) {
            if (primera.getName().equals(name)) {
                return primera;
            }
        }

        return null;
    }



}

