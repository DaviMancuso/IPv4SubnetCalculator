import Model.SubnetInfo;
import Service.SubnetCalculator;

void main() {
    SubnetCalculator calculator = new SubnetCalculator();
    SubnetInfo info = calculator.calcular("9.168.10.1/24");
    System.out.println("Rede: " + info.getRede());
    System.out.println("Broadcast: " + info.getBroadcast());
    System.out.println("Primeiro Host: " + info.getPrimeiroHost());
    System.out.println("Último Host: " + info.getUltimoHost());
    System.out.println("Hosts: " + info.getQuantidadeHost());
    System.out.println("Tipo de rede: " + info.getTipoRede());
    System.out.println("Binário (rede): " + info.getBinarioRede());

}
