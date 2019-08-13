function matchpass() {
  var firstpassword = document.f1.password.value;
  var secondpassword = document.f1.password2.value;

  if (firstpassword == secondpassword) {
    return true;
  } else {
    alert("password must be same!");
    return false;
  }
}

$('[type="password"]').on("blur", e => {
  console.log(e.target.value);
  var frm = document.forms["registrationForm"];
  if (frm.userPwdOne.value != frm.userPwdTwo.value) {
    show_error_msg(
      "The Password and verified password does not match!",
      frm.formAssist
    );
    return false;
  } else {
    return true;
  }
});

const show_error_msg = (msg, elem) => {
  //   elem.style.visibility = "visible";
  elem.innerHtml = "<p>" + msg + "</p>";
  console.log("error :)");
};
