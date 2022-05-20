const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const moment = require('moment');
const routes = require('./routes');

const app = express();
global.__basedir = __dirname;
app.use(cors());
app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())
app.use(express.static('public'))

app.set('json replacer', function (key, value) {
    if (this[key] instanceof Date) {
      value = moment(this[key]).format("YYYY-MM-DD HH:mm:ss");
    }
    return value;
});
app.use(cors({
    origin: '*'
}));

function use_routes(routes){
    Object.keys(routes)
    .forEach((key) => {
        app.use(`/${key}`, routes[key]);
    });
}
  
use_routes(routes);
app.get('/', function (req, res){
    res.json({message: 'Welcome to edukids'});
});
require("./routes/user.routes")(app);
const port = process.env.PORT || 3000;
app.listen(port, function (){
    console.log(`Listening on port ${port}`);
});