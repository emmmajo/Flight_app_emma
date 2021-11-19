package Networks;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FlightSearchApi {

    //below values are hard coded for testing purposes ks 11/4/21
    String depLocation = "SMF", depDate = "2021-12-27", destination = "NYC", tripType = "ROUND_TRIP";
    int passengers = 1;

    private static final String baseApiUrl = "priceline-com-provider.p.rapidapi.com";
    private static final String apiKey = "b8ed4a331emsh2558b300bd3706cp19a0eajsnf48565dc015e";


    public FlightSearchApi() {
    }


    public static String searchFlights(String depLocation, String depDate, String destination, String tripType, int passengers)
    {
        String p = Integer.toString(passengers);
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();
        urlBuilder.addQueryParameter("apiKey", apiKey);
        urlBuilder.addQueryParameter("sort_order", "PRICE"); //hard coded
        urlBuilder.addQueryParameter("depLocation", depLocation);
        urlBuilder.addQueryParameter("departure", depDate); //format yyyy-mm-dd
        urlBuilder.addQueryParameter("class_type", "ECO"); //hard coded
        urlBuilder.addQueryParameter("location_arrival", destination);
        urlBuilder.addQueryParameter("itinerary_type", tripType); //string ONE_WAY or ROUND_TRIP
        urlBuilder.addQueryParameter("number_of_passengers", p);

        String url = urlBuilder.build().toString();

        return getResponse(url);
    }

    private static String getResponse(String url)
    {
        Request request = new Request.Builder().url(url).build();

        OkHttpClient client = new OkHttpClient();
        try{
            Response response = client.newCall(request).execute();
            return response.body().string();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}