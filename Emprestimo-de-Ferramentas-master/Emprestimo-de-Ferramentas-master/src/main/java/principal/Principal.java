package principal;

import visao.FrmMenuPrincipal;

/**
 * Classe Principal que inicia a aplicação.
 */
public class Principal {

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args Argumentos de linha de comando.
     */
    public static void main(String[] args) {
        FrmMenuPrincipal objetoTela = new FrmMenuPrincipal();
        objetoTela.setVisible(true);
    }
}