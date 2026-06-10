package Service;

import Model.SubnetInfo;

public class SubnetCalculator {
    public SubnetInfo calcular(String entrada) {

        //METHOD

        String[] partes = entrada.split("/");
        String ip = partes[0];
        int cidr = Integer.parseInt(partes[1]);

        // VALIDATION IP

        if (!validarIp(ip)) {
            throw new IllegalArgumentException("IP inválido!");
        }

        long hosts = calcularHost(cidr);
        long ipLong = ipParaLong(ip);

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

    // CONVERT IP TO LONG

    private long ipParaLong(String ip) {

        String[] octetos = ip.split("\\.");
        long resultado = 0;

        for(String octeto: octetos) {
            resultado = (resultado << 8)
                    | Integer.parseInt(octeto); // Desloca 8 bits e adiciona o próximo octeto ao número final
        }
        return resultado;
    }

    private String longParaIp(long valor) {
        return ((valor >> 24) & 255) + "." +
                ((valor >> 16) & 255) + "." +
                ((valor >> 8) & 255) + "." +
                (valor & 255);
    }
}
