package com.pms.pmSystem.data.mapper.converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

@Component
public class LocalDateTimeToZonedDateTimeMapper {

    public ZonedDateTime localDateTimeToZonedDateTime(LocalDateTime localDateTime) {
        return localDateTime != null
                ? localDateTime.atZone(ZoneId.systemDefault())
                : null;
    }

    public LocalDateTime zonedDateTimeToLocalDateTime(ZonedDateTime zonedDateTime) {
        return zonedDateTime != null
                ? zonedDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime()
                : null;
    }
}
