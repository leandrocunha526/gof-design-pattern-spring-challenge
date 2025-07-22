# Explorando Padrões de Projetos na Prática com Java usando Spring

API usando Spring Boot para salvar cliente com endereço usando o Via CEP.

Exemplo de requisição em `localhost:8080/clientes` (POST):

```json
{
  "nome": "João da Silva",
  "endereco": {
    "cep": "01001000"
  }
}
```

Repositório com as implementações dos padrões de projeto explorados no Lab "Explorando Padrões de Projetos na Prática com Java". Especificamente, este projeto explorou alguns padrões usando Java com Spring:

Singleton
Strategy
Facade

🔒 1. Singleton (Padrão Criacional)
✔ Intenção:
Garante que uma classe tenha apenas uma instância, e fornece um ponto global de acesso a ela.

📌 Aplicações:
Classes que acessam recursos compartilhados (como conexão com banco, cache, logs etc.).

Gerenciamento centralizado de configurações.

🧠 Estrutura:

```java
public class Singleton {
    private static Singleton instancia;

    private Singleton() {
        // Construtor privado impede instâncias externas
    }

    public static Singleton getInstancia() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }
}
```

✅ Benefícios:
Controla o acesso a recursos globais.

Reduz consumo desnecessário de memória.

🧠 2. Strategy (Padrão Comportamental)
✔ Intenção:
Permite definir uma família de algoritmos e encapsulá-los, tornando-os intercambiáveis. O Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.

📌 Aplicações:
Quando há múltiplas maneiras de realizar uma operação, como cálculo de frete, ordenações, ou operações matemáticas.

🧠 Estrutura:

```java
// Interface
public interface Comportamento {
    void mover();
}

// Estratégias concretas
public class ComportamentoAgressivo implements Comportamento {
    public void mover() {
        System.out.println("Movendo-se agressivamente");
    }
}

public class Robo {
    private Comportamento comportamento;

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    public void mover() {
        comportamento.mover();
    }
}
```

✅ Benefícios:
Reduz uso de condicionais (if/else ou switch).

Torna o código mais flexível e extensível.

🎩 3. Facade (Padrão Estrutural)
✔ Intenção:
Fornece uma interface simplificada para um subconjunto de funcionalidades complexas de um sistema.

📌 Aplicações:
Quando você quer ocultar a complexidade de subsistemas.

Para simplificar o uso de APIs ou sistemas legados.

🧠 Estrutura:

```java
public class Facade {
    private SistemaA sistemaA;
    private SistemaB sistemaB;

    public Facade() {
        this.sistemaA = new SistemaA();
        this.sistemaB = new SistemaB();
    }

    public void migrarCliente(String nome, String cep) {
        String cidade = sistemaA.buscarCidade(cep);
        sistemaB.salvarCliente(nome, cep, cidade);
    }
}
```

✅ Benefícios:
Reduz o acoplamento entre subsistemas.

Torna o código cliente mais limpo e compreensível.

Para acessar o DB: <localhost:8080/h2-console>  
Para acessar o Swagger: <http://localhost:8080/swagger-ui/index.html>

**Desafio DIO**
