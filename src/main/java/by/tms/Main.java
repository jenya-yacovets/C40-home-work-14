package by.tms;

import by.tms.clinic.config.DocLevel;
import by.tms.clinic.entity.Doctor;
import by.tms.clinic.entity.threads.DoctorThread;
import by.tms.clinic.entity.Patient;
import by.tms.clinic.entity.threads.PatientThread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {

        System.out.println("+++ Врачи начали работу +++");

        Queue<Patient> queue = new ConcurrentLinkedQueue<>();

        // Создаю поток который будет добавлять пациентов в очередь
        PatientThread patientThread = new PatientThread(queue);
        patientThread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // создаем потоки для каждого доктора
        DoctorThread doc1 = new DoctorThread(queue, new Doctor("Семен Семенович", DocLevel.INTERN));
        doc1.start();

        DoctorThread doc2 = new DoctorThread(queue, new Doctor("Иван Натанович", DocLevel.STANDARD));
        doc2.start();

        DoctorThread doc3 = new DoctorThread(queue, new Doctor("Андрей Евгеньевич", DocLevel.MANAGER));
        doc3.start();

        try {
            doc1.join();
            doc2.join();
            doc3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- Все врачи закончили принимать пациентов и ушли домой ---");
    }
}
