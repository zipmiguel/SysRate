/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sysrate.tela;


import br.com.sysrate.dao.UsuarioDao;
import br.com.sysrate.entidade.Usuario;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;


/**
 *
 * @author migue
 */
public class LoginCadastro {

    private JPanel panelCadastro;
    private JPanel panelLogin;
    
    private JFrame janela;

    
    /**
     *
     */
    
    
    
            
    public LoginCadastro () throws SQLException {
        janela = new SysRate().janela();
        
        JTextField fieldMatriculaCadastro;
        JPasswordField fieldSenhaCadastro;
        JPasswordField fieldConfirmacaoSenhaCadastro;
        JButton buttonCadastrarse;
        JButton buttonCancelarCadastro;
        
        JTextField fieldMatriculaLogin;
        JPasswordField fieldSenhaLogin;
        JButton buttonEntrar;
        JButton buttonCancelarLogin;
        
        JLabel labelDicaSenha = new JLabel("?");
        labelDicaSenha.setBounds(405, 112, 90, 30);
        labelDicaSenha.setForeground(Color.DARK_GRAY);
        labelDicaSenha.setFont(new Font(null,Font.BOLD,16));
        
        JLabel labelAlterarSenha = new JLabel("Alterar Senha");
        labelAlterarSenha.setBounds(40, 550, 140, 30);
        labelAlterarSenha.setForeground(Color.LIGHT_GRAY);
        labelAlterarSenha.setFont(new Font(null,Font.BOLD,16));
        
        JLabel labelErroCadastro = new JLabel();
        labelErroCadastro.setBounds(125, 250, 300, 20);
        labelErroCadastro.setForeground(Color.RED);
        
        
        JLabel labelErroLogin = new JLabel();
        labelErroLogin.setBounds(160, 420, 260, 20);
        labelErroLogin.setForeground(Color.RED);
        
        
        janela.setVisible(true);
        
        panelCadastro = new JPanel();
        panelCadastro.setLayout(null);
        panelCadastro = painel(20, 180, 460, 280, "");
        panelCadastro.setBackground(Color.LIGHT_GRAY);
        panelCadastro.add(label("Primeiro Acesso?", 150, 20, 160, 20, 20, Color.BLACK));
        panelCadastro.add(label("Matr??cula", 70, 70, 100, 20, 16, Color.BLACK));
        panelCadastro.add(fieldMatriculaCadastro = new Field(190, 70, 200, 20));
        panelCadastro.add(label("Senha", 80, 120, 120, 20, 16, Color.BLACK));
        panelCadastro.add(fieldSenhaCadastro = new PasswordField(190, 120, 200, 20));
        panelCadastro.add(label("Confirma????o Senha", 40, 170, 140, 20, 16, Color.BLACK));
        panelCadastro.add(fieldConfirmacaoSenhaCadastro = new PasswordField(190, 170, 200, 20));
        panelCadastro.add(buttonCadastrarse = new Button(110, 215, 120, 30, "Cadastrar-se", Color.DARK_GRAY, Color.WHITE));
        panelCadastro.add(buttonCancelarCadastro = new Button(260, 215, 90, 30, "Cancelar", Color.GRAY, Color.WHITE));
        panelCadastro.add(labelDicaSenha);
        panelCadastro.add(labelErroCadastro);
       
        panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin = painel(500, 0, 500, 650, "");
        panelLogin.setBackground(Color.DARK_GRAY);
        panelLogin.add(label("Login", 210, 200, 100, 45, 35, Color.WHITE));
        panelLogin.add(label("Matr??cula", 125, 280, 100, 20, 16, Color.WHITE));
        panelLogin.add(fieldMatriculaLogin = new Field(210, 280, 160, 20));
        panelLogin.add(label("Senha", 130, 330, 100, 20, 16, Color.WHITE));
        panelLogin.add(fieldSenhaLogin = new PasswordField(210, 330, 160, 20));
        panelLogin.add(buttonEntrar = new Button(160, 380, 80, 30, "Entrar", Color.GRAY, Color.WHITE));
        panelLogin.add(buttonCancelarLogin = new Button(270, 380, 90, 30, "Cancelar", Color.GRAY, Color.WHITE));
        panelLogin.add(labelAlterarSenha);
        panelLogin.add(labelErroLogin);
        
        Usuario usuario = new Usuario();
        
        UsuarioDao uDao = new UsuarioDao();
        
        labelDicaSenha.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                JOptionPane optionPane = new JOptionPane("Senha deve conter no m??nimo:\n\n" + "6 caracteres\n" + "1 Letra mai??scula\n" + "1 Letra min??scula\n" + "1 N??mero\n" + "1 Caractere especial", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
               
                JDialog dialog = new JDialog();
                dialog.setTitle("Requisitos Senha");
                dialog.setModal(true);

                dialog.setContentPane(optionPane);
                dialog.setLocation(570, 330);
                dialog.pack();
                
                Timer timer  = new Timer(5000, new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });
                
                timer.setRepeats(false);
                
                timer.start();
                
                dialog.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                //JOptionPane.showOptionDialog(null, "Senha deve conter no m??nimo:\n\n" + "6 caracteres\n" + "1 Letra mai??scula\n" + "1 Letra min??scula\n" + "1 N??mero\n" + "1 Caractere especial","Requisitos Senha",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, new Object[]{}, null);
                
                labelDicaSenha.setFont(new Font(null,Font.BOLD,25));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                labelDicaSenha.setFont(new Font(null,Font.BOLD,16));
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                labelDicaSenha.setToolTipText("Senha deve conter no m??nimo:\n\n" + "6 caracteres\n" + "1 Letra mai??scula\n" + "1 Letra min??sculas\n" + "1 N??mero\n" + "1 Caractere especial");
            }
        });
        
        buttonCadastrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                    Usuario usuario = new Usuario();
                    UsuarioDao uDao = new UsuarioDao();
                        
                    usuario = uDao.pesquisarPorMatricula(fieldMatriculaCadastro.getText());
                                        
                    if (fieldMatriculaCadastro.getText().equals("") || fieldMatriculaCadastro.getText().equals(null)){
                        System.err.println("ERRO CADASTRO: Campo Matr??cula n??o pode ser vazio");
                        labelErroCadastro.setText("Campo Matr??cula n??o pode ser vazio");
                         
                    }else if (fieldSenhaCadastro.getText().equals("") || fieldSenhaCadastro.getText().equals(null)){
                        System.err.println("ERRO CADASTRO: Campo Senha n??o pode ser vazio");
                        labelErroCadastro.setText("Campo Senha n??o pode ser vazio");
                        
                    }else if (fieldConfirmacaoSenhaCadastro.getText().equals("") || fieldConfirmacaoSenhaCadastro.getText().equals(null)){
                        System.err.println("ERRO CADASTRO: Campo Confirma????o Senha n??o pode ser vazio");
                        labelErroCadastro.setText("Campo Confirma????o Senha n??o pode ser vazio");
                        
                    }else if (!(fieldSenhaCadastro.getText().equals(fieldConfirmacaoSenhaCadastro.getText()))) {
                        System.err.println("ERRO CADASTRO: Confirma????o Senha deve ser igual a Senha");
                        labelErroCadastro.setText("Confirma????o Senha deve ser igual a Senha");
                                         
                    } else {
                        
                        if (usuario == null) {
                            System.err.println("ERRO CADASTRO: Matricula n??o consta no banco de dados\n"+"          Insira uma matricula v??lida!");
                            JOptionPane.showMessageDialog(null, "Matricula n??o consta no banco de dados\n"+"          Insira uma matricula v??lida!","Erro",0);
                        }
                        String validaSenha = usuario.getSenha();
                        
                        
                        if (validaSenha == null||validaSenha.equals("")) {
                            
                            if (!(LoginCadastro.validaCaracteresEspeciais(fieldSenhaCadastro.getText()))) {
                                System.err.println("ERRO CADASTRO: Senha deve conter no m??nimo:\n\n" + "6 caracteres\n" + "1 Letra mai??scula\n" + "1 Letra min??sculas\n" + "1 N??mero\n" + "1 Caractere especial");
                                JOptionPane.showMessageDialog(null, "Senha deve conter no m??nimo:\n\n" + "6 caracteres\n" + "1 Letra mai??scula\n" + "1 Letra min??sculas\n" + "1 N??mero\n" + "1 Caractere especial","Erro",2);
                            
                            }else {
                                // USUARIO ID   
                                Validacao.setValidaID(usuario.getUsuarioID());
                                // USUARIO ONLINE
                                Validacao.setValidaOnline(true);
                                // NOME USUARIO
                                Validacao.setValidaNome(usuario.getNomeUsuario());
                                // MATRICULA
                                Validacao.setValidaMatr(usuario.getMatricula());
                                // PERMISSAO
                                Validacao.setValidaPermissao(false);
                                usuario.setSenha(fieldSenhaCadastro.getText());
                                usuario.setAtivoOnline(true);
                                uDao.alterar(usuario);  
                                
                                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!!!","Cadastro",1);
                                System.out.println("Cadastro realizado com sucesso!!!");
                                
                                if (Inicio.getProfID() <= 0) {

                                    new Inicio();
                                    
                                    //fechar janela
                                    LoginCadastro.this.janela.dispose();
                                    
                                } else {
                                    new PerfilResumo().equals(Inicio.getProfID());
                                    
                                    //fechar janela
                                    LoginCadastro.this.janela.dispose();
                                }
                            } 
                        }else{
                            System.err.println("ERRO CADASTRO: Clicar no bot??o Alterar Senha");
                            JOptionPane.showMessageDialog(null, "Cadastro j?? foi realizado, clique em Alterar Senha caso queira modificar sua senha!","Aten????o",2);
                            
                        }
                    }
                } catch (SQLException w) {
                    System.err.println("Erro botao Cadastrarse: "+w.getMessage());
                }
            }
        });
        
        buttonCancelarCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fieldMatriculaCadastro.setText("");
                    fieldSenhaCadastro.setText("");
                    fieldConfirmacaoSenhaCadastro.setText("");
                    labelErroCadastro.setText("");
                    
                } catch (Exception x) {
                    System.err.println("Erro botao Cancelar Cadastro: "+x.getMessage());
                }
            }
        });
        
        buttonEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                             
                try {
                    Usuario usu = new Usuario();
                    UsuarioDao usuDao = new UsuarioDao();
                        
                    usu = usuDao.pesquisarPorMatricula(fieldMatriculaLogin.getText());
                        
                    if (fieldMatriculaLogin.getText().equals("") || fieldMatriculaLogin.getText().equals(null)) {
                        System.err.println("ERRO LOGIN: Campo Matr??cula n??o pode ser vazio ");
                        labelErroLogin.setText("Campo Matr??cula n??o pode ser vazio");
                        
                    }else if (fieldSenhaLogin.getText().equals("") || fieldSenhaLogin.getText().equals(null)) {
                        System.err.println("ERRO LOGIN: Campo Senha n??o pode ser vazio");
                        labelErroLogin.setText("Campo Senha n??o pode ser vazio");
                        
                    }else{
                        
                        if (usu == null) {
                            System.err.println("ERRO ALTERAR SENHA: Matricula n??o consta no banco de dados\n"+"          Insira uma matricula v??lida!");
                            JOptionPane.showMessageDialog(null, "Matricula n??o consta no banco de dados\n"+"          Insira uma matricula v??lida!","Erro",0);
                        }
                        
                        boolean validaPermissao = usu.getPermissao();
                        String validaSenha = usu.getSenha();
                        
                        
                        if (!(validaSenha == null||validaSenha.equals(""))) {
                        
                        if (validaPermissao == true) {
                        
                            if ( validaSenha.equals(fieldSenhaLogin.getText())) {
                                usu.setAtivoOnline(true);
                                // USUARIO ID   
                                Validacao.setValidaID(usu.getUsuarioID());
                                // USUARIO ONLINE
                                Validacao.setValidaOnline(true);
                                // NOME USUARIO
                                Validacao.setValidaNome(usu.getNomeUsuario());
                                // MATRICULA
                                Validacao.setValidaMatr(usu.getMatricula());                               
                                // VALIDACAO
                                Validacao.setValidaPermissao(true);
                                usuDao.alterar(usu);
                                
                                new Cadastro();
                                LoginCadastro.this.janela.dispose();
                                
                                System.out.println("Permiss??o: " + validaPermissao);
                            } else {
                                System.err.println("ERRO LOGIN: Senha Incorreta");
                                labelErroLogin.setText("                 Senha Incorreta");
                            }
                        
                        }else{
                        
                            if (validaSenha.equals(fieldSenhaLogin.getText())) {
                                usu.setAtivoOnline(true);
                                // USUARIO ID   
                                Validacao.setValidaID(usu.getUsuarioID());
                                // USUARIO ONLINE
                                Validacao.setValidaOnline(true);
                                // NOME USUARIO
                                Validacao.setValidaNome(usu.getNomeUsuario());
                                // MATRICULA
                                Validacao.setValidaMatr(usu.getMatricula());
                                // PERMISSAO
                                Validacao.setValidaPermissao(false);
                                usuDao.alterar(usu);
                                
                                /*caso de certo o encapsulamento do professorID fazer o login direto na tela de avalia????o desse 
                                professor, caso tenha sido clicado no botao avaliar na tela da tayna*/
                                
                                if (Inicio.getProfID() <= 0) {

                                    /*caso de certo o encapsulamento do professorID fazer o login direto na tela de avalia????o desse 
                                professor, caso tenha sido clicado no botao avaliar na tela da tayna*/
                                    new Inicio();
                                    
                                    //fechar janela
                                    LoginCadastro.this.janela.dispose();
                                    
                                } else {
                                    new PerfilResumo().equals(Inicio.getProfID());
                                    
                                    //fechar janela
                                    LoginCadastro.this.janela.dispose();
                                }
                                
                                System.out.println("Permiss??o: " + validaPermissao);
                            } else {
                                System.err.println("ERRO LOGIN: Senha Incorreta");
                                labelErroLogin.setText("                 Senha Incorreta");
                            }
                        }
                        
                        }else{
                            System.err.println("ERRO LOGIN: Matricula existente por??m sem senha\n\nPara poder efetuar o Login o usu??rio deve efetuar seu cadastro antes.");
                            JOptionPane.showMessageDialog(null, "       Para poder efetuar Login voc?? deve realizar seu cadastro antes!\n\n"+"Preencha os dados na parte Primeiro Acesso e clique no bot??o Cadastrar-se!","Aten????o",2);
                            
                        }
                      
                    }
                    
                } catch (SQLException y) {
                    System.err.println("Erro botao Entrar: "+y.getMessage());
                }
            }
        });
        buttonCancelarLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                   fieldMatriculaLogin.setText("");
                   fieldSenhaLogin.setText("");
                   labelErroLogin.setText("");
                   
                } catch (Exception z) {
                    System.err.println("Erro botao Cancelar Login: "+z.getMessage());
                }
            }
        });
        
        labelAlterarSenha.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                try {
                    
                    Usuario usua = new Usuario();
                    UsuarioDao usuaDao = new UsuarioDao();
                    
                    JTextField fieldMatricula = new JTextField();
                    JPasswordField fieldSenhaAnterior = new JPasswordField(); 
                    JPasswordField fieldNovaSenha = new JPasswordField(); 
                    
                    Object[] fields = {
                        "Matricula", fieldMatricula,
                        "Senha Anterior", fieldSenhaAnterior,
                        "Nova Senha", fieldNovaSenha,
                        
                    };
                    
                    Object[] options = { "Ok", "Cancelar" };
                    
                    int n = JOptionPane.showOptionDialog(null, fields, "Altera????o Senha", JOptionPane.OK_CANCEL_OPTION, 1, null, options, options[1]);
                    
                    usua = usuaDao.pesquisarPorMatricula(fieldMatricula.getText());
                    
                    if(n == JOptionPane.CANCEL_OPTION){ // Afirmative
                        //.... 
                    }else if(n == JOptionPane.NO_OPTION){ // negative
                        //....
                    }else if(n == JOptionPane.CLOSED_OPTION){ // closed the dialog
                        //....
                        
                    }else if (fieldMatricula.getText().equals("") || fieldMatricula.getText().equals(null)){
                        System.err.println("ERRO ALTERAR SENHA: Campo Matr??cula n??o pode ser vazio");
                        JOptionPane.showMessageDialog(null, "Campo Matr??cula n??o pode ser vazio","Erro",0);
                         
                    }else if (fieldSenhaAnterior.getText().equals("") || fieldSenhaAnterior.getText().equals(null)){
                        System.err.println("ERRO ALTERAR SENHA: Campo Senha Anterior n??o pode ser vazio");
                        JOptionPane.showMessageDialog(null, "Campo Senha Anterior n??o pode ser vazio","Erro",0);
                        
                    }else if (fieldNovaSenha.getText().equals("") || fieldNovaSenha.getText().equals(null)){
                        System.err.println("ERRO ALTERAR SENHA: Campo Nova Senha n??o pode ser vazio");
                        JOptionPane.showMessageDialog(null, "Campo Nova Senha n??o pode ser vazio","Erro",0);
                        
                    } else {
                        
                        if (usua == null) {
                            System.err.println("ERRO ALTERAR SENHA: Matricula n??o consta no banco de dados\n"+"          Insira uma matricula v??lida!");
                            JOptionPane.showMessageDialog(null, "Matricula n??o consta no banco de dados\n"+"          Insira uma matricula v??lida!","Erro",0);
                        }

                        
                        String validaSenha = usua.getSenha();
                        
                            if (!(validaSenha == null||validaSenha.equals(""))) {
                                
                                if(!(validaSenha.equals(fieldSenhaAnterior.getText()))){    
                                    System.err.println("ERRO ALTERAR SENHA: Senha Anterior incorreta");
                                    JOptionPane.showMessageDialog(null, "Senha Anterior incorreta","Erro",0);
                
                                }else if (fieldNovaSenha.getText().equals(validaSenha)){
                                    System.err.println("ERRO ALTERAR SENHA: Nova senha deve ser diferente da senha anterior");
                                    JOptionPane.showMessageDialog(null, "Nova senha deve ser diferente da senha anterior","Erro",0);
                                    
                                }else if (!(LoginCadastro.validaCaracteresEspeciais(fieldNovaSenha.getText()))) {
                                    System.err.println("ERRO CADASTRO: Senha deve conter no m??nimo:\n\n" + "6 caracteres\n" + "1 Letra mai??scula\n" + " 1 Letra min??scula\n" + "1 N??mero\n" + "1 Caractere especial");
                                    JOptionPane.showMessageDialog(null, "Senha deve conter no m??nimo:\n\n" + "6 caracteres\n" + "1 Letra mai??scula\n" + "1 Letra min??scula\n" + "1 N??mero\n" + "1 Caractere especial","Erro",0);
                                           
                                } else {
                                    usua.setSenha(fieldNovaSenha.getText());
                                    uDao.alterar(usua);  
                                    JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!!!","Altera????o Senha",1);
                                    System.out.println("Senha alterada com sucesso!!!");
                                }
                                
                            }else{
                                System.err.println("ERRO ALTERAR SENHA: Matricula existente por??m sem senha\n\nPara poder alterar a senha o usu??rio de efetuar seu cadastro antes.");
                                JOptionPane.showMessageDialog(null, "       Para poder alterar sua senha voc?? deve efetuar seu cadastro antes!\n\n"+"Preencha os dados na parte Primeiro Acesso e clique no bot??o Cadastrar-se!","Aten????o",2);
                            
                        }
                      
                    }
                    
                } catch (SQLException w) {
                    System.err.println("Erro botao Alterar Senha: "+w.getMessage());
                }
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                labelAlterarSenha.setFont(new Font(null,Font.BOLD,18));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                labelAlterarSenha.setFont(new Font(null,Font.BOLD,16));
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        janela.getContentPane().add(panelCadastro);
        janela.getContentPane().add(panelLogin);
        
    }
    
    public JPanel painel(int x, int y, int l, int a, String tabela){
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(x,y,l,a);
        painel.setVisible(true);
        painel.add(label(tabela, 20, 5, 100, 20, 18, Color.BLACK));
        

        //painel.setBackground(Color.orange);
        return painel;
    }
    
    public JLabel label(String nome, int x, int y, int l, int a, int f, Color fontColor){
        JLabel label = new JLabel(nome);
        label.setBounds(x, y, l, a);
        label.setFont(new Font("null", Font.PLAIN, f));
        label.setForeground(fontColor);
        
        
        return label;
    }
    
    public static boolean validaCaracteresEspeciais (String validaCaracteresEspeciais){
        boolean result = false;
        if (validaCaracteresEspeciais.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")) {
            result = true;
        }
        return result;
    } 

}
