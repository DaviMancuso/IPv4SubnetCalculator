package Service;

import Model.SubnetInfo;

public class SubnetCalculator {
    public SubnetInfo calcular(String entrada) {
        String[] partes = entrada.split("/");

        String ip = partes[0];
        int cidr = Integer.parseInt(partes[1]);

        if (!validarIp(ip)) {
            throw new IllegalArgumentException("IP inválido!");
        }
        return new SubnetInfo();
    }

    // VALIDATION METHOD

    private boolean validarIp(String ip) {

        String[] octetos = ip.split("\\.");

        if (octetos.length != 4) {
            return false;
        }

        for (String octeto : octetos) {
            int numero = Integer.parseInt(octeto); // TRANSFORMATION LENGTH IN INTEGER

            if (numero < 0 || numero > 255) {
                return false;
            }
        }
        return true;
    }
}
