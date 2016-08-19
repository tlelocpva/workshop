package br.pucrs.elo.vacilationpoints.worker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Armani on 17/08/16.
 */
public class Worker {
    private int id;
    private String name;
    private String image;
    private List<Vacillation> vacillationList;

    public Worker(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
        vacillationList = new ArrayList<>();
    }

    public void addVacillation(Vacillation vacillation){
        vacillationList.add(vacillation);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Vacillation> getVacillationList() {
        return vacillationList;
    }

    public void setVacillationList(List<Vacillation> vacillationList) {
        this.vacillationList = vacillationList;
    }
}
