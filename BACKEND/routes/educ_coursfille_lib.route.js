module.exports = app => {
    const educ_coursfille_lib = require("../controllers/educ_coursfille_lib.controller");
  
    var router = require("express").Router();
  
    // Create a new Tutorial
    // router.post("/", educ_coursfille_lib.inscription);
  
    // // Retrieve all user
    // router.get("/", educ_coursfille_lib.findAll);
  
    // Retrieve all published user
    //router.get("/published", user.getAllActive);
  
    // Retrieve a single Tutorial with id
    router.get("/:iduser/:idcours", educ_coursfille_lib.findDetailsCoursByIdCours);
  
    // // Retrieve a single Tutorial with id
    // router.post("/login", educ_coursfille_lib.login);
  
    // // Update a Tutorial with id
    // router.put("/:id", educ_coursfille_lib.update);
  
    // // Delete a Tutorial with id
    // router.delete("/:id", educ_coursfille_lib.delete);
  
    // // Delete all user
    // router.delete("/", educ_coursfille_lib.deleteAll);
  
    app.use('/api/detailscours', router);
  };
  