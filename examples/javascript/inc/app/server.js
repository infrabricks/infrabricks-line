var express = require('express'),
    http = require('http'),
    redis = require('redis'),
    morgan  = require('morgan'),
    os = require("os");

var app = express();
app.use(morgan('combined'))

console.log(process.env.REDIS_PORT_6379_TCP_ADDR + ':' + process.env.REDIS_PORT_6379_TCP_PORT);

var client = redis.createClient(
	process.env.REDIS_PORT_6379_TCP_PORT,
  	process.env.REDIS_PORT_6379_TCP_ADDR
);

app.get('/', function(req, res, next) {
  client.incr('counter', function(err, counter) {
    if(err) return next(err);
    res.send('This page has been viewed ' + counter + ' times, at host ' + os.hostname() + ' !\n');
  });
});

http.createServer(app).listen(process.env.PORT || 8080, function() {
  console.log('Listening on port ' + (process.env.PORT || 8080));
});
