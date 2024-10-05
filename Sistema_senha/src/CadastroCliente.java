public class CadastroCliente {
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    public CadastroCliente (String nome, String email, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }


    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    // Getters e setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Getters e setters
    public String getTelefone() { return telefone; }
    public void setTelefone(String email) { this.telefone = telefone; }

    // Getters e setters
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereço) { this.endereco = endereco; }



}
