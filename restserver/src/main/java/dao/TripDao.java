package dao;

import jdbc.ConnectionDb;
import pojo.TripPOJO;

import javax.inject.Singleton;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TripDao {
    private ConnectionDb dbConnector = ConnectionDb.getInstance();

    // static variable single_instance of type Singleton
    private static TripDao single_instance = null;

    // variable of type String
    public String s;

    List<TripPOJO> items = new ArrayList<TripPOJO>();


    // static method to create instance of Singleton class
    public static TripDao getInstance()
    {
        single_instance= new TripDao();

        return single_instance;
    }
    // private constructor restricted to this class itself
    private TripDao() {


        try {
            String sql = "SELECT * FROM trips ";
            ResultSet allTripsResultSet = this.dbConnector.selectQuery(sql);
            if (allTripsResultSet == null) {
                System.out.println("NULLLLLLLLLLLLLLLLLLLL");
            }

            while(allTripsResultSet.next()) {
                TripPOJO item = new TripPOJO();

                item.setPackage_id( allTripsResultSet.getInt("package_id"));
                item.setPackage_name(allTripsResultSet.getString("package_name"));
                item.setSource(allTripsResultSet.getString("source"));
                item.setDestination( allTripsResultSet.getString("destination"));
                item.setDeparture_date( allTripsResultSet.getString("departure_date"));
                item.setHotel_name( allTripsResultSet.getString("hotel_name"));
                item.setNo_of_nights( allTripsResultSet.getInt("no_of_nights"));
                item.setMode_of_transport( allTripsResultSet.getString("mode_of_transport"));
                item.setTrip_desc( allTripsResultSet.getString("trip_desc"));
                item.setPackage_cost( allTripsResultSet.getInt("package_cost"));
                item.setDiscount( allTripsResultSet.getInt("discount"));
                items.add(item);
            }
        } catch (Exception var3) {
            System.out.println(var3);
        }


    }

    public List<TripPOJO> getAllTrips(){
        return items;
    }

}