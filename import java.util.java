import java.util.HashMap;

public class RegistroClientes {
    private HashMap<Integer, Cliente> tabelaHash;

    public RegistroClientes() {
        tabelaHash = new HashMap<>();
    }

    public void adicionarCliente(String nome, String telefone, String cpf, String email) {
        int chaveHash = calcularChaveHash(cpf);
        Cliente cliente = new Cliente(nome, telefone, cpf, email);
        tabelaHash.put(chaveHash, cliente);
    }

    public Cliente buscarCliente(String cpf) {
        int chaveHash = calcularChaveHash(cpf);
        return tabelaHash.get(chaveHash);
    }

    private int calcularChaveHash(String cpf) {
        
        return cpf.hashCode();
    }

    public static void main(String[] args) {
        RegistroClientes registro = new RegistroClientes();

        
        registro.adicionarCliente("João", "123456789", "123.456.789-01", "joao@example.com");
        registro.adicionarCliente("Maria", "987654321", "987.654.321-09", "maria@example.com");

        
        Cliente clienteEncontrado = registro.buscarCliente("123.456.789-01");
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.getNome());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}

class Cliente {
    private String nome;
    private String telefone;
    private String cpf;
    private String email;

    public Cliente(String nome, String telefone, String cpf, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    
}
