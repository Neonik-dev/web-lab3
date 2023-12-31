package se.ifmo.web.lab3.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;
import se.ifmo.web.lab3.persistence.model.Attempt;
import se.ifmo.web.lab3.persistence.service.AttemptService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named("historyAttempts")
@SessionScoped
@Data
public class HistoryAttempts implements Serializable {
    private List<Attempt> attempts = Collections.synchronizedList(new ArrayList<>());

    public HistoryAttempts() {
        new AttemptService().getAttempts(3.5, this);
    }
}
