$(document).ready(function () {
    getUserAuthStatus();
    $("#loginForm").submit(function (e) {
        /*$.ajax({url:"/login",success:function(result){
                $("#div1").html(result);
            }});*/
        e.preventDefault();
        var loginModalUserNmae = $("#loginModalUserNmae").val();
        var loginModalUserPwd = $("#loginModalUserPwd").val();
        $.ajax({
            type: "POST",
            url: "/login",
            data: {
                "loginModalUserPwd": loginModalUserPwd,
                "loginModalUserNmae": loginModalUserNmae
            },
            error: function (result) {
                alert(result);
            },
            success: function (result) {
                if (result.retCode === '200') {
                    setUserCookie(result);
                    window.location.href = "/index";
                } else if (result.retCode === '500') {
                    alert(result.retMsg);
                }

            }
        });
    });
    /*注册ajax*/
    $("#registerForm").submit(function (e) {
        /*$.ajax({url:"/login",success:function(result){
                $("#div1").html(result);
            }});*/
        e.preventDefault();
        var registerModalUserNmae = $("#registerModalUserNmae").val();
        var registerModalNickName = $("#registerModalNickName").val();
        var registerModalUserPwd = $("#registerModalUserPwd").val();
        $.ajax({
            url: "/register",
            type: "POST",
            data: {
                "registerModalUserNmae": registerModalUserNmae,
                "registerModalNickName": registerModalNickName,
                "registerModalUserPwd": registerModalUserPwd
            },
            success: function (result) {
                alert(result.retMsg)
            }
        });
    });

    //注销按钮事件 通过事件委托，将子元素的事件绑定到父元素上，子元素被点击之后，事件会冒泡到父元素，由父元素负责捕捉然后触发事件。
    //防止ajxa加载的元素未能绑定事件
    $("#centre").on("click", "#logoutButton", function (e) {
        e.preventDefault();
        alert('23');

        Cookies.remove('rememberMe');
        Cookies.remove('JSESSIONID');
        Cookies.remove('username');
        window.location.href = "/logout";
        /*$.ajax({
            type: "POST",
            url: "/logout",
            data: {
                "registerModalUserNmae": '1'
            },
            error: function (result) {
                alert(result);
            },
            success: function (result) {
                if (result==='success'){
                    Cookies.remove('rememberMe');
                    Cookies.remove('JSESSIONID');
                    Cookies.remove('username');
                    window.location.reload();
                }
            }
        });*/
        /*Cookies.remove('rememberMe');
        Cookies.remove('JSESSIONID');
        Cookies.remove('username');
        window.location.href = "/index";*/

    });
});


function setUserInfo(result) {
    if (result.retCode === "200") {
        $("#usernameSpan").text("你好，" + result.data.username);
        $("#centre").html($("#loginedCentre").html());
        $("#loginModal").modal('hide');
        $("#header_login_tip").text("Hi," + result.data.username);
        $("#register_tip").hide();
        $("#find_pwd_tip").hide();
    } else {
        alert(result.retMsg);
    }
}

function setUserCookie(result) {
    Cookies.set('username', result.data.username);
}

function getUserAuthStatus() {
    var loginStatus = false;
    $.ajax({
        url: "/isLogined",
        success: function (result) {
            loginStatus = result;
            if (loginStatus) {
                const username = Cookies.get('username');
                $("#usernameSpan").text("你好，" + username);
                $("#centre").html($("#loginedCentre").html());
                $("#loginModal").modal('hide');
                $("#header_login_tip").text("Hi," + username);
                $("#register_tip").hide();
                $("#find_pwd_tip").hide();
            } else {
                Cookies.remove('rememberMe');
                Cookies.remove('JSESSIONID');
                Cookies.remove('username');
                //window.location.href = "/index";
            }
        }
    });
}


//判断字符是否为空的方法
function isEmpty(obj) {
    return typeof obj == "undefined" || obj == null || obj === "";
}