import controller.EventController;
import dao.SqliteJDBCConnector;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import  static spark.Spark.*;


public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--create-table")) {
            try {
                SqliteJDBCConnector.createTables();
            } catch (SQLException e) {
                System.out.println("Cannot create tables in DB");
                System.out.println(e.getMessage());
            }
        }

        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(4567);

        // Always start with more specific routes
        get("/hello", (req, res) -> "Hello World");

        // Always add generic routes to the end
        get("/", EventController::renderEvents, new ThymeleafTemplateEngine());

        get("/add", EventController::addNewEvent, new ThymeleafTemplateEngine());

        post("/add", (req, res) -> {
            EventController.saveNewEvent(req, res);
            System.out.println("udalo sie");
            res.redirect("/");
            return "";
        });



        // Equivalent with above
//        get("/index", (Request req, Response res) -> {
//            return new ThymeleafTemplateEngine().render( EventController.renderEvents(req, res) );
//        });
    }


}