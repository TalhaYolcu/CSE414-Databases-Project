package constants;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;

public class CONSTANTS {
    public static final String MYSQL_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    public static String MYSQL_URL="jdbc:mysql://localhost:3306/travel_booking";
    public static String MYSQL_USERNAME="root";
    public static String MYSQL_PASSWORD="root";
    public static String DB_NAME="travel_booking";

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
        public static String rental = "rental";

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
        public static int column_count=8;
        public static String[] column_names=new String[]{
          flight_id,departure_p,aperture_p,departure_t,aperture_t,capacity,price,spare_place
        };

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
    public static class HOTEL_TABLE {
        public static String hotel_id="hotel_id";
        public static String hotel_name="hotel_name";
        public static String location = "location";
    }
    public static class TOUR_TABLE {
        public static String tour_id="tour_id";
        public static String person_id ="person_id";
        public static String transport_id="transport_id";
        public static String acc_id="acc_id";
        public static String capacity="capacity";
        public static String tot_price="tot_price";
        public static String company_id = "company_id";
        public static String guide_id = "guide_id";

    }
    public static class GUIDE_TABLE  {
        public static String guide_id = "guide_id";
        public static String person_id = "person_id";
        public static String company_id = "company_id";
        public static String company_name = "company_name";
        public static String tot_guide = "tot_guide";
    }
    public static class TOUR_COMPANY_TABLE {
        public static String company_id = "company_id";
        public static String company_name = "company_name";
    }
    public static class TRANSPORT_TABLE {
        public static String transport_id = "transport_id";
        public static String person_id = "person_id";
        public static String transport_type = "transport_type";
        public static String respective_id = "respective_id";
    }
    public static class PERSON_TABLE {
        public static String person_id = "person_id";
        public static String name = "name";
        public static String age = "age";
        public static String budget = "budget";
    }
    public static class RENTAL_TABLE {
        public static String rental_id = "rental_id";
        public static String person_id = "person_id";
        public static String car_id = "car_id";
        public static String company_id = "company_id";
    }
    public static class ACCOMODATION_TABLE {
        public static String acc_id = "acc_id";
        public static String hotel_id = "hotel_id";
        public static String room_id = "room_id";
        public static String person_id = "person_id";
        public static int column_count=4;
        public static String[] column_names=new String[]{acc_id,hotel_id,room_id,person_id};
    }
    public static class ROOMS_TABLE {
        public static String hotel_id = "hotel_id";
        public static String room_id = "room_id";
        public static String room_properties = "room_properties";
        public static String room_cap = "room_cap";
        public static String daily_price = "daily_price";
        public static String check_in_date = "check_in_date";
        public static String check_out_date = "check_out_date";

    }
    public static class OPERATIONS {
        public static String insert="Insert";
        public static String delete="Delete";
        public static String edit = "Edit";
    }

}
