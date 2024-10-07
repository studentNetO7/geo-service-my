package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    private final LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

//  @ParameterizedTest
//  @CsvSource(value = {
//           "RUSSIA, 'Добро пожаловать'",  // Russian_greeting
//            "USA, 'Welcome'", // English_greeting
//            "GERMANY, 'Welcome'",  // English_greeting
//            "BRAZIL, 'Welcome'",  // English_greeting
//
//   })
//
//  void localeTest(Country country, String expectedGreeting) {
////       LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
//       String result = localizationService.locale(country);
//       Assertions.assertEquals(expectedGreeting, result);
//    }

    public static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.BRAZIL, "Welcome"),
                Arguments.of(Country.GERMANY, "Welcome"),
                Arguments.of(Country.USA, "Welcome"));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void localeTest(Country country, String expectedGreeting) {
//       LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(country);
        Assertions.assertEquals(expectedGreeting, result);
    }
}

