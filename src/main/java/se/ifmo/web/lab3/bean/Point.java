package se.ifmo.web.lab3.bean;


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

    public synchronized void setR(double r) {
        if (r >= 2 && r <= 5 && r % 0.25 == 0) {
            this.r = r;
        }
    }

    public synchronized void setY(Integer y) {
        if (y != null && y >= -4 && y <= 4) {
            this.y = y;
        }
    }

    public synchronized void setX(double x) {
        if (x >= -5 && x <= 5) {
            this.x = x;
        }
    }

    public boolean validate() {
        return y != null;
    }
}
