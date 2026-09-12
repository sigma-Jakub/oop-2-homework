package com.nhlstenden.hospital.device;

import com.nhlstenden.hospital.users.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BloodPressureMonitorTest
{
    @Test
    void checkStatus_normalValues_returnNormalStatus()
    {
        Patient patient = new Patient("Jakub", LocalDate.now().minusYears(20), "M", 75, 119, 80, true);
        BloodPressureMonitor monitor = new BloodPressureMonitor();
        assertEquals(Device.NORMAL_STATUS_VALUE, monitor.checkStatus(patient));
    }

    @Test
    void checkStatus_warningValues_returnWarningStatus()
    {
        Patient patient = new Patient("Jakub", LocalDate.now().minusYears(20), "M", 75, 121, 80, true);
        BloodPressureMonitor monitor = new BloodPressureMonitor();
        assertEquals(Device.WARNING_STATUS_VALUE, monitor.checkStatus(patient));
    }

    @Test
    void checkStatus_criticalValues_returnCriticalStatus()
    {
        Patient patient = new Patient("Jakub", LocalDate.now().minusYears(20), "M", 75, 119, 111, true);
        BloodPressureMonitor monitor = new BloodPressureMonitor();
        assertEquals(Device.CRITICAL_STATUS_VALUE, monitor.checkStatus(patient));
    }
}