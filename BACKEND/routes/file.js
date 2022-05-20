
module.exports = app => {
    const controller = require("../controllers/file.controller");
  
    var router = require("express").Router();
  
    // Create a new Tutorial
    //router.post("/upload", controller.upload);
router.get("/", controller.getListFiles);
//router.get("/:name", controller.download);
  
    app.use('/api/files', router);
};


  