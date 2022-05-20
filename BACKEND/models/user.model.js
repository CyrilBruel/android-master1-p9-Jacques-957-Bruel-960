const sql = require("./db.js");

// constructor
const User = function(user) {
    this.id = user.id;
    this.nom  = user.nom;
    this.prenom = user.prenom;
    this.age = user.age;
    this.sexe = user.sexe;
    this.username = user.username;
    this.mot_de_passe = user.mot_de_passe;
    this.profil = user.profil;
};

User.create = (newUser, result) => {
  var requete = "INSERT INTO educ_user (nom, prenom, age, sexe, username, mot_de_passe, profil) values ('"+newUser.nom+"', '"+newUser.prenom+"', '"+newUser.age+"', '"+newUser.sexe+"', '"+newUser.username+"', '"+newUser.mot_de_passe+"', '"+newUser.profil+"')"
  sql.query(requete, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }
    // console.log("response =======", res)
    // console.log("created user: ", { id: res.insertId, ...newUser });
    // result(null, { id: res.insertId, ...newUser });

    result(null, { id: res.insertId,
      nom  : newUser.nom,
      prenom : newUser.prenom,
      age : newUser.age,
      sexe : newUser.sexe,
      username : newUser.username,
      mot_de_passe : newUser.mot_de_passe,
      profil : newUser.profil
    });
  });
};

User.findById = (id, result) => {
  sql.query(`SELECT * FROM user WHERE id = ${id}`, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    if (res.length) {
      console.log("found user: ", res[0]);
      result(null, res[0]);
      return;
    }

    // not found User with the id
    result({ kind: "not_found" }, null);
  });
};

User.getAll = (title, result) => {
  let query = "SELECT * FROM user";

  if (title) {
    query += ` WHERE title LIKE '%${title}%'`;
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

/*
User.getAllActive = result => {
  sql.query("SELECT * FROM user WHERE etat=true", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }
    console.log("users: ", res);
    result(null, res);
  });
};
*/

User.updateById = (id, user, result) => {
  sql.query(
    "UPDATE user SET username = ?, password = ? WHERE id = ?",
    [ user.username, user.password, id],
    (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }

      if (res.affectedRows == 0) {
        // not found User with the id
        result({ kind: "not_found" }, null);
        return;
      }

      console.log("updated user: ", { id: id, ...user });
      result(null, { id: id, ...user });
    }
  );
};

User.remove = (id, result) => {
  sql.query("DELETE FROM user WHERE id = ?", id, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    if (res.affectedRows == 0) {
      // not found User with the id
      result({ kind: "not_found" }, null);
      return;
    }

    console.log("deleted user with id: ", id);
    result(null, res);
  });
};

User.removeAll = result => {
  sql.query("DELETE FROM user", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log(`deleted ${res.affectedRows} users`);
    result(null, res);
  });
};

// User.inscription = (newUser, result) => {
//   sql.query("INSERT INTO user SET ?", newUser, (err, res) => {
//     if (err) {
//       console.log("error: ", err);
//       result(err, null);
//       return;
//     }

//     console.log("created user: ", { id: res.insertId, ...newUser });
    
//     //result(null, { id: res.insertId, ...newUser });
//     return this.login(newUser.username, newUser.password, result);
//   });
// };

// User.saveToken = (user, result) => {
//   var token = sha1(
//     user.id +
//     user.password +
//     moment().format("YYYY-MM-DD HH:mm:ss.SSS")
//   );

//   var requete = "INSERT INTO TOKEN (id_user, token, expiration) VALUES ('"+user.id+"', '"+token+"', '"+moment().add(1, "h").format("YYYY-MM-DD HH:mm:ss.SSS")+"') ";
//   sql.query(requete, (err, res) => {
//     if (err) {
//       console.log("error: ", err);
//       result(err, null);
//       return;
//     }
//     result(null, token);
//   });
// };

User.findByLoginPassword = (username, mot_de_passe, result) => {
  sql.query(`SELECT * FROM user WHERE username = '${username}' and mot_de_passe = '${mot_de_passe}'`, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    if (res.length) {
      console.log("found user: ", res[0]);
      result(null, res[0]);
      return;
    }

    // not found User with the id
    result({ kind: "not_found" }, null);
  });
};



// User.logout = result => {

// };

module.exports = User;
