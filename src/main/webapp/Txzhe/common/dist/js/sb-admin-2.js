$(function() {
	var menu = '';
	for (var i = 0,len=treeArr.length; i < len; i++) {
		var obj = JSON.parse(treeArr[i]);
		if(obj.sort == 0){
			$('#side-menu').append('<li id="first_'+obj.id+'"> <a href="javascript:void(0)"><i class="'+obj.icon+'"></i> '+obj.name+'<span class="fa arrow"></span></a></li>');
		}else if(obj.sort == 1){
			var secondObj = '<ul class="nav nav-second-level"><li id=first_second_'+obj.id+'> <a class="menuc" href="javascript:void(0)"> <i class="'+obj.icon+'"></i> '+obj.name+'<span class="fa arrow"></span></a> </li></ul>';
			$("#first_"+obj.parentId).append(secondObj);
		}else if(obj.sort == 2){
			var thirdObj = '<ul class="nav nav-third-level"><li> <a class="menuc" url="${basePath}/SysTracker?'+obj.url+'" href="javascript:void(0)"> <i class="'+obj.icon+'"></i> '+obj.name+'</a> </li></ul>';
			$("#first_second_"+obj.parentId).append(thirdObj);
		}
	}
    $('#side-menu').metisMenu({toggle:false});
});

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function() {
    $(window).bind("load resize", function() {
        topOffset = 50;
        width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div.navbar-collapse').removeClass('collapse');
        }

        height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    });

    var url = window.location;
    var element = $('ul.nav a').filter(function() {
        return this.href == url || url.href.indexOf(this.href) == 0;
    }).addClass('active').parent().parent().addClass('in').parent();
    if (element.is('li')) {
        element.addClass('active');
    }
});
