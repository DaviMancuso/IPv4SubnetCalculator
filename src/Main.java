import Model.SubnetInfo;
import Service.SubnetCalculator;

void main() {
    SubnetCalculator calculator = new SubnetCalculator();
    SubnetInfo info = calculator.calcular("192.168.1.10/26");
    System.out.println("Hosts: " + info.getQuantidadeHost());
}
