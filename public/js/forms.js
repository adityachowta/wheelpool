// document ready function
$(document).ready(function() { 	


	//------------- Masked input fields -------------//
	//$("#mask-phone").mask("(999) 999-9999", {completed:function(){alert("Callback action after complete");}});
	//$("#mask-phoneExt").mask("(999) 999-9999? x99999");
	/*$("input.phone").mask("09999999999");
	$("input.date").mask("99/99/9999");
	$("input.date").datepicker();
	$("input.datetime").datetimepicker();*/


	$("form").on("submit", function(e) {
	    console.log("INSIDE");
	    $(e.currentTarget).find("div.error").hide();
        e.preventDefault();
        var _data = $(e.currentTarget).serializeObject();
        if($(e.currentTarget).find("div.permissions").length > 0) {
           var _perm = [];
           var _moduleTypes = $(e.currentTarget).find("div.permissions input[type=hidden]").serializeObject().moduleType;
           if(_moduleTypes) {
                $.each(_moduleTypes, function(index, value) {
                    _perm.push($(e.currentTarget).find("div.permissions div." + value + " input").serializeObject());
                });
           }
          if(_perm.length > 0) {
               _data["clientModulePermissionRequests"] = _perm;
          }
        }

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

//	$("form span.permissions button").live("click", function(e) {
//
//	    $(e.currentTarget).parent().after($(e.currentTarget).parent().parent().parent().clone());
//	})


});