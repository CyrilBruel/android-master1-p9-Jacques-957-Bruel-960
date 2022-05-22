const sql = require("./db.js");


const Educ_etatcours_user = function(educ_etatcours_user) {
    this.id = educ_etatcours_user.id;
    this.iduser = educ_etatcours_user.iduser;
    this.idcours = educ_etatcours_user.idcours;
};

Educ_etatcours_user.insertEtatCoursUser = (iduser, idcours, result) => {
    var requete = "INSERT INTO educ_etatcours_user (iduser, idcours) values ('"+iduser+"', '"+idcours+"')"
    sql.query(requete, (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(err, null);
        return;
      }
      result(null, { id: res.insertId,
        iduser: iduser,
        idcours: idcours,
      });
    });
};

module.exports = Educ_etatcours_user;