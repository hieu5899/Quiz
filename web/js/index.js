/* 
 Document   : Countdown Timing
 Author     : Hieu Mau
 */
function currentTime(x) {
    var t = setInterval(function () {
        var currentTime = new Date().getTime();
        distance = x - currentTime;
        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);
        var hour = updateTime(hours);
        var min = updateTime(minutes);
        var sec = updateTime(seconds);

        document.getElementById("clock").innerHTML = hour + ":" + min + ":" + sec;
        if (distance > 0) {
            document.getElementById("logout").disabled = true;
            document.getElementById("takeQuiz").disabled = true;
            document.getElementById("makeQuiz").disabled = true;
            document.getElementById("home").disabled = true;
        } else {
            clearInterval(t);
            window.location.href = "timeout";
        }
    }, 1000);
}
//format time number
function updateTime(k) {
    if (k < 10) {
        return "0" + k;
    } else {
        return k;
    }
}
//Check log in 
function validateLogin() {
    var username = document.getElementsByName("username")[0];
    var password = document.getElementsByName("password")[0];
    var message = document.getElementById("message");
    if (username.value === "") {
        message.innerHTML = "Username can't be null";
        return false;
    }
    if (password.value === "") {
        message.innerHTML = "Password can't be null";
        return false;
    }
    return true;
}
//Check number of quiz
function validateTakeQuizNumber() {
    var number = document.getElementsByName("number")[0];
    var message = document.getElementById("message");
    if (number.value === "") {
        message.innerHTML = "Enter a number please.";
        return false;
    }
    return true;
}
//Check making quiz
function validateMakeQuiz() {
    console.log("MakeQuiz Validate");
    var question = document.getElementsByName("question")[0];
    var option = document.getElementsByName("option");

    var message = document.getElementById("message");
    if (question.value === "") {
        message.innerHTML = "Question can not null.";
        return false;
    }
    if (option.values.length === 0) {
        message.innerHTML = "Option can not null.";
        return false;
    }
    return true;
}

