package classes.classesDAO;

import classes.bd.ConexaoBD;
import classes.classesDBO.UsuarioDBO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    //Método para inserir usuario
    static public void insertUser(UsuarioDBO usuario) {

        String sql = "INSERT INTO usuarios(nome, cep, numcasa, complemento) VALUES (?, ?, ?, ?)";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            //Cria a conexão com o bd
            conexao = ConexaoBD.createConnecticonToMySQL();

            //Cria o PreparedStatement de acordo com a consulta SQL para executar a query
            preparedStatement = conexao.prepareStatement(sql);

            //Adiciona os valores pedidos pela consulta no preparedStatement
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getCep());
            preparedStatement.setInt(3, usuario.getNumCasa());
            preparedStatement.setString(4, usuario.getComplemento());

            //Executa uma query
            preparedStatement.execute();
            System.out.println("Usuario cadastrado!");
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            //Fechando as conexoes
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Método para consultar todos os usuarios cadastrados
    public List<UsuarioDBO> getUser() {

        String sql = "SELECT * FROM usuarios";

        List<UsuarioDBO> usuarios = new ArrayList<UsuarioDBO>();

        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;

        try {
            conexao = ConexaoBD.createConnecticonToMySQL();

            preparedStatement = conexao.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UsuarioDBO usuario = new UsuarioDBO();

                //Recuperar o id
                usuario.setId(resultSet.getInt("id"));

                //Recuperar o nome
                usuario.setNome(resultSet.getString("nome"));

                //Recuperar o cep
                usuario.setCep(resultSet.getString("cep"));

                //recuperar numeroCasa
                usuario.setNumCasa(resultSet.getInt("numCasa"));

                //recuperar complemento
                usuario.setComplemento(resultSet.getString("complemento"));

                usuarios.add(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    //Método para  atualizar dados de um usuario
    public void updateÜser(UsuarioDBO usuario) {

        String sql = "UPDATE usuarios SET nome = ?, cep = ?, numCasa = ?, complemento = ? " +
                "WHERE id = ?";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            //Criar conexão com o banco
            conexao = ConexaoBD.createConnecticonToMySQL();

            //Criar classe para executar a query

            preparedStatement = conexao.prepareStatement(sql);

            //Adicionar os valores para atualizar

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getCep());
            preparedStatement.setInt(3, usuario.getNumCasa());
            preparedStatement.setString(4, usuario.getComplemento());

            //Qual o ID do registro que deseja atualizar?
            preparedStatement.setInt(5, usuario.getId());


            //executar a query
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Método para deletar usuarios
    public void deleteUserByID(int id) {

        String sql = "DELETE FROM usuarios WHERE id = ?";

        Connection conexao = null;

        PreparedStatement preparedStatement = null;

        try {
            conexao = ConexaoBD.createConnecticonToMySQL();

            preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Retorna o primeiro registro da tabela onde o nome seja igual ao nome passado como parâmetro
    static public UsuarioDBO getUser(String nome) {

        String sql = "SELECT * FROM usuarios WHERE nome = ? ORDER BY id ASC LIMIT 1;";

        UsuarioDBO usuario = new UsuarioDBO();

        Connection conexao = null;

        PreparedStatement preparedStatement = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;

        try {
            conexao = ConexaoBD.createConnecticonToMySQL();

            preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, nome);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //Recuperar o id
                usuario.setId(resultSet.getInt("id"));

                //Recuperar o nome
                usuario.setNome(resultSet.getString("nome"));

                //Recuperar o cep
                usuario.setCep(resultSet.getString("cep"));

                //recuperar numeroCasa
                usuario.setNumCasa(resultSet.getInt("numCasa"));

                //recuperar complemento
                usuario.setComplemento(resultSet.getString("complemento"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
}

