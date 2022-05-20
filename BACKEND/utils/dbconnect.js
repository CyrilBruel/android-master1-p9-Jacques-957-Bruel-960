// const { MongoClient } = require('mongodb');
const mysql  = require('mysql');

//const connectionString = "mongodb://localhost:27017";
// const connectionString = "mongodb+srv://crud_tuto:crud_tuto@cluster0.6nvil.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
// const url= "mongodb://localhost:27017/ekaly"
// async function getDb(){
//     return MongoClient.connect(connectionString, { useUnifiedTopology: true })
//     .then((client) => {
//         const db = client.db('ekaly')
//         return db;
//     })
// }

function getDb(){
    return mysql.createConnection({
        host: "81.19.215.20",
        user: "tsangana_webcup2022",
        password: "p9O8i7#*!",
        database: "tsangana_webcup2022"
      });
}

module.exports = {getDb}