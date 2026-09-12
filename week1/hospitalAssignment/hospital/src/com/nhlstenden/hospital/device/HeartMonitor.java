package com.nhlstenden.hospital.device;

import com.nhlstenden.hospital.users.Patient;

public class HeartMonitor extends Device
{
    private static final int MALE_NORMAL_THRESHOLD = 60;
    private static final int MALE_WARNING_THRESHOLD = 75;
    private static final int MALE_CRITICAL_THRESHOLD = 100;
    private static final int FEMALE_NORMAL_THRESHOLD = 70;
    private static final int FEMALE_WARNING_THRESHOLD = 80;
    private static final int FEMALE_CRITICAL_THRESHOLD = 110;

    public HeartMonitor()
    {
    }

    @Override
    public String checkStatus(Patient patient)
    {
        if (patient.getSex().equals("F"))
        {
            int f = patient.getHeartRate();

            if (f >= FEMALE_NORMAL_THRESHOLD && f <= FEMALE_WARNING_THRESHOLD)
            {
                return NORMAL_STATUS_VALUE;
            }
            else if (f > FEMALE_WARNING_THRESHOLD && f <= FEMALE_CRITICAL_THRESHOLD)
            {
                return WARNING_STATUS_VALUE;
            }
            else
            {
                return CRITICAL_STATUS_VALUE;
            }
        }
        else if (patient.getSex().equals("M"))
        {
            int m = patient.getHeartRate();

            if (m >= MALE_NORMAL_THRESHOLD && m <= MALE_WARNING_THRESHOLD)
            {
                return NORMAL_STATUS_VALUE;
            }
            else if (m > MALE_WARNING_THRESHOLD && m <= MALE_CRITICAL_THRESHOLD)
            {
                return WARNING_STATUS_VALUE;
            }
            else
            {
                return CRITICAL_STATUS_VALUE;
            }
        }
        else
        {
            return ERROR_MESSAGE_VALUE;
        }
    }
}
