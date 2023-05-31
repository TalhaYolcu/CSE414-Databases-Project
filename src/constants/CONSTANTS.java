package constants;

public class CONSTANTS {
    public static final String MYSQL_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    public static String MYSQL_URL="jdbc:mysql://localhost:3306/travel_booking";
    public static String MYSQL_USERNAME="root";
    public static String MYSQL_PASSWORD="root";

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
}
