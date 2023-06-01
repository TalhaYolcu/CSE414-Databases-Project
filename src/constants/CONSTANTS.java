package constants;

public class CONSTANTS {
    public static final String MYSQL_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    public static String MYSQL_URL="jdbc:mysql://localhost:3306/travel_booking";
    public static String MYSQL_USERNAME="root";
    public static String MYSQL_PASSWORD="root";

    public static class TABLE_NAMES {
        public static String accomodation="accomodation";
        public static String bus_trip="bus_trip";
        public static String car_rental="car_rental";
        public static String flights="flights";
        public static String guide="guide";
        public static String hotels="hotels";
        public static String person = "person";
        public static String rooms = "rooms";
        public static String tour="tour";
        public static String tour_company="tour_company";
        public static String transport = "transport";

    }

    public static class FLIGHT_TABLE {
        public static String flight_id = "flight_id";
        public static String departure_p = "departure_p";
        public static String aperture_p = "aperture_p";
        public static String departure_t = "departure_t";
        public static String aperture_t = "aperture_t";
        public static String capacity = "capacity";
        public static String price = "price";
        public static String spare_place = "spare_place";

    }
    public static class BUS_TRIP_TABLE {
        public static String bus_trip_id = "bus_trip_id";
        public static String departure_p = "departure_p";
        public static String aperture_p = "aperture_p";
        public static String departure_t = "departure_t";
        public static String aperture_t = "aperture_t";
        public static String capacity = "capacity";
        public static String price = "price";
    }
    public static class CAR_RENTAL_TABLE {
        public static String car_id="car_id";
        public static String company="company";
        public static String car_properties="car_properties";
        public static String daily_price="daily_price";
        public static String start_date="start_date";
        public static String end_date="end_date";

    }

}
