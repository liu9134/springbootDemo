var gulp = require('gulp');
var mkdirp = require('mkdirp');
var Config = require('./gulpfile.config.js');
//======= gulp init 初始化项目结构 ===============
function init() {
    /** 
     * 初始化项目结构
     */
    gulp.task('init', function () {
        var dirs = [Config.html.dist, Config.plus.dist, Config.css.dist, Config.libs.dist, Config.js.dist, Config.img.dist];
        dirs.forEach(function dir(){
            mkdirp.sync(dir);
        });
    });
}
module.exports = init;