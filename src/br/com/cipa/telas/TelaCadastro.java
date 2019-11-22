/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cipa.telas;

import javax.swing.JOptionPane;
import java.sql.*;

import java.awt.HeadlessException;
import br.com.cipa.dal.conexao;

/**
 *
 * @author debs
 */
public class TelaCadastro extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
        conexao = br.com.cipa.dal.conexao.conector();
        initComponents();
    }

    //Cadastra Candidato
    private void adicionar() {
        String sql = ("insert into cad_candidato(numero,nome,apelido,setor,idade,tempo) values(?,?,?,?,?,? )");
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCadNumero.getText());
            pst.setString(2, txtCadNome.getText());
            pst.setString(3, txtCadApelido.getText());
            pst.setString(4, txtCadSetor.getText());
            pst.setString(5, txtCadIdade.getText());
            pst.setString(6, txtCadData.getText());

            if ((txtCadNumero.getText().isEmpty()) || (txtCadNome.getText().isEmpty()) || (txtCadApelido.getText().isEmpty()) || (txtCadSetor.getText().isEmpty()) || (txtCadIdade.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios!");
            } else {
                int add = pst.executeUpdate();
                if (add > 0) { //0 falso e 1 Ok 
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso! ");
                    txtCadNumero.setText(null);
                    txtCadNome.setText(null);
                    txtCadApelido.setText(null);
                    txtCadSetor.setText(null);
                    txtCadIdade.setText(null);
                    txtCadData.setText(null);

                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //Edita Candidato
    private void edita_candidadato() {
        String sql = "update cad_candidato set nome=?,apelido=?,setor=?,idade=?,tempo=? where numero = ?";
        try {
            pst = conexao.prepareStatement(sql);
            //Seta os valores para Alterar no banco de dados
            pst.setString(1, txtCadNome.getText());
            pst.setString(2, txtCadApelido.getText());
            pst.setString(3, txtCadSetor.getText());
            pst.setString(4, txtCadIdade.getText());
            pst.setString(5, txtCadData.getText());
            pst.setString(6, txtCadNumero.getText());
            
            if ((txtCadNumero.getText().isEmpty()) || (txtCadNome.getText().isEmpty()) || (txtCadApelido.getText().isEmpty()) || (txtCadSetor.getText().isEmpty()) || (txtCadIdade.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios!");
            } else {
                //Executa a Query que é responsavel para alterar os usuarios
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do cliente alterados com sucesso! ");

                    txtCadNumero.setText(null);
                    txtCadNome.setText(null);
                    txtCadApelido.setText(null);
                    txtCadSetor.setText(null);
                    txtCadIdade.setText(null);
                    txtCadData.setText(null);
                    btnAdd.setEnabled(true);
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
//Consulta Candidato
    private void consultar() {
        String sql = "select * from cad_candidato where numero =?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCadNumero.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtCadNome.setText(rs.getString(2));
                txtCadApelido.setText(rs.getString(3));
                txtCadSetor.setText(rs.getString(4));
                txtCadIdade.setText(rs.getString(5));
                txtCadData.setText(rs.getString(7));

            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                txtCadNumero.setText(null);
                txtCadNome.setText(null);
                txtCadApelido.setText(null);
                txtCadSetor.setText(null);
                txtCadIdade.setText(null);
                txtCadData.setText(null);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //REMOVE O CANDIDATO
    private void remove_candidato() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o Cliente ? ", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from cad_candidato where numero=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCadNumero.getText());
                int deletado = pst.executeUpdate();
                if (deletado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    txtCadNumero.setText(null);
                    txtCadNome.setText(null);
                    txtCadApelido.setText(null);
                    txtCadSetor.setText(null);
                    txtCadIdade.setText(null);
                    txtCadData.setText(null);
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(
            "unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCadNumero = new javax.swing.JTextField();
        txtCadNome = new javax.swing.JTextField();
        txtCadApelido = new javax.swing.JTextField();
        txtCadSetor = new javax.swing.JTextField();
        txtCadIdade = new javax.swing.JTextField();
        txtCadData = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        jLabel1.setText(" * Número: ");

        jLabel2.setText("* Nome:");

        jLabel3.setText("*Apelido:");

        jLabel4.setText("*Setor:");

        jLabel5.setText("*Idade:");

        jLabel6.setText("*Tempo de serviço:");

        txtCadNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadNumeroActionPerformed(evt);
            }
        });

        txtCadSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadSetorActionPerformed(evt);
            }
        });

        txtCadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadDataActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("* campos obrigatórios");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_add-user_46775.png"))); // NOI18N
        btnAdd.setMaximumSize(new java.awt.Dimension(64, 64));
        btnAdd.setMinimumSize(new java.awt.Dimension(64, 64));
        btnAdd.setPreferredSize(new java.awt.Dimension(64, 64));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cipa/imagens/iconfinder_edit-user_46799.png"))); // NOI18N
        btnEdit.setPreferredSize(new java.awt.Dimension(60, 60));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cipa/imagens/iconfinder_delete-user_46794.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cipa/imagens/iconfinder_Search_858732.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtCadData))
                    .addComponent(jLabel7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(34, 34, 34))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(28, 28, 28)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(39, 39, 39)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCadIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCadSetor, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                .addComponent(txtCadNome)
                                .addComponent(txtCadApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(txtCadNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCadNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCadNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCadApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCadSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCadIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCadData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        setBounds(0, 0, 637, 438);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Evento quando clicar no botão Edita o Candidato
        edita_candidadato();
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtCadSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadSetorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadSetorActionPerformed

    private void txtCadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadDataActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Evento quando clicar no botão Adiciona um candidato NO bd
        adicionar();
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Evento quando clicar no botão Remove um candidato no bd
        remove_candidato();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCadNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadNumeroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Evento quando clicar no botão consulta o candidato no bd
        consultar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCadApelido;
    private javax.swing.JTextField txtCadData;
    private javax.swing.JTextField txtCadIdade;
    private javax.swing.JTextField txtCadNome;
    private javax.swing.JTextField txtCadNumero;
    private javax.swing.JTextField txtCadSetor;
    // End of variables declaration//GEN-END:variables
}
