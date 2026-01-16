package com.pms.pmSystem.data.mapper.converter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

@Component
public class LocalDateToZonedDateTimeMapper {

    public ZonedDateTime localDateToZonedDateTime(LocalDate localDate) {
        return localDate != null
                ? localDate.atStartOfDay(ZoneId.systemDefault())
                : null;
    }

    public LocalDate zonedDateTimeToLocalDate(ZonedDateTime zonedDateTime) {
        return zonedDateTime != null
                ? zonedDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDate()
                : null;
    }
}
