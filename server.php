<?php
session_start();

$username = "";
$email="";
$errors = array();

//connecting to the database

$db = mysqli_connect('localhost','root','','User');
//register user

if (isset($_POST['reg_user'])) {

  # code...

  $name =mysqli_real_escape_string($db,$_POST['name']);
  $username = mysqli_real_escape_string($db,$_POST['username']);
  $email = mysqli_real_escape_string($db,$_POST['email']);
  $password_1 = mysqli_real_escape_string($db,$_POST['password_1']);
   $password_2 = mysqli_real_escape_string($db,$_POST['password_2']);

  //form validation ensure that the form is correctely filled

  if (empty($name)) {
    # code...
    array_push($errors, "Name is required");
  }

   if (empty($username)) {
    # code...
    array_push($errors, "Username is required");
  }
   if (empty($email)) {
    # code...
    array_push($errors, "Email is required");
  }
   if (empty($password_1)) {
    # code...
    array_push($errors, "Password is required");
  }
   if ($password_1 != $password_2) {
    # code...
    array_push($errors, "The two password do not match");
  }

  // first check in the database

  $user_check_query = "SELECT * FROM user_admin WHERE username='$username' OR email = '$email' LIMIT 1";
  $result = mysqli_query($db,$user_check_query);
  $user = mysqli_fetch_assoc($result);

  if ($user) {//if exists
     # code...
    if ($user['username'] ===  $username) {
      # code...
      array_push($errors, "Username already exists");
    }
    if ($user['email'] === $email ) {
      # code...
      array_push($errors, "email already exists");
    }
   }
   //Finally , register user if there are no errors

   if (count($errors) == 0) {
      # code...
    $password = md5($password_1);
    $query = "INSERT INTO user_admin (name,username,email,password) VALUES ('$name','$username','$email','$password')";
    mysqli_query($db,$query);

    $_SESSION['username'] = $username;
    $_SESSION['success'] = "You are now logged in ";
    header('location:login.php');
    } 

}


// LOGIN USER
if (isset($_POST['login_user'])) {
  $username = mysqli_real_escape_string($db, $_POST['username']);
  $password = mysqli_real_escape_string($db, $_POST['password']);

  if (empty($username)) {
    array_push($errors, "Username is required");
  }
  if (empty($password)) {
    array_push($errors, "Password is required");
  }

  if (count($errors) == 0) {
    $password = md5($password);
    $query = "SELECT * FROM user WHERE username='$username' AND password='$password'";
    $results = mysqli_query($db, $query);
    if(mysqli_num_rows($results) == 0) {
      $_SESSION['username'] = $username;
      $_SESSION['success'] = "You are now logged in";
      header('location: index.php');
    }else {
      array_push($errors, "Wrong username/password combination");
    }
  }
}
  ?>