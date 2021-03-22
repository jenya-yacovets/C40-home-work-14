package by.tms.clinic.entity.threads;

import by.tms.clinic.config.Config;
import by.tms.clinic.entity.Doctor;
import by.tms.clinic.entity.Patient;

import java.util.Queue;

public class DoctorThread extends Thread {

    private Queue<Patient> queue;
    private Doctor doctor;

    public DoctorThread(Queue<Patient> queue, Doctor doctor) {
        this.queue = queue;
        this.doctor = doctor;
    }

    @Override
    public void run() {
        System.out.println("=== Доктор " + doctor.getName() + " начал работу");
        while (true) {

            if (queue.size() > Config.MAX_PATIENTS_QUEUE) {
                System.out.println("### В очереди слишком много пациентов и доктор " + doctor.getName() + " ушел домой");
                return;
            }

            Patient currentPatient = queue.poll();

            if (currentPatient == null) {
                try {
                    Thread.sleep(Config.INTERVAL_WAIT_PATIENT);
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Доктор " + doctor.getName() + " сейчас лечит пациента " + currentPatient.getName());

            try {
                Thread.sleep(doctor.getLevel().getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
