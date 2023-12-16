package se.ifmo.web.lab3.lab3.bean;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "attempts")
public class Attempt {
    @Id
    private Long id;
    @Column(name = "x")
    private double x;
    @Column(name = "y")
    private int y;
    @Column(name = "r")
    private double r;
    @Column(name = "is_hit")
    private boolean isHit;

    public Attempt(Point point) {
        x = point.getX();
        y = point.getY();
        r = point.getR();
        isHit = checkHit();
    }

    public boolean checkHit() {

    }
}
