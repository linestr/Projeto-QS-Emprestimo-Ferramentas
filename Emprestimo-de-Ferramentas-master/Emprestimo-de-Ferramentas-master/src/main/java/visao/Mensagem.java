package visao;

/**
 * Classe que representa uma mensagem de exceção personalizada.
 */
public class Mensagem extends Exception {

    /**
     * Construtor que cria uma nova mensagem de exceção com a mensagem especificada.
     *
     * @param msg A mensagem de exceção.
     */
    Mensagem(String msg) {
        super(msg);
    }
}