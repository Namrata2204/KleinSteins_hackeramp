var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var hbs = require('hbs');
var session = require('express-session');
var http = require('http');
var ejs= require('ejs');
var router = express.Router();

var index = require('./routes/index')

var app = express();

app.set('views', path.join(__dirname, 'views'));
hbs.registerPartials(__dirname + '/views/partials');
app.set('view engine', 'hbs');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(session({
  secret: 'secret',
  resave: false,
  saveUninitialized: true
}))
app.use(express.static(path.join(__dirname, 'public')));

app.use(function(req, res, next) {
    res.locals.session = req.session;
    next();
});

app.use('/', index);



app.listen(3000, function(req,res)
{
  console.log("Server Listening on port 3000");
})
