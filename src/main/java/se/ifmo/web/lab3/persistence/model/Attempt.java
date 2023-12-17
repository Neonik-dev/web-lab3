package se.ifmo.web.lab3.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.ifmo.web.lab3.bean.Point;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "attempts")
public class Attempt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "x", nullable = false)
    private double x;
    @Column(name = "y", nullable = false)
    private int y;
    @Column(name = "r", nullable = false)
    private double r;
    @Column(name = "is_hit", nullable = false)
    private boolean isHit;

    public Attempt(Point point) {
        x = point.getX();
        y = point.getY();
        r = point.getR();
        isHit = checkHit();
    }

    public boolean checkHit() {
        // Triangle in top-right quadrant
        if (x >= 0 && y >= 0) {
            return (x <= r) && (-x + r >= y);
        }
        // Circle in bottom-right quadrant
        if (x >= 0 && y <= 0) {
            return (x * x + y * y) <= (r * r);
        }
        // Rectangle in bottom-left quadrant
        if (x <= 0 && y <= 0) {
            return (-y <= r / 2) && (-x <= r);
        }
        // Empty in top-left quadrant
        return false;
    }
}
