const Educ_cours = require("../models/educ_cours.model");

exports.getCours = (req, res) => {
    const search = req.body.search;
    const iduser = req.body.iduser;
    const age = req.body.age;
    const idcategorie = req.body.idcategorie;
    const etat = req.body.etat;
    Educ_cours.getCours(iduser, age, search, idcategorie, etat, (err, data) => {
      if (err)
        res.status(500).send({
          message:
            err.message || "Some error occurred while retrieving Cours ."
        });
      else 
        res.status(200).send({
            message: 'Succès',
            status:200,
            data:data
        });
    });
};