package se.ifmo.web.lab3.persistence.service;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import se.ifmo.web.lab3.bean.HistoryAttempts;
import se.ifmo.web.lab3.bean.Point;
import se.ifmo.web.lab3.persistence.model.Attempt;
import se.ifmo.web.lab3.mapper.PointMapper;
import se.ifmo.web.lab3.persistence.repository.AttemptRepository;

import java.io.Serializable;

@Named("attemptService")
@SessionScoped
public class AttemptService implements Serializable {
    private final PointMapper mapper = PointMapper.INSTANCE;
    private final AttemptRepository repository = new AttemptRepository();

    public void addPoint(Point point) {
        if (point.validate()) {
            Attempt newAttempt = mapper.toAttempt(point);
            repository.addAttempt(newAttempt);
        }
    }

    public void getAttempts(double r, HistoryAttempts historyAttempts) {
        historyAttempts.setAttempts(repository.getAttemptsByR(r));
    }

    public void getAttempts(Point point, HistoryAttempts historyAttempts) {
        System.out.println("YYEESS");
        addPoint(point);
        historyAttempts.setAttempts(repository.getAttemptsByR(point.getR()));
    }
}
