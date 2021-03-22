package by.tms.clinic.entity.threads;

import by.tms.clinic.config.Config;
import by.tms.clinic.entity.Patient;
import by.tms.clinic.factories.PatientFactory;

import java.util.Queue;

public class PatientThread extends Thread {

    private Queue<Patient> queue;

    public PatientThread(Queue<Patient> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            if (queue.size() > Config.MAX_PATIENTS_QUEUE) {
                System.out.println("### В очереди больше " + Config.MAX_PATIENTS_QUEUE + " пациентов и поэтому регестратура закрывается");
                return;
            }

            queue.offer(PatientFactory.getPatient());

            try {
                Thread.sleep(Config.TIME_GENERATED_PATIENT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
