import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Servico> servicos = new ArrayList<>();
    private ArrayList<Atendimento> atendimentos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main sistema = new Main();  // Corrigido para "Main"
        sistema.menu();
    }

    public void menu() {
        int opcao = 0;
        do {
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Serviço");
            System.out.println("3. Agendar Atendimento");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarServico();
                    break;
                case 3:
                    agendarAtendimento();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    public void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone, endereco);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarServico() {
        System.out.print("Nome do Serviço: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Servico servico = new Servico(nome, descricao, valor);
        servicos.add(servico);
        System.out.println("Serviço cadastrado com sucesso!");
    }

    public void agendarAtendimento() {
        if (clientes.isEmpty() || servicos.isEmpty()) {
            System.out.println("Cadastre clientes e serviços antes de agendar.");
            return;
        }

        System.out.println("Escolha o cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        int clienteIndex = scanner.nextInt() - 1;

        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }

        System.out.println("Escolha o serviço:");
        for (int i = 0; i < servicos.size(); i++) {
            System.out.println((i + 1) + ". " + servicos.get(i).getNome());
        }
        int servicoIndex = scanner.nextInt() - 1;

        if (servicoIndex < 0 || servicoIndex >= servicos.size()) {
            System.out.println("Serviço inválido.");
            return;
        }

        System.out.print("Data e Hora (DD-MM-AAAA-HH:MM): ");
        String dataHoraInput = scanner.next();
        try {
            LocalDateTime dataHora = LocalDateTime.parse(dataHoraInput);
            Atendimento atendimento = new Atendimento(clientes.get(clienteIndex), servicos.get(servicoIndex), dataHora);
            atendimentos.add(atendimento);
            System.out.println("Atendimento agendado com sucesso!");
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data e hora inválido. Use o formato DD-MM-AAAA-HH:MM.");
        }
    }
}
