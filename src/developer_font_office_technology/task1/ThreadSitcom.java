package developer_font_office_technology.task1;

public class ThreadSitcom {
    public static void main(String[] args) {
        class chandlerTalks implements Runnable {
            @Override
            public void run() {
                System.out.println("Chandler: Hey.");
                System.out.println("Chandler: And This from the cry-for-help department. Are you wearing makeup?");
            }
        }
        Thread chandler = new Thread(new chandlerTalks());

        class joeyTalks implements Runnable {
            @Override
            public void run() {
                System.out.println("Joey: Hey, hey.");
                System.out.println("Joey: Yes, I am. As of today, I am officially Joey Tribbiani, actor slash model.");
                System.out.println("Joey: You know those posters for the City Free Clinic?");
                System.out.println("Joey: Ho, but I hear lyme disease is open, so... (crosses fingers)");
                System.out.println("Joey: Thanks.");
            }
        }
        Thread joey = new Thread(new joeyTalks());

        class monicaTalks implements Runnable{
            @Override
            public void run() {
                System.out.println("Monica: What were you modeling for?");
            }
        }
        Thread monica = new Thread(new monicaTalks());
        class phoebeTalks implements Runnable{
            @Override
            public void run() {
                System.out.println("Phoebe: Hey.");
                System.out.println("Phoebe: You know, the asthma guy was really cute.");
            }
        }
        Thread phoebe = new Thread(new phoebeTalks());
        class rachelTalks implements Runnable{
            @Override
            public void run(){
                System.out.println("Rachel: You know, you can see where they cut my bangs too short.");
            }
        }
        Thread rachel = new Thread(new rachelTalks());
        class rossTalks implements Runnable{
            @Override
            public void run() {
                System.out.println("Ross: We were on a break!");
            }
        }
        Thread ross = new Thread(new rossTalks());

        chandler.start();
        joey.start();
        monica.start();
        phoebe.start();
        rachel.start();
        ross.start();
    }
}
