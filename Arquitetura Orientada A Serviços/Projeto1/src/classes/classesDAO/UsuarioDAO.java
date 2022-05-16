package classes.classesDAO;

import classes.bd.ConexaoBD;
import classes.classesDBO.UsuarioDBO;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // C create - ok
    // R read - ok
    // U update - ok
    // D delete - ok

    //metodo create
    public void save(UsuarioDBO usuario) {

        String sql = "INSERT INTO usuarios(nome, idade, cep, numerocasa, complemento) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar uma conexão com o banco de dados
            conn = ConexaoBD.createConnecticonToMySQL();

            //criamos uma PreparedStatement para executar uma QUERY
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //adicionando os valores que sao esperados pela query

            pstm.setString(1, usuario.getNome());
            pstm.setInt(2, usuario.getIdade());
            pstm.setString(3, usuario.getCep());
            pstm.setInt(4, usuario.getNumeroCasa());
            pstm.setString(5, usuario.getComplemento());

            //Executar a query

            pstm.execute();
            System.out.println("DADOS SALVOS COM SUCESSO");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            //fechar as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //metodo read
    public List<UsuarioDBO> getCliente() {

        String sql = "SELECT * FROM cliente";

        List<UsuarioDBO> usuarios = new ArrayList<UsuarioDBO>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConexaoBD.createConnecticonToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                UsuarioDBO usuario = new UsuarioDBO();

                //Recuperar o id
                usuario.setId(rset.getInt("id"));

                //Recuperar o nome
                usuario.setNome(rset.getString("nome"));

                //Recuperar a idade
                usuario.setIdade(rset.getInt("idade"));

                //Recuperar o cep
                usuario.setCep(rset.getString("cep"));

                //recuperar numeroCasa
                usuario.setNumeroCasa(rset.getInt("numeroCasa"));

                //recuperar complemento
                usuario.setComplemento(rset.getString("complemento"));

                usuarios.add(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    //metodo update
    public void update(UsuarioDBO usuario) {

        String sql = "UPDATE usuarios SET nome = ?, idade = ?, cep = ?, numerocasa = ?, complemento = ? " +
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar conexão com o banco
            conn = ConexaoBD.createConnecticonToMySQL();

            //Criar classe para executar a query

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar os valores para atualizar

            pstm.setString(1, usuario.getNome());
            pstm.setInt(2, usuario.getIdade());
            pstm.setString(3, usuario.getCep());
            pstm.setInt(4, usuario.getNumeroCasa());
            pstm.setString(5, usuario.getComplemento());

            //Qual o ID do registro que deseja atualizar?
            pstm.setInt(6, usuario.getId());


            //executar a query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //metodo delete
    public void deleteByID(int id) {

        String sql = "DELETE FROM usuarios WHERE id = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.createConnecticonToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

