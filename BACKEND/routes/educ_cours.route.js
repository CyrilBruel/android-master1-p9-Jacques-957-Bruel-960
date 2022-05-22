module.exports = app => {
    const educ_cours = require("../controllers/educ_cours.controller");
  
    var router = require("express").Router();
  
    // // Create a new Tutorial
    // router.post("/", user.inscription);
  
    // Retrieve all cours
    router.post("/", educ_cours.getCours);
  
    // Retrieve all published user
    //router.get("/published", user.getAllActive);
  
    // // Retrieve a single Tutorial with id
    // router.get("/:id", user.findOne);
  
    // // Retrieve a single Tutorial with id
    // router.post("/login", user.login);
  
    // // Update a Tutorial with id
    // router.put("/:id", user.update);
  
    // // Delete a Tutorial with id
    // router.delete("/:id", user.delete);
  
    // // Delete all user
    // router.delete("/", user.deleteAll);
  
    app.use('/api/cours', router);
};
  