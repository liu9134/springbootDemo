var SRC_DIR = 'src/main/resources/static_dev/';     // 静态源文件目录
var HTML_DIR = 'src/main/resources/templates_dev/';     // html源文件目录
var DIST_DIR = 'src/main/resources/static/';   // 文件处理后存放的目录
var DIST_HTML_DIR = 'src/main/resources/templates/';     // html处理后文件目录

var Config = {
    src: SRC_DIR,
    dist: DIST_DIR,
    dist_html: DIST_HTML_DIR,
    html: {
        src: HTML_DIR + '**/*.html',
        dist: DIST_HTML_DIR
    },  
    plus: {
        src: SRC_DIR + 'plus/**/*',            // plus目录：./src/plus
        dist: DIST_DIR + 'plus'                // plus文件build后存放的目录：./static/plus
    },  
    css: {  
        src: SRC_DIR + 'css/**/*.css',           // CSS目录：./src/css/
        dist: DIST_DIR + 'css'                   // CSS文件build后存放的目录：./static/css
    },
    libs: {  
        src: SRC_DIR + 'libs/*.js',              // JS目录：./src/libs/
        dist: DIST_DIR + 'libs',                 // JS文件build后存放的目录：./static/libs
        build_name: 'build-libs.js'                  // 合并后的js的文件名  
    },  
    js: {  
        src: SRC_DIR + 'js/**/*.js',             // JS目录：./src/js/
        dist: DIST_DIR + 'js',                   // JS文件build后存放的目录：./static/js
        build_name: 'build.js'                       // 合并后的js的文件名  
    },  
    img: {  
        src: SRC_DIR + 'images/**/*',            // images目录：./src/images/
        dist: DIST_DIR + 'images'                // images文件build后存放的目录：./static/images
    }  
};

module.exports = Config;