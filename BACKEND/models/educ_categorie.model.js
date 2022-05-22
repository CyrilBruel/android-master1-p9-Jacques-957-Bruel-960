const sql = require("./db.js");

// constructor
const Educ_categorie = function(educ_categorie) {
    this.id = educ_categorie.id;
    this.desce = educ_categorie.desce;
    this.icone = educ_categorie.icone;
};


Educ_categorie.getAll = (title, result) => {
    let query = "SELECT * FROM educ_categorie";
  
    if (title) {
      query += ` WHERE title LIKE '%${title}%'`;
    }
  
    sql.query(query, (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }
  
      console.log("categories: ", res);
      result(null, res);
    });
  };

module.exports = Educ_categorie;
