function askVerifyCode(){
    $.get("api/auth/verify-code",{
        email: $("#input-email").val()
    }).done(function(response) {
        window.alert("验证码已发送，请检查邮箱！");
    }).fail(function(xhr) {
        window.alert("发送失败：" + xhr.responseText);
    });
}