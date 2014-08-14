/**
 * Created by CoolGuy on 2014/8/13.
 */
jQuery.fn.extend({
    addNumberStyle:function(){
        var _this = $(this);
        var start = 0;
        var total = Number(_this.text());
        var timeId = setInterval(function(){
            if(start < total){
                _this.text(start);
                start += parseInt(total/20);
            }else{
                _this.text(total);
                clearInterval(timeId);
                _this.addClass("animated pulse");
            }
        },100);
    }
});
$(function(){
    $(".jumbotron").addClass("animated slideInDown");
    $("#count").addNumberStyle();
});

