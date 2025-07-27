# Gilded Rose Refactoring Kata

This repository contains my solution to the classic **Gilded Rose Refactoring Kata**, a programming exercise focused on safely refactoring legacy code while maintaining existing behavior.

---

## 📋 Project Overview

The Gilded Rose Kata is a common coding challenge where you improve the structure and readability of a legacy codebase managing an inventory system, without breaking its functionality.

My objective was to apply best practices in testing and refactoring to deliver clean, maintainable, and well-tested code.

---

## 🧪 Testing Strategy

- **Comprehensive Unit Tests**  
  I started by writing extensive unit tests to cover all business rules and edge cases handled by the original code. This ensured confidence that no behavior would be broken during refactoring.

- **Code Coverage with JaCoCo**  
  Used the JaCoCo plugin to measure test coverage and verify that every branch and instruction was exercised by tests, achieving close to 100% coverage.

- **Mutation Testing with Pitest**  
  Applied mutation testing to assess the quality and effectiveness of tests. Achieved a mutation score of 100%, confirming that tests reliably detect faults.

---

## 🔨 Refactoring Approach

- **Stepwise Refactoring**  
  Refactoring was done incrementally, running tests between each step to guarantee the code remained functional.

- **Improved Code Structure**  
  - Moved quality update logic into the `Item` class for better encapsulation.  
  - Used constants to replace magic numbers for clarity.  
  - Replaced complex conditional logic with cleaner switch statements and ternary operators.  
  - Isolated common code outside of conditionals for simplification.  
  - Ensured special cases like "Sulfuras" were handled explicitly.

- **Code Style and Quality Tools**  
  Integrated Checkstyle and PMD for static code analysis, applying recommendations such as using varargs and cleaning up ternary operator syntax.

---

## 🎯 Outcome & Benefits

- Code is now **easier to read and maintain** with clear separation of concerns.  
- Refactoring preserved **all original behaviors** as ensured by thorough testing.  
- Improved **test quality and robustness** with mutation testing feedback.  
- Demonstrated proficiency with **testing frameworks, static analysis, and refactoring techniques**.

---

## 🛠️ Technologies Used

- Java  
- JUnit (unit testing)  
- JaCoCo (code coverage)  
- Pitest (mutation testing)  
- Gradle (build automation)  
- Checkstyle & PMD (static code analysis)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👤 Author

Mark Ballereau  
[LinkedIn](https://www.linkedin.com/in/markblre) | [GitHub](https://github.com/markblre)
