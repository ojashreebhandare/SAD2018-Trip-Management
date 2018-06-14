package dao;

import jdbc.ConnectionDb;
import pojo.TicketPOJO;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;


public class TicketDao {
    private ConnectionDb dbConnector = ConnectionDb.getInstance();

    // static variable single_instance of type Singleton
    private static TicketDao single_instance = null;

    // variable of type String
    public String s;

    List<TicketPOJO> items = new ArrayList<TicketPOJO>();


    // static method to create instance of Singleton class
    public static TicketDao getInstance()
    {
        single_instance= new TicketDao();

        return single_instance;
    }
    // private constructor restricted to this class itself
    private TicketDao() {

/**
        try {
            String sql = "SELECT * FROM ticket WHERE user_id='" + userPOJO.getUser_id() + "';";
            ResultSet ticketResultset = this.dbConnector.selectQuery(sql);
            if (ticketResultset == null) {
                System.out.println("NULLLLLLLLLLLLLLLLLLLL");
            }

            while(ticketResultset.next()) {
                TicketPOJO item = new TicketPOJO();

                item.setPackage_id( ticketResultset.getInt("package_id"));
                item.setUser_id(ticketResultset.getInt("user_id"));
                item.setTicket_no(ticketResultset.getInt("ticket_no"));
                items.add(item);
            }
        } catch (Exception var3) {
            System.out.println(var3);
        }**/


    }

    public List<TicketPOJO> getBooktickets(int user_id) {
        try {
            String sql = "SELECT * FROM ticket WHERE user_id='" +user_id+ "';";
            ResultSet ticketResultset = this.dbConnector.selectQuery(sql);
            if (ticketResultset == null) {
                System.out.println("NULLLLLLLLLLLLLLLLLLLL");
            }
            System.out.println(ticketResultset);
            while (ticketResultset.next()) {
                TicketPOJO item = new TicketPOJO();

                item.setPackage_id(ticketResultset.getInt("package_id"));
                item.setUser_id(ticketResultset.getInt("user_id"));
                item.setTicket_no(ticketResultset.getInt("ticket_no"));
                items.add(item);
            }
        } catch (Exception var3) {
            System.out.println(var3);
        }
        return items;
    }
}