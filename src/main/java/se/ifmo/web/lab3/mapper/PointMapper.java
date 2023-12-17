package se.ifmo.web.lab3.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se.ifmo.web.lab3.bean.Point;
import se.ifmo.web.lab3.persistence.model.Attempt;

@Mapper
public interface PointMapper {
    PointMapper INSTANCE = Mappers.getMapper(PointMapper.class);

    Attempt toAttempt(Point point);
}
