var gulp = require('gulp');
// 处理css中浏览器兼容的前缀  
var autoprefixer = require('gulp-autoprefixer');
// css的层级压缩合并
var cssnano = require('gulp-cssnano'); 
// sass
var sass = require('gulp-sass'); 
//var jshint = require('gulp-jshint'); //js检查 ==> npm install --save-dev jshint gulp-jshint（.jshintrc：https://my.oschina.net/wjj328938669/blog/637433?p=1） 
// js压缩 
var uglify = require('gulp-uglify');
// 图片压缩 
var imagemin = require('gulp-imagemin'); 
// 替换文件中的链接的工具,一般与gulp-rev共同使用
var useref = require('gulp-useref'); 
// 目录清理
var clean = require('gulp-clean');
var del = require('del');
var runSequence = require('gulp-run-sequence'); 
var browserSync = require('browser-sync').create();
var reload = browserSync.reload;
var Config = require('./gulpfile.config.js');
//======= gulp dev 开发环境下 ===============
function dev() {
    /**
    * 目标目录清理
    */
    gulp.task('clean:dev', function(cb) { 
        return del(['src/main/resources/static/**/*','src/main/resources/templates/**/*'], cb);
    });
    /** 
     * HTML处理 
     */
    gulp.task('html:dev', function () {
        return gulp.src(Config.html.src)
        .pipe(gulp.dest(Config.html.dist))
        .pipe(reload({
            stream: true
        }));
    });
    /** 
     * assets文件夹下的所有文件处理 
     */
    gulp.task('plus:dev', function () {
        return gulp.src(Config.plus.src).pipe(gulp.dest(Config.plus.dist)).pipe(reload({
            stream: true
        }));
    });
    /** 
     * CSS样式处理 
     */
    gulp.task('css:dev', function () {
        return gulp.src(Config.css.src)
        .pipe(gulp.dest(Config.css.dist))
        .pipe(reload({
            stream: true
        }));
    });
    /** 
    * jslibs处理 
    */
    gulp.task('libs:dev', function () {
        return gulp.src(Config.libs.src).pipe(gulp.dest(Config.libs.dist)).pipe(reload({
            stream: true
        }));
    });
    /** 
     * js处理 
     */
    gulp.task('js:dev', function () {
        return gulp.src(Config.js.src)
		//.pipe(jshint('.jshintrc'))
		//.pipe(jshint.reporter('default'))
        .pipe(gulp.dest(Config.js.dist))
        .pipe(reload({
            stream: true
        }));
    });
    /** 
     * 图片处理 
     */
    gulp.task('images:dev', function () {
        return gulp.src(Config.img.src).pipe(imagemin({
            optimizationLevel: 3
            , progressive: true
            , interlaced: true
        })).pipe(gulp.dest(Config.img.dist)).pipe(reload({
            stream: true
        }));
    });
    //
    gulp.task('dev', ['clean:dev'], function (cb) {
        browserSync.init({
            server: {
                baseDir: Config.dist
            }, 
            notify: false
        });
        //
        runSequence(['html:dev', 'css:dev', 'libs:dev', 'js:dev', 'plus:dev', 'images:dev'], cb);
        // Watch .html files  
        gulp.watch(Config.html.src, ['html:dev']);
        // Watch .css files  
        gulp.watch(Config.css.src, ['css:dev']);
        // Watch assets files  
        gulp.watch(Config.assets.src, ['plus:dev']);
        // Watch libs files  
        gulp.watch(Config.libs.src, ['libs:dev']);
        // Watch .js files  
        gulp.watch(Config.js.src, ['js:dev']);
        // Watch image files  
        gulp.watch(Config.img.src, ['images:dev']);
    });
}
//======= gulp dev 开发环境下 ===============
module.exports = dev;