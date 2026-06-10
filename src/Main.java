import Model.SubnetInfo;
import Service.SubnetCalculator;

void main() {
    SubnetCalculator calculator = new SubnetCalculator();
    SubnetInfo info = calculator.calcular("300.168.1.10/24");
    System.out.println(info);
}git
