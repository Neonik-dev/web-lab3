package se.ifmo.web.lab3.lab3.bean;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Named("point")
@SessionScoped
@Data
public class Point implements Serializable {
    private double x;
    private int y;
    private double r;

    public void submit() {
        x += 1;
        System.out.println(this);
    }
}
