package WeatherForecastByCity.App;
import IpmaApi.Client.*;
import java.util.logging.Logger;

public class App 
{
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main( String[] args )
    {
        if(args.length != 1){
            System.out.println("Please add only one argument (City name)");
            // Terminate JVM
            System.exit(0);
        }

        Client c = new Client();

        logger.info(c.GetTemperature(args[0]));
 
        // Terminate JVM
        System.exit(0);
    }
}
