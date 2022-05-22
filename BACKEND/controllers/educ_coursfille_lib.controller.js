const Educ_coursfille_lib = require("../models/educ_coursfille_lib.model");
const Educ_etatcours_user = require("../models/educ_etatcours_user.model");

exports.findDetailsCoursByIdCours = (req, res) => {
    Educ_coursfille_lib.findDetailsCoursByIdCours(req.params.idcours, (err, data1) => {
      if (err) {
        if (err.kind === "not_found") {
          res.status(404).send({
            message: `Not found User with id ${req.params.id}.`
          });
        } else {
          res.status(500).send({
            message: "Error retrieving User with id " + req.params.id
          });
        }
      } else{
        Educ_etatcours_user.insertEtatCoursUser(req.params.iduser, req.params.idcours, (err, data2) => {
            if(err){
                console.log(err);
            } else {
                console.log(data2);
            }
        });
        res.send(data1);
      } 
    });
};
  
