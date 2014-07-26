// document ready function
$(document).ready(function() {

	$("form").on("submit", function(e) {
	    $(e.currentTarget).find("div.error").hide();
        e.preventDefault();
        var _data = $(e.currentTarget).serializeObject();

        $.ajax({
         type: e.currentTarget.method,
         url: e.currentTarget.action,
         data: JSON.stringify(_data),
         success: function(data) {
            if(data && data.status) {
                if(data.status == 200) {
                    window.location = $(e.currentTarget).data().uri;
                } else {
                    $(e.currentTarget).find("div.error p").html(data.message);
                    $(e.currentTarget).find("div.error").show();
                }
            }
         },
         error: function(xhr, textStatus, errorThrown) {
                var em = jQuery.parseJSON(xhr.responseText)
                $(e.currentTarget).find("div.error p").html(em.message);
                $(e.currentTarget).find("div.error").show();
         },
         dataType: "json",
         contentType: "application/json"
       });
	});

	$.fn.serializeObject = function(){
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

});