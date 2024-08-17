import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scannerOne = new Scanner(System.in);
        Scanner scannerSecond = new Scanner(System.in);
        Scanner scannerThird = new Scanner(System.in);
        Winner winner = new Winner();
        System.out.println("Добро пожаловать на Леман 24, вам предстоит самим назначить 3х участников заезда и узнать, кто из них сможет забать золото!\nБудьте внимательны, скорость на гоночной трассе не может превышать 250км/ч, но и стоять на месте тоже нельзя");

        //Первый автомобиль
        System.out.println("Введите название автомобиля");
        String nameOne = scannerOne.nextLine();
        System.out.println("С какой скоростью будет двигаться автомобиль " + nameOne + "?");
        double speedOne = scannerOne.nextDouble();
        Car carOne = new Car (nameOne, speedOne);
        carOne.carSpeed = carOne.speedTest(speedOne);
        System.out.println("Отлично, автомобиль " + carOne.carName + " уже ворвался на трассу на скорости " + carOne.carSpeed + "км/ч, кто же станет его первым соперником?");

        //Второй автомобиль
        String nameSecond = scannerSecond.nextLine();
        System.out.println("С какой скоростью будет двигаться автомобиль " + nameSecond + "?");
        double speedSecond = scannerSecond.nextDouble();
        Car carSecond = new Car (nameSecond, speedSecond);
        carSecond.carSpeed = carSecond.speedTest(speedSecond);
        System.out.println("Отлично, автомобиль " + carSecond.carName + " ворвался на трассу на скорости " + carSecond.carSpeed + "км/ч, кто будет третьим участником?");

        //Третий автомобиль
        String nameThird = scannerThird.nextLine();
        System.out.println("С какой скоростью будет двигаться автомобиль " + nameThird + "?");
        double speedThird = scannerThird.nextDouble();
        Car carThird = new Car (nameThird, speedThird);
        carThird.carSpeed =  carThird.speedTest(speedThird);
        System.out.println("Отлично, автомобиль " + carThird.carName + " ворвался на трассу на скорости " + carThird.carSpeed + "км/ч, все участники в сборе, кто же преодолеет наибольшее расстояние до конца гонки?");

        //Печатаю результаты гонки для наглядности
        System.out.println("Пора подвести итоги:");
        double[] distance = {carOne.carSpeed*24, carSecond.carSpeed*24, carThird.carSpeed*24};
        System.out.println("Участник " + carOne.carName + " преодолел " + distance[0] + "км");
        System.out.println("Участник " + carSecond.carName + " преодолел " + distance[1] + "км");
        System.out.println("Участник " + carThird.carName + " преодолел " + distance[2] + "км");

        winner.whoIs(carOne, carSecond, carThird);
        System.out.println(winner.winnerName);

    }
}


class Car {
    String carName;
    double carSpeed;

    Car(String carName, double carSpeed) {
        this.carName = carName;
        this.carSpeed = carSpeed;
    }
    // Метод для проверки допустимого значения скорости
    double speedTest (double speed){
        Scanner scanner = new Scanner(System.in);
        while (speed <= 0 || speed > 250) {
            System.out.println("Для этой гонки скорость неподходящая, попробуйте другое значение");
            speed = scanner.nextDouble();
        }
        return (speed);
    }
}

class Winner{
    String winnerName;

    //Метод для определения победителя с учетом возможного равенства и ничьей
    void whoIs (Car car1, Car car2, Car car3){
        if (car1.carSpeed > car2.carSpeed && car2.carSpeed > car3.carSpeed) {
            winnerName = "Поздравляем победителя нашего заезда - " + car1.carName;
        }
        if (car2.carSpeed > car1.carSpeed && car2.carSpeed > car3.carSpeed){
            winnerName = "Поздравляем победителя нашего заезда - " + car2.carName;
        }
        if (car3.carSpeed > car2.carSpeed && car3.carSpeed > car1.carSpeed) {
            winnerName = "Поздравляем победителя нашего заезда - " + car3.carName;
        }
        if (car2.carSpeed == car1.carSpeed && car2.carSpeed > car3.carSpeed){
            winnerName = "Поздравляем победителей нашего заезда - " + car1.carName + " и " + car2.carName;
        }
        if (car2.carSpeed == car3.carSpeed && car2.carSpeed > car1.carSpeed){
            winnerName = "Поздравляем победителей нашего заезда" + car3.carName + " и " + car2.carName;
        }
        if (car1.carSpeed == car3.carSpeed && car2.carSpeed < car1.carSpeed){
            winnerName = "Поздравляем победителей нашего заезда" + car1.carName + " и " + car3.carName;
        }
        if (car2.carSpeed == car1.carSpeed && car2.carSpeed == car3.carSpeed){
            winnerName = "Всеобщая ничья!!!";
        }
    }
}



