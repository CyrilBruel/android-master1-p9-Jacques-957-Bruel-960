const sql = require("./db.js");

const Cours = function(cours){
    this.id = cours.id;
    this.val = cours.val;
    this.desce = cours.desce;
    this.datepublication = cours.datepublication;
    this.agemin = cours.agemin;
    this.agemax = cours.agemax;
    this.idcategorie = cours.idcategorie;
}

Cours.create = (newCours, result) => {
    sql.query("INSERT INTO educ_cours SET ?", newCours, (err, res) => {
        if (err) {
          console.log("error: ", err);
          result(err, null);
          return;
        }
    
        console.log("created cours: ", { id: res.insertId, ...newCours });
        result(null, { id: res.insertId, ...newCours });
    });
}

User.findById = (id, result) => {
    sql.query(`SELECT * FROM cours WHERE id = ${id}`, (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(err, null);
        return;
      }
  
      if (res.length) {
        console.log("found cours: ", res[0]);
        result(null, res[0]);
        return;
      }
  
      // not found User with the id
      result({ kind: "not_found" }, null);
    });
  };
  
User.getAll = (title, result) => {
    let query = "SELECT * FROM cours";
  
    if (title) {
      query += ` WHERE val LIKE '%${title}%' OR desce LIKE '%${title}%' `;
    }
  
    sql.query(query, (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }
  
      console.log("users: ", res);
      result(null, res);
    });
};

module.exports = Cours;