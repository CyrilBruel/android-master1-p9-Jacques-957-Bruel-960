const sql = require("./db.js");
// constructor
const Educ_coursfille_lib = function(educ_coursfille_lib) {
    this.id = educ_coursfille_lib.id;
    this.desce = educ_coursfille_lib.desce;
    this.content = educ_coursfille_lib.content;
    this.idcours = educ_coursfille_lib.idcours;
    this.coursdescription = educ_coursfille_lib.coursdescription;
    this.datepublication = educ_coursfille_lib.datepublication;
    this.agemin = educ_coursfille_lib.agemin;
    this.agemax = educ_coursfille_lib.agemax;
    this.idcategorie = educ_coursfille_lib.idcategorie;
    this.categoriedescription = educ_coursfille_lib.categoriedescription;

};

Educ_coursfille_lib.findDetailsCoursByIdCours = (idcours, result) => {
    sql.query(`SELECT * FROM educ_coursfille_lib WHERE idcours = ${idcours}`, (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(err, null);
        return;
      }
  
      if (res.length) {
        console.log("found user: ", res);
        result(null, res);
        return;
      }
  
      // not found User with the id
      result({ kind: "not_found" }, null);
    });
  };

module.exports = Educ_coursfille_lib;