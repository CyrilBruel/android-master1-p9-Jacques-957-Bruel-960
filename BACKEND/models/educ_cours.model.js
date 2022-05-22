const sql = require("./db.js");

// constructor
const Educ_cours = function(educ_cours) {
    this.id = educ_cours.id;
    this.desce = educ_cours.desce;
    this.datepublication = educ_cours.datepublication;
    this.agemin = educ_cours.agemin;
    this.agemax = educ_cours.agemax;
    this.idcategorie = educ_cours.idcategorie;
};


Educ_cours.getCours = (iduser, age, search, idcategorie, etat, result) => {

    let query = "select * from (select ec.*, 0 as etatcoursuser from("+
        " select ec.* from educ_cours ec where ec.agemin < '"+age+"' and ec.agemax > '"+age+"'"+
    " ) ec where ec.id not in ("+
        " select ec.id from educ_etatcours_user eeu"+
        " JOIN educ_cours ec on ec.id = eeu.idcours where eeu.iduser like '"+iduser+"'"+
    " )"+
    " UNION ALL"+
    " select ec.*, 1 from educ_etatcours_user eeu"+
        " JOIN educ_cours ec on ec.id = eeu.idcours where eeu.iduser like '"+iduser+"') info_cours ";
    if (search) {
        query += ` where desce LIKE '%${search}%' `;
    }
    if (idcategorie) {
        query += ` and idcategorie LIKE '${idcategorie}'`;
    }
    if (etat) {
        query += ` and etatcoursuser LIKE '${etat}'`;
    }
    sql.query(query, (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }
  
      console.log("cours: ", res);
      result(null, res);
    });
  };

module.exports = Educ_cours;
