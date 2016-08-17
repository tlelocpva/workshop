package br.pucrs.elo.vacilationpoints.worker;

import java.util.List;

/**
 * Created by Armani on 17/08/16.
 */
public class Worker {
    private int id;
    private String name;
    private String image;
    private List<Vacilation> vacilationList;

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

    public List<Vacilation> getVacilationList() {
        return vacilationList;
    }

    public void setVacilationList(List<Vacilation> vacilationList) {
        this.vacilationList = vacilationList;
    }
}
