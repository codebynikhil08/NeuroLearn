# 🧠 NeuroLearn — Adaptive Learning & Student Well-being Tracker

NeuroLearn is a Java console application built to demonstrate Object-Oriented Programming (OOP). It tracks student marks and study habits, then provides simple academic and routine suggestions.

## Features

- Create a student profile
- Add marks and calculate the average
- Record daily study hours, sleep duration, and a self-reported stress level
- Generate a rule-based workload risk indicator
- Provide personalized academic and routine suggestions
- Interactive menu-driven console interface
- Basic validation of user input

## Problem Statement

Students may follow fixed study routines without considering academic performance, workload, or rest. NeuroLearn combines basic performance analysis and study-habit tracking to offer simple, personalized suggestions in one lightweight Java application.

## Tech Stack

- Java (JDK 8 or later)
- `ArrayList` and `List`
- `Scanner`
- Command-line interface (CLI)

## OOP Concepts Demonstrated

| Concept | Where it is used |
|---|---|
| Classes and objects | `Learner`, `CollegeStudent`, and the `student` object |
| Encapsulation | Private routine fields and internal risk calculation |
| Inheritance | `CollegeStudent extends Learner` |
| Abstraction | Abstract `Learner` class and `generateRecommendation()` |
| Polymorphism | Overridden `generateRecommendation()` method |
| Constructors | Initialize learner and student objects |
| Collections | `List<Integer>` stores marks |

## Requirements

- JDK 8 or later
- A terminal or Java IDE such as VS Code, IntelliJ IDEA, or Eclipse

## Run locally

1. Clone the repository:

   ```bash
   git clone https://github.com/YOUR-USERNAME/NeuroLearn.git
   ```

2. Open the folder:

   ```bash
   cd NeuroLearn
   ```

3. Compile:

   ```bash
   javac NeuroLearn.java
   ```

4. Run:

   ```bash
   java NeuroLearn
   ```

Replace `YOUR-USERNAME` with your GitHub username.

## How to Use

1. Enter a name and age.
2. Select **Add Marks** to record a score.
3. Select **Record Daily Routine** to enter study hours, sleep hours, and stress level.
4. Select **View Learning Report** to see the average, risk indicator, and suggestions.
5. Select **Exit** to close the application.

## Example workflow

```text
Enter student name: Rahul
Enter age: 19

1. Add Marks
2. Record Daily Routine
3. View Learning Report
4. Exit
Enter choice: 1
Enter marks (0-100): 85
Marks added successfully!
```

## Future Improvements

- Subject-wise performance tracking
- File or database storage for student records
- Interfaces and multiple recommendation strategies
- Custom exception handling
- GUI using Java Swing or JavaFX
- Weekly performance reports and charts

## Disclaimer

The workload risk indicator is based on simple predefined rules for educational demonstration. It is not a medical assessment or a validated burnout prediction model.

## Author

Created as a Java Object-Oriented Programming learning project.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE).
