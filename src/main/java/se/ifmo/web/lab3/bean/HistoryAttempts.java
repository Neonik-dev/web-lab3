package se.ifmo.web.lab3.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;
import se.ifmo.web.lab3.persistence.model.Attempt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("historyAttempts")
@SessionScoped
@Data
public class HistoryAttempts implements Serializable {
    private List<Attempt> attempts = new ArrayList<>();
}
