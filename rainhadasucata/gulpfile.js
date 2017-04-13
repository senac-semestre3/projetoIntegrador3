/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var gulp            = require('gulp');
var concat          = require('gulp-concat');
var concatVendor    = require('gulp-concat-vendor');
var uglify          = require('gulp-uglify');
var minify          = require('gulp-minify-css');
var mainBowerFiles  = require('main-bower-files');
var runSequence     = require('gulp-run-sequence');
var gzip            = require('gulp-gzip');
var clone           = require('gulp-clone');
var series          = require('stream-series');
var sass            = require('gulp-sass');
var watch           = require('gulp-watch');


//task para o sass
gulp.task('sass', function(){
	return gulp.src('src/main/webapp/resources/sass/**/*.scss')
	// para cumprimir o arquivo descomente a linha abaixo e comente a linha abaixo dessa
	//.pipe(sass({outputStyle: 'compressed'}).on('error', sass.logError))
	.pipe(sass())
	.pipe(gulp.dest('src/main/webapp/dist/css'));
});


// task para watch
gulp.task( 'watch', function() {
  gulp.watch('src/main/webapp/resources/sass/**/*.scss', ['sass']);
  
});

// task que verifica a pasta bower_components, pega todo js das lib, minifica e envia para o destino
gulp.task('lib-js-files', function () {
    return gulp.src(mainBowerFiles('**/*.js'),{ base: 'bower_components' })
        .pipe(concatVendor('lib.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest('src/main/webapp/dist/js'));
 
    vendorJs.pipe(clone())
        .pipe(gzip())
        .pipe(gulp.dest('src/main/webapp/dist/js'));
});

gulp.task('copyFonts', function() {
    gulp.src(mainBowerFiles('**/dist/fonts/*.{ttf,woff,woff2,eof,svg}'))
        .pipe(gulp.dest('src/main/webapp/dist/fonts'));
});

// Default Task
gulp.task('default', function () {
    runSequence('lib-js-files', 'copyFonts', 'watch');
});