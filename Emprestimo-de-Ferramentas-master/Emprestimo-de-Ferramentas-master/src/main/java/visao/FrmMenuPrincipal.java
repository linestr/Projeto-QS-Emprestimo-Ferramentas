package visao;

/**
 * Classe responsável pela interface do menu principal.
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Construtor da classe FrmMenuPrincipal.
     */
    public FrmMenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        JMEmprestimo = new javax.swing.JMenu();
        CadastroAmigo = new javax.swing.JMenuItem();
        CadastroFerramenta = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        RelatorioAmigos = new javax.swing.JMenuItem();
        RelatorioFerramentas = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        jMenuBar1.setBorder(null);

        JMEmprestimo.setBorder(null);
        JMEmprestimo.setText("Cadastros");
        JMEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMEmprestimoActionPerformed(evt);
            }
        });

        CadastroAmigo.setText("Amigo");
        CadastroAmigo.setBorder(null);
        CadastroAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroAmigoActionPerformed(evt);
            }
        });
        JMEmprestimo.add(CadastroAmigo);

        CadastroFerramenta.setText("Ferramenta");
        CadastroFerramenta.setBorder(null);
        CadastroFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroFerramentaActionPerformed(evt);
            }
        });
        JMEmprestimo.add(CadastroFerramenta);

        jMenuItem1.setText("Empréstimo");
        jMenuItem1.setBorder(null);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JMEmprestimo.add(jMenuItem1);

        jMenuBar1.add(JMEmprestimo);

        jMenu2.setText("Relatórios");

        RelatorioAmigos.setText("Amigos");
        RelatorioAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioAmigosActionPerformed(evt);
            }
        });
        jMenu2.add(RelatorioAmigos);

        RelatorioFerramentas.setText("Ferramentas");
        RelatorioFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioFerramentasActionPerformed(evt);
            }
        });
        jMenu2.add(RelatorioFerramentas);

        jMenu1.setText("Empréstimos");

        jMenuItem3.setText("Todos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("Ativos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenu2.add(jMenu1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastroAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroAmigoActionPerformed
        // TODO add your handling code here:
        FrmCadastroAmigo objTela = new FrmCadastroAmigo();
        objTela.setVisible(true);
    }//GEN-LAST:event_CadastroAmigoActionPerformed

    private void CadastroFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroFerramentaActionPerformed
        // TODO add your handling code here:
        FrmCadastroFerramenta objTela = new FrmCadastroFerramenta();
        objTela.setVisible(true);
    }//GEN-LAST:event_CadastroFerramentaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        FrmCadastroEmprestimo objTela = new FrmCadastroEmprestimo();
        objTela.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void JMEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMEmprestimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMEmprestimoActionPerformed

    private void RelatorioAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioAmigosActionPerformed
        // TODO add your handling code here:
        FrmRelatorioAmigo objTela = new FrmRelatorioAmigo();
        objTela.setVisible(true);
    }//GEN-LAST:event_RelatorioAmigosActionPerformed

    private void RelatorioFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioFerramentasActionPerformed
        // TODO add your handling code here:
        FrmRelatorioFerramenta objTela = new FrmRelatorioFerramenta();
        objTela.setVisible(true);
    }//GEN-LAST:event_RelatorioFerramentasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        FrmRelatorioEmprestimo objTela = new FrmRelatorioEmprestimo();
        objTela.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        FrmRelatorioAtivos objTela = new FrmRelatorioAtivos();
        objTela.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadastroAmigo;
    private javax.swing.JMenuItem CadastroFerramenta;
    private javax.swing.JMenu JMEmprestimo;
    private javax.swing.JMenuItem RelatorioAmigos;
    private javax.swing.JMenuItem RelatorioFerramentas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}
