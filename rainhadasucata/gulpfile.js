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


// Default Task
gulp.task('default', function () {
    runSequence('watch');
});