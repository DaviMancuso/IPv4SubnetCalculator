package Service;

import Model.SubnetInfo;

public class SubnetCalculator {
    public SubnetInfo calcular(String entrada) {
        //METHOD

        String[] partes = entrada.split("/");
        String ip = partes[0];
        int cidr = Integer.parseInt(partes[1]);
        long hosts = calcularHost(cidr);

        // VALIDATION IP

        if (!validarIp(ip)) {
            throw new IllegalArgumentException("IP inválido!");
        }

        // CALCULATE HOST

        SubnetInfo info = new SubnetInfo();
        info.setQuantidadeHost(hosts);
        return info;
    }

    // VALIDATION METHOD

    private boolean validarIp(String ip) {

        String[] octetos = ip.split("\\.");

        if (octetos.length != 4) {
            return false;
        }

        for (String octeto : octetos) {

            try {
                int numero = Integer.parseInt(octeto); // TRANSFORMATION LENGTH IN INTEGER

                if (numero < 0 || numero > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    // CALCULATE HOST

    private long calcularHost(int cidr) {
        if (cidr < 0 || cidr > 32) {
            throw new IllegalArgumentException("O CIDR deve estar entre 0 e 32");
        }
        if (cidr == 32) return 1;
        if (cidr == 31) return 2;
        return (1L << (32 - cidr)) - 2;
    }
}
