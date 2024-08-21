import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double winnerSpeed = 0;
        String winnerName = "";
        System.out.println("Добро пожаловать на Леман 24, вам предстоит самим назначить 3х участников заезда и узнать, кто из них сможет забать золото!\nБудьте внимательны, скорость на гоночной трассе не может превышать 250км/ч, но и стоять на месте тоже нельзя");

        for (int i = 0; i < 3; i++) {
            double speed = 0;
            Car car = new Car();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название автомобиля");
            car.carName = scanner.nextLine();
            System.out.println("С какой скоростью будет двигаться автомобиль " + car.carName + "?");
            car.carSpeed = car.speedTest(speed);
                if (winnerSpeed < car.carSpeed) {
                    winnerSpeed = car.carSpeed;
                    winnerName = car.carName;
                }
                System.out.println("Отлично, автомобиль " + car.carName + " ворвался на трассу на скорости " + car.carSpeed + "км/ч");
            }
            System.out.println("Автомобиль " + winnerName + " преодолел " + winnerSpeed * 24 + "км, поздравляем его с победой!");
    }
}



    class Car {
        String carName;
        double carSpeed;

        // Метод для проверки допустимого значения скорости
        double speedTest(double speed) {
            Scanner isDouble = new Scanner(System.in);
            while (speed == 0) {
                if (isDouble.hasNextDouble()) {
                    speed = isDouble.nextDouble();
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Значение скорости не подходит для этой трассы");
                    }
                } else {
                    System.out.println("Некорректное значение скорости");
                    isDouble.next();
                }
                speed = 0;
            }
            return speed;
        }
    }







