/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cipa.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import br.com.cipa.dal.conexao;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import br.com.cipa.dal.conexao;
import java.awt.Color;

/**
 *
 * @author Debora F
 */
public class TelaDoVoto extends javax.swing.JInternalFrame {
    //Prepara conexao com o banco de dados

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //Armazena texto de acodo com o radio button Selecionado
    private String tipo;

    public TelaDoVoto() {
        initComponents();

        //chamando metodo conector / atribuir conexao ;
        //Mudar a conexao
        conexao = br.com.cipa.dal.conexao.conector();
        initComponents();
    }

    //Pesquisa o candidado no banco de dados
    private void pesquisar_candidato() {
        //Pega o numero do candidato
        String numero = txtNumeroVoto.getText();
        String sql = "select * from cad_candidato where numero = " + numero;
        try {
            //Prepara a conexao
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {

                //Seta os valores
                txtVotoNome.setText(rs.getString(2));
                txtVotoApelido.setText(rs.getString(3));
                txtVotoSetor.setText(rs.getString(4));
                txtVotoIdade.setText(rs.getString(5));
                txtVotoTempo.setText(rs.getString(7));

                //Desabilitando oque não esta usando para não ter problemas dps
                txtVotoNome.setEditable(true);
                txtVotoApelido.setEditable(true);
                txtVotoSetor.setEditable(true);
                txtVotoIdade.setEditable(true);
                txtVotoTempo.setEditable(true);

            } else {
                JOptionPane.showMessageDialog(null, "Candidato não foi encontrado");
            }
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "Os Invalida");
            System.out.println(e);
            /*} catch (HeadlessException | SQLException e2) {
            JOptionPane.showMessageDialog(null, e2);*/
        }

    }
    //Ir para o menu principal

    private void cancelar() {

        MenuPrincipal principal = new MenuPrincipal();
        principal.setVisible(true);
        MenuPrincipal.menu.setEnabled(true);
        MenuPrincipal.menuModVisu.setEnabled(false);
        MenuPrincipal.menuVoto.setEnabled(false);
        MenuPrincipal.menuCadastro.setEnabled(false);

    }

    //Adicionar voto
   Candidato cand = new Candidato();
   

    

    

    private void adicionar_voto(int num) {
        String sql = ("insert into cad_candidato(qnt_voto) values(?)");
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, num);
            int add = pst.executeUpdate();
            if (add > 0) { //0 falso e 1 Ok 
                JOptionPane.showMessageDialog(null, "Voto  adicionado com sucesso! ");

            }
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "invalida");
            System.out.println(e);
            /*} catch (HeadlessException | SQLException e2) {
            JOptionPane.showMessageDialog(null, e2);*/
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroVoto = new javax.swing.JTextField();
        txtVotoNome = new javax.swing.JTextField();
        txtVotoApelido = new javax.swing.JTextField();
        txtVotoSetor = new javax.swing.JTextField();
        txtVotoIdade = new javax.swing.JTextField();
        txtVotoTempo = new javax.swing.JTextField();
        brnConfirma = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVotar = new javax.swing.JButton();
        btnBranco = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("NUMERO:");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );

        jLabel2.setText("Nome:");

        jLabel3.setText("Apelido:");

        jLabel4.setText("Setor:");

        jLabel5.setText("Idade:");

        jLabel6.setText("Tempo de Serviço:");

        txtNumeroVoto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtVotoIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVotoIdadeActionPerformed(evt);
            }
        });

        brnConfirma.setBackground(new java.awt.Color(0, 204, 51));
        brnConfirma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        brnConfirma.setForeground(new java.awt.Color(0, 204, 0));
        brnConfirma.setText("CONFIRMAR");
        brnConfirma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 0), new java.awt.Color(0, 204, 51), new java.awt.Color(0, 204, 0), new java.awt.Color(0, 204, 0)));
        brnConfirma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brnConfirmaMouseClicked(evt);
            }
        });
        brnConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnConfirmaActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(204, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(255, 0, 0)));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnVotar.setText("Pesquisar");
        btnVotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVotarActionPerformed(evt);
            }
        });

        btnBranco.setText("branco");
        btnBranco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(brnConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(162, 162, 162))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVotoNome)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtVotoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtVotoApelido)
                                    .addComponent(txtVotoSetor)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28)
                                .addComponent(txtVotoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(txtNumeroVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVotar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBranco)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumeroVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVotar)
                            .addComponent(btnBranco))))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtVotoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtVotoApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtVotoSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtVotoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVotoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brnConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brnConfirmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brnConfirmaMouseClicked

    }//GEN-LAST:event_brnConfirmaMouseClicked

    private void brnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnConfirmaActionPerformed


    }//GEN-LAST:event_brnConfirmaActionPerformed

    private void txtVotoIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVotoIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVotoIdadeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //caso o botao cancelar seja clicado 
        cancelar();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBrancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrancoActionPerformed
        // TODO add your handling code here:
        cancelar();
    }//GEN-LAST:event_btnBrancoActionPerformed

    private void btnVotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVotarActionPerformed
        //pequisa candidato no banco de dados;
        pesquisar_candidato();

    }//GEN-LAST:event_btnVotarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnConfirma;
    private javax.swing.JButton btnBranco;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVotar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNumeroVoto;
    private javax.swing.JTextField txtVotoApelido;
    private javax.swing.JTextField txtVotoIdade;
    private javax.swing.JTextField txtVotoNome;
    private javax.swing.JTextField txtVotoSetor;
    private javax.swing.JTextField txtVotoTempo;
    // End of variables declaration//GEN-END:variables
}
