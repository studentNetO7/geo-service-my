package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    private final GeoService geoService = new GeoServiceImpl();

//  С использованием @CsvSource:
//@ParameterizedTest
//@CsvSource({
//            "127.0.0.1, null, null, null, 0",  // LOCALHOST
//            "172.0.32.11, 'Moscow', 'RUSSIA', 'Lenina', 15",  // MOSCOW_IP
//            "96.44.183.149, 'New York', 'USA', '10th Avenue', 32",  // NEW_YORK_IP
//            "172.16.0.1, 'Moscow', 'RUSSIA', null, 0",  // 172.x.x.x
//            "96.8.8.8, 'New York', 'USA', null, 0"  // 96.x.x.x
//    })
//    void testByIp(String ip, String expectedCity, String expectedCountry, String expectedStreet, int expectedBuilding) {
//        Location location = geoService.byIp(ip);
//
//        if (expectedCity == null) {
//            assertNull(location);
//        } else {
//            assertNotNull(location);
//            assertEquals(expectedCity, location.getCity());
//            assertEquals(expectedCountry, location.getCountry() != null ? location.getCountry().name() : null);
//            assertEquals(expectedStreet, location.getStreet());
//            assertEquals(expectedBuilding, location.getBuilding());
//        }
//    }

//  С использованием @MethodSource:

    public static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("127.0.0.1", new Location(null, null, null, 0)),
                Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of("96.44.183.149", new Location("New York", Country.USA, "10th Avenue", 32)),
                Arguments.of("172.", new Location("Moscow", Country.RUSSIA, null, 0)),
                Arguments.of("96.", new Location("New York", Country.USA, null, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void testByIp(String ip, Location expectedLocation) {
//        GeoService geoService = new GeoServiceImpl();
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(result, expectedLocation);
    }

    @Test
    void testByCoordinates_throwsException() {
        double latitude = 55.7558; // пример широты
        double longitude = 37.6173; // пример долготы

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            geoService.byCoordinates(latitude, longitude);
        });
        assertEquals("Not implemented", thrown.getMessage());
    }
}

