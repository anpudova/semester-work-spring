package ru.kpfu.itis.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.exception.DateConversionException;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;

@Component
public class LocalDateConverter implements GenericConverter {

    private static final String DATE_FORMAT = "dd.MM.yyyy";
    private static final Set<Class<?>> CONVERTIBLE_TYPES = new HashSet<>();

    static {
        CONVERTIBLE_TYPES.add(LocalDate.class);
        CONVERTIBLE_TYPES.add(String.class);
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(LocalDate.class, String.class));
        convertiblePairs.add(new ConvertiblePair(String.class, LocalDate.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        if (sourceType.getType().equals(LocalDate.class) && targetType.getType().equals(String.class)) {
            return dateToString((LocalDate) source, formatter);
        } else if (sourceType.getType().equals(String.class) && targetType.getType().equals(LocalDate.class)) {
            try {
                return stringToDate((String) source, formatter);
            } catch (DateTimeParseException ex) {
                throw new DateConversionException("Cannot convert " + source + ".");
            }
        }
        throw new DateConversionException("Unsupported conversion between " + sourceType + " and " + targetType);
    }

    private String dateToString(LocalDate date, DateTimeFormatter formatter) {
        return date.format(formatter);
    }

    private LocalDate stringToDate(String dateString, DateTimeFormatter formatter) throws DateTimeParseException{
        return LocalDate.parse(dateString, formatter);
    }
}
