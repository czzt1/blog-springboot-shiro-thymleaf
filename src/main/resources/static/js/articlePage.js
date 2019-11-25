$(document).ready(function () {
    $(".pageButton").click(pageNumClick);
    $(".next-page a").click(nextPageClick);
});

function pageNumClick(e) {
    e.preventDefault();
    const pageNum = parseInt($(this).text());
    $.ajax({
        url: "/comment/" + articleId + "/" + pageNum,
        type: "GET",
        success: function (result) {
            // console.log($(".commentlist").html());
            var commentList = $(".commentlist");
            commentList.html("");
            //填充评论dom
            for (let commentObj of result.commentList) {
                commentList.append("<li class=\"comment-content\"><span class=\"comment-f\">#1</span>\n" +
                    "                        <div class=\"comment-avatar\"><img alt=\"\" class=\"avatar\"  src=\"" + commentObj.userPic + "\" src=\"\"/>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"comment-main\">\n" +
                    "                            <p>来自<span class=\"address\">" + commentObj.author_area + "</span>的用户<span\n" +
                    "                                    class=\"time\">" + commentObj.comment_time + "</span><br/>\n" +
                    "                                <span>" + commentObj.content + "</span></p>\n" +
                    "                        </div>\n" +
                    "                    </li>");
            }
            //分页页码
            var lastActiveDom=$("#curActive");
            var lastPageNum=$("#curActive span").text();
            var curActiveDom=$(".pageNum"+pageNum);
            lastActiveDom.removeClass("active");
            lastActiveDom.removeAttr("id");
            lastActiveDom.addClass("pageNum"+lastPageNum);
            lastActiveDom.html("");
            //添加点击事件
            lastActiveDom.click(pageNumClick);
            lastActiveDom.append("<a class=\"pageButton\">"+lastPageNum+"</a>");
            curActiveDom.html("");
            curActiveDom.addClass("active");
            curActiveDom.attr("id","curActive");
            curActiveDom.append("<span>"+pageNum+"</span>");
            $(".prev-page").remove();
            if(pageNum!==1){
                setLastPageButton();
            }
            var pageTotalNumStr=$("#pageTotalSpan").text();
            var pageTotalNum=parseInt(pageTotalNumStr.substring(1,pageTotalNumStr.length-1));
            $(".next-page").show();
            if(pageNum===pageTotalNum){
                $(".next-page").hide();
            }
        }
    })
}

//下一页按钮事件
function nextPageClick(e){
    e.preventDefault();
    //获取页码
    var lastPageNum=parseInt($("#curActive span").text());
    var curPageNum=lastPageNum+1;
    $.ajax({
        url: "/comment/" + articleId + "/" + curPageNum,
        type: "GET",
        success: function (result) {
            // console.log($(".commentlist").html());
            var commentList = $(".commentlist");
            commentList.html("");
            //填充评论dom
            for (let commentObj of result.commentList) {
                commentList.append("<li class=\"comment-content\"><span class=\"comment-f\">#1</span>\n" +
                    "                        <div class=\"comment-avatar\"><img alt=\"\" class=\"avatar\"  src=\"" + commentObj.userPic + "\" src=\"\"/>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"comment-main\">\n" +
                    "                            <p>来自<span class=\"address\">" + commentObj.author_area + "</span>的用户<span\n" +
                    "                                    class=\"time\">" + commentObj.comment_time + "</span><br/>\n" +
                    "                                <span>" + commentObj.content + "</span></p>\n" +
                    "                        </div>\n" +
                    "                    </li>");
            }
            //分页页码
            var lastActiveDom=$("#curActive");
            var lastPageNum=$("#curActive span").text();
            var curActiveDom=$(".pageNum"+curPageNum);
            lastActiveDom.removeClass("active");
            lastActiveDom.removeAttr("id");
            lastActiveDom.addClass("pageNum"+lastPageNum);
            lastActiveDom.html("");
            //添加点击事件
            lastActiveDom.click(pageNumClick);
            lastActiveDom.append("<a class=\"pageButton\">"+lastPageNum+"</a>");
            curActiveDom.html("");
            curActiveDom.addClass("active");
            curActiveDom.attr("id","curActive");
            curActiveDom.append("<span>"+curPageNum+"</span>");
            $(".prev-page").remove();
            if(curPageNum!==1){
                setLastPageButton();
            }
            var pageTotalNumStr=$("#pageTotalSpan").text();
            var pageTotalNum=parseInt(pageTotalNumStr.substring(1,pageTotalNumStr.length-1));
            $(".next-page").show();
            if(curPageNum===pageTotalNum){
                $(".next-page").hide();
            }
        }
    })
}

function setLastPageButton(){
    $(this).text()
    $(".pagination ul").prepend("<li class=\"prev-page\">\n" +
        "                            <a>上一页</a>\n" +
        "                        </li>");
    //添加上一页事件
    $(".prev-page a").click(function (e) {
        e.preventDefault();
        //获取页码
        var lastPageNum=parseInt($("#curActive span").text());
        var curPageNum=lastPageNum-1;
        $.ajax({
            url: "/comment/" + articleId + "/" + curPageNum,
            type: "GET",
            success: function (result) {
                // console.log($(".commentlist").html());
                var commentList = $(".commentlist");
                commentList.html("");
                //填充评论dom
                for (let commentObj of result.commentList) {
                    commentList.append("<li class=\"comment-content\"><span class=\"comment-f\">#1</span>\n" +
                        "                        <div class=\"comment-avatar\"><img alt=\"\" class=\"avatar\"  src=\"" + commentObj.userPic + "\" src=\"\"/>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"comment-main\">\n" +
                        "                            <p>来自<span class=\"address\">" + commentObj.author_area + "</span>的用户<span\n" +
                        "                                    class=\"time\">" + commentObj.comment_time + "</span><br/>\n" +
                        "                                <span>" + commentObj.content + "</span></p>\n" +
                        "                        </div>\n" +
                        "                    </li>");
                }
                //分页页码
                var lastActiveDom=$("#curActive");
                var lastPageNum=$("#curActive span").text();
                var curActiveDom=$(".pageNum"+curPageNum);
                lastActiveDom.removeClass("active");
                lastActiveDom.removeAttr("id");
                lastActiveDom.addClass("pageNum"+lastPageNum);
                lastActiveDom.html("");
                //添加点击事件
                lastActiveDom.click(pageNumClick);
                lastActiveDom.append("<a class=\"pageButton\">"+lastPageNum+"</a>");
                curActiveDom.html("");
                curActiveDom.addClass("active");
                curActiveDom.attr("id","curActive");
                curActiveDom.append("<span>"+curPageNum+"</span>");
                if(curPageNum===1){
                    $(".prev-page").remove();
                }
                var pageTotalNumStr=$("#pageTotalSpan").text();
                var pageTotalNum=parseInt(pageTotalNumStr.substring(1,pageTotalNumStr.length-1));
                $(".next-page").show();
                if(curPageNum===pageTotalNum){
                    $(".next-page").hide();
                }
            }
        })
    });
}