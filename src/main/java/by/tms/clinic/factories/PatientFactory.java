package by.tms.clinic.factories;

import by.tms.clinic.config.Config;
import by.tms.clinic.entity.Patient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class PatientFactory {

    private static Random random = new Random();
    private static List<String> names;

    static {
        try {
            names = Files.readAllLines(Paths.get(Config.FILE_PATIENTS_NAMES));
        } catch (IOException e) {
            System.out.println("Не удалось прочесть список имен пациентов.");
        }
    }

    public static Patient getPatient() {
        String name = names.get(random.nextInt(names.size()));

        int age = random.nextInt(100);
        return new Patient(name, age);
    }
}
