/**** CRIANDO CONEXAO COM O BD UTILIZANDO CALLBACK FUNCTIONS ****/

/*let mysql = require('mysql2/promise'); //pegando a pasta do banco msql
let bdConfig = require('./bdconfig.js');


let conexao = mysql.createConnection(bdConfig);
conexao.connect();

conexao.query('select * from usuarios', function(error, results, fields){
        if(!error){
            for(let i = 0; i < results.length; i++){
                console.log(results[i].id, results[i].nome);
            };
        }
});

conexao.end();*/

/**** CRIANDO CONEXAO COM O BD UTILIZANDO PROMISES ****/

async function getConexao(){
    if(global.conexao && global.conexao.state !== 'disconnected')
        return global.conexao;
    
    const mysql = require("mysql2/promise");
    const bdConfig = require('./bdconfig.js');

    const conexao = await mysql.createConnection(bdConfig);
    global.conexao = conexao;
    return conexao;
}