import java.util.Scanner;

interface IVehicle {
    default void Drive() {}
    default void Refuel() {}
}

class Car implements IVehicle {
    String CarMark;
    String CarModel;
    int FuelType;

    public void carinfo(String CarMark, String CarModel, int FuelType) {
        this.CarMark = CarMark;
        this.CarModel = CarModel;
        this.FuelType = FuelType;
        System.out.printf("Mark = %s, Model = %s, FuelType = %d%n", CarMark, CarModel, FuelType);
    }

    @Override
    public void Drive() {
        System.out.println("Car edet");
    }

    @Override
    public void Refuel() {
        System.out.println("Car zapravka");
    }
}

class Moto implements IVehicle {
    String MotoType;
    double EngineObiem;

    public void motoinfo(String MotoType, double EngineObiem) {
        this.MotoType = MotoType;
        this.EngineObiem = EngineObiem;
        System.out.printf("MotoType = %s, Engine Obiem = %.1f%n", MotoType, EngineObiem);
    }

    @Override
    public void Drive() {
        System.out.println("Moto edet");
    }

    @Override
    public void Refuel() {
        System.out.println("Moto zapravka");
    }
}

class Truck implements IVehicle {
    int Gruzpodem;
    int OssCount;

    public void truckinfo(int Gruzpodem, int OssCount) {
        this.Gruzpodem = Gruzpodem;
        this.OssCount = OssCount;
        System.out.printf("Gruzpodem = %d, Oss = %d%n", Gruzpodem, OssCount);
    }

    @Override
    public void Drive() {
        System.out.println("Truck edet");
    }

    @Override
    public void Refuel() {
        System.out.println("Truck zapravka");
    }
}
class Bus implements IVehicle {
    String Busname;
    int Busmesta;

    public void businfo(String Busname, int Busmesta) {
        this.Busname = Busname;
        this.Busmesta = Busmesta;
        System.out.printf("Name = %s, Mesta = %s%n", Busname, Busmesta);
    }

    @Override
    public void Drive() {
        System.out.println("Bus edet");
    }

    @Override
    public void Refuel() {
        System.out.println("Bus zapravka");
    }
}

abstract class VehicleFactory {
    abstract IVehicle CreateVehicle();
}

class CarFactory extends VehicleFactory {
    @Override
    IVehicle CreateVehicle() {
        return new Car();
    }
}

class MotoFactory extends VehicleFactory {
    @Override
    IVehicle CreateVehicle() {
        return new Moto();
    }
}

class TruckFactory extends VehicleFactory {
    @Override
    IVehicle CreateVehicle() {
        return new Truck();
    }
}
class Busfactory extends VehicleFactory {
    @Override
    IVehicle CreateVehicle() {
        return new Bus();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Car 2 - Moto 3 - Truck 4 - Bus");
        int num = scanner.nextInt();

        IVehicle vehicle = null;
        switch (num) {
            case 1:
                vehicle = createCar(scanner);
                break;
            case 2:
                vehicle = createMoto(scanner);
                break;
            case 3:
                vehicle = createTruck(scanner);
                break;
            case 4:
                vehicle = createBus(scanner);
                break;
            default:
                System.out.println("ot 1 do 4");
        }

        if (vehicle != null) {
            vehicle.Drive();
            vehicle.Refuel();
        }

        scanner.close();
    }

    public static Car createCar(Scanner scanner) {
        System.out.println("Car mark = ");
        String mark = scanner.next();
        System.out.println("Car model = ");
        String model = scanner.next();
        System.out.println("Car fueltype = ");
        int fuelType = scanner.nextInt();

        CarFactory carFactory = new CarFactory();
        Car car = (Car) carFactory.CreateVehicle();
        car.carinfo(mark, model, fuelType);
        return car;
    }

    public static Moto createMoto(Scanner scanner) {
        System.out.println("Moto type = ");
        String motoType = scanner.next();
        System.out.println("Moto obiem = ");
        double engineObiem = scanner.nextDouble();

        MotoFactory motoFactory = new MotoFactory();
        Moto moto = (Moto) motoFactory.CreateVehicle();
        moto.motoinfo(motoType, engineObiem);
        return moto;
    }

    public static Truck createTruck(Scanner scanner) {
        System.out.println("Truck gruz = ");
        int gruzpodem = scanner.nextInt();
        System.out.println("Truck oss = ");
        int ossCount = scanner.nextInt();

        TruckFactory truckFactory = new TruckFactory();
        Truck truck = (Truck) truckFactory.CreateVehicle();
        truck.truckinfo(gruzpodem, ossCount);
        return truck;
    }
    public static Bus createBus(Scanner scanner) {
        System.out.println("Bus name = ");
        String name = scanner.next();
        System.out.println("Bus mesta = ");
        int mesta = scanner.nextInt();

        Busfactory busfactory = new Busfactory();
        Bus bus = (Bus) busfactory.CreateVehicle();
        bus.businfo(name, mesta);
        return bus;
    }
}
