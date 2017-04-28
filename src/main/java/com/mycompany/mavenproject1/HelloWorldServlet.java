package com.mycompany.mavenproject1;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

@WebServlet(value="/helloWorld", name="helloWorldServlet")
public class HelloWorldServlet extends HttpServlet {

    /*public static void main(String[] args)
            throws IOException, MalformedURLException, JSONException {

        // declaring object of "OpenWeatherMap" class
        OpenWeatherMap owm = new OpenWeatherMap("");

        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("Bochum");

        //printing city name from the retrieved data
        System.out.println("Stadt: " + cwd.getCityName());

        // printing the max./min. temperature
        System.out.println("Temperatur: " + cwd.getMainInstance().getMaxTemperature()
                            + "/" + cwd.getMainInstance().getMinTemperature() + "\'F");
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // declaring object of "OpenWeatherMap" class
        OpenWeatherMap owm = new OpenWeatherMap("d5baeddbca603edb14a2b26102719cfe");

        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("Bochum");

        //printing city name from the retrieved data
        resp.getWriter().print("Stadt: " + cwd.getCityName());

        // printing the max./min. temperature
        resp.getWriter().print("Temperatur: " + cwd.getMainInstance().getMaxTemperature()
                            + "/" + cwd.getMainInstance().getMinTemperature() + "\'F");
        
        resp.setStatus(200);
        resp.setHeader("Content-Type", "application/json");
        resp.getWriter().print("{\"stadt\": \"hello, world!\"}");
    }

}
