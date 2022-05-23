const User = require("../models/user.model.js");

const crypto = require('crypto')



// Create and Save a new User
exports.inscription = (req, res) => {
  console.log(req.body);
  // 
  const str = JSON.stringify(req.body.mot_de_passe); 
  const hash = crypto.createHash('sha1').update(str).digest('hex')
  console.log("hash === ", hash)
  // 
  // Validate request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  // Create a User
  const user = new User({
    nom: req.body.nom,
    prenom: req.body.prenom,
    age: req.body.age,
    sexe: req.body.sexe,
    username: req.body.username,
    mot_de_passe: hash,
    profil: req.body.profil
  });

  // Save user in the database
  // 

  // 
  User.create(user, (err, data) => {
    if (err)
      res.status(200).send({
        status:500,
        message:
          err.message || "Quelques erreurs renvontrées pendant la creation de l'utilisateur."
      });
    else{
      res.status(200).send({'data':data,status:200});
    }
  });
};

// Retrieve all Users from the database (with condition).
exports.findAll = (req, res) => {
  const title = req.query.title;

  User.getAll(title, (err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while retrieving users."
      });
    else res.send(data);
  });
};

// Find a single User by Id
exports.findOne = (req, res) => {
  User.findById(req.params.id, (err, data) => {
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
    } else res.send(data);
  });
};

exports.login = (req, res) => {
  var username = req.body.username;

  const str = req.body.mot_de_passe
  const hash = crypto.createHash('sha1').update(str).digest('hex')

  var mot_de_passe = hash;

  console.log("USERNAME =====", username);
  console.log("PASSWORD =====", mot_de_passe);

  User.findByLoginPassword(username, mot_de_passe, (err, data) => {
    if (err) {
       
        res.status(200).send({
          status:500,
          message: `Mot de passe incorrecte`
        });
      
    }else{
      res.status(200).send({
        message: 'Succès',
        status:200,
        data:data
      });
    } 
  });
};

// find all active User
/*exports.getAllActive = (req, res) => {
  User.getAllActive((err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while retrieving users."
      });
    else res.send(data);
  });
};
*/

// Update a User identified by the id in the request
exports.update = (req, res) => {
  // Validate Request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  console.log(req.body);

  const str = JSON.stringify(req.body.mot_de_passe); 
  const hash = crypto.createHash('sha1').update(str).digest('hex')
  var user = new User(req.body);
  user.mot_de_passe = hash;

  User.updateById(req.params.id, user, (err, data) => {
      if (err) {
        if (err.kind === "not_found") {
          res.status(404).send({
            message: `Not found User with id ${req.params.id}.`
          });
        } else {
          res.status(500).send({
            message: "Error updating User with id " + req.params.id
          });
        }
      } else res.send(data);
    }
  );
};

// Delete a User with the specified id in the request
exports.delete = (req, res) => {
  User.remove(req.params.id, (err, data) => {
    if (err) {
      if (err.kind === "not_found") {
        res.status(404).send({
          message: `Not found User with id ${req.params.id}.`
        });
      } else {
        res.status(500).send({
          message: "Could not delete User with id " + req.params.id
        });
      }
    } else res.send({ message: `User was deleted successfully!` });
  });
};

// Delete all users from the database.
exports.deleteAll = (req, res) => {
  User.removeAll((err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while removing all users."
      });
    else res.send({ message: `All Users were deleted successfully!` });
  });
};
