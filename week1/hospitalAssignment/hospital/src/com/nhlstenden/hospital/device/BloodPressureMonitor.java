package com.nhlstenden.hospital.device;

import com.nhlstenden.hospital.users.Patient;

public class BloodPressureMonitor extends Device
{
    private static final int SYSTOLIC_NORMAL_THRESHOLD = 120;
    private static final int SYSTOLIC_WARNING_THRESHOLD = 140;
    private static final int SYSTOLIC_CRITICAL_THRESHOLD = 180;
    private static final int DIASTOLIC_NORMAL_THRESHOLD = 80;
    private static final int DIASTOLIC_WARNING_THRESHOLD = 90;
    private static final int DIASTOLIC_CRITICAL_THRESHOLD = 110;

    public String checkStatus(Patient patient)
    {
        int s = patient.getSystolicPressure();
        int d = patient.getDiastolicPressure();

        if (s > SYSTOLIC_CRITICAL_THRESHOLD && d > DIASTOLIC_CRITICAL_THRESHOLD)
        {
            return CRITICAL_STATUS_VALUE;
        }
        else if ((s > SYSTOLIC_WARNING_THRESHOLD || s < SYSTOLIC_NORMAL_THRESHOLD) && (d > DIASTOLIC_WARNING_THRESHOLD || d < DIASTOLIC_NORMAL_THRESHOLD))
        {
            return WARNING_STATUS_VALUE;
        }
        else //missing in assignment what if bloodPressure == 120?
        {
            return NORMAL_STATUS_VALUE;
        }
    }
}
