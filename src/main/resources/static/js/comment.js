$(document).ready(function () {
    $("#comment-submit").click(function (e) {
        e.preventDefault();
        alert("chufa");
        const commentText = $("#comment-textarea").val();
        $.ajax({
            type: "POST",
            url: "/comment",
            data: {
                "content": commentText,
              //  "commentUserId": comment
            },
            error: function (result) {
                alert(result);
            },
            success: function (result) {
                if (result.retCode==='200'){
                    alert("S");
                }else if(result.retCode==='500'){
                    alert("F");
                }

            }
        })
    });
});