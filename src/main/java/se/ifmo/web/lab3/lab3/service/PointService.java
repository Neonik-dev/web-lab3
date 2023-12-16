package se.ifmo.web.lab3.lab3.service;

import se.ifmo.web.lab3.lab3.bean.Attempt;
import se.ifmo.web.lab3.lab3.bean.Point;
import se.ifmo.web.lab3.lab3.mapper.PointMapper;

public class PointService {
    private final PointMapper mapper = PointMapper.INSTANCE;

    public void addPoint(Point point) {
        Attempt newAttempt = mapper.toAttempt(point);
    }
}
