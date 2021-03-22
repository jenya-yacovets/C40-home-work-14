package by.tms.clinic.entity.threads;

import by.tms.clinic.config.Config;
import by.tms.clinic.entity.Patient;
import by.tms.clinic.factories.PatientFactory;

import java.util.Queue;

public class PatientThread extends Thread {

    private Queue<Patient> queue;
    private boolean isWork;

    public PatientThread(Queue<Patient> queue) {
        this.queue = queue;
        isWork = true;
    }

    public void disable() {
        isWork = false;
    }

    @Override
    public void run() {
        while (isWork) {
            queue.offer(PatientFactory.getPatient());
            try {
                Thread.sleep(Config.TIME_GENERATED_PATIENT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
