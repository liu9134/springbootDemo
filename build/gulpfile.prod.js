var gulp = require('gulp');
// 处理css中浏览器兼容的前缀  
var autoprefixer = require('gulp-autoprefixer'); 
// 重命名  
var rename = require('gulp-rename'); 
// css的层级压缩合并
var cssnano = require('gulp-cssnano'); 
// sass
var sass = require('gulp-sass'); 
//var jshint = require('gulp-jshint'); //js检查 ==> npm install --save-dev jshint gulp-jshint（.jshintrc：https://my.oschina.net/wjj328938669/blog/637433?p=1） 
// js压缩  
var uglify = require('gulp-uglify'); 
// 合并文件 
var concat = require('gulp-concat'); 
// 图片压缩
var imagemin = require('gulp-imagemin'); 
// 加md5后缀的工具
var rev = require('gulp-rev'); 
// 与rev共同使用  
var revCollector = require('gulp-rev-collector'); 
// 目录清理
var clean = require('gulp-clean'); 
var del = require('del');
//
var runSequence = require('gulp-run-sequence'); 
var Config = require('./gulpfile.config.js');
//======= gulp build 打包资源 ===============
function prod() {
    /**
    * 目标目录清理
    */
    gulp.task('clean', function(cb) { 
        return del(['src/main/resources/static/**/*','src/main/resources/templates/**/*'], cb);
    });
    /** 
     * HTML处理 
     */
    gulp.task('html', function () {
        return gulp.src(Config.html.src).pipe(gulp.dest(Config.html.dist));
    });
    /** 
     * assets文件夹下的所有文件处理 
     */
    gulp.task('plus', function () {
        return gulp.src(Config.plus.src).pipe(gulp.dest(Config.plus.dist));
    });
    /** 
     * CSS样式处理 
     */
    gulp.task('css', function () {
        return gulp.src(Config.css.src)
        .pipe(autoprefixer('last 2 version'))
        .pipe(cssnano()) //执行压缩
        .pipe(rev())
        .pipe(gulp.dest(Config.css.dist))
        .pipe(rev.manifest())
        .pipe(gulp.dest('rev/css'));
    });
    /**
    * jslibs处理
    */
    gulp.task('libs', function () {
        return gulp.src(Config.libs.src).pipe(gulp.dest(Config.libs.dist));
    });
    /**
     * js处理
     */
    gulp.task('js', function () {
        return gulp.src(Config.js.src)
        //.pipe(jshint('.jshintrc'))
        //.pipe(jshint.reporter('default'))
        .pipe(uglify())
        .pipe(rev())
        .pipe(gulp.dest(Config.js.dist))
        .pipe(rev.manifest())
        .pipe(gulp.dest('rev/js'));
    });
    /** 
     * 合并所有js文件并做压缩处理 
     */
    gulp.task('js-concat', function () {
        return gulp.src(Config.js.src)
        //.pipe(jshint('.jshintrc'))
        //.pipe(jshint.reporter('default'))
        .pipe(concat(Config.js.build_name))
        .pipe(gulp.dest(Config.js.dist))
        .pipe(rename({
            suffix: '.min'
        }))
        .pipe(uglify())
        .pipe(gulp.dest(Config.js.dist));
    });
    /** 
     * 图片处理 
     */
    gulp.task('images', function () {
        return gulp.src(Config.img.src).pipe(imagemin({
            optimizationLevel: 3
            , progressive: true
            , interlaced: true
        })).pipe(gulp.dest(Config.img.dist));
    });
    /**
     * rev处理
     */
    gulp.task('rev', function () {
        return gulp.src(['rev/**/*.json', 'src/main/resources/templates/**/*.html'])
        .pipe(revCollector({
            replaceReved: true
        }))
        .pipe(gulp.dest(Config.dist_html));
    });
    //
    gulp.task('build', ['clean'], function(cb){
        runSequence(['html', 'css', 'libs', 'js', 'plus', 'images'], 'rev', cb);
    });
}
module.exports = prod;