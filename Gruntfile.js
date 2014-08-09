/**
 * Created with PhpStorm.
 * User: CoolGuy
 * Date: 14-8-8
 * Time: 下午4:44
 */
module.exports = function(grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        concat: {
            options: {
                // 定义一个用于插入合并输出文件之间的字符
                separator: ';'
            },
            dist: {
                // 将要被合并的文件
                src: ['js/**/*.js'],
                // 合并后的JS文件的存放位置
                dest: 'dist/<%= pkg.name %>.js'
            }
        },uglify: {
            options: {
                // 此处定义的banner注释将插入到输出文件的顶部
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n',
                mangle: {
                    except: ['jQuery']//好像没用。。。
                },
                report:"min"
            },
            dist: {
                files: [{
                    expand: true,
                    cwd:'js/',
                    src: '**/*.js',
                    dest: 'js_zip/'
                }]
            }
        },cssmin:{
            options:{
                report:'gzip'
            },
            task:{
                expand: true,
                cwd: 'css/',
                src: ['*.css', '!*.min.css'],
                dest: 'css_zip/'
            }
        },imagemin: {                          // Task
            dynamic: {                         // Another target
                files: [{
                    expand: true,                  // Enable dynamic expansion
                    cwd: 'images/',                   // Src matches are relative to this path
                    src: ['**/*.{png,jpg,gif}'],   // Actual patterns to match
                    dest: 'img_zip/'                  // Destination path prefix
                }]
            }
        },htmlmin: {                                     // Task
            dist: {                                      // Target
                options: {                                 // Target options
                    removeComments: true,
                    collapseWhitespace: true,
                    minifyJS:true
                },
                files:[{
                    expand: true,
                    cwd: 'templates/',
                    src: ['**/*.html'],   // Actual patterns to match
                    dest: 'templates_zip/'                  // Destination path prefix
                }]
//                files: {                                   // Dictionary of files
//                    't_dist/box.html': 'templates/box.html'
//                }
            }
        }
    });
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-imagemin');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-htmlmin');
// 只需在命令行上输入"grunt"，就会执行default task
    grunt.registerTask('default', ['uglify','cssmin','htmlmin']);
    grunt.registerTask('js','uglify');
    grunt.registerTask('img',['imagemin']);
    grunt.registerTask('html','htmlmin');
}
