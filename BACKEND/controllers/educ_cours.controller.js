const Educ_cours = require("../models/educ_cours.model");

exports.getCours = (req, res) => {
    const search = req.body.search;
    const iduser = req.body.iduser;
    const age = req.body.age;
    Educ_cours.getCours(iduser, age, search, (err, data) => {
      if (err)
        res.status(500).send({
          message:
            err.message || "Some error occurred while retrieving Cours ."
        });
      else res.send(data);
    });
};