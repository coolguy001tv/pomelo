/**
 * Created with PhpStorm.
 * User: CoolGuy
 * Date: 14-8-8
 * Time: 下午3:48
 * 依赖于jQuery库
 */


(function($){
    //tile类的高度和宽度保持一致,使用方法
    //<span class="tile" data-width="360" data-bg="red"></span>
    $('.tile').height(function(){
        var _this = $(this);
        var width = _this.attr('data-width')||_this.width();
        _this.width(width);
        _this.attr('data-bg')&&_this.css('background',_this.attr('data-bg'));
        return width;
    });
})(jQuery);




