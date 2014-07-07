$(document).ready(function() {
    // form validation function
    $("form").validate({
         rules: {
             email: {
                required: true,
                minlength: 4
            },
            password: {
                required: true,
                minlength: 6
            }
         },
         messages: {
            email: {
                required: "Please enter email address",
                minlength: "Too short!"
            },
            password: {
                required: "Please provide a password",
                minlength: "Password should be more than 6 characters"
            }
         }
    });

    // form submit function
    $("form").on("submit", function(e) {
        console.log("INSIDE");
        e.preventDefault();
            if($(e.currentTarget).valid()) {
                console.log("INSIDE 2");
                $.post(e.currentTarget.action, $(e.currentTarget).serialize())
                .success(function(data) {
                    if(data.error) {
                        $(e.currentTarget).find("p.error").html(data.error.description);
                    } else {
                        window.location = '/';
                    }
            });
        }
    });
});