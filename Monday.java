import java.util.Scanner;
import java.time.LocalTime;

interface Alarm {
    void setAlarm(String time);
    void showAlarm();
}

abstract class Weekday implements Alarm {}

public class Monday extends Weekday {
    String time;

    public void setAlarm(String time) {
        this.time = time;
    }

    public void showAlarm() {
        LocalTime alarm = LocalTime.parse(this.time);
        LocalTime now = LocalTime.now();

        if (alarm.isAfter(now)) {
            System.out.println("Alarm is set for tomorrow!");
        } else if (alarm.isBefore(now)) {
            System.out.println("I'll wake you up later!");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Monday mon = new Monday();

        System.out.print("Enter time for alarm in this format (HH:MM): ");
        mon.setAlarm(in.nextLine());
        mon.showAlarm();
    }
}