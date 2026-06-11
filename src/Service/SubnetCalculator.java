package Service;

import Model.SubnetInfo;

public class SubnetCalculator {
    public SubnetInfo calcular(String entrada) {

        String[] partes = entrada.split("/", -1);

        // VALIDATION IP/CIDR

        if (partes.length != 2) {
            throw new IllegalArgumentException("Formato esperado: IP/CDIR");
        }

        // VALIDATION EMPTY FIELD

        if (partes[0].isBlank() || partes[1].isBlank()) {
            throw new IllegalArgumentException("IP e CDIR devem ser informados!");
        }

        String ip = partes[0];
        int cidr;

        // VALIDATION CIDR

        try {
            cidr = Integer.parseInt(partes[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("CIDR inválido!");
        }

        // VALIDATION IP

        if (!validarIp(ip)) {
            throw new IllegalArgumentException("IP inválido!");
        }

        // CALCULATE HOST          *** ENV ***

        long hosts = calcularHost(cidr);
        long ipLong = ipParaLong(ip);

        SubnetInfo info = new SubnetInfo();
        info.setQuantidadeHost(hosts);

        // MASK                     *** ENV ***

        long mascara = calcularMascara(cidr) & 0xFFFFFFFFL;
        String mascsaraIp = longParaIp(mascara);

        // CALCULATE NETWORK        *** ENV ***

        long rede = calcularRede(ipLong,mascara);
        info.setRede(longParaIp(rede));


        //BROADCAST                 *** ENV ***

        long broadcast   = calcularBroadcast(rede,mascara);
        info.setBroadcast(longParaIp(broadcast));

        // PRIMARY AND LAST HOST     *** ENV ***

        long primeiroHost = calcularPrimeiroHost(rede,cidr);
        long ultimoHost = calcularUltimoHost(broadcast,cidr);

        info.setPrimeiroHost(longParaIp(primeiroHost));
        info.setUltimoHost(longParaIp(ultimoHost));
        return info;


    }

    // VALIDATION IP    *** CALCULATE ****

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

    // CALCULATE HOST  *** CALCULATE ***

    private long calcularHost(int cidr) {
        if (cidr < 0 || cidr > 32) {
            throw new IllegalArgumentException("O CIDR deve estar entre 0 e 32");
        }
        if (cidr == 32) return 1;
        if (cidr == 31) return 2;
        return (1L << (32 - cidr)) - 2;
    }

    // CONVERT IP TO LONG OR LONG TO IP  *** CALCULATE ***

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

    // CREATE MASK TO IP  PRIMARY  *** CALCULATE ***

    private long calcularMascara(int cidr) {
        return (-1L <<(32 - cidr));
    }

    // CALCULATE NETWORK     *** CALCULATE ***

    private long calcularRede(long ipLong, long mascara) {
        return ipLong & mascara;
    }

    // CALCULATE BROADCAST  *** CALCULATE ***

    private long calcularBroadcast(long rede, long mascara) {
        long mascaraInvertida = (~mascara) & 0xFFFFFFFFL;
        return rede | mascaraInvertida;
    }

    // CALCULATE PRIMARY HOST  *** CALCULATE ***

    private long calcularPrimeiroHost(long rede, int cidr) {

        if (cidr == 31 || cidr == 32) {
            return rede;
        }
        return rede + 1;

    }

    // CALCULATE PRIMARY HOST  *** CALCULATE ***

    private long calcularUltimoHost(long broadcast, int cidr) {

        if (cidr == 31 || cidr == 32) {
            return broadcast;
        }

        return broadcast -1;
    }
}
