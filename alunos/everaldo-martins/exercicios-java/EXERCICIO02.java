public class EXERCICIO02 {
    public static double celsiusToFahrenheit(double graus){
        return (graus * 1.8) + 32;
    }

    public static void main(String[]args){
        double celsius = 25.5;
        System.out.println(celsius + " °C em Fahrenheit são " + celsiusToFahrenheit(celsius) + " °F");        
    }
}
