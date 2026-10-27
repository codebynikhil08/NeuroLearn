import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstraction: common structure for different types of learners.
abstract class Learner {
    protected String name;
    protected int age;
    protected List<Integer> marks;

    public Learner(String name, int age) {
        this.name = name;
        this.age = age;
        this.marks = new ArrayList<>();
    }

    public void addMarks(int score) {
        if (score >= 0 && score <= 100) {
            marks.add(score);
            System.out.println("Marks added successfully!");
        } else {
            System.out.println("Marks must be between 0 and 100.");
        }
    }

    public double calculateAverage() {
        if (marks.isEmpty()) {
            return 0;
        }

        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.size();
    }

    public String getName() {
        return name;
    }

    public abstract void generateRecommendation();
}

// Inheritance: CollegeStudent inherits from Learner.
class CollegeStudent extends Learner {
    private double studyHours;
    private double sleepHours;
    private int stressLevel;

    public CollegeStudent(String name, int age) {
        super(name, age);
        this.studyHours = 0;
        this.sleepHours = 0;
        this.stressLevel = 1;
    }

    public void recordDailyRoutine(double studyHours, double sleepHours, int stressLevel) {
        if (studyHours < 0 || studyHours > 24
                || sleepHours < 0 || sleepHours > 24
                || stressLevel < 1 || stressLevel > 10
                || studyHours + sleepHours > 24) {
            System.out.println("Invalid routine data. Check hours and stress level.");
            return;
        }

        this.studyHours = studyHours;
        this.sleepHours = sleepHours;
        this.stressLevel = stressLevel;
        System.out.println("Daily routine recorded!");
    }

    // Encapsulation: risk calculation is kept inside this class.
    public String detectBurnoutRisk() {
        int riskScore = 0;

        if (studyHours > 8) {
            riskScore += 2;
        } else if (studyHours > 6) {
            riskScore += 1;
        }

        if (sleepHours < 6) {
            riskScore += 2;
        } else if (sleepHours < 7) {
            riskScore += 1;
        }

        if (stressLevel >= 8) {
            riskScore += 2;
        } else if (stressLevel >= 6) {
            riskScore += 1;
        }

        if (riskScore >= 4) {
            return "HIGH";
        } else if (riskScore >= 2) {
            return "MODERATE";
        }
        return "LOW";
    }

    // Polymorphism: overrides the abstract method from Learner.
    @Override
    public void generateRecommendation() {
        double average = calculateAverage();
        String risk = detectBurnoutRisk();

        System.out.println("\\n--- Personalized Learning Report ---");
        System.out.println("Student: " + name);
        System.out.printf("Average Marks: %.2f/100%n", average);
        System.out.println("Workload Risk Indicator: " + risk);

        if (marks.isEmpty()) {
            System.out.println("Academic suggestion: Add marks to analyze performance.");
        } else if (average < 40) {
            System.out.println("Academic suggestion: Revise fundamentals and practice daily.");
        } else if (average < 70) {
            System.out.println("Academic suggestion: Practice questions from weaker topics.");
        } else {
            System.out.println("Academic suggestion: Try advanced problems and mock tests.");
        }

        if (risk.equals("HIGH")) {
            System.out.println("Well-being suggestion: Consider reducing workload and prioritizing rest.");
        } else if (risk.equals("MODERATE")) {
            System.out.println("Well-being suggestion: Schedule breaks and monitor stress.");
        } else {
            System.out.println("Well-being suggestion: Maintain a balanced routine.");
        }
        System.out.println("------------------------------------");
    }
}

public class NeuroLearn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       NEUROLEARN SYSTEM");
        System.out.println("=================================");

        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            sc.close();
            return;
        }

        System.out.print("Enter age: ");
        if (!sc.hasNextInt()) {
            System.out.println("Age must be a whole number.");
            sc.close();
            return;
        }
        int age = sc.nextInt();

        if (age < 1 || age > 120) {
            System.out.println("Invalid age.");
            sc.close();
            return;
        }

        CollegeStudent student = new CollegeStudent(name, age);
        int choice;

        do {
            System.out.println("\\n1. Add Marks");
            System.out.println("2. Record Daily Routine");
            System.out.println("3. View Learning Report");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 4.");
                sc.next();
                choice = 0;
                continue;
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter marks (0-100): ");
                    if (sc.hasNextInt()) {
                        student.addMarks(sc.nextInt());
                    } else {
                        System.out.println("Marks must be a whole number.");
                        sc.next();
                    }
                    break;

                case 2:
                    System.out.print("Study hours today: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                        break;
                    }
                    double study = sc.nextDouble();

                    System.out.print("Sleep hours last night: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                        break;
                    }
                    double sleep = sc.nextDouble();

                    System.out.print("Stress level (1-10): ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Stress level must be a whole number.");
                        sc.next();
                        break;
                    }
                    int stress = sc.nextInt();
                    student.recordDailyRoutine(study, sleep, stress);
                    break;

                case 3:
                    student.generateRecommendation();
                    break;

                case 4:
                    System.out.println("Thank you for using NeuroLearn!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
