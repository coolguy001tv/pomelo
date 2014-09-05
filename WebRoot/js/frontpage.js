/**
 * Created by CoolGuy on 2014/8/13.
 */
jQuery.fn.extend({
    addNumberStyle:function(){
    	var TOTALTIME = 20;
        var _this = $(this);
        var start = 0;
        var total = Number(_this.text());
        if (total < TOTALTIME) {
        	return;
        }
        var timeId = setInterval(function(){
            if(start < total){
                _this.text(start);
                start += parseInt(total/TOTALTIME);
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
    //高度适应
    //$('.jumbotron').height($('.jumbotron').width());
});

