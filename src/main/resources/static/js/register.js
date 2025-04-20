function askVerifyCode() {
    var email = $("input[name='email']").val();
    if (!email) {
        alert("请先输入邮箱地址！");
        return;
    }

    $.get("/api/auth/verify-code", {
        email: email
    }).done(function() {
        alert("验证码已发送！请查看您的邮箱，验证码3分钟内有效。");
        // 禁用按钮60秒，防止频繁点击
        var btn = $(".verify-btn a");
        var originalText = btn.text();
        btn.addClass("disabled").css("pointer-events", "none");
        var countdown = 60;
        var timer = setInterval(function() {
            btn.text(countdown + "秒后重试");
            countdown--;
            if (countdown < 0) {
                clearInterval(timer);
                btn.text(originalText).removeClass("disabled").css("pointer-events", "auto");
            }
        }, 1000);
    }).fail(function(xhr) {
        alert("发送失败：" + (xhr.responseText || "请检查邮箱格式是否正确"));
    });
}

// 表单提交前验证
$("form").submit(function(e) {
    var username = $("input[name='username']").val();
    var email = $("input[name='email']").val();
    var verifyCode = $("input[name='verifyCode']").val();
    var password = $("input[name='password']").val();

    if (!username || !email || !verifyCode || !password) {
        alert("请填写所有必填字段！");
        e.preventDefault();
        return false;
    }

    if (password.length < 6) {
        alert("密码长度不能少于6位！");
        e.preventDefault();
        return false;
    }

    return true;
});

// 页面加载时检查URL参数
$(document).ready(function() {
    var urlParams = new URLSearchParams(window.location.search);
    var errorMsg = urlParams.get('error');
    var successMsg = urlParams.get('success');
    if (errorMsg) {
        if(errorMsg==="UsernameExists")
        alert("用户名已存在请重新输入" );
        if(errorMsg==="CodeOutofTime")
            alert("验证码过期或输入错误");
        if(errorMsg==="EmailExists")
            alert("邮箱已存在请重新输入邮箱");
    }

    if (successMsg) {
        alert("成功: " + successMsg);
        // 成功消息显示后自动跳转到登录页面
        setTimeout(function() {
            window.location.href = "/login";
        }, 1500); // 1.5秒后跳转
    }
});