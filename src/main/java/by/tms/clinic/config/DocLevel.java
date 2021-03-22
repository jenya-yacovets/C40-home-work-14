package by.tms.clinic.config;

public enum DocLevel {
    INTERN {
        public String getValue() {
            return "Интерн";
        }
        public int getSpeed() {
            return 10 * 1000;
        }
    },
    STANDARD {
        public String getValue() {
            return "Обычный врач";
        }
        public int getSpeed() {
            return 7 * 1000;
        }
    },
    MANAGER {
        public String getValue() {
            return "Зав. отделение";
        }
        public int getSpeed() {
            return 5 * 1000;
        }
    };

    public abstract String getValue();
    public abstract int getSpeed();
}
