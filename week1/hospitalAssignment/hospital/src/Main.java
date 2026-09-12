import com.nhlstenden.hospital.device.BloodPressureMonitor;
import com.nhlstenden.hospital.device.HeartMonitor;
import com.nhlstenden.hospital.users.Patient;

import java.time.LocalDate;

public static void main(String[] args)
{
    Patient jakub = new Patient("Jakub", LocalDate.now().minusYears(21), "F", 110, 120, 80, true);
    BloodPressureMonitor monitor = new BloodPressureMonitor();
    HeartMonitor heartMonitor = new HeartMonitor();

    System.out.println(heartMonitor.checkStatus(jakub));
}
