import java.time.LocalDateTime;

public class Atendimento {
    private Cliente cliente;
    private Servico servico;
    private LocalDateTime dataHora;

    public Atendimento(Cliente cliente, Servico servico, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    // Getters e setters
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    @Override
    public String toString() {
        return "Atendimento agendado para " + cliente.getNome() + " com o serviço " + servico.getNome() + " na data/hora " + dataHora;
    }
}
