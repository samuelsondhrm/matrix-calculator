# Matrix Calculator - Linear Algebra and Geometry Course Project

## Short Description
This project is a CLI-based **Matrix Calculator** implementation for the Linear Algebra and Geometry Course (Tugas Besar 1) 2025/2026. Built using **Java 21** and **Maven**, it provides various matrix operations, system of linear equations solvers, as well as interpolation and regression applications.

## Features & Implementation
Based on the source code, this application includes the following features:

### 1. System of Linear Equations (SLE)
Solves `Ax = b` using:
- Gaussian Elimination
- Gauss-Jordan Elimination
- Inverse Matrix Method
- Cramer's Rule

### 2. Determinant
Calculates matrix determinant using:
- Row Reduction Method
- Cofactor Expansion Method

### 3. Inverse Matrix
Finds the inverse of a matrix using:
- Adjoint Method
- Identity Matrix Method (Augmented Matrix / Gauss-Jordan)

### 4. Matrix Applications
- **Polynomial Interpolation**: Estimates polynomial functions from data points.
- **Bicubic / Spline Interpolation**: Implementation of Bezier curves (`BezierSpline`).
- **Multiple Linear Regression**: Determines multivariate polynomial regression models (`MultivariatePolynomialRegression`).

### 5. Input/Output
- Supports standard keyboard input (CLI).
- Reads matrices from `.txt` files.
- Saves calculation results to output files.

## Code Structure
The source code is organized modularly within the `algeo` package:

```text
src/main/java/algeo/
├── App.java                    # Entry point (Main Class)
├── core/                       # Basic data structures
│   ├── Matrix.java             # Matrix object class
│   ├── MatrixOps.java          # Basic operations (add, subtract, multiply, transpose)
│   └── NumberFmt.java          # Number formatter
├── spl/                        # SLE algorithms (Gauss, GaussJordan, Cramer, etc.)
├── determinant/                # Determinant algorithms (Cofactor, RowReduction)
├── inverse/                    # Inverse algorithms (Adjoint, Augment)
├── interpolasi/                # Interpolation logic (Polynomial, BezierSpline)
├── regression/                 # Regression logic (MultivariatePolynomialRegression)
└── io/                         # Input/Output management & Menu Interface
```

## System Requirements
As configured in `pom.xml`, ensure you have the following installed:

* **Java Development Kit (JDK):** Version **21** or later.
* **Apache Maven:** Version **3.9.x** or later.

## How to Run

### 1. Compilation
Navigate to the project root directory (where `pom.xml` is located) and run:

```bash
mvn clean compile
```

### 2. Running the Application
The application runs in CLI mode. Execute the following command:
```bash
mvn exec:java
```
Once running, an interactive menu will appear in the terminal to guide you through the operations.

### 3. Packaging (Optional)
If you wish to build an executable .jar file for distribution:
```bash
mvn clean package
```
The jar file will be available in the target/matrix-calculator-1.0-SNAPSHOT.jar directory.
