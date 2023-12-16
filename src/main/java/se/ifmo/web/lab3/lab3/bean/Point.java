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
    private Integer y;
    private double r = 3.5;

    public void submit() {
        System.out.println(this);
    }
}
