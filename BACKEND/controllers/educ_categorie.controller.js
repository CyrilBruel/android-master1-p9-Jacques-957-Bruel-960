const Educ_categorie = require("../models/educ_categorie.model");

exports.findAll = (req, res) => {
    const title = req.query.title;
  
    Educ_categorie.getAll(title, (err, data) => {
      if (err)
        res.status(500).send({
          message:
            err.message || "Some error occurred while retrieving categories."
        });
      else 
        res.status(200).send({
            message: 'Succès',
            status:200,
            data:data
        });
    });
};