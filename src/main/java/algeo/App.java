package algeo;

import algeo.core.Matrix;
import algeo.io.MatrixIO;

public class App {
  public static void main(String[] args) {
    System.out.println("Hai");
    menu();
  }

  public static void menu() {
    System.out.println("Selamat datang di Kalkulator keren!");
    Matrix namaMatrix = MatrixIO.inputMatrix();
    System.out.println("Matriks yang Anda masukkan adalah:");
    System.out.println(namaMatrix);
  }
}

// ====== MAIN GUI EXAMPLE ======
// Be sure to uncoment the section below and follow the steps written in README

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.stage.Stage;
// public class App extends Application {

//     @Override
//     public void start(Stage stage) {
//         ModuleContoh m = new ModuleContoh();

//         Label label = new Label("Hello JavaFX from Algeo 1!");
//         Scene scene = new Scene(label, 300, 200);

//         stage.setTitle("Matrix Calculator");
//         stage.setScene(scene);
//         stage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
