function toggleFavorite(id, title, image, userId) {
    let recipe = {
        id: id,
        title: title,
        image: image
    };
    let isFav;
    $.ajax({
        url: ctx + "/api/v1/favorite/isFavorite",
        type: "GET",
        data: {recipeId: id, userId: userId},
        contentType: "application/json",
        success: function(response) {
            isFav = response;
            let button = $("#favorite-btn");
            $.ajax({
                url: ctx + "/api/v1/favorite/toggle",
                type: "POST",
                data: JSON.stringify({recipe: recipe, id: userId, isFavorite: isFav}),
                contentType: "application/json",
                success: function (response) {
                    let notification = $('<span class="alert alert-success">' + response + '</span>');
                    $('#notification-container').append(notification);
                    setTimeout(function() {
                        notification.remove();
                    }, 3000);
                },
                error: function () {
                    alert("Error");
                }
            });
            if (response) {
                button.text("Add to favorites");
            } else {
                button.text("Delete from favorites");
            }
        },
        error: function() {
            alert("Error");
        }
    });
}




