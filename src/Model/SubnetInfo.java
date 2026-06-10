package Model;

public class SubnetInfo {
    // VARIABLES
    private String rede;
    private String broadcast;
    private String primeiroHost;
    private String ultimoHost;
    private long quantidadeHost;

    // GETTER AND SETTER

    public String getRede() {
        return rede;
    }

    public void setRede(String rede) {
        this.rede = rede;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getPrimeiroHost() {
        return primeiroHost;
    }

    public void setPrimeiroHost(String primeiroHost) {
        this.primeiroHost = primeiroHost;
    }

    public String getUltimoHost() {
        return ultimoHost;
    }

    public void setUltimoHost(String ultimoHost) {
        this.ultimoHost = ultimoHost;
    }

    public long getQuantidadeHost() {
        return quantidadeHost;
    }

    public void setQuantidadeHost(long quantidadeHost) {
        this.quantidadeHost = quantidadeHost;
    }
}
