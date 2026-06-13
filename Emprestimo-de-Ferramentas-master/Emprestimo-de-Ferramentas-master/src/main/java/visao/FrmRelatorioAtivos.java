package visao;

import com.google.protobuf.TextFormat;
import dao.ConexaoDAO;
import dao.EmprestimoDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Emprestimo;
import modelo.Data;

/**
 * Classe responsável pela exibição do relatório de empréstimos ativos.
 */
public class FrmRelatorioAtivos extends javax.swing.JFrame {

    private ConexaoDAO connect;
    private Emprestimo objEmprestimo = new Emprestimo();
    private EmprestimoDAO dao = new EmprestimoDAO();

    /**
 * Classe responsável pela exibição do relatório de empréstimos ativos.
 */
    public FrmRelatorioAtivos() {
        initComponents();
        carregaTabelaEmprestimos();
    }

    /**
     * Método responsável por carregar a tabela de empréstimos ativos.
     */
    public void carregaTabelaEmprestimos() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
        modelo.setNumRows(0);
        for (Emprestimo a : dao.getEmprestimosAtivos()) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getIdAmg(),
                a.getDataEmprestimo(),
                a.getDataDevolucao(),
                a.isEntregue()});
        }
    }

    /**
     * Método para alterar o id de empréstimo da ferramenta.
     * @param id O id do empréstimo.
     * @return Verdadeiro se a operação for bem-sucedida, falso caso contrário.
     */
    public boolean alterarIdEmpFerramenta(int id) {
        String sql = "UPDATE tb_ferramentas SET id_emprestimo = null WHERE id_emprestimo = ?";
        try {
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();

            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JCBEntregue = new javax.swing.JCheckBox();
        JTFDataEmp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFDataDev = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JBAlterar = new javax.swing.JButton();
        JBApagar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatorio de Emprestimos Ativos");

        JCBEntregue.setBorder(null);
        JCBEntregue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JCBEntregue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBEntregueActionPerformed(evt);
            }
        });

        JTFDataEmp.setEditable(false);
        JTFDataEmp.setBackground(new java.awt.Color(166, 166, 166));
        JTFDataEmp.setForeground(new java.awt.Color(255, 255, 255));
        JTFDataEmp.setBorder(null);

        jLabel4.setText("Empréstimo:");

        JTFDataDev.setBorder(null);

        JBCancelar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        JBCancelar.setText("Fechar");
        JBCancelar.setBorder(null);
        JBCancelar.setContentAreaFilled(false);
        JBCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBAlterar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        JBAlterar.setText("Alterar");
        JBAlterar.setBorder(null);
        JBAlterar.setContentAreaFilled(false);
        JBAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });

        JBApagar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        JBApagar.setText("Apagar");
        JBApagar.setBorder(null);
        JBApagar.setContentAreaFilled(false);
        JBApagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBApagar.setDefaultCapable(false);
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "ID_Amigo", "Data Empréstimo", "Data Devolução", "Entregue"
            }
        ));
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable.setShowGrid(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel1.setText("Devolução:");

        jLabel.setText("Confirmar Entrega:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(JTFDataEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(JTFDataDev, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(JBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(JBApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCBEntregue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(JTFDataEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFDataDev, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCBEntregue)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCBEntregueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBEntregueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBEntregueActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
        // TODO add your handling code here:
        try {
            int id = 0;
            if (this.jTable.getSelectedRow() == -1) {
                throw new Mensagem(
                    "Primeiro Selecione um Empréstimo para ALTERAR");
            } else {
                id = Integer.parseInt(this.jTable.getValueAt(this.jTable.getSelectedRow(), 0).toString());
            }

            String regex = "\\d{4}-\\d{2}-\\d{2}";
            Date dataDevolucao = null;
            Date dataEmprestimo = Data.stringParaDateSQL(JTFDataEmp.getText());
            boolean Entregue = false;

            if (this.JTFDataDev.getText().matches(regex)) {
                dataDevolucao = Data.stringParaDateSQL(JTFDataDev.getText());
                if (dataDevolucao.before(dataEmprestimo)) {
                    dataDevolucao = null;
                    throw new Mensagem("Data de Devolução não pode ser antes da Data do Empréstimo");

                } else if (dataDevolucao.after(dataEmprestimo)) {
                    dataDevolucao = Data.stringParaDateSQL(JTFDataDev.getText());
                } else {
                    dataDevolucao = null;
                    throw new Mensagem("Data de Devolução não pode ser igual a da Data do Empréstimo");
                }
            } else {
                throw new Mensagem("Data de Devolução deve conter o seguite formato:\nyyyy-MM-dd");
            }
            if (JCBEntregue.isSelected()) {
                int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que este Empréstimo foi finalizado?");

                if (respostaUsuario == 0) {
                    if (JCBEntregue.isSelected()) {
                        Entregue = true;
                        alterarIdEmpFerramenta(id);
                    }

                } else {
                    return;
                }
            }

            if (this.objEmprestimo.alterarEmprestimo(dataDevolucao, Entregue, id)) {
                this.JTFDataDev.setText("");
                this.JCBEntregue.setSelected(false);
                JOptionPane.showMessageDialog(rootPane, "Empréstimo Alterado com Sucesso!");
            }
            System.out.println(this.dao.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        } catch (TextFormat.ParseException | ParseException ex) {
            Logger.getLogger(FrmRelatorioEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            carregaTabelaEmprestimos();
        }
    }//GEN-LAST:event_JBAlterarActionPerformed

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
        // TODO add your handling code here:
        try {
            int id = 0;
            if (this.jTable.getSelectedRow() == -1) {
                throw new Mensagem(
                    "Primeiro Selecione um Empréstimo para APAGAR");
            } else {
                id = Integer.parseInt(this.jTable.getValueAt(this.jTable.getSelectedRow(), 0).toString());

                boolean Ver = dao.verificarPendencia(id);
                if (Ver == true) {
                    JOptionPane.showMessageDialog(null, "Esse Empréstimo está pendente "
                        + "\n   e não pode ser excluido");
                } else {
                    int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este Empréstimo?");

                    if (respostaUsuario == 0) {
                        if (alterarIdEmpFerramenta(id) && this.objEmprestimo.apagarEmprestimo(id)) {
                            JOptionPane.showMessageDialog(rootPane, "Empréstimo Apagado com Sucesso!");
                        }
                    }
                }
            }
            System.out.println(this.dao.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabelaEmprestimos();
        }
    }//GEN-LAST:event_JBApagarActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        if (this.jTable.getSelectedRow() != -1) {
            String dataDev = this.jTable.getValueAt(this.jTable.getSelectedRow(), 3).toString();
            String dataEmp = this.jTable.getValueAt(this.jTable.getSelectedRow(), 2).toString();

            this.JTFDataDev.setText(dataDev);
            this.JTFDataEmp.setText(dataEmp);
        }
    }//GEN-LAST:event_jTableMouseClicked

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
            java.util.logging.Logger.getLogger(FrmRelatorioAtivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorioAtivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorioAtivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorioAtivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRelatorioAtivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JCheckBox JCBEntregue;
    private javax.swing.JTextField JTFDataDev;
    private javax.swing.JTextField JTFDataEmp;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
