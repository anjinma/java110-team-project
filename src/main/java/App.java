public class App {
    String danger="담배좀그만펴연 일찍죽으니깐";
    public String getGreeting() {
        return danger;
        //올린건가??
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        System.out.println("집집집집");
        
        System.out.println("갈땐 가더라도 담배한대정도는 괜잖아?");
    }
}